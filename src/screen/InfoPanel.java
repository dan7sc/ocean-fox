package screen;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComponent;

public class InfoPanel extends JComponent {
  private static final long serialVersionUID = 7407134314158686853L;
  private JComponent title;
  private JComponent whaleLifeLevelLabel;
  private JComponent shipLifeLevelLabel;
  private JComponent whaleLifeLevel;
  private JComponent shipLifeLevel;
  private JComponent startButton;
  private JComponent stopButton;

  public InfoPanel() {
    super();
  }

  public void initialize() {
    setTitle("Ocean Fox");
    setWhaleLifeLevelLabel();
    setWhaleLifeLevel(10);
    setShipLifeLevelLabel();
    setShipLifeLevel(10);
    setStartButton();
    setStopButton();
  }

  public void setTitle(String title) {
    this.title = new JLabel(title);
  }

  public void setWhaleLifeLevelLabel() {
    this.whaleLifeLevelLabel = new JLabel("Whale Life Level: ");
  }

  public void setShipLifeLevelLabel() {
    this.shipLifeLevelLabel = new JLabel("Ship Life Level: ");
  }

  public void setWhaleLifeLevel(int level) {
    this.whaleLifeLevel = new JLabel("" + level);
  }

  public void setShipLifeLevel(int level) {
    this.shipLifeLevel = new JLabel("" + level);
  }

  public void setStartButton() {
    this.startButton= new JButton("Start");
  }

  public void setStopButton() {
    this.stopButton = new JButton("Stop");
  }

  public JComponent getTitle() {
    return title;
  }

  public JComponent getWhaleLifeLevelLabel() {
    return whaleLifeLevelLabel;
  }

  public JComponent getShipLifeLevelLabel() {
    return shipLifeLevelLabel;
  }

  public JComponent getWhaleLifeLevel() {
    return whaleLifeLevel;
  }

  public JComponent getShipLifeLevel() {
    return shipLifeLevel;
  }

  public JComponent getStartButton() {
    return startButton;
  }

  public JComponent getStopButton() {
    return stopButton;
  }
}
