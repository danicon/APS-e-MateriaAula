package recursos;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import produto.Produto;


public class View extends JFrame implements ActionListener {
	JMenuBar jmb = new JMenuBar();
	JMenu jm1 = new JMenu("Opções");
	JMenu jm2 = new JMenu("Sair");
	JMenuItem jmi1 = new JMenuItem("Listar");
	JMenuItem jmi2 = new JMenuItem("Cadastrar");
	JMenuItem jmi3 = new JMenuItem("Editar");
	JMenuItem jmi4 = new JMenuItem("Excluir");
	JMenuItem jmi5 = new JMenuItem("Pesquisar");
	JMenuItem jmi6 = new JMenuItem("Sair");
	JMenuItem jmi7 = new JMenuItem("Gerar arquivo de saída");
	

	public View() {
		PreencheLista();
		this.montarTela();	
	}

	private static ArrayList<Produto> listaProduto = new ArrayList<Produto>();
		
	
	public static void PreencheLista() {		
		
		// Cria o arquivo
		File arquivo = new File("entrada.txt");

	    try {
		        /**
		         * VAMOS CRIAR A LISTA DE STRINGS ONDE VAMOS ARMAZENAR
		         */
	    		ArrayList<String> listPalavras = new ArrayList<>();

				FileReader arq = new FileReader(arquivo);
				BufferedReader lerArq = new BufferedReader(arq);

				String linha = lerArq.readLine(); // ler a primeira linha

	      while (linha != null) {
	          /**
	           * PARA PEGARMOS AS PALAVRAS,VAMOS SEPARAR A LINHA POR ESPA�OS!
	           */
	    	  String[] palavrasDaLinha = linha.split("; ");
	        	/**
	        	 * VAMOS ARAMZENAR O ARRAY NA LISTA
	        	 */
	    	  for(String palavra : palavrasDaLinha) {
	              /**
	               * VAMOS CONSIDERAR PALAVRAS APENAS O QUE TENHA UM TAMANHO MAIOR QUE 0 
	               * ESPACOS VAZIOS, TAMBEM NAO SÃO CONSIDERADOS
	               */
	    		  if(palavra.trim().length() > 0 && !"".equals(palavra.trim())) {
	                listPalavras.add(palavra);
	                
	                //System.out.println(palavra);
	    		  }

	        }

	        linha = lerArq.readLine(); // ler da segunda ate a ultima linha
	      }

	      arq.close();
	      /**
	       * VAMOS INFORMAR O TAMANHO DA LISTA, POR EXEMPLO
	       */
	      System.out.println("\n\n");
	      System.out.printf("Total de palavras no arquivo: %s\n", listPalavras.size());
	      
	      System.out.println(listPalavras);
	      
	      
	      	// Dividindo a quantidade de palavras em colunas e linhas
	      	int valor1 = 0;
			int valor2 = 0;
			int valor3 = 0;
			int valor4 = 0;
			int valor5 = 0;
			int valor6 = 0;
			int valor7 = 0;
			int valor8 = 0;
			int valor9 = 0;
			int valor10 = 0;
			int valor11 = 0;
			int valor12 = 0;
			
			int somaValor1 = 0;
			
			int qntLista = listPalavras.size() / 12;
			
			for(int i = 0; i < qntLista; i++){
				valor1 = valor12 + somaValor1;		
				valor2 = valor1 + 1;
				valor3 = valor2 + 1;
				valor4 = valor3 + 1;
				valor5 = valor4 + 1;
				valor6 = valor5 + 1;
				valor7 = valor6 + 1;
				valor8 = valor7 + 1;
				valor9 = valor8 + 1;
				valor10 = valor9 + 1;
				valor11 = valor10 + 1;
				valor12 = valor11 + 1;
				
				somaValor1 = 1;
				
				//Testando
				System.out.println(valor1);							
				System.out.println(valor2);
				System.out.println(valor3);							
				System.out.println(valor4);
				System.out.println(valor5);							
				System.out.println(valor6);
				System.out.println(valor7);							
				System.out.println(valor8);
				System.out.println(valor9);							
				System.out.println(valor10);
				System.out.println(valor11);	
				System.out.println(valor12);
				System.out.println("-----");
				
				
				
				String primeiroValor = listPalavras.get(valor1);
	      		String segundoValor = listPalavras.get(valor2);
	      		String terceiroValor = listPalavras.get(valor3);
	      		String quartoValor = listPalavras.get(valor4);
	      		String quintoValor = listPalavras.get(valor5);
	      		String sextoValor = listPalavras.get(valor6);
	      		String setimoValor = listPalavras.get(valor7);
	      		String oitavoValor = listPalavras.get(valor8);
	      		String nonoValor = listPalavras.get(valor9);
	      		String decimoValor = listPalavras.get(valor10);
	      		String decimoPrimeiroValor = listPalavras.get(valor11);
	      		String decimoSegundoValor = listPalavras.get(valor12);

	            
	            Produto produto = new Produto(Integer.parseInt(primeiroValor), segundoValor, terceiroValor, quartoValor, quintoValor, Integer.parseInt(sextoValor), setimoValor, oitavoValor, Integer.parseInt(nonoValor), decimoValor, decimoPrimeiroValor, decimoSegundoValor);
	    		
			    listaProduto.add(produto);
			}
	      

	    } catch (IOException e) {
	        System.err.printf("Erro na abertura do arquivo: %s.\n",
	          e.getMessage());
	    }

	    System.out.println();
	        
		
	}
				
	
	public static void ListaProduto() throws IOException{
		// Captura o instante inicial
		long inicio = System.nanoTime();
		
		if(listaProduto.isEmpty()){
			InOut.OutMessage("Nenhum Produto Cadastrado");
			return;
		}
		FileWriter arq = new FileWriter("entrada.txt", false);
		PrintWriter gravaArq = new PrintWriter(arq);

		for(int i = 0; i < listaProduto.size(); i++){
			Produto prod = listaProduto.get(i);
			gravaArq.write(prod.getCodigo() + "; " + prod.getCnpj() + "; " + prod.getRazaoSocial() + "; " + prod.getEstado() + "; " + prod.getMunicipio() + "; " + prod.getAno() + "; " + prod.getTipoResiduo() + "; " + prod.getMetodoReciclagem() + "; " + prod.getQuantidade() + "; " + prod.getUnidadeMedida() + "; " + prod.getEmpresaDestinResiduo() + "; " + prod.getSituacaoCadastral() +"\n");
		}
		gravaArq.close();
		
		// Captura o instante final
		long fim = System.nanoTime();
		
		//Tempo de execução
		long tempExecucao = fim - inicio;
		System.out.println("\nO tempo de execução foi: " + tempExecucao + " nanos segundos.");
		
	}
	
	
	
	
	public void montaTabela() {
		// Captura o instante inicial
		long inicio = System.nanoTime();
					
		// Montando a Tabela:
		String[] titulos = {"Código", "CNPJ", "Razão Social", "Estado", "Município", "Ano", "Tipo de Residuo", "Metodo de Reciclagem", "Quantidade", "Unidade de Medida", "Empresa de Destino do Residuo", "Situação Cadastral"};
		dtm = new DefaultTableModel(titulos, 0);
		
		String[] dados = new String[12];
		

		for(int i = 0; i < listaProduto.size(); i++){
			Produto prod = listaProduto.get(i);
					
			dados[0] = Integer.toString(prod.getCodigo());
			dados[1] = prod.getCnpj();
			dados[2] = prod.getRazaoSocial();
			dados[3] = prod.getEstado();
			dados[4] = prod.getMunicipio();
			dados[5] = Integer.toString(prod.getAno());
			dados[6] = prod.getTipoResiduo();
			dados[7] = prod.getMetodoReciclagem();
			dados[8] = Integer.toString(prod.getQuantidade());
			dados[9] = prod.getUnidadeMedida();
			dados[10] = prod.getEmpresaDestinResiduo();
			dados[11] = prod.getSituacaoCadastral();
			
			dtm.addRow(dados);
			
			// Instanciando a Table com o DefaultTableModel
			jt = new JTable(dtm);
			jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			
			// Inserindo a Tabela na "Tela com barra de rolagem"		
			jsPane.setViewportView(jt);
			
		}
		
		
		
		
		// Captura o instante final
		long fim = System.nanoTime();
		
		//Tempo de execução
		long tempExecucao = fim - inicio;
		
		// Convertendo para segundos
		double convert = (double) tempExecucao / 1_000_000_000;
		
		tempExec.setText("<html> <span style='color: #6d6e71;'> O TEMPO DE EXECUÇÃO FOI: <b style='color: black; font-weight: bold;'>" + tempExecucao + " Nanos Segundos</b> CONVERTIDO: <b style='color: black; font-weight: bold; word-break: normal;'> " + String.format("%.2f", convert) + " Segundos </b> <span> </html>");
								
			
	}
	
	public void montaEditar() {
		// aparecer paine p3	
		int valorCd = InOut.InInt("Insire o Código para Editar:");
		setValorCodigo(valorCd);
		
		CardLayout cl = (CardLayout) pc.getLayout();		
		cl.show(pc, "np2");
		
		// Preencher campos
		for(int i = 0; i < listaProduto.size(); i++){
			Produto prod = listaProduto.get(i);
			
			if(valorCd == (prod.getCodigo())){
				edit_tf1.setText(prod.getCnpj());
				edit_tf2.setText(prod.getRazaoSocial());
				edit_tf3.setText(prod.getEstado());
				edit_tf4.setText(prod.getMunicipio());
				edit_tf5.setText(Integer.toString(prod.getAno()));
				edit_tf6.setText(prod.getTipoResiduo());
				edit_tf7.setText(prod.getMetodoReciclagem());
				edit_tf8.setText(Integer.toString(prod.getQuantidade()));
				edit_tf9.setText(prod.getUnidadeMedida());
				edit_tf10.setText(prod.getEmpresaDestinResiduo());
				edit_tf11.setText(prod.getSituacaoCadastral());
			}
		}
	}
	
	public void montaPesquisar() {
		// Captura o instante inicial
		long inicio = System.nanoTime();
					
		// aparecer paine p5
		int pesqCd = InOut.InInt("Insire o Código para Pesquisar:");
		setPesquisaCodigo(pesqCd);
		
		CardLayout cl = (CardLayout) pc.getLayout();		
		cl.show(pc, "np4");
		
		// Preencher campos
		String nomeArq = "entrada.txt";
		File arq = new File(nomeArq);
		
		if(arq.exists()){
			if(listaProduto.size() == 0){
				InOut.OutMessage("Lista Vazia");
				return;
			}
			
			int codigoProcurar = pesqCd;
			
			for(int i=0; i < listaProduto.size(); i++){
				Produto produto = listaProduto.get(i);
				
				if(codigoProcurar == (produto.getCodigo())){
					pesquise_tf1.setText(Integer.toString(produto.getCodigo()));
					pesquise_tf2.setText(produto.getCnpj());
					pesquise_tf3.setText(produto.getRazaoSocial());
					pesquise_tf4.setText(produto.getEstado());
					pesquise_tf5.setText(produto.getMunicipio());
					pesquise_tf6.setText(Integer.toString(produto.getAno()));
					pesquise_tf7.setText(produto.getTipoResiduo());
					pesquise_tf8.setText(produto.getMetodoReciclagem());
					pesquise_tf9.setText(Integer.toString(produto.getQuantidade()));
					pesquise_tf10.setText(produto.getUnidadeMedida());
					pesquise_tf11.setText(produto.getEmpresaDestinResiduo());
					pesquise_tf12.setText(produto.getSituacaoCadastral());							 
					//System.out.println(escreva);
					
					InOut.OutMessage("Valores encontrado com Sucesso!");
					break;
				}
			}
		}else{
			InOut.OutMessage("Arquivo inexistente", "ERRO");
		}
		
		// Captura o instante final
		long fim = System.nanoTime();
		
		//Tempo de execução
		long tempExecucao = fim - inicio;
		
		// Convertendo para segundos
		double convert = (double) tempExecucao / 1_000_000_000;
		
		tempExec.setText("<html> <span style='color: #6d6e71;'> O TEMPO DE EXECUÇÃO FOI: <b style='color: black; font-weight: bold;'>" + tempExecucao + " Nanos Segundos</b> CONVERTIDO: <b style='color: black; font-weight: bold; word-break: normal;'> " + String.format("%.2f", convert) + " Segundos </b> <span> </html>");
		
	}
	
	public void cadastrar() {
		// Cadastrar
		
		// Captura o instante inicial
		long inicio = System.nanoTime();
		
		int codigo = Integer.parseInt(tf1.getText());
		String cnpj = tf2.getText();
		String razaoSocial = tf3.getText();
		String estado = tf4.getText();
		String municipio = tf5.getText();
		int ano = Integer.parseInt(tf6.getText());
		String tipoResiduo = tf7.getText();
		String metodoReciclagem = tf8.getText();
		int quantidade = Integer.parseInt(tf9.getText());
		String unidadeMedida = tf10.getText();
		String empresaDestinResiduo = tf11.getText();
		String situacaoCadastral = tf12.getText();
		
		Produto produto = new Produto(codigo, cnpj, razaoSocial, estado, municipio, ano, tipoResiduo, metodoReciclagem, quantidade, unidadeMedida, empresaDestinResiduo, situacaoCadastral);
		listaProduto.add(produto);
		InOut.OutMessage("Valores cadastrados com Sucesso!");
		try {
			ListaProduto();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// Captura o instante final
		long fim = System.nanoTime();
		
		//Tempo de execução
		long tempExecucao = fim - inicio;
		
		// Convertendo para segundos
		double convert = (double) tempExecucao / 1_000_000_000;
		
		tempExec.setText("<html> <span style='color: #6d6e71;'> O TEMPO DE EXECUÇÃO FOI: <b style='color: black; font-weight: bold;'>" + tempExecucao + " Nanos Segundos</b> CONVERTIDO: <b style='color: black; font-weight: bold; word-break: normal;'> " + String.format("%.2f", convert) + " Segundos </b> <span> </html>");
		
	}
	
	public void editar() {
		// Captura o instante inicial
		long inicio = System.nanoTime();
					
		for(int i=0; i < listaProduto.size(); i++){
			Produto produto = listaProduto.get(i);
			
			//System.out.print(getValorCodigo());
			int codigoAlterar = getValorCodigo();
			
			if(codigoAlterar == (produto.getCodigo())){
				String cnpjNovo = edit_tf1.getText();
				produto.setCnpj(cnpjNovo);
				String razaoSocialNovo = edit_tf2.getText();
				produto.setRazaoSocial(razaoSocialNovo);
				String estadoNovo = edit_tf3.getText();
				produto.setEstado(estadoNovo);
				String municipioNovo = edit_tf4.getText();
				produto.setMunicipio(municipioNovo);
				int anoNovo = Integer.parseInt(edit_tf5.getText());
				produto.setAno(anoNovo);
				String tipoResiduoNovo = edit_tf6.getText();
				produto.setTipoResiduo(tipoResiduoNovo);
				String metodoReciclagemNovo = edit_tf7.getText();
				produto.setMetodoReciclagem(metodoReciclagemNovo);
				int quantidadeNovo = Integer.parseInt(edit_tf8.getText());
				produto.setQuantidade(quantidadeNovo);
				String unidadeMedidaNovo = edit_tf9.getText();
				produto.setUnidadeMedida(unidadeMedidaNovo);
				String empresaDestinResiduoNovo = edit_tf10.getText();
				produto.setEmpresaDestinResiduo(empresaDestinResiduoNovo);
				String situacaoCadastralNovo = edit_tf11.getText();
				produto.setSituacaoCadastral(situacaoCadastralNovo);
				
				InOut.OutMessage("Valores editados com Sucesso!");  
				try {
					ListaProduto();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;				
			}
		}
		
		// Captura o instante final
		long fim = System.nanoTime();
		
		//Tempo de execução
		long tempExecucao = fim - inicio;
		
		// Convertendo para segundos
		double convert = (double) tempExecucao / 1_000_000_000;
		
		tempExec.setText("<html> <span style='color: #6d6e71;'> O TEMPO DE EXECUÇÃO FOI: <b style='color: black; font-weight: bold;'>" + tempExecucao + " Nanos Segundos</b> CONVERTIDO: <b style='color: black; font-weight: bold; word-break: normal;'> " + String.format("%.2f", convert) + " Segundos </b> <span> </html>");
		
	}
	
	public void deletar() {
		// Captura o instante inicial
		long inicio = System.nanoTime();
		
		int codigoDeletar = Integer.parseInt(exclui_tf1.getText());
		for(int i=0; i < listaProduto.size(); i++){
			Produto produto = listaProduto.get(i);
			
			if(codigoDeletar == (produto.getCodigo())){
				listaProduto.remove(i);
				InOut.OutMessage("Produto deletado com Sucesso!");
				try {
					ListaProduto();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;		
			}
		}
		
		// Captura o instante final
		long fim = System.nanoTime();
		
		//Tempo de execução
		long tempExecucao = fim - inicio;
		
		// Convertendo para segundos
		double convert = (double) tempExecucao / 1_000_000_000;
		
		tempExec.setText("<html> <span style='color: #6d6e71;'> O TEMPO DE EXECUÇÃO FOI: <b style='color: black; font-weight: bold;'>" + tempExecucao + " Nanos Segundos</b> CONVERTIDO: <b style='color: black; font-weight: bold; word-break: normal;'> " + String.format("%.2f", convert) + " Segundos </b> <span> </html>");
		
	}
	
	public void pesquisar() {
		// Captura o instante inicial
		long inicio = System.nanoTime();
		
		// aparecer paine p5
		int pesqCd = InOut.InInt("Insire o Código para Pesquisar:");
		setPesquisaCodigo(pesqCd);
		
		CardLayout cl = (CardLayout) pc.getLayout();		
		cl.show(pc, "np4");
		
		// Preencher campos
		String nomeArq = "entrada.txt";
		File arq = new File(nomeArq);
		
		if(arq.exists()){
			if(listaProduto.size() == 0){
				InOut.OutMessage("Lista Vazia");
				return;
			}
			
			int codigoProcurar = pesqCd;
			
			for(int i=0; i < listaProduto.size(); i++){
				Produto produto = listaProduto.get(i);
				
				if(codigoProcurar == (produto.getCodigo())){
					pesquise_tf1.setText(Integer.toString(produto.getCodigo()));
					pesquise_tf2.setText(produto.getCnpj());
					pesquise_tf3.setText(produto.getRazaoSocial());
					pesquise_tf4.setText(produto.getEstado());
					pesquise_tf5.setText(produto.getMunicipio());
					pesquise_tf6.setText(Integer.toString(produto.getAno()));
					pesquise_tf7.setText(produto.getTipoResiduo());
					pesquise_tf8.setText(produto.getMetodoReciclagem());
					pesquise_tf9.setText(Integer.toString(produto.getQuantidade()));
					pesquise_tf10.setText(produto.getUnidadeMedida());
					pesquise_tf11.setText(produto.getEmpresaDestinResiduo());
					pesquise_tf12.setText(produto.getSituacaoCadastral());							 
					//System.out.println(escreva);
					
					InOut.OutMessage("Valores encontrado com Sucesso!");
					break;
				}
			}
		}else{
			InOut.OutMessage("Arquivo inexistente", "ERRO");
		}
		
		// Captura o instante final
		long fim = System.nanoTime();
		
		//Tempo de execução
		long tempExecucao = fim - inicio;
		
		// Convertendo para segundos
		double convert = (double) tempExecucao / 1_000_000_000;
		
		tempExec.setText("<html> <span style='color: #6d6e71;'> O TEMPO DE EXECUÇÃO FOI: <b style='color: black; font-weight: bold;'>" + tempExecucao + " Nanos Segundos</b> CONVERTIDO: <b style='color: black; font-weight: bold; word-break: normal;'> " + String.format("%.2f", convert) + " Segundos </b> <span> </html>");
		
	}
	
	public void atualizaTabela() {
		// Captura o instante inicial
		long inicio = System.nanoTime();
					
		// Atualiza e Monta Tabela
		try {
			ListaProduto();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		montaTabela();	
		
		CardLayout cl = (CardLayout) pc.getLayout();
		cl.show(pc, "np0");
		
		// Captura o instante final
		long fim = System.nanoTime();
		
		//Tempo de execução
		long tempExecucao = fim - inicio;
		
		// Convertendo para segundos
		double convert = (double) tempExecucao / 1_000_000_000;
		
		tempExec.setText("<html> <span style='color: #6d6e71;'> O TEMPO DE EXECUÇÃO FOI: <b style='color: black; font-weight: bold;'>" + tempExecucao + " Nanos Segundos</b> CONVERTIDO: <b style='color: black; font-weight: bold; word-break: normal;'> " + String.format("%.2f", convert) + " Segundos </b> <span> </html>");
	
	}
	
	public void Bubblesort() throws IOException{	
		// Captura o instante inicial
		long inicio = System.nanoTime();
		
		/**
         * VAMOS CRIAR A LISTA DE INTEIROS ONDE VAMOS ARMAZENAR OS CODIGOS e ORDENAR (Bubblesort)
         */
		
		int qntCodigo = listaProduto.size();	
		
		// Armazena codigos
		int[] listCodigo = new int[qntCodigo];
			
		for(int i = 0; i < listaProduto.size(); i++){
			Produto prod = listaProduto.get(i);
			
			listCodigo[i] =  prod.getCodigo();
		}
		
		// Valores de saida inicial
		for(int i = 0; i < listCodigo.length; i++){
			
			System.out.print(listCodigo[i]);
			
		}
		
		// Ordenação por Troca (Bubblesort)
		 int aux;
		 boolean controle;
		 
		 for(int i = 0; i < listCodigo.length; ++i){
			 controle = true;
			 for(int j = 0; j < (listCodigo.length - 1); ++j){
			 
				 if(listCodigo[j] > listCodigo[j + 1]){
					 aux = listCodigo[j];
					 listCodigo[j] = listCodigo[j + 1];
					 listCodigo[j + 1] = aux;
					 controle = false;
				 }
			 }
			 
			 if(controle){
				 break;
			 }
		 
		 }
		 
		// Valores de saida final
		 for (int i = 0; i < listCodigo.length; ++i) {
			 System.out.println(listCodigo[i] + " ");
		 }
		 
		
		 // Passando os valores em ordenação
		 ArrayList<Produto> listOrdenada = new ArrayList<>();
		 
		
		// Preencher campos
		 for (int j = 0; j < listCodigo.length; ++j) {
			 
			for(int i = 0; i < listaProduto.size(); i++){
				Produto prod = listaProduto.get(i);
				 
				 if((listCodigo[j]) == prod.getCodigo()){
					 Produto produto = new Produto(prod.getCodigo(), prod.getCnpj(), prod.getRazaoSocial(), prod.getEstado(), prod.getMunicipio(), prod.getAno(), prod.getTipoResiduo(), prod.getMetodoReciclagem(), prod.getQuantidade(), prod.getUnidadeMedida(), prod.getEmpresaDestinResiduo(), prod.getSituacaoCadastral());
			    		
					 listOrdenada.add(produto);
			
				 
				 }
				 
				
			 }
		 }
			 		
		
		// Cria o arquivo Ordenação por Troca (Bubblesort)
		
		File arquivo = new File("bubblesort.txt");
		
		if(listOrdenada.isEmpty()){
			InOut.OutMessage("Nenhum Produto Cadastrado");
			return;
		}
		FileWriter arq1 = new FileWriter(arquivo, false);
		PrintWriter gravaArq = new PrintWriter(arq1);

		for(int i = 0; i < listOrdenada.size(); i++){
			Produto prod = listOrdenada.get(i);
			gravaArq.write(prod.getCodigo() + "; " + prod.getCnpj() + "; " + prod.getRazaoSocial() + "; " + prod.getEstado() + "; " + prod.getMunicipio() + "; " + prod.getAno() + "; " + prod.getTipoResiduo() + "; " + prod.getMetodoReciclagem() + "; " + prod.getQuantidade() + "; " + prod.getUnidadeMedida() + "; " + prod.getEmpresaDestinResiduo() + "; " + prod.getSituacaoCadastral() +"\n");
		}
		gravaArq.close();
		
		// Captura o instante final
		long fim = System.nanoTime();
		
		//Tempo de execução
		long tempExecucao = fim - inicio;
		
		// Convertendo para segundos
		double convert = (double) tempExecucao / 1_000_000_000;
		
		tempExec.setText("<html> <span style='color: #6d6e71;'> O TEMPO DE EXECUÇÃO FOI: <b style='color: black; font-weight: bold;'>" + tempExecucao + " Nanos Segundos</b> CONVERTIDO: <b style='color: black; font-weight: bold; word-break: normal;'> " + String.format("%.2f", convert) + " Segundos </b> <span> </html>");	
		
		
	}
	
	
	public void InsertionSort() throws IOException{		
		// Captura o instante inicial
		long inicio = System.nanoTime();
		
		/**
         * VAMOS CRIAR A LISTA DE INTEIROS ONDE VAMOS ARMAZENAR OS CODIGOS e ORDENAR (InsertionSort)
         */
		
		int qntCodigo = listaProduto.size();	
		
		// Armazena codigos
		int[] listCodigo = new int[qntCodigo];
			
		for(int i = 0; i < listaProduto.size(); i++){
			Produto prod = listaProduto.get(i);
			
			listCodigo[i] =  prod.getCodigo();
		}
		
		// Valores de saida inicial
		for(int i = 0; i < listCodigo.length; i++){
			
			System.out.print(listCodigo[i]);
			
		}
		
		// Ordenação por Inserção (InsertionSort)
		int jval; //j
	    int ival; //i
	    int key;

	    for (jval = 1; jval < listCodigo.length; jval++) {
	      key = listCodigo[jval];
	      for (ival = jval - 1; (ival >= 0) && (listCodigo[ival] > key); ival--) {
	    	  listCodigo[ival + 1] = listCodigo[ival];
	       }
	      listCodigo[ival + 1] = key;
	    }
		 
		// Valores de saida final
		 for (int i = 0; i < listCodigo.length; ++i) {
			 System.out.println(listCodigo[i] + " ");
		 }
		 
		
		 // Passando os valores em ordenação
		 ArrayList<Produto> listOrdenada = new ArrayList<>();
		 
		
		// Preencher campos
		 for (int j = 0; j < listCodigo.length; ++j) {
			 
			for(int i = 0; i < listaProduto.size(); i++){
				Produto prod = listaProduto.get(i);
				 
				 if((listCodigo[j]) == prod.getCodigo()){
					 Produto produto = new Produto(prod.getCodigo(), prod.getCnpj(), prod.getRazaoSocial(), prod.getEstado(), prod.getMunicipio(), prod.getAno(), prod.getTipoResiduo(), prod.getMetodoReciclagem(), prod.getQuantidade(), prod.getUnidadeMedida(), prod.getEmpresaDestinResiduo(), prod.getSituacaoCadastral());
			    		
					 listOrdenada.add(produto);
			
				 
				 }
				 
				
			 }
		 }
			 		
		
		// Cria o arquivo Ordenação por Inserção (InsertionSort)
		
		File arquivo = new File("insertionSort.txt");
		
		if(listOrdenada.isEmpty()){
			InOut.OutMessage("Nenhum Produto Cadastrado");
			return;
		}
		FileWriter arq1 = new FileWriter(arquivo, false);
		PrintWriter gravaArq = new PrintWriter(arq1);

		for(int i = 0; i < listOrdenada.size(); i++){
			Produto prod = listOrdenada.get(i);
			gravaArq.write(prod.getCodigo() + "; " + prod.getCnpj() + "; " + prod.getRazaoSocial() + "; " + prod.getEstado() + "; " + prod.getMunicipio() + "; " + prod.getAno() + "; " + prod.getTipoResiduo() + "; " + prod.getMetodoReciclagem() + "; " + prod.getQuantidade() + "; " + prod.getUnidadeMedida() + "; " + prod.getEmpresaDestinResiduo() + "; " + prod.getSituacaoCadastral() +"\n");
		}
		gravaArq.close();
		
		// Captura o instante final
		long fim = System.nanoTime();
		
		//Tempo de execução
		long tempExecucao = fim - inicio;
		
		// Convertendo para segundos
		double convert = (double) tempExecucao / 1_000_000_000;
		
		tempExec.setText("<html> <span style='color: #6d6e71;'> O TEMPO DE EXECUÇÃO FOI: <b style='color: black; font-weight: bold;'>" + tempExecucao + " Nanos Segundos</b> CONVERTIDO: <b style='color: black; font-weight: bold; word-break: normal;'> " + String.format("%.2f", convert) + " Segundos </b> <span> </html>");
				
		
		
	}
	
		 

	// Layout CRUD	
	// instanciando card layout
	JPanel pc = new JPanel();
	
	// instanciando outros paineis
	JPanel p0 = new JPanel();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	JPanel p5 = new JPanel();
	
	//Tempo de execução
	JLabel tempExec = new JLabel();
	
	// Titulos das telas
	String text_tf1 = "Campo de Cadastro";
	String text_tf2 = "Campo de Edição";
	String text_tf3 = "Campo de Deleção";
	String text_tf4 = "Campo de Pesquisa";
	String text_tf5 = "Campo de Arquivos";
	
	JLabel titulo_tf1 = new JLabel ("<html><span style='font-size:14px; color: #6d9eeb;'>"+text_tf1+"</span></html>");
	JLabel titulo_tf2 = new JLabel ("<html><span style='font-size:14px; color: #6d9eeb;'>"+text_tf2+"</span></html>");
	JLabel titulo_tf3 = new JLabel ("<html><span style='font-size:14px; color: #6d9eeb;'>"+text_tf3+"</span></html>");
	JLabel titulo_tf4 = new JLabel ("<html><span style='font-size:14px; color: #6d9eeb;'>"+text_tf4+"</span></html>");
	JLabel titulo_tf5 = new JLabel ("<html><span style='font-size:14px; color: #6d9eeb;'>"+text_tf5+"</span></html>");
	
	
	//Cadastrar
	JTextField tf1 = new JTextField ();
	JTextField tf2 = new JTextField ();
	JTextField tf3 = new JTextField ();
	JTextField tf4 = new JTextField ();
	JTextField tf5 = new JTextField ();
	JTextField tf6 = new JTextField ();
	JTextField tf7 = new JTextField ();
	JTextField tf8 = new JTextField ();
	JTextField tf9 = new JTextField ();
	JTextField tf10 = new JTextField ();
	JTextField tf11 = new JTextField ();
	JTextField tf12 = new JTextField ();
	
	JLabel lb1 = new JLabel("Código:");
	JLabel lb2 = new JLabel("CNPJ:");
	JLabel lb3 = new JLabel("Razão Social:");
	JLabel lb4 = new JLabel("Estado:");
	JLabel lb5 = new JLabel("Município:");
	JLabel lb6 = new JLabel("Ano:");
	JLabel lb7 = new JLabel("Tipo de Residuo:");
	JLabel lb8 = new JLabel("Metodo de Reciclagem:");
	JLabel lb9 = new JLabel("Quantidade:");
	JLabel lb10 = new JLabel("Unidade de Medida:");
	JLabel lb11 = new JLabel("Empresa de Destino do Residuo:");
	JLabel lb12 = new JLabel("Situação Cadastral:");
	JLabel lb13 = new JLabel("<html><span style='font-size:8px; color: red;'>" + "** Preencha todos os campos para realizar o cadastro!" +"</span></html>");
	
	
	//Editar	
	JTextField edit_tf1 = new JTextField ();
	JTextField edit_tf2 = new JTextField ();
	JTextField edit_tf3 = new JTextField ();
	JTextField edit_tf4 = new JTextField ();
	JTextField edit_tf5 = new JTextField ();
	JTextField edit_tf6 = new JTextField ();
	JTextField edit_tf7 = new JTextField ();
	JTextField edit_tf8 = new JTextField ();
	JTextField edit_tf9 = new JTextField ();
	JTextField edit_tf10 = new JTextField ();
	JTextField edit_tf11 = new JTextField ();
	
	
	JLabel edit_lb1 = new JLabel("CNPJ:");
	JLabel edit_lb2 = new JLabel("Razão Social:");
	JLabel edit_lb3 = new JLabel("Estado:");
	JLabel edit_lb4 = new JLabel("Município:");
	JLabel edit_lb5 = new JLabel("Ano:");
	JLabel edit_lb6 = new JLabel("Tipo de Residuo:");
	JLabel edit_lb7 = new JLabel("Metodo de Reciclagem:");
	JLabel edit_lb8 = new JLabel("Quantidade:");
	JLabel edit_lb9 = new JLabel("Unidade de Medida:");
	JLabel edit_lb10 = new JLabel("Empresa de Destino do Residuo:");
	JLabel edit_lb11 = new JLabel("Situação Cadastral:");
	
	//Excluir
	JTextField exclui_tf1 = new JTextField ();
	
	JLabel exclui_lb1 = new JLabel("Código:");

	
	//Pesquisar
	JLabel pesquise_lb1 = new JLabel("Código:");
	JLabel pesquise_lb2 = new JLabel("CNPJ:");
	JLabel pesquise_lb3 = new JLabel("Razão Social:");
	JLabel pesquise_lb4 = new JLabel("Estado:");
	JLabel pesquise_lb5 = new JLabel("Município:");
	JLabel pesquise_lb6 = new JLabel("Ano:");
	JLabel pesquise_lb7 = new JLabel("Tipo de Residuo:");
	JLabel pesquise_lb8 = new JLabel("Metodo de Reciclagem:");
	JLabel pesquise_lb9 = new JLabel("Quantidade:");
	JLabel pesquise_lb10 = new JLabel("Unidade de Medida:");
	JLabel pesquise_lb11 = new JLabel("Empresa de Destino do Residuo:");
	JLabel pesquise_lb12 = new JLabel("Situação Cadastral:");
	
	JTextField pesquise_tf1 = new JTextField ();
	JTextField pesquise_tf2 = new JTextField ();
	JTextField pesquise_tf3 = new JTextField ();
	JTextField pesquise_tf4 = new JTextField ();
	JTextField pesquise_tf5 = new JTextField ();
	JTextField pesquise_tf6 = new JTextField ();
	JTextField pesquise_tf7 = new JTextField ();
	JTextField pesquise_tf8 = new JTextField ();
	JTextField pesquise_tf9 = new JTextField ();
	JTextField pesquise_tf10 = new JTextField ();
	JTextField pesquise_tf11 = new JTextField ();
	JTextField pesquise_tf12 = new JTextField ();
		
	// Botões
	String text_b1 = "Cadastrar";
	String text_b2= "Cancelar";
	String text_b3 = "Editar";
	String text_b4 = "Deletar";
	String text_b5 = "Pesquisar";
	String text_b6 = "Atualizar";
	String text_b7 = "Gerar";

	
	JButton b1 = new JButton("<html><span style='color: green;'>"+text_b1+"</span></html>");
	JButton b2 = new JButton("<html><span style='color: red;'>"+text_b2+"</span></html>");
	JButton b3 = new JButton("<html><span style='color: green;'>"+text_b3+"</span></html>");
	JButton b4 = new JButton("<html><span style='color: red;'>"+text_b2+"</span></html>");
	JButton b5 = new JButton("<html><span style='color: green;'>"+text_b4+"</span></html>");
	JButton b6 = new JButton("<html><span style='color: red;'>"+text_b2+"</span></html>");
	JButton b7 = new JButton("<html><span style='color: green;'>"+text_b5+"</span></html>");
	JButton b8 = new JButton("<html><span style='color: red;'>"+text_b2+"</span></html>");
	JButton b9 = new JButton("<html><span style='color: green;'>"+text_b6+"</span></html>");
	JButton b10 = new JButton("<html><span style='color: green;'>"+text_b7+"</span></html>");
	JButton b11 = new JButton("<html><span style='color: red;'>"+text_b2+"</span></html>");
	JButton b12 = new JButton("<html><span style='color: green;'>"+text_b7+"</span></html>");
	JButton b13 = new JButton("<html><span style='color: red;'>"+text_b2+"</span></html>");
	
	//Pesquisar
	JLabel arq_lb1 = new JLabel("Gerar Arquivo de Ordenação por troca:");
	JLabel arq_lb2 = new JLabel("Gerar Arquivo de Ordenação por inserção:");
	
	
	// Elementos da Tabela (Listar):
	JTable jt;
	DefaultTableModel dtm;
	JScrollPane jsPane = new JScrollPane();
			
	

	
	public void montarTela() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 700);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		// utilizando bordelayout
		this.setTitle("Produtos Reciclados");
		
		// gerando menus
		this.setJMenuBar(jmb);
		jmb.add(jm1);
		jmb.add(jm2);
		jm1.add(jmi1);
		jm1.add(jmi2);
		jm1.add(jmi3);
		jm1.add(jmi4);
		jm1.add(jmi5);		
		jm2.add(jmi6);
		jm1.add(jmi7);

		// ligando os itens de menu
		jmi1.addActionListener(this);
		jmi2.addActionListener(this);
		jmi3.addActionListener(this);
		jmi4.addActionListener(this);
		jmi5.addActionListener(this);
		jmi6.addActionListener(this);	
		jmi7.addActionListener(this);
	
		p1.setLayout(null);
		
		this.add(pc, BorderLayout.CENTER);
		this.add(tempExec, BorderLayout.SOUTH);
				
		
		p1.add(b1);
		p1.add(b2);
		
		p1.add(titulo_tf1);
		
		p1.add(tf1);
		p1.add(tf2);
		p1.add(tf3);
		p1.add(tf4);
		p1.add(tf5);
		p1.add(tf6);
		p1.add(tf7);
		p1.add(tf8);
		p1.add(tf9);
		p1.add(tf10);
		p1.add(tf11);
		p1.add(tf12);
		
		p1.add(lb1);
		p1.add(lb2);
		p1.add(lb3);
		p1.add(lb4);
		p1.add(lb5);
		p1.add(lb6);
		p1.add(lb7);
		p1.add(lb8);
		p1.add(lb9);
		p1.add(lb10);
		p1.add(lb11);
		p1.add(lb12);
		p1.add(lb13);
		
		// dimensionando
		titulo_tf1.setBounds(200, 0, 190, 25);
		b1.setBounds(20, 530, 110, 25);
		b2.setBounds(150, 530, 110, 25);
		
		// cadastrar
		lb1.setBounds(20, 30, 190, 25);
		tf1.setBounds(220, 30, 250, 25);
		lb2.setBounds(20, 70, 190, 25);
		tf2.setBounds(220, 70, 250, 25);
		lb3.setBounds(20, 110, 190, 25);
		tf3.setBounds(220, 110, 250, 25);
		lb4.setBounds(20, 150, 190, 25);
		tf4.setBounds(220, 150, 250, 25);
		lb5.setBounds(20, 190, 190, 25);
		tf5.setBounds(220, 190, 250, 25);
		lb6.setBounds(20, 230, 190, 25);
		tf6.setBounds(220, 230, 250, 25);
		lb7.setBounds(20, 270, 190, 25);
		tf7.setBounds(220, 270, 250, 25);
		lb8.setBounds(20, 310, 190, 25);
		tf8.setBounds(220, 310, 250, 25);
		lb9.setBounds(20, 350, 190, 25);
		tf9.setBounds(220, 350, 250, 25);
		lb10.setBounds(20, 390, 190, 25);
		tf10.setBounds(220, 390, 250, 25);
		lb11.setBounds(20, 430, 190, 25);
		tf11.setBounds(220, 430, 250, 25);
		lb12.setBounds(20, 470, 190, 25);
		tf12.setBounds(220, 470, 250, 25);
		
		lb13.setBounds(20, 500, 300, 25);

		b1.addActionListener(this);
		b2.addActionListener(this);
		
		b3.addActionListener(this);
		b4.addActionListener(this);
		
		b5.addActionListener(this);
		b6.addActionListener(this);
		
		b7.addActionListener(this);
		b8.addActionListener(this);
		
		b9.addActionListener(this);	
		
		b10.addActionListener(this);
		b11.addActionListener(this);		
		b12.addActionListener(this);
		b13.addActionListener(this);
		
		// Chamando e montando a tebela
		montaTabela();
		
		jsPane.setPreferredSize(new java.awt.Dimension(500, 500));
		
		// painel 0
		p0.add(jsPane);	
		p0.add(b9);
		
		// dimensionando
		b9.setBounds(20, 500, 110, 25);
	
		
		// painel 2
		p2.setLayout(null);
		
		
		p2.add(b3);
		p2.add(b4);
		
		p2.add(titulo_tf2);
		
		p2.add(edit_tf1);
		p2.add(edit_tf2);
		p2.add(edit_tf3);
		p2.add(edit_tf4);
		p2.add(edit_tf5);
		p2.add(edit_tf6);
		p2.add(edit_tf7);
		p2.add(edit_tf8);
		p2.add(edit_tf9);
		p2.add(edit_tf10);
		p2.add(edit_tf11);
		
		p2.add(edit_lb1);
		p2.add(edit_lb2);
		p2.add(edit_lb3);
		p2.add(edit_lb4);
		p2.add(edit_lb5);
		p2.add(edit_lb6);
		p2.add(edit_lb7);
		p2.add(edit_lb8);
		p2.add(edit_lb9);
		p2.add(edit_lb10);
		p2.add(edit_lb11);
		
		// dimensionando
		titulo_tf2.setBounds(200, 0, 190, 25);
		
		b3.setBounds(20, 500, 110, 25);
		b4.setBounds(150, 500, 110, 25);
		
		// editar
		edit_lb1.setBounds(20, 30, 190, 25);
		edit_tf1.setBounds(220, 30, 250, 25);
		edit_lb2.setBounds(20, 70, 190, 25);
		edit_tf2.setBounds(220, 70, 250, 25);
		edit_lb3.setBounds(20, 110, 190, 25);
		edit_tf3.setBounds(220, 110, 250, 25);
		edit_lb4.setBounds(20, 150, 190, 25);
		edit_tf4.setBounds(220, 150, 250, 25);
		edit_lb5.setBounds(20, 190, 190, 25);
		edit_tf5.setBounds(220, 190, 250, 25);
		edit_lb6.setBounds(20, 230, 190, 25);
		edit_tf6.setBounds(220, 230, 250, 25);
		edit_lb7.setBounds(20, 270, 190, 25);
		edit_tf7.setBounds(220, 270, 250, 25);
		edit_lb8.setBounds(20, 310, 190, 25);
		edit_tf8.setBounds(220, 310, 250, 25);
		edit_lb9.setBounds(20, 350, 190, 25);
		edit_tf9.setBounds(220, 350, 250, 25);
		edit_lb10.setBounds(20, 390, 190, 25);
		edit_tf10.setBounds(220, 390, 250, 25);
		edit_lb11.setBounds(20, 430, 190, 25);
		edit_tf11.setBounds(220, 430, 250, 25);

		// painel 3
		p3.setLayout(null);
		
		p3.add(b5);
		p3.add(b6);
		
		p3.add(exclui_tf1);	
		p3.add(exclui_lb1);
		
		p3.add(titulo_tf3);
		
		
		// dimensionando
		titulo_tf3.setBounds(200, 0, 190, 25);
		
		b5.setBounds(20, 100, 110, 25);
		b6.setBounds(150, 100, 110, 25);
		
		// excluir
		exclui_lb1.setBounds(20, 30, 190, 25);
		exclui_tf1.setBounds(220, 30, 250, 25);		
		
		
		// painel 4
		p4.setLayout(null);
		
		p4.add(b7);
		p4.add(b8);
		
		p4.add(titulo_tf4);
		
		p4.add(pesquise_lb1);
		p4.add(pesquise_lb2);
		p4.add(pesquise_lb3);
		p4.add(pesquise_lb4);
		p4.add(pesquise_lb5);
		p4.add(pesquise_lb6);
		p4.add(pesquise_lb7);
		p4.add(pesquise_lb8);
		p4.add(pesquise_lb9);
		p4.add(pesquise_lb10);
		p4.add(pesquise_lb11);
		p4.add(pesquise_lb12);
		
		p4.add(pesquise_tf1);
		p4.add(pesquise_tf2);
		p4.add(pesquise_tf3);
		p4.add(pesquise_tf4);
		p4.add(pesquise_tf5);
		p4.add(pesquise_tf6);
		p4.add(pesquise_tf7);
		p4.add(pesquise_tf8);
		p4.add(pesquise_tf9);
		p4.add(pesquise_tf10);
		p4.add(pesquise_tf11);
		p4.add(pesquise_tf12);
		
		// dimensionando
		titulo_tf4.setBounds(200, 0, 190, 25);
		
		b7.setBounds(20, 530, 110, 25);
		b8.setBounds(150, 530, 110, 25);
		
		// pesquisa			
		pesquise_lb1.setBounds(20, 30, 190, 25);
		pesquise_tf1.setBounds(220, 30, 250, 25);
		pesquise_lb2.setBounds(20, 70, 190, 25);
		pesquise_tf2.setBounds(220, 70, 250, 25);
		pesquise_lb3.setBounds(20, 110, 190, 25);
		pesquise_tf3.setBounds(220, 110, 250, 25);
		pesquise_lb4.setBounds(20, 150, 190, 25);
		pesquise_tf4.setBounds(220, 150, 250, 25);
		pesquise_lb5.setBounds(20, 190, 190, 25);
		pesquise_tf5.setBounds(220, 190, 250, 25);
		pesquise_lb6.setBounds(20, 230, 190, 25);
		pesquise_tf6.setBounds(220, 230, 250, 25);
		pesquise_lb7.setBounds(20, 270, 190, 25);
		pesquise_tf7.setBounds(220, 270, 250, 25);
		pesquise_lb8.setBounds(20, 310, 190, 25);
		pesquise_tf8.setBounds(220, 310, 250, 25);
		pesquise_lb9.setBounds(20, 350, 190, 25);
		pesquise_tf9.setBounds(220, 350, 250, 25);
		pesquise_lb10.setBounds(20, 390, 190, 25);
		pesquise_tf10.setBounds(220, 390, 250, 25);
		pesquise_lb11.setBounds(20, 430, 190, 25);
		pesquise_tf11.setBounds(220, 430, 250, 25);
		pesquise_lb12.setBounds(20, 470, 190, 25);
		pesquise_tf12.setBounds(220, 470, 250, 25);
		
		
		// painel 4
		p5.setLayout(null);
		
		p5.add(b10);
		p5.add(b11);
		p5.add(arq_lb1);
		
		p5.add(b12);
		p5.add(b13);
		p5.add(arq_lb2);
		
		p5.add(titulo_tf5);
		
		
		
		// dimensionando
		titulo_tf5.setBounds(200, 0, 190, 25);
		
		b10.setBounds(20, 80, 110, 25);
		b11.setBounds(150, 80, 110, 25);
		
		b12.setBounds(20, 240, 110, 25);
		b13.setBounds(150, 240, 110, 25);
		
		// gerar arquivos
		arq_lb1.setBounds(20, 30, 300, 25);
		
		arq_lb2.setBounds(20, 180, 300, 25);
	

		
		// montando card layout
		pc.setLayout(new CardLayout());
		pc.add(p0, "np0");
		pc.add(p1, "np1");
		pc.add(p2, "np2");
		pc.add(p3, "np3");
		pc.add(p4, "np4");
		pc.add(p5, "np5");
		
			
		this.setVisible(true);
	}

	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();	
		
		
		if(o.equals(jmi1)) {
			// Montando Tabela
			montaTabela();		
			
			CardLayout cl = (CardLayout) pc.getLayout();
			cl.show(pc, "np0");
			
		} else if(o.equals(jmi2)) {
			// aparecer paine p2
			CardLayout cl = (CardLayout) pc.getLayout();
			cl.show(pc, "np1");
			
		} else if(o.equals(jmi3)) {
			montaEditar();
			
		} else if(o.equals(jmi4)) {
			// aparecer paine p4
			CardLayout cl = (CardLayout) pc.getLayout();		
			cl.show(pc, "np3");
			
		} else if(o.equals(jmi5)) {
			montaPesquisar();				
			
		} else if(o.equals(jmi6)) {
			System.exit(0);
			
		} else if(o.equals(jmi7)) {
			CardLayout cl = (CardLayout) pc.getLayout();		
			cl.show(pc, "np5");
			
		} else if(o.equals(b1)) {
			cadastrar();
			
		} else if(o.equals(b3)) {	
			editar();
			
		} else if(o.equals(b5)) {
			deletar();
			
		} else if(o.equals(b7)) {
			pesquisar();
			
		} else if(o.equals(b2)) {
			CardLayout cl = (CardLayout) pc.getLayout();
			cl.show(pc, "np0");
			
		} else if(o.equals(b4)) {
			CardLayout cl = (CardLayout) pc.getLayout();
			cl.show(pc, "np0");
			
		} else if(o.equals(b6)) {
			CardLayout cl = (CardLayout) pc.getLayout();
			cl.show(pc, "np0");
			
		} else if(o.equals(b8)) {
			CardLayout cl = (CardLayout) pc.getLayout();
			cl.show(pc, "np0");	
			
		} else if(o.equals(b11)) {
			CardLayout cl = (CardLayout) pc.getLayout();
			cl.show(pc, "np0");
			
		} else if(o.equals(b13)) {
			CardLayout cl = (CardLayout) pc.getLayout();
			cl.show(pc, "np0");
			
		} else if(o.equals(b9)) {			
			atualizaTabela();
			
		} else if(o.equals(b10)) {			
			// Gerando arquivo de saida Ordenação por troca
			try {					
				Bubblesort();					
				InOut.OutMessage("Arquivo de Saída gerado com Sucesso!");
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}		
			
		} else if(o.equals(b12)) {			
			// Gerando arquivo de saida Ordenação por inserção
			try {			
				InsertionSort();
				InOut.OutMessage("Arquivo de Saída gerado com Sucesso!");
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
					
		} else {
			System.out.print("vazio");
		}


	}



	// Para set e get dos valores do Edita
	private int valorCodigo;
	
	public int getValorCodigo() {
		return valorCodigo;
	}

	public void setValorCodigo(int valorCodigo) {
		this.valorCodigo = valorCodigo;
	}

	
	// Para set e get dos valores do Pesquisa
	private int pesquisaCodigo;
	
	public int getPesquisaCodigo() {
		return pesquisaCodigo;
	}

	public void setPesquisaCodigo(int pesquisaCodigo) {
		this.pesquisaCodigo = pesquisaCodigo;
	}

	
	
	
}

