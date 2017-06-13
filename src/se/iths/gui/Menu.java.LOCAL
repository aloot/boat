package se.iths.gui;


  import se.iths.app.TruckSql;
  import se.iths.app.Truck;
  import se.iths.app.EmployeeSql;
  import se.iths.app.Employee;
  import se.iths.app.KKtyp;
  import se.iths.app.KKtypSql;
  import se.iths.app.VolymSql;
  import se.iths.app.ReportSql;
  import se.iths.app.Report;

  import java.util.Scanner;
  import java.util.ArrayList;
  import java.util.List;
  import java.text.DecimalFormat;

  public class Menu {
    private String mmMsg = "- - - Main menu, enter your choice: ";
    private String trMsg = "- Truck menu, enter your choice: ";
    private String empMsg = "- Employee menu, enter your choice: ";
    private String empMsgAskAgain = "- Employee menu, enter your choice: ";
    private String vMsg = "- Vessel call menu, enter cargo type: ";
    private String rMsg = "- Report menu, enter your choice";
    
    private String invalidInput = "\n- - - Invalid input, please try again";

    private TruckSql tdb = new TruckSql();
    private EmployeeSql empdb = new EmployeeSql();  
    private KKtypSql kkdb = new KKtypSql();
    private VolymSql volDb = new  VolymSql();
    private ReportSql rdb = new ReportSql();
    private Report rep = new Report();
    
    private boolean exit;
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Employee> empListNames = new ArrayList<Employee>();
    private ArrayList<Truck> truckList = new ArrayList<Truck>();
    private ArrayList<Employee> employeeList = new ArrayList<Employee>();
        
    //-----------------------------//
    public void runMenu() {
      System.out.println("BoatFace DataBase - Welcome");
      printMenu();
      while(!exit) {
        int menuChoice = menuInput(mmMsg, 6);
        firstChoice(menuChoice);
      }
    }
  //-----------------------------//
    public void printMenu() {
      System.out.println("\n- - -");
      System.out.println("1. Vessel calls");
      System.out.println("2. Get a report");
      System.out.println("3. Manage personel");
      System.out.println("4. Manage inventory");
      System.out.println("5. Quit");
      System.out.println("6. TMP");
    }
    //-------------------------------------//
  /*
  runMenu
    printmenu
  firstChoice
  */
    public void firstChoice(int menuChoice) {
      switch(menuChoice) {
        case 1: // Boka kaj
          System.out.println("\nMake a vessel call");
          printCallMenu();
          printMenu();
        break;
        
        case 2: // Reports
//          Report r = new Report();
          System.out.println("\nGet some nice reads");
          printRepoMenu();
          printMenu();
          break;
         
        case 3: // Handle personel
          System.out.println("\nManage employees");
        //  employeeList = empdb.getFullEmployeeList();
//          empdb.getEmployeeListNames();
          printEmpMenu();
          manageEmployees();
          printMenu();
          break;

        case 4: // Manage machinery
          System.out.println("\nManage inventory");
//          tdb.selectTruckByKK(menuInput(trMsg, 8));
          printMenu();
          break;
          
        case 5: // quit
          System.out.println("Good Bye!");
          System.exit(0);
          break;
          
        case 6:
          System.out.println("Dev block");
//          rep.doDate();
          printMenu();     
          break;
         
        default:
          System.out.println(invalidInput);
          printMenu();
          break;
      } 
    }
//------------------------//
    public void printRepoMenu() {
      System.out.println("1. Back to main menu");
      System.out.println("View reports, start date: (YYYY-MM-DD)");
      String strDate1 = sc.nextLine();
      if (strDate1.equals("1")) {
        return;
      } else {
        System.out.println("until");
        String strDate2 = sc.nextLine();
        ArrayList<Report> repList = rdb.getReads(strDate1, strDate2);
        System.out.println("1. Back to main menu");
        System.out.println("2. Delete a call");
        String s = sc.nextLine();
        int i = Integer.parseInt(s);
        if (i > 1) {
          System.out.print("Delete ");
          rdb.printOut(repList.get(i));
          System.out.println("\nProceed? Y/N");
          String proceed = sc.nextLine();
          System.out.println("delete");
        }
      }
 
    }

    public void printCallMenu() {
      String cargoTypes = "1. A \n2. AA \n3. B \n4. BB \n5. C \n6. CC \n7. CCC \n8. K";
      System.out.println("1. Back to main menu");
      System.out.println("Enter a date (YYYY-MM-DD): ");
// byt ut      
//      String strDate = "2017-01-01";
      String strDate = sc.nextLine();
      if (strDate.equals("1")) {
        return;
      } else {
        System.out.println(cargoTypes);        
        getADate(strDate);      
      }
    }
    private void getADate(String strDate) {
      int volType = menuInput(vMsg, 8);
      int sns = rdb.findFreeDate(strDate, volType);
      int choice = menuInput("", sns + 2); // datum
      if (choice <= sns) {
        System.out.println("Enter the id number of the vessel (1-100)");
        int ship = Integer.parseInt(sc.nextLine());
        rdb.makeACall(choice, ship);
 //       volDb.vesselCallType(volType);
      } else if (choice <= sns + 1 ) {
        getANewDate();
      }
    }
    public void getANewDate() {
      printCallMenu();
    }
    
//------------------------//
    public void printEmpMenu() {
      System.out.println("1. Search for employee by name");
      System.out.println("2. Search for employee by id");
      System.out.println("3. Add employee");
      System.out.println("4. getEmployeeListNames");
      System.out.println("5. emp 5");
    }
    public void manageEmployees() {
//      RegEmployee rEmp = new RegEmployee();
      int choice = menuInput(empMsg, 5);
      switch (choice) {
      case 1:
        System.out.println("- Search for employee by name - first search");
        String wanted = sc.nextLine();
        empdb.searchOnName(wanted);
        firstSearch();
        break;

      case 2:
        System.out.println("Search for employee by id");
        int wantedNr = Integer.parseInt(sc.nextLine());
        empdb.searchOnNr(wantedNr);
        break;

      case 3:
        System.out.println("Add employee");
        /*        ArrayList<String> newEmp = rEmp.addEmp();
        for (String s : newEmp) {
 //         System.out.println(s);
        }*/
        break;

      case 4:
        System.out.println("getEmployeeListNames, 4");
        empdb.getEmployeeListNames(empMsg);
        break;

      case 5:
        System.out.println("emp menu, 5");
        break;
        
      default:
        System.out.println(invalidInput);
        break;          
      }
    }

//------------------------//
    public void firstSearch() {
      System.out.println("\n1. Another search");
      System.out.println("2. Edit employee by id number");
      System.out.println("3. Back to main menu");
      anotherSearch(menuInput(empMsgAskAgain, 3)); 
    }
//------------------------//
    public void anotherSearch(int choice){
      switch (choice) {
      case 1:
        System.out.println("Another search: ");
        System.out.println("- Search for employee by name - another");
        String wanted = sc.nextLine();
        empdb.searchOnName(wanted);
        firstSearch();
        break;
        
      case 2:
        int empId = Integer.parseInt(sc.nextLine());
        empdb.searchOnNr(empId);
        break;
        
      case 3:
        System.out.println("Back to main menu!");
        break;

      default:
        System.out.println(invalidInput);
        break;
      }
    }

//------------------------//  
    public int menuInput(String menuMsg, int maxInt) {
      int menuChoice = -1;
      while (menuChoice < 0 || menuChoice > maxInt) {
        try {
          System.out.print(menuMsg);
          menuChoice = Integer.parseInt(sc.nextLine());
          if (menuChoice < 1 || menuChoice > maxInt) {
            System.out.println(invalidInput);
          }
        } catch (NumberFormatException e) {
          System.out.println(invalidInput);
        }
      }
      return menuChoice;
    }

/*    private void pickBerth(int i) {
          kkdb.selectEmpsByKK(i);
    }*/


  //--------------------------------//
    public void helpMenu() {
      System.out.println("\n  /----------------------------------------------/");
      System.out.println(" /This is Clutch-MDb, a textbased movie database/");
      System.out.println("/----------------------------------------------/");
      System.out.println("\nEst feugiat habitasse arcu commodo augue interdum Facilisis pharetra tortor habitasse feugiat praesent suscipit rutrum \nSodales sociosqu facilisis tempus metus Magna congue per quis vehicula Porttitor etiam tristique massa et dapibus amet \nlorem molestie Sociosqu Curae dolor amet nulla id diam donec ut auctor, imperdiet vehicula Maecenas tellus purus nam \nporta ligula fusce donec varius, tristique.");
    }
  //--------------------------------//

  
}
