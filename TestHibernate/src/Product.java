// default package
// Generated Jun 14, 2013 4:44:22 PM by Hibernate Tools 4.0.0

/**
 * Product generated by hbm2java
 */
public class Product implements java.io.Serializable {

	private Integer id;
	private String name;
	private String category;
	private Long price;

	public Product() {
	}

	public Product(String name, String category, Long price) {
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getPrice() {
		return this.price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

}
