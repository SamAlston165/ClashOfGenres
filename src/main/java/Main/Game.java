package Main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Game {

    public static void main(String[] args) {

        //Splashscreen Object
        // SplashScreen splash = new SplashScreen();

        //Call to splashscreen main method
        // splash.call();

        try {

            AppGameContainer container = new AppGameContainer(new GamePanel("Clash of Genres"));
            container.setDisplayMode(640, 640, false);
            container.setAlwaysRender(true);
            container.setVSync(true);
            container.setTargetFrameRate(59);
            container.setSmoothDeltas(true);
            container.setForceExit(false);
            container.start();

        } catch (SlickException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }
}