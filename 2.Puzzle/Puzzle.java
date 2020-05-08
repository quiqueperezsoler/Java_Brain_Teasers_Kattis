/****************************************************
******** author: Enrique Perez Soler ****************
**** course: DD1380 - Java for Python Programmers ***
****************************************************/

import java.util.Scanner;
import java.lang.Math;
import java.math.BigInteger;
import java.math.BigDecimal;

public class Puzzle {

        public static void main(String[] args){

                Scanner scan = new Scanner(System.in);

                Integer x = scan.nextInt();
                Integer y = scan.nextInt();

                //OLD: Integer edgePieces = 2*x + 2*y - 4;
                Integer edgePieces = x == 1 || y == 1 ? x*y : 2*x + 2*y - 4;
                Integer innerPieces = (x-2) * (y-2); //x=columns, y=rows

                Double secondsEdge = 0.0;
                Double secondsInner = 0.0;    

                for(Integer i = 1; i <= edgePieces; i++){
                        secondsEdge += Math.pow(1.001,i);
                }
                
                if(x > 2 && y > 2){ //there are only innerPieces if there are more than 2 rows AND columns
                    for(Integer i = 1; i <= innerPieces; i++){
                        secondsInner += Math.pow(1.01,i);
                    }
                }

                BigInteger bigSecongsEdge = BigDecimal.valueOf(secondsEdge).toBigInteger();
                BigInteger bigSecongsInner = BigDecimal.valueOf(secondsInner).toBigInteger();

                BigInteger bigSeconds = bigSecongsEdge.add(bigSecongsInner);

                BigInteger years = bigSeconds.divide(BigInteger.valueOf(365*24*60*60));
				
                bigSeconds = bigSeconds.mod(BigInteger.valueOf(365*24*60*60));
				
                BigInteger days = bigSeconds.divide(BigInteger.valueOf(24*60*60));
				
                bigSeconds = bigSeconds.mod(BigInteger.valueOf(24*60*60));
				
                BigInteger hours = bigSeconds.divide(BigInteger.valueOf(60*60));
				
                bigSeconds = bigSeconds.mod(BigInteger.valueOf(60*60));
				
                BigInteger minutes = bigSeconds.divide(BigInteger.valueOf(60));
				
                bigSeconds = bigSeconds.mod(BigInteger.valueOf(60));

                System.out.println(years + " " + days + " " + hours + " " + minutes + " " + bigSeconds);

        }
}