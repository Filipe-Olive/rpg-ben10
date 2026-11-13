package rpg;

public class CavaleiroEterno extends Inimigo {

    public CavaleiroEterno() {
        super("Cavaleiro Eterno", 60, 11, 2);
    }

    @Override
    public String agir(Personagem alvo, int turno) {
        if (turno % 3 == 0) {
            int real = alvo.receberDano(22);
            return getNome() + " dispara a LANCA LASER e causa " + real + " de dano!";
        } else {
            return atacar(alvo);
        }
    }

}
