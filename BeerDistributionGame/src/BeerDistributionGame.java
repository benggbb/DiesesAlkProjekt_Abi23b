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

	public static int Zyklus(int k_demand) {
		for (int i = 4; i > 0; i--) {

			c1 = station[i][l2]; // kunde bekommt lieferung
			station[i][l2] = station[i][l1]; // shift von l1 zu l2
			if (i < 4)
				station[i][lager] += c2; // lager wird aufgefüllt
			else {
				station[i][lager] += roh[2];
				roh[2] = roh[1];
				roh[1] = roh[0];
				roh[0] = s.nextInt();
				// TODO: lagerzyklus schreiben
			}
			int lieferung =  station[i][lager] - station[i - 1][b2] < 0
			 ? station[i][lager]
			 : station[i - 1][b2]; // lieferung wird ausgerchenet+
			
//			station[i][kl] += kosten( station[i][lager], lagerkosten,  strafkosten); // einstelle
//			station[i][ks] += kosten( station[i][lager], lagerkosten,  strafkosten);
			station[i][l1] = lieferung; // lieferung wird ausgehändigt
			station[i][lager] -= lieferung; // lager wird geupdated
			station[i][b2] = station[i][b1];
			if (i == 1)
				station[i -1][b1] = k_demand;
			station[i][b1] = s.nextInt();
			c2 = c1;
			station[i][kl] += kosten( station[i][lager], lagerkosten,  0); // einstelle
			station[i][ks] += kosten( station[i][lager], 0,  strafkosten);
			

		}
		Print(station);
		return c1;
	}

	private static void Print(int[][] station2) {
//		for (int i[] : station2) {
//			for (int j : i)
//				System.out.print(j + " ");
//			System.out.println();
//		}
		System.out.println(
				  "Station        : b1 : b2 : Lager : l1 : l2 : lagerk : strafk\n"
				+ "------------------------------------------------------------\n"
				+ "Kunde          : " + station2[0][0] + "  :  " + station2[0][1]+ " :  " + station2[0][2]+ "\n"
				+ "Verkäufer      : " + station2[1][0] + "  :  " + station2[1][1]+ " :  " + station2[1][2] + "   : " +station2[1][3] + "  : " + station2[1][4] + "   : " +station2[1][5] + "  : " + station2[1][6] +"\n"
				+ "Großhändler    : " + station2[2][0] + "  :  " + station2[2][1]+ " :  " + station2[2][2] + "   : " +station2[2][3] + "  : " + station2[2][4] + "   : " +station2[2][5] + "  : " + station2[2][6] +"\n"
				+ "Regionalhändler: " + station2[3][0] + "  :  " + station2[3][1]+ " :  " + station2[3][2] + "   : " +station2[3][3] + "  : " + station2[3][4] + "   : " +station2[3][5] + "  : " + station2[3][6] +"\n"		
				+ "Brauerrei      : " + station2[4][0] + "  :  " + station2[4][1]+ " :  " + station2[4][2] + "   : " +station2[4][3] + "  : " + station2[4][4] + "   : " +station2[4][5] + "  : " + station2[4][6] +"\n"
				+ "\nRohstoffe    : B1 : H1 :H2\n"
				+ "------------------------------------------------------------\n"
				+ "               : " + roh[0] + " : " + roh[1] + " : " + roh[2]  )
				;
	}

	public static void Init() {
		for (int i = 0; i < station.length; i++) {
			station[i][b1] = 4;
			station[i][b2] = 4;
			station[i][lager] = 12;
			station[i][l1] = 4;
			station[i][l2] = 4;
			station[i][kl] = 0;
			station[i][ks] = 0;
		}

	}
	public static double kosten( int bestand, double lagerkosten, double verzugskosten) {
		Double neuekosten;
		if(bestand < 0) {
			neuekosten= bestand*verzugskosten*-1.;
		}else {
			neuekosten= bestand*lagerkosten;
		}
		return neuekosten;
	}
	
	
	public static int bestand(int bestand, int wareneingang, int warenausgang) {
		return bestand = bestand + wareneingang - warenausgang;
	}

	public static double getDemand(String kurve,int i) {
		switch (kurve) {
		case "kurve":
			return 4. *Math.cos(i) +5;
		
		case "linear":
			return i;
			
		case "random":
			return new Random().nextDouble() *20;
		
		}return 0;
	}

}
