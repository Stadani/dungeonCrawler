package prikaz;
/**
 * trieda na vytvorenie prikazu
 * @author Richard Stadani
 */
public class Prikaz {

    private String prikaz;
    private String objekt;

    /**
     * inicializovanie atributov
     * @param prikaz
     * @param objekt
     */
    public Prikaz(String prikaz, String objekt) {
        this.prikaz = prikaz;
        this.objekt = objekt;
    }

    /**
     * @return prikaz, pomocou ktoreho nieco budem vykonavat
     */
    public String getPrikaz() {
        return this.prikaz;
    }

    /**
     * @return objekt, s ktorym chcem nieco vykonat
     */
    public String getObjekt() {
        return this.objekt;
    }

    /**
     * @return true, ak pozna objekt
     */
    public boolean poznaObjekt() {
        return this.objekt != null;
    }

}
