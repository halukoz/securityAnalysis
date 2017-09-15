package com.ozduman.analyses;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import com.ozduman.interfaces.CryptoCipher;


/**
 * 
 * This class find find decrypted or encrypted value of input texts. 
 * Generate key according to users' preferences. 
 * 
 * @author ozduman
 *
 */
public class AdvancedEncryptionStandardCipher implements CryptoCipher<String> {

	public static SecretKeySpec setKey(String specifiedKey) {
		
		SecretKeySpec secretKey = null;
		byte[] key;
		try {
			key = specifiedKey.getBytes("UTF-8");
			key = MessageDigest.getInstance("SHA-1").digest(key);
			key = Arrays.copyOf(key, 16); 
			secretKey = new SecretKeySpec(key, "AES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return secretKey;
	}

	/**
	 * @param plainText	 user input, which come from UI. This will be input for the encryption.
	 * @param secretKey  this key come from UI. This will be second input for the encryption.
	 * @return  encrypted text
	 */
	public String encryptTheText(String plainText, String secretKey) {
		
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, setKey(secretKey));
			return Base64.getEncoder().encodeToString(cipher.doFinal(plainText.getBytes("UTF-8")));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	/**
	 * @param cipherText  It has already encrypted message. This input come from users. This will be input for decryption. 
	 * @param secretKey   This value come from users. This will be key for decryption.
	 * @return
	 */
	public String decryptTheText(String cipherText, String secretKey) {
		
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, setKey(secretKey));
			return new String(cipher.doFinal(Base64.getDecoder().decode(cipherText)));
		} 
		catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ozduman.interfaces.CryptoCipher#getEncryptedText(java.lang.String, java.lang.Object)
	 */
	public String getEncryptedText(String plainText, String cipherCriteria) {
		return encryptTheText(plainText, cipherCriteria);
	}

	/* (non-Javadoc)
	 * @see com.ozduman.interfaces.CryptoCipher#getDecryptedText(java.lang.String, java.lang.Object)
	 */
	public String getDecryptedText(String encryptedText, String cipherCriteria) {
		return decryptTheText(encryptedText, cipherCriteria);
	}
}
