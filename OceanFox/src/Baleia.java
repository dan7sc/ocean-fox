import java.util.Random;
public class Baleia {
	public double x,y;
	public double vy = 0;
	public double vx=0;
	
	Random random = new Random();
	
	public Baleia(double x, double y){
		this.x = x;
		this.y = y;
		
	}
		
	public void atualiza(double dt){ //atualiza conforme a variação de tempo
		vy += dt;
		vx += dt;
		y = vy;
		x = vx;
	}
	
	public void y(){
		vy = random.nextInt(100)-100;
		vx = random.nextInt(100)-100;
	}
	
	
	public void stop(){
		vy = 0;
		vx = 0;
	}
		
	
	public void desenhar(Tela t){
		t.imagem("ocean.png", 625, 140, 75,45, 0, x, y);
	}
}
