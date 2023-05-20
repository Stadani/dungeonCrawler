package predmety;

public abstract class Vybavenie extends Predmet {
    private boolean isEquiped;
    public Vybavenie(String nazov, int cena) {
        super(nazov, cena);
    }
    public abstract int getStats();
    public abstract boolean isEquipable();
    public boolean isEquipped() {
        return this.isEquiped;
    }

}
