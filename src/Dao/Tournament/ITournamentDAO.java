package Dao.Tournament;

import Model.Tournament.StateTournament;
import Model.Tournament.Tournament;

public interface ITournamentDAO {
    public boolean createTournament(Tournament tournament);
    public boolean deleteTournament(Tournament tournament);
    public boolean updateStateTournament(int tournamentId, StateTournament state);
}
