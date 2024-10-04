package entities;

public class Product {
	private Integer code;
	private String name;
	private Double price;
	private Double stockQuantity;
	private String description;
	private String category;
	
	public Product(Integer id, String name, Double price, Double quantity, String description, String category) {
		this.code = id;
		this.name = name;
		this.price = price;
		this.stockQuantity = quantity;
		this.description = description;
		this.category = category;
	}

	public Integer getCode() {
		return code;
	}

	public void setId(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getStockQuantity() {
		return stockQuantity;
	}

	public void setQuantity(Double stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public void updatePrice(double newPrice) {
		this.price = newPrice;
	}
	
	public void updateQuantity(double newQuantity) {
		this.stockQuantity = newQuantity;
	}

}
