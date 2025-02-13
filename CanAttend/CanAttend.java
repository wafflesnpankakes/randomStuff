package CanAttend;
//Author: Emilie Spindler
//Date: 2.11.25
//Description: looks through a schedule of meetings and checks if there is an overlap of those meetings

import java.util.ArrayList;

public class CanAttend {

	//precondition: the parameter, meetings, has 2 or more MeetingIntervals
	//postcondition: returns false if there is an overlap in the schedule; and true if 
	//			 	 there is no overlap at all
	public static boolean canAttend(ArrayList<MeetingInterval> meetings) {
		//your implementation here
		System.out.println(meetings);

		for(int i=0; i<meetings.size(); i++){
			int checkStart = meetings.get(i).getStart();
			int checkEnd = meetings.get(i).getEnd();

			for(int k=i+1; k<meetings.size(); k++){
				int compareStart = meetings.get(k).getStart();
				int compareEnd = meetings.get(k).getEnd();

				if(checkStart > compareStart && checkStart < compareEnd){
					return false;
				}
				if(checkEnd > compareStart && checkEnd < compareEnd){
					return false;
				}
			}
		}
		return true;

	}
	public static void main(String[] args) {
		ArrayList<MeetingInterval> meet = new ArrayList<MeetingInterval>();
		for(int i =0; i<10; i++) {
			int start = (int)(Math.random()*2399);
			int end = start + ((int)(Math.random()*(2399-start)));
			meet.add(new MeetingInterval(start, end));
		}
		System.out.println(canAttend(meet) ? "There is no conflict with attending "+meet+" meetings":"Can't attend "+meet+" meetings due to conflict");
		//please include additional testing here!
		
		System.out.println();

		ArrayList<MeetingInterval> mySchedule = new ArrayList<MeetingInterval>();
		mySchedule.add(new MeetingInterval(50, 200));	
		mySchedule.add(new MeetingInterval(1000, 1033));
		mySchedule.add(new MeetingInterval(1099, 1250));
		mySchedule.add(new MeetingInterval(1250, 1847));
		mySchedule.add(new MeetingInterval(2350, 2399));
		
		System.out.println(canAttend(mySchedule) + " - can attend meetings! no conflict! *confetti* yayayy! (should return true)");

		System.out.println();
		mySchedule.add(new MeetingInterval(1500, 2360));
		System.out.println(canAttend(mySchedule) + " - cannot attend meeting due to conflict. (should return false)");

		System.out.println();
		mySchedule.add(new MeetingInterval(1000, 1020));
		System.out.println(canAttend(mySchedule) + " - cannot attend meeting due to conflict. (should return false)");



	}
}
