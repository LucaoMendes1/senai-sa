package br.com.senai.manutencaosenaiapi.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.senai.manutencaosenaiapi.entity.TipoDePeca;
import br.com.senai.manutencaosenaiapi.repository.TipoDePecaRepository;

@Service
@Validated
public class TipoDePecaService {
	
	@Autowired
	private TipoDePecaRepository repository;

	public TipoDePeca inserir(
			@Valid
			@NotNull(message = "A peça não pode ser nula")
			TipoDePeca novoTipoDePeça) {
		TipoDePeca TipoPecaSalva = repository.save(novoTipoDePeça);
		return TipoPecaSalva;
	}
	
	public List<TipoDePeca> listarPorTipo(
			@NotEmpty(message = "A descrição da busca é obrigatória")
			@NotBlank(message = "A descrição não pode conter espaço em branco")
			String descricao){
		return repository.listarPor("%" + descricao + "%");
	}
	
	
}
