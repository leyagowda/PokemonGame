import java.awt.Color;
import java.awt.Graphics;

public class Tree{
	private int x;
	private int y;
	private Color brown;
	private Color darkGreen;
	
	public Tree(int x, int y){	
		this.x = x;
		this.y = y;

		brown = new Color(205,133,63);
		darkGreen = new Color(0,100,0);
	}
	

	public void drawMe(Graphics g, int xDiff, int yDiff){
	
		g.setColor(brown);
		g.fillRect(x+30+xDiff,y+50+yDiff,40,100); 
		
		g.setColor(darkGreen);
		g.fillOval(x+xDiff,y+yDiff,100,100);
	}



}