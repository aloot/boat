package se.iths.gui;

import java.util.Scanner;
import java.util.ArrayList;

import se.iths.gui.RegEmployee;
import se.iths.gui.RegBoats;

public class RegEmployee {

	public ArrayList<String> addEmpList = new ArrayList<String>(5);
	private String fName     = "";
	private String sName     = "";
	private String license   = "";
	private String employment ="";
	private String schema    = "";


	public ArrayList<String> addEmp() {

		addEmpList.add(fName);
		addEmpList.add(sName);
		addEmpList.add(license);
		addEmpList.add(employment);
		addEmpList.add(schema);

		Scanner sc = new Scanner(System.in);
		System.out.print("\nFirst name: ");
		fName = sc.nextLine();
		do {
			while (fName.matches(".*\\d.*")){
				System.out.println("\n'The persons first name cannot contain digits, please enter a valid name !");
				fName = sc.nextLine();
			}
			
			if (fName.trim().isEmpty()) {
				System.out.print("\n'First name' can not be empty, please enter a name: ");
				fName = sc.nextLine();
			
			} while (sName.matches(".*\\d.*")){
					System.out.println("\n'The persons last name cannot contain digits, please enter a valid name !");
					sName = sc.nextLine();
				}

				if (fName.trim().isEmpty()) {
					System.out.print("\n'Last name' can not be empty, please enter a name: ");
					sName = sc.nextLine();
				}

		}
		while (fName.trim().isEmpty());
			String newfName = fName.trim();
			addEmpList.set(0, newfName);

			while (sName.trim().isEmpty());
			String newsName = sName.trim();
			addEmpList.set(0, newsName);

			System.out.print("\nForklift license : ");
			license =   sc.nextLine();
			while (license.trim().isEmpty()) {
				System.out.print("\n'License' cannot be empty, please enter a license : ");
				license =   sc.nextLine();
			}
			addEmpList.set(4, license);

			System.out.print("\nWhat type of forklift license does the employee have? ");
			System.out.print("1 = A005");
			System.out.print("2 = AA07");
			System.out.print("3 = B005");
			System.out.print("4 = BB07");
			System.out.print("5 = C005");
			System.out.print("6 = CC07");
			System.out.print("7 = CCC5");
			System.out.print("8 = K007");
			license =       sc.nextLine();
			while (!license.matches("([1-8]{1}")) {
				System.out.print("\nInvalid number! Please enter a number from 1-8: ");
				license =       sc.nextLine();

			}
			return addEmpList;


			/*
  osäker på vad denna gör uppdaterat från title till review/id_review/AK
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
	}
