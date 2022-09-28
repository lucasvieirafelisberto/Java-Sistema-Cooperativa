package Classe;

import javax.swing.JOptionPane;

public class Cooperativa {
	public int numeroDaCooperativa;

	public void cadastrarCooperativa() {
		numeroDaCooperativa = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da cooperativa: "));
	}

	public String dadosCooperativa() {
		String ret = "Dados da cooperativa: \n";
		ret += "Número da cooperativa: " + numeroDaCooperativa + "\n \n";
		return ret;
	}
}
