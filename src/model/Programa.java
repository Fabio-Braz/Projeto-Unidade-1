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
								   "Remover Conta [9]: \n"+
								   "Remover Cliente [10]: \n"+
								   "Para encerrar o programa (Digite: sair) \n");
				System.out.println("Op��o: ");
				String codigo = pergunta.next();
				System.out.println("__________________________________________________________");
				String nome_cadastro;
				String cpf_cadastro;
				PersistenciaArquivo persistencia = new PersistenciaArquivo();
				
				switch (codigo.toLowerCase()) {
				
				case "1":
					
					System.out.println("Criando um Cadastro para o Cliente!\n");
					System.out.println("Digite seu Nome: ");
					nome_cadastro = pergunta.next();
					System.out.println("Digite seu CPF: ");
					cpf_cadastro = pergunta.next();
					Cliente cliente = new Cliente(nome_cadastro, cpf_cadastro);
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
						persistencia.salvarDados();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					
					break;
					
				case "2":
					System.out.println("Cria��o de conta!");
					System.out.println("Digite o CPF do Cliente que deseja adicionar outra conta:");
					String cpf_cliente = pergunta.next();
					System.out.println("Digite agora o N�MERO da nova conta que deseja adicionar: ");
					try {
						persistencia.localizarClienteCPF(cpf_cliente).adicionarConta(new Conta(pergunta.next()));
						persistencia.salvarDados();
						System.out.println("Voc� adicionou uma nova conta com sucesso!");
					}
						catch (Exception e) {
							System.out.println(e.getMessage());
						}
					break;
					
				case "3":
					System.out.println("Digite o CPF para realizar um deposito:");
					String cpf_deposito = pergunta.next();
					System.out.println("Digite o n�mero da conta que vai receber o deposito:");
					String conta_deposito = pergunta.next();
					System.out.println("Digite o valor do deposito:");
					float valor_deposito = pergunta.nextFloat();
					try {		
						persistencia.localizarClienteCPF(cpf_deposito).localizarConta(conta_deposito).realizarDeposito(conta_deposito, valor_deposito);
						persistencia.salvarDados();
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
					break;
				case "4":
					//Realizar saque [4]
					System.out.println("Digite o CPF para realizar o SAQUE:");
					String cpf_saque = pergunta.next();
					System.out.println("Digite o n�mero da conta que vai ser feito o SAQUE:");
					String conta_saque = pergunta.next();
					System.out.println("Digite o valor do SAQUE:");
					float valor_de_saque = pergunta.nextFloat();
					try {		
						persistencia.localizarClienteCPF(cpf_saque).localizarConta(conta_saque).realizarSaque(cpf_saque, valor_de_saque);
						persistencia.salvarDados();
						System.out.println("Saque realizado com sucesso!");
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
					break;
				case "5":
					try {
					System.out.println("Para saber o saldo voc� dever� digitar o CPF e N�mero da conta.");
					System.out.println("Digite seu CPF:");
					String cpf_saldo = pergunta.next();
					System.out.println("Digite o n�mero da sua CONTA:");
					Conta conta_saldo = new Conta(pergunta.next());
					System.out.println("Saldo dispon�vel:");
					System.out.println(persistencia.localizarClienteCPF(cpf_saldo).mostrarSaldo(conta_saldo));
					
					} catch(Exception e){
						System.err.println(e.getMessage());
					}
					break;
				case "6":
					System.out.println("Clientes Cadastrados!");
					for(Cliente c : persistencia.listarClientes()) {
						System.out.println(c);
					}
					//Listar Clientes Cadastrados [6]
					break;
				case "7":
					System.out.println("Digite o CPF para saber as contas cadastradas:");
					String contas_cadastradas = pergunta.next();
					try {
						Cliente client = persistencia.localizarClienteCPF(contas_cadastradas);
						System.out.println("Contas do CPF: [ " + client.retornoCpfCliente() + " ]");
						System.out.println(persistencia.localizarClienteCPF(contas_cadastradas).listarContas());
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					//Listar Contas Cadastradas [7]
					break;
				case "8":
					System.out.println("Para consultar os dados do cliente, digite seu CPF: ");
					String cpf_consulta = pergunta.next();
					try {
						System.out.println(persistencia.localizarClienteCPF(cpf_consulta));
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					//Consultar Cliente [8]
					break;
				case "9":
					System.out.println("Digite o CPF do cliente que deseja remover:");
					String cpf_conta_remocao = pergunta.next();
					System.out.println("Digite o n�mero da conta para remo��o:");
					Conta conta_remocao = new Conta(pergunta.next());
					try {
						persistencia.localizarClienteCPF(cpf_conta_remocao).removerConta(conta_remocao);
						System.out.println("Conta removida!");
						persistencia.salvarDados();
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
					break;
				case "10":
					System.out.println("Digite o CPF do CLIENTE que ser� removido");
					String cpf_cliente_remocao = pergunta.next();
					try {
						persistencia.removerClienteCPF(cpf_cliente_remocao);
						persistencia.salvarDados();
						System.out.println("Cliente removido com sucesso!");
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					//Remover Cliente [10]
					break;
				case "sair":
					System.out.println("voc� digitou sair. \n Programa Encerrado!");
					persistencia.salvarDados();
					comeco = false;
					break;
				default:
					System.out.println("Voc� digitou uma op��o inv�lida!\nTente novamente!");
					break;
				}
			}
	}
}