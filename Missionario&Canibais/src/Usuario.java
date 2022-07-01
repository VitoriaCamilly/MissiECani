import java.util.ArrayList;

public class Usuario {
	private String nome;
	private int local = 1, barco = 0;
	 ArrayList<Missionario> listaMissionarios = new ArrayList<Missionario>();
	 ArrayList<Canibais> listaCanibais = new ArrayList<Canibais>();
	
	public Usuario() {
		
	}
	
	public void add() {
		for(int i = 0; i < 3; i++) {
			Missionario missionario = new Missionario();
			Canibais canibal = new Canibais();
			listaCanibais.add(canibal);
			listaMissionarios.add(missionario);
		}
	}
	
	public void colocar(int tipo) {
		int i = 0, contador2 = 3;
		if(barco >= 2) {
			throw new ExceptionCheio();
		}
		if(tipo == 1) {
			for(i = 0; i < 3; i ++) {
				if(local == 1) {
					if(listaMissionarios.get(i).getLado() == 1) {
						contador2 = 0;
						listaMissionarios.get(i).setLado(2);
						barco ++;
						Main.jogo();
					}
				}else if(local == 2){
					if(listaMissionarios.get(i).getLado() == 3) {
						contador2 = 0;
						listaMissionarios.get(i).setLado(2);
						barco ++;
						Main.jogo();
					}
				}
				
			}
		}else {
			for(i = 0; i < 3; i ++) {
				if(local == 1) {
					if(listaCanibais.get(i).getLado() == 1) {
						contador2 = 0;
						listaCanibais.get(i).setLado(2);
						barco ++;
						Main.jogo();
					}
				}else if(local == 2){
					if(listaCanibais.get(i).getLado() == 3) {
						contador2 = 0;
						listaCanibais.get(i).setLado(2);
						barco ++;
						Main.jogo();
					}
				}
				
			}
		}
		
		if(contador2 == 3) {
			throw new ExceptionNaoTemParaMover();
		}
	}
	
	public void tirar(int tipo) {
		int i = 0, contador2 = 3;
		if(barco == 0) {
			throw new ExceptionNaoTemParaMover();
		}
		if(tipo == 1) {
			for(i = 0; i < 3; i ++) {
				if(local == 1) {
					if(listaMissionarios.get(i).getLado() == 2) {
						contador2 = 0;
						listaMissionarios.get(i).setLado(1);
						barco --;
						Main.jogo();
					}
				}else if(local == 2){
					if(listaMissionarios.get(i).getLado() == 2) {
						contador2 = 0;
						listaMissionarios.get(i).setLado(3);
						barco --;
						Main.jogo();
					}
				}
				
			}
		}else {
			for(i = 0; i < 3; i ++) {
				if(local == 1) {
					if(listaCanibais.get(i).getLado() == 2) {
						contador2 = 0;
						listaCanibais.get(i).setLado(1);
						barco --;
						Main.jogo();
					}
				}else if(local == 2){
					if(listaCanibais.get(i).getLado() == 2) {
						contador2 = 0;
						listaCanibais.get(i).setLado(3);
						barco --;
						int venceu = venceu();
						if (venceu == 6) {
							System.out.println("Parabéns, você venceu!");
							System.exit(0);
						}
						Main.jogo();
					}
				}
				
			}
			
		}
		if(contador2 == 3) {
			throw new ExceptionNaoTemParaMover();
		}
		
	}
	
	public void Mover() {
		int contadorM = 0, contadorC = 0, contadorM1 = 0, contadorC1 = 0;
		if(barco == 0) {
			throw new ExceptionMoverSemNinguem();
			//não tem pra mover
		}
		if(local == 1) {
			local ++;
		}else {
			local --;
		}
		for(int i = 0; i < 3; i ++) {
			if(listaMissionarios.get(i).getLado() == 2) {
				contadorM ++;
			}
			if(listaCanibais.get(i).getLado() == 2) {
				contadorC ++;
			}
		}
		
		if(local == 1) {
			for(int i = 0; i < 3; i ++) {
				if(listaMissionarios.get(i).getLado() == 1) {
					contadorM ++;
				}else if(listaCanibais.get(i).getLado() == 1) {
					contadorC ++;
				}
			}
			if(contadorC > contadorM && contadorM != 0) {
				System.out.println("Perdeu La 1");
				throw new ExceptionMinoria();
			}else if(contadorM == 1 && contadorC == 0) {
				throw new ExceptionMinoria();
			}
			
		}else {
			for(int i = 0; i < 3; i ++) {
				if(listaMissionarios.get(i).getLado() == 3) {
					contadorM ++;
				}else if(listaCanibais.get(i).getLado() == 3) {
					contadorC ++;
				}
			}
			if(contadorC > contadorM && contadorM != 0) {
				System.out.println("Perdeu La 2");
				throw new ExceptionMinoria();
			}else if(contadorM == 1 && contadorC == 0) {
				throw new ExceptionMinoria();
			}
		}
		
		if(local == 1) {
			for(int i = 0; i < 3; i ++) {
				if(listaMissionarios.get(i).getLado() == 3) {
					contadorM1 ++;
				}else if(listaCanibais.get(i).getLado() == 3) {
					contadorC1 ++;
				}
			}
			if(contadorC1 > contadorM1 && contadorM1 != 0) {
				System.out.println("Perdeu Aqui 1");
				throw new ExceptionMinoria();
			}else if(contadorM == 1 && contadorC == 0) {
				throw new ExceptionMinoria();
			}
		}else {
			for(int i = 0; i < 3; i ++) {
				if(listaMissionarios.get(i).getLado() == 1) {
					contadorM1 ++;
				}else if(listaCanibais.get(i).getLado() == 1) {
					contadorC1 ++;
				}
			}
			if(contadorC1 > contadorM1 && contadorM1 != 0) {
				System.out.println("Perdeu Aqui 2");
				throw new ExceptionMinoria();
			}else if(contadorM == 1 && contadorC == 0) {
				throw new ExceptionMinoria();
			}
		}
		Main.jogo();
	}
	
	public int venceu() {
		int soma = 0;
		for(int i = 0; i < 3; i++) {
			if(listaMissionarios.get(i).getLado() == 3) {
				soma++;
			}
			if(listaCanibais.get(i).getLado() == 3) {
				soma++;
			}
		}
		return soma;
	}

	public Usuario(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
