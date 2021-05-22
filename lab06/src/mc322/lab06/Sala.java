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
    if(c.tipo == 'P' && temComponenteTipo('B')) {
      c.podeMover = false;
    }

    if(c.tipo == 'P' && temComponenteTipo('W')) {
      c.podeMover = false;
    }

    colocaComponente2(c);
  }

  public void colocaComponente2(Componente c) {
    if (c.tipo == 'P') {
      visitada = true;
    }
    componentes[nc] = c;
    nc += 1;
  }

  public void removeComponente(Componente c) {
    Componente[] tmp = new Componente[N];
    int indice = 0;

    for (int i = 0; i < N; i++) {
      if(componentes[i] == c) {
        nc -= 1;
      } else {
        tmp[indice++] = componentes[i];
      }
    }

    componentes = tmp;
  }

  public boolean temComponenteTipo(char tipo) {
    for (int i = 0; i < N; i++) {
      if (componentes[i] != null && componentes[i].tipo == tipo) {
        return true;
      }
    }
    return false;
  }

  public Componente obtemComponentePorOrdemDePrioridade() {
    Componente c;

    if(nc == 0) {
      return null;
    }

    if(nc == 1) {
      c = componentes[0];
      return c;
    }

    c = componentes[0];
    for(int i = 1; i < nc; i++) {
      if(c.prioridade > componentes[i].prioridade) {
        c = componentes[i];
      }
    }
    return c;
  }

  public Componente obtemComponenteDoTipo(char tipo) {
    Componente c = null;

    for (int i = 0; i < nc; i++) {
      if (componentes[i].tipo == tipo) {
        c = componentes[i];
      }
    }
    return c;
  }
}
