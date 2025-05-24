package Dao.Admin_Management;
import Model.Games_Storage.Game;
import Model.Util.DBConnection;

import java.sql.*;
import java.util.ArrayList;

    public class GamesDAO implements IGamesDAO {

        private Connection conn;

        @Override
        public boolean createGames(Game game) {
            conn = DBConnection.startConnection(conn);
            PreparedStatement st;
            boolean outcome = true;
            try {
                String query = "INSERT INTO GAMES (ACTIVE, NAME, CREATIONDATE) VALUES (?, ?, ?)";
                st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                st.setBoolean(1, game.isActive());
                st.setString(2, game.getName());
                st.setDate(3, Date.valueOf(Game.getCreationDate()));;
                int affectedRows = st.executeUpdate();
                if (affectedRows > 0) {
                    try (ResultSet generatedKeys = st.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            int generatedId = generatedKeys.getInt(1);
                            game.setGame_id(generatedId);
                        }
                    }
                } else {
                    outcome = false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                outcome = false;
            } finally {
                DBConnection.closeConnection(conn);
            }
            return outcome;
        }

        @Override
        public boolean deleteGames(Game game) {
            conn = DBConnection.startConnection(conn);
            PreparedStatement st;
            boolean outcome = true;
            try {
                String query = "DELETE FROM GAMES WHERE GAME_ID = ?";
                st = conn.prepareStatement(query);
                st.setInt(1, game.getGame_id());
                int affectedRows = st.executeUpdate();
                if (affectedRows == 0) {
                    outcome = false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                outcome = false;
            } finally {
                DBConnection.closeConnection(conn);
            }
            return outcome;
        }

        @Override
        public boolean updateGames(Game game) {
            conn = DBConnection.startConnection(conn);
            PreparedStatement st;
            boolean outcome = true;
            try {
                String query = "UPDATE GAMES SET Active = ?, NAme = ? , Game_id= ?, CreationDate= ?, WHERE GAME_ID = ?";
                st = conn.prepareStatement(query);
                st.setBoolean(1, game.isActive());
                st.setString(2, game.getName());
                st.setInt(3, game.getGame_id());
                st.setDate(4, Date.valueOf(Game.getCreationDate()));
                int affectedRows = st.executeUpdate();
                if (affectedRows == 0) {
                    outcome = false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                outcome = false;
            } finally {
                DBConnection.closeConnection(conn);
            }
            return outcome;
        }

        @Override
        public Game selectGamesById(int gameId) {
            conn = DBConnection.startConnection(conn);
            PreparedStatement st;
            ResultSet rs;
            Game game = null;
            try {
                String query = "SELECT * FROM GAMES WHERE GAME_ID = ?";
                st = conn.prepareStatement(query);
                st.setInt(1, gameId);
                rs = st.executeQuery();
                if (rs.next()) {
                    game = new Game(
                            rs.getBoolean("ACTIVE"),
                            rs.getString("NAME"),
                            rs.getInt("GAME_ID"),
                            rs.getDate("CREATION_DATE").toLocalDate()
                    );
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.closeConnection(conn);
            }
            return game;
        }

        @Override
        public ArrayList<Game> selectAllGames() {
            ArrayList<Game> result = new ArrayList<>();
            conn = DBConnection.startConnection(conn);
            Statement st;
            ResultSet rs;
            try {
                String query = "SELECT * FROM GAMES";
                st = conn.createStatement();
                rs = st.executeQuery(query);
                while (rs.next()) {
                    Game game = new Game(
                            rs.getBoolean("ACTIVE"),
                            rs.getString("NAME"),
                            rs.getInt("GAME_ID"),
                            rs.getDate("CREATION_DATE").toLocalDate()
                    );
                    result.add(game);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.closeConnection(conn);
            }
            return result;
        }
    }


