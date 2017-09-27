
public class Marcador {
	private String snum;
	private int num;
	
	public Marcador(){
		this.snum="24";
		this.num=24;
	}
	public void bloqueDestruido(){
		this.num-=1;
		this.snum=(""+this.num);
	}
	
	public String getSnum(){
		return this.snum;
	}
	
	public int getNum(){
		return this.num;
	}
	
	public boolean isGanador(){
		if(this.num==0){
			return true;	
		}
		else{
			return false;
		}
	}
	public void restart(){
		this.snum="24";
		this.num=24;
	}
}
