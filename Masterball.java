import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Masterball extends Item{
    private BufferedImage ball;
    private int level;
    private int x;
    private int y;
    private int width;
    private int height;
    public Masterball(int x, int y, int ilevel){
            super("Masterball",x,y);
            
            width = 15;
            height = 15;
            level = ilevel;

        try {
           ball = ImageIO.read(new File("masterballedited.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void drawMe(Graphics g, int ix, int iy, int ilevel){
        level = ilevel;
        if(level >=2){
            g.drawImage(ball,ix, iy, 25, 25, null);
        }
        if(level <2){
            g.drawImage(ball,ix, iy, 15, 15, null);
        }
        //g.drawImage(ball,ix, iy, 15, 15, null);
        g.setColor(darkBlue);
        // g.drawRect(ix,iy,width,height);
        
    }
   
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
}