package view;

import java.util.concurrent.Semaphore;
import controller.AeroportoController;

public class AeroportoPrincipal {

	public static void main(String[] args) 
	{
		Semaphore semaforo = new Semaphore(2);
		
		for (int i = 0; i < 3; i++)
		{
			Thread t = Aeroporto(semaforo, i); 
			t.start();
	}

	}

	
}
