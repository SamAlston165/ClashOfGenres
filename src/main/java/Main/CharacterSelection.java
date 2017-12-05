package Main;
/*
Non-functional class at the moment to initialize Character to selected option

* */




import Entity.Character;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class CharacterSelection extends BasicGameState
{
    //Main menu image
    private Image mainMenu;

    //Instance Variable
    private int a;

    @Override
    public int getID() {
        return 5;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

        //Main menu reference
        mainMenu = new Image("Res/MainMenu.png");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        //Main menu reference
        mainMenu.draw();

        //Sets graphics to color black
        graphics.setColor(Color.black);

        //Displays Main menu string
        graphics.drawString("Press 1 for Archer", 270, 400);

        //Displays Main menu string
        graphics.drawString("Press 2 for Knight", 270, 500);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        //Input Object
        Input input = gameContainer.getInput();

        //Transition button to Town Map
        if (input.isKeyPressed(Input.KEY_1)) {



            stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }

        //Transition button to exit Program
        if (input.isKeyPressed(Input.KEY_2)) {

            stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }
    }
}
