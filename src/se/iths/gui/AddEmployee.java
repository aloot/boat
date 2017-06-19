package se.iths.gui;

import java.util.Scanner;
import java.util.ArrayList;

public class AddEmployee {

	public ArrayList<String> addEmpList = new ArrayList<String>(5);
	private String fName     = "";
	private String sName     = "";
	private int    licenseInt = 0;
	private String  license = "";
	private String empstatus = "";
	private int empstatusInt = 0;
	private String schema    = "";
	private int schemaInt    = 0;


	public ArrayList<String> addEmp() {
		addEmpList.add(fName);
		addEmpList.add(sName);
		addEmpList.add(license);
		addEmpList.add(empstatus);
		addEmpList.add(schema);

		Scanner sc = new Scanner(System.in);
		//Firstname
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
			}
			}while (fName.trim().isEmpty());
			String newfName = fName.trim();
			addEmpList.set(0, newfName);
			
			//Surname
			System.out.print("Surname name: ");
			sName = sc.nextLine();
			do{while (sName.matches(".*\\d.*")){
				System.out.println("\n'The persons surname cannot contain digits, please enter a valid name !");
				sName = sc.nextLine();
			}

			if (sName.trim().isEmpty()) {
				System.out.print("\n'Surname name' can not be empty, please enter a name: ");
				sName = sc.nextLine();
			}
			
			}while (sName.trim().isEmpty());
			String newsName = sName.trim();
			
			addEmpList.set(1, newsName);

			//Forklift
			System.out.print("\nWhat type of forklift license does the employee have? ");
			System.out.print("\n1. A005");
			System.out.print("\n2. AA07");
			System.out.print("\n3. B005");
			System.out.print("\n4. BB07");
			System.out.print("\n5. C005");
			System.out.print("\n6. CC07");
			System.out.print("\n7. CCC5");
			System.out.print("\n8. K007");
			
			System.out.print("\nForklift license : ");

			license =       sc.nextLine();
			while (license.trim().isEmpty()) {
				System.out.print("\n'License' cannot be empty, please enter a license : ");
				license =   sc.nextLine();
			}
			while (!license.matches("[0-9]+")){
				 System.out.print("\nThis is not a number! Please enter a number from 1-8: ");
				 license =   sc.nextLine();
			}
				
			licenseInt = Integer.parseInt(license);
			while (licenseInt < 1 || licenseInt > 9) {
				System.out.print("\nInvalid number! Please enter a number from 1-8: ");
				license =       sc.nextLine();
				licenseInt = Integer.parseInt(license);
			}
			
			String license = Integer.toString(licenseInt);
			addEmpList.set(2, license);
			 
			//Empstatus
			System.out.print("\nWhat kind of status does the employee currently have? ");
			System.out.print("\n1. 100%");
			System.out.print("\n2. 50%");
			System.out.print("\n3. Sick leave");
			System.out.print("\n4. Care of children");
			System.out.print("\n5. Studies");
			System.out.print("\n6. Vacation");
			System.out.print("\n7. Terminated employment");
			
			System.out.print("\n Employee status: ");

			empstatus =       sc.nextLine();
			while (empstatus.trim().isEmpty()) {
				System.out.print("\n'Status' cannot be empty, please enter a statusnumber : ");
				empstatus =   sc.nextLine();
			}
			while (!empstatus.matches("[0-9]+")){
				 System.out.print("\nThis is not a number! Please enter a number from 1-8: ");
				 empstatus =   sc.nextLine();
			}
			empstatusInt = Integer.parseInt(empstatus);
			while (empstatusInt < 1 || empstatusInt > 8) {
				System.out.print("\nInvalid number! Please enter a number from 1-8: ");
				empstatus =       sc.nextLine();
				empstatusInt = Integer.parseInt(empstatus);
			}
			
			String empstatus = Integer.toString(empstatusInt);
			addEmpList.set(3, empstatus);

			//schema_id;
			System.out.print("\nWhat kind of schedule does the employee currently have? ");
			System.out.print("\n1. Daytime weekdays");
			System.out.print("\n2. Daytime weekend");
			System.out.print("\n3. Daytime Sunday");
			System.out.print("\n4. Evenings weekdays");
			System.out.print("\n5. Evenings weekend");
			System.out.print("\n6. Evenings Sunday");
			System.out.print("\n7. Nights weekdays");
			System.out.print("\n8. Nights weekend");
			System.out.print("\n9. Nights enbart Sunday");
						
			System.out.print("\n Employee schema: ");
					
			schema =       sc.nextLine();
			while (schema.trim().isEmpty()) {
				System.out.print("\n'Schema' cannot be empty, please enter a schema number : ");
				schema =   sc.nextLine();
			}
			while (!schema.matches("[0-9]+")){
				 System.out.print("\nInvalid value! Please enter a number from 1-9: ");
				 schema =   sc.nextLine();
			}
			schemaInt = Integer.parseInt(schema);
			while (schemaInt < 1 || schemaInt > 9) {
				System.out.print("\nInvalid number! Please enter a number from 1-9: ");
				schema = sc.nextLine();
				schemaInt = Integer.parseInt(schema);
			}
			
			String schema = Integer.toString(schemaInt);
			addEmpList.set(4, schema);
					
			return addEmpList;

		}
	}
