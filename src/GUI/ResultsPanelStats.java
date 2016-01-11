package GUI;

import javax.swing.*;
import java.awt.*;


/**
 * Klasa odpowiedziana za rysowanie prawdopodobieństwa wstąpienia ropy na danym obszarze.
 * Odczytuje dane z pliku i odpowiedznio wyświetla. Im większe prawdopodobieństwo, tym ciemniejszy kolor.
 */
public class ResultsPanelStats extends JPanel {


	private static final long serialVersionUID = 1L;
	Color c = new Color(0, 0, 0, 0);

    public ResultsPanelStats() {
        super();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    /**
     * Funkcja wyświetlająca tablicę dwuwymiarową na panelu,
     * zgodnie z przyjętymi zasadami - im więcej ropy, tym ciemniejszy kolor
     * @param arg tablica z ilością ropy
     */
    public void draw(Integer [] [] arg) {
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
                    else if(x==-2){
                        c = new Color(0,255,0);
                    }
                    else if(x==-1){
                        c = new Color(225,251,141);
                    }
               	}
                else c = new Color(255,255,255);
 
                g.setColor(c);
                g.drawRect(i, j, 1, 1);          
                
            }

        revalidate();
    }
}
