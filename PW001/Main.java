/*
Class to check the encryption and decryption functions
Laura Benito Martin 284695
Rafael Leon Miranda 275593
*/

import java.io.*;

public class Main {


  public static  void main (String [ ] args)
  {

    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;

  switch(args[0])
  {
    case 1:
    try {
        // Apertura del fichero y creacion de BufferedReader para poder
        // hacer una lectura comoda (disponer del metodo readLine()).
             archivoSrc = new File (args[1]);
             frSrc = new FileReader (archivoSrc);
             brSrc = new BufferedReader(frSrc);

             // Lectura del fichero
             String linea;
             while((linea=br.readLine())!=null)
                System.out.println(linea);
          }
          catch(Exception e){
             e.printStackTrace();
          }finally{
             // En el finally cerramos el fichero, para asegurarnos
             // que se cierra tanto si todo va bien como si salta
             // una excepcion.
             try{
                if( null != fr ){
                   fr.close();
                }
             }catch (Exception e2){
                e2.printStackTrace();
             }
          }

  }



  }

}
