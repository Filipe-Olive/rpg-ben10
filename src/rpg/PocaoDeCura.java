package rpg;

public class PocaoDeCura implements Item {
    @Override
    public String getNome() { return "Pocao de Cura"; }
    @Override
    public String getDescricao() { return "Recupera 40 de vida."; }

    @Override
    public String usar(Player player) {
        player.curar(40);
        return player.getNome() + " usou Pocao de Cura e recuperou 40 de vida!";
    }
}