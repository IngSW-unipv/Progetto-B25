package Model.Games_Storage;

import java.util.ArrayList;
import java.util.List;

class Game {
    private int id;
    private String name;
    private boolean active;

    public Game(String name) {
        this.name = name;
        this.active = true;
    }
    public int getId() { return id; }
    public String getNome() { return nome; }
    public boolean isActive() { return attivo; }
    public void setAttivo(boolean attivo) { this.attivo = attivo; }

    @Override
    public String toString() {
        return "Game ID: " + id + ", Nome: " + nome + ", Stato: " + (attivo ? "Attivo" : "Rimosso");
    }
}
    private List<Game> games;
    private static GamesManager instance;

    private GamesManager() { games = new ArrayList<>(); }

    public static GamesManager getInstance() {
        if(instance == null)
            instance = new GamesManager();
        return instance;
    }

    public void addGame(String nome) { games.add(new Game(nome)); }

    public boolean removeGame(int id) {
        Game game = findGameById(id);
        if(game != null && game.isActive()){
            game.setAttivo(false);
            return true;
        }
        return false;
    }

    public boolean restoreGame(int id) {
        Game game = findGameById(id);
        if(game != null && !game.isActive()){
            game.setAttivo(true);
            return true;
        }
        return false;
    }

    public List<Game> getActiveGames() {
        List<Game> active = new ArrayList<>();
        for(Game g : games)
            if(g.isActive())
                active.add(g);
        return active;
    }

    public List<Game> getRemovedGames() {
        List<Game> removed = new ArrayList<>();
        for(Game g : games)
            if(!g.isActive())
                removed.add(g);
        return removed;
    }

    private Game findGameById(int id) {
        for(Game g : games)
            if(g.getId() == id)
                return g;
        return null;
    }
}