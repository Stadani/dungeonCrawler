package predmety;
import hlavne.Hrac;
/**
 * Trieda, v ktorej je definovany HealthPotion
 * @author Richard Stadani
 */
public class HealthPotion extends Predmet implements Pouzitelnost {


    private final int healValue;

    /**
     * dedi konstruktor predka a innicializuje hodnoty
     * @param nazov
     * @param cena
     */
    public HealthPotion(String nazov, int cena) {
        super(nazov, cena);
        this.healValue = 25;

    }

    /**
     * vracia to ci je potion polozitelny
     * @return true ak je polozitelny
     */
    @Override
    public boolean jePolozitelny() {
        return true;
    }

    /**
     * ak hrac pouzije potion tak sa mu prida hodnota do atributu
     * @param hrac
     */
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
