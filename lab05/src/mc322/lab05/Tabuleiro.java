package mc322.lab05;

public class Tabuleiro {
  private static final int LIN = 10;
  private static final int COL = 10;
  char[][] tab;
  boolean state;
  Peca p = new Peca();

  public Tabuleiro (){
    tab = new char[LIN][COL];
  }

  public void criaTabuleiro (boolean state) {
    state = true;

    for(int i= 1; i <= 9; i++) {
      for(int j = 1; j <= 8; j++) {
        if(i == 4 | i == 5) {
          tab[i][j] = '-';
        } else {
          if(state) {
            if((i == 8| i == 6) && (j % 2 != 0)) {
              tab[i][j] = p.retorno('p');
            } else if(i == 2 && j % 2 != 0) {
              tab[i][j] = p.retorno('b');
            } else tab[i][j] = '-';
          }
          else if(!state) {
            if((i == 1 | i == 3) && (j % 2 == 0)) {
              tab[i][j] = p.retorno('b');
            } else if(i == 7 && j % 2 == 0) {
              tab[i][j] = p.retorno('p');
            } else tab[i][j] = '-';
          }
        }
        state=!state;
      }
      System.out.println();
    }
  }
  public void mostraTabuleiro () {
    System.out.println();
    char a = 'a';
    for(int i = 8; i >= 0; i--) {
      if(i != 0) System.out.print(""+i);
      for(int j = 1; j <= 9; j++) {
        if(i == 0 && j > 1) {
          System.out.print(a + " ");
          a++;
        } else {
          System.out.print(" ");
          System.out.print(tab[i][j]);
        }
      }
      System.out.println();
    }
  }

  public int traduzPos (char c) {
    //traduz as instruções em indices do vetor do tabuleiro
    int var=0;
    if(c=='a' | c=='1') var=1;
    else if(c=='a' | c=='1') var=1;
    else if(c=='b' | c=='2') var=2;
    else if(c=='c' | c=='3') var=3;
    else if(c=='d' | c=='4') var=4;
    else if(c=='e' | c=='5') var=5;
    else if(c=='f' | c=='6') var=6;
    else if(c=='g' | c=='7') var=7;
    else if(c=='h' | c=='8') var=8;

    return var;
  }

  public boolean validaPos (int i_origem, int j_origem, int i_destino, int j_destino) {
    boolean state_1=false,state_2=false,state_pos=false;
    int cont_1, a;

    cont_1 = i_destino - i_origem;
    if(cont_1 < 0) {
      cont_1 = cont_1 * (-1);
    }

    for(a=1; a<=cont_1;a++) {
      if(i_destino == i_origem + a | i_destino == i_origem - a) {
        state_1 = true;
        break;
      }
    }
    if(j_destino == j_origem + a | j_destino == j_origem - a) {
      state_2 = true;
    }
    if(state_1 && state_2 && tab[i_destino][j_destino] == '-') {
      state_pos = true;
    } else
      state_pos = false;

    return state_pos;
  }

  public void alteraPos(char[] A, char [] B, Tabuleiro t) {

    int i_1, j_1,i_2, j_2, posInter_i, posInter_j;

    //posicao inicial
    i_1 = traduzPos(A[1]);
    j_1 = traduzPos(A[0]);

    //posicao final
    i_2 = traduzPos(B[1]);
    j_2 = traduzPos(B[0]);
    if(i_2 > i_1) posInter_i = 1;
    else posInter_i = -1;

    if(j_2 > j_1) posInter_j = 1;
    else posInter_j = -1;

    if(validaPos(i_1, j_1, i_2, j_2)) {
      //verifica distância até a posFinal e se há uma peça entre elas:
      int dist = i_1 -i_2;
      if(dist < 0) dist = dist * (-1);
      System.out.println("\ndist:" + dist + "\nposIntermed:" + posInter_i);
      if(dist == 1) {
        System.out.print("\nEntrei aqui");
        tab[i_2][j_2] = tab[i_1][j_1];
        tab[i_1][j_1] = '-';
      } else if (dist==2 && tab[i_1 + posInter_i][j_1 + posInter_j] != '-') {
        System.out.print("\nEntrei aqui2");
        tab[i_2][j_2] = tab[i_1][j_1];
        tab[i_1 + posInter_i][j_1 + posInter_j] = '-';
        tab[i_1][j_1] = '-';
      }
    }
  }
}
