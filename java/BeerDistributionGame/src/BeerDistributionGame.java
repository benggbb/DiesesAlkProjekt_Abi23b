import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BeerDistributionGame {
	static int[][] station = new int[5][7];
	static int[] roh = new int[] { 4, 4, 4 };
	static final int b1 = 0, b2 = 1, lager = 2, l1 = 3, l2 = 4, kl = 5, ks = 6;
	static final int kunde = 0, verkäufer = 1, großhändler = 2, regionalhändler = 3, brauerrei = 4;
	static int c1 = 0, c2 = 0;
	static double strafkosten = 1, lagerkosten = 0.5;
	static Scanner s = new Scanner(System.in);

	public static int curve(int i) {
		return (int) (2.5 * Math.cos(2.0 * Math.PI / 20.0 * (i)) + 7.5);
	}

	public static void Zyklus(int k_demand, String ki) {
		int n = station[0].length - 3 / 2 ;
		//n = lager 
		System.out.println(k_demand);
		for (int i = 4; i > 0; i--) { // shiften durch die stationen
//			for(int j = n-1; j <= 0; j++) { 
//				if(j == n-1 )
//					c1 = station[i][j];
//				else
//					station[i][j] = station[i][j-1];
//			}
			c1 = station[i][l2]; // kunde bekommt lieferung 
			station[i][l2] = station[i][l1]; // shift von l1 zu l2 deprecated
			if (i < 4)
				station[i][n] += c2; // lager wird aufgefüllt
			else {
				station[i][n] += roh[2];
				roh[2] = roh[1];
				roh[1] = roh[0];
				roh[0] = s.nextInt();
				// TODO: lagerzyklus schreiben
			}
			int lieferung = station[i][n] - station[i - 1][n-1] < 0 
							? station[i][n] 
							: station[i - 1][n-1]; // lieferung
																													// wird
																													// ausgerchenet+

//			station[i][kl] += kosten( station[i][lager], lagerkosten,  strafkosten); // einstelle
//			station[i][ks] += kosten( station[i][lager], lagerkosten,  strafkosten);
			station[i][n+1] = lieferung; // lieferung wird ausgehändigt
			station[i][n] -= lieferung; // lager wird geupdated
			station[i][b2] = station[i][b1];
			if (i == 1)
				station[i - 1][b1] = k_demand;
			switch (ki) {
			case "Menschlich":
				station[i][b1] = berechneBestellungHL(station[i][lager], station[i - 1][b2]);
				break;
			case "rational":
				station[i][b1] = ratbest(station[i - 1][b2]);
				break;
			case "ben":
				if (i < 4)
					station[i][b1] = 
					ben(station[i][lager], station[i - 1][b2], station[i + 1][l2]);
				else
					station[i][b1] = ben(station[i][lager], station[i - 1][b2], roh[2]);
			case "r":
				
			}
			c2 = c1;
			station[i][kl] += kosten(station[i][lager], lagerkosten, 0); // einstelle
			station[i][ks] += kosten(station[i][lager], 0, strafkosten);

		}
		station[0][4] = c1;
	}

	public static int RandomKunde(int iB, int iL) {
		
		if (b2 > l2) {
			int IInv = b2 - l2;
			int iBestZu =  (int) (Math.random()*(IInv) +  1);
			
			iBestZu += l2;
			return iBestZu;
		}
		
		else {
			int IInv = l2 - b2;
			int iBestZu = (int) (Math.random()*(IInv) +1);
			
			
			return iBestZu;
		}
	}
	public static int ben(int lageri, int b2i, int l1i) {
		int wert = b2i;
		int v = 0;
		v = l1i * 4 - b2i * 4;
		if ((lageri - v) < 0) {
			System.out.println("[v]" +v);
			wert = b2i + (v / 4 * (-1));
		}
		return wert;
	}

	private static void Print(int[][] station2) {
//		for (int i[] : station2) {
//			for (int j : i)
//				System.out.print(j + " ");
//			System.out.println();
//		}
		System.out.println("Station        : b1 : b2 : Lager : l1 : l2 : lagerk : strafk\n"
				+ "------------------------------------------------------------\n" + "Kunde          : "
				+ station2[0][0] + "  :  " + station2[0][1] + " :  " + station2[0][2] + "\n" + "Verkäufer      : "
				+ station2[1][0] + "  :  " + station2[1][1] + " :  " + station2[1][2] + "   : " + station2[1][3]
				+ "  : " + station2[1][4] + "   : " + station2[1][5] + "  : " + station2[1][6] + "\n"
				+ "Großhändler    : " + station2[2][0] + "  :  " + station2[2][1] + " :  " + station2[2][2] + "   : "
				+ station2[2][3] + "  : " + station2[2][4] + "   : " + station2[2][5] + "  : " + station2[2][6] + "\n"
				+ "Regionalhändler: " + station2[3][0] + "  :  " + station2[3][1] + " :  " + station2[3][2] + "   : "
				+ station2[3][3] + "  : " + station2[3][4] + "   : " + station2[3][5] + "  : " + station2[3][6] + "\n"
				+ "Brauerrei      : " + station2[4][0] + "  :  " + station2[4][1] + " :  " + station2[4][2] + "   : "
				+ station2[4][3] + "  : " + station2[4][4] + "   : " + station2[4][5] + "  : " + station2[4][6] + "\n"
				+ "\nRohstoffe    : B1 : H1 :H2\n" + "------------------------------------------------------------\n"
				+ "               : " + roh[0] + " : " + roh[1] + " : " + roh[2]);
	}

	public static int ratbest(int rational) {
		return rational;
	}

	public static int berechneBestellungHL(int lager, int bestellung) {
		int out = bestellung;
		if ((lager - bestellung) > (2 * bestellung)) {
			out = (int) ((bestellung * 0.5) + 0.5);
		} else if ((lager - bestellung) < (2 * bestellung)) {
			out = (int) (bestellung * 1.5);
		}
		return out;
	}

	public static void print() {
        System.out.println("K       L:" + station[0][2]);
        System.out.println("    B1:" + station[0][0] + "   l1:" + station[0][3]);
        System.out.println("      v      ^");
        System.out.println("    B2:" + station[0][1] + "   l2:" + station[0][4]);
        System.out.println("--------------------");
        System.out.println("V       L:" + station[1][2]);
        System.out.println("    B1:" + station[1][0] + "   l1:" + station[1][3]);
        System.out.println("      v      ^");
        System.out.println("    B2:" + station[1][1] + "   l2:" + station[1][4]);
        System.out.println("--------------------");
        System.out.println("G       L:" + station[2][2]);
        System.out.println("    B1:" + station[2][0] + "   l1:" + station[2][3]);
        System.out.println("      v      ^");
        System.out.println("    B2:" + station[2][1] + "   l2:" + station[2][4]);
        System.out.println("--------------------");
        System.out.println("R       L:" + station[3][2]);
        System.out.println("    B1:" + station[3][0] + "   l1:" + station[3][3]);
        System.out.println("      v      ^");
        System.out.println("    B2:" + station[3][1] + "   l2:" + station[3][4]);
        System.out.println("--------------------");
        System.out.println("B       L:" + station[4][2]);
        System.out.println("    B1:" + station[4][0] + "   l1:" + station[4][3]);
        System.out.println("      v      ^");
        System.out.println("    B2:" + station[4][1] + "   l2:" + station[4][4]);
    }

	public static void Init(int h, int w) {
		station = new int[h][w];
		for (int i = 0; i < station.length; i++) {
			station[i][b1] = 20;
			station[i][b2] = 20;
			station[i][lager] = 12;
			station[i][l1] = 4;
			station[i][l2] = 4;
			station[i][kl] = 0;
			station[i][ks] = 0;
		}

	}

	public static double kosten(int bestand, double lagerkosten, double verzugskosten) {
		Double neuekosten;
		if (bestand < 0) {
			neuekosten = bestand * verzugskosten * -1.;
		} else {
			neuekosten = bestand * lagerkosten;
		}
		return neuekosten;
	}

	public static int bestand(int bestand, int wareneingang, int warenausgang) {
		return bestand = bestand + wareneingang - warenausgang;
	}

	public static double getDemand(String kurve, int i) {
		switch (kurve) {
		case "kurve":
			return 4. * Math.cos(i) + 5;

		case "linear":
			return 4;

		case "random":
			return new Random().nextDouble() * 20;

		}
		return 0;
	}

}
