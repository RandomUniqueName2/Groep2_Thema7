package main;

import domain.DomainService;
import gui.GeneratorMainFrame;
import hibernate.HibernateService;

public class App {

	public static GeneratorMainFrame mainFrame = null;

	public static void main(String[] args) {
		HibernateService.InitService();
		DomainService.Init();

		mainFrame = new GeneratorMainFrame();
	}
}
