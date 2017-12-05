package Entity;

public class HealthPotion extends Item {

    //no magic numbers
    private static final int baseEffectiveness = 40;



    public HealthPotion(){
        super();
        setEffectiveness(baseEffectiveness);
    }

    @Override
    public void resolveEffect(Character target) {
        target.changeHealth(this.getEffectiveness());
        return;
    }
}
