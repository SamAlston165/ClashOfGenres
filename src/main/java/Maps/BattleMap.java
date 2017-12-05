package Maps;

import Entity.Character;
import Entity.Party;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import java.util.ArrayList;

public class BattleMap extends BasicGameState {

    //Battle map image
    private Image battleMap;

    //Character object / Party
    private Character chosenC;
    private Character chosenT;
    private Party playerT;
    private Party enemyT;
    private ArrayList<Character> tester;

    //Pause Variable
    private boolean quit;
    private boolean action;
    //Mouse tracking
    private int mouseX;
    private int mouseY;
    private int fakeX;
    private int fakeY;



    //Variable for loops in class
    private int i;

    //Default Constructor matching superclass
    public BattleMap() {
        super();
    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException
    {

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
        playerT = new Party(0);
        enemyT = new Party(1);
        chosenC = playerT.getParty().get(0);
        chosenT = playerT.getParty().get(0);
        i = 0;
        action = false;
        quit = false;

        //Initializes Character Teams
        for(i = 0; i < playerT.getPartySize(); i++)
        {
            playerT.getParty().get(i).setY((40 * (i * 2)) + 10 + 40);
            playerT.getParty().get(i).setX((40 *( (i + 1) % 2 )) + 10 + 40);
            playerT.getParty().get(i).init(gameContainer);
        }
        for(i = 0; i < enemyT.getPartySize(); i++)
        {
            enemyT.getParty().get(i).setY((40 * (i * 2)) + 10 + 40);
            enemyT.getParty().get(i).setX((600 - (40 *( (i + 1) % 2))) + 10 - 40);
            enemyT.getParty().get(i).init(gameContainer);
        }


    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        //Draws Battle Map
        battleMap.draw();

        //Sets graphics to color white
        graphics.setColor(Color.lightGray);

        //Draws Character
        //chosenC.render(gameContainer, graphics);
        playerT.getParty().get(0).render(gameContainer, graphics);
        playerT.getParty().get(1).render(gameContainer, graphics);
        playerT.getParty().get(2).render(gameContainer, graphics);
        playerT.getParty().get(3).render(gameContainer, graphics);
        enemyT.getParty().get(0).render(gameContainer, graphics);
        enemyT.getParty().get(1).render(gameContainer, graphics);
        enemyT.getParty().get(2).render(gameContainer, graphics);
        enemyT.getParty().get(3).render(gameContainer, graphics);

        //light rectangle for bottom screen menu
        graphics.fillRect(0, 440, 640, 200);

        //reset to black graphics for text
        graphics.setColor(Color.black);

        //outer rectangle for design
        graphics.drawRect(0, 440, 640, 200);

        //sample text for now
        graphics.drawString("Character Selected: " + chosenC.getName(), 25, 450);
        graphics.drawString("Character Health:   " + chosenC.getCurrent_hp() +"/" + chosenC.getMax_hp(), 25, 500);
        graphics.drawString("Character Lvl:    " + chosenC.getLvl(), 340, 450);
        graphics.drawString("Character Attack: " + chosenC.getAttack(), 340, 500);
        graphics.drawRect(35 ,550, 110, 50);
        graphics.drawString("  Move  ", 55, 570);
        graphics.drawRect(185 ,550, 110, 50);
        graphics.drawString(" Attack ", 205, 570);
        graphics.drawRect(335 ,550, 110, 50);
        graphics.drawString("  Item  ", 355, 570);
        graphics.drawRect( 485,550, 110, 50);
        graphics.drawString("End Turn", 505, 570);


        if(mouseY < 440)
        {
            graphics.setColor(Color.white);
            graphics.drawRect((40 * (mouseX / 40)), (40 * (mouseY / 40)), 40, 40);

        }

        if(quit)
        {
            graphics.setColor(Color.lightGray);
            graphics.fillRect(180, 200, 280, 240);
            graphics.setColor(Color.black);
            graphics.drawRect(180, 200, 280, 240);
            graphics.drawString("Resume      (ESC)", 250, 250);
            graphics.drawString("Surrender   ( S )", 250, 300);
            graphics.drawString("Quit Game   ( Q )", 250, 350);

            //Clears Pause Menu
            if(!quit)
            {
                graphics.clear();
            }
        }

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

        //Input Object
        Input input = gameContainer.getInput();

        //Mouse input
        mouseX = input.getMouseX();
        mouseY = input.getMouseY();
        fakeX = (40 * (mouseX / 40)) + 10;
        fakeY = (40 * (mouseY / 40)) + 10;

        if(!action && input.isMousePressed(Input.MOUSE_LEFT_BUTTON))
        {
            if(playerT.getParty().get(0).getX() == fakeX)
            {
                if(playerT.getParty().get(0).getY() == fakeY) { chosenC = playerT.getParty().get(0); }
            }
            else if(playerT.getParty().get(1).getX() == fakeX)
            {
                if(playerT.getParty().get(1).getY() == fakeY) { chosenC = playerT.getParty().get(1); }
            }
            if(playerT.getParty().get(2).getX() == fakeX)
            {
                if(playerT.getParty().get(2).getY() == fakeY) { chosenC = playerT.getParty().get(2); }
            }
            if(playerT.getParty().get(3).getX() == fakeX)
            {
                if(playerT.getParty().get(3).getY() == fakeY) { chosenC = playerT.getParty().get(3); }
            }
        }


        //for(i = 0; i < .getPartySize(); i++)

        //Gets user coordinates and updates the user
        chosenC.setX(chosenC.getX());
        chosenC.setY(chosenC.getY());

        //Int contains duration of animation
        chosenC.update(gameContainer, 0);

        //Pause menu interaction
        if(quit)
        {
            if(input.isKeyPressed(Input.KEY_ESCAPE))
            {
                quit = false;
            }
            if(input.isKeyDown(Input.KEY_S))
            {
                //input surrender call
            }
            if(input.isKeyDown(Input.KEY_Q))
            {
                System.exit(0);
            }
        }

        /*
                Transition Block
         */

        //Transition button to Town Map
        if (input.isKeyDown(Input.KEY_ENTER)) {
            stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }

        //Transition button to Town Map
        if (input.isKeyDown(Input.KEY_SPACE)) {
            stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }

        //Pause menu transition button to exit game

        if (input.isKeyPressed(Input.KEY_ESCAPE) && !quit) {
            quit = true;
        }

        /*
                Collision Block
         */

        //Detects collision on outer bounds
        if (chosenC.getX() == 640) {
            chosenC.x -= 1;
        }

        //Detects collision on outer bounds
        if (chosenC.getY() == 410) {
            chosenC.y -= 1;
        }

        //Detects collision on outer bounds
        if (chosenC.getY() == 0) {
            chosenC.y += 1;
        }

        //Detects collision on outer bounds
        if (chosenC.getX() == 0) {
            chosenC.x += 1;
        }

        //Transition based from Character location
        if ((chosenC.getX() == -38) && (chosenC.getY() <= 271 || chosenC.getY() >= 201)) {
            chosenC.setX(chosenC.getX() + 1);
            chosenC.setY(chosenC.getY());
            stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }

        //Transition based from Character location
        if ((chosenC.getX() == 520) && (chosenC.getY() <= 299 || chosenC.getY() >= 194)) {
            chosenC.setX(chosenC.getX() - 1);
            chosenC.setY(chosenC.getY());
            stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }

        tester = playerT.getParty();
        if(tester.get(0).getDead() && tester.get(2).getDead() && tester.get(2).getDead() && tester.get(3).getDead())
        {
            loss();
            if(input.isKeyDown(Input.KEY_ENTER))
            {
                stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());
            }
            if(input.isKeyDown(Input.KEY_Q))
            {
                System.exit(0);
            }
        }
    }



    private void victory()
    {
        ArrayList<Character> team = playerT.getParty();
        for(i = 0; i < playerT.getPartySize(); i++)
        {
            chosenC = team.get(0);
            chosenC.setLvl(chosenC.getLvl() + 1);
            chosenC.setMax_hp(chosenC.getMax_hp() + 20);
            chosenC.setCurrent_hp(chosenC.getMax_hp());
            chosenC.setAttack(chosenC.getAttack() + 10);
        }
        playerT.setMoney(playerT.getMoney() + chosenC.getLvl() * 100);
    }

    private void loss()
    {
        ArrayList<Character> team = playerT.getParty();
        for(i = 0; i < playerT.getPartySize(); i++) {
            chosenC = team.get(0);
            chosenC.setCurrent_hp(chosenC.getMax_hp());
        }
        playerT.setMoney(playerT.getMoney() + chosenC.getLvl() * 100);
    }




}

