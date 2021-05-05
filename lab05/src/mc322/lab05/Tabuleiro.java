package mc322.lab05;

public class Tabuleiro {
  static final int NUM_PECAS = 24;
  static final int LIN = 9;
  static final int COL = 9;
  static final char[] colunas = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', '\n' };
  static final char[] linhas = { '8', '7', '6', '5', '4', '3', '2', '1', '\n' };
  static final String inicio = "-p-p-p-p\np-p-p-p-\n-p-p-p-p\n--------\n--------\nb-b-b-b-\n-b-b-b-b\nb-b-b-b-\n";
  char[][] casas = new char[LIN][COL];
  Peca[] pecas = new Peao[NUM_PECAS];

  public Tabuleiro() {
    for(int i = 0; i < LIN; i++) {
      for(int j = 0; j < COL; j++) {
        if(i*COL+j < 72 && inicio.charAt(i*COL+j) != '\n') {
          casas[i][j] = inicio.charAt(i*COL+j);
        }
      }
    }
  }

  public String imprime() {
    String jogada = new String();

    for(int i = 0; i < LIN - 1; i++) {
      // Imprime numeros das linhas do tabuleiro
      System.out.print(linhas[i]);
      // Imprime tabuleiro
      for(int j = 0; j < COL - 1; j++) {
        jogada = jogada.concat("" + casas[i][j]);
        System.out.print(" " + casas[i][j]);
      }
      jogada = jogada.concat("" + '\n');
      System.out.println();
    }
    System.out.print(" ");
    // Imprime numero das colunas do tabuleiro
    for(int i = 0; i < COL; i++) {
      System.out.print(" " + colunas[i]);
    }
    System.out.println();

    return jogada;
  }

  public boolean ehPermitidoPeca(int lin, int col) {
    if(casas[lin][col] == '-') {
      return false;
    }
    return true;
  }

  public void adicionaPecas() {
    String posicao;
    char cor;
    int indice = 0;

    for(int i = 0; i < LIN - 1; i++) {
      for(int j = 0; j < COL - 1; j++) {
        if(ehPermitidoPeca(i, j)) {
          posicao = "" + colunas[j] + linhas[i];
          cor = casas[i][j];
          pecas[indice++] = new Peao(posicao, cor);
        }
      }
    }
  }

  public void imprimeJogada(String movimento) {
    System.out.println("Source: " + movimento.charAt(0) + movimento.charAt(1));
    System.out.println("Target: " + movimento.charAt(3) + movimento.charAt(4));
  }

  public Peca buscaPeca(Posicao posicao) {
    for(int i = 0; i < NUM_PECAS; i++) {
      if(pecas[i].posicao.obtem().compareTo(posicao.obtem()) == 0) {
        return pecas[i];
      }
    }
    return null;
  }

  public Posicao obtemPosicaoDoAlvo(Posicao atacante, Posicao alvo) {
    char letra = atacante.letra();
    char numero = atacante.numero();
    // Alvo está posicionado à direita do atacante
    if(alvo.letra() - atacante.letra() > 0) {
      letra++;
      // Alvo está posicionado à esquerda do atacante
    } else if(alvo.letra() - atacante.letra() < 0) {
      letra--;
    }
    // Alvo está posicionado acima do atacante
    if(alvo.numero() - atacante.numero() > 0) {
      numero++;
      // Alvo está posicionado abaixo do atacante
    } else if(alvo.numero() - atacante.numero() < 0) {
      numero--;
    }

    return new Posicao("" + letra + numero);
  }

  public boolean movePeca(String movimento) {
    Peca pecaAtacante;
    Posicao posicaoInicial = new Posicao("" + movimento.charAt(0) + movimento.charAt(1));
    Posicao posicaoFinal = new Posicao("" + movimento.charAt(3) + movimento.charAt(4));
    int numCasas; // numero de casas que a peça avançará
    boolean ehCapturada;

    pecaAtacante = buscaPeca(posicaoInicial);
    numCasas = Math.abs(posicaoFinal.indiceNumero() - posicaoInicial.indiceNumero());
    if(pecaAtacante == null) {
      return false;
    }
    if(numCasas > 1) {
      ehCapturada = capturaPeca(pecaAtacante, posicaoFinal);
      if(!ehCapturada) {
        return false;
      }
    }
    pecaAtacante.saltaPara(posicaoFinal);
    atualizaCasas(posicaoInicial, posicaoFinal, pecaAtacante.cor);

    return true;
  }

  public boolean capturaPeca(Peca atacante, Posicao posicaoFinal) {
    Posicao posicaoDoAlvo = obtemPosicaoDoAlvo(atacante.posicao, posicaoFinal);
    Peca alvo = buscaPeca(posicaoDoAlvo);
    if(alvo == null) {
      return false;
    }
    casas[posicaoDoAlvo.indiceNumero()][posicaoDoAlvo.indiceLetra()] = '-';
    alvo.remove();
    return true;
  }

  public void atualizaCasas(Posicao posicaoInicial, Posicao posicaoFinal, char cor) {
    casas[posicaoInicial.indiceNumero()][posicaoInicial.indiceLetra()] = '-';
    casas[posicaoFinal.indiceNumero()][posicaoFinal.indiceLetra()] = cor;
  }
}
