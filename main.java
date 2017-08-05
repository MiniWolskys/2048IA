
public class main {
	
	public static void	main(String[] args) {
	
		// Game engine initialization
		
		GameEngine gm = new GameEngine();
		
		// Window initialization
		
		Window win = new Window();
	
		// Key monitor initialization
		
		KeyMonitor monitor = new KeyMonitor();
		
		win.setKeyListener(monitor);
		gm.setWindow(win);
		win.setEngine(gm);
		monitor.setEngine(gm);
		
		return ;
		
	}
	
}
