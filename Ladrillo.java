import java.awt.Rectangle;

public class Ladrillo extends Rectangle{
	
	private boolean vivo;
	
	public Ladrillo(){
		this.vivo = true;
		this.setBounds(70, 0, 20, 50);
	}
	
	public void vivo(boolean vivo){
		this.vivo = vivo;
	}
	public boolean getVivo(){
		return this.vivo;
	}
	
}
