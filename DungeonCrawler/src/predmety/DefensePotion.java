package predmety;
import hlavne.Hrac;
/**
 * Trieda, v ktorej je definovany DefensePotion
 * @author Richard Stadani
 */
public class DefensePotion extends Predmet implements Pouzitelnost {
    private final int defenseValue;

    /**
     * dedi konstruktor predka a innicializuje hodnoty
     * @param nazov
     * @param cena
     */
    public DefensePotion(String nazov, int cena) {
        super(nazov, cena);
        this.defenseValue = 1;

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
        hrac.pridajDefense(this.defenseValue);
    }
}
