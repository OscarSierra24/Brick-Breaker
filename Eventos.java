
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Eventos implements KeyListener{
	private Paleta jugador1,
					jugador2;
	private PanelGrafico pg;
	private boolean izq,der,d,a;
	private boolean restart;
	
	public Eventos(Paleta jugador1,Paleta jugador2, PanelGrafico pg){
		this.restart=false;
		this.pg=pg;
		this.jugador1=jugador1;
		this.jugador2=jugador2;			
	}
	
	public boolean getIzq(){
		return this.izq;
	}
	public boolean getDer(){
		return this.der;
	}
	public boolean getD(){
		return this.d;
	}
	public boolean getA(){
		return this.a;
	}
	public boolean getRestart(){
		return this.restart;
	}
	public void setRestart(boolean restart){
		this.restart=restart;
	}
	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			this.restart=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			this.izq=true;
			this.jugador1.mueveJugador1();
			pg.repaint();
		}
		
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			this.der=true;
			this.jugador1.mueveJugador1();
			pg.repaint();
		}
	
		if(e.getKeyCode()==KeyEvent.VK_D){
			this.d=true;
			Eventos.this.jugador2.mueveJugador2();
			pg.repaint();
		}
		else if(e.getKeyCode()==KeyEvent.VK_A){
			this.a=true;
			Eventos.this.jugador2.mueveJugador2();
			pg.repaint();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			this.izq=false;
			this.jugador1.mueveJugador1();
			pg.repaint();
		}
		
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			this.der=false;
			this.jugador1.mueveJugador1();
			pg.repaint();
		}
	
		if(e.getKeyCode()==KeyEvent.VK_D){
			this.d=false;
			Eventos.this.jugador2.mueveJugador2();
			pg.repaint();
		}
		else if(e.getKeyCode()==KeyEvent.VK_A){
			this.a=false;
			Eventos.this.jugador2.mueveJugador2();
			pg.repaint();
		}
		
	}
}