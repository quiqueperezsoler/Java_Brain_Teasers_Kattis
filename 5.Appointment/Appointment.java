/****************************************************
******** author: Enrique Perez Soler ****************
**** course: DD1380 - Java for Python Programmers ***
****************************************************/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;


class Appointment implements Comparable<Appointment>{
    Integer number; //0
    String description;// Monday 4 april 13-15
    Integer possibleAttendants;

    @Override
    public int compareTo(Appointment app){
        if(this.possibleAttendants != app.possibleAttendants){
            return this.possibleAttendants - app.possibleAttendants;
        }else{
            return app.number - this.number;
        }
    }
}

public class Tidsbokning {

    public static void main(String[] args){


        Scanner scan = new Scanner(System.in);

        Integer numberMeetings = scan.nextInt();
        Integer numberParticipants = scan.nextInt();

        scan.nextLine();

        ArrayList<Appointment> appointments = new ArrayList<Appointment>();

        for(Integer i = 0; i < numberMeetings; i++){ //1. We initialize the appointments with info of appointments
            Appointment newApp = new Appointment();
            newApp.number = scan.nextInt();
            newApp.description = scan.nextLine();
            newApp.possibleAttendants = 0;
            appointments.add(newApp);
        }

        for(Integer i = 0; i < numberParticipants; i++){//2. We complete info of appointmes with info of participants
            scan.next(); //NOTE: scan.next(line,int,etc)() is linear/sequential, that's why initialization of possibleAttendants
						 //wasn't possible before
            while(scan.hasNextInt()){
                appointments.get(scan.nextInt()).possibleAttendants++;//searches certain appointment number and increases possibleParticipants
            }
            scan.nextLine();// MOVES TO THE NEXT LINE. Different from Scan.next and scan.nextInt
        }

        Collections.sort(appointments, Collections.reverseOrder());

        for(Appointment forApp : appointments){
            System.out.println(forApp.number + forApp.description + " " + forApp.possibleAttendants);
        }
    }
}