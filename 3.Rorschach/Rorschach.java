/****************************************************
******** author: Enrique Perez Soler ****************
**** course: DD1380 - Java for Python Programmers ***
****************************************************/

import java.util.Scanner;
import java.util.ArrayList;

public class Roscharch {

        public static void main(String[] args){

            Scanner scan = new Scanner(System.in);

            Integer lines = scan.nextInt();
            Integer columns = scan.nextInt();

            scan.nextLine();

            Boolean complies = true;

            for(Integer i = 0; i < lines && complies; i++){//0. We do the following for every line while complies is true (no line is symmetric) 

                String theLine = scan.nextLine(); //1. Read the row

                Integer middleIndex = columns%2 == 1 ? (columns + 1)/2 - 1 : columns/2 - 1;
				//2. Count the number of columns and depending on if its odd or even we calculate the middleindex

                String left = theLine.substring(0, middleIndex + 1);//3. save the left substring of the line in left
                String right = "";

                Integer middleIndexPivot = columns%2 == 1 ? middleIndex : middleIndex + 1;
				//4. Calculate the middleIndexPivot if its odd or even

				//5. We loop backwards from the end of the line to save the right side
                for(Integer j = columns-1; j >= middleIndexPivot; j--){
                    right += theLine.charAt(j);
                }
				
				//6. We then compare them both easily
                if(!left.equals(right)){
                    complies = false;
                }

            }

            String result = complies ? "Ja" : "Nej";
            System.out.println(result);

        }
}