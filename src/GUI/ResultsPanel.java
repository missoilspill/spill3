package GUI;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


/**
 * Klasa odpowiedziana za rysowanie.
 * Odczytuje dane z pliku i odpowiedznio wyświetla. Im większa warstwa ropy, tym ciemniejszy kolor.
 */
public class ResultsPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	Color c = new Color(0, 0, 0, 0);

    public ResultsPanel() {
        super();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    /**
     * Funkcja zapisująca tablicę do pliku
     * @param tab	tablica do zapisania
     */
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

   /**
    * Funkcja wyświetlająca tablicę dwuwymiarową na panelu,
    * zgodnie z przyjętymi zasadami - im więcej ropy, tym ciemniejszy kolor
    * @param arg tablica z ilością ropy
    * @param shore tablica zawierająca brzegi
    */
    public void draw(double [] [] arg,double[][] shore) {
        double x;
        Graphics g = getGraphics();
        for (int i = 2; i < 706; i++)
            for (int j = 8; j < 577; j++) {
                x =arg[i][j];
                if (x != 0 ) {
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
                    else if (x > 0.01)
                        c = new Color(170, 170, 170);
                    else c = new Color(95, 155, 228);

                    if(!((shore[i][j] <0)&&(c.getBlue()==228))){		//jesli nie ma takiej sytuacji ze chcemy narysowac niebieskie na brzegu
                        g.setColor(c);
                        g.drawRect(i, j, 1, 1);
                    }

                }
                if (x <= 0.01 && x != 0 && !(shore[i][j] <0)) {			// nie malujemy niebieskiego na brzegu
                    c = new Color(95, 155, 228);
                    g.setColor(c);
                    g.drawRect(i, j, 1, 1);
                }
                else if(x==-2){
                    c = new Color(0,255,0);
                    g.setColor(c);
                    g.drawRect(i, j, 1, 1);
                }
                else if(x==-1){
                    c = new Color(225,251,141);
                    g.setColor(c);
                    g.drawRect(i, j, 1, 1);
                }
                
            }
        revalidate();
    }
}
