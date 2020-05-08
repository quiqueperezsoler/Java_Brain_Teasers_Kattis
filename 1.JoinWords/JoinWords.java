/****************************************************
******** author: Enrique Perez Soler ****************
**** course: DD1380 - Java for Python Programmers ***
****************************************************/

import java.util.Scanner;

public class JoinWords {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
		String result = "";   
		Integer wordCount = Integer.parseInt(scan.nextLine());
		//long wordCount = scan.nextLong();
        
		for(Integer i = 0; i < wordCount; i++){
		  //result.concat(scan.nextLine());
		  String theLine = scan.nextLine();
		  //result += theLine;
		  System.out.print(theLine.replaceAll(" ", ""));
		}

		scan.close();
		System.out.println();  
  }
}