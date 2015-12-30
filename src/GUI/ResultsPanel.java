package GUI;

import javax.swing.*;
import java.awt.*;

public class ResultsPanel extends JPanel {

    Color c = new Color(0, 0, 0, 0);

    public ResultsPanel() {
        super();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

   public void saveTableToFile(double [][] tab) throws FileNotFoundException, IOException {
    	File folderWithResults = new File("Results");
    	if (!folderWithResults.exists()) {
    		folderWithResults.mkdir();
    	}    	
    	int countOfFiles = folderWithResults.listFiles().length;
    	File resultFile = new File("./Results/res_ " + (countOfFiles+1) + ".txt");
		resultFile.createNewFile();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(resultFile)));
    	for (int i=0; i<tab.length; i++){
    		for (int j=0; j<tab[0].length; j++){
    			bw.write(String.valueOf(tab[i][j]));
    			bw.write(" ");
    		}
    		bw.newLine();
    	}
    	bw.close();
    }


    public void draw() {
        double x;
        Graphics g = getGraphics();
        for (int i = 2; i < 706; i++)
            for (int j = 8; j < 577; j++) {
                x = mainGui.table2[i][j];
                if (x != 0) {
                    if (x > 17)
                        c = new Color(0, 0, 0);
                    else if (x > 13)
                        c = new Color(40, 40, 40);
                    else if (x > 10)
                        c = new Color(80, 80, 80);
                    else if (x > 7)
                        c = new Color(100, 100, 100);
                    else if (x > 5)
                        c = new Color(120, 120, 120);
                    else if (x > 3)
                        c = new Color(140, 140, 140);
                    else if (x > 2)
                        c = new Color(150, 150, 150);
                    else if (x > 1)
                        c = new Color(160, 160, 160);
                    else if (x > 0.1)
                        c = new Color(170, 170, 170);
                    else c = new Color(95, 155, 228);
                    g.setColor(c);
                    g.drawRect(i, j, 1, 1);
                }
                if (x < 0.1 && x != 0) {
                    c = new Color(95, 155, 228);
                    g.setColor(c);
                    g.drawRect(i, j, 1, 1);
                }
                if(x==-1){
                    c = new Color(0,255,0);
                    g.setColor(c);
                    g.drawRect(i, j, 1, 1);
                }
            }
        revalidate();
    }
}
