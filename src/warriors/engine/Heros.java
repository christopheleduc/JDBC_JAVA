package warriors.engine;

import java.util.Random;
import warriors.contracts.Hero;

public class Heros implements Hero {

    
    private int min = 10;
    private int max = 25;
    private Random r = new Random();
    private String name;
    private String image;
    private int life;
    private int attackLevel;
    private String warrior = ("Conan");
    private String magician = ("Gandalf");
    
    
    /**
	 * Constructeur par defaut.
	 */
    
    public Heros() {
        this("Conan", "conan.png");
    }

    /**
	 * Constructeurs avec paramètres.
	 */

    public Heros(String name, String image) {
        this(name, image, 0, 0);
    }

    public Heros(String name, String image, int life, int attackLevel) {
        this.setName(name) ;
        this.setImage(image) ;
        this.setLife(r.nextInt(max - min + 1) + min) ;
        this.setAttackLevel(r.nextInt(max - min + 1) + min) ;

        //this("Conan", "conan.png", "Guerrier", 0, 0);
    }

    /**
	 * Méthodes bind from the Hero interface.
     * and Map interface for "getName()".
	 */
    
    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name ;
    }

    @Override
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image ;
    }

    @Override
    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life ;
    }

    @Override
    public int getAttackLevel() {
        return attackLevel;
    }

    public void setAttackLevel(int attackLevel) {
        this.attackLevel = attackLevel ;
    }

}