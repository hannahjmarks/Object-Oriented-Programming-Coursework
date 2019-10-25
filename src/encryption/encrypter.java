//This class contains the function that encodes and decodes the passwords for writing and reading to the text file

package encryption;

import java.util.Base64;


public class encrypter {
	public static String encrypt(String original) {
		byte[] encodedString=original.getBytes();//converts the string to a byte array
		String encrypted=Base64.getEncoder().encodeToString(encodedString);//runs the byte array through the encoder to get an encoded string
		
		return encrypted;
	}
	
	public static String decrypt(String encrypted) {
		byte[] decodedString=Base64.getDecoder().decode(encrypted);//runs the encoded string through the decoder to get the byte array
		String decrypted=new String(decodedString);//converts the byte array to a string
		
		return decrypted;
	}

}
