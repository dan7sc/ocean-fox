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
		//vy += dt;
		//vx += dt;
		//y += vy*dt;
		//x += vx*dt;
		//vy += dt;
		//vx += dt;
		y = vy;
		x = vx;
	}
	
	public void y(){
		vy = random.nextInt(500)-50;
		vx = random.nextInt(500)-50;
	}
	
	
	
	public void desenhar(Tela t){
		t.imagem("ocean.png", 625, 140, 75,45, 0, x, y);
	}
}
