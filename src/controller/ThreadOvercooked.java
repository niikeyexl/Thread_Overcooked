package controller;

import java.util.concurrent.Semaphore;

public class ThreadOvercooked extends Thread{
	private static int threadcount = 0;
	private int id;
	private static Semaphore semaforo = new Semaphore(1);
	public ThreadOvercooked(){
		this.id = threadcount++;
	}
	
	@Override
	public void run() {
		int n;
		n = id % 2;
		if (n == 0) {
			LasanhaBolonhesa();
		} else {
			SopaCebola();
		}	
	}
	public void LasanhaBolonhesa() {
		long tempotot;
		long tempoperc = 0;
		tempotot = ((long)(600 +(1200 - 600) * Math.random()));
		try {
			while ( tempoperc < tempotot ) {
				sleep(100);
				tempoperc += 100;
				System.out.println(((tempoperc / tempotot) * 100) + "% completos do prato: Lasanha Bolonhesa");
				
			}
			System.out.println("Cozimento completo!");
			entregar("Lasanha Bolonhesa");
		} catch (Exception e) {
		}
	}
	public void SopaCebola() {
		long tempotot;
		long tempoperc = 0;
		tempotot = ((long)(500 +(800 - 500) * Math.random()));
		try {
			while ( tempoperc < tempotot ) {
				sleep(100);
				tempoperc += 100;
				System.out.println(((tempoperc / tempotot) * 100) + "% completos do prato: Sopa de Cebola");
				
			}
			System.out.println("Cozimento completo!");
			entregar("Sopa de Cebola");
		} catch (Exception e) {
		}
	}
	public void entregar(String prato) {
		try {
			semaforo.acquire();
			System.out.println("Entregando prato " + prato);
			sleep(500);
			System.out.println(prato + " entregue.");
		} catch (Exception e) {
		} finally {
			semaforo.release();
			
		}
	}
}
