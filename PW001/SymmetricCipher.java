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

			
			// Generate the plaintext with padding

			
 //Aquí hay un byte con el texto con padding
			Vector<byte> vTextPad[] = new Vector<byte>();
			vTextPad = division(textPadd, totalBlocks);

			// Generate the ciphertext

			for (int i=0;i<totalBlocks; i++)
			{
				byte[] aux;
					if (i==0)
					{
						//XOR con IV Bloque 1
						aux = (vTextPadd.elementAt(i)) ^ iv;
					}
					else
					{
						// XOR bloque i con bloqueYaCifrado i-1

					}
					ciphertext = concat(ciphertext,aux);
			}


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

	/*
	Function to concatenate two arrays
	*/

	public byte[] concat (byte[] a , byte[] b)
	{
		int aLen = a.length;
		int bLen = b.length;
		byte[] c = new byte[aLen + bLen];
		System.arraycopy(a,0,c,0,aLen);
		System.arraycopy(b,0,c,aLen,bLen);
		return c;
	}

	public Vector<byte>[] division (byte[] text, int a)
	{
		Vector <byte> resultado [] = new Vector[a];
		int b = 16;
		for (int i=0; i<a ;i++ )
		{
				resultado[i] = (Vector<byte>) new Vector<byte>();
				resultado[i].add(text[i+b]);
		}
		return resultado;
	}
	
	/*      	>>> Metodo addPadding <<<
	 * El bloque de entrada tendrá entre 0 y 15 bytes
	 * 
	 * El numero de bytes que faltan serán entre 1 y 16
	 * Se utiliza el formato #PKCS5 que consiste en:
	 * Rellenar los huecos de bytes con el valor numerico
	 * del numero de bytes necesarios
	 * Si faltan 3 bytes, se rellenan 3 bytes con 0x03
	 * Si faltan 2 bytes, se rellenan 2 bytes con 0x02
	 * Si faltan 1 bytes, se rellenan 1 bytes con 0x01
	 * 
	 * Devuelve un array de bytes ya con su padding correspondiente
	 *  
	 * */
	public byte[] addPadding(byte[] input) throws Exception
	{	
		
		byte[] blockWithPadding = null;
		int inputLength;
		
		//Si el array está vacío la longitud es 0
		if(input == null)
		{
			inputLength= 0;
		}
		else if(input.length >= 16)
		{
			//Si tiene 16 bytes o mas no calculamos padding 
			//Para el padding de los bloques enteros le pasamos null
			return null;
		}
		else
		{
			inputLength = input.length;
		}
		
		int missingBytes = 16 - inputLength;
		//Creamos un array de bytes del tamaño de los bytes que faltan
		byte[] padding = new byte[missingBytes];
		//Rellenamos el array con el valor del numero de bytes que faltan
		Arrays.fill(padding, (byte)missingBytes);		
		System.out.println(Arrays.toString(padding));
	    
		//Concatenamos los dos arrays resultantes 
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream( );
	  		
		outputStream.write(input);
		outputStream.write(padding);
	  	
		//Convertimos a byte[] de nuevo
		blockWithPadding = outputStream.toByteArray( );
		
		return blockWithPadding;
	}


}
