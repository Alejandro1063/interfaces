package Ejercicio3;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ejercicio3 {

	public static void main(String[] args) {

		JFrame ventana = new JFrame();
		ventana.setSize(400, 400);
		ventana.setTitle("Ejercicio");
		ventana.setLocationRelativeTo(null); // Posición centrada
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ventana.getContentPane();

		Container contenedor = ventana.getContentPane();
		GridLayout layout = new GridLayout(4, 1);
		JLabel JLTexto = new JLabel();
		ventana.setLayout(layout);
		
		ActionListener listenerBotones = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton botonOrigen = (JButton) e.getSource();
				
				
				JLTexto.setText ("Has hecho click en boton: " + botonOrigen.getText());
			}
		};
		
		
		JButton boton1 = new JButton();
		boton1.setActionCommand("Botón 1" );
		boton1.addActionListener(listenerBotones);
		boton1.setText("1");
		contenedor.add(boton1);

		JButton boton2 = new JButton();
		boton1.setActionCommand("Botón 2" );
		boton2.addActionListener(listenerBotones);
		boton2.setText("2");
		contenedor.add(boton2);

		JButton boton3 = new JButton();
		boton1.setActionCommand("Botón 3" );
		boton3.addActionListener(listenerBotones);
		boton3.setText("3");
		contenedor.add(boton3);

		
		JLTexto.setText("¿En que boton haces click?");
		contenedor.add(JLTexto);
		
		
		ventana.setVisible(true);
	}

}
