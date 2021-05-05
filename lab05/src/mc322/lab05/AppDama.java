package mc322.lab05;

public class AppDama {

  public static String[] executaJogo(String caminhoArquivoCSV) {
    final int NUM_JOGADAS;
    CSVReader csv = new CSVReader();
    Tabuleiro tabuleiro = new Tabuleiro();
    String[] estadosDoJogo;
    String[] commands;

    csv.setDataSource(caminhoArquivoCSV);

    tabuleiro.adicionaPecas();

    commands = csv.requestCommands();
    NUM_JOGADAS = commands.length;
    estadosDoJogo = new String[NUM_JOGADAS+1];

    System.out.println("Tabuleiro inicial");
    estadosDoJogo[0] = tabuleiro.imprime();

    for(int i = 0; i < commands.length; i++) {
      tabuleiro.movimentaPeca(commands[i]);
      tabuleiro.imprimeJogada(commands[i]);
      estadosDoJogo[i+1] = tabuleiro.imprime();
    }

    return estadosDoJogo;
  }

  public static void main(String[] args) {
    String csvFile = "src/db/arq003.csv";
    String[] jogadas = AppDama.executaJogo(csvFile);

    for(int i = 0; i < jogadas.length; i++) {
        System.out.println(jogadas[i]);
    }
  }
}
