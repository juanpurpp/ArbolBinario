import java.util.Scanner;
public class Arbol{
	public static Scanner in = new Scanner(System.in);
	public static Nodo raiz;
	public static void main(String[] args) {
		//ingresar arbol
		System.out.println("Ingrese el arbol");
		String arbol=in.nextLine();
		int[] numeros =new int[arbol.split("-").length];
		for(int i = 0; i < numeros.length; i++){
			numeros[i] = Integer.parseInt(arbol.split("-")[i]);
		}
		System.out.println("la raiz es " + numeros[0]);
		//for(int mostrar:numeros) System.out.println(mostrar);
		for(int i = 0; i < numeros.length; i++){
			if(i==0) raiz = new Nodo(numeros[0]);
			else raiz.insertar(numeros[i]);
		}
		System.out.println("insertados");
		System.out.println("Anchura de"+raiz.num);
		System.out.println("Su anchura es "+raiz.anchura());
		System.out.println("Su altura es "+raiz.altura());
		System.out.println("Sus hojas son "+raiz.hojas());
		System.out.println("inorder es  "+raiz.inorder());
		System.out.println("preorder es  "+raiz.preorder());
		System.out.println("postorder es  "+raiz.postorder());
		/*
		for(int i = 0; i < numeros.length; i++){
			raiz.insertar(numeros[i]);
		}*/
	}
}