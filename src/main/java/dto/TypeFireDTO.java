package dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("TypeFire")
public class TypeFireDTO {

	@Id
	public String id;
	
	public String name;

	public int number;
	
	public TypeFireDTO() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumner() {
		return number;
	}

	public void setNumner(int number) {
		this.number = number;
	}

}
