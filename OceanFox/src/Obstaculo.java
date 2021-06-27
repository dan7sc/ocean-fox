
public class Obstaculo {
	public double x,y;
	public double vxrock;

	public NavioPirata boxcima;
	public NavioPirata boxbaixo;
	
	public Obstaculo(double x, double y, double vx){
		this.x = x;
		this.y = y;
		this.vxrock = vx;
		
		boxcima = new NavioPirata(x,y-270,x+52,y);
		boxbaixo = new NavioPirata(x, y+200, x+52, y+120+242);
	}
	
	public void atualiza(double dt){
		x += vxrock*dt;
		boxcima.mover(vxrock*dt, 0);
		boxbaixo.mover(vxrock*dt, 0);
	}
	
	public void desenha(Tela t){
		t.imagem("ocean.png", 635, 210, 70,45, 0, x, y-270); //cano de cima
		t.imagem("ocean.png", 635, 210, 70,45, 0, x, y+120); //cano de baixo
	
	}
	
}
