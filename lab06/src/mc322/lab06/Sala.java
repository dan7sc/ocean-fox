package mc322.lab06;

public class Sala {
  static final int N = 4;
  Componente[] componentes;
  int lin;
  int col;
  int nc;
  boolean visitada;

  public Sala(int lin, int col) {
    this.lin = lin;
    this.col = col;
    visitada = false;
    nc = 0;
    componentes = new Componente[N];
  }

  public void colocaComponente(Componente c) {
    if(c.tipo == 'P') {
      visitada = true;
    }
    componentes[nc] = c;
    nc += 1;
  }

  public void removeComponente(Componente c) {
    for (int i = 0; i < N; i++) {
      if(componentes[i] == c) {
        System.out.println("remove");
        componentes[i] = null;
        nc -= 1;
      }
    }
  }

  public char obtemElemento() {
    char ch = '#';
    if(componentes[0] == null && visitada) {
      return ch;
    }
    return componentes[0].tipo;
  }
}
