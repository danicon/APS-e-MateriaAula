package control;
import model.Aluno;
import model.AlunoDAO;
import view.TelaAluno;

public class CtrlTelaAluno {

	public void insert (TelaAluno ta) {
		// Gerando o JavaBean
		Aluno al = new Aluno();
		al.setId(Long.parseLong(ta.tfId.getText()));
		al.setNome(ta.tfNome.getText());
		al.setRa(ta.tfRa.getText());
		al.setIdade(Integer.parseInt(ta.tfIdade.getText()));
		// Enviando o JavaBean para o AlunoDAO
		AlunoDAO alDao = new AlunoDAO();
		alDao.insert(al);
	}

	public void update (TelaAluno ta) {
		// Gerando o JavaBean
		Aluno al = new Aluno();
		al.setId(Long.parseLong(ta.tfId.getText()));
		al.setNome(ta.tfNome.getText());
		al.setRa(ta.tfRa.getText());
		al.setIdade(Integer.parseInt(ta.tfIdade.getText()));
		// Enviando o JavaBean para o AlunoDAO
		AlunoDAO alDao = new AlunoDAO();
		alDao.update(al);
	}

	public void delete (TelaAluno ta) {
		// Gerando o JavaBean
		Aluno al = new Aluno();
		al.setId(Long.parseLong(ta.tfId.getText()));
		// Enviando o JavaBean para o AlunoDAO
		AlunoDAO alDao = new AlunoDAO();
		alDao.delete(al);
	}

	public void select (TelaAluno ta) {
		int id = Integer.parseInt(ta.tfId.getText());
		Aluno al = new Aluno();
		al.setId(id);
		AlunoDAO alDao = new AlunoDAO();
		alDao.select(al);
		// ...logo em seguida
		// .. preencher a tela
		ta.tfNome.setText(al.getNome());
		ta.tfRa.setText(al.getRa());
		ta.tfIdade.setText(Integer.toString(al.getIdade()));
	}

}
