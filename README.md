📁 projeto: Análise de Popularidade de Jogos na Steam (SteamCharts.csv)

📝 descricao: >
  Aplicação Java que processa um arquivo .csv contendo dados de popularidade de jogos da plataforma Steam.
  Permite filtrar registros por ano e mês, e analisar a média de jogadores ativos.
  O programa gera um novo arquivo com os resultados e também exibe no console os jogos com média acima de um valor informado.
  Valida a existência do diretório e do arquivo antes de iniciar a leitura.

🗂️ estrutura_arquivos:

📄 src/controller/SteamController.java: >
  Contém os métodos responsáveis por:
  - Validar diretórios e arquivos
  - Filtrar registros por ano e mês
  - Gerar um novo arquivo com os dados filtrados
  - Exibir no console os jogos cuja média de jogadores ativos seja maior ou igual ao valor especificado

📄 src/view/Principal.java: >
  Classe principal da aplicação.
  - Recebe os parâmetros do usuário (ano, mês e média desejada)
  - Chama os métodos do controller para processar os dados

🧠 logica_filtragem:

metodo_1: recebeDados2(int ano, String mes, String path, String nome)
explicacao: >
  - Lê o arquivo SteamCharts.csv
  - Identifica os índices das colunas: gamename, year, month, avg
  - Filtra os registros pelo ano e mês fornecidos
  - Gera um novo arquivo chamado "nome.csv" com o conteúdo:
    nome do jogo,média dos jogadores ativos

metodo_2: recebeDados(int ano, String mes, double media)
explicacao: >
  - Lê o arquivo "nome.csv" gerado anteriormente
  - Remove o caractere '%' da média, se presente
  - Exibe no console os jogos cuja média de jogadores ativos seja maior ou igual ao valor informado
  - Formato da saída: Nome do jogo | Média de jogadores ativos

💬 exemplo_saida_console: |
  Nome do jogo | Média de jogadores ativos
  Counter-Strike: Global Offensive | 53.3674
  Dota 2 | 62.5283
  Team Fortress 2 | 73.3504

📥 entrada:
descricao: >
  O programa espera um arquivo chamado SteamCharts.csv com separador vírgula (,)
  Deve conter, obrigatoriamente, as colunas:
    - gamename
    - year
    - month
    - avg
  O arquivo precisa estar salvo em um diretório existente e acessível.

📤 saida:
descricao: >
  Gera um novo arquivo (nome.csv) contendo apenas os jogos que correspondem ao ano e mês especificados,
  com suas respectivas médias de jogadores ativos.
  Também exibe no console os jogos com média maior ou igual ao valor informado.

🔗 dataset:
nome: SteamCharts.csv
origem: https://drive.google.com/file/d/1QT29x3lMj4_j9Ca9XRyjWzuUjtTjNi58/view?usp=sharing

📌 observacoes:

🛡️ O programa trata erros como:
  - Diretório ou arquivo inexistente
  - Cabeçalhos ausentes ou mal formatados
  - Valores inválidos na média

💻 Compatível com Windows, macOS e Linux (ajustando o caminho de leitura do arquivo)

👨‍💻 autor:
  nome: Lucas Bezerra de Macedo
