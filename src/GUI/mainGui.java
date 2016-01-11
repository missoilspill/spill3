package GUI;

import model.CellularAlgorithm;
import model.Wind;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author dawid
 */
public class mainGui extends JFrame{

	CellularAlgorithm cellularAlgorithm;

	private static double windRatio; 	//współczynnik poziomy i pionowy wiatru
	String xDir;
	String yDir;
	String windPow;
	static double thickness=2;
    double [][]shore;
	double [][] temp = new double[700][570];
	static double[][] table2 = new double[708][578];
	static double[][] poprzednia = new double[700][570];
	static byte[][] table;
	private int wspParowania;
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
	private JButton enythingButton;
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



	Random generator = new Random();

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


	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		table = new byte[700][570];
		jmainGui = new JPanel();
		titlePanel = new JPanel();
		title = new JLabel();
		buttonPanel = new JPanel();
		enythingButton = new JButton();
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
		stop = false;

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Rozprzestrzenianie sie zanieczyszczen");
		setAutoRequestFocus(false);
		setBackground(new java.awt.Color(92, 117, 223));
		setBounds(new java.awt.Rectangle(10, 10, 10, 10));
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		setForeground(new java.awt.Color(222, 74, 74));

		jmainGui.setBackground(new java.awt.Color(166, 230, 239));

		titlePanel.setBackground(new java.awt.Color(95, 155, 228));
		titlePanel.setBorder(BorderFactory.createMatteBorder(10, 2, 10, 2, new java.awt.Color(1, 7, 110)));
		titlePanel.setForeground(new java.awt.Color(20, 18, 84));
		titlePanel.setToolTipText("");

		title.setFont(new java.awt.Font("LM Mono Caps 10", 1, 24)); // NOI18N
		title.setForeground(new java.awt.Color(11, 11, 67));
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

		buttonPanel.setBackground(new java.awt.Color(95, 155, 228));
		buttonPanel.setBorder(BorderFactory.createMatteBorder(8, 2, 8, 2, new java.awt.Color(1, 7, 110)));
		buttonPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		enythingButton.setBackground(new java.awt.Color(237, 254, 201));
		enythingButton.setFont(new java.awt.Font("Droid Sans", 0, 18)); // NOI18N
		enythingButton.setForeground(new java.awt.Color(2, 9, 126));
		enythingButton.setText("");
		enythingButton.setActionCommand("");
		enythingButton.setBorder(BorderFactory.createMatteBorder(5, 2, 5, 2, new java.awt.Color(1, 7, 110)));
		enythingButton.setMaximumSize(new java.awt.Dimension(170, 34));
		enythingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				enythingButtonActionPerformed(evt);
			}
		});

		startButton.setBackground(new java.awt.Color(237, 254, 201));
		startButton.setFont(new java.awt.Font("Droid Sans", 0, 18)); // NOI18N
		startButton.setForeground(new java.awt.Color(2, 9, 126));
		startButton.setText("START");
		startButton.setBorder(BorderFactory.createMatteBorder(5, 2, 5, 2, new java.awt.Color(1, 7, 110)));
		startButton.setMaximumSize(new java.awt.Dimension(80, 34));
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					startButtonActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		stopButton.setBackground(new java.awt.Color(237, 254, 201));
		stopButton.setFont(new java.awt.Font("Droid Sans", 0, 18)); // NOI18N
		stopButton.setForeground(new java.awt.Color(2, 9, 126));
		stopButton.setText("STOP");
		stopButton.setBorder(BorderFactory.createMatteBorder(5, 2, 5, 2, new java.awt.Color(1, 7, 110)));
		stopButton.setMaximumSize(new java.awt.Dimension(80, 34));
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

		windPanel.setBackground(new java.awt.Color(95, 155, 228));
		windPanel.setBorder(BorderFactory.createMatteBorder(4, 1, 4, 1, new java.awt.Color(3, 6, 176)));
		windPanel.setForeground(new java.awt.Color(3, 6, 176));
		windPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		windLabel.setBackground(new java.awt.Color(214, 114, 14));
		windLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
		windLabel.setForeground(new java.awt.Color(2, 9, 126));
		windLabel.setHorizontalAlignment(SwingConstants.CENTER);
		windLabel.setText("  WIATR");

		//   org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, titlePanel, org.jdesktop.beansbinding.ObjectProperty.create(), windLabel, org.jdesktop.beansbinding.BeanProperty.create("border"));
		//     bindingGroup.addBinding(binding);

		wspLabel.setForeground(new java.awt.Color(2, 9, 126));
		wspLabel.setText("   Podaj współrzędne");

		wspYTextField.setBorder(BorderFactory.createLineBorder(new java.awt.Color(3, 6, 176)));
		wspXTextField.setBorder(BorderFactory.createLineBorder(new java.awt.Color(3, 6, 176)));

		powerLabel.setForeground(new java.awt.Color(2, 9, 126));
		powerLabel.setText(" Podaj siłę");

		powerTextField.setBorder(BorderFactory.createLineBorder(new java.awt.Color(3, 6, 176)));


		okButton.setForeground(new java.awt.Color(2, 9, 126));
		okButton.setText("OK");




		xLabel.setForeground(new java.awt.Color(2, 9, 126));
		xLabel.setText("Y:");

		yLabel.setForeground(new java.awt.Color(2, 9, 126));
		yLabel.setText("X:");

		wspYTextField.setBorder(BorderFactory.createLineBorder(new java.awt.Color(3, 6, 176)));
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


		pradPanel.setBackground(new java.awt.Color(95, 155, 228));
		pradPanel.setBorder(BorderFactory.createMatteBorder(4, 1, 4, 1, new java.awt.Color(3, 6, 176)));
		pradPanel.setForeground(new java.awt.Color(3, 6, 176));
		pradPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		windLabelPrad.setBackground(new java.awt.Color(214, 114, 14));
		windLabelPrad.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
		windLabelPrad.setForeground(new java.awt.Color(2, 9, 126));
		windLabelPrad.setHorizontalAlignment(SwingConstants.CENTER);
		windLabelPrad.setText("   PRĄD");

		//   org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, titlePanel, org.jdesktop.beansbinding.ObjectProperty.create(), windLabel, org.jdesktop.beansbinding.BeanProperty.create("border"));
		//     bindingGroup.addBinding(binding);

		wspLabelPrad.setForeground(new java.awt.Color(2, 9, 126));
		wspLabelPrad.setText("   Podaj współrzędne");

		wspYTextFieldPrad.setBorder(BorderFactory.createLineBorder(new java.awt.Color(3, 6, 176)));
		wspXTextFieldPrad.setBorder(BorderFactory.createLineBorder(new java.awt.Color(3, 6, 176)));

		powerLabelPrad.setForeground(new java.awt.Color(2, 9, 126));
		powerLabelPrad.setText(" Podaj siłę");

		powerTextFieldPrad.setBorder(BorderFactory.createLineBorder(new java.awt.Color(3, 6, 176)));


		okButtonPrad.setForeground(new java.awt.Color(2, 9, 126));
		okButtonPrad.setText("OK");

		xLabelPrad.setForeground(new java.awt.Color(2, 9, 126));
		xLabelPrad.setText("X:");

		yLabelPrad.setForeground(new java.awt.Color(2, 9, 126));
		yLabelPrad.setText("Y:");

		wspYTextFieldPrad.setBorder(BorderFactory.createLineBorder(new java.awt.Color(3, 6, 176)));

		wspLabel1.setForeground(new java.awt.Color(2, 9, 126));
		wspLabel1.setText("Określ długość geo.");

		xLabel1.setForeground(new java.awt.Color(2, 9, 126));
		xLabel1.setText("Y1");

		startX.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 6, 176)));

		yLabel1.setForeground(new java.awt.Color(2, 9, 126));
		yLabel1.setText("Y2");

		startY.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 6, 176)));


		wspLabel2.setForeground(new java.awt.Color(2, 9, 126));
		wspLabel2.setText("Określ szerokość geo.");

		xLabel2.setForeground(new java.awt.Color(2, 9, 126));
		xLabel2.setText("X1");

		endX.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 6, 176)));


		yLabel2.setForeground(new java.awt.Color(2, 9, 126));
		yLabel2.setText("X2");

		endY.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 6, 176)));

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


		javax.swing.GroupLayout pradPanelLayout = new javax.swing.GroupLayout(pradPanel);
		pradPanel.setLayout(pradPanelLayout);
		pradPanelLayout.setHorizontalGroup(
				pradPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pradPanelLayout.createSequentialGroup()
						.addGroup(pradPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pradPanelLayout.createSequentialGroup()
										.addGap(48, 48, 48)
										.addComponent(powerLabelPrad))
										.addGroup(pradPanelLayout.createSequentialGroup()
												.addContainerGap()
												.addComponent(xLabel1)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(startX, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(35, 35, 35)
												.addComponent(yLabel1)
												.addGap(8, 8, 8)
												.addComponent(endX, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addGap(0, 0, Short.MAX_VALUE))
												.addGroup(pradPanelLayout.createSequentialGroup()
														.addGroup(pradPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																.addGroup(pradPanelLayout.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(xLabelPrad)
																		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(wspXTextFieldPrad, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(38, 38, 38)
																		.addComponent(yLabelPrad)
																		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																		.addComponent(wspYTextFieldPrad, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGroup(pradPanelLayout.createSequentialGroup()
																				.addGroup(pradPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(pradPanelLayout.createSequentialGroup()
																								.addGap(4, 4, 4)
																								.addGroup(pradPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																										.addComponent(wspLabelPrad)
																										.addGroup(pradPanelLayout.createSequentialGroup()
																												.addGap(23, 23, 23)
																												.addComponent(windLabelPrad, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
																												.addGroup(pradPanelLayout.createSequentialGroup()
																														.addGap(31, 31, 31)
																														.addComponent(powerTextFieldPrad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
																														.addGap(0, 10, Short.MAX_VALUE))
																														.addGroup(pradPanelLayout.createSequentialGroup()
																																.addGroup(pradPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																																		.addGroup(pradPanelLayout.createSequentialGroup()
																																				.addContainerGap()
																																				.addGroup(pradPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																																						.addComponent(wspLabel1)
																																						.addGroup(pradPanelLayout.createSequentialGroup()
																																								.addComponent(xLabel2)
																																								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																								.addComponent(startY, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
																																								.addGap(35, 35, 35)
																																								.addComponent(yLabel2)
																																								.addGap(8, 8, 8)
																																								.addComponent(endY, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
																																								.addGroup(pradPanelLayout.createSequentialGroup()
																																										.addGap(28, 28, 28)
																																										.addComponent(okButtonPrad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
																																										.addGap(0, 0, Short.MAX_VALUE)))
																																										.addContainerGap())
																																										.addGroup(pradPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																																												.addGroup(pradPanelLayout.createSequentialGroup()
																																														.addGap(2, 2, 2)
																																														.addComponent(wspLabel2)
																																														.addContainerGap(22, Short.MAX_VALUE)))
				);

		pradPanelLayout.setVerticalGroup(
				pradPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pradPanelLayout.createSequentialGroup()
						.addComponent(windLabelPrad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(wspLabelPrad, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pradPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(wspXTextFieldPrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(yLabelPrad)
								.addComponent(wspYTextFieldPrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(xLabelPrad))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(powerLabelPrad)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(powerTextFieldPrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(40, 40, 40)
								.addGroup(pradPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(xLabel1)
										.addComponent(startX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(yLabel1)
										.addComponent(endX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addComponent(wspLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(pradPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(xLabel2)
												.addComponent(startY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(yLabel2)
												.addComponent(endY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
												.addComponent(okButtonPrad, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addContainerGap())
												.addGroup(pradPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pradPanelLayout.createSequentialGroup()
																.addContainerGap(152, Short.MAX_VALUE)
																.addComponent(wspLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(118, 118, 118)))
				);


		wspParowaniaLabel.setForeground(new java.awt.Color(2, 9, 126));
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
										.addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
										// .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(stopButton, 60,76,76))

										//.addComponent(startButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										//.addComponent(enythingButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(windPanel, 150,153, 153)
										.addComponent(pradPanel, 140,153,153)

										.addGroup(buttonPanelLayout.createSequentialGroup()
												.addComponent(wspParowaniaLabel)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(wspParowaniaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

												.addGap(2,2,2))))
				);
		buttonPanelLayout.setVerticalGroup(
				buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(buttonPanelLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(stopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(windPanel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
								.addGap(2, 2, 2)
								.addComponent(pradPanel, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
								.addGap(4, 4, 4)
								.addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(wspParowaniaLabel)
										.addComponent(wspParowaniaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
										//	.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
						)
						//	.addComponent(enythingButton, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						//	.addGap(29, 29, 29))
				);

		resultsPanel.setBackground(new java.awt.Color(95, 155, 228));
		resultsPanel.setBorder(BorderFactory.createMatteBorder(8, 2, 8, 2, new java.awt.Color(1, 7, 110)));

		jScrollPane2.setViewportView(jEditorPane1);

		GroupLayout resultsPanelLayout = new GroupLayout(resultsPanel);
		resultsPanel.setLayout(resultsPanelLayout);
		/*   resultsPanelLayout.setHorizontalGroup(
            resultsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        resultsPanelLayout.setVerticalGroup(
            resultsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
		 */
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

		//      bindingGroup.bind();

		pack();
	}// </editor-fold>



	private void startButtonActionPerformed(ActionEvent evt) throws IOException {
		// startButton.setText("STOP");


		//wspParowania = Integer.parseInt(wspParowaniaField.getText());




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
					if(t<500) cellularAlgorithm.addMoreOil();
					if(t % 100==0)System.out.println("time "+t);
					if (t==500)
						try {
							resultsPanel.saveTableToFile(table2);
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					cellularAlgorithm.windEffect(shore);

					cellularAlgorithm.evaporation(Double.parseDouble(wspParowaniaField.getText()));
					cellularAlgorithm.pradyMorskie(Integer.parseInt(startX.getText()),
							Integer.parseInt(endX.getText()),
							Integer.parseInt(startY.getText()),
							Integer.parseInt(endY.getText()),shore);
					resultsPanel.draw(table2,shore);
					t++;
                    //resultsPanel.draw(shore); przez rysowanie brzegu tak okropnie zwalnia
				}
				resultsPanel.draw(table2,shore);
			}
		}.start();
	}

	private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {
		new Thread() {
			@Override
			public void run() {
				stop = !stop;
				System.out.println("STOOOOOOOOOOOOOOOOOOOOP: " + stop);
				// STATYSTYKI
				statsGui.mainStats();
			}
		}.start();
		
		
		// this.setVisible(false);
	}


	private void okButtonActionPerformed(ActionEvent evt) {
		wind = new Wind(-Double.parseDouble(wspXTextField.getText()), Double.parseDouble(wspYTextField.getText()), Integer.parseInt(powerTextField.getText()));
	}

	private void enythingButtonActionPerformed(ActionEvent evt) {

	}


	public void zeros(double [][] arg){
		for(int i=0; i<708; i++){
			for(int j=0; j<578; j++){
				arg[i][j] = 0.0;
			}
		}
	}



	public static double[][] getTable2() {
		return table2;
	}

	public static void setTable2(double[][] table2) {
		mainGui.table2 = table2;
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



	/**
	 * @param args the command line arguments
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



	static double [][] readShore(String path) throws IOException {
		String sciezka = path;
		BufferedImage img = ImageIO.read(new File(sciezka));

		int wiersze = 708, kolumny = 708;

		double[][] pixels = new double[708][578];

		for(int i=0; i<703; i++){
			for(int j=0; j<570; j++){
				pixels[i][j] = 0;
				//  if(i>650 + generator.nextInt(20)) table2[i][j]=-1;
			}
		}

		int wart = 0;
		for (int w = 2; w < 703; w++) {
			for (int k =2; k < 570; k++) {
				wart = img.getRGB(w, k);
				if (wart == -1) {
					pixels[w][k] = 0;
				} else if(wart>-10000000){//plaza
					pixels[w][k] = -1;
				}    else {//skaly
					pixels[w][k]=-2;
				}

			}
		}
		return pixels;
	}
}
