import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static Usuario usuario;
	public static void main(String[] args) {
		try {
			inicio();
		} catch(Exception exception) {
			System.out.println(exception.getClass().getSimpleName() + exception.getMessage());
			if (exception instanceof ExceptionMinoria) {
				System.exit(0);
			} else {
				jogo();
			}
		}
		
	}

	private static void inicio() {
		System.out.println("Bem vindo ao Jogo de Canibais e Missionários"
				+ "\n - - - Vamos Começar - - - ");
		System.out.println("Digite seu nome: ");
		usuario = new Usuario(sc.next());
		usuario.add();
		
 		System.out.println("Instruções de jogo"
 				+ "\nSelecione um tipo de ação para ser realizada, o objetivo é trazer todos"
 				+ " para o outro lado,\ncaso deixe dois ou mais canibais com um missionario"
 				+ " eles comeram o mesmo e o jogo acaba!");
 		System.out.println("Digite o número 1 para Começar o Jogo");
 		if(sc.nextInt() > -1) {
 			jogo();
 		}
	}

	public static void jogo() {
		System.out.println(" - - - Menu - - -"
 				+ "\n1 - Colocar um Missionario no barco"
 				+ "\n2 - Colocar um Canibal no barco"
 				+ "\n3 - Tirar um Missionario do barco"
 				+ "\n4 - Tirar um Canibal do barco"
 				+ "\n5 - Mover Barco");
 		int acao = sc.nextInt();
 		
 		switch(acao) {
 		case 1:
 			usuario.colocar(1);
 			break;
 		case 2:
 			usuario.colocar(2);
 			break;
 		case 3:
 			usuario.tirar(1);
 			break;
 		case 4:
 			usuario.tirar(2);
 			break;
 		case 5:
 			usuario.Mover();
 			break;
 		}
	}
}
