package Entity;

public class Equipment extends Item {

    private static final int armorBonus = 50;

    public Equipment()
    {
        super();
        setEffectiveness(armorBonus);
    }

    @Override
    public void resolveEffect(Character target) {
        target.changeHealth(this.getEffectiveness());
        return;
    }
}
