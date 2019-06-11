package warriors.engine;

import java.util.Random;

public abstract class Personnage {

    private int min = 5;
    private int max = 10;
    private final int mort = 0;
    protected final Random r = new Random();
    protected final String warrior = ("Guerrier");
    protected final String magician = ("Magicien");
    private String playerName;
    private String image;
    private String type;
    protected int life;
    protected int force;

    public Personnage() {
        this("Conan", "conan.png", "Guerrier", 0, 0);
    }

    public Personnage(String playerName, String image, String type) {
        this(playerName, image, type, 0, 0);
    }

    public Personnage(String playerName, String image, String type, int life, int force) {
        this.setName(playerName) ;
        this.setImage(image) ;
        this.setType(type) ;
        this.setLife(r.nextInt(max - min + 1) + min) ;
        this.setForce(r.nextInt(max - min + 1) + min) ;
    }

    public String getName() {
        return this.playerName ;
    }

    public void setName(String playerName) {
        this.playerName = playerName ;
    }

    public String getImage() {
        return this.image ;
    }

    public void setImage(String image) {
        this.image = image ;
    }

    public String getType() {
        return this.type ;
    }

    public void setType(String type) {
        this.type = type ;
    }

    public int getLife() {
        return this.life ;
    }

    public void setLife(int life) {
        this.life = life ;
    }

    public int getForce() {
        return this.force ;
    }

    public void setForce(int force) {
        this.force = force ;
    }

    public int getMin() {
        return this.min ;
    }

    public void setMin(int min) {
        this.min = min ;
    }

    public int getMax() {
        return this.max ;
    }

    public void setMax(int max) {
        this.max = max ;
    }

    public int getMort() {
        return this.mort ;
    }

}
