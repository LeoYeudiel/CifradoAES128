/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifrados;

/**
 *
 * @author lyeup
 */
import java.io.*;
import javax.crypto.*;
import javax.crypto.interfaces.*;
import javax.crypto.spec.*;
import java.security.*;
import javax.swing.JTextField;
import sun.security.util.Length;
import sun.misc.BASE64Encoder;
public class desfun {
   public JTextField txtcifra, clave, txtnormal, txtdecifra;
    public String llave, text;
        public desfun(String entrada, String texto, JTextField txtcifra,JTextField txtdecifra){
            this.llave=entrada;
            this.text=texto;
            this.txtcifra=txtcifra;
            this.txtdecifra=txtdecifra;
        }
    
    
    public void Cifrar() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        KeyGenerator key= KeyGenerator.getInstance("DES");
        key.init(56);
        SecretKey clave= key.generateKey();
        Cipher cifra= Cipher.getInstance("DES/EBC/PKCS5Padding");
        cifra.init(Cipher.ENCRYPT_MODE, clave);
        
        byte[] cifrado=cifra.doFinal(text.getBytes());
        txtcifra.setText(""+ cifrado);
        
        cifra.init(Cipher.DECRYPT_MODE, clave);
        byte[] decifrado=cifra.update(cifrado);
        decifrado=cifra.doFinal();
        txtdecifra.setText(""+ decifrado);
    }
    
    
    
}
