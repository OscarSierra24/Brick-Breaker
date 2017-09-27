import java.awt.Color;
import java.awt.Rectangle;

public class Pelota extends Rectangle implements Runnable{
	private int x,y,widht,height;
	private Color colorPelota,
				  colorFondo;
	private int orientacionX,
				orientacionY;
	private PanelGrafico pg;
	private Paleta jugador1,jugador2;
	private Thread a;
	private boolean inicio;
	
	public Pelota(PanelGrafico pg, Paleta jugador1, Paleta jugador2, int numero){
		super();
		this.inicio=true;
		this.pg=pg;
		if(numero==1){
			this.orientacionX=1;
			this.orientacionY=1;
		}
		else if(numero==2){
			this.orientacionX=-1;
			this.orientacionY=-1;
		}
		else if(numero==3){
			this.orientacionX=-1;
			this.orientacionY=1;
		}
		this.colorPelota=Color.white;
		this.colorFondo=Color.black;
		this.jugador1=jugador1;
		this.jugador2=jugador2;
		
		this.x=pg.getWidth()/2;
		this.y=pg.getHeight()/2;
		this.widht=15;
		this.height=15;
		this.setBounds(this.x,this.y, widht, height);
		
		this.a=new Thread(this);
		this.a.start();
	}
	
	public void actualiza(){
		this.setBounds(this.x,this.y, widht, height);
	}
	
	public Color getColorPelota(){
		return this.colorPelota;
	}
	public void setColorPelota(Color colorPelota){
		this.colorPelota=colorPelota;
	}
	public Color getColorFondo(){
		return this.colorFondo;
	}
	public void reinicio(int numero){
		this.setColorPelota(Color.white);
		if(numero==1){
			this.orientacionX=1;
			this.orientacionY=1;
		}
		else if(numero==2){
			this.orientacionX=-1;
			this.orientacionY=-1;
		}
		else if(numero==3){
			this.orientacionX=-1;
			this.orientacionY=1;
		}
		this.x=pg.getWidth()/2;
		this.y=pg.getHeight()/2;
		this.widht=15;
		this.height=15;
		this.setBounds(this.x,this.y, widht, height);
		this.inicio=true;
	}
	
	//MOVIMIENTO
	public void mueveDerecha(){
		this.orientacionX=1;
	}
	public void mueveIzquierda(){
		this.orientacionX=-1;
	}
	public void mueveArriba(){
		this.orientacionY=-1;
	}
	public void mueveAbajo(){
		this.orientacionY=1;
	}
	public void deten(){
		this.orientacionY=0;
	}
	@Override
	public void run() {
		while(true){
			if(this.inicio){
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				this.inicio=false;
			}
			this.x+=orientacionX;
			this.y+=orientacionY;
			this.actualiza();
			
			//MOVIMIENTO
			if(this.y>=pg.getHeight()-15){
				this.mueveArriba();
			}	
			else if(this.y<=0){
				this.mueveAbajo();
			}
			if(this.x>=pg.getWidth()-15){
				this.mueveIzquierda();
			}
			else if(this.x<=0){
				this.mueveDerecha();
			}
			
			//COLISION JUGADOR1
			if(this.intersects(jugador1)){
//				System.out.println("pelota es:"+(this.getX()));
//				System.out.println("paleta es:"+(this.jugador1.getPosicionX()+this.jugador1.getWidth()));
//				System.out.println("");
				this.colorPelota=Color.red;
				if(this.y+this.height-1<=this.jugador1.getPosicionY()+(this.jugador1.getLargo()/2)){
					this.mueveArriba();
				}
				else if(this.y<this.jugador1.getPosicionY()+this.jugador1.getLargo()){
					this.mueveAbajo();
				}
				if(this.x+15-1==this.jugador1.getPosicionX()){
					this.mueveIzquierda();
				}
				else if(this.x+1==this.jugador1.getPosicionX()+this.jugador1.getWidth()){
					this.mueveDerecha();
				}
				
			}
			
			//COLISION JUGADOR2
			
			if(this.intersects(jugador2)){
				
//				System.out.println("pelota es:"+(this.y+15));
//				System.out.println("paleta es:"+this.jugador2.getPosicionY());
				this.colorPelota=Color.blue;
				if(this.y>this.jugador2.getPosicionY()+(this.jugador2.getLargo())/2){
					this.mueveAbajo();
				}
				else if(this.y+15-1<=this.jugador2.getPosicionY()){
					this.mueveArriba();
				}
				if(this.x+15-1==this.jugador2.getPosicionX()){
					this.mueveIzquierda();
				}
				else if(this.x+1==this.jugador2.getPosicionX()+this.jugador2.getWidth()){
					this.mueveDerecha();
				}
			}
				this.pg.ChoqueDePelotas();
			
			
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			pg.repaint();
		}
	}
	
}
