import java.util.ArrayList;
import java.util.Scanner;

public class BeerDistributionGame {
	static int[][] station = new int[5][5];
	static int[] roh = new int[] { 4, 4, 4 };
	static final int b1 = 0, b2 = 1, lager = 2, l1 = 3, l2 = 4;
	static final int kunde = 0, verkäufer = 1, großhändler = 2, regionalhändler = 3, brauerrei = 4;
	static int c1 = 0, c2 = 0;
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("start");
		Init();
		System.out.println("wie viele züglen");
		System.out.println("Kunde bekommt:  " + Zyklus(40));
//		System.out.println(Zyklus(40));
//		System.out.println(Zyklus(4));
		for (int i = 0; i < s.nextInt(); i++) {
			int c = Zyklus(getDemand(i));
			System.out.println("kunde bekommt: " + c);
		}
		
	}

	/*private static int curve(int i) {
		return (int) (2.5 * Math.cos(2.0 * Math.PI / 20.0 * (i)) + 7.5);
	}*/
	
	private static int getDemand(String type, int n) {
		int r = 0;
        	switch (d) {
            		case "random":
                		r = (int) (Math.random() * 19 + 1);
            		case "linear":
                		r = n;
            		case "curve":
                		r = (int) (2.5 * Math.cos(2.0 * Math.PI / 20.0 * (cycle)) + 7.5);
        	}
        	return r;
	}

	private static int Zyklus(int k_demand) {
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
			int lieferung = station[i - 1][b2];// station[i][lager] - station[i - 1][b2] < 0
			// ? station[i - 1][b2]
			// : station[i - 1][b2]; // lieferung wird ausgerchenet+
			station[i][l1] = lieferung; // lieferung wird ausgehändigt
			station[i][lager] -= lieferung; // lager wird geupdated
			station[i][b2] = station[i][b1];
			if (i == 0)
				station[i][b1] = k_demand;
			else
				station[i][b1] = s.nextInt();
			c2 = c1;

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
				  "Station        : b1 : b2 : Lager : l1 : l1\n"
				+ "------------------------------------------\n"
				+ "Kunde          : " + station2[0][0] + "  :  " + station2[0][1]+ " :  " + station2[0][2]+ "\n"
				+ "Verkäufer      : " + station2[1][0] + "  :  " + station2[1][1]+ " :  " + station2[1][2] + "   : " +station2[1][3] + "  : " + station2[1][4] + "\n"
				+ "Großhändler    : " + station2[2][0] + "  :  " + station2[2][1]+ " :  " + station2[2][2] + "   : " +station2[2][3] + "  : " + station2[2][4] + "\n"
				+ "Regionalhändler: " + station2[3][0] + "  :  " + station2[3][1]+ " :  " + station2[3][2] + "   : " +station2[3][3] + "  : " + station2[3][4] + "\n"		
				+ "Brauerrei      : " + station2[4][0] + "  :  " + station2[4][1]+ " :  " + station2[4][2] + "   : " +station2[4][3] + "  : " + station2[4][4] + "\n"
				+ "\nRohstoffe    : B1 : H1 :H2\n"
				+   "------------------------------------------\n"
				+   "             : " + roh[0] + " : " + roh[1] + " : " + roh[2] );
	}

	private static void Init() {
		for (int i = 0; i < station.length; i++) {
			station[i][b1] = 4;
			station[i][b2] = 4;
			station[i][lager] = 12;
			station[i][l1] = 4;
			station[i][l2] = 4;
		}

	}

}
