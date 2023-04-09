package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ventanaEventosRaton extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTextArea textArea = new JTextArea();

	public ventanaEventosRaton() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Ventana eventos ratón");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.addActionListener(aListener);
		btnLimpiar.setBounds(172, 11, 89, 23);
		contentPane.add(btnLimpiar);

		textArea.addMouseListener(ml);
		textArea.setBounds(20, 45, 394, 205);
		contentPane.add(textArea);

		setVisible(true);
	}

	ActionListener aListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			textArea.setText("");
		}
	};

	MouseAdapter ml = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			textArea.setText(textArea.getText() + "Ratón ha sido pulsado");
			switch (e.getButton()) {
			case 1:
				textArea.setText(textArea.getText() + ": botón izquierdo\n");
				break;
			case 2:
				textArea.setText(textArea.getText() + ": botón central\n");
				break;
			case 3:
				textArea.setText(textArea.getText() + ": botón derecho\n");
				break;
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			textArea.setText(textArea.getText() + "Ratón ha entrado en el componente\n");
		}

		@Override
		public void mouseExited(MouseEvent e) {
			textArea.setText(textArea.getText() + "Ratón ha salido del componente\n");
		}
	};
}
