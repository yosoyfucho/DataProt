import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Signature;
import java.util.Arrays;

import javax.crypto.Cipher;


public class Main{
	
	public static void main(String args[]) throws Exception{

		String plaintext = "Esto es una prueba del cifrado CBC, a ver que tal es capaz de desencriptarlo";
		byte[] input = plaintext.getBytes();
		
		/*byte[] input = new byte[] { (byte)49, (byte)50, (byte)80, (byte)52, (byte)53, (byte)54,
		    		(byte)55, (byte)56, (byte)57, (byte)48, (byte)49, (byte)50, (byte)11, (byte)52,
		    		(byte)53, (byte)33, (byte)57, (byte)48, (byte)49, (byte)57, (byte)48, (byte)49, 
		    		(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)3, (byte)3, (byte)4, 
		    		(byte)5,(byte)2, (byte)78,(byte)2, (byte)0,(byte)2, (byte)20, (byte)100,(byte)9,
		    		(byte)2, (byte)0,(byte)2,(byte)49, (byte)50, (byte)51,(byte)5,(byte)2, (byte)69,
		    		(byte)44, (byte)45, (byte)88, (byte)13, (byte)86, (byte)57, (byte)27, (byte)29};
		 */
		 byte[] byteKey = new byte[] { (byte)20, (byte)50, (byte)58, (byte)52, (byte)33, (byte)9,
		    		(byte)45, (byte)50, (byte)57, (byte)23, (byte)12, (byte)50, (byte)53, (byte)52,
		    		(byte)93, (byte)84};
		
		byte[] cifrado = null;
		byte[] descifrado = null;
		
		System.out.println("Input plaintext  : " + plaintext);
		System.out.println("\n********************************************\n");
		SymmetricCipher sym = new SymmetricCipher();
		cifrado = sym.encryptCBC(input, byteKey);
		System.out.println("Output cifrado   : " + Arrays.toString(cifrado));
		System.out.println(cifrado.length);
		System.out.println("\n********************************************\n");
    	descifrado = sym.decryptCBC(cifrado, byteKey);
    	System.out.println("\n********************************************\n");   
    	String des = new String(descifrado);
      	System.out.println("Output descifrado: " + des);
    	System.out.println(descifrado.length);
    	
    	

		
		
	}

}