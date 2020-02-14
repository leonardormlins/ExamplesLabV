package br.gov.sp.fatec;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DIConfig.class);
 
		Placa obj = (Placa) context.getBean(Placa.class);
		System.out.println(obj.ler());
		
        HelloWorld msg1 = (HelloWorld) context.getBean("mensagem1"); 
        System.out.println(msg1.getMensagem());
        msg1.setNome("Teste");
        HelloWorld msg2 = (HelloWorld) context.getBean("mensagem1"); 
        System.out.println(msg2.getMensagem());

        HelloWorld msg3 = (HelloWorld) context.getBean("mensagem2"); 
        System.out.println(msg3.getMensagem());
        msg3.setNome("Teste");
        HelloWorld msg4 = (HelloWorld) context.getBean("mensagem2"); 
        System.out.println(msg4.getMensagem());
		
		context.close();
	}
}
