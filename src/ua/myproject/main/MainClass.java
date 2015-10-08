package ua.myproject.main;

import javax.swing.plaf.synth.SynthSeparatorUI;

import ua.myproject.heys.Heys;

public class MainClass {
	

	public static void main(String[] args) {
		short k = 31261;
		Heys h = new Heys();
		short l = h.round(k, (short) 0);
		System.out.println(l);
	}
	
}