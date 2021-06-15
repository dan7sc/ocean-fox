import java.util.ArrayList;
import java.util.Random;

public class OceanFox implements Jogo {

	public double ground_offset = 0;
	public double gvx = 70;
	public Navio navio;
	public ArrayList<Obstaculo> obstaculos = new ArrayList<Obstaculo>();
	public Random gerador = new Random();
	public Timer timer_cano;
	
	public OceanFox(){
		 navio = new Navio(150,(getLargura()-100)/2 + 50/2); //posição de partida do navio -> teste
		 timer_cano = new Timer(3, true, addCano());
		 addCano().executa();
	}
	
	private Acao addCano(){
        return new Acao(){
          public void executa(){
        	  obstaculos.add(new Obstaculo(getLargura()+10, gerador.nextInt(getAltura()-112-Obstaculo.HOLESIZE), -gvx));
          }
        };
      }
	
	public String getTitulo(){
		return "Flappy Bird Aula";
	}
	public int getLargura(){
		return 384;
	}
    public int getAltura(){
    	return 512;
    }

    public void tecla(String tecla){
    	if(tecla.equals(" ")){
    		navio.flap();
    	}
    }
    
    //todas as dependências do tempo
    public void tique(java.util.Set<String> teclas, double dt){
    	ground_offset += dt*gvx;
    	ground_offset = ground_offset%308;
    	
    	timer_cano.tique(dt);
    	
    	navio.atualiza(dt);
    	if(navio.y+24>=getAltura()-112){
    		System.out.println("GAME OVER");
    	} else if(navio.y <= 0){
    		System.out.println("GAME OVER");
    	}
    	
    	for(Obstaculo obstaculo: obstaculos){
    		obstaculo.atualiza(dt);
    		if(navio.box.intersecao(obstaculo.boxcima)!=0 || navio.box.intersecao(obstaculo.boxbaixo)!=0){
    			System.out.println("GAME OVER BOYZ");
    		}
    	}
    	
    	//if(obstaculos.size()>0 && obstaculos.get(0).x < -60){
    		//obstaculos.remove(0);
    		//System.out.println("Cano Removido");
    		//System.out.println(obstaculos.size());
    	//}
    	
    	
    }
    
    public void desenhar(Tela t){
    	//Background
    	t.imagem("ocean.png", 0, 0, 300, 600, 0, 0, 0);
       	t.imagem("ocean.png", 270, 0, 300, 600, 0, 300, 0);
       	
    	for(Obstaculo obstaculo: obstaculos){
    		obstaculo.desenha(t);
    	}
    	
    	//Ground
    	t.imagem("ocean.png", 0, 0, 0, 112, 0, -ground_offset, getAltura()-112);
    	t.imagem("ocean.png", 0, 0, 0, 112, 0, 308 -ground_offset, getAltura()-112);
    	t.imagem("ocean.png", 0, 0, 0, 112, 0, 308*2 -ground_offset, getAltura()-112);
    	
    	
    	
    	navio.desenhar(t);
    	
    }
    
    public static void main(String[] args) {
        roda();
    }

    private static void roda() {
    	new Controller(new OceanFox());
    }
	
	
}
