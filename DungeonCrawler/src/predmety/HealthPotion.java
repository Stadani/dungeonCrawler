package predmety;
import hlavne.Hrac;
public class HealthPotion extends Predmet implements Pouzitelnost {


    private final int healValue;


    public HealthPotion(String nazov, int cena) {
        super(nazov, cena);
        this.healValue = 25;

    }
    @Override
    public boolean jePolozitelny() {
        return true;
    }
    @Override
    public void pouzi(Hrac hrac) {
        if (hrac.getZivot() + this.healValue <= hrac.getMaxZivot()) {
            hrac.pridajZivot(this.healValue);
        } else {
            var prebytok = (hrac.getZivot() + this.healValue) - hrac.getMaxZivot();
            hrac.pridajZivot(this.healValue - prebytok);
        }
    }

}
