package com.lr.gain;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {
	public static void main(String arg[]) {

		try {
			Socket cliente = new Socket("localhost",4500);
			ObjectOutputStream mensaje= new ObjectOutputStream(cliente.getOutputStream());
			mensaje.writeObject("Hola servidor");
			ObjectInputStream entrada= new  ObjectInputStream(cliente.getInputStream());
			String servermsj= (String)entrada.readObject();
			System.out.println("Mensaje del servidor: " + servermsj);
			cliente.close();
			System.out.println("Conexion terminada");
			
		}catch(ClassNotFoundException ex) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
		}
		 catch (UnknownHostException ex) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
