package mc322.lab06;

import java.util.Scanner;

public class Controle {
  public Scanner keyboard;
  public Heroi heroi;
  public String player;
  public int score = 0;

  public Controle() {
    keyboard = new Scanner(System.in);
  }

  public void conectaHeroi(Componente heroi) {
    this.heroi = (Heroi) heroi;
  }

  public void leNomeJogador() {
    System.out.println("Digite o nome do jogador: ");
    player = keyboard.nextLine();
  }

  public String leMovimento() {
    String command = keyboard.nextLine();
    if(command.isEmpty()) {
      return new String("\n");
    }
    return command;
  }

  public void move(String movimento) {
    switch(movimento.charAt(0)) {
    case 'w':
      if(heroi.podeMover && heroi.lin - 1 > 0) {
        heroi.cv.removeDaSala(heroi);
        heroi.move(heroi.lin - 1, heroi.col);
        heroi.cv.colocaNaSala(heroi);
      }
      break;
    case 's':
      if(heroi.podeMover && heroi.lin < 4) {
        heroi.cv.removeDaSala(heroi);
        heroi.move(heroi.lin + 1, heroi.col);
        heroi.cv.colocaNaSala(heroi);
      }
      break;
    case 'd':
      if(heroi.podeMover && heroi.col < 4) {
        heroi.cv.removeDaSala(heroi);
        heroi.move(heroi.lin, heroi.col + 1);
        heroi.cv.colocaNaSala(heroi);
      }
      break;
    case 'a':
      if(heroi.podeMover && heroi.col - 1 > 0) {
        heroi.cv.removeDaSala(heroi);
        heroi.move(heroi.lin, heroi.col - 1);
        heroi.cv.colocaNaSala(heroi);
      }
      break;
    case 'k':
      System.out.println("equipa flecha");
      heroi.equipaFlecha();
      break;
    case 'c':
      heroi.capturaOuro();
      break;
    case 'q':
      System.out.println("sai do jogo");
      break;
    default:
      System.out.println("nada");
      break;
    }
  }

  public void exibePainel() {
    System.out.println("Player: " + player);
    System.out.println("Score: " + score);
    System.out.println("Flecha: " + heroi.flecha);
    System.out.println("Ouro: " + heroi.ouro);
    System.out.println();
  }

  public void iniciaJogo() {
    String key = new String();

    heroi.cv.exibe();
    exibePainel();
    while(heroi != null && !key.equals("q")) {
      key = leMovimento();
      move(key);
      heroi.cv.exibe();
      exibePainel();
    }
  }
}
