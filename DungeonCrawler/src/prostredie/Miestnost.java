package prostredie;


import npcs.NPCInterface;

import predmety.Predmet;

import java.util.HashMap;

import java.util.Optional;

/**
 * trieda v ktorej je zoznam vychodov, predmetov, npc a metody spojene s miestnostou
 * @author Richard Stadani
 */
public class Miestnost {

    private final HashMap<String, Miestnost> zoznamVychodov;
    private final HashMap<String, Predmet> zoznamPredmetov;
    private final HashMap<String, NPCInterface> zoznamNPCs;

    private final String popis;

    /**
     * inicializacia atributu a hashmapov
     * @param popis
     */
    public Miestnost(String popis) {
        this.zoznamNPCs = new HashMap<>();
        this.zoznamVychodov = new HashMap<>();
        this.zoznamPredmetov = new HashMap<>();
        this.popis = popis;
    }

    /**
     * nastavi vychody pre miestnosti
     *
     * @param smer      v ktorom je vychod v miestnosti
     * @param miestnost ktorej nastavujeme vychod
     */
    public void setVychodVSmere(String smer, Miestnost miestnost) {
        this.zoznamVychodov.put(smer, miestnost);
    }

    /**
     * ukaze miestnost v smere
     *
     * @param smer smer v ktorom hladame miestnost
     * @return miestnost v smere
     */
    public Optional<Miestnost> getMiestnostVSmere(String smer) {
        return Optional.ofNullable(this.zoznamVychodov.get(smer));
    }


    /**
     * zobranie predmetu
     *
     * @param nazov predmetu
     * @return zobraty predmet
     */
    public Optional<Predmet> zobraniePredmetu(String nazov) {
        return Optional.ofNullable(this.zoznamPredmetov.remove(nazov));
    }

    /**
     * vypise informacie o miestnosti
     */
    public void vypisMiestnosti() {
        System.out.println("\n" + this.popis);
        System.out.print("Vychody: ");
        for (var i : this.zoznamVychodov.keySet()) {
            System.out.printf("%s ", i);
        }
        if (!this.zoznamPredmetov.isEmpty()) {
            System.out.print("\nPredmety v miestnosti: ");
            for (var j : this.zoznamPredmetov.keySet()) {
                System.out.printf("%s ", j);
            }
        }
        if (!this.zoznamNPCs.isEmpty()) {
            System.out.print("\nNPCcka v miestnosti: ");
            for (var k : this.zoznamNPCs.keySet()) {
                System.out.printf("%s ", k);
            }
        }
    }

    /**
     * metoda na umiestnenie NPC
     * @param npc
     */
    public void spawni(NPCInterface npc) {
        this.zoznamNPCs.put(npc.getNazovNPC(), npc);
    }

    /**
     * vratenie miestnosti
     * @return vrati miestnost
     */
    public Miestnost getMiestnost() {
        return this;
    }

    /**
     * polozi predmet do miestnosti
     *
     * @param predmet polozeny predmet
     */
    public void polozeniePredmetu(Predmet predmet) {
        this.zoznamPredmetov.put(predmet.getNazov(), predmet);
    }

    /**
     * vrati zoznam NPC
     * @return zoznam NPCs
     */
    public HashMap<String, NPCInterface> getZoznamNPCs() {
        return this.zoznamNPCs;
    }

    /**
     * odstrani npc zo zoznamu podla kluca
     * @param key
     */
    public void removeNPC(String key) {
        this.zoznamNPCs.remove(key);
    }

}
