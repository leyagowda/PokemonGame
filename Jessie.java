import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
public class Jessie extends Person{
    private int a;
    private int b;
    private int width;
    private int height;
    private int realLevel;
    public Jessie(int x, int y, int ilevel){
        super(x,y,"Jessie",ilevel);
        width = super.getWidth();
        height = super.getHeight();
        realLevel = ilevel;
    }
    public void drawMe(Graphics g,int xDiff,int yDiff,int realLevel) {
        int x;
        int y;
        // if(realLevel == 0){
        x = a+xDiff;
        y = b+yDiff;
        g.setColor(fuscia);
        int[] hairx = new int[]{x+10,x+30, x+30};
        int[] hairy = new int[]{y+10,y-5,y+40};
        g.fillPolygon(hairx, hairy, 3); 
        g.setColor(cream2);
        g.fillOval(x,y,20,20);
        g.setColor(fuscia);
        g.fillOval(x+3,y,14,4); 
        g.setColor(cream2);
        //neck
        g.fillOval(x+7,y+15,5,10);
        //arms
        g.fillOval(x-2,y+27,5,15);
        g.fillOval(x+16,y+27,5,15);
        //legs
        g.fillOval(x+12,y+45,6,20);
        g.fillOval(x+2,y+45,6,20);
        g.setColor(black);
        g.fillOval(x+12,y+45+15,6,7);
        g.fillOval(x+2,y+45+15,6,7);
        
        // g.fillOval(x+12,y+45,6,5);
        // g.fillOval(x+2,y+45,6,5);
        
        g.setColor(cream2);
        g.fillOval(x+5,y+30,10,20);
        g.setColor(gray);
        g.fillOval(x+2,y+23,15,13);
        g.setColor(gray);
        g.fillOval(x,y+40,20,15);
        g.setColor(realBlack);
        g.fillOval(x+3,y+7,4,4);
        g.fillOval(x+12,y+7,4,4);
        g.setColor(red);
        g.fillOval(x+7,y+15,6,2);
        g.setColor(red);
        g.drawRect(x-10,y,width,height);
        g.setColor(fuscia);
        Font font1 = new Font("Arial", Font.PLAIN, 7);
		g.setFont(font1);
        g.drawString("R",x+5+2,y+30+2);
        Font font2 = new Font("Arial", Font.PLAIN, 15);
        g.setFont(font2);
        
    }
}