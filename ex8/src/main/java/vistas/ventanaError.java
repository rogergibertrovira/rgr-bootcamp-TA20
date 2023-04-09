package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ventanaError extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public ventanaError() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 400, 145);
		setTitle("ERROR FORMATO");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label2 = new JLabel("(Debe ser un número, puede contener decimales)");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setBounds(35, 51, 314, 14);
		contentPane.add(label2);

		JLabel lblFormatoDelValor = new JLabel("Formato del valor introducido incorrecto");
		lblFormatoDelValor.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormatoDelValor.setBounds(54, 26, 276, 14);
		contentPane.add(lblFormatoDelValor);

		setVisible(true);
	}

}
