package warriors.engine;

// import com.sun.javafx.collections.MappingChange.Map;
import warriors.contracts.Map;

public class Maps implements Map {

    /**
	 * Attributs.
	 */

    private String name;
    private int numberOfCase;

    /**
	 * Constructeur par defaut.
	 */
    
    public Maps() {
        this("Mordor", 64);
    }

    /**
	 * Constructeur avec paramètres.
	 */

    public Maps(String name, int numberOfCase) {
        this.setName(name) ;
        this.setNumberOfCase(numberOfCase);
    }

    /**
	 * Méthodes bind from the Map interface.
	 */
    
    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name ;
    }
    
    @Override
    public int getNumberOfCase() {
        return numberOfCase;
    }

    public void setNumberOfCase(int numberOfCase) {
        this.numberOfCase = numberOfCase ;
    }

}