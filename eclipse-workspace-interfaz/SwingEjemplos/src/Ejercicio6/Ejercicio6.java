package Ejercicio6;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Ejercicio6 {

	private JFrame frame;
	private JTextField textoL;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio6 window = new Ejercicio6();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Ejercicio6() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnBotonSuma = new JButton("SUMAR");
		btnBotonSuma.setBounds(0, 0, 434, 92);
		frame.getContentPane().add(btnBotonSuma);

		textoL = new JTextField();
		textoL.setBounds(48, 157, 324, 32);
		frame.getContentPane().add(textoL);
		textoL.setColumns(10);

		MiActionListener listener = new MiActionListener(frame,textoL);

		btnBotonSuma.addActionListener(listener);
	}
		}

