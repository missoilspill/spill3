package model;

import GUI.mainGui;

public class CellularAlgorithm {
    private static mainGui mg;
    Wind wind;
    static double windRatio = mg.getWindRatio();
    static double[][] actualBoard = mg.getactualBoard();
    static double[] MooreNeighborhood = new double[10];

    public CellularAlgorithm(mainGui mg) {
        this.mg = mg;
    }

    public void addMoreOil() {
        for (int i = 345; i < 355; i++) {
            for (int j = 285; j < 290; j++) {
                actualBoard[i][j] = actualBoard[i][j] + 5;
            }
        }

    }


    public void evaporation(double intensiviti) {
        for (int wiersz = 0; wiersz < actualBoard.length; wiersz++) {
            for (int kolumna = 0; kolumna < actualBoard[wiersz].length; kolumna++) {
                if (actualBoard[wiersz][kolumna]-intensiviti > 0.0001) actualBoard[wiersz][kolumna] = actualBoard[wiersz][kolumna] - intensiviti;
                else if (actualBoard[wiersz][kolumna] <= 0.0001) actualBoard[wiersz][kolumna] = 0;
            }
        }
    }

    public void setRatiosInCurrentNeighborhood(double xCurrent, double yCurrent, double currentPower) {
        //  123/456/789   gdzie 5 to punk centralny
        double Pitagoras = Math.sqrt(Math.pow(xCurrent, 2) + Math.pow(yCurrent, 2));
        double naroznik = (Math.abs(yCurrent) + Math.abs(yCurrent)) / Pitagoras;
        double partX = Math.abs(xCurrent) / Pitagoras;

        double partY = Math.abs(yCurrent) / Pitagoras;
        for (int i = 0; i < MooreNeighborhood.length; i++) MooreNeighborhood[i] = 0.0;
        //ustawiamy wspolczynniki w zaleznosci od kierunku
        if (xCurrent > 0 && yCurrent > 0)    // w Prawo i w Dol
        {
            MooreNeighborhood[1] = naroznik;
            MooreNeighborhood[2] = partY;
            MooreNeighborhood[4] = partX;
        } else if (xCurrent > 0 && yCurrent == 0)    // w Prawo
        {
            System.out.println("tu");
            MooreNeighborhood[4] = 1;
        } else if (xCurrent > 0 && yCurrent < 0)    // w prawo i w gore
        {
            MooreNeighborhood[7] = naroznik;
            MooreNeighborhood[8] = partY;
            MooreNeighborhood[4] = partX;
        } else if (xCurrent < 0 && yCurrent > 0)    //W  lewo i w dol
        {
            MooreNeighborhood[3] = naroznik;
            MooreNeighborhood[2] = partY;
            MooreNeighborhood[6] = partX;
        } else if (xCurrent < 0 && yCurrent == 0)    // w lewo
        {
            MooreNeighborhood[6] = 1;
        } else if (xCurrent < 0 && yCurrent < 0)    // w gore I  W lewo
        {
            MooreNeighborhood[9] = naroznik;
            MooreNeighborhood[8] = partY;
            MooreNeighborhood[6] = partX;
        } else if (xCurrent == 0 && yCurrent < 0)    // w gore
        {
            MooreNeighborhood[8] = 1;
        } else if (xCurrent == 0 && yCurrent > 0)    // w dol
        {
            MooreNeighborhood[2] = 1;
        }
        MooreNeighborhood[5] = 100 / currentPower; //zwiekszenie licznika spowalnia moze byc np 100000 dla plazy
        double normalizacja = sumOfArray(MooreNeighborhood);
        for (int i = 0; i < MooreNeighborhood.length; i++) MooreNeighborhood[i] /= normalizacja;
    }

    public void seaCurrents(int startX, int endX, int startY, int endY, double[][] shore) {
        double[][] temp = new double[708][578];
        for (int w = 0; w < 708; w++) {
            for (int k = 0; k < 578; k++) {
                temp[w][k] = actualBoard[w][k];
            }
        }
        for (int w = startY; w < endY; w++) {
            for (int k = startX; k < endX; k++) {
                if (shore[w][k] >= 0) {
                    temp[w][k] = (actualBoard[w - 1][k - 1] * MooreNeighborhood[1] +
                            actualBoard[w - 1][k] * MooreNeighborhood[2] +
                            actualBoard[w - 1][k + 1] * MooreNeighborhood[3] +
                            actualBoard[w][k - 1] * MooreNeighborhood[4] +
                            actualBoard[w][k] * MooreNeighborhood[5] +
                            actualBoard[w][k + 1] * MooreNeighborhood[6] +
                            actualBoard[w + 1][k - 1] * MooreNeighborhood[7] +
                            actualBoard[w + 1][k] * MooreNeighborhood[8] +
                            actualBoard[w + 1][k + 1] * MooreNeighborhood[9]);
                }
            }
        }
        for (int w = 0; w < 700; w++) {
            for (int k = 0; k < 570; k++) {
                actualBoard[w][k] = temp[w][k];
            }
        }

    }

    public void windEffect(double[][] shore) {
        wind = mg.getWind();
        double xWind, yWind;
        double xDirection, yDirection;
        double sumOfWindRatios;
        double sumOfWindRatiosBeach = 0;
        int windPower;
        double pitagorasRatio;
        double[][] temp = new double[708][578];
        double[] r = new double[10];            //współczynniki w otoczeniu piksela r[5], którego wartoć wyliczamy, a pozostałe układajš się zgodnie z numeracjš klawiatruy na komórce
        double[] rBEACH = new double[10];
        xDirection = wind.getX();
        yDirection = wind.getY();
        windPower = wind.getPower();
        pitagorasRatio = Math.sqrt(Math.pow(xDirection, 2) + Math.pow(yDirection, 2));
        xWind = countWindPower(xDirection, pitagorasRatio, windPower);
        yWind = countWindPower(yDirection, pitagorasRatio, windPower);

        if (windPower == 0) {
            setDefaultRatios(r);
            setDefaultRatios(rBEACH);
        } else {
            r = setWindRatios(r, xWind, yWind, false);
            rBEACH = setWindRatios(rBEACH, xWind, yWind, true);
        }
        /*System.out.println(r[1] + " " + r[2] + " " +r[3]);
        System.out.println(r[4] + " " + r[5] + " " +r[6]);
		System.out.println(r[7] + " " + r[8] + " " +r[9]);
		System.out.println(yDirection + " " + xDirection + " " + windPower);
		System.out.println("xWind: " + xWind + " yWind: " + yWind);
		*/
        //GRAWITACJA ROZMAZANIE
        sumOfWindRatios = sumOfArray(r);
        sumOfWindRatiosBeach = sumOfArray(rBEACH);
        for (int i = 1; i < 707; i++) {
            for (int j = 1; j < 577; j++) {
                if (shore[i][j] > -4.0) {//rozmazuje wszedzie za wyjatkiem skal
                    temp[i][j] = (2 * (actualBoard[i - 1][j] + actualBoard[i + 1][j] + actualBoard[i][j - 1] + actualBoard[i][j + 1]) + 4 * actualBoard[i][j]
                            + (actualBoard[i - 1][j - 1] + actualBoard[i + 1][j + 1] + actualBoard[i - 1][j + 1] + actualBoard[i + 1][j - 1])) / 16;

                }
            }
        }
        //przepisanie
        for (int i = 0; i < 708; i++) {
            for (int j = 0; j < 578; j++) {
                actualBoard[i][j] = temp[i][j];
            }
        }
        //KONIEC GRAWITACJI


        //WIATR
        for (int i = 1; i < 707; i++) {
            for (int j = 1; j < 577; j++) {
                if (shore[i][j] == 0.0) {//jesli jestesmy na morzu
                    temp[i][j] = (r[2] * actualBoard[i - 1][j] + r[8] * actualBoard[i + 1][j] + r[4] * actualBoard[i][j - 1] + r[6] * actualBoard[i][j + 1] + r[5] * actualBoard[i][j] + r[1] * actualBoard[i - 1][j - 1] + r[9] * actualBoard[i + 1][j + 1] + r[3] * actualBoard[i - 1][j + 1] + r[7] * actualBoard[i + 1][j - 1]) / sumOfWindRatios;
                } else if (shore[i][j] == -1.0) {//jesli jestemy na plazy - ropa porusza sie duzo wolniej
                    temp[i][j] = (rBEACH[2] * actualBoard[i - 1][j] + rBEACH[8] * actualBoard[i + 1][j] + rBEACH[4] * actualBoard[i][j - 1] + rBEACH[6] * actualBoard[i][j + 1] + rBEACH[5] * actualBoard[i][j] + rBEACH[1] * actualBoard[i - 1][j - 1] + rBEACH[9] * actualBoard[i + 1][j + 1] + rBEACH[3] * actualBoard[i - 1][j + 1] + rBEACH[7] * actualBoard[i + 1][j - 1]) / sumOfWindRatiosBeach;

                } else if (shore[i][j] == -2.0) {//na skalach przepisujemy wartosc
                    temp[i][j] = temp[i][j];
                }
            }
        }
        ///przepisanie
        for (int i = 0; i < 708; i++) {
            for (int j = 0; j < 578; j++) {
                actualBoard[i][j] = temp[i][j];
            }
        }
        //KONIEC WIATRU

    }

    /**
     * Do zsumowania parametrów wiatru
     *
     * @param r tablica
     * @return
     */

    public double sumOfArray(double[] r) {
        double sum = 0;
        for (int i = 1; i < r.length; i++)
            sum += r[i];
        return sum;
    }

    /**
     * Ustalamy wartoci tablicy r, na podstawie kierunku, wartocii współczynnika wiatru
     *
     * @param r
     * @param xWind
     * @param yWind
     */
    public double[] setWindRatios(double[] r, double xWind, double yWind, boolean beach) {
        r = resetTab(r);
        double windXInfluence = windRatio * Math.abs(xWind);
        double windYInfluence = windRatio * Math.abs(yWind);
        if (beach) {//
            r[5] = 100000;
        } else {
            r[5] = 1;
        }
        if (xWind > 0 && yWind > 0)    // SE wind
        {
            r[1] = windXInfluence + windYInfluence;
            r[2] = windYInfluence;
            r[4] = windXInfluence;
        } else if (xWind > 0 && yWind == 0)    // E
        {
            r[4] = windXInfluence;
        } else if (xWind == 0 && yWind > 0)    // S
        {
            r[2] = windYInfluence;
        } else if (xWind < 0 && yWind > 0)    // SW wind
        {
            r[3] = windXInfluence + windYInfluence;
            r[2] = windYInfluence;
            r[6] = windXInfluence;
        } else if (xWind < 0 && yWind == 0)    // W
        {
            r[6] = windXInfluence;
        } else if (xWind < 0 && yWind < 0)    // NW wind
        {
            r[9] = windXInfluence + windYInfluence;
            r[8] = windYInfluence;
            r[6] = windXInfluence;
        } else if (xWind == 0 && yWind < 0)    // N
        {
            r[8] = windYInfluence;
        } else if (xWind > 0 && yWind < 0)    // NE wind
        {
            r[7] = windXInfluence + windYInfluence;
            r[8] = windYInfluence;
            r[4] = windXInfluence;
        }
        if (!beach) {
            for (int i = 1; i < r.length; i++) {
                if (r[i] > 1)
                    r[i] = 1;
            }
        }
        return r;
    }

    /**
     * Wyswietla info o współczynnikach i kończy program
     */
    public void showRatios(double pitagorasRatio, double xWind, double yWind, double[] r, double xDir, double yDir, double windPower) {
        System.out.println("xDirection= " + xDir + "\t yDirection= " + yDir);
        System.out.println("WindPower = " + windPower);
        System.out.println("PitagorasRatio= " + pitagorasRatio + "\t windRatio = " + windRatio);
        System.out.println("xWind= " + xWind + "\t yWind= " + yWind);
        for (int i = 1; i <= 1; i++)
            System.out.println("r[" + i + "]= " + r[i]);
    }


    /**
     * @param directionalValue kierunek wiatru i jego wartosc , czyli wind.getX() lub wind.getY()
     * @param pitagoras        to, pitagorasRatio czyli sqrt(wind.getX()^2 + wind.getY()^2)
     * @param windPower
     * @return power of the wind in the certain direction
     */
    public double countWindPower(double directionalValue, double pitagoras, int windPower) {
        return directionalValue / pitagoras * windPower;
    }

    public double[] resetTab(double[] r) {
        for (int i = 1; i < r.length; i++)
            r[i] = 0;
        return r;
    }

    /**
     * tworzy standardowš maskę współczynników, nr 5 jest indeksem rozpatrywanego w danym momencie piksela, a pozostałe sš jego otoczeniem
     */
    public void setDefaultRatios(double[] r) {
        int r1, r2, r3;
        r1 = 1;
        r2 = 2;
        r3 = 4;
        r[1] = r1;
        r[3] = r1;
        r[7] = r1;
        r[9] = r1;
        r[2] = r2;
        r[4] = r2;
        r[6] = r2;
        r[8] = r2;
        r[5] = r3;
    }
}
