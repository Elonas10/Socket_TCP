package com.lr.gain;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
	 public static void main(String arg[]) {
		 try {
		 ServerSocket server= new ServerSocket(4500);
		 Socket cliente=server.accept();
		 ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
		 System.out.println("LLego tu mensaje");
		 
		 String mensaje = (String)entrada.readObject();
		 System.out.println("Mensaje: " + mensaje );
		 ObjectOutputStream reap = new ObjectOutputStream(cliente.getOutputStream());
		 reap.writeObject("Hola cliente");
		 System.out.println("Mensaje enviado");
		 cliente.close();
		 server.close();
		 }
		 catch(ClassNotFoundException ex) {
			 Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
		 }
		 catch(IOException ex){
			 Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
		 }
		 
	 }
}
