package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.SteamController;

public class Principal {

	public static void main(String[] args) {
		SteamController arqCont = new SteamController();
		String path = "/Users/lucasbezerrademacedo/Documents";
		String nome = "SteamCharts.csv";
		int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor do ano desejado"));
		String mes = JOptionPane.showInputDialog("Digite o mes desejado");
		double media = Double.parseDouble(JOptionPane.showInputDialog("Digite o delimitador de média"));
		
		try {
			arqCont.recebeDados2(ano, mes, path, nome);
			arqCont.recebeDados(ano, mes, media);
		} catch (IOException e) {
			e.printStackTrace();
		}	
		}
	}