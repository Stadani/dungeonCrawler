package prikaz;

import hlavne.Hrac;
import npcs.Trader;
import predmety.Vybavenie;
import prostredie.Miestnost;


import java.util.ArrayList;
import java.util.List;

public class Exekutor {
    private ArrayList<String> prikazy;

    public Exekutor() {
        this.prikazy = new ArrayList<>(List.of("zobraz", "interakcia", "poloz", "zober", "chod", "koniec", "utok", "equip", "kup", "predaj", "pozicia"));
    }

    public ArrayList<String> getPrikazy() {
        return this.prikazy;
    }

    /**
     * metoda ktorou moze hrac zobrazit inventar, svoje staty, mesec a zivoty prisery
     * @param prikaz
     * @param hrac
     */
    public void zobrazenie(Prikaz prikaz, Hrac hrac) {
        if (prikaz.poznaObjekt()) {
            if (prikaz.getObjekt().equals("inventar")) {
                hrac.zobrazInventar();
            } else if (prikaz.getObjekt().equals("staty")) {
                hrac.getStats();
            } else if (prikaz.getObjekt().equals("mesec")) {
                System.out.println("\n" + hrac.getMesec() + "G");
            } else if (hrac.getAktualnaMiestnost().getZoznamNPCs().containsKey(prikaz.getObjekt())) {
                System.out.println(hrac.getAktualnaMiestnost().getZoznamNPCs().get(prikaz.getObjekt()).getPopis());
            } else {
                System.out.println("\nNemam co zobrazit");
            }
        }
    }

    /**
     * interakcia s NPCckami alebo pouzitie predmetu
     * @param prikaz
     * @param hrac
     */
    public void interakcia(Prikaz prikaz, Hrac hrac) {
        if (prikaz.poznaObjekt()) {
            String objekt = prikaz.getObjekt();
            if (hrac.getInventar().containsKey(objekt)) {
                System.out.println("\npredmet " + objekt + " bol pouzity");
                hrac.pouziPredmet(objekt);
                hrac.vyhodPredmet(objekt);
            } else if (hrac.getAktualnaMiestnost().getZoznamNPCs().containsKey(objekt)) {
                hrac.dialog(hrac.getAktualnaMiestnost().getZoznamNPCs().get(objekt));
            }
        } else {
            System.out.println("\nNemam s cim robit");
        }
    }

    /**
     * polozi predmet do miestnosti
     * @param prikaz
     * @param hrac
     */
    public void polozeniePredmetu(Prikaz prikaz, Hrac hrac) {
        if (prikaz.poznaObjekt()) {
            String objekt = prikaz.getObjekt();
            hrac.polozeniePredmetu(objekt);
        } else {
            System.out.println("\nNemam co polozit");
        }
    }

    /**
     * zoberie predmet z miestnosti
     * @param prikaz
     * @param hrac
     */
    public void zobraniePredmetu(Prikaz prikaz, Hrac hrac) {
        if (prikaz.poznaObjekt()) {
            String objekt = prikaz.getObjekt();
            if (!hrac.getInventar().containsKey(objekt)) {
                hrac.zobraniePredmetu(objekt);
            } else {
                System.out.println("\n tento predmet uz mas");
            }
        } else {
            System.out.println("\nNemam co zobrat");
        }
    }

    /**
     * posun hraca po mape
     * @param prikaz
     * @param hrac
     */
    public void chodNa(Prikaz prikaz, Hrac hrac) {
        if (prikaz.poznaObjekt()) {
            String smer = prikaz.getObjekt();
            hrac.pohybHraca(smer);
        } else {
            System.out.println("\nTadial nemozem ist");
        }
    }

    /**
     * ukonci hru
     * @return false ak nema hra dalej pokracovat
     */
    public boolean ukoncenieHry() {
        return false;
    }

    /**
     * urok na prisery, ak hrac ma 0 zivtov tak ukonci hru
     * @param prikaz
     * @param hrac
     */
    public boolean utok(Prikaz prikaz, Hrac hrac) {
        if (prikaz.poznaObjekt()) {
            String prisera = prikaz.getObjekt();
            if (hrac.getAktualnaMiestnost().getZoznamNPCs().containsKey(prisera) && hrac.getAktualnaMiestnost().getZoznamNPCs().containsKey("GOBLINLORD")) {
                hrac.utok(prisera);
                if (hrac.getAktualnaMiestnost().getZoznamNPCs().containsKey("GOBLINLORD")) {
                    if (hrac.zabityBoss()) {
                        if (hrac.getZivot() <= 0) {
                            System.out.println();
                            this.ukoncenieHry();
                        }
                    } else {
                        return hrac.zabityBoss();
                    }
                } else {
                    return hrac.zabityBoss();
                }
            } else if (hrac.getAktualnaMiestnost().getZoznamNPCs().containsKey(prisera)) {
                hrac.utok(prisera);
            } else {
                System.out.println("\ntato prisera tu nie je");
                return true;
            }
        } else {
            System.out.println("\nzautocit na koho?");
        }
        return true;
    }

    /**
     * kupovanie predmetov za peniaze v mesci
     * @param prikaz
     * @param hrac
     * @param trader
     */
    public void kup(Prikaz prikaz, Hrac hrac, Trader trader) {
        if (prikaz.poznaObjekt()) {
            String objekt = prikaz.getObjekt();
            if (trader.getStock().containsKey(objekt)) {
                if (hrac.getInventar().containsKey(objekt)) {
                    System.out.println("\nTento predmet uz mas");
                } else {
                    if (hrac.getMesec() >= trader.getStock().get(objekt).getCena()) {
                        hrac.pridajGoldy(-trader.getStock().get(objekt).getCena());
                        hrac.pridajDoInventara(objekt, trader.getStock().get(objekt));
                        System.out.println("\nHeh heh heh... Thank you!");
                    } else {
                        System.out.println("\nNot enough cash, stranger!");
                    }
                }
            } else {
                System.out.println("\ntoto nemam");
            }
            System.out.println("\nIs that all, stranger?");
        } else {
            hrac.nakup(trader);
        }
    }

    /**
     * metoda na predanie predmetov traderovi
     * @param prikaz
     * @param hrac
     */
    public void predaj(Prikaz prikaz, Hrac hrac) {
        if (prikaz.poznaObjekt()) {
            String objekt = prikaz.getObjekt();
            if (hrac.getInventar().containsKey(objekt)) {
                if (hrac.getInventar().get(objekt) instanceof Vybavenie vybavenie) {
                    if (vybavenie.isEquipped()) {
                        System.out.println("\n" + objekt + " mas nasadene cize to nemozes predat");
                        return;
                    }
                }
                hrac.pridajGoldy(hrac.getInventar().get(objekt).getCena());
                System.out.println("\npredal si " + objekt + " za " + hrac.getInventar().get(objekt).getCena() + " goldov");
                hrac.vyhodPredmet(objekt);
            } else {
                System.out.println("\ntento predmet nemas");
            }
        }
    }

    /**
     * motoda na nasadenie alebo vyzlecenie vybavenia
     * @param prikaz
     * @param hrac
     */
    public void equip(Prikaz prikaz, Hrac hrac) {
        if (prikaz.poznaObjekt()) {
            String objekt = prikaz.getObjekt();
            if (hrac.getInventar().containsKey(objekt)) {
                hrac.equipVybavenie(objekt);
                System.out.print(objekt);
            } else {
                System.out.println("\ntoto nemam");
            }
        }
    }

    /**
     * vypise info o aktualnej miestnosti
     * @param miestnost
     */
    public void pozicia(Miestnost miestnost) {
        miestnost.vypisMiestnosti();
    }

    /**
     * vykonavanie prikazov
     * @param prikaz
     * @param hrac
     * @param trader
     * @return true ak ma hra pokracovat
     */
    public boolean vykonaniePrikazu(Prikaz prikaz, Hrac hrac, Trader trader) {
        String nazov = prikaz.getPrikaz();
        switch (nazov) {
            case "zobraz":
                this.zobrazenie(prikaz, hrac);
                return true;
            case "interakcia":
                this.interakcia(prikaz, hrac);
                return true;
            case "poloz":
                this.polozeniePredmetu(prikaz, hrac);
                return true;
            case "zober":
                this.zobraniePredmetu(prikaz, hrac);
                return true;
            case "chod":
                this.chodNa(prikaz, hrac);
                return true;
            case "koniec":
                this.ukoncenieHry();
                return false;
            case "utok":
                return this.utok(prikaz, hrac);
            case "pozicia":
                this.pozicia(hrac.getAktualnaMiestnost());
                return true;
            case "kup":
                this.kup(prikaz, hrac, trader);
                return true;
            case "predaj":
                this.predaj(prikaz, hrac);
                return true;
            case "equip":
                this.equip(prikaz, hrac);
                return true;
            default:
                return true;
        }
    }
}
