package com.ozduman.resource.tests;

import org.junit.Assert;
import org.junit.Test;

import com.ozduman.resource.CryptoResource;

/**
 * Tests for encryption and decryption resources.
 * 
 * @author haluk
 *
 */
public class CryptoResourceTest {

	CryptoResource cryptoResource = new CryptoResource();

	@Test
	public void getEncrpytedResources() {
		Assert.assertEquals("b", cryptoResource.encryptTextWithCaesarCipher("a", "1"));
		Assert.assertEquals("w5S9gUXnBO7YjX+cJ0fpuA==",cryptoResource.encryptTextWithAes("haluk", "secret"));
		Assert.assertEquals("aednk", cryptoResource.encryptTextWithOneTimePadding("haluk", "test"));
		Assert.assertEquals("oawou", cryptoResource.encryptTextWithVigenereCipher("haluk", "haluk"));
	}
	
	@Test
	public void getDecryptedResources() {
		Assert.assertEquals("a", cryptoResource.decryptTextWithCaesarCipher("b", "1"));
		Assert.assertEquals("haluk", cryptoResource.decryptTextWithAes("w5S9gUXnBO7YjX+cJ0fpuA==", "secret"));
		Assert.assertEquals("haluk", cryptoResource.decryptTextWithOneTimePadding("aednk", "test"));
		Assert.assertEquals("haluk", cryptoResource.decryptTextWithVigenereCipher("oawou", "haluk"));
	}
}
