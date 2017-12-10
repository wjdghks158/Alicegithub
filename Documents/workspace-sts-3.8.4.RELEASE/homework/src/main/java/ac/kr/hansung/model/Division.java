package ac.kr.hansung.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Division {
	private int a;	// <th>교필</th>
	private int b;  // <th>토대</th>
	private int c;  // <th>인재</th>
	
	private int d;	//  <th>핵교A</th>
	private int e;  // <th>핵교B</th>
	private int f;  // <th>전지</th>
	
	private int g;	  //  <th>전선</th>
	private int h;  //  <th>전기</th>
	private int i;  // <th>일교</th>
	
	private int j;	// <th>인재</th>
	private int k;  // <th>자율</th>
	private int sum;  //   <th>총학점</th>
	
}
