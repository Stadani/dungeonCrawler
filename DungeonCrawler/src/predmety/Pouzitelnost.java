package predmety;
import hlavne.Hrac;
/**
 * interface na nastavenie pouzitelnosti triedam
 * @author Richard Stadani
 */
public interface Pouzitelnost {
    /**
     * co sa stane s hracom ak pouzije predmet
     * @param hrac
     */
    void pouzi(Hrac hrac);
}
