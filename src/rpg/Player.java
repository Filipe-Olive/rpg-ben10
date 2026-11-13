package rpg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player extends Personagem {
    private FormaAlienigena formaAtual;
    private List<FormaAlienigena> formas;
    private List<Item> inventario;
    private int energia;
    private int energiaMaxima;
    private int bonusDefesaItem;

    public Player(String nome, int numero) {
        super(nome + " " + numero, 110, 14, 4);
        this.energiaMaxima = 60;
        this.energia = 60;
        this.bonusDefesaItem = 0;
        this.formaAtual = new FormaBase();

        this.formas = new ArrayList<>();
        this.formas.add(new Chama());
        this.formas.add(new QuatroBracos());

        this.inventario = new ArrayList<>();
        this.inventario.add(new PocaoDeCura());
        this.inventario.add(new EnergiaOmnitrix());
    }

    @Override
    public String atacar(Personagem alvo) {
        Random sorteio = new Random();
        int dano = getAtaque() + formaAtual.getBonusAtaque() + sorteio.nextInt(6);
        int real = alvo.receberDano(dano);
        return getNome() + " [" + formaAtual.getNomeForma() + "] ataca " + alvo.getNome() + " e causa " + real + " de dano!";
    }

    @Override
    public int receberDano(int dano) {
        int bonusTotal = formaAtual.getBonusDefesa() + bonusDefesaItem;
        int danoAposBonus = Math.max(1, dano - bonusTotal);
        return super.receberDano(danoAposBonus);
    }

    public String usarHabilidadeAlien(Personagem alvo) {
        int custo = 20;
        if (energia < custo) {
            return "Energia insuficiente (" + energia + "/" + energiaMaxima + ")! Voce fez um ataque normal.\n" + atacar(alvo);
        }
        energia -= custo;
        return formaAtual.usarHabilidade(alvo, getAtaque());
    }

    public void transformar(int indice) {
        this.formaAtual = formas.get(indice);
    }

    public void desbloquearForma(FormaAlienigena novaForma) {
        formas.add(novaForma);
    }

    public void adicionarItem(Item item) {
        inventario.add(item);
    }

    public String usarItem(int indice) {
        Item item = inventario.remove(indice);
        return item.usar(this);
    }

    public void recarregarEnergia(int qtd) {
        energia = Math.min(energiaMaxima, energia + qtd);
    }

    public void aumentarDefesa(int bonus) {
        bonusDefesaItem += bonus;
    }

    public FormaAlienigena getFormaAtual() { return formaAtual; }
    public List<FormaAlienigena> getFormas() { return formas; }
    public List<Item> getInventario() { return inventario; }
    public int getEnergia() { return energia; }
    public int getEnergiaMaxima() { return energiaMaxima; }
}