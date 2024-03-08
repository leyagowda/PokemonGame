import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player {
    private int x;
    private int y;
    private int width;
    private int height;
    private BufferedImage ball;
    private BufferedImage xerneas;
    private int level;
    private Color lightBlue = new Color(153, 229, 255);
    private Color darkBlue = new Color(24, 42,132);
    private Color black = new Color(23, 24, 45);
    private Color brown = new Color(135,69,19);
    private Color darkBrown = new Color(160,82,45);
    private Color green = new Color(154,205,50);
    private Color white = new Color(255,250,250);
    private Color darkOrange = new Color(255,69,0);
    private Color orange = new Color(255,140,0);
    private Color lightOrange = new Color(189,183,107); 
    private Color cream = new Color(255,222,173);
    private Color gray = new Color(192,192,192);
    private Color pink = new Color(255,105,180);
    private Color yellow = new Color(255,255,0);
    private Color realBlack = new Color(0,0,0);
    private Color deerBrown = new Color(244,164,96);
    private Color deerDarkBrown = new Color(210,105,30);
    private Color pigPink = new Color(255,182,193);
    private Color pigNosePink = new Color(250,128,114); 
    private Color lightGreen = new Color(154,230,50);
    private Color darkGreen = new Color(20,92,7);
    private Color cream2 = new Color(255,204,153);
    private Color red = new Color(255,0,0);
    private Color xerneasBlue = new Color(100,149,237);


    public Player(int x, int y) {
        this.x = x;
        this.y = y;

        width = 20;
        height = 65;

        try {
           ball = ImageIO.read(new File("masterballedited.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
           xerneas = ImageIO.read(new File("xerneas2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void drawMe(Graphics g, int level) {
        // g.setColor(Color.BLUE);
        // g.fillOval(x, y, width, width);
        // g.fillRect(x + 15, y, 10, height);
        int[] hairx = new int[]{x-5,x+10,x+25};
        int[] hairy = new int[]{y+24,y,y+24};
        g.setColor(darkBrown);
        g.fillPolygon(hairx, hairy, 3);   
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
        
        int ix = x +5;
        int iy = y-35;

        if(level > 1){
            g.drawImage(ball,x+15, y+15+20, 15, 15, null);
        }
        if(level >= 4){
            g.drawImage(xerneas,ix, iy, 110, 110, null);
        }
        

        
        // if(level>=0){
        //     g.setColor(xerneasBlue);
        //     //face
        //     g.fillOval(ix,iy,15,15);
        //     //snout
        //     g.fillOval(ix-5,iy+10, 15, 5);
        //     //ears
        //     g.fillOval(ix,iy-5,4,8);  
        //     g.fillOval(ix+10,iy-5,4,8); 
        //     //neck
        //     g.fillOval(ix+7,iy+13,5,8); 
        //     //body
        //     g.fillOval(ix+8,iy+14,30,20); //15 to 30
        //     //nose
        //     g.setColor(black);
        //     g.fillOval(ix-5,iy+10, 3, 3);
            
        //     //legs
        //     g.setColor(xerneasBlue);
        //     g.fillOval(ix+10,iy+15,5,40); 
        //     g.fillOval(ix+15,iy+15,5,40); 
        //     g.fillOval(ix+28,iy+15,5,40); 
        //     g.fillOval(ix+33,iy+15,5,40); 
        //     //tail
        //     g.setColor(cream);
        //     g.fillOval(ix+33,iy+13,5,5);
        //     //eyes and hooves
        //     g.setColor(black);
        //     g.fillOval(ix+2,iy+5, 3, 3);
        //     g.fillOval(ix+8,iy+5, 3, 3);
        //     g.fillOval(ix+10,iy+15+25+10, 5, 5);
        //     g.fillOval(ix+15,iy+15+25+10, 5, 5);
        //     g.fillOval(ix+28,iy+15+25+10, 5, 5);
        //     g.fillOval(ix+33,iy+15+25+10, 5, 5);
        //     g.setColor(red);
        // }
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

    public boolean checkCollisionItem(Item t, int xDiff, int yDiff){
        //System.out.println("check col");
        // "Ball w diff (" + (ball.getX() + xDiff) + ", " + (ball.getY() + yDiff)+ ")");

        int pX = x;
        int pY = y;
        int pWidth = width;
        int pHeight = height;

        int tX = t.getX()+ xDiff;
        int tY = t.getY() + yDiff;
        int tWidth = t.getWidth();
        int tHeight = t.getHeight();
        System.out.print("");
    
        
        if( pX+pWidth >= tX && pX <= tX + tWidth && pY + pHeight >= tY && pY <= tY + tHeight){
            return true;

        }else{
            return false;
        }
    }
    public boolean checkCollisionPerson(Person t, int xDiff , int yDiff ){
        
        int pX = x;
        int pY = y;
        int pWidth = width;
        int pHeight = height;

        int tX = t.getX()+ xDiff;
        int tY = t.getY() + yDiff;
        int tWidth = t.getWidth();
        int tHeight = t.getHeight();
        System.out.print("");
        // System.out.println(tX + ", " + tY + ", " + tWidth + ", " + tHeight);
        // System.out.println(pX + ", " + pY + ", " + pWidth + ", " + pHeight);

        if( pX+pWidth >= tX && pX <= tX + tWidth && pY + pHeight >= tY && pY <= tY + tHeight){
            return true;

        }else{
            return false;
        }
    }




}