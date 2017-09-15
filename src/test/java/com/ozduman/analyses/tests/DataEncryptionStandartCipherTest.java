package com.ozduman.analyses.tests;

import org.junit.Assert;
import org.junit.Test;

import com.ozduman.analyses.DataEncryptionStandartCipher;
import com.ozduman.analyses.tests.interfaces.CipherTest;

/**
 * 
 * Tests for DES.
 * 
 * @author haluk
 *
 */
public class DataEncryptionStandartCipherTest implements CipherTest{

	DataEncryptionStandartCipher dataEncryptionStandartCipher = new DataEncryptionStandartCipher();

	@Test
	public void testGetEncryptedText() {
		Assert.assertEquals("test", dataEncryptionStandartCipher.getDecryptedText(dataEncryptionStandartCipher.getEncyptedTextAsBytes("test", "no-criteria"), "no-criteria"));
		Assert.assertEquals("", dataEncryptionStandartCipher.getDecryptedText(dataEncryptionStandartCipher.getEncyptedTextAsBytes("", "no-criteria"), "no-criteria"));
		Assert.assertEquals("haluk88", dataEncryptionStandartCipher.getDecryptedText(dataEncryptionStandartCipher.getEncyptedTextAsBytes("haluk88", "no-criteria"), "no-criteria"));
		Assert.assertEquals("Haluk implemented DES.", dataEncryptionStandartCipher.getDecryptedText(dataEncryptionStandartCipher.getEncyptedTextAsBytes("Haluk implemented DES.", "no-criteria"), "no-criteria"));
	}

	@Test
	public void testGetDecryptedText() {
		Assert.assertEquals("testdecryption", dataEncryptionStandartCipher.getDecryptedText(dataEncryptionStandartCipher.getEncyptedTextAsBytes("testdecryption", "no-criteria"), "no-criteria"));
		Assert.assertEquals("", dataEncryptionStandartCipher.getDecryptedText(dataEncryptionStandartCipher.getEncyptedTextAsBytes("", "no-criteria"), "no-criteria"));
		Assert.assertEquals("haluk88decryption", dataEncryptionStandartCipher.getDecryptedText(dataEncryptionStandartCipher.getEncyptedTextAsBytes("haluk88decryption", "no-criteria"), "no-criteria"));
		Assert.assertEquals("Haluk implemented DES.", dataEncryptionStandartCipher.getDecryptedText(dataEncryptionStandartCipher.getEncyptedTextAsBytes("Haluk implemented DES.", "no-criteria"), "no-criteria"));
	}
}
