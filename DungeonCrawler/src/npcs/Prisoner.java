package npcs;

public class Prisoner extends FriendlyNPC implements NPCInterface {

    public Prisoner(TypNPC typNPC) {
        super(typNPC.PRISONER);
    }

    @Override
    public String getNazovNPC() {
        return super.getNazovNPC();
    }

    @Override
    public String getPopis() {
        return super.getPopis();
    }

    @Override
    public void dialog() {
        super.dialog();
        System.out.println("----------");
        System.out.println("Dakujem za pomoc, moc ti nepomozem iba viem, ze pokial sa poriadne nepripravis tak nemas sancu zabit lorda");
    }


}