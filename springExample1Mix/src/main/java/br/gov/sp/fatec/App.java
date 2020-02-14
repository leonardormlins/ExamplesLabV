package br.gov.sp.fatec;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
 
		Placa obj = (Placa) context.getBean("placaMensagem");
		System.out.println(obj.ler());
		
        HelloWorld msg1 = (HelloWorld) context.getBean("mensagem"); 
        System.out.println(msg1.getMensagem());
        msg1.setNome("Teste");
        HelloWorld msg2 = (HelloWorld) context.getBean("mensagem"); 
        System.out.println(msg2.getMensagem());

        HelloWorld msg3 = (HelloWorld) context.getBean("mensagem2"); 
        System.out.println(msg3.getMensagem());
        msg3.setNome("Teste");
        HelloWorld msg4 = (HelloWorld) context.getBean("mensagem2"); 
        System.out.println(msg4.getMensagem());
		
		context.close();
	}
}
