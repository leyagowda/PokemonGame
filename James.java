import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class James extends Person{
    private int a;
    private int b;
    private int width;
    private int height;
    private int realLevel;
    public James(int aa, int bb, int irealLevel){
        super(aa,bb, "James",0);
        width = super.getWidth();
        height = super.getHeight();
        realLevel = irealLevel;
    }
    public void drawMe(Graphics g,int xDiff,int yDiff,int realLevel) {
        g.setColor(super.gray);
        int x;
        int y;
        // if(realLevel == 0){
        x = a+xDiff;
        y = b+yDiff;

    // }else{
    //     x = 5000;
    //     y = 5000;
    // }
        int[] hairx = new int[]{x-5,x+10,x+25};
        int[] hairy = new int[]{y-5,y+10,y-5};
        //int[] hairx = new int[]{x-2, x-5,x+10+3,x+25};
        //int[] hairy = new int[]{y, y+24,y,y+24};  ponytail
        g.setColor(darkBlue);
        g.fillPolygon(hairx, hairy, 3); 
        g.setColor(cream2);
        g.fillOval(x,y,20,20);
        g.setColor(darkBlue);
        g.fillOval(x+3,y,14,4); 
        g.setColor(cream2);
        //neck
        g.fillOval(x+7,y+15,5,10);
        //arms
        g.fillOval(x-2,y+27,5,15);
        g.fillOval(x+16,y+27,5,15);
        g.setColor(gray);
        g.fillOval(x-2,y+27-2,5,10);
        g.fillOval(x+16,y+27-2,5,10);
        //legs
        g.setColor(gray);
        g.fillOval(x+12,y+45,6,20);
        g.fillOval(x+2,y+45,6,20);
        g.setColor(black);
        g.fillOval(x+12,y+45+15,6,7);
        g.fillOval(x+2,y+45+15,6,7);

        g.setColor(gray);
        g.fillOval(x,y+23,15+3,13+15);
        g.setColor(black);
        g.fillOval(x+2+2,y+23,10,13+15);
        //g.fillOval(x+5,y+30,10,20);
        g.setColor(gray);
        g.fillOval(x,y+40,20,15);
        g.setColor(realBlack);
        g.fillOval(x+3,y+7,4,4);
        g.fillOval(x+12,y+7,4,4);
        g.setColor(red);
        g.fillOval(x+7,y+15,6,2);
        Font font1 = new Font("Arial", Font.PLAIN, 7);
		g.setFont(font1);
        g.drawString("R",x+5+2,y+30+2); 
        Font font2 = new Font("Arial", Font.PLAIN, 15);
        g.setFont(font2);
        g.setColor(lightBlue);
        g.drawRect(x-10,y,width,height); 
        
    }
    


}