package Entity;

import java.util.ArrayList;

public class Party {

    private static final int startingMoney = 100;

    private ArrayList<Character> party;
    private ArrayList<Item> inventory;
    private int money;

    //make a new party with 3 characters and starting money
    public Party(){
        money = startingMoney;
        party.add(new Knight());
        party.add(new Archer());
        party.add(new Character());
    }
}
