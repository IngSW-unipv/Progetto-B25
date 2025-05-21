package Dao.Tournament;

import Model.Tournament.Tournament;
import Model.Tournament.TournamentRound;

public interface IRoundDAO {
    public boolean createRound(Tournament tournament, TournamentRound round);
}
