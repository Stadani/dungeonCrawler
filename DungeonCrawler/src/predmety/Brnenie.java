package predmety;

import hlavne.Hrac;

public class Brnenie extends Vybavenie implements Pouzitelnost {
    private boolean isEquipped;
    private final int brnenieDefense;

    public Brnenie(String nazov, int brnenieDefense, int cena) {
        super(nazov, cena);
        this.isEquipped = false;
        this.brnenieDefense = brnenieDefense;
    }

    @Override
    public int getStats() {
        return this.brnenieDefense;
    }

    @Override
    public boolean isEquipable() {
        return true;
    }

    public boolean isEquipped() {
        return this.isEquipped;
    }

    @Override
    public boolean jePolozitelny() {
        return true;
    }

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
