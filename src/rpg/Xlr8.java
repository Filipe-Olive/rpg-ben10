package rpg;

public class Xlr8 implements FormaAlienigena {
    @Override
    public String getNomeForma() { return "XLR8"; }
    @Override
    public int getBonusAtaque() { return 7; }
    @Override
    public int getBonusDefesa() { return 2; }

    @Override
    public String usarHabilidade(Alvo alvo, int ataqueBase) {
        int real = alvo.receberDano(ataqueBase + 15);
        return "XLR8 cria um Tornado Cinetico e causa " + real + " de dano em " + alvo.getNome() + "!";
    }
}