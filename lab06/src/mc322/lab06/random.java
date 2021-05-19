package mc322.lab06;

import java.util.Random;

public class random extends Controle {
	public boolean pegaOuro (){
		Random random = new Random();
		int N = random.nextInt(10);				
		if (N > 5) return true;
		else return false;
	}
}