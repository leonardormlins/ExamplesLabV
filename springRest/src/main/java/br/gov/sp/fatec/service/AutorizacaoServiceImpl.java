package br.gov.sp.fatec.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Autorizacao;
import br.gov.sp.fatec.repository.AutorizacaoRepository;

@Service("autorizacaoService")
@Transactional
public class AutorizacaoServiceImpl implements AutorizacaoService {

	@Autowired
	private AutorizacaoRepository autorizacaoRepo;
	
	public void setAutorizacaoRepo(AutorizacaoRepository autorizacaoRepo) {
		this.autorizacaoRepo = autorizacaoRepo;
	}
	
	@Override
	public Autorizacao salvar(Autorizacao autorizacao) {
		return autorizacaoRepo.save(autorizacao);
	}

	@Override
	public void excluir(Long idAutorizacao) {
		autorizacaoRepo.deleteById(idAutorizacao);
	}

	@Override
	public List<Autorizacao> todos() {
		List<Autorizacao> retorno = new ArrayList<Autorizacao>();
		for(Autorizacao autorizacao: autorizacaoRepo.findAll()) {
			retorno.add(autorizacao);
		}
		return retorno;
	}

	@Override
	public List<Autorizacao> buscar(String nome) {
		if(nome == null || nome.isEmpty()) {
			return todos();
		}
		return autorizacaoRepo.findByNomeContainsIgnoreCase(nome);
	}

	@Override
	public Autorizacao buscarPorId(Long idAutorizacao) {
		Optional<Autorizacao> autorizacao = autorizacaoRepo.findById(idAutorizacao);
		if(autorizacao.isPresent()) {
			return autorizacao.get();
		}
		return null;
	}

}
