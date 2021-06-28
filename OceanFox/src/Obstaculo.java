
public class Obstaculo {
	public double x,y;
	public double vxbomba;

	public NavioPirata superior;
	public NavioPirata inferior;
	
	public Obstaculo(double x, double y, double vx){
		this.x = x;
		this.y = y;
		this.vxbomba = vx;
		
		superior = new NavioPirata(x,y-270,x+52,y);
		inferior = new NavioPirata(x, y+200, x+52, y+362);
	}
	
	public void atualiza(double dt){
		x += vxbomba*dt;
		superior.mover(vxbomba*dt, 0);
		inferior.mover(vxbomba*dt, 0);
	}
	
	public void desenha(Tela t){
		t.imagem("ocean.png", 635, 210, 70,45, 0, x, y-270); //cano de cima
		t.imagem("ocean.png", 635, 210, 70,45, 0, x, y+120); //cano de baixo
	
	}
	
}
