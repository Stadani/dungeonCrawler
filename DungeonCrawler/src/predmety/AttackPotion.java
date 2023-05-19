package predmety;
import hlavne.Hrac;
public class AttackPotion extends Predmet implements Pouzitelnost {

    private final int attackValue;
    private final int cena;
    private final String nazov;

    public AttackPotion() {
        this.attackValue = 5;
        this.cena = 80;
        this.nazov = "AttackPotion";
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

    @Override
    public void pouzi(Hrac hrac) {
        hrac.pridajAttack(this.attackValue);
    }

}
