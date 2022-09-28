package Classe;

import java.awt.HeadlessException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args)
			throws HeadlessException, NoSuchAlgorithmException, UnsupportedEncodingException {
		Cooperativa cooperativa = new Cooperativa();
		cooperativa.cadastrarCooperativa();

		Agencia agencia = new Agencia();
		agencia.cadastrarAgencia();

		Cliente cliente = new Cliente();
		cliente.cadastrarCliente();

		Conta conta = new Conta();
		conta.varcooperativa = cooperativa;
		conta.varagencia = agencia;
		conta.varcliente = cliente;
		conta.cadastraConta();
		conta.cadastraSenha();
		conta.alterarsenha();
		conta.saque();
		conta.continuarSacando();
		conta.deposito();
		conta.continuarDepositando();

		JOptionPane.showMessageDialog(null, conta.retornaContaCliente());
	}

}
