import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyMonitor extends KeyAdapter {

	private GameEngine	gm;
	
	public void	setEngine(GameEngine gm) {
		this.gm = gm;
	}

	
	public void keyPressed(KeyEvent e) {
		
		switch (e.getKeyCode()) {
			case KeyEvent.VK_SPACE:
				// Pressing space.
				gm.start();
				break ;
			case KeyEvent.VK_UP:
				// Pressing UP.
				gm.pushTop();
				break ;
			case KeyEvent.VK_DOWN:
				// Pressing DOWN
				gm.pushBot();
				break ;
			case KeyEvent.VK_LEFT:
				// Pressing LEFT
				gm.pushLeft();
				break ;
			case KeyEvent.VK_RIGHT:
				// Pressing RIGHT
				gm.pushRight();
				break ;
			case KeyEvent.VK_ESCAPE:
				System.exit(0);
			default:
				break ;
		}
		
	}
	
}
