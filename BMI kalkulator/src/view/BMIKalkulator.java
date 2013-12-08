package view;

import java.text.DecimalFormat;

public class BMIKalkulator {

	private double visina;
	private double tezina;
	private double bmi;
	private char pol;
	
	public BMIKalkulator (double visina, double tezina, char pol) {
		this.visina = visina;
		this.tezina = tezina;
		this.pol = pol;
	}
	
	public void izracunajMBI () {
		visina = visina/100;
		bmi = tezina/(visina*visina);
		bmi = roundOneDecimals(bmi);
	}
	
	public String rezultat () {
		izracunajMBI();
		return "Vas BMI iznosi "+bmi;
	}
	
	public String objasnjenje (char pol) {
		String rec = null;
		if (pol == 'M') {
			if (bmi < 20.7)
				rec = "prenizak";
			else if (20.7 <= bmi && bmi <=26.4)
				rec = "idealan";
			else if (26.5 <= bmi && bmi <=27.8)
				rec = "malo iznad normale";
			else if (27.9 <= bmi && bmi <=31.1)
				rec = "visok";
			else if (31.2 <= bmi && bmi <=35.4)
				rec = "previsok";
			else if (bmi > 45.4)
				rec = "izrazito visok";
		}
		else if (pol == 'Z'){
			if (bmi < 19.1)
				rec = "prenizak";
			else if (19.1 <= bmi && bmi <= 25.8)
				rec = "idealan";
			else if (25.9 <= bmi && bmi <=27.3)
				rec = "malo iznad normale";
			else if (27.4 <= bmi && bmi <=32.2)
				rec = "visok";
			else if (32.3 <= bmi && bmi <=44.8)
				rec = "previsok";
			else if (bmi > 44.8)
				rec = "izrazito visok";
		}
		else if (pol == 'N')
			rec = "";
		return "Vas BMI je "+rec+" .";
	}

	public double roundOneDecimals(double d) {
	    DecimalFormat oneDForm = new DecimalFormat("#.#");
	    return Double.valueOf(oneDForm.format(d));
	}
	
	
	
}
