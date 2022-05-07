package model;

import java.util.Scanner;

import persistencia.PersistenciaArquivo;

public class Programa {
	public static void main(String[] args) throws Exception {
		
		// PROGRAMA FINAL
			Scanner pergunta = new Scanner(System.in);
			boolean comeco = true;
			while(comeco) {
				
				System.out.println("__________________________________________________________");
				System.out.println("Digite um n�mero de acordo com sua necessidade:\n");
				System.out.println("Cadastrar cliente [1]:\n" +
								   "Criar conta para o cliente [2]: \n" +
								   "Realizar deposito [3]: \n" +
								   "Realizar saque [4]: \n" +
								   "Consultar Saldo [5]: \n" +
								   "Listar Clientes Cadastrados [6]: \n" +
								   "Listar Contas Cadastradas Pelo CPF [7]: \n"+
								   "Consultar Cliente [8]: \n"+
								   "Remover Cliente [9]: \n"+
								   "Remover Conta [10]: \n"+
								   "Para desligar o programa (Digite: sair) \n");
				System.out.println("Op��o: ");
				String codigo = pergunta.next();
				System.out.println("__________________________________________________________");
				String nome;
				String cpf;
				PersistenciaArquivo persistencia = new PersistenciaArquivo();
			
				
				switch (codigo.toLowerCase()) {
				
				case "1":
					
					System.out.println("Criando um Cadastro para o Cliente!\n");
					System.out.println("Digite seu Nome: ");
					nome = pergunta.next();
					System.out.println("Digite seu CPF: ");
					cpf = pergunta.next();
					Cliente cliente = new Cliente(nome, cpf);
					System.out.println("Pronto, voc� est� cadastrado! Crie uma conta! ");
					System.out.println("Digite um N�MERO para sua Conta: ");
					String numeroConta = pergunta.next();
					Conta conta = new Conta(numeroConta);
					cliente.adicionarConta(conta);
					System.out.println("Conta criado com Sucesso!");
					System.out.println();
					
					//Persistencia do Programa!
					try {
						persistencia.adicionarCliente(cliente);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					
					break;
					
				case "2":
					try {
						System.out.println("Cria��o de conta!");
						System.out.println("Digite o CPF do Cliente que deseja adicionar outra conta:");
						String cpf_cliente = pergunta.next();
						System.out.println("Digite agora o N�MERO da nova conta que deseja adicionar: ");
						System.out.println(persistencia.localizarClienteCPF(cpf_cliente).listarContas());
						System.out.println("Voc� adicionou uma nova conta com sucesso!");	
					}
						catch (Exception e) {
							System.out.println(e.getMessage());
						}
						break;
				case "3":
					System.out.println("voc� digitou 3");
					//Realizar deposito [3]
					break;
				case "4":
					System.out.println("voc� digitou 4");
					//Realizar saque [4]
					break;
				case "5":
					System.out.println("voc� digitou 5");
					//Consultar Saldo [5]
					break;
				case "6":
					System.out.println("Clientes Cadastrados!");
					for(Cliente c : persistencia.listarClientes()) {
						System.out.println(c);
					}
					//Listar Clientes Cadastrados [6]
					break;
				case "7":
					System.out.println("voc� digitou 7");
					//Listar Contas Cadastradas [7]
					break;
				case "8":
					System.out.println("voc� digitou 8");
					//Consultar Cliente [8]
					break;
				case "9":
					System.out.println("voc� digitou 9");
					//Remover Cliente [9]
					break;
				case "10":
					System.out.println("voc� digitou 10");
					//Remover Conta [10]
					break;
				case "sair":
					System.out.println("voc� digitou sair. \n Programa Encerrado!");
					//Remover Conta [10]
					comeco = false;
					break;
				default:
					System.out.println("Voc� digitou uma op��o inv�lida!\nTente novamente!");
					break;
				}

		
		
		/* CADASTRO DO CLIENTE E ASSOCIA��O A CONTA!
		Cliente cliente1 = new Cliente("001" , "F�bio");
		Conta conta1 = new Conta("123A");
		conta1.adicionarSaldo(100);
		cliente1.adicionarConta(conta1);
		
		Cliente cliente2 = new Cliente("002" , "Maria");
		Conta conta2 = new Conta("456A");
		cliente2.adicionarConta(conta2);
		
		Cliente cliente3 = new Cliente("003" , "Jo�o");
		Conta conta3 = new Conta("897A");
		cliente3.adicionarConta(conta3);
		
		
		PersistenciaArquivo p1 = new PersistenciaArquivo();
		try {
			p1.adicionarCliente(cliente1);
			p1.adicionarCliente(cliente2);
			p1.adicionarCliente(cliente3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		// Foreach mostrando clientes!
		for(Cliente c : p1.listarClientes()) {
			System.out.println(c);
		}
		
		// M�todo para procurar clientes dentro dos dados!
		// Funciona > System.out.println(p1.localizarClienteCPF("001"));
		
		// M�todo remover cliente
		p1.removerClienteCPF("001");
		
		System.out.println();
		
		// Foreach mostrando clientes ap�s remo��o!
				for(Cliente c : p1.listarClientes()) {
					System.out.println(c);
				}
				
		System.out.println();
		
		//Cliente temp = p1.localizarClienteCPF("002");
		//
		//System.out.println(temp.listarContas());
		
		//System.out.println(p1.localizarClienteCPF("002").listarContas());
		
		System.out.println(p1.listarContasPeloCPF("002").listarContas());
		*/
			}
	}
}
		

