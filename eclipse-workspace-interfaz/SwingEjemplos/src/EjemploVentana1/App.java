package EjemploVentana1;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class App{

	
		public static void main(String[] args) {

			JFrame ventana = new JFrame();
			ventana.setSize(600,400);
			
			ventana.setTitle("Hola que pasa");
			ventana.setLocationRelativeTo(null); // Posición centrada
			ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			ventana.getContentPane();
			 
			Container contenedor = ventana.getContentPane();
			
			
			GridLayout layout = new GridLayout(4,2);
			JButton boton = new JButton();
			
			
			ventana.setLayout (layout);
			boton.setSize(0, 0);
			boton.setText("que pasa");
			contenedor.add(boton);
			
			
			JButton boton2 = new JButton();
			boton2.setSize(0, 0);
			boton2.setText("que no pasa");
			contenedor.add(boton2);
			
			ventana.setVisible(true);
			
			JPanel panel = new JPanel();
			GridLayout layoutprimero = new GridLayout(1,2);
			panel.setLayout(layoutprimero);
			
			contenedor.add(panel);
			
			for (int contador = 0; contador < 5; contador++) {
				
			
				JButton boton3 = new JButton();
				boton3.setSize(0, 0);
				boton3.setText("Boton" + contador);
				contenedor.add(boton3);
				
			}
			
			for (int contador = 0; contador < 2; contador++) {
				
				
				JButton botonn = new JButton();
				panel.add(botonn);
				botonn.setText("Prueba");
				
			}
		}


		
	
}
