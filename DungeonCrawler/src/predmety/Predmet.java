package predmety;
/**
 * abstraktna trieda, v ktorej je definovany predmet
 * @author Richard Stadani
 */
public abstract class Predmet {
    private String nazov;
    private int cena;

    /**
     * inicializuje atributy
     * @param nazov
     * @param cena
     */
    public Predmet(String nazov, int cena) {
        this.nazov = nazov;
        this.cena = cena;
    }

    /**
     * vrati nazov predmetu
     * @return nazov
     */
    public String getNazov() {
        return this.nazov;
    }

    /**
     * hlavicka metodi na to ci je predmet polozitelny
     * @return true ak je polozitelny
     */
    public abstract boolean jePolozitelny();

    /**
     * vrati cenu predmetu
     * @return cena
     */
    public int getCena() {
        return this.cena;
    }
}
