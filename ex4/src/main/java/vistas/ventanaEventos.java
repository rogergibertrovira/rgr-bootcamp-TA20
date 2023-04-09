package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowStateListener;
import javax.swing.JTextArea;

public class ventanaEventos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTextArea textArea = new JTextArea();

	public ventanaEventos() {
		addWindowStateListener(new WindowStateListener() {
			public void windowStateChanged(WindowEvent e) {
				if (e.getNewState() == 6) {
					System.out.println("Ventana a pantalla completa");
					textArea.setText(textArea.getText() + "\nVentana a pantalla completa");
				}
				else if(e.getOldState() == 6) {
					System.out.println("Ventana a pantalla completa");
					textArea.setText(textArea.getText() + "\nPantalla completa a ventana");
				}
			}
		});
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				System.out.println("Ventana maximizada");
				textArea.setText(textArea.getText() + "\nVentana maximizada");
			}

			public void windowLostFocus(WindowEvent e) {
				System.out.println("Ventana minimizada");
				textArea.setText(textArea.getText() + "\nVentana minimizada");
			}
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				System.out.println("Ventana abierta");
				textArea.setText(textArea.getText() + "\nVentana abierta");
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Ventana eventos");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label1 = new JLabel("Eventos");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(115, 17, 203, 28);
		contentPane.add(label1);

		textArea.setText("Texto prueba inicial");
		textArea.setBounds(16, 67, 401, 168);
		contentPane.add(textArea);

		setVisible(true);
	}
}
