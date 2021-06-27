import java.util.ArrayList;
import java.util.Random;

public class OceanFox implements Jogo {

	
	public Navio navio;
	public Baleia baleia;
	public Arpao arpao;
	public WinLoseGame winlosegame;
	
	public ArrayList<Obstaculo> obstaculos = new ArrayList<Obstaculo>();
	public Random random = new Random();
	public Timer timer_bomba;
	
	public OceanFox(){
		 navio = new Navio(150,(getLargura()-100)/2 + 50/2); 
		 winlosegame = new WinLoseGame(150,150); 
		 baleia = new Baleia(getLargura()/2,getAltura()/2);
		 arpao = new Arpao(150,(getLargura()-100)/2 + 50/2);
		 timer_bomba = new Timer(3, true, addBomba());
		 addBomba().executa();
	}
	
	private Acao addBomba(){
        return new Acao(){
          public void executa(){
        	  obstaculos.add(new Obstaculo(getLargura()+10, random.nextInt(getAltura()-232), -50));
          }
        };
      }
	
	public String getTitulo(){
		return "Ocean-Fox";
	}
	public int getLargura(){
		return 600;
	}
    public int getAltura(){
    	return 500;
    }

    public void tecla(String tecla){
    	if(tecla.equals("w")){
    		navio.yPositivo();
    		arpao.yPositivo();
    		baleia.y();
    	}
    	else if(tecla.equals("s")){
    		navio.yNegativo();
    		arpao.yNegativo();
    		baleia.y();
    	}
    	else if(tecla.equals("d")){
    		navio.xPositivo();
    		arpao.xPositivo();
    		baleia.y();
    	}
    	else if(tecla.equals("a")){
    		navio.xNegativo();
    		arpao.xNegativo();
    		baleia.y();
    	}
    	else if(tecla.equals(" ")){
    		navio.stop();
    		arpao.stop();
    		baleia.stop();
    	}
    	else if(tecla.equals("t")){
    		arpao.ataque();
    		baleia.stop();
    		navio.stop();
    	}
    }
    
    //todas as dependências do tempo
    public void tique(java.util.Set<String> teclas, double dt){
    	
    	timer_bomba.eachFrame(dt);
    	navio.atualiza(dt);
    	baleia.atualiza(dt);
    	arpao.atualiza(dt);
    	if(navio.y>=getAltura()){
    	    System.out.println("FIM - LIMITE TELA");
    	    winlosegame.fim();
     	} else if(navio.y <= 0){
    		System.out.println("FIM - LIMITE TELA");
    	} else if (navio.x==baleia.x) {
    		System.out.println("FIM - CAPTURA");//colocar imagem
    	}
    	for(Obstaculo obstaculo: obstaculos){
    		obstaculo.atualiza(dt);
    		if(navio.bomba.colisaoBomba(obstaculo.boxcima)!=0 || navio.bomba.colisaoBomba(obstaculo.boxbaixo)!=0){
    			System.out.println("FIM - COLISÃO");
    		}
    		
    	}	
    	
    }
    
    public void desenhar(Tela t){
    	//Background
    	t.imagem("ocean.png", 0, 0, 500, 800, 0,  0 ,0 );
    	t.imagem("ocean.png", 0, 0, 500, 800, 0,330 ,0 );
     	
    	
    	for(Obstaculo obstaculo: obstaculos){
    		obstaculo.desenha(t);
    	}
    
        	
    	navio.desenhar(t);
    	baleia.desenhar(t);
    	arpao.desenhar(t);
    	
    }
    
    public static void main(String[] args) {
        roda();
    }

    private static void roda() {
    	new Controller(new OceanFox());
    }
	
}
