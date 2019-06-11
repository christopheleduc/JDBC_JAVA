package warriors.engine;

import java.util.HashMap;

import warriors.contracts.GameItem;
import warriors.contracts.GameState;
import warriors.contracts.GameStatus;

public class SpecialCases extends Warriors{

    /**
	 * Attributs.
	 */

     private int vie;
     private int attck;
     private int pos;

    /**
	 * Constructeur par defaut.
	 */
    public SpecialCases() {
        this(0, 0, 0) ;
    }

    /**
	 * Constructeurs avec paramètres.
	 */
    public SpecialCases(int pos) {
        this(pos, 0, 0) ;
    }

    public SpecialCases(int pos, int vie, int attck) {
        this.setPos(pos) ;
        this.setVie(vie) ;
        this.setAttck(attck) ;
    }
    
    /**
	 * Accesseurs.
	 */
    public int getPos() {
        return this.pos ;
    }

    public void setPos(int pos) {
        this.pos = pos ;
    }

    public int getVie() {
        return this.vie ;
    }

    public void setVie(int vie) {
        this.vie = vie ;
    }

    public int getAttck() {
        return this.attck ;
    }

    public void setAttck(int attck) {
        this.attck = attck ;
    }
     
    /**
	 * Méthodes.
	 */
    public void IsDragonCase (int des, HashMap<String, GameState> listGamer, String idGame) {
        GameItem parameters = GameItem.DRAGONS; // Utilise ENUM.
        // Teste si sur une case spécial.
        for (int position : parameters.getCasesDrag()){
            if(position == des) {
                System.out.println("!!! ATTENTION !!!"); // Avertissement.
                System.out.println("Vous etes en présence d'" + parameters.getNom() + " !"); // Description.
                System.out.println("Avec [ " + parameters.getLife() + " ] de Vie, et [ " + parameters.getAttack() + " ] d'attack !"); // Détails.

                //******************//
                // COMBAT.          //
                //******************//
                //Attributs+Calculs //
                int yourLife = ((Game)(listGamer.get(idGame))).getHero().getLife() ; // Recupère la vie du joueur.
                int yourAttack = ((Game)(listGamer.get(idGame))).getHero().getAttackLevel(); // on récupère l'attak du joueur.
                yourAttack = yourAttack - parameters.getAttack() ; // On soustrait les points d'attack de l'adversaire.
                yourLife = yourLife - parameters.getLife() ; // On soustrait les points de vie de l'adversaire.
                //((Heros) ((Game)(listGamer.get(idGame))).getHero()).setLife(pow) ; // On modifie (set) la vie du joueur.

                //Points Attack     //
                if(yourAttack >= 0) {   // Supérieur ou égal à zero.
                    ((Heros) ((Game)(listGamer.get(idGame))).getHero()).setAttackLevel(yourAttack) ; // On modifie (set) l'attack du joueur.
                    System.out.println("Il vous reste [ " + yourAttack + " ] d'attack !"); // Points d'attack restants.
                } else {                // Inferieur à zero
                    ((Heros) ((Game)(listGamer.get(idGame))).getHero()).setAttackLevel(0) ; // On modifie (set) l'attack du joueur à zero.
                    System.out.println("Il vous reste [ " + 0 + " ] d'attack !"); // Points d'attack restants.
                }
                //Points Vie        //
                if(yourLife <= 0) {     // Inferieur ou égal à zero.
                    ((Heros) ((Game)(listGamer.get(idGame))).getHero()).setLife(0) ; // On modifie (set) la vie du joueur à zero.
                    System.out.println("Il vous reste [ " + 0 + " ] de vie !"); // Points de vie restants.
                    System.out.println("Vous avez perdu !!!!!"); // Perdu.
                    ((Game)(listGamer.get(idGame))).setGameStatus(GameStatus.GAME_OVER) ; // Renvoi Game over.
                } else {                // Superieur à zero
                    ((Heros) ((Game)(listGamer.get(idGame))).getHero()).setLife(yourLife) ; // On modifie (set) la vie du joueur.
                    System.out.println("Il vous reste [ " + yourLife + " ] de vie !"); // Points de vie restants.
                    System.out.println("Vous gagnez le combat !!!!!"); // Vainceur.
                    ((Game)(listGamer.get(idGame))).setGameStatus(GameStatus.IN_PROGRESS) ; // Renvoi En cours.
                }
            }
        }
    }

    public void IsSorcierCase (int des, HashMap<String, GameState> listGamer, String idGame) {
        GameItem parameters = GameItem.SORCIERS; // Utilise ENUM.
        // Teste si sur une case spécial.
        for (int position : parameters.getCasesSorc()){
            if(position == des) {
                System.out.println("!!! ATTENTION !!!"); // Avertissement.
                System.out.println("Vous etes en présence d'" + parameters.getNom() + " !"); // Description.
                System.out.println("Avec [ " + parameters.getLife() + " ] de Vie, et [ " + parameters.getAttack() + " ] d'attack !"); // Détails.
                
                //******************//
                // COMBAT.          //
                //******************//
                //Attributs+Calculs //
                int yourLife = ((Game)(listGamer.get(idGame))).getHero().getLife() ; // Recupère la vie du joueur.
                int yourAttack = ((Game)(listGamer.get(idGame))).getHero().getAttackLevel(); // on récupère l'attak du joueur.
                yourAttack = yourAttack - parameters.getAttack() ; // On soustrait les points d'attack de l'adversaire.
                yourLife = yourLife - parameters.getLife() ; // On soustrait les points de vie de l'adversaire.
                //((Heros) ((Game)(listGamer.get(idGame))).getHero()).setLife(pow) ; // On modifie (set) la vie du joueur.

                //Points Attack     //
                if(yourAttack >= 0) {   // Supérieur ou égal à zero.
                    ((Heros) ((Game)(listGamer.get(idGame))).getHero()).setAttackLevel(yourAttack) ; // On modifie (set) l'attack du joueur.
                    System.out.println("Il vous reste [ " + yourAttack + " ] d'attack !"); // Points d'attack restants.
                } else {                // Inferieur à zero
                    ((Heros) ((Game)(listGamer.get(idGame))).getHero()).setAttackLevel(0) ; // On modifie (set) l'attack du joueur à zero.
                    System.out.println("Il vous reste [ " + 0 + " ] d'attack !"); // Points d'attack restants.
                }
                //Points Vie        //
                if(yourLife <= 0) {     // Inferieur ou égal à zero.
                    ((Heros) ((Game)(listGamer.get(idGame))).getHero()).setLife(0) ; // On modifie (set) la vie du joueur à zero.
                    System.out.println("Il vous reste [ " + 0 + " ] de vie !"); // Points de vie restants.
                    System.out.println("Vous avez perdu !!!!!"); // Perdu.
                    ((Game)(listGamer.get(idGame))).setGameStatus(GameStatus.GAME_OVER) ; // Renvoi Game over.
                } else {                // Superieur à zero
                    ((Heros) ((Game)(listGamer.get(idGame))).getHero()).setLife(yourLife) ; // On modifie (set) la vie du joueur.
                    System.out.println("Il vous reste [ " + yourLife + " ] de vie !"); // Points de vie restants.
                    System.out.println("Vous gagnez le combat !!!!!"); // Vainceur.
                    ((Game)(listGamer.get(idGame))).setGameStatus(GameStatus.IN_PROGRESS) ; // Renvoi En cours.
                }
            }
        }
    }

    public void IsGobelinCase (int des, HashMap<String, GameState> listGamer, String idGame) {
        GameItem parameters = GameItem.GOBELINS; // Utilise ENUM.
        // Teste si sur une case spécial.
        for (int position : parameters.getCasesGob()){
            if(position == des) {
                System.out.println("!!! ATTENTION !!!"); // Avertissement.
                System.out.println("Vous etes en présence d'" + parameters.getNom() + " !"); // Description.
                System.out.println("Avec [ " + parameters.getLife() + " ] de Vie, et [ " + parameters.getAttack() + " ] d'attack !"); // Détails.
                                
                //******************//
                // COMBAT.          //
                //******************//
                //Attributs+Calculs //
                int yourLife = ((Game)(listGamer.get(idGame))).getHero().getLife() ; // Recupère la vie du joueur.
                int yourAttack = ((Game)(listGamer.get(idGame))).getHero().getAttackLevel(); // on récupère l'attak du joueur.
                yourAttack = yourAttack - parameters.getAttack() ; // On soustrait les points d'attack de l'adversaire.
                yourLife = yourLife - parameters.getLife() ; // On soustrait les points de vie de l'adversaire.
                //((Heros) ((Game)(listGamer.get(idGame))).getHero()).setLife(pow) ; // On modifie (set) la vie du joueur.

                //Points Attack     //
                if(yourAttack >= 0) {   // Supérieur ou égal à zero.
                    ((Heros) ((Game)(listGamer.get(idGame))).getHero()).setAttackLevel(yourAttack) ; // On modifie (set) l'attack du joueur.
                    System.out.println("Il vous reste [ " + yourAttack + " ] d'attack !"); // Points d'attack restants.
                } else {                // Inferieur à zero
                    ((Heros) ((Game)(listGamer.get(idGame))).getHero()).setAttackLevel(0) ; // On modifie (set) l'attack du joueur à zero.
                    System.out.println("Il vous reste [ " + 0 + " ] d'attack !"); // Points d'attack restants.
                }
                //Points Vie        //
                if(yourLife <= 0) {     // Inferieur ou égal à zero.
                    ((Heros) ((Game)(listGamer.get(idGame))).getHero()).setLife(0) ; // On modifie (set) la vie du joueur à zero.
                    System.out.println("Il vous reste [ " + 0 + " ] de vie !"); // Points de vie restants.
                    System.out.println("Vous avez perdu !!!!!"); // Perdu.
                    ((Game)(listGamer.get(idGame))).setGameStatus(GameStatus.GAME_OVER) ; // Renvoi Game over.
                } else {                // Superieur à zero
                    ((Heros) ((Game)(listGamer.get(idGame))).getHero()).setLife(yourLife) ; // On modifie (set) la vie du joueur.
                    System.out.println("Il vous reste [ " + yourLife + " ] de vie !"); // Points de vie restants.
                    System.out.println("Vous gagnez le combat !!!!!"); // Vainceur.
                    ((Game)(listGamer.get(idGame))).setGameStatus(GameStatus.IN_PROGRESS) ; // Renvoi En cours.
                }
            }
        }
    }

    //public HashMap<String, GameState> IsArcCase (int des, HashMap<String, GameState> listGamer, String idGame) {
    public void IsArcCase (int des, HashMap<String, GameState> listGamer, String idGame) {
        GameItem parameters = GameItem.ARCS; // Utilise ENUM.
        // Teste si sur une case spécial.
        for (int position : parameters.getCasesArc()){
            if(position == des) {
                System.out.println("!!! ATTENTION !!!"); // Avertissement.
                System.out.println("Vous etes en présence d'" + parameters.getNom() + " !") ; // Description.
                System.out.println("Avec [ " + parameters.getAttack() + " ] d'attack !") ; // Détails.
                //listGamer.get(idGame).getHero().getAttackLevel() ; // TEST
                int pow = ((Game)(listGamer.get(idGame))).getHero().getAttackLevel(); // on récupère l'attak du joueur.
                pow = pow + parameters.getAttack() ; // On ajoute les points d'attack obtenues.
                ((Heros) ((Game)(listGamer.get(idGame))).getHero()).setAttackLevel(pow) ; // On modifie (set) l'attaque du joueur.
                System.out.println("Ce qui porte votre force d'attack à: [ " + ((Game)(listGamer.get(idGame))).getHero().getAttackLevel() + " ]"); // on affiche la nouvelle force d'attak du joueur.
                //return listGamer ; // On renvoie la HashMap modifiée.
                //return (parameters.getAttack() + power) ; // Renvoi le total des points d'attaque'.
            }
        }
        //return listGamer ; // renvoi la HashMap non modifiée !!!
    }

    public void IsMassueCase (int des, HashMap<String, GameState> listGamer, String idGame) {
        GameItem parameters = GameItem.MASSUES; // Utilise ENUM.
        // Teste si sur une case spécial.
        for (int position : parameters.getCasesMass()){
            if(position == des) {
                System.out.println("!!! ATTENTION !!!"); // Avertissement.
                System.out.println("Vous etes en présence d'" + parameters.getNom() + " !"); // Description.
                System.out.println("Avec [ " + parameters.getAttack() + " ] d'attack !"); // Détails.
                int pow = ((Game)(listGamer.get(idGame))).getHero().getAttackLevel(); // on récupère l'attak du joueur.
                pow = pow + parameters.getAttack() ; // On ajoute les points d'attack obtenues.
                ((Heros) ((Game)(listGamer.get(idGame))).getHero()).setAttackLevel(pow) ; // On modifie (set) l'attaque du joueur.
                System.out.println("Ce qui porte votre force d'attack à: [ " + ((Game)(listGamer.get(idGame))).getHero().getAttackLevel() + " ]"); // on affiche la nouvelle force d'attak du joueur.
                //return listGamer ; // On renvoie la HashMap modifiée.
                //return parameters.getAttack() ; // Renvoi les points d'attaque'.
            }
        }
        //return listGamer ; // renvoi la HashMap non modifiée !!!
    }

    public void IsEpeeCase (int des, HashMap<String, GameState> listGamer, String idGame) {
        GameItem parameters = GameItem.EPEES; // Utilise ENUM.
        // Teste si sur une case spécial.
        for (int position : parameters.getCasesEpee()){
            if(position == des) {
                System.out.println("!!! ATTENTION !!!"); // Avertissement.
                System.out.println("Vous etes en présence d'" + parameters.getNom() + " !"); // Description.
                System.out.println("Avec [ " + parameters.getAttack() + " ] d'attack !"); // Détails.
                int pow = ((Game)(listGamer.get(idGame))).getHero().getAttackLevel(); // on récupère l'attak du joueur.
                pow = pow + parameters.getAttack() ; // On ajoute les points d'attack obtenues.
                ((Heros) ((Game)(listGamer.get(idGame))).getHero()).setAttackLevel(pow) ; // On modifie (set) l'attaque du joueur.
                System.out.println("Ce qui porte votre force d'attack à: [ " + ((Game)(listGamer.get(idGame))).getHero().getAttackLevel() + " ]"); // on affiche la nouvelle force d'attak du joueur.
                //return listGamer ; // On renvoie la HashMap modifiée.
                //return parameters.getAttack() ; // Renvoi les points d'attaque'.
            }
        }
        //return listGamer ; // renvoi la HashMap non modifiée !!!
    }

    public void IsSortECase (int des, HashMap<String, GameState> listGamer, String idGame) {
        GameItem parameters = GameItem.SORTS_ECLAIR; // Utilise ENUM.
        // Teste si sur une case spécial.
        for (int position : parameters.getCasesSortE()){
            if(position == des) {
                System.out.println("!!! ATTENTION !!!"); // Avertissement.
                System.out.println("Vous etes en présence d'" + parameters.getNom() + " !"); // Description.
                System.out.println("Avec [ " + parameters.getAttack() + " ] d'attack !"); // Détails.
                int pow = ((Game)(listGamer.get(idGame))).getHero().getAttackLevel(); // on récupère l'attak du joueur.
                pow = pow + parameters.getAttack() ; // On ajoute les points d'attack obtenues.
                ((Heros) ((Game)(listGamer.get(idGame))).getHero()).setAttackLevel(pow) ; // On modifie (set) l'attaque du joueur.
                System.out.println("Ce qui porte votre force d'attack à: [ " + ((Game)(listGamer.get(idGame))).getHero().getAttackLevel() + " ]"); // on affiche la nouvelle force d'attak du joueur.
                //return listGamer ; // On renvoie la HashMap modifiée.
                //return parameters.getAttack() ; // Renvoi les points d'attaque'.
            }
        }
        //return listGamer ; // renvoi la HashMap non modifiée !!!
    }

    public void IsSortFCase (int des, HashMap<String, GameState> listGamer, String idGame) {
        GameItem parameters = GameItem.SORTS_FIRE; // Utilise ENUM.
        // Teste si sur une case spécial.
        for (int position : parameters.getCasesSortF()){
            if(position == des) {
                System.out.println("!!! ATTENTION !!!"); // Avertissement.
                System.out.println("Vous etes en présence d'" + parameters.getNom() + " !"); // Description.
                System.out.println("Avec [ " + parameters.getAttack() + " ] d'attack !"); // Détails.
                int pow = ((Game)(listGamer.get(idGame))).getHero().getAttackLevel(); // on récupère l'attak du joueur.
                pow = pow + parameters.getAttack() ; // On ajoute les points d'attack obtenues.
                ((Heros) ((Game)(listGamer.get(idGame))).getHero()).setAttackLevel(pow) ; // On modifie (set) l'attaque du joueur.
                System.out.println("Ce qui porte votre force d'attack à: [ " + ((Game)(listGamer.get(idGame))).getHero().getAttackLevel() + " ]"); // on affiche la nouvelle force d'attak du joueur.
                //return listGamer ; // On renvoie la HashMap modifiée.
                //return parameters.getAttack() ; // Renvoi les points d'attaque'.
            }
        }
        //return listGamer ; // renvoi la HashMap non modifiée !!!
    }

    public void IsPostionLCase (int des, HashMap<String, GameState> listGamer, String idGame) {
        GameItem parameters = GameItem.POTION_LOW; // Utilise ENUM.
        // Teste si sur une case spécial.
        for (int position : parameters.getCasesPotionMin()){
            if(position == des) {
                System.out.println("!!! ATTENTION !!!"); // Avertissement.
                System.out.println("Vous etes en présence d'" + parameters.getNom() + " !"); // Description.
                System.out.println("Avec [ " + parameters.getLife() + " ] de Vie !"); // Détails.
                int pow = ((Game)(listGamer.get(idGame))).getHero().getLife(); // on récupère la vie du joueur.
                pow = pow + parameters.getLife() ; // On ajoute les points de vie obtenues.
                ((Heros) ((Game)(listGamer.get(idGame))).getHero()).setLife(pow) ; // On modifie (set) la vie du joueur.
                System.out.println("Ce qui porte votre vie à: [ " + ((Game)(listGamer.get(idGame))).getHero().getLife() + " ]"); // on affiche la nouvelle vie du joueur.
                //return listGamer ; // On renvoie la HashMap modifiée.
                //return parameters.getLife() ; // Renvoi les points de vie.
            }
        }
        //return listGamer ; // renvoi la HashMap non modifiée !!!
    }

    public void IsPostionNCase (int des, HashMap<String, GameState> listGamer, String idGame) {
        GameItem parameters = GameItem.POTION_NORM; // Utilise ENUM.
        // Teste si sur une case spécial.
        for (int position : parameters.getCasesPotionNorm()){
            if(position == des) {
                System.out.println("!!! ATTENTION !!!"); // Avertissement.
                System.out.println("Vous etes en présence d'" + parameters.getNom() + " !"); // Description.
                System.out.println("Avec [ " + parameters.getLife() + " ] de Vie !"); // Détails.
                int pow = ((Game)(listGamer.get(idGame))).getHero().getLife(); // on récupère la vie du joueur.
                pow = pow + parameters.getLife() ; // On ajoute les points de vie obtenues.
                ((Heros) ((Game)(listGamer.get(idGame))).getHero()).setLife(pow) ; // On modifie (set) la vie du joueur.
                System.out.println("Ce qui porte votre vie à: [ " + ((Game)(listGamer.get(idGame))).getHero().getLife() + " ]"); // on affiche la nouvelle vie du joueur.
                //return listGamer ; // On renvoie la HashMap modifiée.
                //return parameters.getLife() ; // Renvoi les points de vie.
            }
        }
        //return listGamer ; // renvoi la HashMap non modifiée !!!
    }

    public void IsPostionHCase (int des, HashMap<String, GameState> listGamer, String idGame) {
        GameItem parameters = GameItem.POTION_HIGH; // Utilise ENUM.
        // Teste si sur une case spécial.
        for (int position : parameters.getCasesPotionHigh()){
            if(position == des) {
                System.out.println("!!! ATTENTION !!!"); // Avertissement.
                System.out.println("Vous etes en présence d'" + parameters.getNom() + " !"); // Description.
                System.out.println("Avec [ " + parameters.getLife() + " ] de Vie !"); // Détails.
                int pow = ((Game)(listGamer.get(idGame))).getHero().getLife(); // on récupère la vie du joueur.
                pow = pow + parameters.getLife() ; // On ajoute les points de vie obtenues.
                ((Heros) ((Game)(listGamer.get(idGame))).getHero()).setLife(pow) ; // On modifie (set) la vie du joueur.
                System.out.println("Ce qui porte votre vie à: [ " + ((Game)(listGamer.get(idGame))).getHero().getLife() + " ]"); // on affiche la nouvelle vie du joueur.
                //return listGamer ; // On renvoie la HashMap modifiée.
                //return parameters.getLife() ; // Renvoi les points de vie.
            }
        }
        //return listGamer ; // renvoi la HashMap non modifiée !!!
    }
    

}





