package Maps;

import AI.AI;
import Entity.Character;
import Entity.HealthPotion;
import Entity.Item;
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
    private Item itemInUse;

    //Pause/Reaction Variables
    private boolean quit;
    public static final int BUFFER_SPACE = 10;
    public static final int GRID_SIZE = 40;
    private boolean action;
    private boolean surrender;
    private int actionCode;
    private boolean lossSc;
    private boolean victorySc;
    private boolean moveDraw;
    private boolean attkDraw;

    //Mouse tracking
    private int mouseX;
    private int mouseY;
    private int fakeX;
    private int fakeY;
    private int fakeCharX;
    private int fakeCharY;



    //Variable for loops in class
    private int i;

    //Default Constructor matching superclass
    public BattleMap() {
        super();
    }

    @Override
    public void enter(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException
    {
        //Character reference
        playerT = new Party(0);
        enemyT = new Party(1);
        chosenC = playerT.getParty().get(0);
        chosenT = playerT.getParty().get(0);
        i = 0;
        surrender = false;
        action = false;
        actionCode = 0;
        quit = false;
        lossSc = false;
        victorySc = false;
        moveDraw = false;
        attkDraw = false;

        //Initializes Character Teams
        for(i = 0; i < playerT.getPartySize(); i++)
        {
            playerT.getParty().get(i).setY((GRID_SIZE * (i * 2)) + BUFFER_SPACE + GRID_SIZE);
            playerT.getParty().get(i).setX((GRID_SIZE *( (i + 1) % 2 )) + BUFFER_SPACE + GRID_SIZE);
            playerT.getParty().get(i).init(gameContainer);
        }
        for(i = 0; i < enemyT.getPartySize(); i++)
        {
            enemyT.getParty().get(i).setY((GRID_SIZE * (i * 2)) + BUFFER_SPACE + GRID_SIZE);
            enemyT.getParty().get(i).setX((600 - (GRID_SIZE *( (i + 1) % 2))) + BUFFER_SPACE - GRID_SIZE);
            enemyT.getParty().get(i).init(gameContainer);
        }
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
        actionCode = 0;
        surrender = false;
        quit = false;
        lossSc = false;
        victorySc = false;
        moveDraw = false;
        attkDraw = false;

        //Initializes Character Teams
        for(i = 0; i < playerT.getPartySize(); i++)
        {
            playerT.getParty().get(i).setY((GRID_SIZE * (i * 2)) + BUFFER_SPACE + GRID_SIZE);
            playerT.getParty().get(i).setX((GRID_SIZE *( (i + 1) % 2 )) + BUFFER_SPACE + GRID_SIZE);
            playerT.getParty().get(i).init(gameContainer);
        }
        for(i = 0; i < enemyT.getPartySize(); i++)
        {
            enemyT.getParty().get(i).setY((GRID_SIZE * (i * 2)) + BUFFER_SPACE + GRID_SIZE);
            enemyT.getParty().get(i).setX((600 - (GRID_SIZE *( (i + 1) % 2))) + BUFFER_SPACE - GRID_SIZE);
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

        graphics.drawString("Right Click to cancel actions.",180, 620);

        //Shows grid slots following mouse
        if(mouseY < 440)
        {
            graphics.setColor(Color.white);
            graphics.drawRect((GRID_SIZE * (mouseX / GRID_SIZE)), (GRID_SIZE * (mouseY / GRID_SIZE)), GRID_SIZE, GRID_SIZE);

        }

        if(action)
        {
            if(actionCode == 1)
            {
                //show movement area around chosen character
                graphics.setColor(Color.white);
                graphics.drawRect((chosenC.getX() - chosenC.getMovement() - BUFFER_SPACE),
                        (chosenC.getY() - chosenC.getMovement() - BUFFER_SPACE),
                        (chosenC.getMovement() * 2 + GRID_SIZE),
                        (chosenC.getMovement() * 2 + GRID_SIZE));
                //shows the attack range from chosen location
                if(mouseY < 440)
                {
                    graphics.setColor(Color.red);
                    graphics.drawRect((GRID_SIZE * (mouseX / GRID_SIZE)) - chosenC.getAttackRange(),
                            (GRID_SIZE * (mouseY / GRID_SIZE)) - chosenC.getAttackRange(),
                            chosenC.getAttackRange() * 2 + GRID_SIZE,
                            chosenC.getAttackRange() * 2 + GRID_SIZE);
                }
            }
        }

        //Highlights buttons as you mose over, iff character can perform  indicated action
        if(mouseY >= 550 && mouseY <= 600)
        {
            if ((mouseX >= 35 && mouseX <= 145) && chosenC.getAvailableMove())
            {
                graphics.setColor(Color.black);
                graphics.fillRect(35 ,550, 110, 50);
                graphics.setColor(Color.white);
                graphics.drawRect(35 ,550, 110, 50);
                graphics.drawString("  Move  ", 55, 570);
                if (!(mouseX >= 35 && mouseX <= 145))
                {
                    graphics.clear();
                }
            }
            if ((mouseX >= 185 && mouseX <= 295) && chosenC.getAvailableAttk())
            {
                graphics.setColor(Color.black);
                graphics.fillRect(185 ,550, 110, 50);
                graphics.setColor(Color.white);
                graphics.drawRect(185 ,550, 110, 50);
                graphics.drawString(" Attack ", 205, 570);

                if (!(mouseX >= 185 && mouseX <= 295))
                {
                    graphics.clear();
                }
            }
            if ((mouseX >= 335 && mouseX <= 445) && chosenC.getAvailableItem())
            {
                graphics.setColor(Color.black);
                graphics.fillRect(335 ,550, 110, 50);
                graphics.setColor(Color.white);
                graphics.drawRect(335 ,550, 110, 50);
                graphics.drawString("  Item  ", 355, 570);

                if (!(mouseX >= 335 && mouseX <= 445))
                {
                    graphics.clear();
                }
            }
            if (mouseX >= 485 && mouseX <= 595)
            {
                graphics.setColor(Color.black);
                graphics.fillRect( 485,550, 110, 50);
                graphics.setColor(Color.white);
                graphics.drawRect( 485,550, 110, 50);
                graphics.drawString("End Turn", 505, 570);

                if (!(mouseX >= 485 && mouseX <= 595))
                {
                    graphics.clear();
                }
            }
        }


        //Pause menu graphics
        if(quit)
        {
            graphics.setColor(Color.black);
            graphics.fillRect(180, 150, 280, 240);
            graphics.setColor(Color.white);
            graphics.drawRect(180, 150, 280, 240);
            graphics.drawString("Resume      (ESC)", 250, 200);
            graphics.drawString("Surrender   ( S )", 250, 250);
            graphics.drawString("Quit Game   ( Q )", 250, 300);

            //Clears Pause Menu
            if(!quit)
            {
                graphics.clear();
            }
        }

        //Loss screen graphics
        if(lossSc)
        {
            graphics.setColor(Color.black);
            graphics.fillRect(0, 0, 640, 640);
            graphics.setColor(Color.red);
            graphics.drawString("you lose...",290, 310);
            graphics.drawString("return to town  (enter)", 290, 360);
            graphics.drawString("quit game       (  q  )", 290, 380);
            if(!lossSc)
            {
                graphics.clear();
            }
        }

        //Victory Screen Graphics
        if(victorySc)
        {
            graphics.setColor(Color.lightGray);
            graphics.fillRect(0, 0, 640, 640);
            graphics.setColor(Color.black);
            graphics.drawString("YOU WON!",290, 310);
            graphics.drawString("Return to Town  (ENTER)", 290, 360);
            graphics.drawString("Quit Game       (  Q  )", 290, 380);
            if(!victorySc)
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
        fakeX = (GRID_SIZE * (mouseX / GRID_SIZE)) + BUFFER_SPACE;
        fakeY = (GRID_SIZE * (mouseY / GRID_SIZE)) + BUFFER_SPACE;
//        fakeCharX = (GRID_SIZE * (chosenC.getX() / GRID_SIZE)) + BUFFER_SPACE;
//        fakeCharY = ;

        if((mouseY > 550 && mouseY < 600))
        {

            if( (mouseX >= 35 && mouseX <= 145) && chosenC.getAvailableMove() && input.isMousePressed(Input.MOUSE_LEFT_BUTTON))
            {
                action = true;
                actionCode = 1;
            }
            if((mouseX >= 185 && mouseX <= 295) && chosenC.getAvailableAttk() && input.isMousePressed(Input.MOUSE_LEFT_BUTTON))
            {
                action = true;
                actionCode = 2;
            }
            if((mouseX >= 335 && mouseX <= 445) && chosenC.getAvailableItem() && input.isMousePressed(Input.MOUSE_LEFT_BUTTON))
            {
                action = true;
                actionCode = 3;
            }
            if((mouseX >= 485 && mouseX <= 595) && input.isMousePressed(Input.MOUSE_LEFT_BUTTON))
            {
                actionCode = 4;
            }

        }

        //If character is selected without action active
        if(!action && input.isMousePressed(Input.MOUSE_LEFT_BUTTON))
        {
            //check if player is at click location
            if(checkCharacter(playerT) != null)
            {
                chosenC = checkCharacter(playerT);
            }
        }


        //If action is active
        if(action && input.isMousePressed(Input.MOUSE_LEFT_BUTTON))
        {
            //if move action
            if(actionCode == 1)
            {
                if((chosenC.getX() + chosenC.getMovement()) >= fakeX && (chosenC.getX() - chosenC.getMovement()) <= fakeX)
                {
                   if(((chosenC.getY() + chosenC.getMovement()) >= fakeY && (chosenC.getY() - chosenC.getMovement()) <= fakeY) && input.isMousePressed(Input.MOUSE_LEFT_BUTTON))
                   {
                       chosenC.setX(fakeX);
                       chosenC.setY(fakeY);
                       action = false;
                       actionCode = 0;
                       chosenC.setAvailableMove(false);
                   }
                }
            }
            //if attack action
            else if(actionCode == 2)
            {
                if((chosenC.getX() + chosenC.getAttackRange()) >= fakeX && (chosenC.getX() - chosenC.getAttackRange()) <= fakeX)
                {
                    if (((chosenC.getY() + chosenC.getAttackRange()) >= fakeY
                            && (chosenC.getY() - chosenC.getAttackRange()) <= fakeY)
                            && input.isMousePressed(Input.MOUSE_LEFT_BUTTON))
                    {
                        chosenT = checkCharacter(enemyT);
                        if(chosenT != null) {
                            chosenC.attackChar(chosenT);
                            chosenC.setAvailableMove(false);
                            chosenC.setAvailableAttk(false);
                            chosenC.setAvailableItem(false);
                            chosenT = chosenC;
                            action = false;
                            actionCode = 0;
                        }
                    }
                }
            }
            //if item action
            else if(actionCode == 3)
            {
                if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON))
                {
                    chosenT = checkCharacter(playerT);
                    if(chosenT != null)
                    {
                        if (playerT.getInventory().get(0) != null)
                        {
                            itemInUse = (Item) playerT.getInventory().get(0);
                            itemInUse.resolveEffect(chosenT);
                            playerT.getInventory().remove(0);
                            itemInUse = null;
                        }
                        chosenT = chosenC;
                        chosenC.setAvailableItem(false);
                    }
                }

            }
        }


        //for(i = 0; i < .getPartySize(); i++)

        //Gets user coordinates and updates the user
        chosenC.setX(chosenC.getX());
        chosenC.setY(chosenC.getY());

        //Int contains duration of animation
        //chosenC.update(gameContainer, 0);

        //Pause menu interaction
        if(quit)
        {
            if(input.isKeyPressed(Input.KEY_ESCAPE))
            {
                quit = false;
            }
            if(input.isKeyDown(Input.KEY_S))
            {
                surrender = true;
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
        if (input.isKeyPressed(Input.KEY_ENTER)) {
            stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }

        //Transition button to Town Map
        if (input.isKeyPressed(Input.KEY_SPACE)) {
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
        //Test for loss condition
        tester = playerT.getParty();
        if((tester.get(0).getDead() && tester.get(2).getDead() && tester.get(2).getDead() && tester.get(3).getDead()) || surrender)
        {
            loss();
            //Make Loss screen live
            if(input.isKeyDown(Input.KEY_ENTER))
            {
                stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());
            }
            if(input.isKeyDown(Input.KEY_Q))
            {
                System.exit(0);
            }
        }

        //Test for victory condition
        tester = enemyT.getParty();
        if(tester.get(0).getDead() && tester.get(2).getDead() && tester.get(2).getDead() && tester.get(3).getDead())
        {
            victory();
            //Make victory screen live
            if(input.isKeyDown(Input.KEY_ENTER))
            {
                stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());
            }
            if(input.isKeyDown(Input.KEY_Q))
            {
                System.exit(0);
            }
        }

        //test for turn end
        if(checkTurnEnd(playerT) || actionCode == 4)
        {
           for (i = 0; i < enemyT.getPartySize(); i++)
            {
                AI.decide(enemyT.getParty().get(i), playerT.getParty());
            }
            resetTurn();
        }

        if(input.isMousePressed(Input.MOUSE_RIGHT_BUTTON))
        {
            action = false;
            actionCode = 0;
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
        victorySc = true;
    }

    private void loss()
    {
        ArrayList<Character> team = playerT.getParty();
        for(i = 0; i < playerT.getPartySize(); i++) {
            chosenC = team.get(0);
            chosenC.setCurrent_hp(chosenC.getMax_hp());
        }
        playerT.setMoney(playerT.getMoney() + chosenC.getLvl() * 100);
        lossSc = true;
    }

    private Character checkCharacter(Party partyG)
    {
        if(partyG.getParty().get(0).getX() == fakeX)
        {
            if(partyG.getParty().get(0).getY() == fakeY) { return partyG.getParty().get(0); }
        }
        if(partyG.getParty().get(1).getX() == fakeX)
        {
            if(partyG.getParty().get(1).getY() == fakeY) { return partyG.getParty().get(1); }
        }
        if(partyG.getParty().get(2).getX() == fakeX)
        {
            if(partyG.getParty().get(2).getY() == fakeY) { return partyG.getParty().get(2); }
        }
        if(partyG.getParty().get(3).getX() == fakeX)
        {
            if(partyG.getParty().get(3).getY() == fakeY) { return partyG.getParty().get(3); }
        }
        return(null);
    }

    private boolean checkTurnEnd(Party partyG)
    {
        for(i = 0; i < partyG.getPartySize(); i++)
        {
            if(partyG.getParty().get(i).getAvailableMove())
            { return false;}
            if(partyG.getParty().get(i).getAvailableItem())
            {return false;}
            if(partyG.getParty().get(i).getAvailableAttk())
            {return false;}
        }
        return(true);
    }

    private void resetTurn()
    {
        for(i = 0; i < playerT.getPartySize(); i++)
        {
            playerT.getParty().get(i).setAvailableMove(true);
            playerT.getParty().get(i).setAvailableItem(true);
            playerT.getParty().get(i).setAvailableAttk(true);
        }
        chosenC = playerT.getParty().get(0);
        chosenT = playerT.getParty().get(0);
        i = 0;
        action = false;
        actionCode = 0;
        quit = false;
        lossSc = false;
        victorySc = false;
        moveDraw = false;
        attkDraw = false;
    }




}

