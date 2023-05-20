package predmety;
import hlavne.Hrac;
public class DefensePotion extends Predmet implements Pouzitelnost {
    private final int defenseValue;

    public DefensePotion(String nazov, int cena) {
        super(nazov, cena);
        this.defenseValue = 1;

    }

    @Override
    public boolean jePolozitelny() {
        return true;
    }

    @Override
    public void pouzi(Hrac hrac) {
        hrac.pridajDefense(this.defenseValue);
    }
}
