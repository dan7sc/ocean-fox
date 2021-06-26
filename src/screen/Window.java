package screen;

import java.awt.Container;

import javax.swing.JFrame;

public class Window extends JFrame {
	private static final long serialVersionUID = 6901334046997057478L;
  private static String DIR;

  public Window(String dir) {
    super();
    this.DIR = dir;
  }

  public void initialize() {
    setSize(900, 600);
    setResizable(false);
    setLocation(250, 60);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  public void open() {
    Container mainPane = getContentPane();
    Layout layout = new Layout(mainPane);
    GridPanel gridPanel = new GridPanel();
    InfoPanel infoPanel = new InfoPanel();

    infoPanel.initialize();

    layout.addGridPanel(gridPanel);
    layout.addInfoPanel(infoPanel);
    layout.make();
    mainPane.setLayout(layout);
  }
}
