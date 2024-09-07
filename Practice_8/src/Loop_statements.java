
public class Loop_statements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		
		while(i <= 20) {
			if(i == 10) continue;// used to skip current iteration
			i++;
			System.out.println(i);
		}
		
		i = 0;
		
		do {
			if(i == 10 ) break;// used to break the inner most loop the break is used loop
			i++;
			System.out.println(i);
		}while(i <= 20);
		
		for(int j = 0; j <= 10; j++) {
			System.out.println(j);
		}
		
		for(int j = 0, k = 0, l = 0, m = 0; j <= 10; j++, k ++, l ++, m ++) {// multiple initialization is also possible
			System.out.println("" + j + k + l + m);
		}
	}

}
