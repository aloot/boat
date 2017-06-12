package se.iths.gui;

import java.util.Scanner;
import java.util.ArrayList;

public class RegTrucks {

	public ArrayList<String> addTruck = new ArrayList<String>(5);
	private String truckId     = "";
	private String truckTyp      = "";
	private String truckStatus   = "";

/*	public ArrayList<String> addTruck() {

		//addTruck.add(truckId);
		addTruck.add(truckTyp);
		addTruck.add(truckStatus);

		Scanner sc = new Scanner(System.in);
		System.out.print("\nTruck typ: ");
		truckTyp = sc.nextLine();
		do {
			while (truckId.matches(".*\\d.*")){
				System.out.println("\n'The truck's type must contain alphanumerical characters, please enter a valid name !");
				truckTyp = sc.nextLine();
			}
			if (truckTyp.trim().isEmpty()) {
				System.out.print("\n'The truck's type' can not be empty, please enter a type: ");
				truckTyp = sc.nextLine();
			}
		} while (truckTyp.trim().isEmpty());
		String newTruckTyp = truckTyp.trim();
		addTruck.set(0, newTruckTyp);

		System.out.print("\nStatus of the boat : ");
		status =   sc.nextLine();
		while (status.trim().isEmpty()) {
			System.out.print("\n'Status' field cannot be empty, please enter a status: ");
			status =   sc.nextLine();
		}
		addTruck.set(4, type);

		System.out.print("\nWhat type does the truck have? ");
		System.out.print("1 = A001");
		System.out.print("2 = AA01");
		System.out.print("3 = B001");
		System.out.print("4 = BB01");
		System.out.print("5 = C001");
		System.out.print("6 = CC01");
		System.out.print("7 = CCC1");
		System.out.print("8 = K001");
		truckType =       sc.nextLine();
		while (!truckType.matches("([1-8]{1}")) {
			System.out.print("\nInvalid number! Please enter a number from 1-8: ");
			truckType =       sc.nextLine();
		}
		return addTruck;

	}
*/

	/*osÃ¤ker pÃ¥ vad denna gÃ¶r uppdaterat frÃ¥n title till review/id_review/AK
  ResultSet rs = db.executeQuery("SELECT volumeType"+
                                 " FROM ships"+
                                 " WHERE volumeType ='" + volumeType + "'");
  try{
    rs.next();
    r.setID(rs.getInt("volumeType"));
  } catch (Exception e){
    System.err.println("Getting ID: " + e.getMessage());
  } finally {
    db.closeIt(rs);
  }
}
	 */
}
