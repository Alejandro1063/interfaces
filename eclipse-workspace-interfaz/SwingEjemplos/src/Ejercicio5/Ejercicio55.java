package Ejercicio5;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Ejercicio55 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio55 window = new Ejercicio55();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ejercicio55() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnBotonSuma = new JButton("SUMAR");
		btnBotonSuma.setBounds(0, 0, 434, 92);
		frame.getContentPane().add(btnBotonSuma);
		
		JLabel labelpru = new JLabel("");
		labelpru.setHorizontalAlignment(SwingConstants.CENTER);
		labelpru.setBounds(10, 103, 424, 158);
		frame.getContentPane().add(labelpru);
	
	
	ActionListener listener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
		
			if (labelpru.getText().isEmpty()){
				labelpru.setText("1");
		}
			else
				labelpru.setText((Integer.parseInt(labelpru.getText())+1)+"");
			
	};

};
	btnBotonSuma.addActionListener(listener);
	}
}
