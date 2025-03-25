/*4 cavaleiros caminham por um corredor, simultaneamente, de 2 a 4 m por 50 ms. O corredor é
escuro, tem 2 km e em 500 m, há uma única tocha. O cavaleiro que pegar a tocha, aumenta sua
velocidade, somando mais 2 m por 50 ms ao valor que já fazia. Em 1,5 km, existe uma pedra
brilhante. O cavaleiro que pegar a pedra, aumenta sua velocidade, somando mais 2 m por 50 ms
ao valor que já fazia (O cavaleiro que já detém a tocha não poderá pegar a pedra). Ao final dos 2
km, os cavaleiros se deparam com 4 portas e, um por vez pega uma porta aleatória (que não pode
repetir) e entra nela. Apenas uma porta leva à saída. As outras 3 tem monstros que os devoram.*/

package view;
import java.util.concurrent.Semaphore;
import Controller.Cavaleiros;

public class Principal {

	public static void main(String[] args) {
		
		
		Semaphore tocha = new Semaphore(1);
		Semaphore pedra = new Semaphore(1);
		int porta = gerarPorta();
		
		System.out.println("A porta correta é: " +porta);
		
		for (int i = 0; i < 4; i++)
		{
			Thread Cavaleiros = new Cavaleiros (i, tocha, pedra, porta);
			Cavaleiros.start();
		}
	}
	
	public static int gerarPorta()
	{
		return (int)(Math.random()*4);
	}

}
