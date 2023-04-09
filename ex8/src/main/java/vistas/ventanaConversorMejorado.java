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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ventanaConversorMejorado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton buttonEurPes;
	private JButton buttonBorrar;
	private JTextField tfCantidad;
	private JTextField tfResultado;
	private boolean euroaPes = true;

	public ventanaConversorMejorado() {
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
		buttonEurPes.setBounds(38, 101, 101, 28);
		contentPane.add(buttonEurPes);
		buttonEurPes.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					buttonEurPes.doClick();
				}
			}
		});

		JButton buttonCambio = new JButton("CAMBIAR");
		buttonCambio.addActionListener(cambioListener);
		buttonCambio.setBounds(177, 101, 89, 28);
		contentPane.add(buttonCambio);
		buttonCambio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					buttonCambio.doClick();
				}
			}
		});

		tfCantidad = new JTextField();
		tfCantidad.setBounds(83, 55, 86, 20);
		contentPane.add(tfCantidad);
		tfCantidad.setColumns(10);

		tfResultado = new JTextField();
		tfResultado.setEditable(false);
		tfResultado.setBounds(241, 55, 86, 20);
		contentPane.add(tfResultado);
		tfResultado.setColumns(10);

		buttonBorrar = new JButton("BORRAR");
		buttonBorrar.addActionListener(borrarListener);
		buttonBorrar.setBounds(304, 101, 89, 28);
		contentPane.add(buttonBorrar);
		buttonBorrar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					buttonBorrar.doClick();
				}
			}
		});

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
			try {
				DecimalFormat d2 = new DecimalFormat("0.00");
				double res = 0.0;
				if (euroaPes) {
					res = Double.parseDouble(tfCantidad.getText()) * 166.386;
				} else {
					res = Double.parseDouble(tfCantidad.getText()) / 166.386;
				}
				tfResultado.setText(d2.format(res));
			} catch (Exception ex) {
				System.out.println("Error de formato (" + ex + ")");
				ventanaError ve = new ventanaError();
			}
		}
	};

	ActionListener borrarListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			tfCantidad.setText("");
			tfResultado.setText("");
		}
	};
}
