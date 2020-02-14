/**
 * 
 */
package br.gov.sp.fatec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author Emanuel
 *
 */
@Component
public class Placa {
	
	/**
	 * Mensagem a ser exibida na placa
	 */
	@Autowired
	@Qualifier("mensagem1") //Nao e obrigatorio especificar um nome
	private Mensagem mensagem;
	
	/**
	 * Construtor
	 */
	public Placa() {
	}
	
	/**
	 * Retorna o texto da placa
	 * @return Texto da placa
	 */
	public String ler() {
		return "[ <" + mensagem.getMensagem() + "> ]";
	}
	
	/**
	 * Setter para mensagem
	 * @param mensagem
	 */
	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}

}
