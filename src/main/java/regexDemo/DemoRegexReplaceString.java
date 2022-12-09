package regexDemo;

import java.util.regex.*; 


public class DemoRegexReplaceString {
	public static void main(String args[]){  
		//1st way  
		
		String inputText = "https://google.com/abc/somecoolstuff/per?";
		String replaceByText = "rohit.kumar.io";
		
		Pattern p = Pattern.compile("google.com.abc");//. represents single character  
		Matcher m = p.matcher(inputText);  
		boolean b = m.find();
		
		String replacedStringOutput = m.replaceAll(replaceByText);
		  
		System.out.println(replacedStringOutput);
		  
		System.out.println(inputText);  
		}
}
