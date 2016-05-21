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
	private Double valorFinal;
	
	private int dia = new GregorianCalendar().get(GregorianCalendar.DAY_OF_MONTH);
	private int mes = new GregorianCalendar().get(GregorianCalendar.MONTH);
	private int ano = new GregorianCalendar().get(GregorianCalendar.YEAR);
	
	private static int seq;
	
	public Venda(Cliente cliente, ArrayList<ItemVenda> vendaItem, Double valorFinal){
		this.numVenda = ++seq;
		this.cliente = cliente;
		this.vendaItem = vendaItem;
		this.valorFinal = valorFinal;
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

	public static void setSeq(int seq) {
		Venda.seq = seq;
	}
	
	public Double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(Double valorFinal) {
		this.valorFinal = valorFinal;
	}
	
	@Override
	public String toString() {
		return "\n ============ VENDA NUM " + numVenda + "============" +
				"\nCliente = " + cliente.getNome() +
				"\nData da Venda = " + LtpUtil.formatarData(dataVenda, "dd/MM/yyyy") +
				"\n\n==============" + 
				"\nDados do Produto :: " + vendaItem +
				"\n==============" + 
				"\n\nValor Final = " + valorFinal ;
	}

}
