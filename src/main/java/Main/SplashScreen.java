package Main;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SplashScreen extends JPanel {
    JProgressBar pb;

    public SplashScreen() {
        pb = new JProgressBar();
        pb.setBounds(50, 50, 250, 30);
        pb.setValue(0);
        pb.setStringPainted(true);
        this.add(pb);
        this.setSize(450, 450);
        this.setLocation(100, 450);
        pb.setBackground(Color.BLACK);

    }

    public void update() {
        int i = -1;
        while (i < 100) {
            pb.setValue(i);
            i++;

            if (i == 0) {
                pb.setStringPainted(true);
                pb.setForeground(Color.GREEN);
            }

            if (i == 25) {
                pb.setStringPainted(true);
                pb.setForeground(Color.GREEN);
            }

            if (i == 50) {
                pb.setStringPainted(true);
                pb.setForeground(Color.GREEN);
            }

            if (i == 75) {
                pb.setStringPainted(true);
                pb.setForeground(Color.GREEN);
            }
            //simulate heavy stuff
            try {
                Random generator = new Random();
                int Low = 10;
                int High = 100;
                int result = generator.nextInt(High - Low) + Low;
                Thread.sleep(result);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


    public void call() {
        SplashScreen.main(null);
    }

    public static void main(String[] args) {
        JWindow window = new JWindow();
        SplashScreen kbs = new SplashScreen();
        window.getContentPane().add(kbs);
        window.getContentPane().add(new JLabel("", new ImageIcon("Res/Splash.png"), SwingConstants.CENTER));
        window.pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension labelSize = window.getPreferredSize();
        window.setLocation(screenSize.width / 2 - (labelSize.width / 2), screenSize.height / 2 - (labelSize.height / 2));
        window.setVisible(true);

        try {
            kbs.setOpaque(false);
            kbs.setVisible(true);
            kbs.update();
            kbs.setVisible(false);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        window.dispose();
    }
}