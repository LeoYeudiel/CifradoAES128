/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifrados;

import java.io.*;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JTextField;
import sun.misc.BASE64Encoder;

/**
 *
 * @author lyeup
 */
public class aesfun {
    public JTextField txtcifra, clave, txtnormal, txtdecifra;
    public String llave, text;
        public aesfun(String entrada, String texto, JTextField txtcifra,JTextField txtdecifra, JTextField normal){
            this.llave=entrada;
            this.text=texto;
            this.txtcifra=txtcifra;
            this.txtdecifra=txtdecifra;
            this.txtnormal=normal;
        }

    
    
        
    public void cifrar(){
        SecretKeySpec key=new SecretKeySpec(llave.getBytes(), "AES");
        Cipher cifrado;
        try {
            cifrado=Cipher.getInstance("AES");
            cifrado.init(Cipher.ENCRYPT_MODE, key);
            byte[] textcifrado= cifrado.doFinal(text.getBytes());
            String base64=new BASE64Encoder().encode(textcifrado);
            txtcifra.setText(""+base64);
            
            
        FileWriter fichero = null;
        PrintWriter pw = null;
            try
            {
                fichero = new FileWriter("cifrado.txt");
                pw = new PrintWriter(fichero);

                for (int i = 0; i < 1; i++)
                    pw.println(base64);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
               try {
               if (null != fichero)
                  fichero.close();
               } catch (Exception e2) {
                  e2.printStackTrace();
               }
            }   
        } catch (Exception e) {
            System.out.println("La llave es pequeña o grande");
        }
        
    }
    
    public void decifrar(){
        SecretKeySpec key=new SecretKeySpec(llave.getBytes(), "AES");
        Cipher cifrado;
        try {
            cifrado=Cipher.getInstance("AES");
            cifrado.init(Cipher.ENCRYPT_MODE, key);
            byte[] textcifrado= cifrado.doFinal(text.getBytes());
            String base64=new BASE64Encoder().encode(textcifrado);
          
            
            cifrado.init(Cipher.DECRYPT_MODE, key);
            byte[] textdecifrado= cifrado.doFinal(textcifrado);
            String mensaje= new String(textdecifrado);
            txtdecifra.setText(""+mensaje);
            FileWriter fichero = null;
            PrintWriter pw = null;
                try
                {
                    fichero = new FileWriter("decifrado.txt");
                    pw = new PrintWriter(fichero);

                    for (int i = 0; i < 1; i++)
                        pw.println(mensaje);

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                   try {
                   if (null != fichero)
                      fichero.close();
                   } catch (Exception e2) {
                      e2.printStackTrace();
                   }
                }
            
        } catch (Exception e) {
            System.out.println("La llave es pequeña o grande");
        }
    }
    
    public void leer(){
        String texto="";
       File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;

      try {
         archivo = new File ("mormal.txt");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

        
         while((texto=br.readLine())!=null)
            txtnormal.setText(texto);
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
    }
    public void guardar(){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("src\\mormal.txt");
            pw = new PrintWriter(fichero);

            for (int i = 0; i < 1; i++)
                pw.println(text);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }

}
      

