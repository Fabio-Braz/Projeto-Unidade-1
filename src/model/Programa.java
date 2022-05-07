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
				System.out.println("Digite um número de acordo com sua necessidade:\n");
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
				System.out.println("Opção: ");
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
					System.out.println("Pronto, você está cadastrado! Crie uma conta! ");
					System.out.println("Digite um NÚMERO para sua Conta: ");
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
						System.out.println("Criação de conta!");
						System.out.println("Digite o CPF do Cliente que deseja adicionar outra conta:");
						String cpf_cliente = pergunta.next();
						System.out.println("Digite agora o NÚMERO da nova conta que deseja adicionar: ");
						System.out.println(persistencia.localizarClienteCPF(cpf_cliente).listarContas());
						System.out.println("Você adicionou uma nova conta com sucesso!");	
					}
						catch (Exception e) {
							System.out.println(e.getMessage());
						}
						break;
				case "3":
					System.out.println("você digitou 3");
					//Realizar deposito [3]
					break;
				case "4":
					System.out.println("você digitou 4");
					//Realizar saque [4]
					break;
				case "5":
					System.out.println("você digitou 5");
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
					System.out.println("você digitou 7");
					//Listar Contas Cadastradas [7]
					break;
				case "8":
					System.out.println("você digitou 8");
					//Consultar Cliente [8]
					break;
				case "9":
					System.out.println("você digitou 9");
					//Remover Cliente [9]
					break;
				case "10":
					System.out.println("você digitou 10");
					//Remover Conta [10]
					break;
				case "sair":
					System.out.println("você digitou sair. \n Programa Encerrado!");
					//Remover Conta [10]
					comeco = false;
					break;
				default:
					System.out.println("Você digitou uma opção inválida!\nTente novamente!");
					break;
				}

		
		
		/* CADASTRO DO CLIENTE E ASSOCIAÇÃO A CONTA!
		Cliente cliente1 = new Cliente("001" , "Fábio");
		Conta conta1 = new Conta("123A");
		conta1.adicionarSaldo(100);
		cliente1.adicionarConta(conta1);
		
		Cliente cliente2 = new Cliente("002" , "Maria");
		Conta conta2 = new Conta("456A");
		cliente2.adicionarConta(conta2);
		
		Cliente cliente3 = new Cliente("003" , "João");
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
		
		// Método para procurar clientes dentro dos dados!
		// Funciona > System.out.println(p1.localizarClienteCPF("001"));
		
		// Método remover cliente
		p1.removerClienteCPF("001");
		
		System.out.println();
		
		// Foreach mostrando clientes após remoção!
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
		

