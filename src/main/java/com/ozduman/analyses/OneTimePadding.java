package com.ozduman.analyses;

import java.util.Random;

import com.ozduman.interfaces.CryptoCipher;

/**
 * 
 * This class finds encrypted or decrpyted messages with one time padding technique.
 *
 * @author ozduman
 * 
 */
public class OneTimePadding implements CryptoCipher<String> {
	
	/**
	 * Use vigenere cipher, because the logic of one time padding is similar with vigenere cipher.
	 */
	private VigenereCipher vigenereCipher = new VigenereCipher();
	/**
	 * Use only small letter of english alphabet. 
	 */
	private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyz";

	/**
	 * Generate random strings for auto generated key functionality.
	 * 
	 * (Note: auto generation has not been implemented yet) 
	 * 
	 * @param randomStringLength
	 * @return
	 */
	private String generateRandomString(int randomStringLength){

		StringBuffer randStr = new StringBuffer();
		for(int i=0; i<randomStringLength; i++){
			int number = getRandomNumber();
			char ch = CHAR_LIST.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString();
	}
	/**
	 * @return random numbers
	 */
	private int getRandomNumber() {
		
		int randomInt = 0;
		Random randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(CHAR_LIST.length());
		if (randomInt - 1 == -1) {
			return randomInt;
		} else {
			return randomInt - 1;
		}
	}
	
	/**
	 * @param plainText  user input, which come from UI.
	 * @param cipherCriteria  cipherCriteria is a key or a second text to encrypt the plain text.
	 * @return
	 */
	private String findEncryptedPadding(String plainText, String cipherCriteria) {
		
		String encryptedMessage;
		if(cipherCriteria.length() <= plainText.length()) {
			encryptedMessage = vigenereCipher.getEncryptedText(plainText.substring(0, cipherCriteria.length()), cipherCriteria) + plainText.substring(cipherCriteria.length());
		} else {
			encryptedMessage = vigenereCipher.getEncryptedText(plainText, cipherCriteria);
		}
		return encryptedMessage;
	}
	
	/**
	 * @param encryptedText
	 * @param cipherCriteria
	 * @return
	 */
	private String findDecryptedPadding(String encryptedText, String cipherCriteria) {
		
		String decryptedMessage;
		if(cipherCriteria.length() <= encryptedText.length()) {
			decryptedMessage = vigenereCipher.getDecryptedText(encryptedText.substring(0, cipherCriteria.length()), cipherCriteria) + encryptedText.substring(cipherCriteria.length());
		} else {
			decryptedMessage = vigenereCipher.getDecryptedText(encryptedText, cipherCriteria);
		}
		return decryptedMessage;
	}
	
	/* (non-Javadoc)
	 * @see com.ozduman.interfaces.CryptoCipher#getEncryptedText(java.lang.String, java.lang.Object)
	 */
	public String getEncryptedText(String plainText, String cipherCriteria) {
		return findEncryptedPadding(plainText, cipherCriteria);
		
	}

	/* (non-Javadoc)
	 * @see com.ozduman.interfaces.CryptoCipher#getDecryptedText(java.lang.String, java.lang.Object)
	 */
	public String getDecryptedText(String encryptedText, String cipherCriteria) {
		return findDecryptedPadding(encryptedText, cipherCriteria);
	}
}
