package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Destinations extends JFrame implements Runnable {

    Thread t1;
    JLabel[] label = new JLabel[9];  // Array size should be 9

    public void run() {
        try {
            for (int i = 0; i < label.length; i++) {  // Loop should run from 0 to 8
                label[i].setVisible(true);
                Thread.sleep(2500);
                label[i].setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Destinations() {
        setBounds(500, 200, 800, 600);

        ImageIcon[] image = new ImageIcon[9];  // Array size should be 9
        Image[] jimage = new Image[9];
        ImageIcon[] kimage = new ImageIcon[9];

        for (int i = 0; i < 9; i++) {
            image[i] = new ImageIcon(ClassLoader.getSystemResource("icons/dest" + (i + 1) + ".jpg"));
            jimage[i] = image[i].getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
            kimage[i] = new ImageIcon(jimage[i]);
            label[i] = new JLabel(kimage[i]);
            label[i].setBounds(0, 0, 800, 600);
            add(label[i]);
            label[i].setVisible(false); // Set all labels to invisible initially
        }

        t1 = new Thread(this);
        t1.start();

        setVisible(true);
    }

    public static void main(String args[]) {
        new Destinations();
    }
}
