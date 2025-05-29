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
    private int adminId;
    private LocalDate tournamentDataCreation;
    //AGGIUNGERE DATA INIZIO E ORARIO TORNEO
    //setDateTime


    /**
     *
     * @param adminId
     * @param tournamentName
     * @param entryFee
     * @param prizePool
     * @param numMaxPlayer
     * @param levelRequirement
     * @param numRound
     */
    public Tournament(int adminId, String tournamentName, double entryFee, double prizePool, int numMaxPlayer, int levelRequirement, int numRound) {
        this.adminId = adminId;
        this.tournamentName = tournamentName;
        this.entryFee = entryFee;
        this.prizePool = prizePool;
        this.numMaxPlayer = numMaxPlayer;
        this.levelRequirement = levelRequirement;
        this.numRound = numRound;


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
     * @param tournamentDataCreation
     * @param adminId
     */
    public Tournament(String tournamentName, int tournamentId, StateTournament tournamentStatus, double entryFee, double prizePool, int numMaxPlayer, int levelRequirement, int numRound, LocalDate tournamentDataCreation, int adminId) {
        this.tournamentName = tournamentName;
        this.tournamentId = tournamentId;
        this.entryFee = entryFee;
        this.prizePool = prizePool;
        this.numMaxPlayer = numMaxPlayer;
        this.levelRequirement = levelRequirement;
        this.numRound = numRound;
        this.adminId = adminId;

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

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public void setTournamentDataCreation(LocalDate tournamentDataCreation) {
        this.tournamentDataCreation = tournamentDataCreation;
    }

    //GETTER

    public String getTournamentName() {
        return tournamentName;
    }

    public int getTournamentId() {
        return tournamentId;
    }

    public StateTournament getTournamentStatus() {
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


    public int getAdminId() {
        return adminId;
    }

    public LocalDate getTournamentDataCreation() {
        return tournamentDataCreation;
    }
}




