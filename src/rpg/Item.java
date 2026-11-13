package rpg;

public interface Item {
    String getNome();
    String getDescricao();
    String usar(Player player);
}