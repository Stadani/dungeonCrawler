package npcs;

import hlavne.Hrac;

import java.util.Random;

public class NPC implements NPCInterface {
    private TypNPC typNPC;
    private int health;
    private Random random;

    public NPC(TypNPC typNPC) {
        this.typNPC = typNPC;
        this.health = this.typNPC.getHealth();
        this.random = new Random();
    }

    public TypNPC getTypNPC() {
        return this.typNPC;
    }
    @Override
    public String getNazovNPC() {
        return this.typNPC.toString();
    }

    @Override
    public String getPopis() {
        return "\nHP " + this.typNPC + ": " + this.health;
    }

    @Override
    public void dialog() {
        System.out.println("\nGrrrr");
    }

    public int getHealth() {
        return this.health;
    }

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
    public void vypisVlastnosti() {
        System.out.println("\n" + this.getNazovNPC() + "\n----------\n" + "Attack: " + this.typNPC.getAttack() + "\nHealth: " + this.getHealth() + "\nDefense: " + this.typNPC.getDefense());
    }

    public void zautoc(Hrac hrac) {
        //damage sposobeny npcku
        var penDefNPC = this.getTypNPC().getDefense() - hrac.getAttack();
        if (penDefNPC < 0) {
            var novyHealthNPC = this.getHealth() + penDefNPC;
            if (novyHealthNPC <= 0) {
                if (this.getTypNPC().equals(TypNPC.GOBLINLORD)) {
                    System.out.println("\nZabil si sefa goblinov");
                    System.out.println("Splnil si ciel hry");
                    this.setHealth(0);
                } else {
                    this.setHealth(0);
                    hrac.getAktualnaMiestnost().getZoznamNPCs().remove(this.getNazovNPC());
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
