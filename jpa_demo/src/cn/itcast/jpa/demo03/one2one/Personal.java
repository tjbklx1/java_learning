package cn.itcast.jpa.demo03.one2one;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Personal {

	private Integer id;
	private String name;
	private IDCard idcard;

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 10, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "idcard_id")
	public IDCard getIdcard() {
		return idcard;
	}

	public void setIdcard(IDCard idcard) {
		this.idcard = idcard;
	}

	public Personal(String name) {
		this.name = name;
	}
	
	public Personal() {
	}
}
