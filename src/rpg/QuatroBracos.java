package rpg;

public class QuatroBracos implements FormaAlienigena {
    @Override
    public String getNomeForma() { return "Quatro Bracos"; }
    @Override
    public int getBonusAtaque() { return 8; }
    @Override
    public int getBonusDefesa() { return 3; }

    @Override
    public String usarHabilidade(Alvo alvo, int ataqueBase) {
        int real = alvo.receberDano(ataqueBase + 18);
        return "Quatro Bracos desfere um Soco Sismico e causa " + real + " de dano em " + alvo.getNome() + "!";
    }
}