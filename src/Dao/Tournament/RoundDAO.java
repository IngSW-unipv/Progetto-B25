package Dao.Tournament;

import Model.Tournament.Tournament;
import Model.Tournament.Round;
import Model.Util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RoundDAO implements IRoundDAO {
    private Connection conn;

    public boolean createRound(Round round) {
        conn = DBConnection.closeConnection(conn);
        PreparedStatement st1;

        boolean outcome = true;

        try{
           String query = "INSERT INTO ROUND (TOURNAMENTID, ROUNDTIME, NUMFISH) VALUES (?,?,?)";
           st1 = conn.prepareStatement(query);

           st1.setInt(1, round.getTournamentId());
           st1.setInt(2, round.getRoundTime());
           st1.setInt(3, round.getNumFishRound());

           int affectedRows = st1.executeUpdate();

           if(affectedRows > 0){
               try (ResultSet generatedKeys = st1.getGeneratedKeys()) {
                   if (generatedKeys.next()) {
                       int generatedId = generatedKeys.getInt(1);
                       round.setRoundId(generatedId);
                   }
               }
           }



        }catch (Exception e){
            e.printStackTrace();
            outcome=false;
        }

        DBConnection.closeConnection(conn);
        return outcome;
    }
}
