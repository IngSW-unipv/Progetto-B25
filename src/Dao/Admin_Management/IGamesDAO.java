package Dao.Admin_Management;
import Model.Games_Storage.*;
import java.util.ArrayList;
public interface IGamesDAO {
    public boolean createGames(Game game);
    public boolean deleteGames(Game game);
    public boolean updateGames(Game game);
    public Game selectGamesById(int Game_id);
    public ArrayList<Game> selectAllGames();

}
