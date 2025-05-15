package Model.Tournament;

import java.time.LocalDate;

public class Tournament {
    private String tournamentName;
    private int tournamentId;
    private StateTournament tournamentStatus;
    private double entryFee;
    private double prizePool;
    private int numMaxPlayer;
    private int levelRequirement;
    private int numRound;
    private int roundTime; //Non ho idea di come definire una variabile di tempo su JAVA
    private Enum gamesType;
    private int numFishRound;
    private int adminId;
    private LocalDate tournamentDataCreation;

    /**
     *
     * @param adminId
     * @param tournamentName
     */
    public Tournament(int adminId, String tournamentName) {
        this.adminId = adminId;
        this.tournamentName = tournamentName;
        tournamentStatus = StateTournament.PUBBLICO;
        tournamentDataCreation = LocalDate.now();
    }


    /**
     *
     * @param tournamentName
     * @param tournamentId
     * @param tournamentStatus
     * @param entryFee
     * @param prizePool
     * @param numMaxPlayer
     * @param levelRequirement
     * @param numRound
     * @param roundTime
     * @param gamesType
     * @param numFishRound
     */
    public Tournament(String tournamentName, int tournamentId, Enum tournamentStatus, double entryFee, double prizePool, int numMaxPlayer, int levelRequirement, int numRound, int roundTime, Enum gamesType, int numFishRound) {
        this.tournamentName = tournamentName;
        this.tournamentId = tournamentId;
        this.entryFee = entryFee;
        this.prizePool = prizePool;
        this.numMaxPlayer = numMaxPlayer;
        this.levelRequirement = levelRequirement;
        this.numRound = numRound;
        this.roundTime = roundTime;
        this.gamesType = gamesType;
        this.numFishRound = numFishRound;

        //per l'adminID andrà preso l'id dell'admin e associato al tournament, dovrà essere una cosa che avviene in automatico
    }




    //SETTER

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    public void setTournamentStatus(StateTournament tournamentStatus) {
        this.tournamentStatus = tournamentStatus;
    }

    public void setEntryFee(double entryFee) {
        this.entryFee = entryFee;
    }

    public void setPrizePool(double prizePool) {
        this.prizePool = prizePool;
    }

    public void setNumMaxPlayer(int numMaxPlayer) {
        this.numMaxPlayer = numMaxPlayer;
    }

    public void setLevelRequirement(int levelRequirement) {
        this.levelRequirement = levelRequirement;
    }

    public void setNumRound(int numRound) {
        this.numRound = numRound;
    }

    public void setRoundTime(int roundTime) {
        this.roundTime = roundTime;
    }

    public void setGamesType(Enum gamesType) {
        this.gamesType = gamesType;
    }

    public void setNumFishRound(int numFishRound) {
        this.numFishRound = numFishRound;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    //GETTER

    public String getTournamentName() {
        return tournamentName;
    }

    public int getTournamentId() {
        return tournamentId;
    }

    public Enum getTournamentStatus() {
        return tournamentStatus;
    }

    public double getEntryFee() {
        return entryFee;
    }

    public double getPrizePool() {
        return prizePool;
    }

    public int getNumMaxPlayer() {
        return numMaxPlayer;
    }

    public int getLevelRequirement() {
        return levelRequirement;
    }

    public int getNumRound() {
        return numRound;
    }

    public int getRoundTime() {
        return roundTime;
    }

    public Enum getGamesType() {
        return gamesType;
    }

    public int getNumFishRound() {
        return numFishRound;
    }

    public int getAdminId() {
        return adminId;
    }
}




