/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploclientesocketstream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class EjemploClienteSocketStream {

    public static void main(String[] args) {
        try {
            System.out.println("Creando socket cliente");
            Socket clienteSocket = new Socket();
            System.out.println("Estableciendo la conexi�n");

            InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
            clienteSocket.connect(addr);

            InputStream is = clienteSocket.getInputStream();
            OutputStream os = clienteSocket.getOutputStream();

            System.out.println("Enviando mensaje");

            String mensaje = "mensaje desde Omar";
            byte[] mens=new byte[30];
            byte[] bytesMensaje=mensaje.getBytes();
            for(int i=0;i<mensaje.getBytes().length;i++){
                mens[i]=bytesMensaje[i];
            }           
            
            os.write(mens);
            
            System.out.println("Mensaje enviado");
            
            String mensaje2="Parvo";
            
            mens=new byte[30];
            bytesMensaje=mensaje2.getBytes();
            for(int i=0;i<mensaje2.getBytes().length;i++){
                mens[i]=bytesMensaje[i];
            }
            
            os.write(mens);

            System.out.println("Cerrando el socket cliente");

            clienteSocket.close();

            System.out.println("Terminado");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
