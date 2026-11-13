package rpg;

public class Ben10000 extends Inimigo {

    public Ben10000() {
        super("Ben 10.000", 150, 22, 6);
    }

    @Override
    public String agir(Personagem alvo, int turno) {
        if (turno % 3 == 0) {
            int real = alvo.receberDano(getAtaque() + 10);
            return getNome() + " ativa o Controle Mestre como Enormossauro e causa " + real + " de dano em " + alvo.getNome() + "!";
        }
        return atacar(alvo);
    }
}