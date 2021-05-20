package mc322.lab06;

public class Buraco extends Componente {
  public Buraco(int lin, int col) {
    super(lin, col, 'B');
  }

  public void criaBrisa() {
    Brisa b;

    if ((lin - 1 > 0 && lin - 1 < 5) && (col > 0 && col < 5)) {
      b = new Brisa(lin - 1, col);
      this.cv.colocaNaSala(b);
    }

    if ((lin > 0 && lin < 5) && (col + 1 > 0 && col + 1 < 5)) {
      b = new Brisa(lin, col + 1);
      this.cv.colocaNaSala(b);
    }

    if ((lin + 1 > 0 && lin + 1 < 5) && (col > 0 && col < 5)) {
      b = new Brisa(lin + 1, col);
      this.cv.colocaNaSala(b);
    }

    if ((lin > 0 && lin < 5) && (col - 1 > 0 && col - 1 < 5)) {
      b = new Brisa(lin, col - 1);
      this.cv.colocaNaSala(b);
    }
  }
}
