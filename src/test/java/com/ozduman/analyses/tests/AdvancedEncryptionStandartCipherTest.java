package com.ozduman.analyses.tests;

import org.junit.Assert;
import org.junit.Test;

import com.ozduman.analyses.AdvancedEncryptionStandardCipher;
import com.ozduman.analyses.tests.interfaces.CipherTest;

/**
 *  Tests for AES.
 * 
 * @author haluk
 * 
 *
 */
public class AdvancedEncryptionStandartCipherTest implements CipherTest {
	
	AdvancedEncryptionStandardCipher advancedEncryptionStandardCipher = new AdvancedEncryptionStandardCipher();

	@Test
	public void testGetEncryptedText() {
		Assert.assertEquals("pgIRcZeJzibQz42+A/1xfw==", advancedEncryptionStandardCipher.encryptTheText("", ""));
		Assert.assertEquals("w5S9gUXnBO7YjX+cJ0fpuA==", advancedEncryptionStandardCipher.encryptTheText("haluk", "secret"));
		Assert.assertEquals("kN1EXCgVJyexwNkrqZlnrAaBZip1GHN5AUMQLcrCJ4gJhHXpY8GqVTvqmEMi0QSZ6ai7Fl9w1f6EhSAOd22RMw==", advancedEncryptionStandardCipher.encryptTheText("Haluk implemented advanced encryption standart cipher.", "this is a key"));
	}

	@Test
	public void testGetDecryptedText() {
		Assert.assertEquals("", advancedEncryptionStandardCipher.decryptTheText("pgIRcZeJzibQz42+A/1xfw==", ""));
		Assert.assertEquals("haluk", advancedEncryptionStandardCipher.decryptTheText("w5S9gUXnBO7YjX+cJ0fpuA==", "secret"));
		Assert.assertEquals("Haluk implemented advanced encryption standart cipher.", advancedEncryptionStandardCipher.decryptTheText("kN1EXCgVJyexwNkrqZlnrAaBZip1GHN5AUMQLcrCJ4gJhHXpY8GqVTvqmEMi0QSZ6ai7Fl9w1f6EhSAOd22RMw==", "this is a key"));
	}
}
