import java.awt.Rectangle;
public class Paleta extends Rectangle{
	private int x,y,posicionX,posicionY;
	private PanelGrafico pg;
	private Eventos e;
	
	public Paleta(int numero, PanelGrafico pg){
		super();
		this.pg=pg;
		this.x=100;
		this.y=20;
		
		if(numero==1){	
			this.posicionX=((pg.getWidth()/2)-(this.x/2));
			this.posicionY=pg.getHeight()-140-30;
			this.setBounds(this.posicionX, this.posicionY, this.x, this.y);
		}
		else if(numero==2){
			this.posicionX=((pg.getWidth()/2)-(this.x/2));
			this.posicionY=140+30;
			this.setBounds(this.posicionX, this.posicionY, this.x, this.y);
		}
	}
	
	public void setEventos(Eventos e){
		this.e=e;
	}
	
	public int getPosicionX(){
		return this.posicionX;
	}
	public int getPosicionY(){
		return this.posicionY;
	}
	public int getLargo(){
		return this.y;
	}
	
	public void actualiza(){
		this.setBounds(this.posicionX, this.posicionY, this.x, this.y);
		this.pg.repaint();
	}
	
	public void reinicio(int numero){
		if(numero==1){	
			this.posicionX=((pg.getWidth()/2)-(this.x/2));
			this.posicionY=pg.getHeight()-140-30;
			this.setBounds(this.posicionX, this.posicionY, this.x, this.y);
		}
		else if(numero==2){
			this.posicionX=((pg.getWidth()/2)-(this.x/2));
			this.posicionY=140+30;
			this.setBounds(this.posicionX, this.posicionY, this.x, this.y);
		}
	}
	public void mueveJugador1(){
		if(e.getDer()&&this.getPosicionX()<=(pg.getWidth()-130)){
			this.posicionX+=1;
			this.actualiza();
		}
		if(e.getIzq()&&this.getPosicionX()>=30){
			this.posicionX-=1;
			this.actualiza();
		}
	}
	
	public void mueveJugador2(){
		if(e.getD()&&this.getPosicionX()<=(pg.getWidth()-130)){
			this.posicionX+=1;
			this.actualiza();
		}
		if(e.getA()&&this.getPosicionX()>=30){
			this.posicionX-=1;
			this.actualiza();
		}
	}
	
	
}
