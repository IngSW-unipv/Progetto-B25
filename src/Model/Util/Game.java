package Model.Util;
class Game {
    private int id;
    private String name;
    private boolean active;

    public Game(String nome) {
        this.name = nome;
        this.active = true;
    }
}