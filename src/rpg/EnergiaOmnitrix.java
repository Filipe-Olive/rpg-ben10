package rpg;

public class EnergiaOmnitrix implements Item {
    @Override
    public String getNome() { return "Celula de Energia"; }
    @Override
    public String getDescricao() { return "Recarrega 40 de energia do Omnitrix."; }

    @Override
    public String usar(Player player) {
        player.recarregarEnergia(40);
        return player.getNome() + " recarregou 40 de energia do Omnitrix!";
    }
}