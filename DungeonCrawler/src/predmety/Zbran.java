package predmety;

import hlavne.Hrac;

public class Zbran extends Vybavenie implements Pouzitelnost {
    private final int zbranAttack;
    private boolean isEquipped;
    public Zbran(String nazov, int zbranAttack, int cena) {
        super(nazov, cena);
        this.zbranAttack = zbranAttack;
        this.isEquipped = false;
    }

    @Override
    public int getStats() {
        return this.zbranAttack;
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
            System.out.println("\nunequipol si ");
        } else {
            this.isEquipped = true;
            System.out.println("\nnasadil si ");
        }
    }
}
