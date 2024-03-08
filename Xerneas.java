import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Xerneas extends Item{
    private BufferedImage xerneas;
    private int level;
    private int x;
    private int y;
    private int width;
    private int height;
    public Xerneas(int x, int y, int ilevel){
            super("Xerneas",x,y);
            
            width = 110;
            height = 110;
            level = ilevel;

        try {
           xerneas = ImageIO.read(new File("xerneas2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void drawMe(Graphics g, int ix, int iy, int ilevel){
        level = ilevel;
        if(level ==3){
            g.drawImage(xerneas,ix, iy, 110, 110, null);
        }else if(level > 3){
            g.drawImage(xerneas,ix, iy-15, 50, 50, null);
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