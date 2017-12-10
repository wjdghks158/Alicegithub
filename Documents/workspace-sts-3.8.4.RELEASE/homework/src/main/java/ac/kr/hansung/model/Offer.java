package ac.kr.hansung.model;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Offer {
	@Size(min=2, max=100, message="ID must be between 2  and 100 chars ")
	private String id;
	
	private String password;
	private String name;
	private String email;

}
