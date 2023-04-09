package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ventanaConversor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton buttonEurPes;
	private JTextField tfCantidad;
	private JTextField tfResultado;
	private boolean euroaPes = true;

	public ventanaConversor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		setTitle("Conversor Pesetas - Euros");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelCantidad = new JLabel("Cantidad a convertir");
		labelCantidad.setBounds(54, 23, 115, 21);
		contentPane.add(labelCantidad);

		JLabel labelResultado = new JLabel("Resultado");
		labelResultado.setBounds(241, 23, 58, 21);
		contentPane.add(labelResultado);

		buttonEurPes = new JButton("EUR > PES");
		buttonEurPes.addActionListener(aListener);
		buttonEurPes.setBounds(68, 98, 101, 28);
		contentPane.add(buttonEurPes);

		JButton buttonCambio = new JButton("CAMBIAR");
		buttonCambio.addActionListener(cambioListener);
		buttonCambio.setBounds(241, 98, 89, 28);
		contentPane.add(buttonCambio);
		
		tfCantidad = new JTextField();
		tfCantidad.setBounds(83, 55, 86, 20);
		contentPane.add(tfCantidad);
		tfCantidad.setColumns(10);
		
		tfResultado = new JTextField();
		tfResultado.setEditable(false);
		tfResultado.setBounds(241, 55, 86, 20);
		contentPane.add(tfResultado);
		tfResultado.setColumns(10);

		setVisible(true);
	}

	ActionListener aListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			euroaPes = !euroaPes;
			if (euroaPes) {
				buttonEurPes.setText("EUR > PES");
			} else {
				buttonEurPes.setText("PES > EUR");
			}
		}
	};

	ActionListener cambioListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			DecimalFormat d2 = new DecimalFormat("0.00");
			double res = 0.0;
			if (euroaPes) {
				res = Double.parseDouble(tfCantidad.getText()) * 166.386;
			} else {
				res = Double.parseDouble(tfCantidad.getText()) / 166.386;
			}
			tfResultado.setText(d2.format(res));
		}
	};

}
