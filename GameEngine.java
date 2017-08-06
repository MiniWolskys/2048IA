import java.util.concurrent.ThreadLocalRandom;

public class GameEngine {
	
	private int[]	values = new int[16];
	private Window	win;
	private int		started = 0;
	
	public void		setWindow(Window win) {
		this.win = win;
	}
	
	public void		setValue(int v, int p) {
		
		values[p] = v;
		
	}
	
	public void		afterMove() {
		
		int	newPos;
		int	newVal;
	
		newVal = ThreadLocalRandom.current().nextInt(1, 3) * 2;
		do {
			newPos = ThreadLocalRandom.current().nextInt(0, 16);
		} while (values[newPos] != 0);
	
		this.setValue(newVal, newPos);

		for (int i = 0; i < 16; i++) {
		
			win.setValue(values[i], i);
		
		}
	
		win.refresh();
		
	}
	
	public void		pushLeft() {

		int		j = 0;
		boolean	moved = false;
		
		for (int i = 0; i < 16; i++) {
			
			if (values[i] != 0)
			{
			
				j = 1;
			
				while (j <= (i % 4)) {
				
					if (values[i] == values[i - j])
					{
								
						this.setValue(values[i] * 2, i - j);
						this.setValue(0, i);
						moved = true;
						break ;
					
					}
				
					else if (j == i % 4 && values[i - j] == 0)
					{
					
						this.setValue(values[i], i - j);
						this.setValue(0, i);
						moved = true;
						break ;
					
					}
				
					else if (values[i] != values[i - j] && values[i - j] != 0)
					{
					
						if (j != 1)
						{
							
							this.setValue(values[i], i - j + 1);
							this.setValue(0, i);
							moved = true;
							
						}
					
						break ;
					
					}
				
					j += 1;
				
				}
			
			}
			
		}
		
		if (moved == true) {
			
			this.afterMove();
			
		}
		
	}
	
	public void		pushRight() {
		
		int		j = 0;
		boolean	moved = false;
		
		for (int i = 15; i >= 0; i--) {
			
			if (values[i] != 0)
			{
			
				j = 4 - (i % 4) - 1;
			
				while (j > 0) {
				
					if (values[i] == values[i + j])
					{
								
						this.setValue(values[i] * 2, i + j);
						this.setValue(0, i);
						moved = true;
						break ;
					
					}
				
					else if (j == 1 && values[i + j] == 0)
					{
					
						this.setValue(values[i], i + j);
						this.setValue(0, i);
						moved = true;
						break ;
					
					}
				
					else if (values[i] != values[i + j] && values[i + j] != 0)
					{
					
						if (j != 4 - (i % 4) - 1)
						{
							
							this.setValue(values[i], i + j + 1);
							this.setValue(0, i);
							moved = true;
							
						}
					
						break ;
					
					}
				
					j -= 1;
				
				}
			
			}
			
		}
		
		if (moved == true) {
			
			this.afterMove();
			
		}
		
	}
	
	public void		pushTop() {
		
		int		j = 0;
		boolean	moved = false;
		
		for (int i = 0; i < 16; i++) {
			
			if (values[i] != 0) {
				
				j = i - 4;
				
				while (j >= 0) {
					
					if (values[i] == values[j]) {
						
						this.setValue(values[j] * 2, j);
						this.setValue(0, i);
						moved = true;
						break ;
						
					}
					
					else if (values[j] == 0 && j < 4) {
						
						this.setValue(values[i], j);
						this.setValue(0, i);
						moved = true;
						break ;
						
					}
					
					else if (values[j] != 0 && values[j] != values[i]) {
						
						if (i - j != 4) {
							
							this.setValue(values[i], j + 4);
							this.setValue(0, i);
							moved = true;
						
						}
						
						break ;
						
					}
					
					j -= 4;
					
				}
				
			}
			
		}
		
		if (moved == true) {
			
			this.afterMove();
		
		}
		
	}
	
	public void		pushBot() {
		
		int		j = 0;
		boolean	moved = false;
		
		for (int i = 15; i > -1; i--) {
			
			if (values[i] != 0) {
				
				j = i + 4;
				
				while (j <= 15) {
					
					if (values[i] == values[j]) {
						
						this.setValue(values[j] * 2, j);
						this.setValue(0, i);
						moved = true;
						break ;
						
					}
					
					else if (values[j] == 0 && j > 11) {
						
						this.setValue(values[i], j);
						this.setValue(0, i);
						moved = true;
						break ;
						
					}
					
					else if (values[j] != 0 && values[j] != values[i]) {
						
						if (j - i != 4) {
							
							this.setValue(values[i], j - 4);
							this.setValue(0, i);
							moved = true;
						
						}
						
						break ;
						
					}
					
					j += 4;
					
				}
				
			}
			
		}
		
		if (moved == true) {
			
			this.afterMove();
		
		}
		
	}
	
	public void		start() {
		
		if (this.started == 1) {
			return ;
		}
		
		this.started = 1;
		
		for (int i = 0; i < 16; i++) {
			win.setValue(0, i);
		}
		
		int randP1 = ThreadLocalRandom.current().nextInt(0, 15 + 1);
		
		int randP2 = randP1;
		while (randP2 == randP1) {
			
			randP2 = ThreadLocalRandom.current().nextInt(0, 15 + 1);
		
		}
		
		int	randV1 = ThreadLocalRandom.current().nextInt(1, 3) * 2;
		int randV2 = ThreadLocalRandom.current().nextInt(1, 3) * 2;
		
		this.setValue(randV1, randP1);
		this.setValue(randV2, randP2);
		
		win.setValue(randV1, randP1);
		win.setValue(randV2, randP2);

		win.refresh();
		
	}
	
}
