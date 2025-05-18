package Model.Util;
class Game {
    private static int counter = 1;
    private int id;
    private String nome;
    private boolean attivo;

    public Game(String nome) {
        this.id = counter++;
        this.nome = nome;
        this.attivo = true;
    }
}