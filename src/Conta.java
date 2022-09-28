package Classe;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JOptionPane;

public class Conta {
	Cooperativa varcooperativa;
	Agencia varagencia;
	Cliente varcliente;
	double limite;
	double valorSaque;
	double saldo;
	double valorDeposito;
	private String senhaStr;
	private String senhaAntiga;

	public void cadastraConta() {
		limite = Double.parseDouble(JOptionPane.showInputDialog("Informe o limite do usuário"));
		saldo = Double.parseDouble(JOptionPane.showInputDialog("Informe o saldo: "));
	}

	public void cadastraSenha() {
		senhaStr = JOptionPane.showInputDialog("Digite a senha de seis dígitos");
		senhaAntiga = senhaStr;
		if (senhaStr.length() > 6 || senhaStr.length() < 6) {
			JOptionPane.showMessageDialog(null, "Senha inválida");
		}
	}

	public void alterarsenha() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		int alterarSenhaConta = JOptionPane.showConfirmDialog(null, "Deseja alterar senha?");
		if (alterarSenhaConta == 0) {
			String senhaAnterior = JOptionPane.showInputDialog("Digite sua senha anterior");
			toHash(senhaAnterior);

			if (senhaAnterior.equals(senhaAntiga)) {
				String novaSenha = JOptionPane.showInputDialog("Digite sua nova senha");
				toHash(novaSenha);
			} else {
				JOptionPane.showMessageDialog(null, "Senha inválida");
				System.exit(0);
			}
		}

	}

	public String toHash(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		StringBuilder str = new StringBuilder();

		MessageDigest algorithm = MessageDigest.getInstance("MD5");
		for (byte bit : algorithm.digest(password.getBytes("UTF-8"))) {
			str.append(String.format("%02X", 0xFF & bit));
		}

		return str.toString();
	}

	public String retornaContaCliente() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String ret = "Dados da conta: \n \n";
		ret += varcooperativa.dadosCooperativa();
		ret += varagencia.dadosAgencia();
		ret += varcliente.retornadadosCliente() + "\n";
		ret += "Saldo: " + saldo + "\n";
		ret += "Senha: " + toHash(senhaStr);
		return ret;
	}

	public void saque() {

		valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor a ser sacado"));
		saldo = saldo - valorSaque;
		JOptionPane.showMessageDialog(null, "Valor em conta: R$ " + saldo);

	}

	public void deposito() {

		valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor a ser depositado"));
		saldo = saldo + valorDeposito;

		JOptionPane.showMessageDialog(null, "Valor em conta: R$ " + saldo);

	}

	public void continuarSacando() {
		int continuarSaque;
		do {
			continuarSaque = JOptionPane.showConfirmDialog(null, "Você deseja continuar sacando?");
			if (continuarSaque == 0) {
				saque();
			}
		} while (continuarSaque == 0);
	}

	public void continuarDepositando() {
		int continuarDeposito;
		do {
			continuarDeposito = JOptionPane.showConfirmDialog(null, "Você deseja continuar depositando?");
			if (continuarDeposito == 0) {
				saque();
			}
		} while (continuarDeposito == 0);
	}
}
