package screen;

import java.awt.Graphics;

import javax.swing.JComponent;

public class GridPanel extends JComponent {
	private static final long serialVersionUID = 6387981091991552704L;

  public GridPanel() {
    super();
    repaint();
  }

  public void paint(Graphics g) {
    makeGrid(g);
  }

  private void makeGrid(Graphics g) {
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        g.drawRect(50 + i * 50, 50 + j * 50, 50, 50);
      }
    }
  }
}
