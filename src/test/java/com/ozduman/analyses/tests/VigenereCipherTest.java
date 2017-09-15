package com.ozduman.analyses.tests;

import org.junit.Assert;
import org.junit.Test;

import com.ozduman.analyses.VigenereCipher;
import com.ozduman.analyses.tests.interfaces.CipherTest;

/**
 * 
 * Tests for Vigenere Cipher
 * 
 * @author haluk
 *
 */
public class VigenereCipherTest implements CipherTest{
	
	VigenereCipher vigenereCipher = new VigenereCipher();
	
	@Test
	public void testGetEncryptedText() {
		Assert.assertEquals("", vigenereCipher.getEncryptedText("", ""));
		Assert.assertEquals("", vigenereCipher.getEncryptedText("haluk", ""));
		Assert.assertEquals("haluk", vigenereCipher.getEncryptedText("haluk", "a"));
		Assert.assertEquals("haluk", vigenereCipher.getEncryptedText("haluk", "aaaaa"));
		Assert.assertEquals("haluk", vigenereCipher.getEncryptedText("haluk", "aaaaaa"));
		Assert.assertEquals("oawou", vigenereCipher.getEncryptedText("haluk", "haluk"));
		Assert.assertEquals("aedndmeieiexgxwwomyxgijxvmhaxv", vigenereCipher.getEncryptedText("haluk implemented vigenere cipher", "test"));
	}

	@Test
	public void testGetDecryptedText() {
		Assert.assertEquals("", vigenereCipher.getDecryptedText("", ""));
		Assert.assertEquals("", vigenereCipher.getDecryptedText("haluk", ""));
		Assert.assertEquals("haluk", vigenereCipher.getDecryptedText("haluk", "a"));
		Assert.assertEquals("haluk", vigenereCipher.getDecryptedText("haluk", "aaaaa"));
		Assert.assertEquals("haluk", vigenereCipher.getDecryptedText("haluk", "aaaaaa"));
		Assert.assertEquals("haluk", vigenereCipher.getDecryptedText("oawou", "haluk"));
		Assert.assertEquals("halukimplementedvigenerecipher", vigenereCipher.getDecryptedText("aedndmeieiexgxwwomyxgijxvmhaxv", "test"));
	}
}
