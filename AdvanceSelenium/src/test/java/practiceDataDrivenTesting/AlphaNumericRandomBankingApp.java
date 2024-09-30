package practiceDataDrivenTesting;

public class AlphaNumericRandomBankingApp {
	public static void main(String[] args) {
		//limit we setting
		int n=20;
		////choose a character random from this string
	    String AlphaNumericString="ASDFGHJKLXCVBasdfghjwertyucvb123456789789954123225";
	    //create String Builder size of AlphaNumericString
	    StringBuilder sb=new StringBuilder(n);
	    
		for(int i=0;i<=n;i++)
		{
			// generate a random number between 0 to AlphaNumericString variable length
			int index =(int)(AlphaNumericString.length()*Math.random());
			
			//add character one in end of sb
			sb.append(AlphaNumericString.charAt(index));
			 
		}
		System.out.println(sb);
	}

}
