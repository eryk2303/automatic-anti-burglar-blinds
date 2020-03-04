import javax.swing.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Start {

    JFrame frame;
    JButton up, down, homeUp, homeDown, read;
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
            if(!auto.isSelected())
            {
                String cmd = "python up_noauto.py";
                Runtime run = Runtime.getRuntime();
                try {
                    Process pr = run.exec(cmd);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }


            else
            {

                String cmd = "python up_auto.py";
                Runtime run = Runtime.getRuntime();
                try {
                    Process pr = run.exec(cmd);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        });


        down = new JButton("DOWN");
        down.setBounds(40, 220, 85, 100);
        frame.add(down);
        down.addActionListener(e -> {
            if(!auto.isSelected())
            {

                String cmd = "python down_noauto.py";
                Runtime run = Runtime.getRuntime();
                try {
                    Process pr = run.exec(cmd);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            else
            {
                String cmd = "python down_auto.py";
                Runtime run = Runtime.getRuntime();
                try {
                    Process pr = run.exec(cmd);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        });

        homeUp = new JButton("Home");
        homeUp.setBounds(150, 100, 85, 100);
        frame.add(homeUp);
        homeUp.addActionListener(e -> {
            if(!auto.isSelected())
            {
                String cmd = "python homeUp_noauto.py";
                Runtime run = Runtime.getRuntime();
                try {
                    Process pr = run.exec(cmd);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }


            else
            {

                String cmd = "python homeUp_auto.py";
                Runtime run = Runtime.getRuntime();
                try {
                    Process pr = run.exec(cmd);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        });


        homeDown = new JButton("Home");
        homeDown.setBounds(150, 220, 85, 100);
        frame.add(homeDown);
        homeDown.addActionListener(e -> {
            if(!auto.isSelected())
            {
                String cmd = "python homeDown_noauto.py";
                Runtime run = Runtime.getRuntime();
                try {
                    Process pr = run.exec(cmd);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }


            else
            {

                String cmd = "python homeDown_auto.py";
                Runtime run = Runtime.getRuntime();
                try {
                    Process pr = run.exec(cmd);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        });

        read = new JButton("update");
        read.setBounds(250, 50, 100, 20);
        frame.add(read );
        read .addActionListener(e -> {

            String cmd = "python read.py";
            Runtime run = Runtime.getRuntime();
            try {

                Process pr = run.exec(cmd);
                Scanner fromProc = new Scanner(new InputStreamReader(pr.getInputStream()));
                while (fromProc.hasNextLine()) {
                    temperature = fromProc.nextLine();
                    temperatureInfo.setText("Temperatura na zewnatrz: "+ temperature);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }


        });

        temperatureInfo = new JLabel();
        frame.add(temperatureInfo);
        temperatureInfo.setBounds(250, 20, 250, 30);
        temperatureInfo.setText("Temperatura na zewnatrz: "+ temperature);


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


