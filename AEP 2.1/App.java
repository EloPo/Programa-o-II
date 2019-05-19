package pessoa;

public class App {
	public static void main(String[] args) {
		Júridica j1 = new Júridica("Arthur", "123", 12.01);
		Júridica j2 = new Júridica("Hise", "123", 13.1);
		

		j1.adicionarSócio(j1,10.0);
		j1.adicionarSócio(j2,11.0);
		
		j1.listarSocios();
	
	}
}


