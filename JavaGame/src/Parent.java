import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by JATIN on 23-11-2015.
 */
public class Parent {
    public static void main(String[] args) {
        int E=0;
        JFrame jframe1 = new JFrame();
        JFrame jframe2=new JFrame();
        jframe1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Stage2Screen mainPanel = new Stage2Screen();
        Stage3Screen mainPanel3 = new Stage3Screen();
        mainPanel.setPreferredSize(new Dimension(800, 450));
        mainPanel.setFocusable(true);
        mainPanel.requestFocus();
        mainPanel3.setPreferredSize(new Dimension(624, 352));
        mainPanel3.setFocusable(true);
        mainPanel3.requestFocus();

        mainPanel.addKeyListener(mainPanel);
        mainPanel.addMouseListener(mainPanel);

        jframe1.add(mainPanel);
        jframe1.setResizable(false);
        jframe1.pack();
        jframe2.add(mainPanel3);
        jframe2.setResizable(false);
        jframe2.pack();


        BufferedImage image1 = Stage2Screen.loadImage("run_anim1.png");
        BufferedImage image2 = Stage2Screen.loadImage("run_anim2.png");
        BufferedImage image3 = Stage2Screen.loadImage("run_anim3.png");
        BufferedImage image4 = Stage2Screen.loadImage("run_anim4.png");
        BufferedImage image5 = Stage2Screen.loadImage("run_anim5.png");
        BufferedImage playerImages[] = {image1, image2, image3, image4, image5, image4, image3, image2};
        int counter = 0;
        Random generator = new Random();

        while(true) {

            if(mainPanel.playerX>-10) {
                if (!mainPanel.isPaused) {

                    counter++;

                    counter = counter % 8;

                    mainPanel.playerImage = playerImages[counter];
                    mainPanel.playerVelocityY += mainPanel.playerAccY;
                    mainPanel.playerY += mainPanel.playerVelocityY;


                    if (mainPanel.playerY == 450 - 45 - 90) {
                        mainPanel.playerY = 450 - 45 - 90 ;
                        mainPanel.playerVelocityY = 0;
                        mainPanel.playerAccY = 0;
                    }

                    if (mainPanel.cloud1X <= -100) {
                        mainPanel.cloud1Y = generator.nextInt(190) + 10;
                        mainPanel.cloud1X = 900;
                        mainPanel.cloud1Visible = true;
                    }

                    if (mainPanel.cloud2X <= -100) {
                        mainPanel.cloud2Y = generator.nextInt(190) + 10;
                        mainPanel.cloud2X = 900;
                    }
                    if (mainPanel.blockX1 <= -50) {
                        mainPanel.blockX1 = generator.nextInt(100)+850;
                        mainPanel3.E++;
                        mainPanel.blockX1Visible = true;
                    }
                    if (mainPanel.blockX2 <= -50) {
                        mainPanel.blockX2 = generator.nextInt(100)+ 850;
                        mainPanel3.E++;
                        mainPanel.blockX2Visible = true;
                    }

                    if (mainPanel.blockX3 <= -50) {
                        mainPanel.blockX3 = generator.nextInt(100)+ 850;
                        mainPanel3.E++;
                        mainPanel.blockX3Visible = true;
                    }


                    mainPanel.cloud1X -= 2;
                    mainPanel.cloud2X -= 3;
                    mainPanel.blockX1 -= 5;
                    mainPanel.blockX2 -= 5;
                    mainPanel.blockX3 -= 5;

                    Rectangle playerRectangle = new Rectangle(mainPanel.playerX, mainPanel.playerY, 72, 90);
                    Rectangle blockX1Rectangle = new Rectangle(mainPanel.blockX1, mainPanel.blockY1, 20, 50);
                    Rectangle blockX2Rectangle = new Rectangle(mainPanel.blockX2, mainPanel.blockY2, 20, 50);
                    Rectangle blockX3Rectangle = new Rectangle(mainPanel.blockX3, mainPanel.blockY3, 20, 50);


                    if (mainPanel.blockX1Visible && playerRectangle.intersects(blockX1Rectangle)) {
                        mainPanel.blockX1Visible = false;
                        mainPanel.playerX -= 5;
                    }
                    if (mainPanel.blockX2Visible && playerRectangle.intersects(blockX2Rectangle)) {
                        mainPanel.blockX2Visible = false;
                        mainPanel.playerX -= 5;

                    }
                    if (mainPanel.blockX3Visible && playerRectangle.intersects(blockX3Rectangle)) {
                        mainPanel.blockX3Visible = false;
                        mainPanel.playerX -= 5;
                    }


                }

                jframe1.setVisible(true);
                jframe2.setVisible(false);
                mainPanel.repaint();
                mainPanel.repaint();

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else
            {
                jframe1.setVisible(false);
                jframe2.setVisible(true);
                mainPanel3.repaint();
            }



        }
    }
}
