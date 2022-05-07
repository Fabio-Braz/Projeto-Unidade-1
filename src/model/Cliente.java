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
	String cpf;
	String nome;
	
	private List<Conta> Contas = new ArrayList<>();
	
	public Cliente() {
		
	}
	
	public Cliente(String cpf) {
		this.cpf = cpf;
	}
	
	public Cliente(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}
	
	
	// Listar contas
	public List<Conta> listarContas() {
		return Contas;
	}
	
	
	
	public void adicionarConta(Conta c){
		if(Contas.contains(c)) {
			System.out.println("Conta já cadastrada!");
		}
		else {
			Contas.add(c);
		}
	}
	
	public void removerConta(Conta c) {
		if(Contas.contains(c)) {
			Contas.remove(c);
		}
		else {
			System.err.println("Conta inexistente!");
		}
	}

	
	public Conta localizarConta(String c) {
		Conta temp = new Conta(c);
		if(Contas.contains(temp))
		{
			int index = Contas.indexOf(temp);
			temp = Contas.get(index);
			return temp;
		}
		else {
			return null;
		
		}
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
		return "Cliente [cpf=" + cpf + ", nome=" + nome + ", ArraydeContas="
				+ Contas + "]";
	}
	
	
}
