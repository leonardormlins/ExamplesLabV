package br.gov.sp.fatec;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Usuario;
import br.gov.sp.fatec.repository.UsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class SpringDataJpaTests {

	private static final String NOME = "Usuário Test";
	private static final String SENHA = "Test";
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	/**
	 * @param usuarioRepo the usuarioRepo to set
	 */
	public void setUsuarioRepo(UsuarioRepository usuarioRepo) {
		this.usuarioRepo = usuarioRepo;
	}

	@Test
	public void testeInsercaoOk() {
		Usuario usuario = new Usuario();
		usuario.setNome(NOME);
		usuario.setSenha(SENHA);
		usuarioRepo.save(usuario);
		assertTrue(usuario.getId() != null);
	}

}
