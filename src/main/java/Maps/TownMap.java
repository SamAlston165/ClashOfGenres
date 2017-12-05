package Maps;

import Entity.Character;
import Entity.Item;
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

    //Pause Menu t/f
    private Boolean quit;

    //Item Menu boolean variable
    private Boolean quit2;

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

        //Boolean variable reference
        quit = false;

        //Boolean variable reference
        quit2 = false;
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        //Draws Town Map
        townMap.draw();

        //Draws Character
        kbd.render(gameContainer, graphics);

        //Display Bar Text
        if((kbd.getX() < 140 && kbd.getX() > 100) && (kbd.getY() > 245 && kbd.getY() < 275 ))
        {
            graphics.drawString("Press Enter to go Bar", 60, 280);

            //Clears bar text
            if(!((kbd.getX() < 140 && kbd.getX() > 100) && (kbd.getY() > 245 && kbd.getY() < 275 )))
            {
                graphics.clear();
            }
        }

        //Display Shop Text
        if((kbd.getX() < 500 && kbd.getX() > 445) && (kbd.getY() > 245 && kbd.getY() < 275 ))
        {
            graphics.drawString("Press Enter to go Shop", 390, 280);

            //Clears shop text
            if(!((kbd.getX() < 500 && kbd.getX() > 445) && (kbd.getY() > 245 && kbd.getY() < 275 )))
            {
                graphics.clear();
            }
        }


        //Display Pause Menu
        if(quit)
        {
            graphics.setColor(Color.black);
            graphics.fillRect(180, 200, 280, 240);
            graphics.setColor(Color.white);
            graphics.drawRect(180, 200, 280, 240);
            graphics.drawString("Resume (ESC)", 250, 250);
            graphics.drawString("Quit   ( Q )", 250, 300);
            graphics.drawString("", 250, 350);

            //Clears Pause Menu
            if(!quit)
            {
                graphics.clear();
            }
        }

        if(quit2)
        {
            //Item shop menu needs currency system implement
            graphics.setColor(Color.black);
            graphics.fillRect(180, 200, 280, 240);
            graphics.setColor(Color.white);
            graphics.drawRect(180, 200, 280, 240);
            graphics.drawString("Welcome to Item Shop!",230,200);
            graphics.drawString("Potion x 1( P )", 250, 250);
            graphics.drawString("Armor x 1 ( A )", 250, 275);
            graphics.drawString("Exit Menu ( Q )", 250, 300);
            graphics.drawString("", 250, 350);

            //Clears Item Menu
            if(!quit2)
            {
                graphics.clear();
            }
        }

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

        //Input Object
        Input input = gameContainer.getInput();

        //Updates Character
        //Int contains duration of animation
        kbd.update(gameContainer, 0);

        //Universal Transition button to Battle Map
        if (input.isKeyPressed(Input.KEY_SPACE)) {
            stateBasedGame.enterState(3, new FadeOutTransition(), new FadeInTransition());
        }

        //Pause menu interaction
        if(quit)
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

        //Item menu interaction
        if(quit2)
        {
            if(input.isKeyPressed(Input.KEY_Q))
            {
                quit2 = false;
            }
            if(input.isKeyDown(Input.KEY_P))
            {
               //Needs add potion method to array list
                //Needs add armor method to array list
                // Deduct money method
            }
        }

        //Pause menu transition button to exit game
        if (input.isKeyPressed(Input.KEY_ESCAPE) && !quit) {
            quit = true;
        }

        //Transition method to Bar if called
        if((kbd.getX() < 140 && kbd.getX() > 100) && (kbd.getY() > 255 && kbd.getY() < 275 ))
        {
            if(input.isKeyDown(Input.KEY_ENTER))
            {
                stateBasedGame.enterState(2, new FadeOutTransition(), new FadeInTransition());
            }
        }

        //Transition method to Item Shop if called
        if((kbd.getX() < 500 && kbd.getX() > 445) && (kbd.getY() > 245 && kbd.getY() < 275 ))
        {
            if(input.isKeyDown(Input.KEY_ENTER))
            {
                quit2 = true;
            }
        }

        //Detects collision on outer bounds
        if (kbd.getX() == 585) {
            kbd.x -= 1;
        }

        //Left fence boundary
        if ((kbd.getX() == 54 && kbd.getY() <= 572) && (kbd.getX() == 54 && kbd.getY() >= 433)) {
            kbd.x -= 1;
        }

        //Middle fence boundary
        if ((kbd.getX() == 215 && kbd.getY() <= 507) && (kbd.getX() == 215 && kbd.getY() >= 369)) {
            kbd.x -= 1;
        }


        //Right fence boundary
        if ((kbd.getX() == 471 && kbd.getY() <= 588) && (kbd.getX() == 471 && kbd.getY() >= 462)) {
            kbd.x -= 1;
        }

        //Left house boundary
        if ((kbd.getX() == 44 && kbd.getY() <= 228) && (kbd.getX() == 44 && kbd.getY() >= 103)) {
            kbd.x -= 1;
        }

        //Right house boundary
        if ((kbd.getX() == 394 && kbd.getY() <= 228) && (kbd.getX() == 394 && kbd.getY() >= 105)) {
            kbd.x -= 1;
        }

        //Detects collision on outer bounds
        if (kbd.getY() == 587) {
            kbd.y -= 1;
        }

        //Left fence boundary
        if ((kbd.getY() == 427 && kbd.getX() <= 179) && (kbd.getY() == 427 && kbd.getX() >= 60)) {
            kbd.y -= 1;
        }

        //Middle fence boundary
        if ((kbd.getY() == 360 && kbd.getX() <= 436) && (kbd.getY() == 360 && kbd.getX() >= 221)) {
            kbd.y -= 1;
        }

        //Right fence boundary
        if ((kbd.getY() == 459 && kbd.getX() <= 584) && (kbd.getY() == 459 && kbd.getX() >= 473)) {
            kbd.y -= 1;
        }

        //Left house boundary
        if ((kbd.getY() == 42 && kbd.getX() <= 194) && (kbd.getY() == 42 && kbd.getX() >= 42)) {
            kbd.y -= 1;
        }

        //Right house boundary
        if ((kbd.getY() == 42 && kbd.getX() <= 547) && (kbd.getY() == 42 && kbd.getX() >= 389)) {
            kbd.y -= 1;
        }

        //Detects collision on outer bounds
        if (kbd.getY() == 31) {
            kbd.y += 1;
        }

        //Left fence boundary
        if ((kbd.getY() == 576 && kbd.getX() <= 179) && (kbd.getY() == 576 && kbd.getX() >= 60)) {
            kbd.y += 1;
        }

        //Middle fence boundary
        if ((kbd.getY() == 513 && kbd.getX() <= 438) && (kbd.getY() == 513 && kbd.getX() >= 220)) {
            kbd.y += 1;
        }

        //Left house boundary
        if ((kbd.getY() == 256 && kbd.getX() <= 163) && (kbd.getY() == 256 && kbd.getX() >= 70)) {
            kbd.y += 1;
        }

        //Right house boundary
        if ((kbd.getY() == 256 && kbd.getX() <= 518) && (kbd.getY() == 256 && kbd.getX() >= 420)) {
            kbd.y += 1;
        }
        //Detects collision on outer bounds
        if (kbd.getX() == 33) {
            kbd.x += 1;
        }

        //Left fence boundary
        if ((kbd.getX() == 183 && kbd.getY() <= 572) && (kbd.getX() == 183 && kbd.getY() >= 433)) {
            kbd.x += 1;
        }

        //Middle fence boundary
        if ((kbd.getX() == 440 && kbd.getY() <= 505) && (kbd.getX() == 440 && kbd.getY() >= 368)) {
            kbd.x += 1;
        }

        //Left house boundary
        if ((kbd.getX() == 191 && kbd.getY() <= 230) && (kbd.getX() == 191 && kbd.getY() >= 106)) {
            kbd.x += 1;
        }

        //Right house boundary
        if ((kbd.getX() == 543 && kbd.getY() <= 230) && (kbd.getX() == 543 && kbd.getY() >= 106)) {
            kbd.x += 1;
        }

        //Transition based from Character location
        if ((kbd.getX() == 584 && kbd.getY() <= 364) && (kbd.getX() == 584 && kbd.getY() >= 257)) {
            if(input.isKeyDown(Input.KEY_ENTER)) {
                stateBasedGame.enterState(3, new FadeOutTransition(), new FadeInTransition());
            }
        }
    }
}