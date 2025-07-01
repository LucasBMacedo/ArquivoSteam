package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SteamController {

    public SteamController() {
        super();
    }

    public void recebeDados(int ano, String mes, double media) throws IOException {
        String path = "/Users/lucasbezerrademacedo/Documents";
        String nome = "nome.csv"; // O nome do seu arquivo gerado
        File arq = new File(path, nome);

        if (arq.exists() && arq.isFile()) {
            FileInputStream fluxo = new FileInputStream(arq);
            InputStreamReader leitor = new InputStreamReader(fluxo);
            BufferedReader buffer = new BufferedReader(leitor);
            String linha = buffer.readLine(); // Lê o cabeçalho

            System.out.println("Nome do jogo | Média de jogadores ativos");

            linha = buffer.readLine(); // Começa a ler os dados
            while (linha != null) {
                String[] campos = linha.split(",");
                if (campos.length >= 2) {
                    String nomeJogo = campos[0];
                    String mediaStr = campos[1].replace("%", "").trim();

                    try {
                        double mediaArquivo = Double.parseDouble(mediaStr);
                        if (mediaArquivo >= media) {
                            System.out.println(nomeJogo + " | " + mediaArquivo);
                        }
                    } catch (NumberFormatException e) {
                        // Pula se não for um número válido
                    }
                }
                linha = buffer.readLine();
            }
            buffer.close();
            leitor.close();
            fluxo.close();
        } else {
            throw new IOException("Arquivo inválido");
        }
    }

    public void recebeDados2(int ano, String mes, String path, String nome) throws IOException {
        File arqEntrada = new File(path, nome);
        File arqSaida = new File(path, "nome.csv");

        if (!arqEntrada.exists() || !arqEntrada.isFile()) {
            throw new IOException("Arquivo de entrada inválido");
        }

        // Leitura do arquivo de entrada
        FileInputStream fluxo = new FileInputStream(arqEntrada);
        InputStreamReader leitor = new InputStreamReader(fluxo);
        BufferedReader buffer = new BufferedReader(leitor);

        // Escrita do arquivo de saída
        boolean escreverCabecalho = !arqSaida.exists() || arqSaida.length() == 0;
        FileWriter fw = new FileWriter(arqSaida, true); // modo append
        PrintWriter pw = new PrintWriter(fw);

        String linha = buffer.readLine(); // Cabeçalho
        String[] colunas = linha.split(",");

        int gamenameIdx = -1, yearIdx = -1, monthIdx = -1, avgIdx = -1;

        for (int i = 0; i < colunas.length; i++) {
            String col = colunas[i].toLowerCase().trim();
            if (col.equals("gamename")) gamenameIdx = i;
            else if (col.equals("year")) yearIdx = i;
            else if (col.equals("month")) monthIdx = i;
            else if (col.equals("avg")) avgIdx = i;
        }

        if (gamenameIdx == -1 || yearIdx == -1 || monthIdx == -1 || avgIdx == -1) {
            buffer.close();
            pw.close();
            throw new IOException("Erro ao identificar colunas. Verifique o cabeçalho do CSV.");
        }

        if (escreverCabecalho) {
            pw.println("nome do jogo,média dos jogadores ativos");
        }

        linha = buffer.readLine();
        while (linha != null) {
            String[] campos = linha.split(",");
            if (campos.length > avgIdx) {
                int anoLinha = Integer.parseInt(campos[yearIdx].trim());
                String mesLinha = campos[monthIdx].trim();

                if (anoLinha == ano && mesLinha.equalsIgnoreCase(mes)) {
                    String nomeJogo = campos[gamenameIdx].trim();
                    String mediaStr = campos[avgIdx].trim();
                    pw.println(nomeJogo + "," + mediaStr);
                }
            }
            linha = buffer.readLine();
        }

        // Fechando tudo
        buffer.close();
        pw.close();
        leitor.close();
        fluxo.close();
    }
}
