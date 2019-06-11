package warriors.engine;

public class Guerrier extends Personnage {




    public Guerrier() {
        super() ;
    }

    public Guerrier(String playerName, String image, String type) {
        super(playerName, image, type) ;
    }

    public Guerrier(String playerName, String image, String type, int life, int force) {
        super(playerName, image, type, life, force) ;
    }
}