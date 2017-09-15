package com.ozduman.service;

import com.ozduman.analyses.AdvancedEncryptionStandardCipher;
import com.ozduman.analyses.CaesarCipher;
import com.ozduman.analyses.DataEncryptionStandartCipher;
import com.ozduman.analyses.OneTimePadding;
import com.ozduman.analyses.VigenereCipher;

/**
 * @author ozduman
 *
 * Contains encryption functions of different cipher techniques.
 */
public class Encryption {

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
	 * @param plainText
	 * @param shiftSize
	 * @return
	 */
	public String encryptWithCaesarCipher(String plainText, Integer shiftSize) {

		return caesarCipher.getEncryptedText(plainText, shiftSize);
	}

	/**
	 * @param plainText
	 * @param key
	 * @return
	 */
	public String encryptWithVigenereCipher(String plainText, String key) {

		return vigenereCipher.getEncryptedText(plainText, key);
	}

	/**
	 * @param plainText
	 * @param key
	 * @return
	 */
	public String encryptWithOneTimePadding(String plainText, String key) {

		return oneTimePadding.getEncryptedText(plainText, key);
	}
	
	/**
	 * @param plainText
	 * @return
	 */
	public String encrypWithDataEncryptionStandartCipher(String plainText) {
		
		return dataEncryptionStandartCipher.getEncryptedText(plainText, "no-criteria");
	}
	
    /**
     * @param plainText
     * @param key
     * @return
     */
    public String encryptWithAdvancedEncryptionStandardCipher(String plainText, String key) {
		
		return advancedEncryptionStandardCipher.getEncryptedText(plainText, key);
	}
}
