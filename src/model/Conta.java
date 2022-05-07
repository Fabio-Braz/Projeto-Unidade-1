package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import model.Conta;

public class Conta implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String numConta;
	float saldo;
	boolean status;
	Date dataAbertura;
	
	public Conta(String numConta)
	{
		this.numConta = numConta;
		this.saldo = 0f;
		this.status = true;
		this.dataAbertura = new Date();
		
	}
	public Conta() {
		
	}
	
	public void adicionarSaldo(float quantia) {
		this.saldo = quantia;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(numConta);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(numConta, other.numConta);
	}
	@Override
	public String toString() {
		return "Conta [numConta=" + numConta + ", saldo=" + saldo + ", status=" + status + ", dataAbertura="
				+ dataAbertura + "]";
	}

}
