package vistas;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class vistaMemory extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	// -----------------------------------------------------------------------------------
	private Font pixelFont;
	private Font pixelSizeFont;

	// -----------------------------------------------------------------------------------
	private ArrayList<JToggleButton> botones = new ArrayList<>();
	private JToggleButton butSel1;
	private JToggleButton butSel2;
	private int botonesRestantes;

	// -----------------------------------------------------------------------------------
	private int intentos;
	private JLabel labelIntentos;

	// Iconos que se usan en los botones
	private ImageIcon iconBack = new ImageIcon("icons/back.png");
	private ImageIcon icon1 = new ImageIcon("icons/icon1.png");
	private ImageIcon icon2 = new ImageIcon("icons/icon2.png");
	private ImageIcon icon3 = new ImageIcon("icons/icon3.png");
	private ImageIcon icon4 = new ImageIcon("icons/icon4.png");
	private ImageIcon icon5 = new ImageIcon("icons/icon5.png");
	private ImageIcon icon6 = new ImageIcon("icons/icon6.png");
	private ImageIcon icon7 = new ImageIcon("icons/icon7.png");
	private ImageIcon icon8 = new ImageIcon("icons/icon8.png");

	public vistaMemory() {
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

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 762);
		setTitle("Mario's Memory");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		intentos = 0;
		labelIntentos = new JLabel("INTENTOS: " + intentos);
		labelIntentos.setHorizontalAlignment(SwingConstants.CENTER);
		labelIntentos.setBounds(170, 8, 354, 25);
		contentPane.add(labelIntentos);
		labelIntentos.setFont(pixelSizeFont);

		// Crea los botones y les assigna la posicion
		JToggleButton button1 = new JToggleButton("");
		button1.setBounds(10, 40, 160, 160);
		contentPane.add(button1);

		JToggleButton button2 = new JToggleButton("");
		button2.setBounds(180, 40, 160, 160);
		contentPane.add(button2);

		JToggleButton button3 = new JToggleButton("");
		button3.setBounds(350, 40, 160, 160);
		contentPane.add(button3);

		JToggleButton button4 = new JToggleButton("");
		button4.setBounds(520, 40, 160, 160);
		contentPane.add(button4);

		JToggleButton button5 = new JToggleButton("");
		button5.setBounds(10, 211, 160, 160);
		contentPane.add(button5);

		JToggleButton button6 = new JToggleButton("");
		button6.setBounds(180, 211, 160, 160);
		contentPane.add(button6);

		JToggleButton button7 = new JToggleButton("");
		button7.setBounds(350, 211, 160, 160);
		contentPane.add(button7);

		JToggleButton button8 = new JToggleButton("");
		button8.setBounds(520, 211, 160, 160);
		contentPane.add(button8);

		JToggleButton button9 = new JToggleButton("");
		button9.setBounds(10, 382, 160, 160);
		contentPane.add(button9);

		JToggleButton button10 = new JToggleButton("");
		button10.setBounds(180, 382, 160, 160);
		contentPane.add(button10);

		JToggleButton button11 = new JToggleButton("");
		button11.setBounds(350, 382, 160, 160);
		contentPane.add(button11);

		JToggleButton button12 = new JToggleButton("");
		button12.setBounds(520, 382, 160, 160);
		contentPane.add(button12);

		JToggleButton button13 = new JToggleButton("");
		button13.setBounds(10, 553, 160, 160);
		contentPane.add(button13);

		JToggleButton button14 = new JToggleButton("");
		button14.setBounds(180, 553, 160, 160);
		contentPane.add(button14);

		JToggleButton button15 = new JToggleButton("");
		button15.setBounds(350, 553, 160, 160);
		contentPane.add(button15);

		JToggleButton button16 = new JToggleButton("");
		button16.setBounds(520, 553, 160, 160);
		contentPane.add(button16);

		// Añade los botones al arraylist "buttons"
		botones.add(button1);
		botones.add(button2);
		botones.add(button3);
		botones.add(button4);
		botones.add(button5);
		botones.add(button6);
		botones.add(button7);
		botones.add(button8);
		botones.add(button9);
		botones.add(button10);
		botones.add(button11);
		botones.add(button12);
		botones.add(button13);
		botones.add(button14);
		botones.add(button15);
		botones.add(button16);

		botonesRestantes = botones.size();

		// Assigna el borde sin pintar y el icono a cada botón
		for (int i = 0; i < botones.size(); i++) {
			botones.get(i).setEnabled(false);
			botones.get(i).setBorderPainted(false);
			botones.get(i).setIcon(iconBack);
			botones.get(i).setDisabledIcon(iconBack);
			botones.get(i).addMouseListener(mouseList);
			botones.get(i).setName(Integer.toString(i));
		}
		setIcons();
		setVisible(true);
	}

	/*
	 * 
	 */
	MouseAdapter mouseList = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			JToggleButton jtb = (JToggleButton) e.getSource();

			// Ningun boton seleccionado
			if (butSel1 == null) {
				butSel1 = jtb;
				butSel1.setSelected(true);
			}
			// Un boton seleccionado
			else if (butSel1 != null && butSel2 == null) {
				butSel2 = jtb;
				butSel2.setSelected(true);
			}
			// Dos botones seleccionados
			else if (butSel1 != null && butSel2 != null) {
				checkSameIcon(butSel1, butSel2);
			}
		}
	};

	/*
	 * 
	 */
	public void sumaIntento() {
		intentos++;
		labelIntentos.setText("INTENTOS: " + intentos);
	}

	/*
	 * 
	 */
	public void checkSameIcon(JToggleButton b1, JToggleButton b2) {
		// Iconos iguales
		if (b1.getDisabledSelectedIcon() == b2.getDisabledSelectedIcon()) {
			butSel1.setEnabled(false);
			butSel2.setEnabled(false);
			butSel1.setVisible(false);
			butSel2.setVisible(false);
			botonesRestantes = botonesRestantes - 2;
		}
		// Iconos diferentes
		else {
			butSel1.setSelected(false);
			butSel2.setSelected(false);
		}
		butSel1 = null;
		butSel2 = null;
		sumaIntento();

		if (botonesRestantes <= 0) {
			vistaFinal vf = new vistaFinal(intentos);
		}
	}

	/*
	 * Assigna un icono a cada pareja de botones de manera aleatoria
	 */
	public void setIcons() {
		int num1, num2, cont = 1;
		ArrayList<Integer> positions = new ArrayList<>();

		for (int i = 0; i < 16; i++) {
			positions.add(i + 1);
		}

		Collections.shuffle(positions);

		do {
			num1 = positions.get(0);
			positions.remove(0);

			num2 = positions.get(positions.size() - 1);
			positions.remove(positions.size() - 1);

			setIconButton(botones.get(num1 - 1), cont);
			setIconButton(botones.get(num2 - 1), cont);

			cont++;

		} while (positions.size() > 0);
	}

	/*
	 * Assigna un icono a un boton
	 */
	public void setIconButton(JToggleButton button, int icon) {
		switch (icon) {
		case 1:
			button.setDisabledSelectedIcon(icon1);
			break;
		case 2:
			button.setDisabledSelectedIcon(icon2);
			break;
		case 3:
			button.setDisabledSelectedIcon(icon3);
			break;
		case 4:
			button.setDisabledSelectedIcon(icon4);
			break;
		case 5:
			button.setDisabledSelectedIcon(icon5);
			break;
		case 6:
			button.setDisabledSelectedIcon(icon6);
			break;
		case 7:
			button.setDisabledSelectedIcon(icon7);
			break;
		case 8:
			button.setDisabledSelectedIcon(icon8);
			break;
		}
	}
}
