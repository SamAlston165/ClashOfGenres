package Maps;

import Entity.Character;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class TownMap extends BasicGameState {

    //Town map image
    private Image townMap;

    //Character object
    private Character kbd;

    //Default Constructor matching superclass
    public TownMap() {
        super();
    }


    @Override
    public int getID() {
        return 1;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

        //Town Map reference
        townMap = new Image("Res/TownMap.png");

        //Character reference
        kbd = new Character();

        //Initializes Character
        kbd.init(gameContainer);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        //Draws Town Map
        townMap.draw();

        //Draws Character
        kbd.render(gameContainer, graphics);

        //Displays Town Map string
        graphics.drawString("Town Map", 270, 400);

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

        //Input Object
        Input input = gameContainer.getInput();

        //Updates Character
        kbd.update(gameContainer, 0);

        //Transition button to Bar
        if (input.isKeyPressed(Input.KEY_ENTER)) {
            stateBasedGame.enterState(2, new FadeOutTransition(), new FadeInTransition());
        }

        //Transition button to Battle Map
        if (input.isKeyPressed(Input.KEY_SPACE)) {
            stateBasedGame.enterState(3, new FadeOutTransition(), new FadeInTransition());
        }

        //Transition button to exit game
        if (input.isKeyPressed(Input.KEY_ESCAPE)) {
            System.exit(0);
        }

        //Transition based from Character location
        if ((kbd.getX() == 584 && kbd.getY() <= 364) && (kbd.getX() == 584 && kbd.getY() >= 257)) {
            //int choice = JOptionPane.showConfirmDialog(null, "Do you want to travel to the Battle Map?", "", JOptionPane.YES_NO_OPTION);
            //if (choice == JOptionPane.YES_OPTION) {
                //  kbd.setX(kbd.getX() - 1);
                //  kbd.setY(kbd.getY());
                stateBasedGame.enterState(3, new FadeOutTransition(), new FadeInTransition());
            } //else if (choice == JOptionPane.NO_OPTION) {
                //stateBasedGame.getCurrentState();
            }
        }