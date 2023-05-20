package predmety;

public abstract class Predmet {
    private String nazov;
    private int cena;

    public Predmet(String nazov, int cena) {
        this.nazov = nazov;
        this.cena = cena;
    }
    public String getNazov() {
        return this.nazov;
    }
    public abstract boolean jePolozitelny();
    public int getCena() {
        return this.cena;
    }
}
