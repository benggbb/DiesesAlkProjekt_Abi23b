public class Cosis {
	int[] punkte;
	double a, c, d;
	int x;
	double f1, f2, f3, f4, f5, f6;
	double[] unterschied;
	double formel;
	double gesamtUnterschied;

	public Cosis(int[] punkte) {
		this.punkte = punkte;
		annäherung();
	}

	public void annäherung() {
		unterschied = new double[6];
		a = 1.0;
		c = 0.0;
		d = 0.0;
		do {
			d += 0.1;
			a = 0.0;
			do {
				a += 0.1;
				akktu();
				if (gesamtUnterschied > 28) {
					break;
				}
			} while (akktu() == false);
			if (gesamtUnterschied < 1) {
				break;
			}
		} while (d < 20);
		System.out.println(gesamtUnterschied);
		System.out.println(a);
		System.out.println(d);
	}

	public double f(double x, double a, double c, double d) {
		formel = a * Math.cos(x - c) + d;
		return formel;
	}

	public boolean akktu() {
		int i = 0;
		for (i = 0; i < 6; i++) {
			unterschied[i] = Math.sqrt((punkte[i] - f(i, a, c, d)) * (punkte[i] - f(i, a, c, d)));
		}
		gesamtUnterschied = unterschied[0] + unterschied[1] + unterschied[2] + unterschied[3] + unterschied[4]
				+ unterschied[5];
		if (gesamtUnterschied < 1) {
			return true;
		} else
			return false;
	}
}