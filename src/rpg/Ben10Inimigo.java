package rpg;

public class Ben10Inimigo extends Inimigo {

    public Ben10Inimigo() {
        super("Ben 10", 110, 18, 5);
    }

    @Override
    public String agir(Personagem alvo, int turno) {
        if (turno % 2 == 0) {
            int real = alvo.receberDano(getAtaque() + 7);
            return getNome() + " vira Quatro Bracos, acerta um golpe duplo em " + alvo.getNome() + " e causa " + real + " de dano!";
        }
        return atacar(alvo);
    }
}