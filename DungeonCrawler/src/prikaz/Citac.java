package prikaz;


import javax.swing.JOptionPane;
/**
 * trieda ktora berie vstup od uzivatela
 * @author Richard Stadani
 */
public class Citac {
    private Exekutor ex;
    private String prikaz;

    /**
     * inicializuje hodnoty
     * @param ex
     */
    public Citac(Exekutor ex) {
        this.ex = ex;
    }

    /**
     * berie od hraca vstup kde si pyta prikaz a potom hrac napise objekt s ktorym chce nieco robit
     * @return instanciu prikazu
     */
    public Prikaz citaniePrikazov() {
        String[] prikazy = this.ex.getPrikazy().toArray(new String[this.ex.getPrikazy().size()]);
        int prikazJO = JOptionPane.showOptionDialog(null, "Zadaj cinnost", "Prikaz", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, prikazy, prikazy[0]);
        String objektJO = JOptionPane.showInputDialog(null, "Zadaj nazov obejktu", "Objekt", JOptionPane.PLAIN_MESSAGE);

        if (prikazJO == JOptionPane.CLOSED_OPTION) {
            System.out.println();
            throw new RuntimeException("Ukoncil si hru cez krizik miesto buttonu");
        }

        for (int i = 0; i < prikazy.length; i++) {
            if (i == prikazJO) {
                this.prikaz = prikazy[i];
            }
        }

        return new Prikaz(this.prikaz, objektJO);

    }
}
