package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ventanaInteraccion2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel label1 = new JLabel();
	private JLabel label2 = new JLabel();
	private int button1pressed = 0;
	private int button2pressed = 0;

	public ventanaInteraccion2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		setTitle("Ventana más interacción");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		label1.setText("BOTON 1: pulsado 0 veces");
		label1.setHorizontalAlignment(SwingConstants.LEFT);
		label1.setBounds(122, 21, 155, 28);
		contentPane.add(label1);

		label2.setText("BOTON 2: pulsado 0 veces");
		label2.setBounds(122, 60, 155, 23);
		contentPane.add(label2);

		JButton button1 = new JButton("BOTON 1");
		button1.addActionListener(buttonPress);
		button1.setBounds(68, 114, 89, 23);
		contentPane.add(button1);

		JButton button2 = new JButton("BOTON 2");
		button2.addActionListener(buttonPress);
		button2.setBounds(223, 114, 89, 23);
		contentPane.add(button2);

		setVisible(true);
	}

	ActionListener buttonPress = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "BOTON 1") {
				button1pressed++;
				label1.setText("BOTON 1: pulsado " + button1pressed + " veces");
			} else if (e.getActionCommand() == "BOTON 2") {
				button2pressed++;
				label2.setText("BOTON 2: pulsado " + button2pressed + " veces");
			}
		}
	};
}
