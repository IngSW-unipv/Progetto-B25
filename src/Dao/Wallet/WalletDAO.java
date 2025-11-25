package Dao.Wallet;


import Model.Util.DBConnection;
import Model.Wallet_Payment.Wallet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WalletDAO implements IWalletDAO{
    private Connection conn;

    public boolean createWallet(Wallet wallet) {
        conn = DBConnection.startConnection(conn);
        PreparedStatement st1;
        
        boolean outcome = false;
        try{
            String query="insert into wallet(balance, deposit_limit) values(?,?)";
            st1=conn.prepareStatement(query);
            st1.setDouble(1, wallet.getBalance());
            st1.setDouble(2, wallet.getDeposit_limit());

            int affectedRows=st1.executeUpdate();
            if(affectedRows>0){

                //generazione id da parte del db
                try (ResultSet generatedKeys = st1.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int generatedId = generatedKeys.getInt(1);
                       wallet.setWallet_id(generatedId);
                    }
                }
            }else {
                outcome=false;
            }
        }catch (Exception e){
            e.printStackTrace();
            outcome=false;
        }

        DBConnection.closeConnection(conn);
        return outcome;

    }
    public boolean deleteWallet(int wallet_id) {
        conn = DBConnection.startConnection(conn);
        PreparedStatement st1;
        boolean outcome = true;

        try {
            String query="delete from wallet where wallet_id=?";
            st1=conn.prepareStatement(query);
            st1.setInt(1, wallet_id);
            int affectedRows=st1.executeUpdate();
            if(affectedRows==0){
                outcome=false;
            }
        }catch (Exception e){
            e.printStackTrace();
            outcome=false;
        }
        DBConnection.closeConnection(conn);
        return outcome;
        }
    }

