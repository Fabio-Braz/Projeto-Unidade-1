package persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class PersistenciaArquivo {
List<Cliente> ArrayClientes = new ArrayList<>();
	
	public PersistenciaArquivo() {
		
		carregarDados();
	}
	
	// Listar todos os Clientes
	public List<Cliente> listarClientes() {
		return ArrayClientes;
	}
	
	// Método remover Clientes
	public Cliente removerClienteCPF(String cpf) throws Exception
	{
		Cliente temp = new Cliente(cpf);
		
		if(ArrayClientes.contains(temp)) {
			int index = ArrayClientes.indexOf(temp);
			temp = ArrayClientes.remove(index);
			return temp;
		}
		else
			throw new Exception("O cliente não existe na lista!");
	}
	
	// Método Localizar Clientes
	public Cliente localizarClienteCPF(String cpf) throws Exception
	{
		Cliente temp = new Cliente(cpf);
		
		if(ArrayClientes.contains(temp)) {
			int index = ArrayClientes.indexOf(temp);
			temp = ArrayClientes.get(index);
			return temp;
		}
		else
			throw new Exception("O cliente não existe na lista!");
	}
	
	// Método adicionar Clientes
	public void adicionarCliente(Cliente c) throws Exception{
		if(ArrayClientes.contains(c)){
			throw new Exception("O cliente já foi cadastrado");
			
		}
		else {
			ArrayClientes.add(c);
			salvarDados();
		}
			
	}
	
	// Método salvar Clientes
	public void salvarDados() {
		try {
			FileOutputStream fos = new FileOutputStream("dados");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(ArrayClientes);
			oos.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	
	// Método carregar Clientes
	public void carregarDados() {

		try 
		{
			FileInputStream fis = new FileInputStream("dados");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayClientes = (ArrayList<Cliente>) ois.readObject();
			ois.close();
		}
		catch(Exception ex)
		{
			System.err.println(ex.getMessage());
		}
	}
	
	// Método Ixibir Clientes
	public String toString() {
		return "PersistenciaArquivo [Clientes=" + ArrayClientes + "]";
	}
}
