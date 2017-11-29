package Maps;

import Entity.User;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Bar extends BasicGameState {

    //Bar map image
    private Image bar;

    //User object
    private User user;

    //Default Constructor matching superclass
    public Bar() {
        super();
    }

    @Override
    public int getID() {
        return 2;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

        //Bar Map reference
        bar = new Image("Res/Bar.png");

        //Character reference
        user = new User();

        //Initializes Character
        user.init(gameContainer);

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        //Draws Bar Map
        bar.draw();

        //Draws Character
        user.render(gameContainer, graphics);

        //Displays Bar Map string
        graphics.drawString("Bar", 270, 400);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

        //Input Object
        Input input = gameContainer.getInput();

        //Gets user coordinates and updates the user
        user.setX(user.getX());
        user.setY(user.getY());
        user.update(gameContainer, 0);


        //Transition button to Town Map
        if (input.isKeyPressed(Input.KEY_ENTER)) {
            stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }

        //Transition button to Town Map
        if (input.isKeyPressed(Input.KEY_SPACE)) {
            stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }

        //Transition button to exit game
        if (input.isKeyPressed(Input.KEY_ESCAPE)) {
            System.exit(0);
        }

        //Transition based from User location
        if ((user.getX() == -38) && (user.getY() <= 271 || user.getY() >= 201)) {
            user.setX(user.getX() + 1);
            user.setY(user.getY());
            stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }

        //Transition based from User location
        if ((user.getX() == 520) && (user.getY() <= 299 || user.getY() >= 194)) {
            user.setX(user.getX() - 1);
            user.setY(user.getY());
            stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }
    }
}