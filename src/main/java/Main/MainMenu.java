package Main;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class MainMenu extends BasicGameState {

    //Main menu image
    private Image mainMenu;

    //Background music
    private Music music;

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

        //Main menu reference
        mainMenu = new Image("Res/MainMenu2.png");

        //Background music in loop
        //    music = new Music("Res/*Music Reference*");
        //    music.loop();
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        //Main menu reference
        mainMenu.draw();

        //Sets graphics to color black
        graphics.setColor(Color.white);

        //Displays Main menu string
        graphics.drawString("Play: \nPress Enter", 270, 450);

        //Displays Main menu string
        graphics.drawString("Exit: \nPress ESC", 270, 500);

    }


    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

        //Input Object
        Input input = gameContainer.getInput();

        //Transition button to Town Map
        if (input.isKeyPressed(Input.KEY_ENTER)) {
            stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }

        //Transition button to exit Program
        if (input.isKeyPressed(Input.KEY_ESCAPE)) {
            System.exit(0);
        }
    }
}