package mc322.lab06;

import java.util.Random;

public class Heroi extends Componente {
  int flecha = 1;
  int ouro = 0;
  boolean estaArmado = false;

  public Heroi(int lin, int col) {
    super(lin, col, 'P', 2, true);
  }

  public void move(int lin, int col) {
    super.lin = lin;
    super.col = col;
  }

  public void equipaFlecha() {
    if (flecha == 1) {
      estaArmado = true;
    }
  }

  public boolean disparaFlecha() {
    Random random = new Random();
    int N = random.nextInt(10);
    boolean matouWumpus;
    flecha = 0;
    estaArmado = false;

    if (N > 5) {
      matouWumpus = true;
    } else {
      matouWumpus = false;
    }

    return matouWumpus;
  }

  public void capturaOuro() {
    boolean capturouOuro = this.cv.removeDaSalaComponenteDoTipo(this.lin, this.col, 'O');
    if(capturouOuro) {
      ouro = 1;
    }
  }

  public void saiDaCaverna() {

  }
}
