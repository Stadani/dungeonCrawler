package npcs;

import predmety.Brnenie;
import predmety.HealthPotion;
import predmety.Predmet;
import predmety.Zbran;
import predmety.AttackPotion;
import predmety.DefensePotion;

import java.util.HashMap;

public class Trader extends FriendlyNPC implements NPCInterface {
    private HashMap<String, Predmet> stock;

    public Trader(TypNPC typNPC) {
        super(typNPC.TRADER);
        Predmet brnenie1 = new Brnenie("KozeneBrnenie", 1, 100);
        Predmet brnenie2 = new Brnenie("Chainmail", 3, 200);
        Predmet zbran1 = new Zbran("Dagger", 1, 50);
        Predmet zbran2 = new Zbran("ShortSword", 2, 100);
        Predmet hP = new HealthPotion();
        Predmet dP = new DefensePotion();
        Predmet aP = new AttackPotion();
        this.stock = new HashMap<>() {{
                put(brnenie1.getNazov(), brnenie1);
                put(brnenie2.getNazov(), brnenie2);
                put(zbran1.getNazov(), zbran1);
                put(zbran2.getNazov(), zbran2);
                put(hP.getNazov(), hP);
                put(dP.getNazov(), dP);
                put(aP.getNazov(), aP);
            }};
    }

    @Override
    public String getNazovNPC() {
        return super.getNazovNPC();
    }

    @Override
    public String getPopis() {
        return super.getPopis();
    }

    @Override
    public void dialog() {
        super.dialog();
        System.out.println("----------");
        System.out.println("uz si nieco kupis?");
    }

    /**
     * vypise svoj inventar toho co predava
     */
    public void vypisInformaci() {
        System.out.println("\nWhat are ya buyin'?");
        System.out.print("Predavam: \n");
        for (var j : this.stock.values()) {
            System.out.println(j.getNazov() + " " + j.getCena() + "G");
        }
    }
    public HashMap<String, Predmet> getStock() {
        return this.stock;
    }

    /**
     * odstrani kupeny tovar
     * @param predmet
     */
    public void removeStock(String predmet) {
        this.stock.remove(predmet);
    }

}