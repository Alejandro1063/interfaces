package Ejercicio1;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ejercicio1 {

	public static void main(String[] args) {
		JFrame ventana = new JFrame();
		ventana.setSize(600,400);
		ventana.setTitle("Hola que pasa");
		ventana.setLocationRelativeTo(null); // Posición centrada
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ventana.getContentPane();
		 
		Container contenedor = ventana.getContentPane();
		GridLayout layout = new GridLayout(3,2);
		
		ventana.setLayout (layout);
		
		ventana.setVisible(true);
		 
		
		for (int contador = 1; contador < 6; contador++) {
		
			JLabel boton3 = new JLabel();
			boton3.setSize(0, 0);
			boton3.setText("Texto " + contador);
			contenedor.add(boton3);
			
		}
		
		JPanel panel = new JPanel();
		GridLayout layoutprimero = new GridLayout(2,2);
		panel.setLayout(layoutprimero);
		contenedor.add(panel);
		
		for (int contador = 0; contador < 4; contador++) {
			
			
			JLabel botonn = new JLabel();
			panel.add(botonn);
			botonn.setText("Texto6" + (contador + 1));
			
		}
	}
}