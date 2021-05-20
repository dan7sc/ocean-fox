package mc322.lab06;

public class Componente {
  int lin;
  int col;
  char tipo;
  Caverna cv;

  public Componente(int lin, int col, char tipo) {
    this.lin = lin;
    this.col = col;
    this.tipo = tipo;
  }

  public void move(int lin, int col) {}

  public void colocaNaCaverna(Caverna cv) {
    this.cv = cv;
  }
}
