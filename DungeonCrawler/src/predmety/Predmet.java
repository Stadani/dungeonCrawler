package predmety;

public abstract class Predmet {
    private String nazov;
    private int cena;
    public String getNazov() {
        return this.nazov;
    }
    public abstract boolean jePolozitelny();
    public int getCena() {
        return this.cena;
    }
}
