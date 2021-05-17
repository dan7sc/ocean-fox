package mc322.lab06;

public class AppMundoWumpus {
  public static void main(String[] args) {
    String[][] commands;
    CSVHandling csv = new CSVHandling();
    Caverna c = new Caverna();
    Controle ctrl = new Controle();
    String key = new String();

    csv.setDataSource("src/db/arq001.csv");
    commands = csv.requestCommands();

    for(int i = 0; i < commands.length; i++) {
      if(commands[i] != null) {
        for(int j = 0; j < commands[i].length; j++) {
          System.out.print(commands[i][j]);
        }
        System.out.println();
      }
    }

    Heroi h = new Heroi(1, 1);
    c.colocaComponenteNaSala(h, 1, 1);
    c.imprime();

    while(!key.equals("q")) {
      key = ctrl.leEntrada();
      ctrl.move(key, h, c);
      c.imprime();
    }
  }
}
