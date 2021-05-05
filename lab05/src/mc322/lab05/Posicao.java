package mc322.lab05;

public class Posicao {
  private String pos;

  public Posicao(String posicao) {
    this.pos = posicao;
  }

  public String obtem() {
    return pos;
  }

  public void atribui(String posicao) {
    this.pos = posicao;
  }

  public char letra() {
    return pos.charAt(0);
  }

  public char numero() {
    return pos.charAt(1);
  }

  public int indiceNumero() {
    char ch = pos.charAt(1);

    return 8 - Integer.parseInt(String.valueOf(ch));
  }

  public int indiceLetra() {
    char ch = pos.charAt(0);

    return (int)ch - 97;
  }
}
