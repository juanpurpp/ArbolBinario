import java.util.Scanner;
/**
 * Autores: Juan Sandoval
 * 			Sebastian Araus
 * 			Diego Oyarzo
 * Ramo: Estructuras de datos
 * Profesor: Raul Arredondo
 * Larga vida a hamas y la liberacion palestina!!
 */
public class Arbol{
	public static Scanner in = new Scanner(System.in);
	public static Nodo raiz;
	public static void main(String[] args) {
		//ingresar arbol
		System.out.println("Ingrese un arbol inicial de la forma a-b-c-d... (a b c y d son numeros ejemplo 32-43-12-23-23-54)");
		String arbol=in.nextLine();
		int[] numeros =new int[arbol.split("-").length];
		for(int i = 0; i < numeros.length; i++) numeros[i] = Integer.parseInt(arbol.split("-")[i]);
		System.out.println("la raiz es " + numeros[0]);
		//for(int mostrar:numeros) System.out.println(mostrar);
		for(int i = 0; i < numeros.length; i++){
			if(i==0) raiz = new Nodo(numeros[0]);
			else raiz.insertar(numeros[i]);
		}
		boolean terminar = false;
		do{
			System.out.println("Escoja una opcion: ");
			System.out.println("1: Insertar un numero");
			System.out.println("2: Eliminar un numero");
			System.out.println("3: Obtener raiz");
			System.out.println("4: Obtener anchura");
			System.out.println("5: Obtener inorden");
			System.out.println("6: Obtener preorden");
			System.out.println("7: Obtener postorden");
			System.out.println("8: Obtener hojas");
			System.out.println("9: Obtener altura (profundidad)");
			System.out.println("0: Cerrar");
			switch(in.nextLine()){
				case "1":
					System.out.println("Ingrese el numero que quiere insertar");
					raiz.insertar(in.nextInt());
					in.nextLine();
				break;
				case "2":
					System.out.println("Ingrese el numero que desea eliminar");
					raiz.eliminar(in.nextInt());
					in.nextLine();
				break;
				case "3": System.out.println("La raiz es  "+raiz.num);
				break;
				case "4": System.out.println("Su anchura es "+raiz.anchura());
				break;
				case "5": System.out.println("inorder es  "+raiz.inorder());
				break;
				case "6": System.out.println("preorder es  "+raiz.preorder());
				break;
				case "7": System.out.println("postorder es  "+raiz.postorder());
				break;
				case "8": System.out.println("Sus hojas son "+raiz.hojas());
				break;
				case "9": System.out.println("Su altura es "+raiz.altura());
				break;
				case "0": 
					System.out.println("Adios!");		
					terminar = true;
				break;
				default: System.out.println("Ingrese una opción valida");
				break;
			}
			System.out.println("");
		}while(!terminar);
		
		/*
		for(int i = 0; i < numeros.length; i++){
			raiz.insertar(numeros[i]);
		}*/
	}
}