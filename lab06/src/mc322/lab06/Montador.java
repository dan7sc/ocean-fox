package mc322.lab06;

public class Montador {
  public Caverna cv;
  public Componente[] cmp;
  public static int N;

  public Montador() {
    cv = new Caverna();
  }

  public String[][] leArquivo(String arquivo) {
    CSVHandling csv = new CSVHandling();
    csv.setDataSource(arquivo);

    return csv.requestCommands();
  }

  public int obtemLinha(String[][] cmd, int indice) {
    return Integer.parseInt(cmd[indice][0].substring(0, 1));
  }

  public int obtemColuna(String[][] cmd, int indice) {
    return Integer.parseInt(cmd[indice][0].substring(2, 3));
  }

  public char obtemTipo(String[][] cmd, int indice) {
    return cmd[indice][1].charAt(0);
  }

  public int contaComponentes(String[][] cmd) {
    int contador = 0;

    for (int i = 0; i < cmd.length; i++) {
      if (cmd[i] != null && obtemTipo(cmd, i) != '_') {
        contador++;
      }
    }

    return contador;
  }

  public void iniciaCaverna(String[][] cmd) {
    Componente componente;
    int contador = 0;

    N = contaComponentes(cmd);
    cmp = new Componente[N];

    for (int i = 0; i < cmd.length; i++) {
      if (cmd[i] != null) {
        componente = criaComponente(obtemLinha(cmd, i),
                                    obtemColuna(cmd, i),
                                    obtemTipo(cmd, i));
        if (componente != null) {
          componente.colocaNaCaverna(cv);
          componente.cv.colocaNaSala(componente);
          cmp[contador++] = componente;
          if (componente.tipo == 'B') {
            ((Buraco) componente).criaBrisa();
          }
          if (componente.tipo == 'W') {
            ((Wumpus) componente).geraFedor();
          }
        }
      }
    }
  }

  public Componente criaComponente(int lin, int col, char tipo) {
    if (tipo == 'P') {
      return new Heroi(lin, col);
    } else if (tipo == 'W') {
      return new Wumpus(lin, col);
    } else if (tipo == 'O') {
      return new Ouro(lin, col);
    } else if (tipo == 'B') {
      return new Buraco(lin, col);
    } else {
      return null;
    }
  }

  public Componente obtemHeroi() {
    for(int i = 0; i < cmp.length; i++) {
      if(cmp[i].tipo == 'P') {
        return cmp[i];
      }
    }
    return null;
  }
}
