package Ejercicio6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MiActionListener implements ActionListener {
	
	private JFrame frame;
	private JTextField textoL;
	
	public MiActionListener( JFrame frameC, JTextField textoLC) {
	
		frame = frameC;
		textoL = textoLC;

		
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			if (textoL.getText().isEmpty()) {
				textoL.setText("1");
			}

			else
				textoL.setText((Integer.parseInt(textoL.getText()) + 1) + "");

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(frame, "No se admiten letras", "ERROR", JOptionPane.ERROR_MESSAGE);
			textoL.setText("");

		}
	};

};
