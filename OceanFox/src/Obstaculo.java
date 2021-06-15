//obstaculo está implementando o Cano do FlappyBird
public class Obstaculo {
	public double x,y;
	public double vxrock;
	public static int HOLESIZE = 120;
	public Hitbox boxcima;
	public Hitbox boxbaixo;
	
	public Obstaculo(double x, double y, double vx){
		this.x = x;
		this.y = y;
		this.vxrock = vx;
		
		boxcima = new Hitbox(x,y-270,x+52,y);
		boxbaixo = new Hitbox(x, y+Obstaculo.HOLESIZE, x+52, y+Obstaculo.HOLESIZE+242);
	}
	
	public void atualiza(double dt){
		x += vxrock*dt;
		boxcima.mover(vxrock*dt, 0);
		boxbaixo.mover(vxrock*dt, 0);
	}
	
	public void desenha(Tela t){
		t.imagem("ocean.png", 400, 10, 80, 80, 0, x, y-270); //cano de cima
		t.imagem("ocean.png", 400, 10, 80, 80, 0, x, y+Obstaculo.HOLESIZE); //cano de baixo
	}
	
}
