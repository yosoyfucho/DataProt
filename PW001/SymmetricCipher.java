/*
Laura Benito Martin 100284695
Rafael Leon Miranda 100275593
*/

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.NoSuchAlgorithmException;
import javax.crypto.*;
import java.security.InvalidKeyException;
import java.text.NumberFormat;

public class SymmetricCipher {

	byte[] byteKey;
	SymmetricEncryption s;
	SymmetricEncryption d;

	// Initialization Vector (fixed)

	byte[] iv = new byte[] { (byte)49, (byte)50, (byte)51, (byte)52, (byte)53, (byte)54,
		(byte)55, (byte)56, (byte)57, (byte)48, (byte)49, (byte)50, (byte)51, (byte)52,
		(byte)53, (byte)54};

    /*************************************************************************************/
	/* Constructor method */
    /*************************************************************************************/
	public void SymmetricCipher() {
	}

    /*************************************************************************************/
	/* Method to encrypt using AES/CBC/PKCS5 */
    /*************************************************************************************/
	public byte[] encryptCBC (byte[] input, byte[] byteKey) throws Exception {

		byte[] ciphertext = null;
		byte[] aux = null;

		int numBytesPad = 0;
		int numBytesTot = 0;
		int totalBlocks = 0;

		int auxMod = 0;
		int audDiv = 0;

		auxMod = input.length % 16;

		numBytesPad = input.length - auxMod;
		numBytesTot = numBytesPad + input.length;
		totalBlocks = numBytesTot / 16;
		//Comprobar con if si cumple Padding
		if (auxMod == 0)
		{
			totalBlocks ++;
		}
			//Check arraycopy

			for (int i =0;i<totalBlocks; i++)
			{





					if (i==0)
					{
						//XOR con IV Bloque 1
					}
					else
					{
						// XOR bloque i con bloqueYaCifrado i-1

					}
			}


			// Generate the plaintext with padding



			// Generate the ciphertext



		return ciphertext;
	}

	/*************************************************************************************/
	/* Method to decrypt using AES/CBC/PKCS5 */
    /*************************************************************************************/


	public byte[] decryptCBC (byte[] input, byte[] byteKey) throws Exception {


		byte [] finalplaintext = null;


		// Generate the plaintext


		// Eliminate the padding



		return finalplaintext;
	}

}
