package mc322.lab05;

public class AppDama {
  char[][]tab;
  boolean state;

  public AppDama (){
    tab = new char [8][8];
  }

  public static void criaTabuleiro (AppDama d, boolean state) {
    peaoPreto p = new peaoPreto();
    peaoBranco b = new peaoBranco();

    for(int i=1;i<=7;i++) {
      for(int j=1;j<=7;j++) {

        if(i==4 && j==4) d.tab[i][j]=p.retorno(state);

        else if(i==4|i==5) {
          d.tab[i][j]=p.retorno(state);

        } else {
          if(j==3|j==4|j==5) {

            d.tab[i][j]=b.retorno(state);
          } else {
            d.tab[i][j]=b.retorno(state);

          }
        }
      }
    }
  }

  public static void executaJogo(String diretorio) {
    System.out.println("executa jogo");
  }

  public static void main(String[] args) {
    System.out.println("main");
    AppDama app = new AppDama();
    app.executaJogo("dir");
  }
}
