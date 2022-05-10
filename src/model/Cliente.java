package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;


public class Cliente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cpf;
	private String nome;
	
	private List<Conta> Contas = new ArrayList<>();
	
	public Cliente() {
		
	}
	
	public Cliente(String cpf) {
		this.cpf = cpf;
	}
	
	public Cliente(String nome, String cpf) {
		this.cpf = cpf;
		this.nome = nome;
	}

	// Listar contas
	public List<Conta> listarContas(){
		return Contas;
	}
	
	public float mostrarSaldo(Conta c) throws Exception {
		if(Contas.contains(c)) {
			return c.saldoDeInstancia();
		}
		else {
			throw new Exception("Conta inexistente!");
		}
	}
	
	public void adicionarConta(Conta c) throws Exception {
		if(Contas.contains(c)) {
			throw new Exception("Conta já registrada!");
		}
		else {
			Contas.add(c);
		}
	}
	
	public void removerConta(Conta c) throws Exception{
		if(Contas.contains(c)) {
			Contas.remove(c);
		}
		else {
			throw new Exception("Conta inexistente!");
		}
	}
	
	public Conta localizarConta(String c) throws Exception{
		Conta temp = new Conta(c);
		if(Contas.contains(temp))
		{
			int index = Contas.indexOf(temp);
			temp = Contas.get(index);
			return temp;
		}
		else {
			throw new Exception("Conta inexistente!");
		
		}
	}
	
	
	public String retornoCpfCliente(){
		return this.cpf;
	}
	
	public boolean contaExistente(Conta c) {
		if(Contas.contains(c)) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {
		return "Cliente = Nome: " + nome + " | CPF: " + cpf + "\nContas:\n"
				+ Contas;
	}
	
	
}
