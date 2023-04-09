package vistas;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class vistaFinal extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	// -----------------------------------------------------------------------------------
	private Font pixelFont;
	private Font pixelSizeFont;

	public vistaFinal(int intentos) {
		// -----------------------------------------------------------------------------------
		File fontFile = new File("font/PressStart2P.ttf");
		try {
			pixelFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			pixelSizeFont = pixelFont.deriveFont(18f);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// -----------------------------------------------------------------------------------
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelWin = new JLabel("YOU WIN!!");
		labelWin.setHorizontalAlignment(SwingConstants.CENTER);
		labelWin.setBounds(10, 39, 364, 30);
		contentPane.add(labelWin);
		labelWin.setFont(pixelSizeFont);

		JLabel labelIntentos = new JLabel("You needed " + intentos + " tries");
		labelIntentos.setHorizontalAlignment(SwingConstants.CENTER);
		labelIntentos.setBounds(10, 80, 364, 30);
		contentPane.add(labelIntentos);
		labelIntentos.setFont(pixelSizeFont);

		setVisible(true);
	}
}
