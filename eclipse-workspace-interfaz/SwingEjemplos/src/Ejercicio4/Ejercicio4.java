package Ejercicio4;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Ejercicio4 {

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

				JLTexto.setText("Has hecho click en boton: " + botonOrigen.getText());

			}
		};
		MouseListener MListener = new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				JButton botonOrigen = (JButton) e.getSource();
				botonOrigen.setBackground(null);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				JButton botonOrigen = (JButton) e.getSource();
				botonOrigen.setBackground(Color.red);
				
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				
				JButton botonClick = (JButton) e.getSource();
				botonClick.setText(botonClick.getText() + "!");
			

			}
		};

		JButton boton1 = new JButton();
		boton1.setActionCommand("Botón 1");
		boton1.addActionListener(listenerBotones);
		boton1.setText("1");
		boton1.addMouseListener(MListener);
		contenedor.add(boton1);

		JButton boton2 = new JButton();
		boton2.setActionCommand("Botón 2");
		boton2.addActionListener(listenerBotones);
		boton2.addMouseListener(MListener);
		boton2.setText("2");
		contenedor.add(boton2);

		JButton boton3 = new JButton();
		boton3.setActionCommand("Botón 3");
		boton3.addMouseListener(MListener);
		boton3.addActionListener(listenerBotones);
		boton3.setText("3");
		contenedor.add(boton3);

		JLTexto.setText("¿En que boton haces click?");
		contenedor.add(JLTexto);

		
	

		ventana.setVisible(true);
	}

}
