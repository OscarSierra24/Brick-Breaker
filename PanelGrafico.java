import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelGrafico extends JPanel{
	private Paleta jugador1, jugador2;
	private Pelota p,
				   p2,
				   p3;
	private Ladrillo[][] ladrillos;
	private Ladrillo[][] ladrillos2;
	private Marcador mJugador1,
					 mJugador2;
	private Eventos e;
	private boolean pinta=true;
	public PanelGrafico(){
		this.setPreferredSize(new Dimension(700, 800));
		this.setBackground(Color.white);
		this.setVisible(true);
		this.setFocusable(true);
		this.ladrillos = new Ladrillo[8][3];
		this.ladrillos2=new Ladrillo[8][3];
		for(int j=0; j<3; j++){
			for(int i=0; i<8; i++){
				this.ladrillos[i][j]=new Ladrillo();
				this.ladrillos[i][j].setBounds(70+((int)ladrillos[i][j].getX()*i), 5 +25 *j, 50, 20);
				}
		}
		for(int j2=0; j2<3; j2++){
			for(int i2=0; i2<8; i2++){
				this.ladrillos2[i2][j2]=new Ladrillo();
				this.ladrillos2[i2][j2].setBounds(70+((int)ladrillos2[i2][j2].getX()*i2),780-(5+25*j2) , 50, 20);
				}
		}
	}
	
	//SETTERS
	public void setPaletas(Paleta jugador1, Paleta jugador2){
		this.jugador1=jugador1;
		this.jugador2=jugador2;
	}
	
	public void setPelota(Pelota pelota,int numero){
		if(numero==1){
			this.p=pelota;
		}
		else if(numero==2){
			this.p2=pelota;
		}
		else if(numero==3){
			this.p3=pelota;
		}
	}
	public void setEventos(Eventos e){
		this.e=e;
	}
	public void setMarcadores(Marcador mJugador1, Marcador mJugador2){
		this.mJugador1=mJugador1;
		this.mJugador2=mJugador2;
	}
	
	
	//REVISA SI LAS PELOTAS INTERSECTAN ENTRE SÍ. DE SER ASÍ, CAMBIA SU COLOR A BLANCO
	public void ChoqueDePelotas(){
		if(p.intersects(p2)){
			p.setColorPelota(Color.white);
			p2.setColorPelota(Color.white);
			this.repaint();
		}
		if(p3.intersects(p)){
			p.setColorPelota(Color.white);
			p3.setColorPelota(Color.WHITE);
		}
		if(p3.intersects(p2)){
			p3.setColorPelota(Color.white);
			p2.setColorPelota(Color.white);
		}
	}
	
	//SI LA PELOTA TOCA UN LADRILLO, REBOTA. EL VALOR DE VIVO DEL LADRILLO CAMBIA A "FALSE"
	public void checaChoqueDeLadrillos(){
		for(int i=0; i<3; i++){
			for(int j=0; j<8; j++){
				if(p2.intersects(this.ladrillos[j][i])	|| p.intersects(this.ladrillos[j][i])||p3.intersects(this.ladrillos[j][i])){
					if(this.ladrillos[j][i].getVivo()){
						this.mJugador1.bloqueDestruido();
						if(p.intersects(this.ladrillos[j][i])){
							if(p.getY()<ladrillos[j][i].getY()+ladrillos[j][i].getHeight()){
								p.mueveAbajo();
							}
							else if(p.getY()+p.getHeight()<ladrillos[j][i].getY()){
								p.mueveArriba();
							}
							if(p.getX()+1>=ladrillos[j][i].getX()+ladrillos[j][i].getWidth()){
								p.mueveDerecha();
							}
							else if(p.getX()+p.getWidth()-1<=ladrillos[j][i].getX()){
								p.mueveIzquierda();
							}
						}
							
						if(p2.intersects(this.ladrillos[j][i])){
							if(p2.getY()<ladrillos[j][i].getY()+ladrillos[j][i].getHeight()){
								p2.mueveAbajo();
							}
							else if(p2.getY()+p2.getHeight()<ladrillos[j][i].getY()){
								p2.mueveArriba();
							}
							if(p2.getX()+1>=ladrillos[j][i].getX()+ladrillos[j][i].getWidth()){
								p2.mueveDerecha();
							}
							else if(p2.getX()+p2.getWidth()-1<=ladrillos[j][i].getX()){
								p2.mueveIzquierda();
							}
						}
						if(p3.intersects(this.ladrillos[j][i])){
							if(p3.getY()<ladrillos[j][i].getY()+ladrillos[j][i].getHeight()){
								p3.mueveAbajo();
							}
							else if(p3.getY()+p3.getHeight()<ladrillos[j][i].getY()){
								p3.mueveArriba();
							}
							if(p3.getX()+1>=ladrillos[j][i].getX()+ladrillos[j][i].getWidth()){
								p3.mueveDerecha();
							}
							else if(p3.getX()+p.getWidth()-1<=ladrillos[j][i].getX()){
								p3.mueveIzquierda();
							}
						}
					}
					
					this.ladrillos[j][i].vivo(false);
				}
			}	
		}
		for(int i2=0; i2<3; i2++){
			for(int j2=0; j2<8; j2++){
				if(p2.intersects(this.ladrillos2[j2][i2])	|| p.intersects(this.ladrillos2[j2][i2])||p3.intersects(this.ladrillos2[j2][i2])){
					if(this.ladrillos2[j2][i2].getVivo()){
						this.mJugador2.bloqueDestruido();
						if(p.intersects(this.ladrillos2[j2][i2])){
							if(p.getY()<ladrillos2[j2][i2].getY()+ladrillos[j2][i2].getHeight()){
								p.mueveArriba();
							}
							else if(p.getY()<ladrillos2[j2][i2].getY()+ladrillos2[j2][i2].getHeight()){
								p.mueveAbajo();
							}
							if(p.getX()+1>=ladrillos2[j2][i2].getX()+ladrillos2[j2][i2].getWidth()){
								p.mueveDerecha();
							}
							else if(p.getX()+p.getWidth()-1<=ladrillos2[j2][i2].getX()){
								p.mueveIzquierda();
							}
						}
							
						if(p2.intersects(this.ladrillos2[j2][i2])){
							if(p2.getY()<ladrillos2[j2][i2].getY()+ladrillos2[j2][i2].getHeight()){
								p2.mueveArriba();
							}
							else if(p2.getY()>ladrillos2[j2][i2].getY()+ladrillos2[j2][i2].getHeight()){
								p2.mueveAbajo();
							}
							if(p2.getX()+1>=ladrillos2[j2][i2].getX()+ladrillos2[j2][i2].getWidth()){
								p2.mueveDerecha();
							}
							else if(p2.getX()+p2.getWidth()-1<=ladrillos2[j2][i2].getX()){
								p2.mueveIzquierda();
							}
						}
						if(p3.intersects(this.ladrillos2[j2][i2])){
							if(p3.getY()<ladrillos2[j2][i2].getY()+ladrillos2[j2][i2].getHeight()){
								p3.mueveArriba();
							}
							else if(p3.getY()>ladrillos2[j2][i2].getY()+ladrillos2[j2][i2].getHeight()){
								p3.mueveAbajo();
							}
							if(p3.getX()+1>=ladrillos2[j2][i2].getX()+ladrillos2[j2][i2].getWidth()){
								p3.mueveDerecha();
							}
							else if(p3.getX()+p3.getWidth()-1<=ladrillos2[j2][i2].getX()){
								p3.mueveIzquierda();
							}
						}
					}
					this.ladrillos2[j2][i2].vivo(false);
				}
			}	
		}
		this.repaint();
	}
	
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(this.pinta){
		g.setColor(Color.black);
		g.fillRect(0,0,1000,1000);
		g.setColor(Color.white);
		g.fillRect(0,this.getHeight()/2,this.getWidth(),2);
		g.setFont(new Font("Helvetica",Font.BOLD, 40));
		g.setColor(Color.blue);
		g.drawString(this.mJugador1.getSnum(), 50, (this.getHeight()/2)-100);
		g.setColor(Color.red);
		g.drawString(this.mJugador2.getSnum(), 50, (this.getHeight()/2)+100);
		g.setColor(Color.red);
		g.fillRect((int)this.jugador1.getX(),(int)this.jugador1.getY(), this.jugador1.width, this.jugador1.height);
		g.setColor(Color.blue);
		g.fillRect((int)this.jugador2.getX(),(int)this.jugador2.getY(), this.jugador2.width, this.jugador2.height);
		
		g.setColor(p.getColorPelota());
		g.fillRect((int)p.getX(),(int)p.getY(),(int)p.getWidth(),(int)p.getHeight());
		g.setColor(p2.getColorPelota());
		g.fillRect((int)p2.getX(),(int)p2.getY(),(int)p2.getWidth(),(int)p2.getHeight());
		g.setColor(p3.getColorPelota());
		g.fillRect((int)p3.getX(),(int)p3.getY(),(int)p3.getWidth(),(int)p3.getHeight());
		
		g.setColor(Color.WHITE);
		g.drawRect(35, 270, 80, 40);
		g.drawRect(35, 470, 80, 40);
		g.setFont(new Font("Helvetica",0, 15));
		g.drawString("Bloques por Destruir:", 20, 260);
		g.drawString("Bloques por Destruir:", 20, 460);
		

		this.checaChoqueDeLadrillos();
		for(int j=0; j<3; j++){
			for(int i=0; i<8; i++){
				if(this.ladrillos[i][j].getVivo()){
					g.setColor(new Color(51, 153, 255));
					g.fillRect((int)ladrillos[i][j].getX(), 5 +25 *j, 50, 20);
					g.setColor(Color.WHITE);
					g.drawRect((int)ladrillos[i][j].getX(), 5 +25 *j, 50, 20);
				}
			}
		}
		
		for(int j2=0; j2<3; j2++){
			for(int i2=0; i2<8; i2++){
				if(this.ladrillos2[i2][j2].getVivo()){
					g.setColor(new Color(255, 51, 51));
					g.fillRect((int)ladrillos2[i2][j2].getX(), 780-(5+25*j2), 50, 20);
					g.setColor(Color.WHITE);
					g.drawRect((int)ladrillos2[i2][j2].getX(), 780-(5+25*j2), 50, 20);
					
				}
			}
		}
		if(this.mJugador1.isGanador()	||	this.mJugador2.isGanador()){
			if(this.mJugador1.isGanador()){
				this.pinta=false;
			}
			else if(this.mJugador2.isGanador()){
				this.pinta=false;
			}
		}
		
		
		this.actualizar();		
		}
		else{
			g.setFont(new Font("Helvetica",Font.BOLD,30));
			if(this.mJugador1.isGanador()){
				g.setColor(Color.black);
				g.fillRect(0, 0, 1000, 1000);

				g.setColor(Color.white);
				g.drawString("Pulsa espacio para volver a jugar", (this.getWidth()/3)-100, (this.getHeight()/2)+100);
				g.setColor(Color.red);
				g.drawString("¡Gana Jugador rojo!", this.getWidth()/3, (this.getHeight()/2));
			}
			if(this.mJugador2.isGanador()){
				g.setColor(Color.black);
				g.fillRect(0, 0, 1000, 1000);
				g.setColor(Color.white);
				g.drawString("Pulsa espacio para volver a jugar", (this.getWidth()/3)-100, (this.getHeight()/2)+100);
				g.setColor(Color.blue);
				g.drawString("¡Gana Jugador azul!", this.getWidth()/3, (this.getHeight()/2));
			}
			if(this.pinta==false){
				if(this.e.getRestart()){
					this.removeAll();
					this.reinicio();
					this.pinta=true;
					this.e.setRestart(false);
				}
			}
		}
	}
	public void reinicio(){
		p.reinicio(1);
		p2.reinicio(2);
		p3.reinicio(3);
		this.jugador1.reinicio(1);
		this.jugador2.reinicio(2);
		this.restartLadrillo();
		this.mJugador1.restart();
		this.mJugador2.restart();
	}
	
	public void restartLadrillo(){
		for(int j2=0; j2<3; j2++){
			for(int i2=0; i2<8; i2++){
				this.ladrillos2[i2][j2].vivo(true);
				this.ladrillos[i2][j2].vivo(true);
			}
		}
	}
	
	public void actualizar(){
		this.jugador1.mueveJugador1();
		this.jugador2.mueveJugador2();
	}
}
