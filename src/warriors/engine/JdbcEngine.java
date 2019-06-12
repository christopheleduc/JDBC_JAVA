package warriors.engine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JdbcEngine {

  private final String url = "jdbc:mysql://localhost:3306/java_jdbc_01?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
  private final String user = "jdbc_java";
  private final String passwd = "sasdipas";
  private Connection connection=null;	
  private Statement st=null;
  private ResultSet rs=null;
  private PreparedStatement ps=null;
  private int idPersonnage = 0;
  private String namePersonnage;
  private String typePersonnage;
  private int viePersonnage = 0;
  private int attackPersonnage = 0;
  private String armePersonnage;
  private String bouclierPersonnage;
  private String query;
  private ArrayList<String> retourEcran = new ArrayList<String>();

    // public static void main(String[] args) { 
           
    //     try {
    //       Class.forName("com.mysql.cj.jdbc.Driver");
    //       System.out.println("Driver O.K.");
    
    //       Connection conn = DriverManager.getConnection(url, user, passwd);
    //       System.out.println("Connexion effective !");         
             
    //     } catch (Exception e) {
    //       e.printStackTrace();
    //     }      
    //   }

      public ArrayList<String> getHeroes() {

      // CONNEXION A LA BASE DE DONNEES  
	     try{
          Class.forName("com.mysql.cj.jdbc.Driver");
          connection = DriverManager.getConnection(url, user, passwd);
          st=connection.createStatement();
          rs=st.executeQuery("SELECT id, type, nom, vie, attack, arme, bouclier from hero;");
          while (rs.next()) {	
            idPersonnage = rs.getInt("id");
            namePersonnage = rs.getString("nom");
            typePersonnage = rs.getString("type");
            viePersonnage = rs.getInt("vie");
            attackPersonnage = rs.getInt("attack");
            armePersonnage = rs.getString("arme");
            bouclierPersonnage = rs.getString("bouclier");       	             
            System.out.println ("Hero: " + "[ID: " + idPersonnage + " ]" + "[Nom: " + namePersonnage + " ]" + "[Type: " + typePersonnage + " ]" + "[Vie: " + viePersonnage + " ]" + "[Attack: " + attackPersonnage + " ]" + "[Arme: " + armePersonnage + " ]" + "[Bouclier: " + bouclierPersonnage+ " ]" );
            retourEcran.add("Hero: " + "[ID: " + idPersonnage + " ]" + "[Nom: " + namePersonnage + " ]" + "[Type: " + typePersonnage + " ]" + "[Vie: " + viePersonnage + " ]" + "[Attack: " + attackPersonnage + " ]" + "[Arme: " + armePersonnage + " ]" + "[Bouclier: " + bouclierPersonnage+ " ]" );
           }

          } catch (Exception e) {
            e.printStackTrace();
          } finally {
            if (connection != null)
              try { /* Close connexion */
                connection.close();
        } catch ( SQLException ignore ) {
          
        }
      }
      return retourEcran; 
      }

      public ArrayList<String> getHero(int Id) {
        
      // CONNEXION A LA BASE DE DONNEES  
	     try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url, user, passwd);
        //prepared statement
        query = "SELECT id, type, nom, vie, attack, arme, bouclier from hero where id = ?";
        ps=connection.prepareStatement(query);
        ps.setInt(1, Id);
        rs = ps.executeQuery();
        //st=connection.createStatement();
        // rs=st.executeQuery("SELECT id, type, nom, vie, attack, arme, bouclier from hero where id = ?");
        //rs.getInt(1, Id);
        rs.next(); 	
          idPersonnage = rs.getInt("id");
          namePersonnage = rs.getString("nom");
          typePersonnage = rs.getString("type");
          viePersonnage = rs.getInt("vie");
          attackPersonnage = rs.getInt("attack");
          armePersonnage = rs.getString("arme");
          bouclierPersonnage = rs.getString("bouclier");       	             
          System.out.println ("Hero: " + "[ID: " + idPersonnage + " ]" + "[Nom: " + namePersonnage + " ]" + "[Type: " + typePersonnage + " ]" + "[Vie: " + viePersonnage + " ]" + "[Attack: " + attackPersonnage + " ]" + "[Arme: " + armePersonnage + " ]" + "[Bouclier: " + bouclierPersonnage+ " ]" );
          retourEcran.add("Hero: " + "[ID: " + idPersonnage + " ]" + "[Nom: " + namePersonnage + " ]" + "[Type: " + typePersonnage + " ]" + "[Vie: " + viePersonnage + " ]" + "[Attack: " + attackPersonnage + " ]" + "[Arme: " + armePersonnage + " ]" + "[Bouclier: " + bouclierPersonnage+ " ]" );
         

        } catch (Exception e) {
          e.printStackTrace();
        } finally {
          if (connection != null)
            try { /* Close connexion */
              connection.close();
      } catch ( SQLException ignore ) {
        
      }
    }
    return retourEcran; 
        //return null;
      }

      public String createHero() {
        return null;
      }

      public String updateHero() {
        return null;
      }

      public String deleteHero(String id) {
        return null;
      }
    
}