package mc322.lab06;

public class AppMundoWumpus {
  public static void main(String[] args) {
    String[][] commands;
    CSVHandling csv = new CSVHandling();

    csv.setDataSource("src/mc322/lab06/arq001.csv");
    commands = csv.requestCommands();

    for(int i = 0; i < commands.length; i++) {
      if(commands[i] != null) {
        for(int j = 0; j < commands[i].length; j++) {
          System.out.print(commands[i][j]);
        }
        System.out.println();
      }
    }
  }
}
