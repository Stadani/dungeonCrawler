package predmety;

public class Zbran extends Predmet implements Vybavenie {

    private boolean isEquipped;
    private String nazov;
    private final int zbranAttack;
    private int cena;

    public Zbran(String nazov, int zbranAttack, int cena) {
        this.nazov = nazov;
        this.cena = cena;
        this.isEquipped = false;
        this.zbranAttack = zbranAttack;
    }

    @Override
    public int getStats() {
        return this.zbranAttack;
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

    public boolean mozemDropnutZbran() {
        return !this.isEquipped;
    }
}
