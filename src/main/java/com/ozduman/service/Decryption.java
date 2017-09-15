package com.ozduman.service;

import com.ozduman.analyses.AdvancedEncryptionStandardCipher;
import com.ozduman.analyses.CaesarCipher;
import com.ozduman.analyses.DataEncryptionStandartCipher;
import com.ozduman.analyses.OneTimePadding;
import com.ozduman.analyses.VigenereCipher;

/**
 * @author ozduman
 * 
 * Contains decryption functions of different cipher techniques.
 */
public class Decryption {

	/**
	 * 
	 */
	private CaesarCipher caesarCipher = new CaesarCipher();
	/**
	 * 
	 */
	private VigenereCipher vigenereCipher = new VigenereCipher();
	/**
	 * 
	 */
	private OneTimePadding oneTimePadding = new OneTimePadding();
	/**
	 * 
	 */
	private DataEncryptionStandartCipher dataEncryptionStandartCipher = new DataEncryptionStandartCipher();
    /**
     * 
     */
    private AdvancedEncryptionStandardCipher advancedEncryptionStandardCipher = new AdvancedEncryptionStandardCipher();
	
	/**
	 * @param cipherText
	 * @param shiftSize
	 * @return
	 */
	public String decryptWithCaesarCipher(String cipherText, Integer shiftSize) {

		return caesarCipher.getDecryptedText(cipherText, shiftSize);
	}

	/**
	 * @param cipherText
	 * @param key
	 * @return
	 */
	public String decryptWithVigenereCipher(String cipherText, String key) {

		return vigenereCipher.getDecryptedText(cipherText, key);
	}

	/**
	 * @param cipherText
	 * @param key
	 * @return
	 */
	public String decryptWithOneTimePadding(String cipherText, String key) {

		return oneTimePadding.getDecryptedText(cipherText, key);
	}
	
	/**
	 * @param cipherText
	 * @return
	 */
	public String decryptWithDataEncryptionStandartCipher(String cipherText) {
		
		return dataEncryptionStandartCipher.getDecryptedText(cipherText, "no-criteria");
	}
	
	/**
	 * @param cipherText
	 * @param key
	 * @return
	 */
	public String decryptWithAdvancedEncryptionStandardCipher(String cipherText, String key) {
		
		return advancedEncryptionStandardCipher.getDecryptedText(cipherText, key);
	}
}
