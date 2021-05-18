package mc322.lab06;

public class Caverna {
  static final int NLIN = 4;
  static final int NCOL = 4;
  static final char[] numeracao = { '1', '2', '3', '4' };
  Sala[][] salas;

  public Caverna() {
    salas = new Sala[NLIN][NCOL];
    for(int i = 0; i < salas.length; i++) {
      for (int j = 0; j < salas.length; j++) {
        salas[i][j] = new Sala(i, j, 3);
      }
    }
  }

  public String imprime() {
    for(int i = 0; i < NLIN; i++) {
      // Imprime numeros das linhas da caverna
      System.out.print(numeracao[i]);
      // Imprime caverna
      for(int j = 0; j < NCOL; j++) {
        if (salas[i][j].componentes[0] == null && salas[i][j].visitada) {
          System.out.print(" " + '#');
        } else if (salas[i][j].componentes[0] == null && !salas[i][j].visitada) {
          System.out.print(" " + '-');
        } else {
          System.out.print(" " + salas[i][j].componentes[0].ch);
        }
      }
      System.out.println();
    }
    System.out.print(" ");
    // Imprime numero das colunas da caverna
    for(int i = 0; i < NCOL; i++) {
      System.out.print(" " + numeracao[i]);
    }
    System.out.println();
    System.out.println();

    return "";
  }

  public void colocaComponenteNaSala(Componente c, int lin, int col) {
    salas[lin-1][col-1].colocaComponente(c, lin, col);
  }

  public void removeComponenteDaSala(Componente c, int lin, int col) {
    salas[lin - 1][col - 1].removeComponente(c, lin, col);
  }
 }
