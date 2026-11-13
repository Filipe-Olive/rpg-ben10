package rpg;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = teclado.nextLine();

        int numero = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print("Escolha seu numero (1 a 99): ");
            if (teclado.hasNextInt()) {
                numero = teclado.nextInt();
                if (numero >= 1 && numero <= 99) {
                    valido = true;
                } else {
                    System.out.println("Numero fora do intervalo!");
                }
            } else {
                System.out.println("Digite apenas numeros!");
                teclado.next();
            }
        }
        teclado.nextLine();

        Player player = new Player(nome, numero);
        System.out.println("Player Criado: " + player.getNome());

        Historia.mostrarPrologo(player.getNome(), teclado);

        Inimigo[] fases = {
                new CavaleiroEterno(),
                new Kevin11(),
                new Fantasmatico(),
                new Ben10Inimigo(),
                new Ben10000()
        };

        for (int i = 0; i < fases.length; i++) {
            Inimigo vilaoAtual = fases[i];
            Historia.mostrarIntroFase(i + 1, vilaoAtual, teclado);

            Ben10Aliado aliado = (i == 4) ? new Ben10Aliado() : null;
            if (aliado != null) {
                System.out.println("Ben 10 se junta a voce para salvar sua versao do futuro!");
            }
            
            Batalha batalha = new Batalha(player, vilaoAtual, aliado, teclado);
            boolean venceu = batalha.executar();

            if (!venceu) {
                System.out.println("\nVoce foi derrotado na Fase " + (i + 1) + "... GAME OVER.");
                return;
            }

            if (i == 0) {
                player.desbloquearForma(new Diamante());
                player.adicionarItem(new DefesaOmnitrix());
                System.out.println("\n[RECOMPENSA] Alien Diamante desbloqueado + Defesa do Omnitrix adicionado!");
            } else if (i == 1) {
                player.desbloquearForma(new Xlr8());
                player.adicionarItem(new PocaoDeCura());
                System.out.println("\n[RECOMPENSA] Alien XLR8 desbloqueado + Pocao de Cura adicionada!");
            } else if (i == 2) {
                player.adicionarItem(new EnergiaOmnitrix());
                System.out.println("\n[RECOMPENSA] Celula de Energia adicionada ao inventario!");
            } else if (i == 3) {
                player.adicionarItem(new PocaoDeCura());
                player.adicionarItem(new EnergiaOmnitrix());
                System.out.println(
                        "\n[RECOMPENSA] Ben 10 te entregou uma Pocao de Cura e uma Celula de Energia para a batalha final!");
            }

            if (i < fases.length - 1) {
                player.curar(35);
                player.recarregarEnergia(30);
                System.out.println("Voce recuperou 35 de vida e 30 de energia antes da proxima fase! Vida atual: "
                        + player.getVida() + "/" + player.getVidaMaxima());
            }
        }

        Historia.mostrarFinal(player.getNome());
    }
}