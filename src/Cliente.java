package Classe;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public class Cliente {
	String nome, dataNascimento, endereco, telefone, documento;
	LocalDate dataNascimentoCliente;

	public void cadastrarCliente() {

		nome = JOptionPane.showInputDialog("Digite o nome do cliente: ");
		documento = JOptionPane.showInputDialog("Digite o documento do cliente: ");
		dataNascimento = JOptionPane.showInputDialog("Digite a data de nascimento: ");
		dataNascimentoCliente = LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("ddMMyyyy"));
		endereco = JOptionPane.showInputDialog("Digite o endereço: ");
		telefone = JOptionPane.showInputDialog("Digite o telefone: ");

	}

	public String getNome() {
		return nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getDocumento() {
		return documento;
	}

	public LocalDate getDataNascimentoCliente() {
		return dataNascimentoCliente;
	}

	public String retornadadosCliente() {
		String ret = "Dados do cliente \n";
		ret += "Nome: " + nome + "\n";
		ret += "CPF do cliente: " + documento + "\n";
		ret += "Data de nascimento: " + dataNascimentoCliente + "\n";
		ret += "Endereço: " + endereco + "\n";
		ret += "Telefone: " + telefone + "\n";

		return ret;
	}

}
