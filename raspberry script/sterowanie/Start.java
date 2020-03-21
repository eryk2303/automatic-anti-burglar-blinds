import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Start {

    JFrame frame;
    JButton up, down, homeUp, homeDown, read, autoB;
    String temperature = "0";
    JLabel temperatureInfo;
    JCheckBox auto;

    public Start()
    {
        frame = new JFrame();
        up = new JButton("UP");
        up.setBounds(40, 100, 85, 100);
        frame.add(up);
        up.addActionListener(e -> {

                String cmd = "sudo ./up";
                Runtime run = Runtime.getRuntime();
                try {
                    Process pr = run.exec(cmd);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

        });


        down = new JButton("DOWN");
        down.setBounds(40, 220, 85, 100);
        frame.add(down);
        down.addActionListener(e -> {

                String cmd = "sudo ./down";
                Runtime run = Runtime.getRuntime();
                try {
                    Process pr = run.exec(cmd);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }


        });

        homeUp = new JButton("Home");
        homeUp.setBounds(150, 100, 85, 100);
        frame.add(homeUp);
        homeUp.addActionListener(e -> {

                String cmd = "sudo ./homeUp";
                Runtime run = Runtime.getRuntime();
                try {
                    Process pr = run.exec(cmd);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }


        });


        homeDown = new JButton("Home");
        homeDown.setBounds(150, 220, 85, 100);
        frame.add(homeDown);
        homeDown.addActionListener(e -> {

                String cmd = "sudo ./homeDown";
                Runtime run = Runtime.getRuntime();
                try {
                    Process pr = run.exec(cmd);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }


        });

        
        autoB = new JButton("send CheckBox");
        autoB.setBounds(250,150, 200,50);
        frame.add(autoB);
        autoB.addActionListener(e -> {
            if(auto.isSelected()) {
                String cmd = "sudo ./auto";
                Runtime run = Runtime.getRuntime();
                try {
                    Process pr = run.exec(cmd);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            else
            {
                String cmd = "sudo ./noauto";
                Runtime run = Runtime.getRuntime();
                try {
                    Process pr = run.exec(cmd);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        


        auto = new JCheckBox("Tryb automatyczny");
        auto.setBounds(250,100, 200,50);
        frame.add(auto);


        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);




    }


    public static void main(String s[]) {
        new Start();

    }

}
