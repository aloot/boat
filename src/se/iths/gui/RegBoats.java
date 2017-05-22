package se.iths.gui;

import java.util.Scanner;
import java.util.ArrayList;

public class RegBoats {

	public ArrayList<String> addBoat = new ArrayList<String>(5);
	private String boatName     = "";
	private String company      = "";
	private String volumeType   = "";

	public ArrayList<String> addBoat() {

		addBoat.add(boatName);
		addBoat.add(company);
		addBoat.add(volumeType);

		Scanner sc = new Scanner(System.in);
		System.out.print("\nBoat name: ");
		boatName = sc.nextLine();
		do {
			while (boatName.matches(".*\\d.*")){
				System.out.println("\n'The boat's name cannot contain digits, please enter a valid name !");
				boatName = sc.nextLine();
			}
			if (boatName.trim().isEmpty()) {
				System.out.print("\n'The boat's name' can not be empty, please enter a name: ");
				boatName = sc.nextLine();
			}
		} while (boatName.trim().isEmpty());
		String newBoatName = boatName.trim();
		addBoat.set(0, newBoatName);

		System.out.print("\nCompany of the boat : ");
		company =   sc.nextLine();
		while (company.trim().isEmpty()) {
			System.out.print("\n'Company' name cannot be empty, please enter a company name: ");
			company =   sc.nextLine();
		}
		addBoat.set(4, company);

		System.out.print("\nWhat volumetype does the boat have? ");
		System.out.print("1 = A005");
		System.out.print("2 = AA07");
		System.out.print("3 = B005");
		System.out.print("4 = BB07");
		System.out.print("5 = C005");
		System.out.print("6 = CC07");
		System.out.print("7 = CCC5");
		System.out.print("8 = K007");
		volumeType =       sc.nextLine();
		while (!volumeType.matches("([1-8]{1}")) {
			System.out.print("\nInvalid number! Please enter a number from 1-8: ");
			volumeType =       sc.nextLine();
		}
		return addBoat;

	}


	/*osäker på vad denna gör uppdaterat från title till review/id_review/AK
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
