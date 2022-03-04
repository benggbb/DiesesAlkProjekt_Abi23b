import java.util.Scanner;

public class Game {

	static String kurve = "linear";
	static int zyklen = 20;
	static int w = 5, h = 7;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println(Alkorithmus.wc_Screen );
		switch (s.next()) {
		case "1":
			kurve = "random";
			System.out.println("Zufällige Nachfrage");
			break;
		case "2":
			kurve = "kurve";
			System.out.println("Cosinus Abfrage");
			break;
		case "3":
			kurve = "linear";
			System.out.println("lineare Abfrage");
			break;
		default:
			System.out.println("Standart Kurve: linear");

			System.out.println("Let´s go...");

			BeerDistributionGame.Init(h, w);
			
		}

		for (int i = 0; i < zyklen; i++) {
			System.out.println((int) BeerDistributionGame.getDemand(kurve, i));
		}
		for (int i = 0; i < zyklen; i++) {
			BeerDistributionGame.Zyklus((int) BeerDistributionGame.getDemand(kurve, i), "kurve");
			BeerDistributionGame.print();
		}

	}

}
