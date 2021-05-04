package mc322.lab05;

public class Peca {
  String posicao;
  char cor;

  public Peca(String posicao, char cor) {
    this.posicao = posicao;
    this.cor = cor;
  }

  public void saltaPara(String posicao) {
    this.posicao = posicao;
  }

  public void remove() {
    this.posicao = "";
  }

  public String obtemPosicaoDoAlvo(String alvo) {
    String posicao= new String();
    // Alvo está posicionado à direita do atacante
    if(alvo.charAt(0) - this.posicao.charAt(0) > 0) {
      posicao = posicao.concat(Character.toString(this.posicao.charAt(0) + 1));
      // Alvo está posicionado à esquerda do atacante
    } else if(alvo.charAt(0) - this.posicao.charAt(0) < 0) {
      posicao = posicao.concat(Character.toString(this.posicao.charAt(0) - 1));
      // Alvo está posicionado na mesma coluna do atacante
    } else {
      posicao = posicao.concat(Character.toString(this.posicao.charAt(0)));
    }
    // Alvo está posicionado acima do atacante
    if(alvo.charAt(1) - this.posicao.charAt(1) > 0) {
      posicao = posicao.concat(Character.toString(this.posicao.charAt(1) + 1));
      // Alvo está posicionado abaixo do atacante
    } else if(alvo.charAt(1) - this.posicao.charAt(1) < 0) {
      posicao = posicao.concat(Character.toString(this.posicao.charAt(1) - 1));
      // Alvo está posicionado na mesma linha do atacante
    } else {
      posicao = posicao.concat(Character.toString(this.posicao.charAt(1)));
    }

    return posicao;
  }
}
