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

    //Pause Menu t/f
    Boolean quit;

    //Default Constructor matching superclass
    public TownMap() {
        super();
    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException
    {

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

        quit = false;
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        //Draws Town Map
        townMap.draw();

        //Draws Character
        kbd.render(gameContainer, graphics);

        //Displays Town Map string
       // graphics.drawString("Town Map", 270, 400);

        //Display Bar Text
        if((kbd.getX() < 140 && kbd.getX() > 100) && (kbd.getY() > 245 && kbd.getY() < 275 ))
        {
            graphics.drawString("Press Enter togo Bar", 60, 280);

            //Clears bar text
            if(!((kbd.getX() < 140 && kbd.getX() > 100) && (kbd.getY() > 245 && kbd.getY() < 275 )))
            {
                graphics.clear();
            }
        }

        //Display Shop Text
        if((kbd.getX() < 500 && kbd.getX() > 445) && (kbd.getY() > 245 && kbd.getY() < 275 ))
        {
            graphics.drawString("Press Enter togo Shop", 390, 280);

            //Clears shop text
            if(!((kbd.getX() < 500 && kbd.getX() > 445) && (kbd.getY() > 245 && kbd.getY() < 275 )))
            {
                graphics.clear();
            }
        }


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

        //Updates Character
        //Int contains duration of animation
        kbd.update(gameContainer, 0);

        //Transition button to Bar
//        if (input.isKeyPressed(Input.KEY_ENTER)) {
//            stateBasedGame.enterState(2, new FadeOutTransition(), new FadeInTransition());
//        }

        //Transition button to Battle Map
        if (input.isKeyPressed(Input.KEY_SPACE)) {
            stateBasedGame.enterState(3, new FadeOutTransition(), new FadeInTransition());
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
        if (input.isKeyPressed(Input.KEY_ESCAPE) && quit == false) {
            quit = true;
        }


        if((kbd.getX() < 140 && kbd.getX() > 100) && (kbd.getY() > 255 && kbd.getY() < 275 ))
        {
            if(input.isKeyDown(Input.KEY_ENTER))
            {
                stateBasedGame.enterState(2, new FadeOutTransition(), new FadeInTransition());
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
            //int choice = JOptionPane.showConfirmDialog(null, "Do you want to travel to the Battle Map?", "", JOptionPane.YES_NO_OPTION);
            //if (choice == JOptionPane.YES_OPTION) {
            //  kbd.setX(kbd.getX() - 1);
            //  kbd.setY(kbd.getY());
            if(input.isKeyDown(Input.KEY_ENTER)) {
                stateBasedGame.enterState(3, new FadeOutTransition(), new FadeInTransition());
            }
        } //else if (choice == JOptionPane.NO_OPTION) {
        //stateBasedGame.getCurrentState();

        input = null;
    }

}