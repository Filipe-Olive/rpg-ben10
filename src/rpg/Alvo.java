package rpg;

public interface Alvo {
    String getNome();
    int receberDano(int dano);
    boolean estaVivo();
}