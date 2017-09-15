package com.ozduman.analyses;

import com.ozduman.interfaces.CryptoCipher;

/**
 * 
 * This class finds encrypted or decrpyted messages with using caesar cipher technique.
 *
 * @author haluk
 */
public class CaesarCipher implements CryptoCipher<Integer>{

	/**
	 * @param splittedItem this text is splitted according to empty lines and characters. This is the splitted part of users' messages. 
	 * @param shiftAmount  this integer determines the shift amount of ceasar cipher.
	 * @return
	 */
	private String encryptTheText(String splittedItem, int shiftAmount) {

		char[] buffer = splittedItem.toCharArray();

		for (int i = 0; i < buffer.length; i++) {
			char textLetter = buffer[i];
			textLetter = (char) (textLetter + shiftAmount);

			if (textLetter > 'z') {
				textLetter = (char) (textLetter - 26);
			} else if (textLetter < 'a') {
				textLetter = (char) (textLetter + 26);
			}
			buffer[i] = textLetter;
		}
		return new String(buffer);
	}

	/**
	 * @param splittedItem this text is splitted according to empty lines and characters.
	 * @param shiftAmount this integer determines the shift amount of ceasar cipher.
	 * @return
	 */
	private String decryptTheText(String splittedItem, int shiftAmount) {

		char[] buffer = splittedItem.toCharArray();
		
		for (int i = 0; i < buffer.length; i++) {
			char textLetter = buffer[i];
			textLetter = (char) (textLetter - shiftAmount);
			
			if(textLetter > 'z') {
				textLetter = (char) (textLetter - 26);
			} else if (textLetter < 'a') {
				textLetter = (char) (textLetter + 26);
			}
			buffer[i] = textLetter;
		}
		return new String(buffer);
	}

	/* (non-Javadoc)
	 * @see com.ozduman.interfaces.CryptoCipher#getEncryptedText(java.lang.String, java.lang.Object)
	 */
	public String getEncryptedText(String plainText, Integer cipherCriteria) {

		String encryptedText = "";
		String[] splittedPlainText = plainText.split("[ .]");
		int indexOfSplittedText = 0;

		for (String splittedItem : splittedPlainText) { 	
			encryptedText = encryptedText + encryptTheText(splittedItem, cipherCriteria);
			indexOfSplittedText++;
			if (splittedPlainText.length != indexOfSplittedText) {
				encryptedText = encryptedText + " ";
			}
		}
		return encryptedText;
	}

	/* (non-Javadoc)
	 * @see com.ozduman.interfaces.CryptoCipher#getDecryptedText(java.lang.String, java.lang.Object)
	 */
	public String getDecryptedText(String encryptedText, Integer cipherCriteria) {

		String decryptedText = "";
		String[] splittedEncryptedText = encryptedText.split("[ .]");
		int indexOfSplittedText = 0;

		for (String splittedItem: splittedEncryptedText) {
			decryptedText = decryptedText + decryptTheText(splittedItem, cipherCriteria);
			indexOfSplittedText++;
			if (splittedEncryptedText.length != indexOfSplittedText) {
				decryptedText = decryptedText + " ";
			}
		}
		return decryptedText;
	}
}
