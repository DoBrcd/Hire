package com.hire.service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

/**
 * Class which expose static methods to encrypt / decrypt a password with a given key
 */
public class Encrypt {

	/**
	 * Encrypts a given password with a given key
	 * @param password The password to encrypt
	 * @param key The key to use during password encryption
	 * @return The new encrypted password
	 */
	public static String encrypt(String password, String key) {
		try {
			Key clef = new SecretKeySpec(key.getBytes("UTF-8"), "Blowfish");
			Cipher cipher = Cipher.getInstance("Blowfish");
			cipher.init(Cipher.ENCRYPT_MODE, clef);
			return new String(cipher.doFinal(password.getBytes()), "UTF-8");
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Decrypts a given password with a given key
	 * @param password The password to decrypt
	 * @param key The key to use during password decryption
	 * @return The new decrypted password
	 */
	public String decrypt(String password, String key) {
		try {
			Key clef = new SecretKeySpec(key.getBytes("UTF-8"), "Blowfish");
			Cipher cipher = Cipher.getInstance("Blowfish");
			cipher.init(Cipher.DECRYPT_MODE, clef);

            return new String(cipher.doFinal(password.getBytes("UTF-8")), "UTF-8");
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
