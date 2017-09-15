package com.ozduman.analyses;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import com.ozduman.interfaces.CryptoCipher;

/**
 * 
 * This class finds encrypted or decrpyted messages with DES.
 * 
 *  @author ozduman
 *
 */
public class DataEncryptionStandartCipher implements CryptoCipher<String> {

	/**
	 * SecretKey will be generated automatically and randomly.
	 */
	private static SecretKey secretKey;
	/**
	 * Cipher object is for DES/ECB/PKCS5Padding des technique.
	 */
	private static Cipher cipher;

	/**
	 * Constructor
	 */
	public DataEncryptionStandartCipher() {
		secretKey = getSecretKey();
		cipher = getCipher();
	}

	/**
	 * @return auto-generated secret key
	 */
	private SecretKey getSecretKey() {
		KeyGenerator keygenerator = null;
		SecretKey myDesKey = null;
		try {
			keygenerator = KeyGenerator.getInstance("DES");
			myDesKey = keygenerator.generateKey();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return myDesKey;
	}

	/**
	 * @return cipher with DES/ECB/PKCS5Padding property
	 */
	private Cipher getCipher() {
		try {
			cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
		return cipher;
	}

	/**
	 * @param plainText user input, which come from UI.
	 * @return encrypted message.
	 */
	private byte[] encryptTheText(String plainText) {
		byte[] textEncrypted = null;
		try {
			if (secretKey == null) {
				return null;
			}
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] text = plainText.getBytes();
			textEncrypted = cipher.doFinal(text);
		}  catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return textEncrypted;
	}

	/**
	 * @param cipherText encrypted message which come from UI.
	 * @return decrypted message.
	 */
	private String decryptTheText(byte[] cipherText) {
		byte[] textDecrypted = null;
		try {
			if (secretKey == null) {
				return "";
			}
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			textDecrypted = cipher.doFinal(cipherText);
		}  catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return new String(textDecrypted);
	}

	/**
	 * @param plainText
	 * @param cipherCriteria
	 * @return
	 */
	public byte[] getEncyptedTextAsBytes(String plainText, String cipherCriteria) {

		return encryptTheText(plainText);
	}

	/* (non-Javadoc)
	 * @see com.ozduman.interfaces.CryptoCipher#getEncryptedText(java.lang.String, java.lang.Object)
	 */
	public String getEncryptedText(String plainText, String cipherCriteria) {

		return new String(getEncyptedTextAsBytes(plainText, cipherCriteria));
	}

	/* (non-Javadoc)
	 * @see com.ozduman.interfaces.CryptoCipher#getDecryptedText(java.lang.String, java.lang.Object)
	 */
	public String getDecryptedText(String encryptedText, String cipherCriteria) {

		return decryptTheText(encryptedText.getBytes());
	}

	/**
	 * @param encryptedText
	 * @param cipherCriteria
	 * @return
	 */
	public String getDecryptedText(byte[] encryptedText, String cipherCriteria) {

		return decryptTheText(encryptedText);
	}
}
