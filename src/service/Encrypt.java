package service;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Encrypt {

	public static String encrypt(String password, String key) {
		try {
			Key clef = new SecretKeySpec(key.getBytes("UTF-8"), "Blowfish");
			Cipher cipher = Cipher.getInstance("Blowfish");
			cipher.init(Cipher.ENCRYPT_MODE, clef);
			
            return new String(cipher.doFinal(password.getBytes("UTF-8")), "UTF-8");

		} catch (Exception e) {
			return null;
		}
	}

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
