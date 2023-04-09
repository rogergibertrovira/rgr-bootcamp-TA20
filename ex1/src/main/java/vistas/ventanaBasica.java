package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ventanaBasica extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public ventanaBasica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Ventana controles basicos");
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label1 = new JLabel("Ventana con controles básicos");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(115, 116, 203, 28);
		contentPane.add(label1);
		
		setVisible(true);
	}

}
