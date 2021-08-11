public class Nodo{
	private int num;
	private Nodo izq;
	private Nodo der;
	private Nodo padre;
	public Nodo(int num){
		this.num = num;
	}
	public Nodo(Nodo padre,int num){
		this.padre = padre;
		this.num = num;
	}
	public Nodo(Nodo padre,int num, Nodo izq, Nodo der){
		this.padre = padre;
		this.num = num;
		this.izq = izq;
		this.der = der;
	}
	public Nodo getPadre(){
		return this.padre;
	}
	public void setPadre(Nodo padre){
		this.padre = padre;
	}
	public int getNum(){
		return this.num;
	}
	public void setNum(int num){
		this.num = num;
	}
	public Nodo getIzq(){
		return this.izq;
	}
	public void setizq(Nodo izq){
		this.izq = izq;
	}
	public Nodo getDer(){
		return this.der;
	}
	public void setder(Nodo der){
		this.der = der;
	}
	public boolean esHoja(){
		if(izq==null && der==null) return true;
		else return false;
	}
	public boolean esRaiz(){
		if(this.padre==null) return true;
		else return false;
	}
	public void insertar(int num){
	
	}
}