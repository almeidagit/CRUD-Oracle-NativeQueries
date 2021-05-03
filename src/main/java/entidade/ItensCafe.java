package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ITENS_CAFE")
public class ItensCafe {
	
	@Id
	@Column(name = "ID_ITEM", nullable = false)
	@GeneratedValue(generator = "S_ID_ITEM")
	@SequenceGenerator(name = "S_ID_ITEM", sequenceName = "S_ID_ITEM", allocationSize = 1)
	private int item_id_pk;
	
	@Column(name = "ITEM_CAFE", nullable = false)
	private String item_cafe;
	
	@ManyToOne
	@JoinColumn(name = "CPF_FUNC", referencedColumnName = "CPF", nullable = false)
	private Funcionario funcionario;

	public int getItem_id_pk() {
		return item_id_pk;
	}

	public void setItem_id_pk(int item_id_pk) {
		this.item_id_pk = item_id_pk;
	}

	public String getItem_cafe() {
		return item_cafe;
	}

	public void setItem_cafe(String item_cafe) {
		this.item_cafe = item_cafe;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
