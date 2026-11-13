package rpg;

import java.util.Scanner;

public class Historia {

    public static void mostrarPrologo(String nomePlayer, Scanner teclado) {
        System.out.println("\n----------------------------------------");
        System.out.println("              PROLOGO");
        System.out.println("------------------------------------------");
        System.out.println(nomePlayer + " estava acampando na floresta durante as ferias.");
        System.out.println("De repente, uma capsula espacial cruza o ceu e cai bem perto dali.");
        System.out.println("Ao se aproximar da cratera, um relogio estranho salta e gruda no seu pulso!");
        System.out.println("Agora o Omnitrix e seu, e os inimigos ja estao vindo atras dele...");
        pausar(teclado);
    }

    public static void mostrarIntroFase(int numeroFase, Inimigo vilao, Scanner teclado) {
        System.out.println("\n----------------------------------------");
        System.out.println("FASE " + numeroFase + " - INIMIGO: " + vilao.getNome().toUpperCase());
        System.out.println("----------------------------------------");

        switch (numeroFase) {
            case 1:
                System.out.println("Um Cavaleiro Eterno bloqueia a estrada exigindo a entrega do relogio!");
                break;
            case 2:
                System.out.println("Kevin 11 aparece absorvendo metal e energia, pronto para tomar seu poder!");
                break;
            case 3:
                System.out.println("As sombras se espalham: Fantasmatico escapou e quer possuir o portador do Omnitrix!");
                break;
            case 4:
                System.out.println("O proprio Ben 10 surge para testar se voce e digno de carregar um Omnitrix!");
                break;
            case 5:
                System.out.println("ALERTA FINAL! Vilgax implantou um chip de controle mental no Ben 10.000!");
                System.out.println("Derrote-o para destruir o chip antes que ele destrua a cidade!");
                break;
        }
        pausar(teclado);
    }

    public static void mostrarFinal(String nomePlayer) {
        System.out.println("\n---------------------------------------");
        System.out.println("              VITORIA FINAL!");
        System.out.println("----------------------------------------");
        System.out.println("Com o ultimo golpe, o chip de Vilgax se estilhaca!");
        System.out.println("Ben 10.000 recupera a consciencia e agradece a " + nomePlayer + ".");
        System.out.println("O universo esta a salvo. Fim de jogo!");
    }

    private static void pausar(Scanner teclado) {
        System.out.print("\n[Pressione ENTER para continuar]");
        teclado.nextLine();
    }
}