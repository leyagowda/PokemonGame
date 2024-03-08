import java.awt.Color;
import java.awt.Graphics;
public abstract class Person{
    private int x;
    private int y;
    private int width;
    private int height;
    private int level;
    private String name;
    public Color lightBlue = new Color(153, 229, 255);
    public Color darkBlue = new Color(24, 42,132);
    public Color black = new Color(23, 24, 45);
    public Color brown = new Color(135,69,19);
    public Color darkBrown = new Color(160,82,45);
    public Color green = new Color(154,205,50);
    public Color white = new Color(255,250,250);
    public Color darkOrange = new Color(255,69,0);
    public Color orange = new Color(255,140,0);
    public Color lightOrange = new Color(189,183,107); 
    public Color cream = new Color(255,222,173);
    public Color gray = new Color(192,192,192);
    public Color pink = new Color(255,105,180);
    public Color yellow = new Color(255,255,0);
    public Color realBlack = new Color(0,0,0);
    public Color deerBrown = new Color(244,164,96);
    public Color deerDarkBrown = new Color(210,105,30);
    public Color pigPink = new Color(255,182,193);
    public Color pigNosePink = new Color(250,128,114); 
    public Color lightGreen = new Color(154,230,50);
    public Color darkGreen = new Color(20,92,7);
    public Color cream2 = new Color(255,204,153);
    public Color red = new Color(255,0,0);
    public Color fuscia = new Color(255,51,153);


    public Person(int x, int y, String iname,int ilevel) {
        this.x = x;
        this.y = y;
        name = iname;
        level = ilevel;

        width = 40;
        height = 65;


    }


    public void drawMe(Graphics g,int xDiff,int yDiff,int realLevel) {
        
        g.setColor(cream2);
        g.fillOval(x,y,20,20);
        g.setColor(darkBrown);
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
        g.setColor(pink);
        g.fillOval(x+2,y+23,15,13);
        g.fillOval(x+5,y+30,10,20);
        g.fillOval(x,y+40,20,15);
        g.setColor(realBlack);
        g.fillOval(x+3,y+7,4,4);
        g.fillOval(x+12,y+7,4,4);
        g.setColor(red);
        g.fillOval(x+7,y+15,6,2);
        g.setColor(red);
        g.drawRect(x-10,y,width,height);
        
    }

    public int getX(){
        return x-10;
    }
    public int getY(){
        return y;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public void drawDeer(Graphics g, int ix, int iy){
        g.setColor(deerBrown);
        //face
        g.fillOval(ix,iy,15,15);
        //snout
        g.fillOval(ix-5,iy+10, 15, 5);
        //ears
        g.fillOval(ix,iy-5,4,8);  
        g.fillOval(ix+10,iy-5,4,8); 
        //neck
        g.fillOval(ix+7,iy+13,5,8); 
        //body
        g.fillOval(ix+8,iy+14,30,15);
        
        //nose
        g.setColor(realBlack);
        g.fillOval(ix-5,iy+10, 3, 3);
        
        //legs
        g.setColor(deerBrown);
        g.fillOval(ix+10,iy+15,5,30); 
        g.fillOval(ix+15,iy+15,5,30); 
        g.fillOval(ix+28,iy+15,5,30); 
        g.fillOval(ix+33,iy+15,5,30); 
        //tail
        g.setColor(cream);
        g.fillOval(ix+33,iy+13,5,5);
        //eyes and hooves
        g.setColor(realBlack);
        g.fillOval(ix+2,iy+5, 3, 3);
        g.fillOval(ix+8,iy+5, 3, 3);
        g.fillOval(ix+10,iy+15+25, 5, 5);
        g.fillOval(ix+15,iy+15+25, 5, 5);
        g.fillOval(ix+28,iy+15+25, 5, 5);
        g.fillOval(ix+33,iy+15+25, 5, 5);
        g.setColor(red);
    }
   
   

    public void setXY(int x,  int y){
        this.x = x;
        this.y = y;
    }
    public void dissappear(){
        x = 5000;
        y = 5000;
    }
    





}