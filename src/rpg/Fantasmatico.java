package rpg;

public class Fantasmatico extends Inimigo {

    public Fantasmatico() {
        super("Fantasmatico", 85, 16, 3);
    }

    @Override
    public String agir(Personagem alvo, int turno) {
        if (turno % 3 == 0) {
            int real = alvo.receberDano(getAtaque() + 8);
            return getNome() + " dispara um RAIO ESPECTRAL em " + alvo.getNome() + " e causa " + real + " de dano!";
        }
        return atacar(alvo);
    }
}