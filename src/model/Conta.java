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
	
	public void realizarDeposito(String c, float dinheiro) throws Exception {
		if(this.status == true && dinheiro > 0) {
			this.saldo += dinheiro;
			}
		else if(dinheiro <= 0) {
			throw new Exception("O valor inserido não é válido!");	
			}
		else {
			throw new Exception("A conta inserida não é válida!");
		}
	}
	
	public void realizarSaque(String c, float dinheiro) throws Exception {
		if(this.status == true && dinheiro <= this.saldo) {
			this.saldo -= dinheiro;
			}
		else if(dinheiro > 0) {
			throw new Exception("O valor inserido não é válido!");	
			}
		else {
			throw new Exception("A conta inserida não é válida!");
		}
	}
	
	public float mostrarSaldo() {
		return this.saldo;
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
		return "\nConta: " + numConta + ", Saldo: " + saldo + ", Status: " + status + ", Data de Abertura: "
				+ dataAbertura + "\n";
	}

}
