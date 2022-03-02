
public class Game {
	
	static String kurve = "random";
	static int zyklen = 20;

	public static void main(String[] args) {
		BeerDistributionGame.Init();
		

		for (int i = 0; i < zyklen; i++) {
			System.out.println((int) BeerDistributionGame.getDemand(kurve, i));
		}
		for (int i = 0; i < zyklen; i++) {
			BeerDistributionGame.Zyklus((int) BeerDistributionGame.getDemand(kurve, i));
		}
		

	}

}
