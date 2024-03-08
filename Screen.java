import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Font;
import javax.sound.sampled.*;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;



public class Screen extends JPanel implements KeyListener {

    private Player p1;
    private Tree t1;
    private Oak oak;
    private Masterball ball;
    private Misty misty;
    private Meowth meowth;
    private Xerneas xerneas;
    private Jessie jessie;
    private James james;
    private Mewtwo mewtwo;
    
    private int xDiff;
    private int yDiff;
    private int level= 0;
    private Clip clip;

    private BufferedImage map;
    private int mapHeight = 2000;
    private int mapWidth = 3200;
    private boolean gameScreen = true;
    private boolean foundBall = false;
    private boolean masterballMessage = false;
    private boolean talkMisty = false;
    private boolean capture = false;
    private boolean meowthTalk = false;
    private ArrayList<Item> inventory;
    private boolean jessieTalk = false;
    private boolean jamesTalk = false;
    private boolean rocketTalk = false;
    private boolean rocketTalk2 = false;
    private boolean rocketTalk3 = false;
    private boolean endScreen = false;


    private boolean oakMessage = false;

    private Color lightBlue = new Color(153, 229, 255);
    private Color lightBlue2 = new Color(153, 229, 255, 200);
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


    public Screen() {
        loadSound();

        //sets up the instance variables		
        p1 = new Player(380, 260);
        //t1 = new Tree(500, 150);
        oak = new Oak(xDiff+750+380+70, yDiff+1275+260, level);
		ball = new Masterball(xDiff+2040+380, yDiff+1275+260, level);
        misty = new Misty(xDiff+2500, yDiff+500+260, level);
        meowth = new Meowth(xDiff+500, yDiff+360, level);
        xerneas = new Xerneas(xDiff+1700, yDiff+150+260, level);
        jessie = new Jessie(xDiff+750+380+70, yDiff+1275+260, level);
        james = new James(xDiff+750+380+70+50, yDiff+1275+260, level);
        mewtwo = new Mewtwo(xDiff+750+380+70+50+100, yDiff+1275+260, level);
		//set x and y diff
		xDiff = 0;
		yDiff = 0;
        //sets keylistener
        setFocusable(true);
        addKeyListener(this);
        inventory = new ArrayList<Item>();
        
       

        

        try {
           map = ImageIO.read(new File("gamemap1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Dimension getPreferredSize() {
        //Sets the size of the panel
        return new Dimension(800, 600);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(map, xDiff, yDiff, mapWidth, mapHeight, null);
        
        
        oak.drawMe(g, xDiff+750+380+70, yDiff+1275+260,level);
        misty.drawMe(g, xDiff+2500, yDiff+500+260,level);
        meowth.drawMe(g, xDiff+500, yDiff+360, level);
        if(level > 4){
            jessie.drawMe(g, xDiff+750+380+70, yDiff+1275+260, level);
            james.drawMe(g, xDiff+750+380+70+50, yDiff+1275+260, level);
        }
        if(level<4){
            xerneas.drawMe(g, xDiff+1700, yDiff+150+260, level);
        }
        if(level >5){
            mewtwo.drawMe(g, xDiff+750+380+70+50+50, yDiff+1275+260,level);
        }
        if(endScreen==true){
            mewtwo.drawMe(g, 600+50+100, 30,level);
        }

        p1.drawMe(g,level);
        if(level < 2){
            ball.drawMe(g,xDiff+2040+380, yDiff+1275+260, level);
        }
        

        int invX = 600;
        int invY = 30;
        g.setColor(lightBlue2);
        g.fillRect(575,15,200,50);
        for(int i = 0; i < inventory.size(); i++){
            inventory.get(i).drawMe(g,invX,invY,level);
            invX+=50;
        }
        if(gameScreen == true){
            g.setColor(lightBlue);
            g.fillRect(100,100,600,400);
            g.setColor(black);
            g.drawString("Welcome  " , 150,150);
            g.drawString("Team Rocket, an evil and corrupt organization, has taken over." , 150,230);
            g.drawString("You turn to your mentor for guidance." , 150,260);
            g.drawString("Objective: Find Professor Oak" , 150,290);
            g.drawString("Hint: travel south, look for a house" , 150,320);
            g.drawString("Press X to start", 150,400);
        }
        if(oakMessage == true){
            g.setColor(lightBlue);
            g.fillRect(100,100,600,400);
            g.setColor(black);
            g.drawString("Professor Oak" , 150,150);
            g.drawString("\"Team Rocket has grown too powerful..." , 150,230);
            g.drawString("Only the power of an ancient, legendary pokemon can stop them..." , 150,260);
            g.drawString("Maybe a masterball could assist you in capturing one...\"" , 150,290);
            g.drawString("Objective: Find a masterball", 150,375);
            //g.drawString("Hint: n/a", 150,400);
            g.drawString("Press X to continue", 150,450);
        }
        if(masterballMessage == true){
            g.setColor(lightBlue);
            g.fillRect(100,100,600,400);
            g.setColor(black);
            //g.drawString("" , 150,150);
            g.drawString("You now own a masterball." , 150,230);
            g.drawString("With this you can capture a legendary pokémon, but which one?" , 150,260);
            g.drawString("You wonder if your good friend Misty could give you advice..." , 150,290);
            g.drawString("Objective: Find Misty", 150,375);
            //g.drawString("Hint: n/a", 150,400);
            g.drawString("Press X to continue", 150,450);
        }
        if(talkMisty == true){
            g.setColor(lightBlue);
            g.fillRect(100,100,600,400);
            g.setColor(black);
            g.drawString("Misty" , 150,150);
            g.drawString("\"Hey! It's been a while." , 150,230);
            g.drawString("I've heard the legendary pokémon Xerneas has awoken, and is no longer in its tree form." , 150,260);
            g.drawString("It's time to put your masterball to use!\"" , 150,290);
            g.drawString("Objective: Capture Xerneas", 150,375);
            //g.drawString("Hint: n/a", 150,400);
            g.drawString("Press X to continue", 150,450);
        }

        if(capture == true){
            g.setColor(lightBlue);
            g.fillRect(100,100,600,400);
            g.setColor(black);
            //g.drawString("Misty" , 150,150);
            g.drawString("You have captured the legendary pokémon Xerneas with your masterball!" , 150,230);
            g.drawString("Look for Meowth and trick him into telling you where Team Rocket is!" , 150,260);
            //g.drawString("It's time to put your masterball to use!" , 150,290);
            g.drawString("Objective: Find Meowth", 150,375);
            //g.drawString("Hint: n/a", 150,400);
            g.drawString("Press X to continue", 150,450);
        }
        if(meowthTalk == true){
            g.setColor(lightBlue);
            g.fillRect(100,100,600,400);
            g.setColor(black);
            g.drawString("Meowth" , 150,150);
            g.drawString("\"Oh crud! You've got Xerneas?!" , 150,230);
            g.drawString("Fine, they're near Professor Oak's lab" , 150,260);
            g.drawString("Don't hurt me please!\"" , 150,290);
            g.drawString("Objective: Defeat Team Rocket", 150,375);
            //g.drawString("Hint: n/a", 150,400);
            g.drawString("Press X to continue", 150,450);
        }
        if(rocketTalk == true){
            g.setColor(lightBlue);
            g.fillRect(100,100,600,400);
            g.setColor(black);
            g.drawString("You" , 150,150);
            g.drawString("\"Xerneas! Attack.\"" , 150,230);
            // g.drawString("" , 150,260);
            // g.drawString("Don't hurt me please!\"" , 150,290);
            // g.drawString("Objective: Defeat Team Rocket", 150,375);
            //g.drawString("Hint: n/a", 150,400);
            g.drawString("Press X to continue", 150,450);
        }
        if(rocketTalk2 == true){
            g.setColor(lightBlue);
            g.fillRect(100,100,600,400);
            g.setColor(black);
            g.drawString("James" , 150,150);
            g.drawString("\"Ahhhh! You win! Take Mewtwo from us!\"" , 150,230);
            // g.drawString("" , 150,260);
            // g.drawString("Don't hurt me please!\"" , 150,290);
            g.drawString("Objective: Collect Mewtwo to liberate the world from Team Rocket", 150,375);
            //g.drawString("Hint: n/a", 150,400);
            g.drawString("Press X to continue", 150,450);
        }
        // if(rocketTalk3 == true){
            
        // }
        if(endScreen == true){
            g.setColor(lightBlue);
            g.fillRect(0,0,800,600);
            g.setColor(black);
            g.drawString("YOU WIN" , 150,150);
            g.drawString("You saved the Day!" , 150,230);
            // g.drawString("" , 150,260);
            // g.drawString("Don't hurt me please!\"" , 150,290);
            // g.drawString("Objective: Defeat Team Rocket", 150,375);
            //g.drawString("Hint: n/a", 150,400);
            //g.drawString("Press X to continue", 150,450);
        }

        


    }


    //implement methods of the KeyListener
    public void keyPressed(KeyEvent e) {

        //System.out.println("key code: " + e.getKeyCode());
        if(e.getKeyCode() == 65){
        	// System.out.println("");
            // System.out.println("(" + p1.getX() + ", " + p1.getY() + ")");

            System.out.println("xDiff: " + xDiff + ", yDiff: " + yDiff);
            System.out.println("level: " + level);
            // System.out.println("Player: (" + (xDiff +2000) + ", " + (yDiff + 2810) + ")");

            // System.out.println("ball:   (" + ball.getX() + ", " + ball.getY() + " ) width " + ball.getWidth() + "height " + ball.getHeight() + " coll: " + foundBall);
            // System.out.println("oak     (" + oak.getX() + " , " + oak.getY() + ") width " + oak.getWidth() + " height " + oak.getHeight() + " coll: " + oakMessage);
            System.out.println("");

            // System.out.println("Player      (" + p1.getX() + ", " + p1.getY() + ")");
            // System.out.println("misty        (" + misty.getX() + ", " + misty.getY() + ")");
            // System.out.println("misty w diff (" + (misty.getX() + xDiff) + ", " + (misty.getY() + yDiff)+ ")");
        }
        if(e.getKeyCode() == 88){
        	gameScreen = false;
            oakMessage = false;
            masterballMessage = false;
            talkMisty = false; 
            capture = false;  
            meowthTalk = false; 
            rocketTalk2 = false;
            // if(rocketTalk == true){
            //     rocketTalk2 = true;
            // } 
            if(rocketTalk == true){
                rocketTalk = false;
                rocketTalk2 = true;
                setLevel(7);
            }  else if(rocketTalk2 == true){
                rocketTalk2 = false;
                setLevel(8);
            }
            // if(level == 6){
            //     rocketTalk2 = true;
            //     setLevel(7);
            // }
            // if(level == 7){
            //     rocketTalk3 = true;
            //     setLevel(8);
            // }
            // if(level == 8){
            //     endScreen = false;
            // }       
        }
        if(e.getKeyCode() == 79){
        	if(level==0){
                level = 1;
                oakMessage = true;
            }else if(level == 1){
                level = 2;
                masterballMessage = true;
                inventory.add(ball);

            }else if(level == 2){
                level = 3;
                talkMisty= true;
            }else if(level == 3){
                level = 4;
                capture= true;
                inventory.add(xerneas);

            }else if(level == 4){
                level = 5;
                meowthTalk= true;
            }else if(level == 5){
                level = 6;
                rocketTalk= true;
            }else if(level == 6){
                level = 7;
                rocketTalk2= true;
            }else if(level == 7){
                level = 8;
                rocketTalk3= true;
            }else if(level == 8){
                level = 9;
                endScreen= true;
            }   
        }

        if(e.getKeyCode() == 37){
        	xDiff += 15;
        }
        if(e.getKeyCode() == 39){
        	xDiff -= 15;
        }
        if(e.getKeyCode() == 38){
        	yDiff += 15;
        }
        if(e.getKeyCode() == 40){
        	yDiff -= 15;
        }
        if(xDiff >= 0){
            xDiff = 0;
        }
        if(yDiff >= 5){
            yDiff = 0;
        }
        if(xDiff <= -mapWidth+800){
            xDiff = -mapWidth +800;
        }
        if(yDiff <= -mapHeight +600){
            yDiff = -mapHeight +600;
        }
        
        
        repaint();

    }
    public void animate(){
        playSound();
        p1.setXY(xDiff + 380, yDiff + 260);
        while(true){
            while(level == 0){
                oakMessage = p1.checkCollisionPerson(oak,xDiff,yDiff);
                if(oakMessage == true){
                    setLevel(1);
                }
                try{
                    Thread.sleep(10); //milliseconds
                } catch (InterruptedException ex){
                    Thread.currentThread().interrupt();
                }

            }
            while(level == 1){
                // foundBall = p1.checkCollisionItem(ball,xDiff,yDiff);
                foundBall = p1.checkCollisionItem(ball,xDiff,yDiff);
                // System.out.print(foundBall);
                if (foundBall==true){
                    setLevel(2);
                    masterballMessage = true;
                    inventory.add(ball);
                    playChimeSound();
                }
                
            }
            while(level == 2){
                // foundBall = p1.checkCollisionItem(ball,xDiff,yDiff);
                talkMisty = p1.checkCollisionPerson(misty,xDiff,yDiff);
                // System.out.print(foundBall);
                if (talkMisty==true){
                    //System.out.print("works");
                    setLevel(3);
                }
                
            }
            while(level == 3){
                // foundBall = p1.checkCollisionItem(ball,xDiff,yDiff);
                capture = p1.checkCollisionItem(xerneas,xDiff,yDiff);
                // System.out.print(foundBall);
                if (capture==true){
                    //System.out.print("works");
                    inventory.add(xerneas);
                    setLevel(4);
                    playChimeSound();

                }
                
            }
            while(level == 4){
                // foundBall = p1.checkCollisionItem(ball,xDiff,yDiff);
                meowthTalk = p1.checkCollisionItem(meowth,xDiff,yDiff);
                // System.out.print(foundBall);
                if (meowthTalk==true){
                    setLevel(5);
                }
                
            }
            while(level == 5){
                // foundBall = p1.checkCollisionItem(ball,xDiff,yDiff);
                jessieTalk = p1.checkCollisionPerson(jessie,xDiff,yDiff);
                jamesTalk = p1.checkCollisionPerson(james,xDiff,yDiff);
                rocketTalk = jessieTalk||jamesTalk;
                // System.out.print(foundBall);
                if (rocketTalk==true){
                    // System.out.print("works");
                    setLevel(6);
                }
                
            }
            
            while(level == 7){
                // foundBall = p1.checkCollisionItem(ball,xDiff,yDiff);
                endScreen = p1.checkCollisionItem(mewtwo,xDiff,yDiff);
                // System.out.print(foundBall);
                if (endScreen==true){
                    //playChimeSound();

                }
                
            }

            

            repaint(); 
        }  
         
            
    }


    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
    public void setLevel(int i){
        level = i;
    }
    public void playSound() {
        if(!clip.isRunning()){
            clip.start();
        }
    }
    public void loadSound(){
        try {
            // if(clip == null){
            clip = AudioSystem.getClip();
            // }
            // if(clip.isRunning() == false){
            URL url = this.getClass().getClassLoader().getResource("pokemusic3.wav");
            clip.open(AudioSystem.getAudioInputStream(url));
            // }
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }
    public void playChimeSound() {
        try {
            URL url2 = this.getClass().getClassLoader().getResource("chime.wav");
            Clip clip2 = AudioSystem.getClip();
            clip2.open(AudioSystem.getAudioInputStream(url2));
            clip2.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }
}