package predmety;

import hlavne.Hrac;
/**
 * Trieda, v ktorej je definovane brnenie
 * @author Richard Stadani
 */
public class Brnenie extends Vybavenie implements Pouzitelnost {
    private boolean isEquipped;
    private final int brnenieDefense;

    /**
     * dedi konstruktor predka a innicializuje hodnoty
     * @param nazov
     * @param brnenieDefense
     * @param cena
     */
    public Brnenie(String nazov, int brnenieDefense, int cena) {
        super(nazov, cena);
        this.isEquipped = false;
        this.brnenieDefense = brnenieDefense;
    }

    /**
     * vrati staty
     * @return staty
     */
    @Override
    public int getStats() {
        return this.brnenieDefense;
    }
    /**
     * vracia to ci je brnenie nasaditelne
     * @return true ak je nasaditelne
     */
    @Override
    public boolean isEquipable() {
        return true;
    }

    /**
     * vracia stav brnenia
     * @return true ak je nasadeny
     */
    @Override
    public boolean isEquipped() {
        return this.isEquipped;
    }
    /**
     * vracia to ci je brnenie polozitelne
     * @return true ak je polozitelne
     */
    @Override
    public boolean jePolozitelny() {
        return true;
    }
    /**
     * ak hrac pouzije brnenie tak sa zmeni hodnota atributu a vypise text do konzoly
     * @param hrac
     */
    @Override
    public void pouzi(Hrac hrac) {
        if (this.isEquipped) {
            this.isEquipped = false;
            System.out.println("\n unequipol si ");
        } else {
            this.isEquipped = true;
            System.out.println("\n nasadil si ");
        }
    }
}
