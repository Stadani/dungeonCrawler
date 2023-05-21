package npcs;
/**
 * Interface na implementaciu metod na getovanie nazvu a popisu NPC a dialogu
 * @author Richard Stadani
 */
public interface NPCInterface {
    /**
     * vratenie nazvu npc
     */
    String getNazovNPC();
    /**
     * vratenie popisu npc
     */
    String getPopis();
    /**
     * vratenie dialogu npc
     */
    void dialog();
}
