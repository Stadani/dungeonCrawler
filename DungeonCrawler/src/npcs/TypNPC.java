package npcs;

/**
 * enum na rozdelenie priser a priradenie zivotov, attacku a defense
 * @author Richard Stadani
 */
public enum TypNPC {
    GOBLIN(2, 10, 0),
    HOBGOBLIN(4, 30, 1),
    GOBLINSHAMAN(7, 10, 0),
    GOBLINCHAMPION(9, 40, 3),
    GOBLINPALADIN(5, 50, 6),
    GOBLINLORD(10, 1, 3),
    TRADER(0, 5, 1),
    PRISONER(0, 5, 0);


    private final int attack;
    private final int health;
    private final int defense;

    /**
     * inicialozovanie atributov
     * @param attack
     * @param health
     * @param defense
     */
    TypNPC(int attack, int health, int defense) {
        this.attack = attack;
        this.health = health;
        this.defense = defense;
    }

    /**
     * vrati utok
     * @return utok
     */
    public int getAttack() {
        return this.attack;
    }
    /**
     * vrati zivot
     * @return zivot
     */
    public int getHealth() {
        return this.health;
    }
    /**
     * vrati defense
     * @return defense
     */
    public int getDefense() {
        return this.defense;
    }
}
