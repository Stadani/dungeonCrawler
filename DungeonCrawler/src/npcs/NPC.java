package npcs;

import hlavne.Hrac;

import java.util.Random;
/**
 * Trieda, v ktorej su definovane metody pre nepriatelske NPC
 * @author Richard Stadani
 */
public class NPC implements NPCInterface {
    private TypNPC typNPC;
    private int health;
    private Random random;

    /**
     * priradi sa atributom pociatocna hodnota a inicializuje sa random
     * @param typNPC
     */
    public NPC(TypNPC typNPC) {
        this.typNPC = typNPC;
        this.health = this.typNPC.getHealth();
        this.random = new Random();
    }
    /**
     * vracia typ NPC
     * @return typ NPC
     */
    public TypNPC getTypNPC() {
        return this.typNPC;
    }
    /**
     * vracia typ NPC v stringu
     * @return typ NPC v stringu
     */
    @Override
    public String getNazovNPC() {
        return this.typNPC.toString();
    }
    /**
     * vracia popis ku NPC
     * @return vracia popis
     */
    @Override
    public String getPopis() {
        return "\nHP " + this.typNPC + ": " + this.health;
    }
    /**
     * vracia hlasku
     * @return vracia hlasku
     */
    @Override
    public void dialog() {
        System.out.println("\nGrrrr");
    }
    /**
     * vracia zivoty
     * @return vracia zivoty
     */
    public int getHealth() {
        return this.health;
    }
    /**
     * nastavi zivoty
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * metoda na generovanie dropnnutych penazi
     */
    public void drop(Hrac hrac) {
        int goldy = 1 + this.random.nextInt(100);
        hrac.pridajGoldy(goldy);
        System.out.println("\ndostal si " + goldy + " goldov");
    }

    /**
     * vypise nazov, attack, zivoty a defense NPC
     */
    public void vypisVlastnosti() {
        System.out.println("\n" + this.getNazovNPC() + "\n----------\n" + "Attack: " + this.typNPC.getAttack() + "\nHealth: " + this.getHealth() + "\nDefense: " + this.typNPC.getDefense());
    }

    /**
     * metoda na pocitanie damagu sposobene hracovi a prisere
     * ak hrac zabije goblinlorda tak splnil ucel hry
     * @param hrac
     */
    public void zautoc(Hrac hrac) {
        //damage sposobeny npcku
        var penDefNPC = this.getTypNPC().getDefense() - hrac.getAttack();
        if (penDefNPC < 0) {
            var novyHealthNPC = this.getHealth() + penDefNPC;
            if (novyHealthNPC <= 0) {
                if (this.getTypNPC().equals(TypNPC.GOBLINLORD)) {
                    this.setHealth(0);
                    System.out.println("\nZabil si sefa goblinov");
                    System.out.println("Splnil si ciel hry");
                    hrac.getAktualnaMiestnost().removeNPC(this.getNazovNPC());
                } else {
                    this.setHealth(0);
                    hrac.getAktualnaMiestnost().removeNPC(this.getNazovNPC());
                    this.drop(hrac);
                }
            } else {
                this.setHealth(novyHealthNPC);

            }
            this.vypisVlastnosti();
        } else {
            System.out.println("Neprepenetroval si armor " + this.getNazovNPC() + "a");
        }
        //damage sposobeny hracovi
        var penDefHrac = hrac.getDefense() - this.getTypNPC().getAttack();
        if (penDefHrac < 0) {
            var novyHealthHrac = hrac.getZivot() + penDefHrac;

            hrac.setZivot(novyHealthHrac);

        } else {
            System.out.println("Nedostal si damage vdaka armoru");
        }
    }


}
