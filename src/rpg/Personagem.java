package rpg;

import java.util.Random;

public class Personagem implements Alvo, Curavel {

    private String nome;
    private int vidaMaxima;
    private int vida;
    private int ataque;
    private int defesa;

    public Personagem(String nome, int vidaMaxima, int ataque, int defesa) {
        this.nome = nome;
        this.vidaMaxima = vidaMaxima;
        this.vida = vidaMaxima;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public boolean estaVivo() {
        return vida > 0;
    }
    public int receberDano(int dano) {
        int real = Math.max(1, dano - defesa);
        vida = Math.max(0, vida - real);
        return real;
    }

    public String atacar(Personagem alvo) {
        Random sorteio = new Random();
        int dano = ataque + sorteio.nextInt(6);
        int real = alvo.receberDano(dano);
        return nome + " ataca " + alvo.getNome() + " e causa " + real + " de dano!";
    }
    public void curar(int quantidade) {
    vida = Math.min(vidaMaxima, vida + quantidade);
}

}
