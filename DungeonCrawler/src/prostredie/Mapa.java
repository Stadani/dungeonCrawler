package prostredie;

import npcs.NPC;
import npcs.Prisoner;
import npcs.Trader;
import npcs.TypNPC;

import predmety.*;
import prostredie.Miestnost;

public class Mapa {
    private Miestnost zaciatok;

    public Mapa() {
        this.zaciatok = this.generovanieMapy();
    }

    /**
     * generovanie mapy
     * @return vrati pociatocnu miestnost
     */
    public Miestnost generovanieMapy() {
        /*
        * [O][V][P]
        * [M]   [Z]
        * [D][T][V]
        * */
        Miestnost vchod = new Miestnost("\nVchadzas do jaskyne plnej goblinov");
        Miestnost prazdna = new Miestnost("\nTu nie je nic zaujimave");
        Miestnost most = new Miestnost("\nDreveny most, ktory je na pokraji rozpadnutia");
        Miestnost oltar = new Miestnost("\nMiestnost, v ktorej saman robi rituali");
        Miestnost dorm = new Miestnost("\nVyzera ze tu spia goblini");
        Miestnost vazenie = new Miestnost("\nNasiel si vazanie s zohavenymi telami");
        Miestnost zbrojnica = new Miestnost("\nVidis okolo seba nieco co sa podoba ostepom");
        Miestnost tron = new Miestnost("\nTronova miestnost s panom jaskyne");

        vchod.setVychodVSmere("vychod", prazdna);
        vchod.setVychodVSmere("zapad", oltar);
        vchod.spawni(new NPC(TypNPC.GOBLIN));
        vchod.spawni(new NPC(TypNPC.GOBLINLORD));
        vchod.polozeniePredmetu(new HealthPotion());
        vchod.polozeniePredmetu(new DefensePotion());
        vchod.polozeniePredmetu(new AttackPotion());
        vchod.spawni(new Trader(TypNPC.TRADER));
        vchod.spawni(new Prisoner(TypNPC.PRISONER));

        prazdna.setVychodVSmere("zapad", vchod);
        prazdna.setVychodVSmere("juh", zbrojnica);
        prazdna.spawni(new NPC(TypNPC.HOBGOBLIN));


        zbrojnica.setVychodVSmere("juh", vazenie);
        zbrojnica.setVychodVSmere("sever", prazdna);
        zbrojnica.polozeniePredmetu(new Zbran("Ostep", 1, 10));
        zbrojnica.polozeniePredmetu(new Brnenie("Kovova Helma", 1, 20));

        vazenie.setVychodVSmere("zapad", tron);
        vazenie.setVychodVSmere("sever", zbrojnica);

        tron.setVychodVSmere("vychod", vazenie);
        tron.setVychodVSmere("zapad", dorm);

        dorm.setVychodVSmere("vychod", tron);
        dorm.setVychodVSmere("sever", most);

        most.setVychodVSmere("sever", oltar);
        most.setVychodVSmere("juh", dorm);

        oltar.setVychodVSmere("juh", dorm);
        oltar.setVychodVSmere("vychod", vchod);



        return vchod;
    }

    public Miestnost getZaciatok() {
        return this.zaciatok;
    }
}
