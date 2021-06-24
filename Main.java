package com.muradn;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame obj = new JFrame();
        Play gamePlay=new Play();

        obj.setBounds(10,10,1400,960);
        obj.setTitle("Traffic Light Alpha");
        obj.setResizable(false);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gamePlay);

        obj.setVisible(true);

    }
}
