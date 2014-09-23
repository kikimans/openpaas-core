package kr.cloudsc.openpaas.cipher;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import org.apache.commons.codec.binary.Base64;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
public class CipherTest {

	static final Logger logger = LoggerFactory.getLogger(CipherTest.class);
	
	private AESCipher cipher;
	
	@Before
	public void setUp() throws Exception {
		cipher = new AESCipher();
	}

	@Test
	public void test_인증키발급() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException {
		
		String secretKey = cipher.getSecretKeyIssue();
		System.out.println(secretKey);
		logger.info("암호화 키 : " + secretKey);
	}
	
	
	@Test
	public void test_비밀번호_암호화() throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, InvalidKeySpecException{
		String originKey = "46sZHabuHBoOIQkqyVowIA==";
		String passwd = "alsgh@1716";
		
		String encrypted = cipher.encrypt(passwd, cipher.getDecodedSecretKey(originKey));
				
		System.out.println(cipher.getEncodedSecretKey(cipher.getSecretKey()));
		logger.info("암호화 비밀번호 : " + encrypted);
		logger.info("암호화 SecretKey : " + cipher.getEncodedSecretKey(cipher.getSecretKey()));
	}
	
	@Test
	public void test_암호화_풀기() throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException{
		String passwd = "alsgh@1716";
		String encrypted = cipher.decrypt("KRjM58F06DL1Oq2gFdUhjDX9ZbzLxPIF7ZIAy/P6w74=", cipher.getDecodedSecretKey("46sZHabuHBoOIQkqyVowIA=="));
		assertThat(encrypted, is(passwd));
	}
	
	

}
