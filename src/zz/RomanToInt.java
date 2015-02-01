//zz reviewed
package zz;

public class RomanToInt {
	public int romanToInt(String s) {
		if(s==null || s.length()==0){
			return 0;
		}
		int pre=0;
		int sum=0;
		for(int i=s.length()-1;i>=0;i--){
			int cur=getLetterValue(s.charAt(i));
			if(cur>=pre){
				sum+=cur;
			}
			else{
				sum-=cur;
			}
			pre=cur;
		}
		//zz   assert value>=1 && value <= 3999;
		return sum;		
	}
	public int getLetterValue(char c){
		switch(c){//zz no {} needed
		case 'I':{
			return 1;
		}
		case 'V':{
			return 5;
		}
		case 'X':{
			return 10;
		}
		case 'L':{
			return 50;
		}
		case 'C':{
			return 100;
		}
		case 'D':{
			return 500;
		}
		case 'M':{
			return 1000;
		}
		default:{
			return 0;
		}
		}
	}
}
