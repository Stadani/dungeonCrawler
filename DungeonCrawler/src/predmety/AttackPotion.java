package predmety;
import hlavne.Hrac;
/**
 * Trieda, v ktorej je definovany AttackPotion
 * @author Richard Stadani
 */
public class AttackPotion extends Predmet implements Pouzitelnost {

    private final int attackValue;

    /**
     * dedi konstruktor predka a innicializuje hodnoty
     * @param nazov
     * @param cena
     */
    public AttackPotion(String nazov, int cena) {
        super(nazov, cena);
        this.attackValue = 5;

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
        hrac.pridajAttack(this.attackValue);
    }

}
