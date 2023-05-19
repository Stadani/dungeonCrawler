package predmety;
import hlavne.Hrac;
public class HealthPotion extends Predmet implements Pouzitelnost {


    private final int healValue;
    private final String nazov;
    private final int cena;

    public HealthPotion() {
        this.healValue = 25;
        this.cena = 40;
        this.nazov = "HealthPotion";
    }

    public String getNazov() {
        return this.nazov;
    }

    @Override
    public boolean jePolozitelny() {
        return true;
    }

    public int getCena() {
        return this.cena;
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
