package warriors.client.console;

import java.util.ArrayList;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;

import warriors.contracts.GameState;
import warriors.contracts.GameStatus;
import warriors.contracts.Hero;
import warriors.contracts.Map;
import warriors.contracts.WarriorsAPI;
import warriors.engine.JdbcEngine;
import warriors.engine.Warriors;
import java.sql.Connection;
import java.sql.DriverManager;

public class ClientConsole {
	
	private static String MENU_COMMENCER_PARTIE = "1";
	private static String MENU_QUITTER = "2";

	public static void main(String[] args) {
				
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver O.K.");
	  
			String url = "jdbc:mysql://localhost:3306/java_jdbc_01?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
			String user = "jdbc_java";
			String passwd = "sasdipas";
	  
			Connection conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("Connexion effective !");         
			   
		  } catch (Exception e) {
			e.printStackTrace();
		  } 
		ArrayList<String> listDeHeros = new ArrayList<>();

		JdbcEngine jdbcInstance = new JdbcEngine(); // Instancie JdbcEngine.
		System.out.println("*******************************************************");
		System.out.println("Affiche la liste des H�ros:");
		listDeHeros = jdbcInstance.getHeroes(); // Affiche la liste des H�ros; M�thode getHeroes.
		//System.out.println(listDeHeros);
		System.out.println("*******************************************************");
		System.out.println("Affiche un H�ro en fonction de l'ID pass� en param�tre:");
		jdbcInstance.getHero(2); // Affiche un H�ro en fonction de l'ID pass� en param�tre; M�thode getHero.
		System.out.println("*******************************************************");
		System.out.println("Cr�e un nouveau H�ro:");
		//jdbcInstance.createHero(); // Cr�e un nouveau H�ro; M�thode createHero.
		System.out.println("*******************************************************");
		System.out.println("Renome un H�ro:");
		//jdbcInstance.updateHero(); // Renome un H�ro; M�thode updateteHero.
		System.out.println("*******************************************************");
		System.out.println("Supprime un H�ro selon son ID:");
		//jdbcInstance.deleteHero(); // Supprime un H�ro selon son ID; M�thode deleteHero.
		

		WarriorsAPI warriors = new Warriors();
		Scanner sc = new Scanner(System.in);
		String menuChoice = "";
		do {
			menuChoice = displayMenu(sc);
			if(menuChoice.equals(MENU_COMMENCER_PARTIE)) {					
				startGame(warriors, sc);
			}			
		}while(!menuChoice.equals(MENU_QUITTER));
		sc.close();
		System.out.println("A bient�t");
	}

	private static void startGame(WarriorsAPI warriors, Scanner sc) {
		System.out.println();
		System.out.println("Entrez votre nom:");
		String playerName = sc.nextLine();
		
		System.out.println("Choisissez votre h�ro:");
		for(int i = 0; i < warriors.getHeroes().size(); i++) {
			Hero heroe = warriors.getHeroes().get(i);
			System.out.println(i+1 + " - " + heroe.getName());
			System.out.println("    Force d'attaque : " + heroe.getAttackLevel());
			System.out.println("    Niveau de vie : " + heroe.getLife());
		}
		Hero chosenHeroe = warriors.getHeroes().get(Integer.parseInt(sc.nextLine()) - 1);
		
		System.out.println("Choisissez votre map:");
		for(int i = 0; i < warriors.getMaps().size(); i++) {
			Map map = warriors.getMaps().get(i);
			System.out.println(i+1 + " - " + map.getName());
		}
		Map choosenMap = warriors.getMaps().get(Integer.parseInt(sc.nextLine()) - 1);

		GameState gameState = warriors.createGame(playerName, chosenHeroe, choosenMap);
		String gameId = gameState.getGameId();
		while (gameState.getGameStatus() == GameStatus.IN_PROGRESS) {
			System.out.println(gameState.getLastLog());
			System.out.println("\nAppuyer sur une touche pour lancer le d�"); 
			if(sc.hasNext()) {
				sc.nextLine();
				gameState = warriors.nextTurn(gameId);
			}									
		}
		
		System.out.println(gameState.getLastLog());
	}

	private static String displayMenu(Scanner sc) {
		System.out.println();
		System.out.println("================== Java Warriors ==================");
		System.out.println("1 - Commencer une partie");
		System.out.println("2 - Quitter"); 
		if(sc.hasNext()) {
			String choice = sc.nextLine();
			return choice;
		}		
		
		return "";
	}
}

