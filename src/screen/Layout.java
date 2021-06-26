package screen;

import java.awt.Container;

import javax.swing.GroupLayout;
import javax.swing.SwingConstants;

import static javax.swing.GroupLayout.Alignment.CENTER;

public class Layout extends GroupLayout {
  private GridPanel leftPanel;
  private InfoPanel rightPanel;

  public Layout(Container pane) {
    super(pane);
  }

  public void addGridPanel(GridPanel panel) {
    this.leftPanel = panel;
  }

  public void addInfoPanel(InfoPanel panel) {
    this.rightPanel = panel;
  }

  public void make() {
    setAutoCreateGaps(false);
    setAutoCreateContainerGaps(false);

    SequentialGroup hGroup = createSequentialGroup()
      .addComponent(leftPanel)
      .addGroup(createParallelGroup()
                .addGap(250)
                .addComponent(rightPanel.getTitle())
                .addGroup(createSequentialGroup()
                          .addComponent(rightPanel.getWhaleLifeLevelLabel())
                          .addComponent(rightPanel.getWhaleLifeLevel())
                          )
                .addGroup(createSequentialGroup()
                          .addComponent(rightPanel.getShipLifeLevelLabel())
                          .addComponent(rightPanel.getShipLifeLevel())
                          )
                .addGroup(createSequentialGroup()
                          .addComponent(rightPanel.getStartButton())
                          .addGap(15)
                          .addComponent(rightPanel.getStopButton())
                          )
                );
    linkSize(SwingConstants.HORIZONTAL, rightPanel.getStartButton(), rightPanel.getStopButton());

    setHorizontalGroup(hGroup);

    SequentialGroup vGroup = createSequentialGroup()
      .addGroup(createParallelGroup(CENTER)
                .addComponent(leftPanel)
                .addGroup(createSequentialGroup()
                          .addComponent(rightPanel.getTitle())
                          .addGap(25)
                          .addGroup(createParallelGroup()
                                    .addComponent(rightPanel.getWhaleLifeLevelLabel())
                                    .addComponent(rightPanel.getWhaleLifeLevel())
                                    )
                          .addGap(25)
                          .addGroup(createParallelGroup()
                                    .addComponent(rightPanel.getShipLifeLevelLabel())
                                    .addComponent(rightPanel.getShipLifeLevel())
                                    )
                          .addGap(25)
                          .addGroup(createParallelGroup()
                                    .addComponent(rightPanel.getStartButton())
                                    .addComponent(rightPanel.getStopButton())
                                    )
                          )
                );

    setVerticalGroup(vGroup);
  }
}
