package warriors.engine;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

//import java.util.Iterator;
import java.util.Random;
//import java.util.Set;
//import java.util.Map.Entry;

//import warriors.contracts.GameItem;
import warriors.contracts.GameState;
import warriors.contracts.GameStatus;
import warriors.contracts.Hero;
import warriors.contracts.Map;
import warriors.contracts.WarriorsAPI;
import warriors.engine.Game ;

public class Warriors implements WarriorsAPI {

    /**
	 * Attributs.
	 */
    
    //private ArrayList<Hero> heroes = new ArrayList<Hero>();
    //private ArrayList<Map> maps = new ArrayList<Map>();
    //private ArrayList<GameState> gameStatList = new ArrayList<GameState>();
    private HashMap<String, GameState> gameStatList = new HashMap<>();
    //private gameStatList = new gameStatList();
    private Random r = new Random();

    
    /**
	 * Constructeur par defaut.
	 */
    
    public Warriors() {
        // Création d'une liste de heros
        this.getHeroes() ;
        //this.heroes.add(new Heros("Conan", "conan.png"));
        //this.heroes.add(new Heros("Gandalf", "gandalf.png"));
        // Création d'une liste de map
        this.getMaps() ;
        //this.maps.add(new Maps("Mordor", 64));
        //this.maps.add(new Maps("Terre du milieu", 64));
        //this.maps.add(new Maps("NeverLand", 64));
    }

    /**
	 * Constructeurs avec paramètres.
	 */

    // public Warriors(String name) {
    //     //this.heroes.add(new Heros(name, "conan.png"));
    //     //this.maps.add(new Maps("Mordor", 64));
    //     this.maps.add(new Maps("Terre du milieu", 64));
    //     this.maps.add(new Maps("NeverLand", 64));
    // }

    // public Warriors(String name, String image, int life, int AttackLevel, String nameMap, int numberOfCase) {
    //     this.heroes.add(new Heros(name, image, life, AttackLevel));
    //     this.maps.add(new Maps(nameMap, numberOfCase));
    //     //heroes.add(warrior) ;
    //     //heroes.add(magician) ;
    //     // this.setPlayerName(playerName) ;
    //     // this.heroes.setImage(image) ;
    //     // this.setHero(hero) ;
    //     // this.setLife(r.nextInt(max - min + 1) + min) ;
    //     // this.heroes.setAttackLevel(r.nextInt(max - min + 1) + min) ;
    // }

    /**
	 * Méthodes bind from the WarriorsAPI interface.
	 */
    
    @Override
    public List<Hero> getHeroes() {
        ArrayList<Hero> heroes = new ArrayList<Hero>();
        heroes.add(new Heros("Conan", "conan.png"));
        heroes.add(new Heros("Gandalf", "gandalf.png"));
        return heroes ;
    }

    // public void setHeroes(List<Hero> heroes) {
    //     this.heroes = heroes new Heros()) ;
    //     //this.heroes = heroes ;
    // }

    @Override
    public List<Map> getMaps() {
        ArrayList<Map> maps = new ArrayList<Map>();
        maps.add(new Maps("Mordor", 64));
        maps.add(new Maps("Terre du milieu", 64));
        maps.add(new Maps("NeverLand", 64));
        return maps;
    }

    // public void setMaps(List<Map> maps) {
    //     this.maps = maps ;
    // }

    @Override
    public GameState createGame(String playerName, Hero hero, Map map) {

        // Instanciation de la partie
        GameState tour = new Game(playerName, hero, map);
        //HashMap<String, GameState> gameStatList = new HashMap<>();

        // Création du GameState
        //gameStatList.add(tour); // Ajout de l'intance de Game (interface GameState) dans la ArayList
        gameStatList.put(tour.getGameId(), tour); // Ajout de l'intance de Game (interface GameState) dans la HasMap
        System.out.println("****************************************");
        // System.out.println("gameId -> " + tour.getGameId());
        // System.out.println("DEBUG01: " + gameStatList.values()); // DEBUG

        // DEBUG
        // System.out.println("DEBUG01: "); // DEBUG
        // System.out.println("DEBUG01A: " + tour.getPlayerName()); // DEBUG
        // System.out.println("DEBUG01 GameId: " + gameStatList.get(tour.getGameId()).getGameId()); // DEBUG
        // System.out.println("DEBUG01 player name: " + gameStatList.get(tour.getGameId()).getPlayerName()); // DEBUG
        // System.out.println("DEBUG01 case: " + gameStatList.get(tour.getGameId()).getCurrentCase()); // DEBUG
        // System.out.println("DEBUG01 Hero: " + gameStatList.get(tour.getGameId()).getHero()); // DEBUG
        // System.out.println("DEBUG01 Map: " + gameStatList.get(tour.getGameId()).getMap()); // DEBUG
        // System.out.println("DEBUG01 GameStaut: " + gameStatList.get(tour.getGameId()).getGameStatus()); // DEBUG
        // System.out.println("DEBUG01 LastLog: " + gameStatList.get(tour.getGameId()).getLastLog()); // DEBUG

        // DEBUG
        // Set<Entry<String, GameState>> setGameStatList = gameStatList.entrySet();
        // Iterator<Entry<String, GameState>> it = setGameStatList.iterator();
        // while(it.hasNext()){
        //     Entry<String, GameState> e = it.next();
        //     System.out.println(e.getKey() + " : " + e.getValue());
        // }

        // for (HashMap.Entry<String, GameState> entry : gameStatList.entrySet()) {
        //     String key = entry.getKey();
        //     GameState value = entry.getValue();
        //     System.out.println(key + " -- " + value.toString());
        // }
        //System.out.println("coucou");

        // GameState tour2 = new Game(playerName, hero, map);
        // gameStatList.add(tour); 
        //gameStatList.get(1).getLastLog();
        //tour.getPlayerName(), tour.getGameId(), tour.getGameStatus(), tour.getHero(), tour.getMap(), tour.getLastLog(), tour.getCurrentCase()) ;
        //this.gameStat.add(new Game(playerName, hero, map));
        return tour; // Retourne l'instance de la partie.
    }

    @Override
    public GameState nextTurn(String gameID) {
        // lancer les dés.
        int de = r.nextInt(6 - 1 + 1) + 1 ; // random de 1 à 6.
        int des = de + gameStatList.get(gameID).getCurrentCase() ; // calcul la nouvelle position.
        //int energy = ((Game)(gameStatList.get(gameID))).getHero().getLife() ; // On recupere la vie du joueur.
        //int power = ((Game)(gameStatList.get(gameID))).getHero().getAttackLevel() ; // On recupere l'attaque du joueur.

        // + de 64 cases = Fin de partie.
        if(des >= 64){ // Si on est sur la case 64.
            System.out.println("Votre score: [ " + de + " ]"); // Affiche le score.
            ((Game)(gameStatList.get(gameID))).setCurrentCase(64) ; // Set current case FINAL.
            System.out.println("Vous etes maintenant sur la case: [ 64 ]") ; // Affiche la dernière case.
            System.out.println("-------------------------------------------") ; // Affiche la dernière case.
            ((Game)(gameStatList.get(gameID))).setLastLog("Bravo! Vous avez gagné!") ; // Affiche la dernière case.
            ((Game)(gameStatList.get(gameID))).setGameStatus(GameStatus.FINISHED) ; // Renvoi FIN.
        } else if(des < 64 && ((Game)(gameStatList.get(gameID))).getHero().getLife() > 0) { // Si on est pas encore sur la case 64 et qu'on a de la vie.
            System.out.println("Votre score: [ " + de + " ]"); // Affiche le score.
            ((Game)(gameStatList.get(gameID))).setCurrentCase(des) ; // Set current case.
            ((Game)(gameStatList.get(gameID))).setLastLog("Vous etes maintenant sur la case: [ " + des + " ]") ; // Affiche la nouvelle case.

            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"); // Affiche une barre.
            System.out.println("_________________________________________________________________________________"); // Affiche une barre.
            System.out.println("Votre vie: [ " + ((Game)(gameStatList.get(gameID))).getHero().getLife() + " ]"); // Affiche la vie du joueur.
            System.out.println("Votre force de frappe: [ " + ((Game)(gameStatList.get(gameID))).getHero().getAttackLevel() + " ]"); // Affiche les points d'attack du joueur.
            System.out.println("_________________________________________________________________________________"); // Affiche une barre.
            System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||"); // Affiche une barre.

            SpecialCases isSpecCase = new SpecialCases(des) ;
            //******************//
            // Les adversaires. //
            //******************//
            // Dragons          //
            isSpecCase.IsDragonCase(des, gameStatList, gameID) ;
            // Sorciers         //
            isSpecCase.IsSorcierCase(des, gameStatList, gameID) ;
            // Gobelins         //
            isSpecCase.IsGobelinCase(des, gameStatList, gameID) ;

            //******************//
            // Les bonus.       //
            //******************//
            // Arcs             //
            isSpecCase.IsArcCase(des, gameStatList, gameID) ;
            //((Heros) ((Game)(gameStatList.get(gameID))).getHero()).setAttackLevel(isSpecCase.IsArcCase(des, power)) ; // On recuperait l'attaque du joueur, mais j'ai inclus tous les calculs et modif dans la methode...
            //System.out.println("DEBUG points d'Attack: " + ((Game)(gameStatList.get(gameID))).getHero().getAttackLevel()) ; // DeBUG !!!

            // Massues          //
            isSpecCase.IsMassueCase(des, gameStatList, gameID) ;
            //System.out.println("DEBUG points d'Attack: " + ((Game)(gameStatList.get(gameID))).getHero().getAttackLevel()) ; // DeBUG !!!

            // Epées            //
            isSpecCase.IsEpeeCase(des, gameStatList, gameID) ;
            //System.out.println("DEBUG points d'Attack: " + ((Game)(gameStatList.get(gameID))).getHero().getAttackLevel()) ; // DeBUG !!!

            // Sorts Eclair     //
            isSpecCase.IsSortECase(des, gameStatList, gameID) ;
            //System.out.println("DEBUG points d'Attack: " + ((Game)(gameStatList.get(gameID))).getHero().getAttackLevel()) ; // DeBUG !!!

            // Sorts Fire       //
            isSpecCase.IsSortFCase(des, gameStatList, gameID) ;
            //System.out.println("DEBUG points d'Attack: " + ((Game)(gameStatList.get(gameID))).getHero().getAttackLevel()) ; // DeBUG !!!

            // Potion Min       //
            isSpecCase.IsPostionLCase(des, gameStatList, gameID) ;
            //System.out.println("DEBUG points de vie: " + ((Game)(gameStatList.get(gameID))).getHero().getLife()) ; // DeBUG !!!

            // Potion Norm      //
            isSpecCase.IsPostionNCase(des, gameStatList, gameID) ;
            //System.out.println("DEBUG points de vie: " + ((Game)(gameStatList.get(gameID))).getHero().getLife()) ; // DeBUG !!!

            // Potion High      //
            isSpecCase.IsPostionHCase(des, gameStatList, gameID) ;
            //System.out.println("DEBUG points de vie: " + ((Game)(gameStatList.get(gameID))).getHero().getLife()) ; // DeBUG !!!

            // a mettre en parametres.
            //((Game)(gameStatList.get(gameID))).getHero().getLife() ;
            //((Game)(gameStatList.get(gameID))).getHero().getLife() ;


            // GameItem parameters = GameItem.DRAGONS; // Utilise ENUM.
            // // Teste si sur une case spécial.
            // for (int position : parameters.getCasesDrag()){
            //     if(position == des) {
            //         System.out.println("!!! ATTENTION !!!"); // Avertissement.
            //         System.out.println("Vous etes en présence d'" + parameters.getNom() + " !"); // Description.
            //     }
            // }

        }

        System.out.println("****************************************"); // Separation.

        // recup state par rapport au gameID
        //next = this.Game.getGameId();
        //this.gameID tour.getGameId(gameID);
        // Renvoyer l'etat de la partie
        // gameStatList.get(1).getLastLog();
        // System.out.println("DEBUG02: " + gameStatList.get(gameID)); // DEBUG
        //System.out.println("DEBUG02 GameId: " + gameStatList.get(gameID.equals(gameID))); // DEBUG
        // Set<Entry<String, GameState>> setGameStatList = gameStatList.entrySet();
        // Iterator<Entry<String, GameState>> it = setGameStatList.iterator();
        // //Entry<String, GameState> e = it.next();
        // Entry<String, GameState> e = it.next();
        // System.out.println(e.getKey() + " : " + e.getValue());
        // return e.getValue() ;

        //gameStatList.get(gameID);
        

        return gameStatList.get(gameID) ;
        
    }
    
}