package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.DefaultKeyboardFocusManager;
import java.awt.event.ActionEvent;

public class ventanaMasaCorporal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfAltura;
	private JTextField tfPeso;
	private JTextField tfIMC;

	public ventanaMasaCorporal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 215);
		setTitle("Índice de masa corporal");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label1 = new JLabel("Altura (metros)");
		label1.setHorizontalAlignment(SwingConstants.LEFT);
		label1.setBounds(35, 20, 93, 28);
		contentPane.add(label1);

		JLabel label2 = new JLabel("Peso (kg)");
		label2.setHorizontalAlignment(SwingConstants.LEFT);
		label2.setBounds(247, 20, 65, 28);
		contentPane.add(label2);

		tfAltura = new JTextField();
		tfAltura.setBounds(126, 24, 65, 20);
		contentPane.add(tfAltura);
		tfAltura.setColumns(10);

		tfPeso = new JTextField();
		tfPeso.setBounds(311, 24, 65, 20);
		contentPane.add(tfPeso);
		tfPeso.setColumns(10);

		JButton button = new JButton("CALCULAR IMC");
		button.addActionListener(al);
		button.setBounds(161, 120, 124, 34);
		contentPane.add(button);

		JLabel labelIMC = new JLabel("IMC");
		labelIMC.setHorizontalAlignment(SwingConstants.RIGHT);
		labelIMC.setBounds(161, 68, 46, 32);
		contentPane.add(labelIMC);

		tfIMC = new JTextField();
		tfIMC.setEditable(false);
		tfIMC.setBounds(217, 74, 54, 20);
		contentPane.add(tfIMC);
		tfIMC.setColumns(10);

		setVisible(true);
	}

	ActionListener al = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			DecimalFormat d2 = new DecimalFormat("0.00");
			double imc = Double.parseDouble(tfPeso.getText()) / Math.pow(Double.parseDouble(tfAltura.getText()), 2);
			tfIMC.setText(d2.format(imc));
		}
	};
}
