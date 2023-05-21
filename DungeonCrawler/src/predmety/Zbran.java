package predmety;

import hlavne.Hrac;

/**
 * Trieda, v ktorej je definovana zbran
 * @author Richard Stadani
 */
public class Zbran extends Vybavenie implements Pouzitelnost {
    private final int zbranAttack;
    private boolean isEquipped;
    /**
     * dedi konstruktor predka a innicializuje hodnoty
     * @param nazov
     * @param zbranAttack
     * @param cena
     */
    public Zbran(String nazov, int zbranAttack, int cena) {
        super(nazov, cena);
        this.zbranAttack = zbranAttack;
        this.isEquipped = false;
    }

    /**
     * vrati staty
     * @return staty
     */
    @Override
    public int getStats() {
        return this.zbranAttack;
    }

    /**
     * vracia to ci je zbran nasaditelna
     * @return true ak je nasaditelna
     */
    @Override
    public boolean isEquipable() {
        return true;
    }
    /**
     * vracia stav zbrane
     * @return true ak je nasadena
     */
    @Override
    public boolean isEquipped() {
        return this.isEquipped;
    }
    /**
     * vracia to ci je zbran polozitelna
     * @return true ak je polozitelna
     */
    @Override
    public boolean jePolozitelny() {
        return true;
    }
    /**
     * ak hrac pouzije zbran tak sa zmeni hodnota atributu a vypise text do konzoly
     * @param hrac
     */
    @Override
    public void pouzi(Hrac hrac) {
        if (this.isEquipped) {
            this.isEquipped = false;
            System.out.println("\nunequipol si ");
        } else {
            this.isEquipped = true;
            System.out.println("\nnasadil si ");
        }
    }
}
