/**
 * 
 */
package br.gov.sp.fatec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Emanuel
 *
 */
@Component("placaMensagem")
public class Placa {
	
	/**
	 * Mensagem a ser exibida na placa
	 */
	@Autowired
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
