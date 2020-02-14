package br.gov.sp.fatec.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Autorizacao;
import br.gov.sp.fatec.model.Usuario;
import br.gov.sp.fatec.repository.AutorizacaoRepository;
import br.gov.sp.fatec.repository.UsuarioRepository;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Autowired
	private AutorizacaoRepository autorizacaoRepo;

	public void setUsuarioRepo(UsuarioRepository usuarioRepo) {
		this.usuarioRepo = usuarioRepo;
	}

	public void setAutorizacaoRepo(AutorizacaoRepository autorizacaoRepo) {
		this.autorizacaoRepo = autorizacaoRepo;
	}

	@Override
	@Transactional
	public Usuario incluirUsuario(String nome, String senha, String nomeAutorizacao) {
		Autorizacao autorizacao = autorizacaoRepo.findByNome(nomeAutorizacao);
		// Se nao existe
		if(autorizacao == null) {
			// Cria nova
			autorizacao = new Autorizacao();
			autorizacao.setNome(nomeAutorizacao);
			autorizacaoRepo.save(autorizacao);
		}
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setSenha(senha);
		usuario.setAutorizacoes(new ArrayList<Autorizacao>());
		usuario.getAutorizacoes().add(autorizacao);
		usuarioRepo.save(usuario);
		return usuario;
	}

	@Override
	public List<Usuario> buscar(String nome) {
		return usuarioRepo.findByNomeContainsIgnoreCase(nome);
	}
	
	@Override
	public Usuario buscar(Long id) {
		Optional<Usuario> usuario =  usuarioRepo.findById(id);
		if(usuario.isPresent()) {
			return usuario.get();
		}
		return null;
	}

	@Override
	public List<Usuario> todos() {
		List<Usuario> retorno = new ArrayList<Usuario>();
		for(Usuario usuario: usuarioRepo.findAll()) {
			retorno.add(usuario);
		}
		return retorno;
	}
	
	@Override
	public Usuario salvar(Usuario usuario) {
		if(!usuario.getAutorizacoes().isEmpty()) {
			for(Autorizacao aut: usuario.getAutorizacoes()) {
				// Se nao existe, cria
				if(aut.getId() == null && autorizacaoRepo.findByNome(aut.getNome()) == null) {
					autorizacaoRepo.save(aut);
				}
			}
		}
		return usuarioRepo.save(usuario);
	}


}
