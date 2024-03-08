import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Meowth extends Item{
    private BufferedImage meowth;
    private int level;
    private int x;
    private int y;
    private int width;
    private int height;
    public Meowth(int x, int y, int ilevel){
            super("Meowth",x,y);
            
            width = 50;
            height = 50;
            level = ilevel;

        try {
           meowth = ImageIO.read(new File("meowth.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void drawMe(Graphics g, int ix, int iy, int ilevel){
        level = ilevel;
        if(level ==4){
            g.drawImage(meowth,ix, iy, 50, 60, null);
        }
        //g.drawImage(ball,ix, iy, 15, 15, null);
        g.setColor(darkBlue);
        //g.drawRect(ix,iy,width,height);
        
    }
   
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
}