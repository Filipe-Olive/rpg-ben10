package rpg;

public abstract class Inimigo extends Personagem {
    public Inimigo (String nome, int vida, int ataque, int defesa) {
        super(nome, vida, ataque, defesa);
    }

    public abstract String agir(Personagem alvo, int turno);
    
}
