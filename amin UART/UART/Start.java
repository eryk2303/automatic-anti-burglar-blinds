import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *class for calling uart scripts
 */
public class Start {

    JFrame frame;
    JButton up, down, homeUp, homeDown, read, autoB;
    JLabel temperatureInfo;
    JCheckBox auto;

    /**
     *
     * script call constructor
     */
    public Start()
    {
        frame = new JFrame();
       
 	    frame.setSize(400, 300);
        /**
         * button for send CheckBox
         */
        autoB = new JButton("send CheckBox");
        autoB.setBounds(100,150, 200,50);
        frame.add(autoB);
        autoB.addActionListener(e -> {
            if(auto.isSelected()) {
                String cmd = "sudo python3 disable.py";
                Runtime run = Runtime.getRuntime();
                try {
                    Process pr = run.exec(cmd);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            else
            {
                String cmd = "sudo python3 able.py";
                Runtime run = Runtime.getRuntime();
                try {
                    Process pr = run.exec(cmd);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        /**
         * check box for check right mode
         */
        auto = new JCheckBox("zablokuj");
        auto.setBounds(100,100, 200,50);
        frame.add(auto);


   
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);




    }


    public static void main(String s[]) {
        new Start();

    }

}
