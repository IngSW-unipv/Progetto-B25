package Dao.Tournament;

import Model.Tournament.Participate;
import Model.Util.DBConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PartecipateDAO implements IPartecipateDAO {
    private Connection conn;

    public boolean createParticipate(Participate participate) {
        conn = DBConnection.startConnection(conn);
        PreparedStatement st1;

        boolean outcome = true;

        try{
            String query ="INSERT INTO PARTICIPATE (TOURNAMENTID, USERID, PARTICIPATEDATE, RANK, BALANCEPRE, BALANCEPOST) VALUES (?,?,?,?,?,?)";
            st1 = conn.prepareStatement(query);

            st1.setInt(1, participate.getTournamentId());
            st1.setInt(2, participate.getUserId());
            st1.setDate(3, Date.valueOf(participate.getParticipateDate()));
            st1.setInt(4, participate.getRank());
            st1.setDouble(5, participate.getBalancePre());
            st1.setDouble(6, participate.getBalancePost());

            int affectedRows = st1.executeUpdate();
            if(affectedRows == 0){
                outcome = false;
            }

        }catch (Exception e) {
            e.printStackTrace();
            outcome = false;
        }

        DBConnection.closeConnection(conn);
        return outcome;
    }



    public ArrayList<Participate> selectByUser(int userId) {
        conn = DBConnection.startConnection(conn);
        PreparedStatement st1;
        ArrayList<Participate> participates = new ArrayList<>();


        try{
            String query = "SELECT * FROM PARTICIPATE WHERE USERID = ?";
            st1 =conn.prepareStatement(query);
            st1.setInt(1, userId);

            ResultSet rs = st1.executeQuery();

            while(rs.next()){
                Participate p = new Participate(rs.getInt(1),rs.getInt(2), rs.getDate(3).toLocalDate(),
                                                rs.getInt(4), rs.getDouble(5), rs.getDouble(6));
                participates.add(p);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }


        DBConnection.closeConnection(conn);
        return participates;
    }


}
