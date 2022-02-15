package produto;

public class Produto {
	private int codigo;
	private String cnpj;
	private String razaoSocial;
	private String estado;
	private String municipio;
	private int ano;
	private String tipoResiduo;
	private String metodoReciclagem;
	private int quantidade;
	private String unidadeMedida;
	private String empresaDestinResiduo;
	private String situacaoCadastral;
	
	
	//11 colunas e valores
	public Produto(int codigo, String cnpj, String razaoSocial, String estado, String municipio, int ano, String tipoResiduo, String metodoReciclagem, int quantidade, String unidadeMedida, String empresaDestinResiduo, String situacaoCadastral){			
		this.codigo = codigo;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.estado = estado;
		this.municipio = municipio;
		this.ano = ano;
		this.tipoResiduo = tipoResiduo;
		this.metodoReciclagem = metodoReciclagem;
		this.quantidade = quantidade;
		this.unidadeMedida = unidadeMedida;
		this.empresaDestinResiduo = empresaDestinResiduo;
		this.situacaoCadastral = situacaoCadastral;
	}
	
	
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getTipoResiduo() {
		return tipoResiduo;
	}

	public void setTipoResiduo(String tipoResiduo) {
		this.tipoResiduo = tipoResiduo;
	}

	public String getMetodoReciclagem() {
		return metodoReciclagem;
	}

	public void setMetodoReciclagem(String metodoReciclagem) {
		this.metodoReciclagem = metodoReciclagem;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public String getEmpresaDestinResiduo() {
		return empresaDestinResiduo;
	}

	public void setEmpresaDestinResiduo(String empresaDestinResiduo) {
		this.empresaDestinResiduo = empresaDestinResiduo;
	}

	public String getSituacaoCadastral() {
		return situacaoCadastral;
	}

	public void setSituacaoCadastral(String situacaoCadastral) {
		this.situacaoCadastral = situacaoCadastral;
	}
	

	
}
