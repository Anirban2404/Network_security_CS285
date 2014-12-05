/**
 * @author Anirban Bhattacharjee
 */

public class AESExample {
	public static void main(String[] args) throws Exception {
		String Plaintext = "test msg";
		System.out.println("Plain Text : " + Plaintext);

		byte[] Ciphertext = AESEncryption.encrypt(Plaintext.getBytes());
		System.out.println("Encrypted Text : " + new String(Ciphertext));

		byte[] Decryptedtext = AESEncryption.decrypt(Ciphertext);
		System.out.println("Decrypted Text : " + new String(Decryptedtext));
	}
}
