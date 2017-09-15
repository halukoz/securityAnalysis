package com.ozduman.analyses;

import com.ozduman.interfaces.CryptoCipher;

/**
 *
 * This class finds encrypted or decrpyted messages with using vigenere cipher technique.
 *
 *@author ozduman
 */
public class VigenereCipher implements CryptoCipher<String>{

	/**
	 * @param plainText  user input, which come from ui.
	 * @param key    key value, which come from ui.
	 * @return
	 */
	private String encryptTheMessage(String plainText, String key) {
		
		StringBuilder encryptedText = new StringBuilder();
		int lengthOfPlainText = plainText.length();
		int indexOfKey = 0;
		
		if (lengthOfPlainText == 0 || key.length() == 0) {
			return "";
		}

		for (int i=0; i < lengthOfPlainText; i++) {
			int asciiOfPlainTextCharacter = plainText.charAt(i);
			int asciiOfkeyCharacter = key.charAt(indexOfKey);
			
			if (asciiOfPlainTextCharacter >= 65 && asciiOfPlainTextCharacter <= 90) {
				asciiOfPlainTextCharacter += 32; 
			}
			
			if (asciiOfkeyCharacter >= 65 && asciiOfkeyCharacter <= 90) {
				asciiOfkeyCharacter += 32;
			}
			
			if ((asciiOfPlainTextCharacter < 97 || asciiOfPlainTextCharacter > 122) || (asciiOfkeyCharacter < 97 || asciiOfkeyCharacter > 122)) {
				continue;
			}
			
	    	int shiftedTextAsciiNumber = asciiOfPlainTextCharacter+asciiOfkeyCharacter-97;
			char c = (char)((shiftedTextAsciiNumber > 122) ? shiftedTextAsciiNumber-26 : shiftedTextAsciiNumber);
			encryptedText.append(c);
			
			if (indexOfKey == key.length()-1) {
				indexOfKey = 0;
			} else {
				indexOfKey++;
			}
		}
		return encryptedText.toString();
	}
	
	/**
	 * @param plainText user input, which come from ui.
	 * @param key key value, which come from ui.
	 * @return
	 */
	private String decryptTheMessage(String plainText, String key) {
		
		StringBuilder decryptedText = new StringBuilder();
		
		if (plainText.length() == 0 || key.length() == 0) {
			return "";
		}
		
		int lengthOfPlainText = plainText.length();
		int indexOfKey = 0;
		for (int i=0; i < lengthOfPlainText; i++) {
			int asciiOfPlainTextCharacter = plainText.charAt(i);
			int asciiOfkeyCharacter = key.charAt(indexOfKey);

			if (asciiOfPlainTextCharacter >= 65 && asciiOfPlainTextCharacter <= 90) {
				asciiOfPlainTextCharacter += 32;
			}
			
			if (asciiOfkeyCharacter >= 65 && asciiOfkeyCharacter <= 90) {
				asciiOfkeyCharacter += 32;
			}
			
			if ((asciiOfPlainTextCharacter < 97 || asciiOfPlainTextCharacter > 122) || (asciiOfkeyCharacter < 97 || asciiOfkeyCharacter > 122)) {
				continue;
			}
			
	    	int shiftedTextAsciiNumber = asciiOfPlainTextCharacter-(asciiOfkeyCharacter-97);
			char c = (char)((shiftedTextAsciiNumber < 97) ? shiftedTextAsciiNumber+26 : shiftedTextAsciiNumber);
			decryptedText.append(c);
			
			if (indexOfKey == key.length()-1) {
				indexOfKey = 0;
			} else {
				indexOfKey++;
			}
		}
		return decryptedText.toString();
	}

	/* (non-Javadoc)
	 * @see com.ozduman.interfaces.CryptoCipher#getEncryptedText(java.lang.String, java.lang.Object)
	 */
	public String getEncryptedText(String plainText, String cipherCriteria) {
		return encryptTheMessage(plainText, cipherCriteria);
		
	}

	/* (non-Javadoc)
	 * @see com.ozduman.interfaces.CryptoCipher#getDecryptedText(java.lang.String, java.lang.Object)
	 */
	public String getDecryptedText(String encryptedText, String cipherCriteria) {
		return decryptTheMessage(encryptedText, cipherCriteria);
	}
}
