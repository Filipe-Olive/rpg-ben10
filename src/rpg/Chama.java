package rpg;

public class Chama implements FormaAlienigena {
    @Override
    public String getNomeForma() { return "Chama"; }
    @Override
    public int getBonusAtaque() { return 6; }
    @Override
    public int getBonusDefesa() { return 1; }

    @Override
    public String usarHabilidade(Alvo alvo, int ataqueBase) {
        int real = alvo.receberDano(ataqueBase + 16);
        return "Chama dispara uma Supernova de Fogo e causa " + real + " de dano em " + alvo.getNome() + "!";
    }
}