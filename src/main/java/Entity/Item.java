package Entity;

public abstract class Item {

    private int effectiveness;
    private String itemName;

    //set effectiveness of item
    public void setEffectiveness(int e){
        effectiveness = e;
        return;
    }

    // get effectiveness of item
    public int getEffectiveness(){return effectiveness;}

    //resolve the effect of item
    public abstract void resolveEffect(Character target);

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
