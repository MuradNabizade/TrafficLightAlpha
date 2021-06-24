package com.muradn;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class Play extends JPanel implements KeyListener, ActionListener {

    Image img = Toolkit.getDefaultToolkit().createImage("/Users/muradnabizade/Desktop/1bfecc195f9fc962f361f38bd6f59c5a.jpeg");

    //Advise-Change the car after finishing project. Color is not what i want
    Image imgCar = Toolkit.getDefaultToolkit().createImage("/Users/muradnabizade/Desktop/Daco_5666117.png");

    private boolean play=true;
    private Timer time;
    private int delay= 100;
    private  int playerX=10;


    private boolean pass=true;

    private int error=1;

    private int next;

    public Play(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        time=new Timer(delay,this);
        time.start();//
    }

    public void paint(Graphics g){



        g.setColor(Color.black);
        g.fillRect(1,1,1200,960);

        g.drawImage(img, 10, 10, null);
        g.drawImage(imgCar, playerX, 10, null);



        //pause System for Game
        g.setColor(new Color(217, 222, 221));
        g.setFont(new Font("serif",Font.BOLD,25));
        g.drawString("USE RiGHT or LEFT ARROW KEYS",100,30);

        //traffic light lane
        g.setColor(Color.orange);
        g.fillRect(900,650,20,500);




        // the ball
        g.drawImage(img, 10, 10, null);
        //traffic light lane
        g.setColor(Color.orange);
        g.fillRect(900,770,20,170);
        g.drawImage(imgCar, playerX, 700, null);

        //Traffic Light
        g.setColor(new Color(0xE80E0B0D, true));
        g.fillRect(1100,545,50,120);
        //Lights Red
        g.setColor(new Color(255, 0, 49));
        g.fillOval(1110,550,30,30);
        //Lights yellow
        g.setColor(new Color(0xE80E0B0D, true));
        g.fillOval(1110,590,30,30);
        //Lights Green
        g.setColor(new Color(0xE80E0B0D, true));
        g.fillOval(1110,630,30,30);



        if(next==3){
            //Lights yellow
            //Lights Red
            g.setColor(new Color(14, 11, 13));
            g.fillOval(1110,550,30,30);
            g.setColor(new Color(0xE80E0B0D, true));
            g.fillOval(1110,590,30,30);
            //Lights Green
            g.setColor(new Color(0xE841FF08, true));
            g.fillOval(1110,630,30,30);
            level2();
            error=2;


            g.setColor(new Color(0, 255, 29));
            g.setFont(new Font("serif",Font.BOLD,45));
            g.drawString("Hooray, Green Light! You can pass when light is Green! ",175,300);
            g.drawString("Bye!",255,400);


        }


        // Error
        if(error==1){
            g.setColor(new Color(255, 55, 0));
            g.setFont(new Font("serif",Font.BOLD,45));
            g.drawString("Failed. Keep in Mind Never Drive When Lights are Red!",175,300);
            g.drawString("Press R to Restart",255,350);
            g.drawString("Press N for Next Level",255,400);

            play=false;


        }
        else if(error==2){
            g.dispose();
            g.setColor(new Color(255, 55, 0));
            g.setFont(new Font("serif",Font.BOLD,45));
            g.drawString("Failed. ",175,300);
            g.drawString("Press R to Restart",255,350);
            g.drawString("Press N for Next Level",255,400);
        }






        g.dispose();

    }

    //light is red
    public void level1(){
        time.start();

        if(play){
            if(pass&&playerX>=820){
                error=1;
            }
            else if(pass){
                error=2;
            }



            repaint();

        }
    }
    public void level2(){
        time.start();

        if(play){
            if(pass&&playerX<=820){
                error=2;
            }
            else{
                next=3;
            }





            repaint();

        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        time.start();
        if(pass==true) {
            level1();
        }



    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            if(playerX<=10){
                playerX=100;
            }
            else{
                moveRight();
            }
        }

        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            if(playerX<=10){
                playerX=10;
            }
            else{
                moveLeft();
            }
        }
        //Restart
        if(e.getKeyCode()==KeyEvent.VK_R){
            if(!play){

                playerX=10;
                error=2;


                repaint();
            }
        }


    }
    public void moveRight(){
        play=true;
        playerX += 40;
    }
    public void moveLeft(){
        play=true;
        playerX-=40;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //Next-Yellow
        if(e.getKeyCode()==KeyEvent.VK_N){
            if(!play){

                playerX=10;
                next=3;






                repaint();
            }
        }


    }
}