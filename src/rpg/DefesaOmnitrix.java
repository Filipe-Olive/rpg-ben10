package rpg;

public class DefesaOmnitrix implements Item {

    @Override
    public String getNome() {
        return "Defesa Omnitrix";
    }

    @Override
    public String getDescricao() {
        return "Aumenta +2 de defesa permanente.";
    }

    @Override
    public String usar(Player player) {
        player.aumentarDefesa(2);
        return player.getNome() + " ativou Defesa Omnitrix (+2 defesa)!";
    }
}