package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ventanaInteraccion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel label1 = new JLabel();

	public ventanaInteraccion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		setTitle("Ventana interacción");
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label1.setText("Has pulsado:");
		label1.setHorizontalAlignment(SwingConstants.LEFT);
		label1.setBounds(128, 31, 128, 28);
		contentPane.add(label1);
		
		JButton button1 = new JButton("BOTON 1");
		button1.addActionListener(buttonPress);
		button1.setBounds(68, 90, 89, 23);
		contentPane.add(button1);
		
		JButton button2 = new JButton("BOTON 2");
		button2.addActionListener(buttonPress);
		button2.setBounds(225, 90, 89, 23);
		contentPane.add(button2);
		
		setVisible(true);
	}
	
	ActionListener buttonPress = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand() == "BOTON 1") {
				label1.setText("Has pulsado: BOTON 1");
			}
			else if(e.getActionCommand() == "BOTON 2") {
				label1.setText("Has pulsado: BOTON 2");
			} 
		}
	};
}
