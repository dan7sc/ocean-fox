package mc322.lab05;

public class AppDama {
  static Tabuleiro t = new Tabuleiro();

  public static void executaJogo(String diretorio) {
    t.criaTabuleiro(true);

    System.out.print("Tabuleiro inicial:");

    CSVReader csv = new CSVReader();
    csv.setDataSource(diretorio);

    //vetor contendo os passos de execução
    String commands[] = csv.requestCommands();
    char[] posInicial = new char[2];
    char[] posFinal = new char[2];

    int n=commands.length; //contem o número de comandos presentes no .csv

    for(int j=1;j<n;j++) {
      posInicial[0]=commands[j].charAt(0);
      posInicial[1]=commands[j].charAt(1);

      posFinal[0]=commands[j].charAt(3);
      posFinal[1]=commands[j].charAt(4);

      System.out.println("\n");
      System.out.println("Source:"+posInicial[0]+"" +posInicial[1]);
      System.out.print("Target:"+posFinal[0]+"" +posFinal[1]);

      t.alteraPos(posInicial,posFinal,t);
      t.mostraTabuleiro();
    }
  }

  public static void main (String args []) {
    String diretorio = "src/db/arq001.csv";
    AppDama.executaJogo(diretorio);
  }
}
