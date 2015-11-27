import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Created by JATIN on 23-11-2015.
 */
public class Stage2Screen extends JPanel implements KeyListener, MouseListener {
    public int cloud1X = 400;
    public int cloud1Y = 150;
    public int cloud2X = 900;
    public int cloud2Y = 70;
    public int cloud3X = 650;
    public int cloud4X=720;
    public int cloud3Y =100;
    public int cloud4Y=120;
    public int playerVelocityY = 0;
    public int playerAccY = 0;
    public int playerX=100;
    public int playerY = 450 - 45 - 90;
    public boolean cloud1Visible = true;
    public boolean blockX1Visible=true;
    public boolean blockX2Visible=true;
    public boolean blockX3Visible=true;
    public int blockX1=1000;
    public int blockY1=360;
    public int blockX2=1300;
    public int blockY2=270;
    public int blockX3=1600;
    public int blockY3=360;

    public boolean isPaused = false;

    BufferedImage pause=Stage2Screen.loadImage("paused.png");
    BufferedImage playerImage = Stage2Screen.loadImage("run_anim1.png");
    BufferedImage grassImage = Stage2Screen.loadImage("grass.png");
    BufferedImage cloud1Image = Stage2Screen.loadImage("cloud1.png");
    BufferedImage cloud2Image = Stage2Screen.loadImage("cloud2.png");
    BufferedImage cloud3Image = Stage2Screen.loadImage("cloud1.png");
    BufferedImage cloud4Image = Stage2Screen.loadImage("cloud2.png");
    BufferedImage Block1=Stage2Screen.loadImage("block.png");
    BufferedImage Block3=Stage2Screen.loadImage("block.png");
    BufferedImage Block2=Stage2Screen.loadImage("block.png");
    BufferedImage jump=Stage2Screen.loadImage("jump.png");
    BufferedImage duck=Stage2Screen.loadImage("duck.png");

    public Color skyBlueColor = new Color(208, 244, 247);

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);



            g.setColor(Color.BLACK);

            g.fillRect(0, 0, 800, 450);

        if(!isPaused){
            g.drawImage(pause, 750, 0, null);
        }
        g.drawImage(cloud1Image, cloud1X, cloud1Y, null);
        g.drawImage(cloud2Image, cloud2X, cloud2Y, null);

        if(playerY==315) {
            g.drawImage(playerImage, playerX, playerY, null);
        }
        else if(playerY<315)
        {
            g.drawImage(jump,playerX,playerY,null);
        }
        else
        {
            g.drawImage(duck,playerX,314,null);
        }
        g.drawImage(grassImage, 0, 450 - 45, null);
        if (this.blockX1Visible) {
            g.drawImage(Block1, blockX1, blockY1, null);
        }

        if (this.blockX2Visible) {
            g.drawImage(Block2, blockX2, blockY2, null);
        }
        if (this.blockX3Visible) {
            g.drawImage(Block3, blockX3, blockY3, null);
        }
    }

    public static BufferedImage loadImage(String filename) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(Stage2Screen.class
                    .getResourceAsStream("/" + filename));
        } catch (IOException e) {
            System.out.println("Error while reading: " + filename);
            e.printStackTrace();
        }
        return img;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE && this.playerY == 450 - 45 -90) {
            this.playerVelocityY = -20;
            this.playerAccY = 1;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_DOWN && this.playerY==450-45-90){
            this.playerVelocityY= 20;
            this.playerAccY= -1;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getX() > 750 && e.getY() < 50) {
            this.isPaused = !this.isPaused;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}