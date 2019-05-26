package pessoa;

public class App {
	public static void main(String[] args) {
		Juridica arthur = new Juridica("Arthur", "123", 12.01);
		Juridica carlos = new Juridica("Carlos", "123", 13.1);
		Fisica arthur = new Fisica("Arthur", "123", 12.01);
		Fisica carlos = new Fisica("Carlos", "123", 13.1);

		arthur.adicionarSocio(arthur,10.0);
		carlos.adicionarSocio(carlos,11.0);
		
		arthur.listarSocios();
	
	}
}


