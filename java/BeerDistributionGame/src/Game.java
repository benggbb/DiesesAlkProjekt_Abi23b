import java.util.Scanner;

public class Game {

	static double rundeZahl(double zahl){
		zahl = zahl * 100; 					//Kommastelle verschieben 
		zahl = (int) zahl; 					//Nachkommazahlen streichen 
		zahl = (double) zahl / 100; 	   //Nachkommastellen  wieder hinzufügen 
		return zahl;		
	}
	
	
	static int x(int a) {
		if(a < 0 || a > 101) {

			System.out.println("deine Zahl ist nicht zwischen 1 und 100");
			x(new Scanner(System.in).nextInt());
		}
		else {
			return a;
		}
		return a;
	}
	static int spieler;
	static int kundennachfrage;
	static int bestellen;
	static double lagerhaltungskosten;
	static double verzugskosten;
	static int lieferdauer;
	static int verzugsdauer;
	static int testmodus;
	
	public static void main(String[] args) {

		System.out.println(Alkorithmus.wc_Screen );
		Scanner eingabe = new Scanner(System.in);
		
		//	Wen spielst du ?
		//--------------------------------------------------------------------------------------------
		System.out.println("Wen möchten Sie spielen?"
				+"\n (1)	Hersteller" 
				+"\n (2)	Regionallager"
				+"\n (3)	Großhändler"
				+"\n (4)	Einzelhändler");
		spieler = eingabe.nextInt();
		while(spieler < 0 || spieler > 5) {
			System.out.println("Dieser Wert ist nicht 1,2,3 oder 4");
			spieler = eingabe.nextInt();
		}
		
		
		//	Rundenanzahl
		//--------------------------------------------------------------------------------------------
		System.out.println("Wie viele Runden/Zyklen möchtest du spielen? (reelle Zahlen zwischen 1 und 100)");
		int rundenanzahl = x(eingabe.nextInt());
		
		
		//	Kundennachfrage
		//--------------------------------------------------------------------------------------------
		System.out.println("Wie soll die Kundennachfrage sein?"
				+"\n	(1)	Kosinus");
		System.out.println(" |  .                                                        . ");
		System.out.println(" |       .                                                .    ");
		System.out.println(" |           .                                        .     ");
		System.out.println(" |               .                                .       ");
		System.out.println(" |                 .                           .         ");
		System.out.println(" |                   .                      .           ");
		System.out.println(" |                     .                  .             ");
		System.out.println(" |                       .              .               ");
		System.out.println(" |                         .          .                 ");
		System.out.println(" |                            .    .                 ");
		System.out.println(" |_____________________"
				+"\n	(2)	Linear konstant");
		System.out.println(" |                                                           "
		+"\n | "
		+"\n | "
		+"\n | ");
		System.out.println(" | .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  ."
		+"\n | "
		+"\n | "
		+"\n | "
		+"\n | "
		+"\n | ");
		System.out.println(" |_____________________"
				+"\n	(3)	zufällig springend");
		System.out.println(" |  .                                                          ");
		System.out.println(" |       .                .                     .        .     ");
		System.out.println(" |           .                                        .        ");
		System.out.println(" |   .                       .                     .       .   ");
		System.out.println(" |                              .                              ");
		System.out.println(" |                                                             ");
		System.out.println(" |                  .                  .  .                    ");
		System.out.println(" |                                                             ");
		System.out.println(" |                .                        .                   ");
		System.out.println(" |                      .           .                         .");
		System.out.println(" |_____________________"
				+"\n	(4)	zufällig");
		System.out.println(" |  .                                                           ");
		System.out.println(" |                        .                     .               ");
		System.out.println(" |            .                                       .         ");
		System.out.println(" |                                                              ");
		System.out.println(" |               .               .                              ");
		System.out.println(" |                                                       .      ");
		System.out.println(" |       .           .                  .  .                    ");
		System.out.println(" |                                                .             ");
		System.out.println(" |                            .                                 ");
		System.out.println(" |                      .           .                        .  ");
		System.out.println(" |_____________________"
				+"\n	(5)	Linear");
		System.out.println(" |                                                           "
				+"\n |                                 ."
				+"\n |                             ."
				+"\n |                         ."
				+"\n |                     ."
				+"\n |                 ."
				+"\n |             ."
				+"\n |         ."
				+"\n |     ."
				+"\n | .");
				System.out.println(" |______________");
				
				kundennachfrage = eingabe.nextInt();
				while(kundennachfrage < 0 || kundennachfrage > 6) {
					System.out.println("Dieser Wert ist nicht 1,2,3,4 oder 5");
					kundennachfrage = eingabe.nextInt();
				}
				
		//	Wie verhalten sich die anderen Filialien?
		//--------------------------------------------------------------------------------------------
		System.out.println("Wie sollen sich die anderen Spieler verhalten?"
				+"\n	(1)	zufällig	(im Berecih der eingehenden Bestellung)"
				+"\n	(2)	rational	(logisch, bestellt immer die eingehende Bestellung)"
				+"\n	(3)	menschlich	(wenn das Lager überfühl, bestellt er weniger und wenn es leer ist, dann bestellt er mehr"
				+"\n	(4)	abi23b		()");
		bestellen = eingabe.nextInt();
		while(bestellen < 0 || bestellen > 5) {
			System.out.println("Dieser Wert ist nicht 1,2,3 oder 4");
			bestellen = eingabe.nextInt();
		}
		
		//	Kosten
		//--------------------------------------------------------------------------------------------
		System.out.println("Wie hoch sind die Lagerhaltungskosten? (zwischen 0 und 100 mit zwei Nachkommerstellen)");
		lagerhaltungskosten = rundeZahl(eingabe.nextDouble());
		while(lagerhaltungskosten < 0 || lagerhaltungskosten > 101) {
			System.out.println("Dieser Wert ist nicht zwischen 1 und 100");
			lagerhaltungskosten = rundeZahl(eingabe.nextDouble());
		}
		System.out.println("Wie hoch sind die Verzugskosten? (zwischen 0 und 100 mit zwei Nachkommerstellen)");
		verzugskosten = rundeZahl(eingabe.nextDouble());
		while(verzugskosten < 0 || verzugskosten > 101) {
			System.out.println("Dieser Wert ist nicht zwischen 1 und 100");
			verzugskosten = rundeZahl(eingabe.nextDouble());
		}
		
		//	Liefer- und VezugsZEIT
		//--------------------------------------------------------------------------------------------
		System.out.println("Wie hoch sind die Lieferdauer? (0,1,2,3 und 4)");
		lieferdauer = eingabe.nextInt();
		while(lieferdauer <= 0 || lieferdauer > 5) {
			System.out.println("Dieser Wert ist nicht 0,1,2,3, oder 4");
			lieferdauer = eingabe.nextInt();
		}
		System.out.println("Wie hoch sind die Verzugsdauer der Bestellung? (0,1,2,3 und 4)");
		verzugsdauer = eingabe.nextInt();
		while(verzugsdauer <= 0 || verzugsdauer > 5) {
			System.out.println("Dieser Wert ist nicht 0,1,2,3, oder 4");
			verzugsdauer = eingabe.nextInt();
		}
		
		//	Testmodus
		//--------------------------------------------------------------------------------------------
		System.out.println("Soll der Testmodus aktiviert sein? (im Testmodus siehtst du, was die andern Spielen tun)"
				+"\n	(0)	aktivieren"
				+"\n	(1)	deaktivieren");
		testmodus = eingabe.nextInt();
		while(testmodus <= 0 || testmodus > 2) {
			System.out.println("Dieser Wert ist nicht 0 oder 1");
			testmodus = eingabe.nextInt();
		}

		BeerDistributionGame.Init(5,7);

		for (int i = 0; i < rundenanzahl; i++) {
			System.out.println((int) BeerDistributionGame.getDemand(kundennachfrage, i));
		}
		for (int i = 0; i < rundenanzahl; i++) {
			BeerDistributionGame.Zyklus((int) BeerDistributionGame.getDemand(kundennachfrage, i), "kurve");
			BeerDistributionGame.print(BeerDistributionGame.station);
		}
		
		
	}
}
