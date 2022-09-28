package Classe;

import javax.swing.JOptionPane;

public class Agencia {

	public String endereco;
	public int numeroAgencia;

	public void cadastrarAgencia() {
		numeroAgencia = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da agência: "));
		endereco = JOptionPane.showInputDialog("Digite o endereço da agência (bairro): ");
	}

	public String dadosAgencia() {
		String ret = "Dados da agência: \n";
		ret += "Número da agência: " + numeroAgencia + "\n";
		ret += "Endereço da agência: " + endereco + "\n \n ";
		return ret;
	}
}
