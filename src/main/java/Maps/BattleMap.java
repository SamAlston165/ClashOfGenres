package Maps;

import Character.User;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class BattleMap extends BasicGameState {

    //Battle map image
    private Image battleMap;

    //User object
    private User kbd;

    //Default Constructor matching superclass
    public BattleMap() {
        super();
    }

    @Override
    public int getID() {
        return 3;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

        //Battle Map reference
        battleMap = new Image("Res/BattleMap.png");

        //Character reference
        kbd = new User();

        //Initializes Character
        kbd.init(gameContainer);


    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        //Draws Battle Map
        battleMap.draw();

        //Sets graphics to color white
        graphics.setColor(Color.white);

        //Draws Character
        kbd.render(gameContainer, graphics);

        //Displays Battle Map string
        graphics.drawString("Battle Map", 270, 400);

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

        //Input Object
        Input input = gameContainer.getInput();

        //Gets user coordinates and updates the user
        kbd.setX(kbd.getX());
        kbd.setY(kbd.getY());
        kbd.update(gameContainer, 0);

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
        if ((kbd.getX() == -38) && (kbd.getY() <= 271 || kbd.getY() >= 201)) {
            kbd.setX(kbd.getX() + 1);
            kbd.setY(kbd.getY());
            stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }

        //Transition based from User location
        if ((kbd.getX() == 520) && (kbd.getY() <= 299 || kbd.getY() >= 194)) {
            kbd.setX(kbd.getX() - 1);
            kbd.setY(kbd.getY());
            stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }
    }
}

