package hlavne;

import npcs.Trader;
import npcs.TypNPC;
import prikaz.Citac;
import prikaz.Exekutor;
import prikaz.Prikaz;
import prostredie.Mapa;
import prostredie.Miestnost;

/**
 * trieda na spustenie hry
 * @author Richard Stadani
 */
public class DungeonCrawler {
    private Hrac hrac;
    private Mapa mapa;
    private Citac citac;
    private Exekutor exekutor;

    /**
     * tu si vytvaram mapu, hraca v startovacej miestnosti, exekutor a citac prikazov
     */
    public DungeonCrawler() {
        this.mapa = new Mapa();
        Miestnost start = this.mapa.getZaciatok();
        this.hrac = new Hrac(start);
        this.exekutor = new Exekutor();
        this.citac = new Citac(this.exekutor);
    }

    /**
     * vypise uvod do hry do konzoly
     */
    public void uvod() {
        System.out.println("Vitaj v hre Dungeon Crawler");
        System.out.println("Cielom hry je prejst cez miestnosti dungeonu a zabit bossa");
        System.out.println("Ak nechces zadavat objekt, klikni na tlacidlo Cancel v okne kde sa pise objekt");
        this.hrac.getAktualnaMiestnost().vypisMiestnosti();
    }

    /**
     * kontroluje beh hry
     */
    public void beh() {
        this.uvod();
        boolean bezi = true;
        while (bezi) {
            Prikaz prikaz = this.citac.citaniePrikazov();
            Trader trader = new Trader(TypNPC.TRADER);
            bezi = this.exekutor.vykonaniePrikazu(prikaz, this.hrac, trader);
        }
        System.out.println("\nJe koniec");
    }
}