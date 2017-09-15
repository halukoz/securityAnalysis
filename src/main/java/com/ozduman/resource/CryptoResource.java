package com.ozduman.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ozduman.service.Decryption;
import com.ozduman.service.Encryption;

/**
 * @author haluk
 * 
 * This class provides rest services.
 *
 */
@Path("/messages")
public class CryptoResource {

	/**
	 * 
	 */
	private Encryption encryption = new Encryption();
	/**
	 * 
	 */
	private Decryption decryption = new Decryption();

	/**
	 * Rest service for Caesar Cipher, encryption
	 * 
	 * @param plainText  user input of Caesar cipher.
	 * @param shiftSize  user input of Caesar cipher.
	 * @return  		 encrypted text.
	 */
	@GET
	@Path("/caesar/encryption/{plaintext}/{shiftsize}")
	@Produces(MediaType.TEXT_PLAIN)
	public String encryptTextWithCaesarCipher(@PathParam("plaintext") String plainText, @PathParam("shiftsize") String shiftSize) {
		return encryption.encryptWithCaesarCipher(plainText, Integer.parseInt(shiftSize));
	}

	/**
	 * Rest service for Caesar Cipher, decryption
	 * 
	 * @param ciphertext  user input of Caesar cipher.
	 * @param shiftSize   user input of Caesar cipher.
	 * @return  		  decrypted text.
	 */
	@GET
	@Path("/caesar/decryption/{ciphertext}/{shiftsize}")
	@Produces(MediaType.TEXT_PLAIN)
	public String decryptTextWithCaesarCipher(@PathParam("ciphertext") String ciphertext, @PathParam("shiftsize") String shiftSize) {
		return decryption.decryptWithCaesarCipher(ciphertext, Integer.parseInt(shiftSize));
	}

	/**
	 * Rest service for Vigenere Cipher, encryption.
	 * 
	 * @param plainText user input of Vigenere cipher.
	 * @param key       user input of Vigenere cipher.
	 * @return			encrypted text.
	 */
	@GET
	@Path("/vigenere/encryption/{plaintext}/{key}")
	@Produces(MediaType.TEXT_PLAIN)
	public String encryptTextWithVigenereCipher(@PathParam("plaintext") String plainText, @PathParam("key") String key) {
		return encryption.encryptWithVigenereCipher(plainText, key);
	}

	/**
	 * Rest service for Vigenere Cipher, decryption.
	 * 
	 * @param ciphertext  user input of Vigenere cipher.
	 * @param key		  user input of Vigenere cipher.
	 * @return            decrypted text.
	 */
	@GET
	@Path("/vigenere/decryption/{ciphertext}/{key}")
	@Produces(MediaType.TEXT_PLAIN)
	public String decryptTextWithVigenereCipher(@PathParam("ciphertext") String ciphertext, @PathParam("key") String key) {
		return decryption.decryptWithVigenereCipher(ciphertext, key);
	}

	/**
	 * Rest service for One Time Padding, encryption.
	 * 
	 * @param plainText  user input of one time padding.
	 * @param key		 user input of one time padding.
	 * @return           encrypted text.
	 */
	@GET
	@Path("/onetimepadding/encryption/{plaintext}/{key}")
	@Produces(MediaType.TEXT_PLAIN)
	public String encryptTextWithOneTimePadding(@PathParam("plaintext") String plainText, @PathParam("key") String key) {
		return encryption.encryptWithOneTimePadding(plainText, key);
	}

	/**
	 * Rest service for One Time Padding, decryption.
	 * 
	 * @param ciphertext  user input of one time padding.
	 * @param key		  user input of one time padding.
	 * @return            decrypted text.
	 */
	@GET
	@Path("/onetimepadding/decryption/{ciphertext}/{key}")
	@Produces(MediaType.TEXT_PLAIN)
	public String decryptTextWithOneTimePadding(@PathParam("ciphertext") String ciphertext, @PathParam("key") String key) {
		return decryption.decryptWithOneTimePadding(ciphertext, key);
	}
	
	/**
	 * Rest service for DES, encryption.
	 * 
	 * @param plainText	user input of DES.
	 * @return			encrypted text
	 */
	@GET
	@Path("/des/encryption/{plaintext}")
	@Produces(MediaType.TEXT_PLAIN)
	public String encryptTextWithDes(@PathParam("plaintext") String plainText) {
		return encryption.encrypWithDataEncryptionStandartCipher(plainText);
	}

	/**
	 * Rest service for DES, decryption.
	 * 
	 * @param cipherText user input of DES.
	 * @return			 decrypted text.
	 */
	@GET
	@Path("/des/decryption/{ciphertext}")
	@Produces(MediaType.TEXT_PLAIN)
	public String decryptTextWithDes(@PathParam("ciphertext") String cipherText) {
		return decryption.decryptWithDataEncryptionStandartCipher(cipherText);
	}
	
	/**
	 * @param plainText	user input of AES.
	 * @param key		user input of AES.
	 * @return			encrypted text.
	 */
	@GET
	@Path("/aes/encryption/{plaintext}/{key}")
	@Produces(MediaType.TEXT_PLAIN)
	public String encryptTextWithAes(@PathParam("plaintext") String plainText, @PathParam("key") String key) {
		return encryption.encryptWithAdvancedEncryptionStandardCipher(plainText, key);
	}

	/**
	 * @param cipherText user input of AES.
	 * @param key		 user input of AES.
	 * @return			 decrypted text.
	 */
	@GET
	@Path("/aes/decryption/{ciphertext}/{key}")
	@Produces(MediaType.TEXT_PLAIN)
	public String decryptTextWithAes(@PathParam("ciphertext") String cipherText, @PathParam("key") String key) {
		return decryption.decryptWithAdvancedEncryptionStandardCipher(cipherText, key);
	}
}
