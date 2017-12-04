package Maps;

import Entity.Character;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Bar extends BasicGameState {

    //Bar map image
    private Image bar;

    boolean quit = false;
    //Character object
    private Character kbd;

    //Default Constructor matching superclass
    public Bar() {
        super();
    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException
    {

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
        kbd = new Character();

        //Initializes Character
        kbd.init(gameContainer);

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        //Draws Bar Map
        bar.draw();

        //Draws Character
        kbd.render(gameContainer, graphics);

        //Displays Bar Map string
       // graphics.drawString("Bar", 270, 400);

        //Display Pause Menu
        if(quit == true)
        {
            graphics.setColor(Color.black);
            graphics.fillRect(180, 200, 280, 240);
            graphics.setColor(Color.white);
            graphics.drawRect(180, 200, 280, 240);
            graphics.drawString("Resume (ESC)", 250, 250);
            graphics.drawString("Quit   ( Q )", 250, 300);
            graphics.drawString("", 250, 350);
            //Clears Pause Menu
            if(quit == false)
            {
                graphics.clear();
            }
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

        //Input Object
        Input input = gameContainer.getInput();

        //Gets character coordinates and updates the character
        kbd.setX(kbd.getX());
        kbd.setY(kbd.getY());

        //Int contains duration of animation
        kbd.update(gameContainer, 0);


        //Transition button to Town Map
        if (input.isKeyDown(Input.KEY_ENTER)) {
            stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }

        //Transition button to Town Map
        if (input.isKeyDown(Input.KEY_SPACE)) {
            stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }

        if(quit == true)
        {
            if(input.isKeyPressed(Input.KEY_ESCAPE))
            {
                quit = false;
            }
            if(input.isKeyDown(Input.KEY_Q))
            {
                System.exit(0);
            }
        }

        //Transition button to exit game
        if (input.isKeyDown(Input.KEY_ESCAPE) && quit == false) {
            quit = true;
        }

        //Detects collision on outer bounds
        if (kbd.getX() == 585) {
            kbd.x -= 1;
        }

        //Detects collision on outer bounds
        if (kbd.getY() == 587) {
            kbd.y -= 1;
        }

        //Detects collision on outer bounds
        if (kbd.getY() == 31) {
            kbd.y += 1;
        }

        //Detects collision on outer bounds
        if (kbd.getX() == 33) {
            kbd.x += 1;
        }

        /*//Transition based from Character location
        if ((character.getX() == -38) && (character.getY() <= 271 || character.getY() >= 201)) {
            character.setX(character.getX() + 1);
            character.setY(character.getY());
            stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }

        //Transition based from Character location
        if ((character.getX() == 520) && (character.getY() <= 299 || character.getY() >= 194)) {
            character.setX(character.getX() - 1);
            character.setY(character.getY());
            stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }*/
    }
}