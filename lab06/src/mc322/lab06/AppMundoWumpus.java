package mc322.lab06;

public class AppMundoWumpus {
  public static void main(String[] args) {
    Controle ctrl = new Controle();
    Montador mnt = new Montador();
    String arq = args[0];
    String[][] cmd;

    cmd = mnt.leArquivo(arq);
    mnt.iniciaCaverna(cmd);

    ctrl.conectaHeroi(mnt.obtemComponente('P'));
    ctrl.leNomeJogador();
    ctrl.iniciaJogo();
  }
}
