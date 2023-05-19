package hlavne;


import npcs.FriendlyNPC;
import npcs.NPC;
import npcs.NPCInterface;
import npcs.Trader;
import npcs.TypNPC;
import predmety.Pouzitelnost;
import predmety.Predmet;
import prostredie.Miestnost;

import java.util.HashMap;

public class Hrac {
    private HashMap<String, Predmet> inventar;
    private Miestnost aktualnaMiestnost;
    private int attack = 5;
    private int zivot = 50;
    private final int maxZivot = 50;
    private int defense = 0;
    private int mesec = 0;

    public Hrac(Miestnost aktualnaMiestnost) {
        this.aktualnaMiestnost = aktualnaMiestnost;
        this.inventar = new HashMap<>();
    }

    /**
     *zoberie predmet do inventara
     * @param predmet nazov predmetu
     */
    public void zobraniePredmetu(String predmet) {
        var zobratyPredmet = this.aktualnaMiestnost.zobraniePredmetu(predmet);
        if (!zobratyPredmet.isPresent()) {
            System.out.println("\nPredmet nie je v miestnosti");
        } else {
            this.inventar.put(zobratyPredmet.get().getNazov(), zobratyPredmet.get());
            System.out.println("\nPredmet " + zobratyPredmet.get().getNazov() + " bol zobrany");
        }
    }

    /**
     * Vypise obsah inventaru
     */
    public void zobrazInventar() {
        if (!this.inventar.isEmpty()) {
            System.out.println("Inventar: ");
            for (var i: this.inventar.keySet()) {
                System.out.println(i);
            }
        } else {
            System.out.println("\nInventar je prazdny!");
        }
    }

    /**
     * polozim predmet z inventara do miestnosti
     * @param predmet predmet, ktory chcem polozit
     */
    public void polozeniePredmetu(String predmet) {
        Predmet polozeny = this.inventar.remove(predmet);
        if (polozeny == null) {
            System.out.println(predmet + " nemas");
            return;
        }
        if (!polozeny.jePolozitelny()) {
            System.out.println(polozeny.getNazov() + " sa neda polozit");
            this.inventar.put(polozeny.getNazov(), polozeny);
            return;
        }
        this.aktualnaMiestnost.polozeniePredmetu(polozeny);
        System.out.println("\nPolozil si " + predmet);
    }


    /**
     * posunie hraca do miestnosti v urcenom smere
     * @param smer v ktorom ideme
     */
    public void pohybHraca(String smer) {
        var exit = this.aktualnaMiestnost.getMiestnostVSmere(smer);
        if (!exit.isEmpty()) {
            this.aktualnaMiestnost = exit.get().getMiestnost();
            this.aktualnaMiestnost.vypisMiestnosti();
        } else {
            System.out.println("\nTadial nemozes ist");
        }
    }

    /**
     * pouzije predmet, ktory je v parametri
     * @param nazov predmetu
     */
    public void pouziPredmet(String nazov) {
        var predmet = this.inventar.get(nazov);
        if (predmet instanceof Pouzitelnost pouzitelny) {
            pouzitelny.pouzi(this);
        } else {
            System.out.printf("\npredmet %s nie je pouzitelny", nazov);
        }
    }

    /**
     * metoda vymaze predmet podla nazvu parametra popripade vymaze cely inventar
     * @param nazov nazov predmetu
     */
    public void vyhodPredmet(String nazov) {
        if (nazov.equals("vsetko")) { //vymaze cely inventar
            this.inventar.clear();
        } else if (this.inventar.containsKey(nazov)) {
            this.inventar.remove(nazov);
        } else {
            System.out.printf("\n%s sa nenachadza v inventari", nazov);
        }
    }

    /**
     * vypise staty hraca na konzolu
     */
    public void getStats() {
        System.out.printf("\nAttack: %d \nZivot: %d \nDefense: %d", this.attack, this.zivot, this.defense);
    }

    /**
     * miestnost v ktorej je hrac
     * @return vrati miestnost v ktorej je hrac
     */
    public Miestnost getAktualnaMiestnost() {
        return this.aktualnaMiestnost;
    }

    public void utok(String ciel) {
        var prisera = this.aktualnaMiestnost.getZoznamNPCs().get(ciel);
        if (prisera instanceof FriendlyNPC) {
            System.out.println("\nNemozes zautocit na priatelov");
        } else if (prisera instanceof NPC priserka) {
            priserka.zautoc(this);
            priserka.getPopis();

        }
    }

    /**
     * metoda na overenie ci bol zabity goblin lord
     * @return vrati false ak este nebol zabity
     */
    public boolean zabityBoss() {
        var boss = this.aktualnaMiestnost.getZoznamNPCs().containsKey(TypNPC.GOBLINLORD);
        if (!boss) {
            return false;
        }
        return true;
    }

    /**
     * vola metodu nakup v traderovi
     * @param trader
     */
    public void nakup(Trader trader) {
        trader.vypisInformaci();
    }

    /**
     * vola metodu dialog v npc
     * @param npc
     */
    public void dialog(NPCInterface npc) {
        npc.dialog();
    }

    /**
     * vlozi do inventara hraca predmet
     * @param nazov
     * @param predmet
     */
    public void pridajDoInventara(String nazov, Predmet predmet) {
        this.inventar.put(nazov, predmet);
    }

    /**
     * prida utok podla parametra
     * @param attack
     */
    public void pridajAttack(int attack) {
        this.attack += attack;
    }
    /**
     * prida zivot podla parametra
     * @param zivot
     */
    public void pridajZivot(int zivot) {
        this.zivot += zivot;
    }
    /**
     * prida defense podla parametra
     * @param defense
     */
    public void pridajDefense(int defense) {
        this.defense += defense;
    }
    /**
     * prida peniaze podla parametra
     * @param mesec
     */
    public void pridajGoldy(int mesec) {
        this.mesec += mesec;
    }

    public int getMaxZivot() {
        return this.maxZivot;
    }

    public int getZivot() {
        return this.zivot;
    }

    public void setZivot(int zivot) {
        this.zivot = zivot;
    }

    public int getAttack() {
        return this.attack;
    }
    public int getDefense() {
        return this.defense;
    }
    public int getMesec() {
        return this.mesec;
    }
    public HashMap<String, Predmet> getInventar() {
        return this.inventar;
    }
}