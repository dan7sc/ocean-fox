package mc322.lab06;

public class Montador {
  String[][] cmd;

  public Montador(String[][] cmd) {
    this.cmd = cmd;
  }

  public void montaCaverna(Caverna cv) {
    Componente comp;
    int lin;
    int col;
    char tipo;

    for (int i = 0; i < cmd.length; i++) {
      if (cmd[i] != null) {
        lin = Integer.parseInt(cmd[i][0].substring(0, 1));
        col = Integer.parseInt(cmd[i][0].substring(2, 3));
        tipo = cmd[i][1].charAt(0);
        comp = criaComponente(lin, col, tipo);
        if (comp != null) {
          cv.colocaComponenteNaSala(comp, lin, col);
        }
      }
    }
  }

  public Componente criaComponente(int lin, int col, char tipo) {
    if(tipo == 'P') {
      return new Heroi(lin, col);
    } else if(tipo == 'W') {
      return new Wumpus(lin, col);
    } else if(tipo == 'O') {
      return new Ouro(lin, col);
    } else if(tipo == 'B') {
      return new Buraco(lin, col);
    } else if(tipo == 'f') {
      return new Fedor(lin, col);
    } else if(tipo == 'b') {
      return new Brisa(lin, col);
    } else {
      return null;
    }
  }
}
