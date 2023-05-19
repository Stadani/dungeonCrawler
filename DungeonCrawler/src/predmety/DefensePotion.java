package predmety;
import hlavne.Hrac;
public class DefensePotion extends Predmet implements Pouzitelnost {
    private final int defenseValue;
    private final String nazov;
    private final int cena;

    public DefensePotion() {
        this.defenseValue = 1;
        this.nazov = "DefensePotion";
        this.cena = 50;
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
        hrac.pridajDefense(this.defenseValue);
    }
}
