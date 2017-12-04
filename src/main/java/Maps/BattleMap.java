package Maps;

import Entity.Character;
import Entity.Party;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import java.util.ArrayList;
import java.util.Random;

public class BattleMap extends BasicGameState {

    //Battle map image
    private Image battleMap;

    //Mouse input
    private int mouseX;
    private int mouseY;

    //Character/Party object
    private Character kbd;
    private Party userTeam;
    private Party enemyTeam;

    //Default Constructor matching superclass
    public BattleMap() {
        super();
    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException
    {
        //userTeam =

        //enemyTeam = createEnemy(userTeam);

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
        kbd = new Character();

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

        //Mouse input
        mouseX = input.getMouseX();
        mouseY = input.getMouseY();

        //Gets user coordinates and updates the user
        kbd.setX(kbd.getX());
        kbd.setY(kbd.getY());

        //Int contains duration of animation
        kbd.update(gameContainer, 0);




        //Outer Bound Collision block
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



        //Transition Block
        //Transition based from Character location
        if ((kbd.getX() == -38) && (kbd.getY() <= 271 || kbd.getY() >= 201)) {
            kbd.setX(kbd.getX() + 1);
            kbd.setY(kbd.getY());
            stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }

        //Transition based from Character location
        if ((kbd.getX() == 520) && (kbd.getY() <= 299 || kbd.getY() >= 194)) {
            kbd.setX(kbd.getX() - 1);
            kbd.setY(kbd.getY());
            stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }
        //Transition button to Town Map
        if (input.isKeyDown(Input.KEY_ENTER)) {
            stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }

        //Transition button to Town Map
        if (input.isKeyDown(Input.KEY_SPACE)) {
            stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }

        //Transition button to exit game
        if (input.isKeyDown(Input.KEY_ESCAPE)) {
            System.exit(0);
        }
    }

    private static Party createEnemy(Party userT)
    {
        Party enemyT = new Party();
        ArrayList<Character> teamA = userT.getParty();

        int numOfEn = teamA.size();
        int i = 0; int x = 0;
        Random rando = new Random();


        for(i = 0; i < numOfEn; i++)
        {
            x = rando.nextInt(2) + 1;

            if( x == 1)
            {}
            if(x == 2)
            {}
        }

        return(enemyT);
    }
}



