package npcs;
/**
 * Trieda, v ktorej su je dedena trieda FriendlyNPC a sluzi ako postava v hre
 * @author Richard Stadani
 */
public class Prisoner extends FriendlyNPC {
    /**
     * dedim konstruktor predka
     * @param typNPC
     */
    public Prisoner(TypNPC typNPC) {
        super(typNPC.PRISONER);
    }
    /**
     * vracia typ NPC v stringu
     * @return typ NPC v stringu
     */
    @Override
    public String getNazovNPC() {
        return super.getNazovNPC();
    }
    /**
     * vracia popis ku NPC
     * @return vracia popis
     */
    @Override
    public String getPopis() {
        return super.getPopis() + "\ntento vazen bol chyteny goblinmi";
    }
    /**
     * vracia dialog
     * @return vracia dialog
     */
    @Override
    public void dialog() {
        super.dialog();
        System.out.println("----------");
        System.out.println("Dakujem za pomoc, moc ti nepomozem iba viem, ze pokial sa poriadne nepripravis tak nemas sancu zabit lorda");
    }


}
