import java.util.Arrays;
import java.lang.Math;

public class Nodo{
	public int num;
	public Nodo izq;
	public Nodo der;
	public Nodo padre;
	public Nodo(){	
	}
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
	public void setIzq(Nodo izq){
		this.izq = izq;
	}
	public Nodo getDer(){
		return this.der;
	}
	public void setDer(Nodo der){
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
		if(this.izq== null && this.der == null){
			if(num<=this.num) this.izq = new Nodo(this,num);
			else this.der =new Nodo(this,num);
		}
		else if(this.izq != null && this.der == null){
			if(num>this.num) this.der =new Nodo(this,num);
			else izq.insertar(num);
		}
		else if(this.izq == null && this.der != null){
			if(num<=this.num) this.izq =new Nodo(this,num);
			else der.insertar(num);
		}
		else if(this.izq != null && this.der != null){
			if(num<=this.num) izq.insertar(num);
			else der.insertar(num);
		}
	}
	public String inorder(){
		String r = "";
		//metodo de disección creado por juan
		//diseccionar a la izquierda
		if(this.izq != null) r+=this.izq.inorder();
		r+= this.num+"_";
		if(this.der != null) r+=this.der.inorder();
		//disecionar al a derecha
		return r;
	}
	public String preorder(){
		String r = "";
		r+= this.num+"_";
		if(this.izq != null) r+=this.izq.preorder();
		if(this.der != null) r+=this.der.preorder();
		return r;
	}
	public String postorder(){
		String r = "";
		if(this.izq != null) r+=this.izq.postorder();
		if(this.der != null) r+=this.der.postorder();
		r+= this.num+"_";
		return r;
	}
	public String anchura(){
		int niveles = 0;
		Nodo[][] pisos = new Nodo[niveles+1][];
		pisos[niveles] = new Nodo[(int)Math.pow(2,niveles)];
		boolean seguir = true;
		pisos[0][0] = this;
		while(seguir){
			niveles++;
			pisos = Arrays.copyOf(pisos,niveles+1);
			pisos[niveles] = new Nodo[(int)Math.pow(2,niveles)];
			int pasos = 0;
			for(Nodo item: pisos[niveles-1]){
				if(item!=null){
					if(item.izq != null){
						//System.out.println("pasos es "+pasos+" cuando item.izq es "+ item.izq.num);
						pisos[niveles][pasos] = item.izq;
						pasos++;
					}
					if(item.der != null){
						//System.out.println("pasos es "+pasos+" cuando item.izq es "+ item.der.num);
						pisos[niveles][pasos] = item.der;
						pasos++;
					}
				}
			}
			seguir = false;
			for(Nodo ultimos:pisos[niveles]){
				if(ultimos != null){
					if(!ultimos.esHoja()) seguir = true;
				}
			}
		}
		String r = "";
		for(Nodo[] d1:pisos){
			for(Nodo d2: d1){
				if(d2 != null) r+=d2.num+"_";
			}
		}
		return r;
	}
	public int altura(){
		int niveles = 0;
		Nodo[][] pisos = new Nodo[niveles+1][];
		pisos[niveles] = new Nodo[(int)Math.pow(2,niveles)];
		boolean seguir = true;
		pisos[0][0] = this;
		while(seguir){
			niveles++;
			pisos = Arrays.copyOf(pisos,niveles+1);
			pisos[niveles] = new Nodo[(int)Math.pow(2,niveles)];
			int pasos = 0;
			for(Nodo item: pisos[niveles-1]){
				if(item!=null){
					if(item.izq != null){	
						pisos[niveles][pasos] = item.izq;
						pasos++;
					}
					if(item.der != null){
						pisos[niveles][pasos] = item.der;
						pasos++;
					}
				}
			}
			seguir = false;
			for(Nodo ultimos:pisos[niveles]){
				if(ultimos != null){
					if(!ultimos.esHoja()) seguir = true;
				}
			}
		}
		return niveles+1;
	}
	public String hojas(){
		int niveles = 0;
		Nodo[][] pisos = new Nodo[niveles+1][];
		pisos[niveles] = new Nodo[(int)Math.pow(2,niveles)];
		boolean seguir = true;
		pisos[0][0] = this;
		while(seguir){
			niveles++;
			pisos = Arrays.copyOf(pisos,niveles+1);
			pisos[niveles] = new Nodo[(int)Math.pow(2,niveles)];
			int pasos = 0;
			for(Nodo item: pisos[niveles-1]){
				if(item!=null){
					if(item.izq != null){
						//System.out.println("izq: "+ item.izq.num);
						pisos[niveles][pasos] = item.izq;
						pasos++;
					}
					if(item.der != null){
						//System.out.println("der: "+ item.der.num);
						pisos[niveles][pasos] = item.der;
						pasos++;
					}
				}
			}
			seguir = false;
			for(Nodo ultimos:pisos[niveles]){
				if(ultimos != null){
					if(!ultimos.esHoja()) seguir = true;
				}
			}
		}
		String r = "";
		for(Nodo[] d1:pisos){
			for(Nodo d2: d1){
				if(d2 != null && d2.esHoja()) r+=d2.num+"_";
			}
		}
		//ordenamos las hojas de
		int i = 0;
		Nodo orden=null;
		for(String ord: r.split("_")){
			if(i==0) orden = new Nodo(Integer.parseInt(ord));
			else orden.insertar(Integer.parseInt(ord));
			i++;
		}

		return orden.inorder();
	}
	public void eliminar(int num){
		if(this.num == num){
			if(this.izq != null){
				this.num = this.izq.num;
				if(this.izq.der != null)this.der=this.izq.der;
				else this.der = null;
				if(this.izq.izq != null) this.izq=this.izq.izq;
				else this.izq = null;
			}
			else if(this.der!=null){
				this.num = this.der.num;
				if(this.der.izq != null) this.izq=this.der.izq;
				else this.izq = null;
				if(this.der.der != null)this.der=this.der.der;
				else this.der = null;
			}
			return;
		}
		else if(this.izq!=null)
			if(this.izq.num == num && this.izq.esHoja()) this.izq = null;
			else if(num<=this.num) this.izq.eliminar(num);
		else if(this.der!=null)
			if(this.der.num == num && this.der.esHoja()) this.der = null;
			else if(num>this.num) this.der.eliminar(num);
	}
}


/*
int niveles = 0;
		Nodo aux = this;
		Nodo[][] pisos = new Nodo[niveles+1][(int)Math.pow(2,niveles)];
		pisos[0][0] = aux;
		boolean seguir = true;
		while(seguir){
			niveles++;
			pisos= Arrays.copyOf(pisos, niveles+1);
			pisos[niveles] = new Nodo[(int)Math.pow(2,niveles)];
			int pasos = 0;
			for(int i = 0; i < pisos[niveles-1].length; i++){
				pisos[niveles][pasos] = pisos[niveles-1][i].izq;
				pasos++;
				pisos[niveles][pasos] = pisos[niveles-1][i].der;
				pasos++;
			}
			for()
		}
*/