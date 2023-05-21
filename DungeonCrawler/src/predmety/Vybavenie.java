package predmety;
/**
 * abstraktna trieda, v ktorej je definovany vybavenie
 * @author Richard Stadani
 */
public abstract class Vybavenie extends Predmet {
    private boolean isEquiped;

    /**
     * dedi konstruktor predka a innicializuje hodnoty
     * @param nazov
     * @param cena
     */
    public Vybavenie(String nazov, int cena) {
        super(nazov, cena);
    }
    /**
     * hlavicka na vratenie statov
     * @return staty
     */
    public abstract int getStats();
    /**
     * hlavicka metody ktora vracia to ci je vybavenie nasaditelne
     * @return true ak je nasaditelne
     */
    public abstract boolean isEquipable();
    /**
     * vracia stav vybavenia
     * @return true ak je nasadene
     */
    public boolean isEquipped() {
        return this.isEquiped;
    }

}
