/****************************************************
******** author: Enrique Perez Soler ****************
**** course: DD1380 - Java for Python Programmers ***
****************************************************/
import java.io.*;

class StatesMachine{

    enum State {
        ACCEPTING,
        EXPECTING_STAR,
        EXPECTING_SLASH,
        PERCENTAGE,
        BLOCK
    }

    State actualState = State.ACCEPTING;

    String process(char c){
        switch(actualState){
            case ACCEPTING:

                switch(c){
                    case '%':
                        actualState = State.PERCENTAGE;
                        return "";
                    case '/':
                        actualState = State.EXPECTING_STAR;
                        return "";
                    default: //If it isn't any of the special comment char, we print the char then
                        return String.valueOf(c);
                }

            case PERCENTAGE: // we have % and we are expecting closing %

                if(c == '%'){
                    actualState = State.ACCEPTING;
                    return "";
                }else return "";

            case EXPECTING_STAR:

                if(c == '*'){
                    actualState = State.BLOCK;
                    return "";
                }else if(c == '/'){
                    return "/";
                }else{
                    actualState = State.ACCEPTING;
                    return "/" + c;
                }

            case BLOCK: //We have /* and we are expecting a *

                if(c == '*'){
                    actualState = State.EXPECTING_SLASH;
                    return "";
                }else return "";

            case EXPECTING_SLASH: //We have /* ..* and we are expecting a /
                if(c == '/'){
                    actualState = State.ACCEPTING;
                    return "";
                }else if (c == '*') {
                    return "";
                }else{
                    actualState = State.BLOCK;
                    return "";
                }
        }
        return null;
    }

}

public class Kommentarer {

    public static void main(String[] args){

        StatesMachine machine = new StatesMachine();

        int i;
        try {
            while ((i = System.in.read()) != -1) {
                char c = (char)i;
                System.out.print(machine.process(c));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}