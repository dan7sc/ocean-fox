package mc322.lab06;

public class AppMundoWumpus {
  public static void main(String[] args) {
    String[][] commands;
    CSVHandling csv = new CSVHandling();
    Caverna c = new Caverna();
    Controle ctrl = new Controle();
    Montador mnt;

    csv.setDataSource("src/db/arq001.csv");
    commands = csv.requestCommands();

    mnt = new Montador(commands);
    mnt.montaCaverna(c);

    c.imprime();

    ctrl.joga(c);
  }
}
