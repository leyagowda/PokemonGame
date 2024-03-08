import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public abstract class Item{
    String name;
    int x;
    int y;
    int width;
    int height;
    Color lightBlue = new Color(153, 229, 255);
    Color darkBlue = new Color(24, 42,132);
    Color black = new Color(23, 24, 45);
    Color brown = new Color(135,69,19);
    Color darkBrown = new Color(160,82,45);
    Color green = new Color(154,205,50);
    Color white = new Color(255,250,250);
    Color darkOrange = new Color(255,69,0);
    Color orange = new Color(255,140,0);
    Color lightOrange = new Color(189,183,107); 
    Color cream = new Color(255,222,173);
    Color gray = new Color(192,192,192);
    Color pink = new Color(255,105,180);
    Color yellow = new Color(255,255,0);
    Color realBlack = new Color(0,0,0);
    Color deerBrown = new Color(244,164,96);
    Color deerDarkBrown = new Color(210,105,30);
    Color pigPink = new Color(255,182,193);
    Color pigNosePink = new Color(250,128,114); 
    Color lightGreen = new Color(154,230,50);
    Color darkGreen = new Color(20,92,7);
    Color cream2 = new Color(255,204,153);
    Color red = new Color(255,0,0);
    public Item(String iname, int ix, int iy){
        x = ix;
        y = iy;
        name = iname;
    }
    public abstract void drawMe(Graphics g,int x, int y, int level);

    public boolean checkCollisionPlayer(Player p){
        //System.out.println("check col");
        int dX = getX();
        int dY = getY();
        int dWidth = getWidth();
        int dHeight = getHeight();

        int pX = p.getX();
        int pY = p.getY();
        int pWidth = p.getWidth();
        int pHeight = p.getHeight();

        if( dX+dWidth >= pX && dX <= dX + pWidth && dY + pHeight >= pY && dY <= pY + pHeight){
            return true;
        }else{
            return false;
        }
        
    }

    public void dissappear(){
        x = 5000;
        y = 5000;
    }
    public void reappear(){
        x = (int)(Math.random()*600);
        y = (int)(Math.random()*450 +100);
    }

    public int getX(){
        return x;
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
    public void setXY(int x,  int y){
        this.x = x;
        this.y = y;
    }
    
}