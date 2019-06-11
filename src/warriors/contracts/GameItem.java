package warriors.contracts;

//import java.util.ArrayList;
//import java.util.List;

/**
 * Enum to describe possible game items and enemy
 */
public enum GameItem {
    DRAGONS ("un Dragon", 15, 4),

    SORCIERS ("un Sorcier", 9, 2),

    GOBELINS ("un Gobelin", 6, 1),

    ARCS ("un Arc", 0, 1),

    MASSUES ("une Massue", 0, 3),

    EPEES ("une Epée", 0, 5),

    SORTS_ECLAIR ("un Sort Eclair", 0, 2),

    SORTS_FIRE ("un Sort Boules de feu", 0, 7),

    POTION_LOW ("une Potion mineur", 1, 0),

    POTION_NORM ("une Potion standard", 2, 0),

    POTION_HIGH ("une Grande Potion", 5, 0);

    private String nom;
    private int vie;
    private int attck;
    private int[] dragonListCases = {45, 52, 56, 62};
    private int[] sorcierListCases = {10, 20, 25, 32, 35, 36, 37, 40, 44, 47};
    private int[] gobelinListCases = {3, 6, 9, 12, 15, 18, 21, 24, 27, 30};
    private int[] arcListCases = {2, 11, 14, 19, 26};
    private int[] massueListCases = {5, 22, 38};
    private int[] epeeListCases = {42, 53};
    private int[] sortEclairListCases = {1, 4 , 8, 17, 23};
    private int[] sortFireListCases = {48, 49};
    private int[] potionMinListCases = {7, 13, 28, 29, 33};
    private int[] potionNormListCases = {31, 39, 43};
    private int[] potionHighListCases = {41};
    

    GameItem(String nom, int vie, int attck) {
        this.nom = nom ;
        this.vie = vie ;
        this.attck = attck ;
    }

    public String getNom() {
        return nom ;
    }

    public int getLife() {
        return vie ;
    }

    public int getAttack() {
        return attck ;
    }

    public <Dragon> int[] getCasesDrag() {
        return dragonListCases ;
    }

    public <Sorcier> int[] getCasesSorc() {
        return sorcierListCases ;
    }

    public <Gobelin> int[] getCasesGob() {
        return gobelinListCases ;
    }

    public <Arc> int[] getCasesArc() {
        return arcListCases ;
    }

    public <Massue> int[] getCasesMass() {
        return massueListCases ;
    }

    public <Epee> int[] getCasesEpee() {
        return epeeListCases ;
    }

    public <SortE> int[] getCasesSortE() {
        return sortEclairListCases ;
    }

    public <SortF> int[] getCasesSortF() {
        return sortFireListCases ;
    }

    public <PotionMin> int[] getCasesPotionMin() {
        return potionMinListCases ;
    }

    public <PotionNorm> int[] getCasesPotionNorm() {
        return potionNormListCases ;
    }

    public <PotionHigh> int[] getCasesPotionHigh() {
        return potionHighListCases ;
    }

}