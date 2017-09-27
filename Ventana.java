import javax.swing.JFrame;

public class Ventana extends JFrame{
	private PanelGrafico pg;
	private Paleta jugador1,
				   jugador2;
	private Eventos e;
	private Pelota p,
				   p2,
				   p3;
	private Marcador mJugador1,
					 mJugador2;
	public Ventana(){
		super("Brick Breaker");
		
		this.pg=new PanelGrafico();
		this.add(pg);
		this.pack();
		
		this.jugador1=new Paleta(1,this.pg);
		this.jugador2=new Paleta(2,this.pg);
		this.pg.setPaletas(this.jugador1,this.jugador2);
		
		this.p=new Pelota(this.pg, this.jugador1,this.jugador2, 1);
		this.p2=new Pelota(this.pg, this.jugador1,this.jugador2, 2);
		this.p3=new Pelota(this.pg,this.jugador1,this.jugador2,3);
		
		
		this.pg.setPelota(this.p,1);
		this.pg.setPelota(this.p2, 2);
		this.pg.setPelota(this.p3, 3);
		
		this.e=new Eventos(this.jugador1,this.jugador2, this.pg);
		this.pg.setEventos(this.e);
		this.pg.addKeyListener(this.e);
		this.jugador1.setEventos(this.e);
		this.jugador2.setEventos(this.e);
		
		this.mJugador1=new Marcador();
		this.mJugador2=new Marcador();
		this.pg.setMarcadores(this.mJugador1,this.mJugador2);
		
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public static void main(String[] args){
		Ventana v=new Ventana();
	}
}
