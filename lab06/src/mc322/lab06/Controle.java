package mc322.lab06;

import java.util.Scanner;

public class Controle {
  public Scanner keyboard;
  public Componente heroi;

  public Controle() {
    keyboard = new Scanner(System.in);
  }

  public void conectaHeroi(Componente heroi) {
    this.heroi = heroi;
  }

  public String leEntrada() {
    String command = keyboard.nextLine();
    if(command.isEmpty()) {
      return new String("\n");
    }
    return command;
  }

  public void move(String movimento) {
    switch(movimento.charAt(0)) {
    case 'w':
      if(heroi.lin - 1 > 0) {
        heroi.cv.removeDaSala(heroi);
        heroi.move(heroi.lin - 1, heroi.col);
        heroi.cv.colocaNaSala(heroi);
      }
      break;
    case 's':
      if(heroi.lin < 4) {
        heroi.cv.removeDaSala(heroi);
        heroi.move(heroi.lin + 1, heroi.col);
        heroi.cv.colocaNaSala(heroi);
      }
      break;
    case 'd':
      if(heroi.col < 4) {
        heroi.cv.removeDaSala(heroi);
        heroi.move(heroi.lin, heroi.col + 1);
        heroi.cv.colocaNaSala(heroi);
      }
      break;
    case 'a':
      if(heroi.col - 1 > 0) {
        heroi.cv.removeDaSala(heroi);
        heroi.move(heroi.lin, heroi.col - 1);
        heroi.cv.colocaNaSala(heroi);
      }
      break;
    case 'k':
      System.out.println("equipa flecha");
      break;
    case 'c':
      // if (heroi.cv.pegaOuro()) {
        System.out.println("captura ouro");
      // }
      break;
    case 'q':
      System.out.println("sai do jogo");
      break;
    default:
      System.out.println("nada");
      break;
    }
  }

  public void iniciaJogo() {
    String key = new String();

    heroi.cv.exibe();
    while(!key.equals("q")) {
      key = leEntrada();
      move(key);
      heroi.cv.exibe();
    }
  }
}
