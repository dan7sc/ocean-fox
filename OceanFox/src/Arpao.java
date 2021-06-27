public class Arpao {
	public double x,y;
	public double vy,vx = 0;
		
	public static double G = 10;
	public static double VELOCIDADE = -200;
	
	public NavioPirata bomba;
	
	public Arpao(double x, double y){
		this.x = x;
		this.y = y;
		
	}	
	
	public void atualiza(double dt){ 
		vy += dt;
		vx += dt;
		y += vy*dt;
		x += vx*dt;
		
	}
	
	public void yPositivo(){
		vy = VELOCIDADE;
		vx = 0;
	}
	
	public void yNegativo(){
		vy = -VELOCIDADE;
		vx = 0;
	}
	public void xPositivo(){
		vy = 0;
		vx = -VELOCIDADE;
	}
	public void xNegativo(){
		vy = 0;
		vx = VELOCIDADE;
	}
	public void stop(){
		vy = 0;
		vx = 0;
	}
	public void ataque(){
		vy = 0;
		vx = -2*VELOCIDADE;
	}
		
	
	public void desenhar(Tela t){
		
		t.imagem("ocean.png", 690, 268,50,15, 0, x+75, y);
	}
	
}
