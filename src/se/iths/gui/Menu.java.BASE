package se.iths.gui;


  import se.iths.app.TruckSql;
  import se.iths.app.Truck;
  import se.iths.app.EmployeeSql;
  import se.iths.app.Employee;
  import se.iths.app.KKtyp;
  import se.iths.app.KKtypSql;
  import se.iths.app.VolymSql;

  import java.util.Scanner;
  import java.util.ArrayList;
  import java.util.List;
  import java.text.DecimalFormat;

  public class Menu {
    private String mmMsg = "- - - Main menu, enter your choice: ";
    private String trMsg = "- Truck menu, enter your choice: ";
    private String empMsg = "- Employee menu, enter your choice: ";
    private String empMsgAskAgain = "- Employee menu, enter your choice: ";
    private String vMsg = "- Vessel call menu, enter your choice: ";
    
    private String invalidInput = "\n- - - Invalid input, please try again";

    private TruckSql tdb = new TruckSql();
    private EmployeeSql empdb = new EmployeeSql();  
    private KKtypSql kkdb = new KKtypSql();
    private VolymSql vdb = new  VolymSql();
    
    private boolean exit;
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Employee> empListNames = new ArrayList<Employee>();
    private ArrayList<Truck> truckList = new ArrayList<Truck>();
    private ArrayList<Employee> employeeList = new ArrayList<Employee>();
        
    //-----------------------------//
    public void runMenu() {
      printMenu();
      while(!exit) {
        int menuChoice = menuInput(mmMsg, 6);
        firstChoice(menuChoice);
      }
    }
  //-----------------------------//
    public void printMenu() {
      System.out.println("- - -");
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
          System.out.println("Make a vessel call");
          int i = menuInput(vMsg, 8);
          vdb.vesselCallType(i);
       //   pickBerth(i);
          printMenu();
        break;
        
        case 2: // Reports
          System.out.println("\nGet some nice reads");
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
          System.out.println("Manage inventory");
          tdb.selectTruckByKK(menuInput(trMsg, 8));
          printMenu();
          break;
          
        case 5: // quit
          System.out.println("Good Bye!");
          System.exit(0);
          break;
          
        case 6:
          System.out.println("Dev block");
//          empdb.getEmpFromID(menuInput(600));
//          empdb.getEmpFromID(400);          
          break;
         
        default:
          System.out.println(invalidInput);
          break;
      } 
    }
  //------------------------//
    public void printEmpMenu() {
      System.out.println("1. Search for employee by name");
      System.out.println("2. Search for employee by id");
      System.out.println("3. Add employee");
      System.out.println("4. getEmployeeListNames");
      System.out.println("5. emp 5");
    }
  //------------------------//
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
    public void firstSearch() {
      System.out.println("\n1. Another search");
      System.out.println("2. Edit employee by id number");
      System.out.println("2. Back to main menu");
      anotherSearch(menuInput(empMsgAskAgain, 3)); 
    }
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

    private void pickBerth(int i) {
          kkdb.selectEmpsByKK(i);
    }

/*    private void extendMovieData(List<Movie> mList, int movieNr) {
  /*    AddReview addReview = new AddReview();
      ArrayList<String> newReview;
      AddActor addAct = new AddActor();
      ArrayList<String> newAct;
      ArrayList<String> newMA = new ArrayList<String>();

      boolean b = true;
      while (b) {
        System.out.println("\n1. Add review");
        System.out.println("2. Delete review");
        System.out.println("3. Add actor");
        System.out.println("4. Back");
        int menuChoice = kbdChoice(4);
        switch(menuChoice) {
          case 1: // add Review
            newReview = addReview.addReview(movieNr);
            Review r = new Review(newReview);
            rdb.addReview(r);
            showMovie(mList, movieNr);
            break;
          case 2:
            int revToDelete = -1;
            System.out.println("Enter id of the reveiw you wish to delete, or zero to exit: ");
            revToDelete = Integer.parseInt(sc.nextLine());
            if (revToDelete > 0) {
              if (revToDelete == 0) {
                break;
              } else {
                rdb.deleteReview(revToDelete);
                System.out.println("Review " + revToDelete + " deleted");
              }
            }
            break;

          case 3: // add actor
            newAct = addAct.addActor();
            newMA.add(Integer.toString(movieNr));
            newMA.add("0");
            newMA.add(newAct.get(newAct.size() - 1));
            newAct.remove(newAct.size() - 1);
            Actor a = new Actor(newAct);
            adb.addActor(a);
            newMA.set(1, Integer.toString(a.id_actor()));
//            System.out.println(newMA);
            MovieActor ma = new MovieActor(newMA);
            adb.addMovieActor(ma);
            showMovie(mList, movieNr);

          case 4:
            b = false;
            break;
          }
        }
      }*/

/*    private void showMovie(List<Movie> mList, int movieNr) {
  /*    DecimalFormat df1 = new DecimalFormat("#,###,##0.0");
      List<Review> revList;
      ArrayList<Object> oList;
      ArrayList<MovieActor> maList = new ArrayList<MovieActor>();
      ArrayList<Actor> actList = new ArrayList<Actor>();
      for (Movie m : mList) { // hitta rätt film, visa den + dess reviews
        if (movieNr == m.id_movie()) {
          System.out.println(m);
          revList = rdb.getByMovieID(movieNr);
          Integer listSize = revList.size();
          if (listSize > 0) {
            double mScore = 0.00;
            System.out.println("\nID:     Score:   Author:           Review:");
            for (Review r : revList) {
              System.out.println(r.id_review() < 10 ? " " + r.id_review() + " - - - " + r.score() + " - - - " + r.author() + " - - -  - - " + r.review(): r.id_review() + " - - - "  + r.score() + " - - - " +  r.author() + " - - -  - - " + r.review());
              mScore += r.score();
            }
            System.out.println("Average rating: " + df1.format(mScore/listSize));
          } else {
            System.out.println("\nBe the first to rate this movie..! :P");
          }
          // Skriv ut skådisarna
          oList = adb.getActorByIdMovie(movieNr);
          if (oList.size() > 1) {
            for (int i = 0; i < oList.size(); i = i+2) {
              maList.add((MovieActor) oList.get(i));
              actList.add((Actor) oList.get(i+1));
            }
            System.out.println("\nCast:");
            int counter = 1;
            for (int i = 0; i < maList.size(); i ++) {
              System.out.println(counter + ". " + maList.get(i).character() + "  - - - - -  " + actList.get(i).name());
              counter ++;
            }
          } else {
            System.out.println("\nNo actors listed, so far");
          }

        }
      } // end 'for (Movie m : mList)'
    }*/

/*    private void getMovieNr(List<Movie> mList, int movieNr) {
/*      if (movieNr < 1) {
        boolean b = true;
        while (b) { // bara gör detta tills det är dags att backa i menyn...
          try {
            System.out.print("\nEnter a movie number: ");
            movieNr = Integer.parseInt(sc.nextLine());
            for (Movie m : mList) {
            // hitta rätt film, visa den + dess reviews
              if (movieNr == m.id_movie()) {
                showMovie(mList, movieNr);
                extendMovieData(mList, movieNr);
                b = false;
              }
            }
          } catch (NumberFormatException e) {
            System.out.println("\nInvalid input! Try again...");
          }
        }
      } 
    }*/

/*    private void showActor(List<Actor> aList, int actNr) {
      ArrayList<Object> oList;
      ArrayList<Actor> actList = new ArrayList<Actor>();
      ArrayList<MovieActor> maList = new ArrayList<MovieActor>();
      ArrayList<Movie> mList = new ArrayList<Movie>();
      for (Actor a : aList) {
        if (actNr == a.id_actor()) {
          oList = adb.getActorFromId(actNr);
          if (oList.size() > 2) { // get it sorted
            for (int i = 0; i < oList.size(); i = i + 3) {
              actList.add((Actor) oList.get(i));
              maList.add((MovieActor) oList.get(i + 1));
              mList.add((Movie) oList.get(i + 2));
            }
          } // done sorting
          int listSize = maList.size();
          System.out.println(actList.get(0).name() + " is an actor, born " + actList.get(0).birth() + " in " + actList.get(0).nationality());
          System.out.println("S/he has an acting part in: ");
          for (int i = 0; i < maList.size(); i++) {
            System.out.println("\t'" + mList.get(i).title() + "' by " +mList.get(i).director() + ", as " + maList.get(i).character() + (maList.size() - 1 > i ?  "," : ""));
          }
        }
      } 
    } */

 /*   private void showActorList(List<Actor> aList) {
      boolean b = true;
      int actNr;
      while (b) {
        try {
          System.out.println("\nEnter an actor number: ");
          actNr = Integer.parseInt(sc.nextLine());
          for (Actor a : aList) {
            if (actNr == a.id_actor()){
              showActor(aList, actNr);
              b = false;
            }
          }
        } catch (NumberFormatException e) {
          System.out.println(invalidInput);
        }
      }
    } */
  //----------------------------------------------//

  //--------------------------------//
    public void helpMenu() {
      System.out.println("\n  /----------------------------------------------/");
      System.out.println(" /This is Clutch-MDb, a textbased movie database/");
      System.out.println("/----------------------------------------------/");
      System.out.println("\nEst feugiat habitasse arcu commodo augue interdum Facilisis pharetra tortor habitasse feugiat praesent suscipit rutrum \nSodales sociosqu facilisis tempus metus Magna congue per quis vehicula Porttitor etiam tristique massa et dapibus amet \nlorem molestie Sociosqu Curae dolor amet nulla id diam donec ut auctor, imperdiet vehicula Maecenas tellus purus nam \nporta ligula fusce donec varius, tristique.");
    }
  //--------------------------------//

  
}
