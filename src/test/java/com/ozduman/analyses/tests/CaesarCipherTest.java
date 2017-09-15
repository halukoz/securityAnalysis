package com.ozduman.analyses.tests;

import org.junit.Assert;
import org.junit.Test;

import com.ozduman.analyses.CaesarCipher;
import com.ozduman.analyses.tests.interfaces.CipherTest;

/**
 * Tests for Caesar Cipher.
 * 
 * @author haluk
 * 
 *
 *
 */
public class CaesarCipherTest implements CipherTest {

	// These asserts test the caesar cipher with corner cases.
	CaesarCipher caesarCipher = new CaesarCipher();
	@Test
	public void testGetEncryptedText() {
		Assert.assertEquals("test", caesarCipher.getEncryptedText("test", 0));
		Assert.assertEquals("b", caesarCipher.getEncryptedText("a", 1));
		Assert.assertEquals("z", caesarCipher.getEncryptedText("a", -1));
		Assert.assertEquals("vguv", caesarCipher.getEncryptedText("test", 2));
		Assert.assertEquals("haluk implemented caesar cipher", caesarCipher.getEncryptedText("haluk implemented caesar cipher", 0));
		Assert.assertEquals("kdoxn lpsohphqwhg fdhvdu flskhu", caesarCipher.getEncryptedText("haluk implemented caesar cipher", 3));
		Assert.assertEquals("haluk implemented caesar cipher", caesarCipher.getEncryptedText("haluk implemented caesar cipher", 26));
	}
	
	@Test
	public void testGetDecryptedText() {
		Assert.assertEquals("test", caesarCipher.getDecryptedText("test", 0));
		Assert.assertEquals("a", caesarCipher.getDecryptedText("b", 1));
		Assert.assertEquals("a", caesarCipher.getDecryptedText("z", -1));
		Assert.assertEquals("test", caesarCipher.getDecryptedText("vguv", 2));
		Assert.assertEquals("haluk implemented caesar cipher", caesarCipher.getDecryptedText("haluk implemented caesar cipher", 0));
		Assert.assertEquals("haluk implemented caesar cipher", caesarCipher.getDecryptedText("kdoxn lpsohphqwhg fdhvdu flskhu", 3));
		Assert.assertEquals("haluk implemented caesar cipher", caesarCipher.getDecryptedText("haluk implemented caesar cipher", 26));
	}
}
