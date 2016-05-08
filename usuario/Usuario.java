package usuario;

import java.util.*;
import java.io.*;

public class Usuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void gravarDadosClientes(){
		try {
			File file = new File("database/clientes.txt");
			if(!file.exists()){
				file.createNewFile();
			}
			
			BufferedReader reader = new BufferedReader(new FileReader("database/clientes.txt"));
			
			int i = 1;
			
			while(true){
				String linha = reader.readLine();
				if(linha == null){
					break;
				}
			}
			
		} catch (Exception e) {
			
		}
	}

}
