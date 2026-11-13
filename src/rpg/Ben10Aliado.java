package rpg;

public class Ben10Aliado {
    public String agir(Alvo chefe, Curavel aliadoPlayer, int turno) {
        if (turno % 2 == 0) {
            aliadoPlayer.curar(20);
            return "[ALIADO] Ben 10 usa Enxame Nano e cura 20 de vida de " + aliadoPlayer.getNome() + "!";
        } else {
            int real = chefe.receberDano(20);
            return "[ALIADO] Ben 10 vira Eco Eco, dispara grito sonico em " + chefe.getNome() + " e causa " + real + " de dano!";
        }
    }
}