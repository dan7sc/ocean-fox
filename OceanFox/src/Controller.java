//Este código foi criado a partir do estudo de vídeo tutoriais disponíveis no youtube para a implementação de jogos em java
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.util.TreeSet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Canvas;

public class Controller
{
    public Jogo jogo;
    public BufferStrategy buffer;
    public TreeSet<String> string = new TreeSet<String>();
   
    
    public Controller(Jogo j) {
        jogo = j;
        Canvas tela = new Canvas();
        JFrame limite = new JFrame(jogo.getTitulo());
        JPanel layout = (JPanel) limite.getContentPane();
        
        
        layout.setPreferredSize(new Dimension(
                jogo.getLargura(), jogo.getAltura()));
        layout.setLayout(null);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();
        Rectangle bounds = gs[gs.length-1].getDefaultConfiguration().getBounds();
        limite.setResizable(false);
        limite.setBounds(bounds.x+(bounds.width - jogo.getLargura())/2,
                            bounds.y+(bounds.height - jogo.getAltura())/2,
                            jogo.getLargura(),jogo.getAltura());
        tela.setBounds(0,0,jogo.getLargura(),jogo.getAltura());
        layout.add(tela);        
        tela.setIgnoreRepaint(true);
        limite.pack();
        limite.setVisible(true);
        limite.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        tela.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent comando) {
                string.add(keyString(comando));
            }
            @Override
            public void keyReleased(KeyEvent comando) {
                string.remove(keyString(comando));
            }
            @Override
            public void keyTyped(KeyEvent comando) {
                jogo.tecla(keyString(comando));
            }
        });
        
        tela.createBufferStrategy(2);
        buffer = tela.getBufferStrategy();
        tela.requestFocus();
        mainLoop();
    }
    
    private void mainLoop() {
    	
        Timer t = new Timer(5, new ActionListener() {
            public long t0;
          
            public void actionPerformed(ActionEvent comando) {
                long t1 = System.currentTimeMillis();
                if(t0 == 0)
                    t0 = t1;
                if(t1 > t0) {
                    double dt = (t1 - t0) / 1000.0;
                    t0 = t1;
                    jogo.tique(string, dt);     
                    Graphics2D g = (Graphics2D)buffer.getDrawGraphics();
                    g.setColor(Color.black);
                    g.fillRect(0,0,jogo.getLargura(),
                          jogo.getAltura());
                    jogo.desenhar(new Tela(g));
                    buffer.show();
                }
            }
        });
            
        t.start();
    }

    
    private static String keyString(KeyEvent comando) {
        if(comando.getKeyChar() != KeyEvent.CHAR_UNDEFINED) {
            return String.valueOf(comando.getKeyChar()).toLowerCase();
        } else {
            switch(comando.getKeyCode()) {
            default: return "";
            }
        }
    }

    
}

