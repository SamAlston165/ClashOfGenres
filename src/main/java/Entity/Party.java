package Entity;

import java.util.ArrayList;

public class Party {

    private static final int startingMoney = 100;

    public ArrayList<Character> party;
    public ArrayList<Item> inventory;
    private int money;

    //make a new party with 3 characters and starting money
    public Party(){
        setMoney(startingMoney);
        party = new ArrayList<Character>();
        inventory = new ArrayList<Item>();
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
