

public class WinLoseGame {
	public double x,y;
	public double vy = 0;
	public double vx=0;
	
	public WinLoseGame(double x, double y){
		this.x = x;
		this.y = y;
	}
		
	public void atualiza(double dt){ //atualiza conforme a variação de tempo
		y = vy;
		x = vx;
	}
	
	public void fim(){
		vy = 150;
		vx = 150;
	}
	
	public void desenhar(Tela t){
		t.imagem("ocean.png", 495, 10, 175,145, 0,x ,y);
	}
}
