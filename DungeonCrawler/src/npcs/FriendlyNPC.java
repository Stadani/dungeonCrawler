package npcs;

/**
 * Trieda, v ktorej su definovane metody a nasledne sa dedia pre priatelske NPC
 * @author Richard Stadani
 */
public class FriendlyNPC implements NPCInterface {
    private TypNPC typNPC;

    /**
     * atributu sa priradi typNPC
     * @param typNPC
     */
    public FriendlyNPC(TypNPC typNPC) {
        this.typNPC = typNPC;
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
        return "\nNa toto NPC nemozes utocit";
    }
    /**
     * vracia hlavicku dialogu
     * @return vracia dialog
     */
    @Override
    public void dialog() {
        System.out.println("\n\n" + this.getNazovNPC());
    }


}
