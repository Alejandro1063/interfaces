package Ejercicio2;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ejercicio2 {

	public static void main(String[] args) {
		JFrame ventana = new JFrame();
		ventana.setSize(400, 200);
		ventana.setTitle("Añadir usuario");
		ventana.setLocationRelativeTo(null); // Posición centrada
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ventana.getContentPane();

		Container contenedor = ventana.getContentPane();
		GridLayout layout = new GridLayout(4, 2);

		ventana.setLayout(layout);

		
		JLabel nombre = new JLabel();
		nombre.setText("Nombre:");
		contenedor.add(nombre);
		
		JTextField relleno1 = new JTextField();
		contenedor.add(relleno1);
		
		JLabel dni = new JLabel();
		dni.setText("DNI:");
		contenedor.add(dni);
		
		JTextField relleno2 = new JTextField();
		contenedor.add(relleno2);
		
		
		JLabel fecha = new JLabel();
		fecha.setText("Fecha de nacimiento:");
		contenedor.add(fecha);
		
		
		
		
		JPanel panel = new JPanel();
		FlowLayout layoutprimero = new FlowLayout();
		panel.setLayout(layoutprimero);
		contenedor.add(panel);
		
		JTextField relleno3 = new JTextField(2);
		panel.add(relleno3);
		
		JLabel barra1 = new JLabel();
		barra1.setText("/");
		panel.add(barra1);
		
		JTextField relleno4 = new JTextField(2);
		panel.add(relleno4);
		
		JLabel barra2 = new JLabel();
		barra2.setText("/");
		panel.add(barra2);
		
		JTextField relleno5 = new JTextField(2);
		panel.add(relleno5);
		
		
		
		
		JButton boton1 = new JButton();
		boton1.setText("Aceptar");
		contenedor.add(boton1);

		
		JButton boton2 = new JButton();
		boton2.setText("Cancelar");
		contenedor.add(boton2);
		
		
		
		
		
		
		ventana.setVisible(true);

	}
}
