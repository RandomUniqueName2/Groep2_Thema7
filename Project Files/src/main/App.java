package main;

import gui.GeneratorMainFrame;
import hibernate.HibernateService;

public class App {

	public static GeneratorMainFrame mainFrame = null;

	public static void main(String[] args) {
		HibernateService.InitService();

		mainFrame = new GeneratorMainFrame();
	}
}
