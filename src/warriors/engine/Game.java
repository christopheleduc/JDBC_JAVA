package warriors.engine;

import java.sql.Timestamp;
import java.time.Instant;
import warriors.contracts.GameState;
import warriors.contracts.GameStatus;
import warriors.contracts.Hero;
import warriors.contracts.Map;

public class Game implements GameState {

    /**
	 * Attributs.
	 */
    
    private String playerName;
    private Hero hero;
    private Map map;
    private String gameId;
    private GameStatus gameStatus;
    private String lastLog;
    private int currentCase;
    //String timestamp;
    
    /**
	 * Constructeur par defaut.
	 */

    // public Game() {
    //     //this.heroes.add(new Heros("Conan", "conan.png"));
    //     this("Player_1", "Conan", "Mordor");
    // }

    /**
	 * Constructeurs avec paramètres.
	 */

    public Game(String playerName, Hero hero, Map map) {

        // Initialisation des paramètres.
        this.setPlayerName(playerName) ;
        this.setHero(hero) ;
        this.setMap(map) ;

        // Création du gameId initial.
        Timestamp timestamp = new Timestamp(System.currentTimeMillis()) ; // Création du time stamp initial.
        Instant instant = timestamp.toInstant() ; // Convert timestamp to instant.
        //gameId = timestamp.toString() ;
        //gameId = instant.toString() ; // Convert to String.
        this.setGameId(instant.toString()) ; // set le gameId

        // Création de gameStatus.
        this.setGameStatus(GameStatus.IN_PROGRESS) ;

        // Création de lastLog.
        this.setLastLog("La partie commence. A vous de jouer!!!");

        // Création de la position initial du joueur (currentCase).
        this.setCurrentCase(0) ; // La partie commence à la position 0.

    }

    // public Game(String playerName, Hero hero, Map map, String gameId, GameStatus gameStatus, String lastLog, int currentCase) {
    //     this.setPlayerName(playerName) ;
    //     this.setHero(hero) ;
    //     this.setMap(map) ;
    //     this.setGameId(gameId) ;
    //     this.setGameStatus(gameStatus) ;
    //     this.setLastLog(lastLog) ;
    //     this.setCurrentCase(currentCase) ;
    // }

    /**
     * Méthodes bind from the GameState interface.
     */
    
    @Override
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName ;
    }

    @Override
    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId ;
    }

    @Override
    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus ;
    }

    @Override
    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero ;
    }

    @Override
    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map ;
    }

    @Override
    public String getLastLog() {
        return lastLog;
    }

    public void setLastLog(String lastLog) {
        this.lastLog = lastLog ;
    }

    @Override
    public int getCurrentCase() {
        return currentCase;
    }

    public void setCurrentCase(int currentCase) {
        this.currentCase = currentCase ;
    }

    // @Override
    // public String toString() {
    //     return this.getPlayerName();
    // }
    
}