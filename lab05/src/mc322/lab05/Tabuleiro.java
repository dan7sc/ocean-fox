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
    char ch;
    int indice;
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

  public boolean ehPermitidoPeca(char numero , char letra) {
    // Posicao inicial sem peça
    if(numero == '4' || numero == '5') {
      return false;
      // Posicoes proibidas em colocar peças no tabuleiro
    } else if (numero == '8' && (letra == 'a' || letra == 'c' || letra == 'e' || letra == 'g')) {
      return false;
    } else if (numero == '7' && (letra == 'b' || letra == 'd' || letra == 'f' || letra == 'h')) {
      return false;
    } else if (numero == '6' && (letra == 'a' || letra == 'c' || letra == 'e' || letra == 'g')) {
      return false;
    } else if (numero == '3' && (letra == 'b' || letra == 'd' || letra == 'f' || letra == 'h')) {
      return false;
    } else if (numero == '2' && (letra == 'a' || letra == 'c' || letra == 'e' || letra == 'g')) {
      return false;
    } else if (numero == '1' && (letra == 'b' || letra == 'd' || letra == 'f' || letra == 'h')) {
      return false;
    } else {
      return true;
    }
  }

  public void adicionaPecas() {
    String posicao;
    int indice = 0;

    for(int i = 0; i < LIN - 1; i++) {
      for(int j = 0; j < COL - 1; j++) {
        if(ehPermitidoPeca(linhas[i], colunas[j]) && indice < 24) {
          posicao = "" + colunas[j] + linhas[i];
          if(indice < 12) {
            pecas[indice++] = new Peao(posicao, 'p');
          } else {
            pecas[indice++] = new Peao(posicao, 'b');
          }
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

  public void movimentaPeca(String movimento) {
    Peca pecaAtacante;
    Peca pecaAlvo;
    Posicao posicaoInicial = new Posicao("" + movimento.charAt(0) + movimento.charAt(1));
    Posicao posicaoFinal = new Posicao("" + movimento.charAt(3) + movimento.charAt(4));
    Posicao posicaoDoAlvo;
    int finalMenosInicial;

    pecaAtacante = buscaPeca(posicaoInicial);
    finalMenosInicial = posicaoFinal.indiceNumero() - posicaoInicial.indiceNumero();
    if(pecaAtacante != null) {
      if(finalMenosInicial == 1 || finalMenosInicial == -1) {
        pecaAtacante.saltaPara(posicaoFinal);
        atualizaCasas(posicaoInicial, posicaoFinal, pecaAtacante.cor);
      } else if(finalMenosInicial > 1 || finalMenosInicial < -1) {
        posicaoDoAlvo = obtemPosicaoDoAlvo(pecaAtacante.posicao, posicaoFinal);
        pecaAlvo = buscaPeca(posicaoDoAlvo);
        if(pecaAlvo != null) {
          pecaAtacante.saltaPara(posicaoFinal);
          capturaPeca(pecaAlvo, posicaoDoAlvo);
          atualizaCasas(posicaoInicial, posicaoFinal, pecaAtacante.cor);
        }
      } else {
        System.out.println("Jogada proibida para peça alvo.");
      }
    } else {
      System.out.println("Jogada proibida para peça atacante.");
    }
  }

  public void capturaPeca(Peca alvo, Posicao posicaoDoAlvo) {
    casas[posicaoDoAlvo.indiceNumero()][posicaoDoAlvo.indiceLetra()] = '-';
    alvo.remove();
  }

  public void atualizaCasas(Posicao posicaoInicial, Posicao posicaoFinal, char cor) {
    casas[posicaoInicial.indiceNumero()][posicaoInicial.indiceLetra()] = '-';
    casas[posicaoFinal.indiceNumero()][posicaoFinal.indiceLetra()] = cor;
  }
}
