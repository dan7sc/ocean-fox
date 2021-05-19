package mc322.lab06;
import java.util.Random;
import java.util.Scanner;

public class Controle {
  public Scanner keyboard;

  public Controle() {
    keyboard = new Scanner(System.in);
  }

  public String leEntrada() {
    String command = keyboard.nextLine();
    System.out.println("command: " + command);
    if(command.isEmpty()) {
      return new String("\n");
    }
    return command;
  }

  public void move(String movimento, Componente c, Caverna cv) {
    switch(movimento.charAt(0)) {
    case 'w':
      if(c.lin - 1 > 0) {
        System.out.println("para cima");
        cv.removeComponenteDaSala(c, c.lin, c.col);
        cv.colocaComponenteNaSala(c, c.lin - 1, c.col);
      }
      break;
    case 's':
      if(c.lin < 4) {
        System.out.println("para baixo");
        cv.removeComponenteDaSala(c, c.lin, c.col);
        cv.colocaComponenteNaSala(c, c.lin + 1, c.col);
      }
      break;
    case 'd':
      if(c.col < 4) {
        System.out.println("para direita");
        cv.removeComponenteDaSala(c, c.lin, c.col);
        cv.colocaComponenteNaSala(c, c.lin, c.col + 1);
      }
      break;
    case 'a':
      if(c.col - 1 > 0) {
        System.out.println("para esquerda");
        cv.removeComponenteDaSala(c, c.lin, c.col);
        cv.colocaComponenteNaSala(c, c.lin, c.col - 1);
      }
      break;
    case 'k':
      System.out.println("equipa flecha");
      break;
    case 'c':
      if (cv.pegaOuro())System.out.println("captura ouro");
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
