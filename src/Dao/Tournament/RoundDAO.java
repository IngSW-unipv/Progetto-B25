package Dao.Tournament;

import Model.Tournament.Tournament;
import Model.Tournament.TournamentRound;
import Model.Util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RoundDAO implements IRoundDAO {
    private Connection conn;

    public boolean createRound(Tournament tournament, TournamentRound round) {
        conn = DBConnection.closeConnection(conn);
        PreparedStatement st1;

        boolean outcome = true;

        try{
            String query = "INSERT INTO ROUND (ROUNDID, TOURNAMENTID) VALUES (?,?)";
            st1 = conn.prepareStatement(query);

            st1.setInt(1, round.getRoundId());
            st1.setInt(2, tournament.getTournamentId());

            int affectedRows = st1.executeUpdate();

            if (affectedRows == 0) {
                outcome = false;
            }




        }catch (Exception e){
            e.printStackTrace();
            outcome=false;
        }

        DBConnection.closeConnection(conn);
        return outcome;
    }
}
