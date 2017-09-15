package com.ozduman.interfaces;

/**
 * @author ozduman
 *
 * Interfaces for different cipher techniques.
 *
 * @param <T>
 */
public interface CryptoCipher<T> {
	
	/**
	 * @param plainText
	 * @param cipherCriteria
	 * @return
	 */
	public String getEncryptedText(String plainText, T cipherCriteria);
	
	/**
	 * @param encryptedText
	 * @param cipherCriteria
	 * @return
	 */
	public String getDecryptedText(String encryptedText, T cipherCriteria);

}
