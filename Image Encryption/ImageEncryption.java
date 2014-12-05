/**
 * @author Anirban Bhattacharjee
 * 
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ImageEncryption {

	public static void main(String[] args) {
		System.out.println("Start Encryption of the Image File");
		File imageFile = new File("C:/image.jpg");
		try {
			// Start reading from the Image File
			System.out.println("Read Image File");
			FileInputStream fin = new FileInputStream(imageFile);
			DataInputStream din = new DataInputStream(new BufferedInputStream(
					fin));
			File encryptedFile = new File("C:/encrypted_image.jpg");
			// Checking if the Encrypted Image file already exists
			if (!encryptedFile.exists()) {
				encryptedFile.createNewFile();
			}
			// create an empty file whether it exists or not
			FileOutputStream fout = new FileOutputStream(encryptedFile, false);
			System.out.println("Created blank File for encryption");

			DataOutputStream dout = new DataOutputStream(
					new BufferedOutputStream(fout));
			// Encrypting the Image file byte by byte
			byte[] b = new byte[(int) imageFile.length()];

			for (int i = 0; i < b.length - 1; i++) {
				b[i] = din.readByte();
			}

			byte[] Ciphertext = AESEncryption.encrypt(b);
			System.out.println("Encryption is done successfully");
			System.out.println("Encrypted Text : " + new String(Ciphertext));
			// Write the encrypted text to encryptd_image.jpg
			dout.write(Ciphertext);
			// Close the write buffer
			dout.close();
			// Close the write buffer
			din.close();
			System.out.println("Encyption File is created");

			// Start decrypting the file
			byte[] Decryptedtext = AESEncryption.decrypt(Ciphertext);
			System.out.println("Decrypted Text : " + new String(Decryptedtext));
			File decryptedFile = new File("C:/decrypted_image.jpg");
			// Checking if the Encrypted Image file already exists
			if (!decryptedFile.exists()) {
				decryptedFile.createNewFile();
			}
			// create an empty file whether it exists or not
			FileOutputStream fout_d = new FileOutputStream(decryptedFile, false);
			System.out.println("Created blank File for decryption");

			System.out.println("Write decrypted text to file");
			DataOutputStream dout_d = new DataOutputStream(
					new BufferedOutputStream(fout_d));

			// Decrypting the Image file byte by byte
			for (int i = 0; i < Decryptedtext.length - 1; i++) {
				dout_d.write(Decryptedtext[i]);
			}
			// Close the write buffer
			dout_d.close();
			System.out.println("Decyption File is created");
		} catch (FileNotFoundException ex) {
			System.out.println("Image file does not exists");
		} catch (Exception ex) {
			System.out.println("Ërror in the encryption-decrytion process");
		}
	}

}
