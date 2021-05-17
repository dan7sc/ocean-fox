package mc322.lab06;

public class Sala {
  Componente[] componentes;
  int lin;
  int col;
  int indice = 0;
  char visitada = '#';

  public Sala(int lin, int col, int qtde) {
    this.lin = lin;
    this.col = col;
    componentes = new Componente[qtde];
  }

  public void colocaComponente(Componente c, int lin, int col) {
    c.move(lin, col);
    componentes[indice] = c;
    indice += 1;
  }

  public void removeComponente(Componente c, int lin, int col) {
    for (int i = 0; i < componentes.length; i++) {
      if(componentes[i] == c) {
        componentes[i] = null;
        indice -= 1;
      }
    }
  }

  public char obtemElemento() {
    if(componentes[0] == null) {
      return visitada;
    }
    return componentes[0].ch;
  }
}
