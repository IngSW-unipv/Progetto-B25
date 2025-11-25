package Model.Games_Storage;

import java.time.LocalDate;
import java.time.LocalTime;

public class Played_Game {
private int played_Game_id;
private int amount_bet;
private int amount_won;
private int amount_before;
private int amount_after;
private LocalDate creation_Date;
private LocalTime creation_Time;
private String game_name;

    public int getPlayed_Game_id() {
        return played_Game_id;
    }

    public void setPlayed_Game_id(int played_Game_id) {
        played_Game_id = played_Game_id;
    }

    public int getAmount_bet() {
        return amount_bet;
    }

    public void setAmount_bet(int amount_bet) {
        this.amount_bet = amount_bet;
    }

    public int getAmount_won() {
        return amount_won;
    }

    public void setAmount_won(int amount_won) {
        this.amount_won = amount_won;
    }

    public int getAmount_before() {
        return amount_before;
    }

    public void setAmount_before(int amount_before) {
        this.amount_before = amount_before;
    }

    public int getAmount_after() {
        return amount_after;
    }

    public void setAmount_after(int amount_after) {
        this.amount_after = amount_after;
    }

    public LocalDate getCreation_Date() {
        return creation_Date;
    }

    public void setCreation_Date(LocalDate creation_Date) {
        creation_Date = creation_Date;
    }

    public LocalTime getCreation_Time() {
        return creation_Time;
    }

    public void setCreation_Time(LocalTime creation_Time) {
        creation_Time = creation_Time;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }
}
