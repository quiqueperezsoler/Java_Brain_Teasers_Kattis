import java.util.Scanner;
/****************************************************
******** author: Enrique Perez Soler ****************
**** course: DD1380 - Java for Python Programmers ***
****************************************************/

import java.util.ArrayList;

public class Enigma {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
    
        String codex = scan.nextLine();
        String message = scan.nextLine();

        Integer maxOffset = codex.length() - message.length() + 1; //1. calculate max offset

        ArrayList<Integer> result = new ArrayList<Integer>();

        for(Integer offset = 0; offset < maxOffset; offset++){

            Boolean discarded = false;

            for(Integer i = 0; i < message.length() && !discarded; i++){ //while discarded is false
                Character encryptedCharacter = codex.charAt(i+offset);
                Character plainCharacter = message.charAt(i);
                if(encryptedCharacter.equals(plainCharacter)){//while they aren't the same we continue
                    discarded = true;//OH NO! It doesn't work.
                }
            }

            if(!discarded){//If discarded is false
                result.add(offset+1);
            }//Else we continue with a new offset and discarded reinitiated to false

        }
        if(result.isEmpty()){
            System.out.println("-1");
        }else{
            System.out.println(result.toString().replace("[", "").replace("]", "").replace(",", " ")); 
        }
    }
}