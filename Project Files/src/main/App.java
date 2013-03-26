package main;

import gui.GeneratorMainFrame;
import controller.HibernateService;

public class App {

	public static GeneratorMainFrame mainFrame = null;

	public static void main(String[] args) {
		HibernateService.InitService();

		mainFrame = new GeneratorMainFrame();
	}
}
