package Entity;

import java.util.ArrayList;

public class Party {

    private static final int startingMoney = 100;

    private ArrayList<Character> party;
    private ArrayList<Item> inventory;
    private int money;

    //make a new party of characters and starting money
    public Party(){
        setMoney(startingMoney);
        setParty(new ArrayList<Character>());
        setInventory(new ArrayList<Item>());
    }
    //Constructor for saved files
    public Party(ArrayList<Character> party, ArrayList<Item> inventory, int money)
    {
        setMoney(money);
        setParty(party);
        setInventory(inventory);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public ArrayList<Character> getParty() {
        return party;
    }

    public void setParty(ArrayList<Character> party) {
        this.party = party;
    }

    public void addToParty(Character newMem)
    {
        if(party.size() <= 4)
        {
            party.add(newMem);
        }
    }

    public void rmPartyMember(Character oldMem)
    {
        if(party.size() > 2)
        {
            party.remove(oldMem);
        }
    }

    public int getPartySize()
    {
        return(party.size());
    }
}