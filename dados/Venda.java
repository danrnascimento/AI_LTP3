package dados;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import utilitarios.LtpUtil;

public class Venda implements Serializable{
	
	private int numVenda;
	private Cliente cliente;
	private GregorianCalendar dataVenda;
	private ArrayList<ItemVenda> vendaItem;
	
	private int dia = new GregorianCalendar().get(GregorianCalendar.DAY_OF_MONTH);
	private int mes = new GregorianCalendar().get(GregorianCalendar.MONTH);
	private int ano = new GregorianCalendar().get(GregorianCalendar.YEAR);
	
	private static int  ultimaVenda = 0;
	
	public Venda(Cliente cliente, ArrayList<ItemVenda> vendaItem){
		this.numVenda = ++ultimaVenda;
		this.cliente = cliente;
		this.vendaItem = vendaItem;
		this.dataVenda = new GregorianCalendar(ano,mes,dia);
	}

	public int getNumVenda() {
		return numVenda;
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
	
	@Override
	public String toString() {
		return "\nnumVenda = " + numVenda + 
				"\ncliente = " + cliente.getNome() +
				"\ndataVenda = " + LtpUtil.formatarData(dataVenda, "dd/MM/yyyy") +
				"\nvendaItem = " + vendaItem;
	}

}
