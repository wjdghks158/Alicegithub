package ac.kr.hansung.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Lecture {
	private int year;
	private int semester;
	private String code;
	private String course;
	private String division;
	private int grades;

}

