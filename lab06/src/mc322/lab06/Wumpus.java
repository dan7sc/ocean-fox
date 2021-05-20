package mc322.lab06;

public class Wumpus extends Componente {
  public Wumpus(int lin, int col) {
    super(lin, col, 'W');
  }

  public void geraFedor() {
    Fedor f;

    if ((lin - 1 > 0 && lin - 1 < 5) && (col > 0 && col < 5)) {
      f = new Fedor(lin - 1, col);
      this.cv.colocaNaSala(f);
    }

    if ((lin > 0 && lin < 5) && (col + 1 > 0 && col + 1 < 5)) {
      f = new Fedor(lin, col + 1);
      this.cv.colocaNaSala(f);
    }

    if ((lin + 1 > 0 && lin + 1 < 5) && (col > 0 && col < 5)) {
      f = new Fedor(lin + 1, col);
      this.cv.colocaNaSala(f);
    }

    if ((lin > 0 && lin < 5) && (col - 1 > 0 && col - 1 < 5)) {
      f = new Fedor(lin, col - 1);
      this.cv.colocaNaSala(f);
    }
  }
}
