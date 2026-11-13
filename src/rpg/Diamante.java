package rpg;

public class Diamante implements FormaAlienigena {
    @Override
    public String getNomeForma() { return "Diamante"; }
    @Override
    public int getBonusAtaque() { return 4; }
    @Override
    public int getBonusDefesa() { return 7; }

    @Override
    public String usarHabilidade(Alvo alvo, int ataqueBase) {
        int real = alvo.receberDano(ataqueBase + 14);
        return "Diamante dispara Rajada de Cristais e causa " + real + " de dano em " + alvo.getNome() + "!";
    }
}