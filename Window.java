import javax.swing.JFrame;

public class Window extends JFrame {

	private Panel		panel = new Panel();
	private GameEngine	gm;
	
	public void	setEngine(GameEngine gm) {
		this.gm = gm;
	}
	
	public void	setKeyListener(KeyMonitor m) {
		this.addKeyListener(m);
	}
	
	public int	setValue(int v, int p) {
		return (panel.setValue(v, p));
	}
	
	public void		refresh() {

		this.setContentPane(this.panel);
		this.setVisible(true);
		
	}
	
	public	Window() {
		
		// Set default properties for window.
		
		this.setTitle("MiniWolskys - 2048");
		this.setSize(600, 600);
		this.setLocation(100, 0);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setFocusable(true);
		
		// Display the window.
		
		this.setVisible(true);
		
		return ;
		
	}
	
}
