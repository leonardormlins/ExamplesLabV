/**
 * 
 */
package br.gov.sp.fatec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author Emanuel
 *
 */
@Configuration
@ComponentScan(value={"br.gov.sp.fatec"})
public class DIConfig {
	
	@Bean(name={"mensagem1"}) //Nao e necessario especificar um nome
	public Mensagem getMensagem() {
		HelloWorld mensagem = new HelloWorld();
		mensagem.setNome("Newcomer");
		return mensagem;
	}
	
	@Bean(name={"mensagem2"}) //Nao e necessario especificar um nome
	@Scope("prototype")
	public Mensagem getMensagem2() {
		HelloWorld mensagem = new HelloWorld();
		mensagem.setNome("Ze Ninguem");
		return mensagem;
	}

}
