import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class Panel extends JPanel {
	
	private int[]	values = new int[16];
	
	public int		setValue(int v, int p) {
		
		if (p < 0 || p > 15) {
			return (0);
		}
		
		values[p] = v;
		
		return (1);
		
		
	}
	
	private void	printValue(int v, int p, Graphics g) {

		if (v == 0) {
			return ;
		}
		
		int	x = -1;
		int	y = -1;
		
		switch ((p + 1) % 4) {
			case 0:
				x = this.getWidth() / 4 * 3 + 5;
				break ;

			case 1:
				x = 5;
				break ;

			case 2:
				x = this.getWidth() / 4 + 5;
				break ;
				
			case 3:
				x = this.getWidth() / 2 + 5;
				break ;
		}
		
		if (p >= 0 && p <= 3) {
			
			y = this.getHeight() / 8;
			
		} else if (p >= 4 && p <= 7) {
			
			y = this.getHeight() / 8 * 3;
			
		} else if (p >= 8 && p <= 11) {
			
			y = this.getHeight() / 8 * 5;
			
		} else {
			
			y = this.getHeight() / 8 * 7;
			
		}
		
		g.drawString(Integer.toString(v), x, y);
		
	}
	
	public void		paintComponent(Graphics g) {
		
		g.setColor(Color.BLACK);
		g.drawLine(0, this.getHeight() / 4, this.getWidth(), this.getHeight() / 4);
		g.drawLine(0, this.getHeight() / 4 * 2, this.getWidth(), this.getHeight() / 4 * 2);
		g.drawLine(0, this.getHeight() / 4 * 3, this.getWidth(), this.getHeight() / 4 * 3);
		g.drawLine(this.getWidth() / 4, 0, this.getWidth() / 4, this.getHeight());
		g.drawLine(this.getWidth() / 4 * 2, 0, this.getWidth() / 4 * 2, this.getHeight());
		g.drawLine(this.getWidth() / 4 * 3, 0, this.getWidth() / 4 * 3, this.getHeight());
		
		for (int i = 0; i < 16; i++) {
			printValue(values[i], i, g);
		}
		
	}
	
}
