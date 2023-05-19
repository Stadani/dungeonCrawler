package predmety;

public class Brnenie extends Predmet implements Vybavenie {


    private boolean isEquipped;
    private String nazov;
    private final int brnenieDefense;
    private int cena;

    public Brnenie(String nazov, int brnenieDefense, int cena) {
        this.nazov = nazov;
        this.cena = cena;
        this.isEquipped = false;
        this.brnenieDefense = brnenieDefense;
    }

    @Override
    public int getStats() {
        return this.brnenieDefense;
    }

    @Override
    public void equip() {
        if (!this.isEquipped) {
            this.isEquipped = true;
        }
    }

    @Override
    public void unequip() {
        if (this.isEquipped) {
            this.isEquipped = false;
        }
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

    public boolean isEquipped() {
        return this.isEquipped;
    }

    public boolean mozemDropnutBrnenie() {
        return !this.isEquipped;
    }
}
