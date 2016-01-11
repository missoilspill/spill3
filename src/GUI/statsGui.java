package GUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;

/**
 *
 * @author dawid
 */
public class statsGui extends javax.swing.JFrame {
                 
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel mainGui;
    private static ResultsPanelStats resultsPanelStat;
    private javax.swing.JLabel title;
    private javax.swing.JPanel titlePanel;
    static Integer[][] tab1Sym = new Integer[708][578];
    
    public statsGui() {
        initComponents();
    }
                
    private void initComponents() {

        mainGui = new javax.swing.JPanel();
        titlePanel = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        resultsPanelStat = new ResultsPanelStats();
       
        for (int i=0; i<tab1Sym.length; i++){
    		for (int j=0; j<tab1Sym[0].length; j++){
    			tab1Sym[i][j]=0;
    		}
    	}
		fillTab();
	    
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Statystyki");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(92, 117, 223));
        setBounds(new java.awt.Rectangle(10, 10, 10, 10));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(222, 74, 74));

        mainGui.setBackground(new java.awt.Color(166, 230, 239));

        titlePanel.setBackground(new java.awt.Color(95, 155, 228));
        titlePanel.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 2, 10, 2, new java.awt.Color(1, 7, 110)));
        titlePanel.setForeground(new java.awt.Color(20, 18, 84));
        titlePanel.setToolTipText("");

        title.setFont(new java.awt.Font("LM Mono Caps 10", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(11, 11, 67));
        title.setText("Statystyczki");

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        resultsPanelStat.setBackground(new java.awt.Color(95, 155, 228));
		resultsPanelStat.setBorder(BorderFactory.createMatteBorder(8, 2, 8, 2, new java.awt.Color(1, 7, 110)));


		
        resultsPanelStat.setBackground(new java.awt.Color(95, 155, 228));
		resultsPanelStat.setBorder(BorderFactory.createMatteBorder(8, 2, 8, 2, new java.awt.Color(1, 7, 110)));

        jScrollPane2.setViewportView(jEditorPane1);

        javax.swing.GroupLayout resultsPanelStatLayout = new javax.swing.GroupLayout(resultsPanelStat);
        resultsPanelStat.setLayout(resultsPanelStatLayout);
        resultsPanelStatLayout.setHorizontalGroup(
                resultsPanelStatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
            );
            resultsPanelStatLayout.setVerticalGroup(
                resultsPanelStatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
            );
            




        javax.swing.GroupLayout mainGuiLayout = new javax.swing.GroupLayout(mainGui);
        mainGui.setLayout(mainGuiLayout);
        mainGuiLayout.setHorizontalGroup(
            mainGuiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainGuiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainGuiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(titlePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainGuiLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(resultsPanelStat, 709,709,709)))
                .addContainerGap())
        );
        mainGuiLayout.setVerticalGroup(
            mainGuiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainGuiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resultsPanelStat, 586,586,586)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainGui, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainGui, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void mainStats() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(statsGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(statsGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(statsGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(statsGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new statsGui().setVisible(true);
              	
            }
        });
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        resultsPanelStat.draw(tab1Sym);

    }

                 
    public void fillTab() {
		HashMap<Integer[], Integer> map = readHashMap("wyniki.txt");
		for(Map.Entry<Integer[], Integer> m : map.entrySet()){
			int x = m.getKey()[0];
			int y = m.getKey()[1];
			tab1Sym[x][y] += m.getValue();
        }
	}
	
	/**
	 * odczytuje wyniki z pliku 
	 * @param filename
	 * @return
	 */
	public HashMap<Integer[], Integer> readHashMap(String filename){
		HashMap<Integer[], Integer> mapInFile = null;
	    //read from file 
	    try{
	        File toRead=new File("Results/"+filename);
	        FileInputStream fis=new FileInputStream(toRead);
	        ObjectInputStream ois=new ObjectInputStream(fis);

	        mapInFile=(HashMap<Integer[], Integer>)ois.readObject();
//			for(Map.Entry<Integer[], Integer> m :mapInFile.entrySet()){
//				System.out.println(m.getKey()[0]+" "+m.getKey()[1]);
//	        }
	        ois.close();
	        fis.close();
	    }catch(Exception e){}
	    return mapInFile;
	}
	
	public void showTab() {
	    for (int i=0; i<tab1Sym.length; i++){
    		for (int j=0; j<tab1Sym[0].length; j++){
    			System.out.print ("["+i+"]["+j+"]= "+tab1Sym[i][j] + "  ");
    		}
    		System.out.println(" ");
	    }
	}
	
}
