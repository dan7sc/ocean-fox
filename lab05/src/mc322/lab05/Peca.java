package mc322.lab05;

public class Peca {
  Posicao posicao;
  char cor;

  public Peca(String posicao, char cor) {
    this.posicao = new Posicao(posicao);
    this.cor = cor;
  }

  public void saltaPara(Posicao posicao) {}

  public void remove() {}
}
