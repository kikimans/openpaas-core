/**
 * 
 */
package kr.cloudsc.openpaas.cipher;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
/**
 * <pre>
 * kr.cloudsc.openpaas.cipher
 * AESCipher.java
 * </pre>
 *
 * @author  : kikimans
 * @Date    : 2014. 8. 12.
 * @Version : 
 */
public class AESCipher implements IAESCipher{

	/**
	 * 
	 */
	
	
	private Cipher cipher;
    private Base64 base64;
    private int passwordLength;
    private int saltLength;
    private int initializationVectorSeedLength;

    public AESCipher()
            throws NoSuchAlgorithmException, NoSuchPaddingException {
        this(new Base64(), 16, 16, 16);
    }
    
    public AESCipher(Base64 base64, int passwordLength, int saltLength, int initializationVectorSeedLength)
            throws NoSuchAlgorithmException, NoSuchPaddingException {

        try {
            this.base64 = base64;
            this.passwordLength = passwordLength;
            this.saltLength = saltLength;
            this.initializationVectorSeedLength = initializationVectorSeedLength;
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw noSuchAlgorithmException;
        } catch (NoSuchPaddingException noSuchPaddingException) {
            throw noSuchPaddingException;
        }
    }
    
    private SecretKey secretKey;

    public SecretKey getSecretKey() {
        return secretKey;
    }
    
    public String getEncodedSecretKey(SecretKey secretKey) {
        return base64.encodeToString(secretKey.getEncoded());
    }

    public SecretKey getDecodedSecretKey(String secretKey) {
        return new SecretKeySpec(base64.decode(secretKey), "AES");
    }   
    
    public String encrypt(String rawText, SecretKey secretKey1) throws InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{
    	SecureRandom secureRandom = new SecureRandom();
        byte[] seed = secureRandom.generateSeed(initializationVectorSeedLength);
        AlgorithmParameterSpec algorithmParameterSpec = new IvParameterSpec(seed);

        this.secretKey = secretKey1;
        
        cipher.init(Cipher.ENCRYPT_MODE, secretKey1, algorithmParameterSpec);
        byte[] encryptedMessageBytes = cipher.doFinal(rawText.getBytes());

        byte[] bytesToEncode = new byte[seed.length + encryptedMessageBytes.length];
        System.arraycopy(seed, 0, bytesToEncode, 0, seed.length);
        System.arraycopy(encryptedMessageBytes, 0, bytesToEncode, seed.length, encryptedMessageBytes.length);

        return base64.encodeToString(bytesToEncode);
    }
    
    protected String encrypt(String rawText, int hashIterations, KeyLength keyLength, String secretKeyString)
            throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {

        
        SecureRandom secureRandom = new SecureRandom();
        byte[] seed = secureRandom.generateSeed(initializationVectorSeedLength);
        AlgorithmParameterSpec algorithmParameterSpec = new IvParameterSpec(seed);

        setSecretKeySpec(secretKeyString, hashIterations, keyLength);

        cipher.init(Cipher.ENCRYPT_MODE, secretKey, algorithmParameterSpec);
        byte[] encryptedMessageBytes = cipher.doFinal(rawText.getBytes());

        byte[] bytesToEncode = new byte[seed.length + encryptedMessageBytes.length];
        System.arraycopy(seed, 0, bytesToEncode, 0, seed.length);
        System.arraycopy(encryptedMessageBytes, 0, bytesToEncode, seed.length, encryptedMessageBytes.length);

        return base64.encodeToString(bytesToEncode);
    }
    
    protected String decrypt(String encryptedText, String secretKeyString, int hashIterations, KeyLength keyLength)
            throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, InvalidKeySpecException {      
        
        setSecretKeySpec(secretKeyString, hashIterations, keyLength);
        return decrypt(encryptedText, this.getDecodedSecretKey(this.getEncodedSecretKey(secretKey)));
    }

    public String decrypt(String encryptedText, SecretKey secretKey1)
            throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {

        byte[] bytesToDecode = base64.decode(encryptedText);

        byte[] emptySeed = new byte[initializationVectorSeedLength];
        System.arraycopy(bytesToDecode, 0, emptySeed, 0, initializationVectorSeedLength);

        cipher.init(Cipher.DECRYPT_MODE, secretKey1, new IvParameterSpec(emptySeed));

        int messageDecryptedBytesLength = bytesToDecode.length - initializationVectorSeedLength;
        byte[] messageDecryptedBytes = new byte[messageDecryptedBytesLength];
        System.arraycopy(bytesToDecode, initializationVectorSeedLength, messageDecryptedBytes, 0, messageDecryptedBytesLength);

        return new String(cipher.doFinal(messageDecryptedBytes));
    }

    public enum KeyLength {

        ONE_TWENTY_EIGHT(128),
        ONE_NINETY_TWO(192),
        TWO_FIFTY_SIX(256);
        
        private int bits;

        KeyLength(int bits) {
            this.bits = bits;
        }

        public int getBits() {
            return bits;
        }
    }
    
    protected char[] getRandomPassword() {
        
        char[] randomPassword = new char[passwordLength];
        
        Random random = new Random();
        for(int i = 0; i < passwordLength; i++) {
            randomPassword[i] = (char)(random.nextInt('~' - '!' + 1) + '!');
        }
       
        return randomPassword;
    }
    
    public String getSecretKeyIssue() throws NoSuchAlgorithmException, InvalidKeySpecException{
    	char[] randomPassword = getRandomPassword();   
    	String strPassword = new String(randomPassword);
    	
    	return getEncodedSecretKey(createSecreKeySpec(strPassword));
    }
    
    private void setSecretKeySpec(String secretKeyStr, int hashIterations, KeyLength keyLength) throws NoSuchAlgorithmException, InvalidKeySpecException{
    	
    	SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        SecureRandom secureRandom = new SecureRandom();
    	
    	KeySpec keySpec = new PBEKeySpec(secretKeyStr.toCharArray(), secureRandom.generateSeed(saltLength), hashIterations, keyLength.getBits());
        secretKey = new SecretKeySpec(secretKeyFactory.generateSecret(keySpec).getEncoded(), "AES");
        
    }
    
    private SecretKey createSecreKeySpec(String secretKeyStr) throws NoSuchAlgorithmException, InvalidKeySpecException{
    	SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        SecureRandom secureRandom = new SecureRandom();
    	
    	KeySpec keySpec = new PBEKeySpec(secretKeyStr.toCharArray(), secureRandom.generateSeed(saltLength), 1000, KeyLength.ONE_TWENTY_EIGHT.getBits());
        return new SecretKeySpec(secretKeyFactory.generateSecret(keySpec).getEncoded(), "AES");
    }

}
