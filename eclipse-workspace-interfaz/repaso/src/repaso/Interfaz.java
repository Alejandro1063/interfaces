package repaso;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Interfaz{

	
		public static void main(String[] args) {

			JFrame ventana = new JFrame();
			ventana.setSize(600,400);
			
			ventana.setTitle("Hola que pasa");
			ventana.setLocationRelativeTo(null); // Posición centrada
			ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			ventana.getContentPane();
			 
			Container contenedor = ventana.getContentPane();
			JButton boton = new JButton();
			boton.setSize(0, 0);
			boton.setText("que pasa");
			contenedor.add(boton);
			
			
			ventana.setVisible(true);
		}

		
	
}
