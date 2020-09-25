package view;

import controller.ThreadOvercooked;

public class Main {

	public static void main(String[] args) {
		int Id = 5;
		for (int i = 0; i < Id; i++) {
			new ThreadOvercooked().start();
		}
	}

}
