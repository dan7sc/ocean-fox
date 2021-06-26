import screen.Window;

public class App {
  public static String DIRETORIO = App.class.getResource(".").getPath();

  public static void main(String[] args) {
    Window window = new Window(DIRETORIO);
    window.initialize();
    window.open();
  }
}
