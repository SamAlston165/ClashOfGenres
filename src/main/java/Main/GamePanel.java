package Main;

import Maps.Bar;
import Maps.BattleMap;
import Maps.MainMenu;
import Maps.TownMap;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class GamePanel extends StateBasedGame {

    public GamePanel(String name) {
        super(name);
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {

        //All difference States contained within the game
        this.addState(new MainMenu());
        this.addState(new CharacterSelection());
        this.addState(new BattleMap());
        this.addState(new TownMap());
        this.addState(new Bar());
    }
}
