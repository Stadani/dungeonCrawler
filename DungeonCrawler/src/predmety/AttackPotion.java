package predmety;
import hlavne.Hrac;
public class AttackPotion extends Predmet implements Pouzitelnost {

    private final int attackValue;

    public AttackPotion(String nazov, int cena) {
        super(nazov, cena);
        this.attackValue = 5;

    }

    @Override
    public boolean jePolozitelny() {
        return true;
    }

    @Override
    public void pouzi(Hrac hrac) {
        hrac.pridajAttack(this.attackValue);
    }

}
