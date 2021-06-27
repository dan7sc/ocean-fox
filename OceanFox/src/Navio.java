
public class Navio {

	public double x,y;
	public double vy,vx = 0;
		
	public static double G = 10;
	public static double VELOCIDADE = -200;
	
	public NavioPirata bomba;
	
	public Navio(double x, double y){
		this.x = x;
		this.y = y;
		this.bomba = new NavioPirata(x,y, x+34, y+24);
	}
	
	//física do Navio -> variação com o tempo
	
	public void atualiza(double dt){ //atualiza conforme a variação de tempo
		vy += dt;
		vx += dt;
		y += vy*dt;
		x += vx*dt;
		bomba.mover(0, vy*dt); //movimentaão do plano de fundo

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

	
	public void desenhar(Tela t){
		t.imagem("ocean.png", 615, 268,75,25, 0, x, y);
		
	}
	
}
