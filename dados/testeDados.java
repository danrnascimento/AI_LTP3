package dados;

public class testeDados {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cliente cliente = new Cliente("11087177642", "Daniel Rocha do Nascimento");
		System.out.println(cliente.toString());
		
		System.out.println("\n\n");
		
		Produto produto = new Produto("Pao", 2.00);
		Produto produto2 = new Produto("Pao2", 10.00);
		System.out.println(produto.toString());
		System.out.println("\n");
		System.out.println(produto2.toString());
		
		System.out.println("\n\n");
		
	}

}
