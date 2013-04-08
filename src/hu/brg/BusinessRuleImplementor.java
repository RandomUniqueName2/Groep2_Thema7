package hu.brg;

import hu.brg.domain.DomainService;
import hu.brg.gui.ImplementorMainFrame;

import java.awt.EventQueue;

public class BusinessRuleImplementor {
	public static void main(String[] args) {
		DomainService.Init();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					ImplementorMainFrame frame = new ImplementorMainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
