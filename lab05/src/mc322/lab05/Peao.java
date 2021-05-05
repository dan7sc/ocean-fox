package mc322.lab05;

public class Peao extends Peca {
  public Peao(String posicao, char cor) {
    super(posicao, cor);
  }

  public void saltaPara(Posicao posicao) {
    this.posicao.atribui(posicao.obtem());
  }

  public void remove() {
    this.posicao.atribui("");
  }
}
