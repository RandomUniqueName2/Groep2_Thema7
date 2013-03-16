package main;

import controller.HibernateService;
import gui.GeneratorMainFrame;

public class App {	
	
	public static GeneratorMainFrame mainFrame = null;
	
	public static void main(String[] args) {
		HibernateService.InitService();
		
		mainFrame = new GeneratorMainFrame();
	}
}
