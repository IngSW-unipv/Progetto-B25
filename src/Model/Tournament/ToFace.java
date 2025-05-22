package Model.Tournament;

public class ToFace {
    private int roundId;
    private int userId;
    private double fishWin;


    public ToFace(int roundId, int userId) {
        this.roundId = roundId;
        this.userId = userId;
    }



    //SETTER

    public void setRoundId(int roundId) {
        this.roundId = roundId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setFishWin(double fishWin) {
        this.fishWin = fishWin;
    }

    //GETTER

    public int getRoundId() {
        return roundId;
    }

    public int getUserId() {
        return userId;
    }

    public double getFishWin() {
        return fishWin;
    }
}
