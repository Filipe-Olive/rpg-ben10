package rpg;

public interface FormaAlienigena {
    String getNomeForma();
    int getBonusAtaque();
    int getBonusDefesa();
    String usarHabilidade(Alvo alvo, int ataqueBase);
}