package npcs;

public class FriendlyNPC implements NPCInterface {
    private TypNPC typNPC;

    public FriendlyNPC(TypNPC typNPC) {
        this.typNPC = typNPC;
    }

    @Override
    public String getNazovNPC() {
        return this.typNPC.toString();
    }

    @Override
    public String getPopis() {
        return "Na toto NPC nemozes utocit";
    }

    @Override
    public void dialog() {
        System.out.println("\n\n" + this.getNazovNPC());
    }


}
