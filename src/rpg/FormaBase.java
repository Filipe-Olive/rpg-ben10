package rpg;

public class FormaBase implements FormaAlienigena {
    @Override
    public String getNomeForma() { return "Humano"; }
    @Override
    public int getBonusAtaque() { return 0; }
    @Override
    public int getBonusDefesa() { return 0; }

    @Override
    public String usarHabilidade(Alvo alvo, int ataqueBase) {
        int real = alvo.receberDano(ataqueBase + 4);
        return "Golpe improvisado! Causou " + real + " de dano em " + alvo.getNome() + "!";
    }
}