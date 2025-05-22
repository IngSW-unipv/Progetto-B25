package Dao.Tournament;

import Model.Tournament.StateTournament;
import Model.Tournament.Tournament;
import Model.Util.DBConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TournamentDAO implements ITournamentDAO {
    private Connection conn;


    public boolean createTournament(Tournament tournament) {
        conn= DBConnection.startConnection(conn);
        PreparedStatement st1;

        boolean outcome=true;


        try
        {
            String query = "INSERT INTO TOURNAMENT (TOURNAMENTNAME,TOURNAMENTSTATUS,ENTRYFEE,PRIZEPOOL,NUMMAXPLAYER,LEVELREQUIREMENT,NUMROUND,ADMINID,TOURNAMENTDATACREATION) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            st1 = conn.prepareStatement(query);

            st1.setString(1, tournament.getTournamentName());
            st1.setString(2, tournament.getTournamentStatus().name());
            st1.setDouble(3, tournament.getEntryFee());
            st1.setDouble(4, tournament.getPrizePool());
            st1.setInt(5, tournament.getNumMaxPlayer());
            st1.setInt(6, tournament.getLevelRequirement());
            st1.setInt(7, tournament.getNumRound());
            st1.setInt(8, tournament.getAdminId());
            st1.setDate(9, Date.valueOf(tournament.getTournamentDataCreation()));


            int affectedRows = st1.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = st1.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int generatedId = generatedKeys.getInt(1);
                        tournament.setTournamentId(generatedId);
                    }
                }
            } else {
                outcome = false;
            }

        }catch (Exception e){
            e.printStackTrace();
            outcome=false;
        }



        DBConnection.closeConnection(conn);
        return outcome;
    }


    public boolean deleteTournament(Tournament tournament) {
        conn= DBConnection.startConnection(conn);
        PreparedStatement st1;

        boolean outcome=true;

        try
        {
            String query = "DELETE FROM TOURNAMENT WHERE TOURNAMENTID = ?";

            st1 = conn.prepareStatement(query);
            st1.setInt(1, tournament.getTournamentId());

            int affectedrows = st1.executeUpdate();
            if (affectedrows == 0) {
                outcome = false;
            }

        }catch (Exception e){
            e.printStackTrace();
            outcome=false;
        }


        DBConnection.closeConnection(conn);
        return outcome;
    }



    public boolean updateStateTournament(int tournamentId, StateTournament state) {
        conn= DBConnection.startConnection(conn);
        PreparedStatement st1;

        boolean outcome=true;

        try
        {
            String query="UPDATE TOURNAMENT SET STATE = ? WHERE TOURNAMENTID = ?";

            st1 = conn.prepareStatement(query);
            st1.setString(1, state.name());
            st1.setInt(2, tournamentId);


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



    private ArrayList<Tournament> getAllTournament() {
        conn= DBConnection.startConnection(conn);
        PreparedStatement st1;
        ArrayList<Tournament> tournaments = new ArrayList<>();

        try{
            String query = "SELECT * FROM TOURNAMENT";
            st1 = conn.prepareStatement(query);

            ResultSet rs = st1.executeQuery();



            while (rs.next()) {
                Tournament t = new Tournament(
                        rs.getString(1),
                        rs.getInt(2),
                        StateTournament.valueOf(rs.getString(3)),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getDate(9).toLocalDate(),
                        rs.getInt(10)
                );
                tournaments.add(t);
            }


        }catch (Exception e){
            e.printStackTrace();
        }


        DBConnection.closeConnection(conn);
        return tournaments;
    }
}
