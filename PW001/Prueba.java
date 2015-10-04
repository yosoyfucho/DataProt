import java.text.NumberFormat;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.NoSuchAlgorithmException;
import javax.crypto.*;
import java.security.InvalidKeyException;
import java.text.NumberFormat;

public class Prueba{

  public static  void main (String [ ] args) {

    String str1 = args[0];
    String str2 = args[1];

    int numero1 = Integer.parseInt(str1);
    int numero2 = Integer.parseInt(str2);

    int div1 = (int) numero1/numero2;
    System.out.println("Division entera" + div1);

    int div2 = (int) numero1 % numero2;
    System.out.println("resto =" + div2);
    if(div2!=0)
    {
      div1++;
      System.out.println("Se redondea hacia arriba" + div1);
    }

}

}
