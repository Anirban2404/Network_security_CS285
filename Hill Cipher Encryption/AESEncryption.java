/**
 * @author Anirban Bhattacharjee
 */

import java.security.Security;
import java.security.Key;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESEncryption {

	private static final String ALGO = "AES";
	private static final String ALGOSPEC = "AES/ECB/PKCS5Padding";
	private static final byte[] keyValue = new byte[] { 0x00, 0x01, 0x02, 0x03,
			0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e,
			0x0f, 0x10, 0x11, 0x12, 0x13, 0x14, 0x15, 0x16, 0x17 };

	public static byte[] encrypt(byte[] Data) throws Exception {
		Key key = generateKey();
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encVal = c.doFinal(Data);
		return encVal;
	}

	public static byte[] decrypt(byte[] encryptedData) throws Exception {
		Key key = generateKey();
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.DECRYPT_MODE, key);
		byte[] decValue = c.doFinal(encryptedData);
		return decValue;
	}

	private static Key generateKey() throws Exception {
		Key key = new SecretKeySpec(keyValue, ALGO);
		return key;
	}

}
