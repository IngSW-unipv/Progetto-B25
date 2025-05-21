package Dao.Tournament;

import Model.Tournament.ToFace;
import Model.Util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ToFaceDAO implements IToFaceDAO {
    private Connection conn;
    PreparedStatement st1;

    public boolean createToFace(ToFace toFace) {
        conn = DBConnection.startConnection(conn);

        boolean outcome = true;

        try{
            String query = "INSERT INTO TOFACE (ROUNDID, USERID, FISHWIN) VALUES (?,?,?)";
            st1 = conn.prepareStatement(query);

            st1.setInt(1, toFace.getRoundId());
            st1.setInt(2, toFace.getUserId());
            st1.setDouble(3, toFace.getFishWin());


            int affectedRows = st1.executeUpdate();

            if(affectedRows > 0){
                try (ResultSet generatedKeys = st1.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int generatedId = generatedKeys.getInt(1);
                            toFace.setRoundId(generatedId);
                    }
                }
            } else {
                outcome = false;
            }

        }catch (Exception e) {
            e.printStackTrace();
            outcome = false;
        }

        DBConnection.closeConnection(conn);
        return outcome;
    }
}
