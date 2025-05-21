package Model.Tournament;

import java.time.LocalDate;

public class Participate {
    private int tournamentId;
    private int userId;
    private LocalDate participateDate;
    private int rank;
    private double balancePre;
    private double balancePost;

    public Participate(int tournamentId, int userId, LocalDate participateDate, int rank, double balancePre, double balancePost) {
        this.tournamentId = tournamentId;
        this.userId = userId;
        this.participateDate = participateDate;
        this.rank = rank;
        this.balancePre = balancePre;
        this.balancePost = balancePost;
    }

    //SETTER

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setParticipateDate(LocalDate participateDate) {
        this.participateDate = participateDate;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setBalancePre(double balancePre) {
        this.balancePre = balancePre;
    }

    public void setBalancePost(double balancePost) {
        this.balancePost = balancePost;
    }


    //GETTER

    public int getTournamentId() {
        return tournamentId;
    }

    public int getUserId() {
        return userId;
    }

    public LocalDate getParticipateDate() {
        return participateDate;
    }

    public int getRank() {
        return rank;
    }

    public double getBalancePre() {
        return balancePre;
    }

    public double getBalancePost() {
        return balancePost;
    }
}
