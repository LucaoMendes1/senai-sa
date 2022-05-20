package br.com.senai.manutencaosenaiapi.view.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.senai.manutencaosenaiapi.entity.Peca;
import br.com.senai.manutencaosenaiapi.entity.TipoDePeca;

public class TipoDePecaTableModel extends AbstractTableModel{

	private final int QTDE_COLUNAS = 2;
	
	private List<TipoDePeca> tipoDePecas;	
	
	public TipoDePecaTableModel(List<TipoDePeca> tipoDePeca) {	
		this.tipoDePecas = tipoDePeca;
	}

	@Override
	public int getRowCount() {
		return tipoDePecas.size();
	}

	@Override
	public int getColumnCount() {
		return QTDE_COLUNAS;
	}
	
	@Override
	public String getColumnName(int column) {
		if (column == 0) {
			return "ID";
		}else if (column == 1) {
			return "Descrição";
		}
		throw new IllegalArgumentException("Indice inválido");
	}
	
	public TipoDePeca getPor(int rowIndex) {
		return tipoDePecas.get(rowIndex);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		if (columnIndex == 0) {
			return tipoDePecas.get(rowIndex).getId();
		}else if (columnIndex == 1) {
			return tipoDePecas.get(rowIndex).getDescricao();
		}
		
		throw new IllegalArgumentException("Indice inválido");
	}

}
