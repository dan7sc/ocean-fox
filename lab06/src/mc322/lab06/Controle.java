package mc322.lab06;

import java.util.Scanner;

public class Controle {
  public Scanner keyboard;

  public Controle() {
    keyboard = new Scanner(System.in);
  }

  public String leEntrada() {
    String command = keyboard.nextLine();
    System.out.println("command: " + command);
    // this.move(command, c);
    return command;
  }

  public void move(String movimento, Componente c, Caverna cv) {
    switch(movimento.charAt(0)) {
    case 'w':
      System.out.println("para cima");
      cv.removeComponenteDaSala(c, c.lin, c.col);
      cv.colocaComponenteNaSala(c, c.lin - 1, c.col);
      break;
    case 's':
      System.out.println("para baixo");
      cv.removeComponenteDaSala(c, c.lin, c.col);
      cv.colocaComponenteNaSala(c, c.lin + 1, c.col);
      break;
    case 'd':
      System.out.println("para direita");
      cv.removeComponenteDaSala(c, c.lin, c.col);
      cv.colocaComponenteNaSala(c, c.lin, c.col + 1);
      break;
    case 'a':
      System.out.println("para esquerda");
      cv.removeComponenteDaSala(c, c.lin, c.col);
      cv.colocaComponenteNaSala(c, c.lin, c.col - 1);
      break;
    case 'k':
      System.out.println("equipa flecha");
      break;
    case 'c':
      System.out.println("captura ouro");
      break;
    case 'q':
      System.out.println("sai do jogo");
      break;
    default:
      System.out.println("nada");
      break;
    }
  }
}
