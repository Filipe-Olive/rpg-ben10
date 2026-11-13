package rpg;

public class Kevin11 extends Inimigo {

    public Kevin11() {
        super("Kevin 11", 90, 13, 4);
    }

    @Override
    public String agir(Personagem alvo, int turno) {
        if (turno % 3 == 0) {
            int real = alvo.receberDano(30);
            return getNome() + " absorve o metal ao redor e acerta um Golpe Metálico, causando " + real + " de dano!";
        } else {
            return atacar(alvo);
        }
    }
}