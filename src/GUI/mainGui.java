package GUI;

import model.CellularAlgorithm;
import model.Wind;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.awt.*;

/**
 * Główna klasa projektu,
 * zawiera wszystkie komponenty, odpowiada za GUI
 */
public class mainGui extends JFrame{

	private static final long serialVersionUID = 1L;
	private CellularAlgorithm cellularAlgorithm;
	private static double windRatio; 	//współczynnik poziomy i pionowy wiatru
	String xDir;
	String yDir;
	String windPow;
	static double thickness=2;
	double [][]shore;
	double [][] temp = new double[700][570];
	static double[][] actualBoard = new double[708][578];
	static double[][] poprzednia = new double[700][570];
	static byte[][] table;
	private Wind wind;
	private JPanel buttonPanel;
	private JPanel windPanel;
	private JButton okButton;
	private JEditorPane jEditorPane1;
	private JLabel windLabel;
	private JLabel wspLabel;
	private JLabel powerLabel;
	private JPanel jmainGui;
	private JScrollPane jScrollPane2;
	private JTextField powerTextField;
	private JPanel titlePanel;
	private JLabel title;
	private ResultsPanel resultsPanel;
	private JButton startButton;
	private JButton stopButton;
	private JLabel xLabel;
	private JLabel yLabel;
	private JTextField wspXTextField;
	private JTextField wspYTextField;
	private JLabel wspParowaniaLabel;
	private JTextField wspParowaniaField;

	private JTextField powerTextFieldPrad;
	private JTextField wspXTextFieldPrad;
	private JTextField wspYTextFieldPrad;
	private JLabel powerLabelPrad;
	private JLabel windLabelPrad;
	private JLabel xLabelPrad;
	private JLabel yLabelPrad;
	private JButton okButtonPrad;
	private JLabel wspLabelPrad;
	private JPanel pradPanel;

	private JLabel wspLabel1;
	private JLabel xLabel1;
	private JTextField startX;
	private JLabel yLabel1;
	private JTextField endX;
	private JLabel wspLabel2;
	private JLabel xLabel2;
	private JTextField startY;
	private JTextField endY;
	private JLabel yLabel2;
	private boolean stop;
	private Color colorBackground;
	private Color colorButtonBackground;
	private Color colorForeground;
	private Color colorLineBorder;
	private Color colorMatteBorder;
	Random generator = new Random();


	/**
	 * Konstruktor, inicjalizacja componwntów
	 */
	public mainGui() {
		initRatios();
		initComponents();
	}

	/**
	 * Inicjalizacja współczynników, i danych do modelu matematycznego
	 */
	public void initRatios() {
		xDir = "2";
		yDir = "3";
		windPow = "10";
		setWindRatio(0.03);
	}


	/**
	 * Funkcja, która tworzy obiekty, nadaje im początkowy stan
	 * i określa parametry GUI - odpowiada za wygląd komponentów
	 */
	private void initComponents() {

		table = new byte[700][570];
		jmainGui = new JPanel();
		titlePanel = new JPanel();
		title = new JLabel();
		buttonPanel = new JPanel();
		startButton = new JButton();
		stopButton = new JButton();
		windPanel = new JPanel();
		windLabel = new JLabel();
		wspLabel = new JLabel();
		powerLabel = new JLabel();
		powerTextField = new JTextField();
		okButton = new JButton();
		resultsPanel = new ResultsPanel();
		jScrollPane2 = new JScrollPane();
		jEditorPane1 = new JEditorPane();
		xLabel = new JLabel();
		yLabel = new JLabel();
		wspXTextField = new JTextField();
		wspYTextField = new JTextField();
		wspParowaniaLabel = new JLabel();
		wspParowaniaField = new JTextField();

		pradPanel = new JPanel();
		powerTextFieldPrad = new JTextField();
		wspXTextFieldPrad = new JTextField();;
		wspYTextFieldPrad = new JTextField();;
		powerLabelPrad = new JLabel();;
		windLabelPrad = new JLabel();
		xLabelPrad = new JLabel();
		yLabelPrad = new JLabel();
		okButtonPrad = new JButton();
		wspLabelPrad = new JLabel();

		wspLabel1 = new JLabel();
		xLabel1 = new JLabel();
		startX = new JTextField();
		yLabel1 = new JLabel();
		endX = new JTextField();
		wspLabel2 = new JLabel();
		xLabel2 = new JLabel();
		startY = new JTextField();
		endY = new JTextField();
		yLabel2 = new JLabel();
		colorBackground = new Color(95, 155, 228);
		colorButtonBackground = new Color(237, 254, 201);
		colorForeground = new Color(2, 9, 126);
		colorLineBorder = new Color(3, 6, 176);
		colorMatteBorder = new Color(1, 7, 110);
		stop = false;

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Rozprzestrzenianie sie zanieczyszczen");
		setAutoRequestFocus(false);
		setBackground(new Color(92, 117, 223));
		setBounds(new Rectangle(10, 10, 10, 10));
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		setForeground(new Color(222, 74, 74));

		jmainGui.setBackground(new Color(166, 230, 239));

		titlePanel.setBackground(colorBackground);
		titlePanel.setBorder(BorderFactory.createMatteBorder(10, 2, 10, 2, colorMatteBorder));
		titlePanel.setForeground(new Color(20, 18, 84));
		titlePanel.setToolTipText("");

		title.setFont(new Font("LM Mono Caps 10", 1, 24)); 
		title.setForeground(new Color(11, 11, 67));
		title.setText("Symulacja rozprzestrzeniania się ropy naftowej na wodzie");

		GroupLayout titlePanelLayout = new GroupLayout(titlePanel);
		titlePanel.setLayout(titlePanelLayout);
		titlePanelLayout.setHorizontalGroup(
				titlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(titlePanelLayout.createSequentialGroup()
						.addGap(34, 34, 34)
						.addComponent(title)
						.addContainerGap(59, Short.MAX_VALUE))
				);
		titlePanelLayout.setVerticalGroup(
				titlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(title, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);

		buttonPanel.setBackground(colorBackground);
		buttonPanel.setBorder(BorderFactory.createMatteBorder(8, 2, 8, 2, colorMatteBorder));
		buttonPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));

			startButton.setBackground(colorButtonBackground);
		startButton.setFont(new Font("Droid Sans", 0, 18)); 
		startButton.setForeground(colorForeground);
		startButton.setText("START");
		startButton.setBorder(BorderFactory.createMatteBorder(5, 2, 5, 2, colorMatteBorder));
		startButton.setMaximumSize(new Dimension(80, 34));
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					startButtonActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		stopButton.setBackground(colorButtonBackground);
		stopButton.setFont(new Font("Droid Sans", 0, 18)); 
		stopButton.setForeground(colorForeground);
		stopButton.setText("STOP");
		stopButton.setBorder(BorderFactory.createMatteBorder(5, 2, 5, 2, colorMatteBorder));
		stopButton.setMaximumSize(new Dimension(80, 34));
		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				stopButtonActionPerformed(evt);
			}
		});

		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				okButtonActionPerformed(evt);
			}
		});

		windPanel.setBackground(colorBackground);
		windPanel.setBorder(BorderFactory.createMatteBorder(4, 1, 4, 1, colorLineBorder));
		windPanel.setForeground(colorLineBorder);
		windPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));

		windLabel.setBackground(new Color(214, 114, 14));
		windLabel.setFont(new Font("Ubuntu", 1, 15)); // NOI18N
		windLabel.setForeground(colorForeground);
		windLabel.setHorizontalAlignment(SwingConstants.CENTER);
		windLabel.setText("  WIATR");

		wspLabel.setForeground(colorForeground);
		wspLabel.setText("   Podaj współrzędne");

		wspYTextField.setBorder(BorderFactory.createLineBorder(colorLineBorder));
		wspXTextField.setBorder(BorderFactory.createLineBorder(colorLineBorder));

		powerLabel.setForeground(colorForeground);
		powerLabel.setText(" Podaj siłę");

		powerTextField.setBorder(BorderFactory.createLineBorder(colorLineBorder));

		okButton.setForeground(colorForeground);
		okButton.setText("OK");

		xLabel.setForeground(colorForeground);
		xLabel.setText("Y:");

		yLabel.setForeground(colorForeground);
		yLabel.setText("X:");

		wspYTextField.setBorder(BorderFactory.createLineBorder(colorLineBorder));
		wspYTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

			}
		});


		GroupLayout windPanelLayout = new GroupLayout(windPanel);
		windPanel.setLayout(windPanelLayout);
		windPanelLayout.setHorizontalGroup(
				windPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(windPanelLayout.createSequentialGroup()
						.addGap(4, 4, 4)
						.addGroup(windPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(wspLabel)
								.addGroup(windPanelLayout.createSequentialGroup()
										.addGap(20, 20, 20)
										.addComponent(windLabel, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))))
										.addGroup(windPanelLayout.createSequentialGroup()
												.addGap(25, 25, 25)
												.addGroup(windPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addComponent(okButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
														.addComponent(powerTextField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
														.addGroup(windPanelLayout.createSequentialGroup()
																.addContainerGap()
																.addComponent(yLabel)
																.addGroup(windPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
																		.addGroup(windPanelLayout.createSequentialGroup()
																				.addGap(24, 24, 24)
																				.addComponent(powerLabel)
																				.addGap(0, 0, Short.MAX_VALUE))
																				.addGroup(windPanelLayout.createSequentialGroup()
																						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																						.addComponent(wspYTextField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
																						.addGap(38, 38, 38)
																						.addComponent(xLabel)
																						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																						.addComponent(wspXTextField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
																						.addContainerGap())))
				);
		windPanelLayout.setVerticalGroup(
				windPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(windPanelLayout.createSequentialGroup()
						.addComponent(windLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(wspLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(windPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(wspYTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(yLabel)
								.addComponent(xLabel)
								.addComponent(wspXTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(powerLabel)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(powerTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(okButton, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addGap(10, 10, 10))
				);


		pradPanel.setBackground(colorBackground);
		pradPanel.setBorder(BorderFactory.createMatteBorder(4, 1, 4, 1, colorLineBorder));
		pradPanel.setForeground(colorLineBorder);
		pradPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));

		windLabelPrad.setBackground(new Color(214, 114, 14));
		windLabelPrad.setFont(new Font("Ubuntu", 1, 15)); // NOI18N
		windLabelPrad.setForeground(colorForeground);
		windLabelPrad.setHorizontalAlignment(SwingConstants.CENTER);
		windLabelPrad.setText("   PRĄD");

		wspLabelPrad.setForeground(colorForeground);
		wspLabelPrad.setText("   Podaj współrzędne");

		wspYTextFieldPrad.setBorder(BorderFactory.createLineBorder(colorLineBorder));
		wspXTextFieldPrad.setBorder(BorderFactory.createLineBorder(colorLineBorder));

		powerLabelPrad.setForeground(colorForeground);
		powerLabelPrad.setText(" Podaj siłę");

		powerTextFieldPrad.setBorder(BorderFactory.createLineBorder(colorLineBorder));


		okButtonPrad.setForeground(colorForeground);
		okButtonPrad.setText("OK");

		xLabelPrad.setForeground(colorForeground);
		xLabelPrad.setText("X:");

		yLabelPrad.setForeground(colorForeground);
		yLabelPrad.setText("Y:");

		wspYTextFieldPrad.setBorder(BorderFactory.createLineBorder(colorLineBorder));

		wspLabel1.setForeground(colorForeground);
		wspLabel1.setText("Określ długość geo.");

		xLabel1.setForeground(colorForeground);
		xLabel1.setText("Y1");

		startX.setBorder(BorderFactory.createLineBorder(colorLineBorder));

		yLabel1.setForeground(colorForeground);
		yLabel1.setText("Y2");

		startY.setBorder(BorderFactory.createLineBorder(colorLineBorder));

		wspLabel2.setForeground(colorForeground);
		wspLabel2.setText("Określ szerokość geo.");

		xLabel2.setForeground(colorForeground);
		xLabel2.setText("X1");

		endX.setBorder(BorderFactory.createLineBorder(colorLineBorder));

		yLabel2.setForeground(colorForeground);
		yLabel2.setText("X2");

		endY.setBorder(BorderFactory.createLineBorder(colorLineBorder));

		wspXTextField.setText("-1");
		wspYTextField.setText("0");

		wspXTextFieldPrad.setText("-1");
		wspYTextFieldPrad.setText("0");

		powerTextField.setText("10");
		powerTextFieldPrad.setText("700");

		startX.setText("350");
		endX.setText("450");

		startY.setText("1");
		endY.setText("699");


		GroupLayout pradPanelLayout = new GroupLayout(pradPanel);
		pradPanel.setLayout(pradPanelLayout);
		pradPanelLayout.setHorizontalGroup(
				pradPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pradPanelLayout.createSequentialGroup()
						.addGroup(pradPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(pradPanelLayout.createSequentialGroup()
										.addGap(48, 48, 48)
										.addComponent(powerLabelPrad))
										.addGroup(pradPanelLayout.createSequentialGroup()
												.addContainerGap()
												.addComponent(xLabel1)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(startX, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
												.addGap(35, 35, 35)
												.addComponent(yLabel1)
												.addGap(8, 8, 8)
												.addComponent(endX, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
												.addGap(0, 0, Short.MAX_VALUE))
												.addGroup(pradPanelLayout.createSequentialGroup()
														.addGroup(pradPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
																.addGroup(pradPanelLayout.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(xLabelPrad)
																		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(wspXTextFieldPrad, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
																		.addGap(38, 38, 38)
																		.addComponent(yLabelPrad)
																		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																		.addComponent(wspYTextFieldPrad, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
																		.addGroup(pradPanelLayout.createSequentialGroup()
																				.addGroup(pradPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
																						.addGroup(pradPanelLayout.createSequentialGroup()
																								.addGap(4, 4, 4)
																								.addGroup(pradPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
																										.addComponent(wspLabelPrad)
																										.addGroup(pradPanelLayout.createSequentialGroup()
																												.addGap(23, 23, 23)
																												.addComponent(windLabelPrad, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))))
																												.addGroup(pradPanelLayout.createSequentialGroup()
																														.addGap(31, 31, 31)
																														.addComponent(powerTextFieldPrad, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
																														.addGap(0, 10, Short.MAX_VALUE))
																														.addGroup(pradPanelLayout.createSequentialGroup()
																																.addGroup(pradPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
																																		.addGroup(pradPanelLayout.createSequentialGroup()
																																				.addContainerGap()
																																				.addGroup(pradPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
																																						.addComponent(wspLabel1)
																																						.addGroup(pradPanelLayout.createSequentialGroup()
																																								.addComponent(xLabel2)
																																								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																																								.addComponent(startY, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
																																								.addGap(35, 35, 35)
																																								.addComponent(yLabel2)
																																								.addGap(8, 8, 8)
																																								.addComponent(endY, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))))
																																								.addGroup(pradPanelLayout.createSequentialGroup()
																																										.addGap(28, 28, 28)
																																										.addComponent(okButtonPrad, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
																																										.addGap(0, 0, Short.MAX_VALUE)))
																																										.addContainerGap())
																																										.addGroup(pradPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
																																												.addGroup(pradPanelLayout.createSequentialGroup()
																																														.addGap(2, 2, 2)
																																														.addComponent(wspLabel2)
																																														.addContainerGap(22, Short.MAX_VALUE)))
				);

		pradPanelLayout.setVerticalGroup(
				pradPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pradPanelLayout.createSequentialGroup()
						.addComponent(windLabelPrad, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(wspLabelPrad, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pradPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(wspXTextFieldPrad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(yLabelPrad)
								.addComponent(wspYTextFieldPrad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(xLabelPrad))
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(powerLabelPrad)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(powerTextFieldPrad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(40, 40, 40)
								.addGroup(pradPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(xLabel1)
										.addComponent(startX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(yLabel1)
										.addComponent(endX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addComponent(wspLabel1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(pradPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(xLabel2)
												.addComponent(startY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(yLabel2)
												.addComponent(endY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
												.addComponent(okButtonPrad, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
												.addContainerGap())
												.addGroup(pradPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addGroup(GroupLayout.Alignment.TRAILING, pradPanelLayout.createSequentialGroup()
																.addContainerGap(152, Short.MAX_VALUE)
																.addComponent(wspLabel2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
																.addGap(118, 118, 118)))
				);


		wspParowaniaLabel.setForeground(colorForeground);
		wspParowaniaLabel.setText("Wsp. parowania:");

		wspParowaniaField.setText("0.003");

		GroupLayout buttonPanelLayout = new GroupLayout(buttonPanel);
		buttonPanel.setLayout(buttonPanelLayout);
		buttonPanelLayout.setHorizontalGroup(
				buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(buttonPanelLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(buttonPanelLayout.createSequentialGroup()
										.addComponent(startButton, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
										.addComponent(stopButton, 60,76,76))
										.addComponent(windPanel, 150,153, 153)
										.addComponent(pradPanel, 140,153,153)
										.addGroup(buttonPanelLayout.createSequentialGroup()
												.addComponent(wspParowaniaLabel)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(wspParowaniaField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(2,2,2))))
				);
		buttonPanelLayout.setVerticalGroup(
				buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(buttonPanelLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(startButton, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
								.addComponent(stopButton, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(windPanel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
								.addGap(2, 2, 2)
								.addComponent(pradPanel, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
								.addGap(4, 4, 4)
								.addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(wspParowaniaLabel)
										.addComponent(wspParowaniaField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				);

		resultsPanel.setBackground(colorBackground);
		resultsPanel.setBorder(BorderFactory.createMatteBorder(8, 2, 8, 2, colorMatteBorder));

		jScrollPane2.setViewportView(jEditorPane1);

		GroupLayout resultsPanelLayout = new GroupLayout(resultsPanel);
		resultsPanel.setLayout(resultsPanelLayout);
		GroupLayout jmainGuiLayout = new GroupLayout(jmainGui);
		jmainGui.setLayout(jmainGuiLayout);
		jmainGuiLayout.setHorizontalGroup(
				jmainGuiLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jmainGuiLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jmainGuiLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(titlePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(jmainGuiLayout.createSequentialGroup()
										.addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(resultsPanel, 706, 706, 706)))
										.addContainerGap())
				);
		jmainGuiLayout.setVerticalGroup(
				jmainGuiLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jmainGuiLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jmainGuiLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(resultsPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(buttonPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 470))
								.addContainerGap())
				);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jmainGui, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jmainGui, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);

		pack();
	}


	/**
	 * Funkcja uruchamiająca symulację
	 * @param evt wciśnięcie prycisku "Start"
	 * @throws IOException
	 */
	private void startButtonActionPerformed(ActionEvent evt) throws IOException {

		/**
		 * String określający planszę, na któ©ej wykonywana jest symulacja
		 */
		String sciezka = "plansza256.bmp";
		//String sciezka = "trojkat.bmp";
		shore=readShore(sciezka);

		cellularAlgorithm = new CellularAlgorithm(this);
		cellularAlgorithm.setRatiosInCurrentNeighborhood(-Double.parseDouble(wspYTextFieldPrad.getText()), Double.parseDouble(wspXTextFieldPrad.getText()), Double.parseDouble(powerTextFieldPrad.getText()));

		new Thread() {
			@Override
			public void run() {
				resultsPanel.draw(shore,shore);
				int t = 0;
				while(t<1000 && !stop){
					if(t<500){
						cellularAlgorithm.addMoreOil();			// dolewanie oleju
					}
					if (t==500)
						try {
							resultsPanel.saveTableToFile(actualBoard);			//zapis satnu planszy do pliku
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}	

					cellularAlgorithm.windEffect(shore);						// uwzględnienie brzegów
					cellularAlgorithm.evaporation(Double.parseDouble(wspParowaniaField.getText()));
					cellularAlgorithm.seaCurrents(Integer.parseInt(startX.getText()),            // uwzględnienie prądów morskich o parametrach podanych przez użytkownika
                            Integer.parseInt(endX.getText()),
                            Integer.parseInt(startY.getText()),
                            Integer.parseInt(endY.getText()), shore);
					resultsPanel.draw(actualBoard,shore);						// rysowanie
					t++;
				}
				resultsPanel.draw(actualBoard,shore);
			}
		}.start();
	}

	
	/**
	 * Funkja zatrzymująca symulację
	 * @param evt wciśnięcie przycisku "STOP"
	 */
	private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {
		new Thread() {
			@Override
			public void run() {
				stop = !stop;
				// STATYSTYKI
				statsGui.mainStats();
			}
		}.start();
	}


	/**
	 * Funkcja zapisująca ustawione parametry wiatru
	 * @param evt
	 */
	private void okButtonActionPerformed(ActionEvent evt) {
		wind = new Wind(-Double.parseDouble(wspXTextField.getText()), Double.parseDouble(wspYTextField.getText()), Integer.parseInt(powerTextField.getText()));
	}


	/**
	 * Funkcja główna programu, uruchamia aplickację w nowym wątku
	 * @param args
	 */
	public static void main(String args[]) {

		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(mainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(mainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(mainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(mainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}


		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new mainGui().setVisible(true);
			}
		});
	}


	/**
	 * Funkcja wczytujaca brzeg z podanego pliku
	 * @param path	ścieżka, pod którą jest plik
	 * @return	tablica wypełniona wartościami określającymi brzeg/wodę
	 */
	static double [][] readShore(String path) throws IOException {
		String sciezka = path;
		BufferedImage img = ImageIO.read(new File(sciezka));

		double[][] pixels = new double[708][578];

		for(int i=0; i<703; i++){
			for(int j=0; j<570; j++){
				pixels[i][j] = 0;
			}
		}

		int wart = 0;
		for (int w = 2; w < 703; w++) {
			for (int k =2; k < 570; k++) {
				wart = img.getRGB(w, k);
				if (wart == -1) {
					pixels[w][k] = 0;
				} else if(wart>-10000000){			//plaza
					pixels[w][k] = -1;
				}    else {							//skaly
					pixels[w][k]=-2;
				}

			}
		}
		return pixels;
	}
	
	
	/*
	 * GETTERY i SETTERY
	 */
	public static double[][] getactualBoard() {
		return actualBoard;
	}

	public static void setactualBoard(double[][] actualBoard) {
		mainGui.actualBoard = actualBoard;
	}

	public static double getWindRatio() {
		return windRatio;
	}

	public static void setWindRatio(double windRatio) {
		mainGui.windRatio = windRatio;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}
}
