package Controller;

import java.util.concurrent.Semaphore;

public class Cavaleiros extends Thread 
{
	int Cavaleiro;
	Semaphore PegaTocha;
	Semaphore PegaPedra; 
	static boolean tocha = false;
	static boolean pedra = false; 
	private int anda;
	static boolean [] portas = new boolean [4];
	final int PORTA_CORRETA; 
	
	public Cavaleiros (int Cavaleiros, Semaphore PegaTocha, Semaphore PegaPedra, int porta)
	{
		this.Cavaleiro = Cavaleiro;
		this.PegaTocha = PegaTocha;
		this.PegaPedra = PegaPedra; 
		this.PORTA_CORRETA = porta;
		
	}
	
	public void run ()
	{
		cavaleirosAndando();
	}

	public void cavaleirosAndando() 
	{
		int distanciaTotal = 2000;
		this.anda = (int) ((Math.random()*3) + 2);
		int distanciaPercorrida = 0;
		int tempo = 50;
		
		while (distanciaPercorrida < distanciaTotal)
		{
			distanciaPercorrida += anda;
			if (distanciaPercorrida >= 500 && !tocha)
			{
				pegarTocha();
			}
			try
			{
				sleep(tempo);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
			System.out.println("#" +Cavaleiro+ "andou " +distanciaPercorrida+ "m. " +anda);
		}
		
		escolhaPorta(Cavaleiro, PORTA_CORRETA);
		
	}
	
	public void pegarTocha()
	{
		try 
		{
			PegaTocha.acquire();
			System.out.println(Cavaleiro+ " pegou a tocha");
			
			this.anda += 2;
			this.tocha = true;
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			PegaTocha.release();
		}
	}
	
	public void escolhaPorta(int cavaleiro, int PORTA_CORRETA)
	{
		int portaEscolhida = (int)(Math.random()*4);
		
		while(portas[portaEscolhida])
		{
			portaEscolhida = (int) (Math.random()*4);
		}
		
		portas [portaEscolhida] = true; 
		
		System.out.println("O cavaleiro #"+cavaleiro+ "está em frente as 4 portas");
		System.out.println("Escolheu a porta "+portaEscolhida);
		
		if (portaEscolhida == PORTA_CORRETA)
		{
			System.out.println("Sobreviveu");
		}
		else
		{
			System.out.println("Não sobreviveu");
		}
	}
	
	
}
