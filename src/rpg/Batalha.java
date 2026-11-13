package rpg;

import java.util.List;
import java.util.Scanner;

public class Batalha {
    private Player player;
    private Inimigo inimigo;
    private Ben10Aliado aliado;
    private Scanner teclado;

    public Batalha(Player player, Inimigo inimigo, Ben10Aliado aliado, Scanner teclado) {
        this.player = player;
        this.inimigo = inimigo;
        this.aliado = aliado;
        this.teclado = teclado;
    }

    // devolve verdadeiro se o player venceu
    public boolean executar() {
        System.out.println("\n*** BATALHA: " + player.getNome() + " VS " + inimigo.getNome() + " ***");

        int turno = 1;
        while (player.estaVivo() && inimigo.estaVivo()) {
            System.out.println("\n--- Turno " + turno + " ---");
            mostrarStatus();
            turnoDoPlayer();

            // na luta final, o Ben 10 ajuda se estiver presente
            if (inimigo.estaVivo() && aliado != null) {
                System.out.println(aliado.agir(inimigo, player, turno));
            }

            if (inimigo.estaVivo()) {
                System.out.println(inimigo.agir(player, turno));
            }
            turno++;
        }

        if (player.estaVivo()) {
            System.out.println("\n>>> " + inimigo.getNome() + " foi derrotado! <<<");
        }
        return player.estaVivo();
    }

    private void mostrarStatus() {
        String forma = player.getFormaAtual().getNomeForma();
        System.out.println(player.getNome() + " (" + forma + ") | Vida: " + player.getVida() + "/" + player.getVidaMaxima() + " | Energia: " + player.getEnergia());
        System.out.println(inimigo.getNome() + " | Vida: " + inimigo.getVida() + "/" + inimigo.getVidaMaxima());
    }

    private void turnoDoPlayer() {
        System.out.println("\n1) Atacar");
        System.out.println("2) Habilidade do Alien (20 energia)");
        System.out.println("3) Transformar (Omnitrix)");
        System.out.println("4) Usar Item");

        int opcao = lerOpcao(1, 4);

        if (opcao == 1) {
            System.out.println(player.atacar(inimigo));
        } else if (opcao == 2) {
            System.out.println(player.usarHabilidadeAlien(inimigo));
        } else if (opcao == 3) {
            List<FormaAlienigena> formas = player.getFormas();
            for (int i = 0; i < formas.size(); i++) {
                FormaAlienigena alien = formas.get(i);
                System.out.println((i + 1) + ") " + alien.getNomeForma() + " (+" + alien.getBonusAtaque() + " Atq, +" + alien.getBonusDefesa() + " Def)");
            }
            int escolha = lerOpcao(1, formas.size());
            player.transformar(escolha - 1);
            System.out.println("Voce virou " + player.getFormaAtual().getNomeForma() + "!");
        } else if (opcao == 4) {
            List<Item> itens = player.getInventario();
            if (itens.isEmpty()) {
                System.out.println("Mochila vazia! Voce perdeu o turno procurando item.");
            } else {
                for (int i = 0; i < itens.size(); i++) {
                    Item item = itens.get(i);
                    System.out.println((i + 1) + ") " + item.getNome() + " - " + item.getDescricao());
                }
                int escolha = lerOpcao(1, itens.size());
                System.out.println(player.usarItem(escolha - 1));
            }
        }
    }

    // lê um número do menu e só aceita se estiver entre min e max
    private int lerOpcao(int min, int max) {
        int opcao = 0;
        boolean valido = false;

        while (!valido) {
            System.out.print("Escolha: ");

            if (teclado.hasNextInt()) {
                opcao = teclado.nextInt();

                if (opcao >= min && opcao <= max) {
                    valido = true;
                } else {
                    System.out.println("Opcao invalida!");
                }
            } else {
                System.out.println("Digite apenas numeros!");
                teclado.next();
            }
        }
        teclado.nextLine(); // limpa o Enter que sobrou
        return opcao;
    }
}