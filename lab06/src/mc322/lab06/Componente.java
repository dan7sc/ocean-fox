package mc322.lab06;

public class Componente {
  int lin;
  int col;
  char tipo;
  int prioridade;
  boolean podeMover;
  Caverna cv;

  public Componente(int lin, int col, char tipo, int prioridade, boolean podeMover) {
    this.lin = lin;
    this.col = col;
    this.tipo = tipo;
    this.prioridade = prioridade;
    this.podeMover = podeMover;
  }

  public void colocaNaCaverna(Caverna cv) {
    this.cv = cv;
  }

  public void move(int lin, int col) {
  }
}
