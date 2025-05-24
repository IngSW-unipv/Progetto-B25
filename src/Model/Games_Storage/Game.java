package Model.Games_Storage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

 public class Game {
    public int Game_id;
    private String name;
    private boolean active;
    public static LocalDate creationDate;
// per la creazione
     public Game(boolean active, String name) {
         this.active = active;
         this.name = name;
         creationDate = LocalDate.now();
     }
// per la visualizzazione
     public Game(boolean active, String name, int game_id, LocalDate creationDate) {
         this.active = active;
         this.name = name;
         Game_id = game_id;
         this.creationDate = creationDate;
     }

     public boolean isActive() {
         return active;
     }

     public void setActive(boolean active) {
         this.active = active;
     }

     public static LocalDate getCreationDate() {
         return creationDate;
     }

     public void setCreationDate(LocalDate creationDate) {
         this.creationDate = creationDate;
     }

     public int getGame_id() {
         return Game_id;
     }

     public void setGame_id(int game_id) {
         Game_id = game_id;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     @Override
    public String toString() {
        return "Game ID: " + Game_id + ", Nome: " + name + ", Stato: " + (active ? "Attivo" : "Rimosso");
    }
}

