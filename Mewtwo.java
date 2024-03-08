import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Mewtwo extends Item{
    private BufferedImage mewtwo;
    private int level;
    private int x;
    private int y;
    private int width;
    private int height;
    public Mewtwo(int x, int y, int ilevel){
            super("Mewtwo",x,y);
            
            width = 70;
            height = 70;
            level = ilevel;

        try {
           mewtwo = ImageIO.read(new File("mewtwo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void drawMe(Graphics g, int ix, int iy, int ilevel){
        level = ilevel;
        if(level < 8){
            g.drawImage(mewtwo,ix, iy, 70, 70, null);
        }
        if(level ==8){
            g.drawImage(mewtwo,ix, iy, 50, 50, null);
        }
        
        
        //g.drawImage(ball,ix, iy, 15, 15, null);
        g.setColor(darkBlue);
        g.drawRect(ix,iy,width,height);
        
    }
   
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
}