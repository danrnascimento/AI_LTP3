package dados;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Venda {
	
	private int numVenda;
	private Cliente cliente;
	private GregorianCalendar dataVenda;
	private ArrayList<ItemVenda> vendaItem;
	
	
	private static int  ultimaVenda = 0;
	
	public Venda(Cliente cliente){
		ultimaVenda++;
		this.numVenda = ultimaVenda;
		this.cliente = cliente;
	}

	public int getNumVenda() {
		return numVenda;
	}

	public void setNumVenda(int numVenda) {
		this.numVenda = numVenda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public GregorianCalendar getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(GregorianCalendar dataVenda) {
		this.dataVenda = dataVenda;
	}

	public ArrayList<ItemVenda> getVendaItem() {
		return vendaItem;
	}

	public void setVendaItem(ArrayList<ItemVenda> vendaItem) {
		this.vendaItem = vendaItem;
	}

	public static int getUltimaVenda() {
		return ultimaVenda;
	}

	public static void setUltimaVenda(int ultimaVenda) {
		Venda.ultimaVenda = ultimaVenda;
	}
	
	

}
