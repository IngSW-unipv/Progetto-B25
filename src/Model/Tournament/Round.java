package Model.Tournament;

public class Round {
    private int roundId;
    private int tournamentId;
    private int roundTime;
    private int numFishRound;


    public Round(int roundId, int tournamentId, int roundTime, int numFishRound) {
        this.roundId = roundId;
        this.tournamentId = tournamentId;
        this.roundTime = roundTime;
        this.numFishRound = numFishRound;
    }

    //SETTER

    public void setRoundId(int roundId) {
        this.roundId = roundId;
    }

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    public void setRoundTime(int roundTime) {
        this.roundTime = roundTime;
    }

    public void setNumFishRound(int numFishRound) {
        this.numFishRound = numFishRound;
    }

    //GETTER

    public int getRoundId() {
        return roundId;
    }

    public int getTournamentId() {
        return tournamentId;
    }

    public int getRoundTime() {
        return roundTime;
    }

    public int getNumFishRound() {
        return numFishRound;
    }
}







