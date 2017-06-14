package se.iths.app;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public class ReportSql {
  
  DBUtils db = DBUtils.getInstance();
  VolymSql volDb = new VolymSql();
  private ArrayList<Report> suggestions;
  private LocalDate prefDate;
  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  private int workHours;
  private int nrOfSuggestions = 9;
  private int volType;
  private ArrayList<String> hours = new ArrayList<>();
  
  
  private String berth;
  
  public ArrayList<Report> getReads(String strDate1, String strDate2) {
    if (hours.size() == 0) {
      hours.add("00-08");
      hours.add("08-16");
      hours.add("16-00");
    }
    LocalDate start = LocalDate.parse(strDate1, dtf);
    LocalDate end = LocalDate.parse(strDate2, dtf);
//    ArrayList<LocalDate> timeRange = new ArrayList<>();
    ArrayList<Report> reportList = new ArrayList<>();

    String SQL = "SELECT r.report_id, r.datum, r.pass, k.kaj_namn,"
        + " v.voltyp_namn, s.ship_name, s.company, r.total_price"
        + " FROM report r, kajtyp k, volymtyp v, ships s"
        + " WHERE (datum >= '" + start + "'" + "AND datum <= '" + end + "')"
        + " AND r.kaj_id = k.kaj_id "
        + " AND r.voltyp_id = v.voltyp_id"
        + " AND r.ship_id = s.ship_id;";
    ResultSet rs = db.executeQuery(SQL);
    Report r = null;
    try {
      while (rs.next()){
       r = new Report(rs.getInt("report_id"),
                       rs.getString("datum"),
                       rs.getInt("pass"),
                       rs.getString("kaj_namn"),
                       rs.getString("voltyp_namn"),
                       rs.getString("ship_name"),
                       rs.getString("company"),
                       rs.getInt("total_price"));
       reportList.add(r);
      }
      db.closeIt(rs);
    } catch (Exception e) {
      System.err.println("- Retrieving 'getReads': " + e.getMessage());
        db.closeIt(rs);
    }
    for (int i = 0; i < reportList.size(); i ++) {
      int id = reportList.get(i).report_id();

      if (id < 10 ) {
        System.out.print("  " + id);
      } else if (id < 100) {
        System.out.print(" " + id);
      } else {
        System.out.print(id);
      }
      printOut(reportList.get(i));
/*      String vTyp = r.voltyp_namn();
      int vT;
      switch(vTyp) {
      case "A005":
        vT = 1;
        break;
        
      case "AA07":        
        vT = 2;
        break;

      case "B005":
        vT = 3;
        break;
      case "BB07":
        vT = 4;
        break;
        
      case "C005":
        vT = 5;
        break;
        
      case "CC07":
        vT = 6;
        break;
      case "CCC5":
        vT = 7;
        break;      
      case "K007":
        vT = 8;
        break;
      
      default:
        vT = 0;
        System.out.println("Unknown error");
        break;
      }*/
//      volDb.vesselCallType(vT);

      /*      System.out.print(". " + reportList.get(i).strDatum());
      System.out.print(", " + hours.get(reportList.get(i).pass()-1));
      System.out.print(", " + reportList.get(i).kaj_namn());
      System.out.print(", " + reportList.get(i).voltyp_namn());
      System.out.print(", " + reportList.get(i).ship_namn());
      System.out.print(", " + reportList.get(i).company());
      System.out.println(", " + reportList.get(i).total_price());*/
    }

    return reportList;
  }
  
  
  public void printOut(Report r) {
    System.out.print(". " + r.strDatum());
    System.out.print(", " + hours.get(r.pass()-1));
    System.out.print(", " + r.kaj_namn());
    System.out.print(", " + r.voltyp_namn());
    System.out.print(", " + r.ship_namn());
    System.out.print(", " + r.company());
    System.out.println(", " +r.total_price());
  }
  public int  findFreeDate (String stringDate, int vol) {

    if (hours.size() == 0) {
      hours.add("00-08");
      hours.add("08-16");
      hours.add("16-00");
    }
 //   dateList = new ArrayList<LocalDate>();
    volType = vol;
//    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    prefDate = LocalDate.parse(stringDate, dtf);
    ArrayList<Integer> occupied = new ArrayList<>();
    suggestions = new ArrayList<>();
    if (vol > 5) {
 //     System.out.println("(berth: 301)");
      berth = "301";
      vol = 3;
    } else if (vol < 3) {
 //     System.out.println("(berth: 101)");
      berth = "101";
      vol = 1;
    } else {
 //     System.out.println("(berth: 201)");
      berth = "201";
      vol = 2;
    }

    int inc = 0;
    while (suggestions.size() < nrOfSuggestions + 1) {
      occupied = crunchSql(prefDate.plusDays(inc), vol);
      if (occupied.size() < 3) {
        if (occupied.indexOf(1) < 0) {
          Report r = new Report(prefDate.plusDays(inc), 1, vol);
          suggestions.add(r);
        }
        if (occupied.indexOf(2) < 0) {
          Report r = new Report(prefDate.plusDays(inc), 2, vol);
          suggestions.add(r);
        }
        if (occupied.indexOf(3) < 0) {
          Report r = new Report(prefDate.plusDays(inc), 3, vol);
          suggestions.add(r);
        }
      }        
      inc ++;
    }

    LocalDate dZero = suggestions.get(0).datum();
    System.out.println("\n" + chCase(dZero.getDayOfWeek().toString()));
 //   System.out.println(dZero.getDayOfWeek());
    for (int i = 0; i < suggestions.size(); i ++) {
      if (dZero.isBefore(suggestions.get(i).datum())) {
        System.out.println(" ");
        System.out.println(chCase(suggestions.get(i).datum().getDayOfWeek().toString()));
//        System.out.println(suggestions.get(i).datum().getDayOfWeek());
        dZero = suggestions.get(i).datum();
      } 
      String s = (i + 1 + ". date: " + suggestions.get(i).datum());
      if (i + 1 < 10) {
        System.out.print(" " + s);
      } else {
        System.out.print(s);
      }
      System.out.println("  time: " + hours.get(suggestions.get(i).pass()-1));
    }
    System.out.println("  berth: " + berth);
    int sns = suggestions.size();
    System.out.println("Chooose one of the suggestions above, \nenter " + (sns + 1) + 
        " to see available time slots for another day,\nor " + (sns + 2) + ", to go back to main menu");
    return sns;
    
  }
  private String chCase(String s) {
    String d = s.substring(0,1);
    String ay = s.substring(1).toLowerCase();
    return d + ay;
  }
  public void makeACall(int choice, int ship_id) {
    choice = choice - 1;
    LocalDate d = suggestions.get(choice).datum();
    int pass = suggestions.get(choice).pass();
    int kaj = suggestions.get(choice).kaj_id();
    Scanner sc = new Scanner(System.in);
//    System.out.println("(makeACall: p: "+ pass + ", kaj: " + kaj +")");

    Ship s = findShip(ship_id);
    if (s != null) {
      int sId = s.ship_id();
      String sName = s.ship_name();
      String sComp = s.comp();
      System.out.println("Ship name: " + sName + "\nId: " + sId + "\nCompany: " + sComp);
      int price = getPrice();
      System.out.println("- You're about to make a call for '" + sName + "' of '" + sComp + "'");
      System.out.println("Berth: " + berth);
      System.out.format("Price: " + "%,d%n",price);
      System.out.println("Date: " + d + ": " + hours.get((suggestions.get(choice).pass())-1));
      System.out.println("Go ahead? Y/N");
      String goAhead = sc.nextLine();
      if (goAhead.toUpperCase().equals("Y")) {
        String SQL = "INSERT INTO report (datum, pass, kaj_id, voltyp_id, ship_id, total_price) "
            + "VALUES ('"+ d +"', '" + pass + "', '" + kaj + "', '" + volType + "', '" + sId +"', '"+price +"' );";
        System.out.println(db.executeUpdate(SQL) + " row(s) inserted");
        Report r = null;
        ResultSet rs = db.executeQuery("SELECT * FROM report "
            + "WHERE datum = '" + d + "' AND pass = '" + pass + "'AND kaj_id = '" + kaj + "';");
        try {
         while (rs.next()) {
           r = new Report(rs.getInt("report_id"), 
                           rs.getInt("pass"),
                           rs.getInt("kaj_id"),
                           rs.getInt("ship_id"),
                           rs.getInt("total_price"));
         }
         db.closeIt(rs);
        } catch(Exception e) {
          System.err.println("- Retrieving 'Ship': " + e.getMessage());
        } finally {
          db.closeIt(rs);        
//          sc.close();
        }
      volDb.vesselCallType(volType);
      } else {
        
      }// change of mind
    } else { // no ship
      System.out.println("Not a valid ship id");
//      sc.close();
      return;
    }
    
  }
  private int getPrice() {
    int ant = 0;
    int empPrice = 0;
    int trkPrice = 0;
    int price;
    switch (volType) {
    case 1: 
      ant = 5;
      empPrice = 500;
      trkPrice = 1000;
      break;
      
    case 2:
      ant = 7;
      empPrice = 700;
      trkPrice = 1500;
      break;
      
    case 3:
      ant = 5;
      empPrice = 900;
      trkPrice = 2000;
      break;
      
    case 4:
      ant = 7;
      empPrice = 1000;
      trkPrice = 2500;
      break;
      
    case 5:
      ant = 5;
      empPrice = 1250;
      trkPrice = 3000;
      break;
      
    case 6:
      ant = 7;
      empPrice = 1500;
      trkPrice = 3500;
      break;
      
    case 7:
      ant = 5;
      empPrice = 3000;
      trkPrice = 4000;
      break;
      
    case 8:
      ant = 7;
      empPrice = 4500;
      trkPrice = 6000;
      break;
      
    default:
      break;
    }
    price = (ant * empPrice) + (ant * trkPrice);
    return price;
  }
  private Ship findShip(int id) {
    String SQL = "SELECT * FROM ships WHERE ship_id ="+id+";";
    ResultSet rs = db.executeQuery(SQL);
    Ship s = null;
    try {
      while (rs.next()) {
        s = new Ship(rs.getInt("ship_id"),
                      rs.getString("ship_name"),
                      rs.getString("company"),
                      rs.getInt("volymtyp_id"));
      }
      db.closeIt(rs);
      return s;
    } catch (Exception e) {
      System.err.println("- Retrieving 'Ship': " + e.getMessage());
      db.closeIt(rs);
      return null;
    }
  }
    private void recycle() {

      /**
       * personnel n trucks
       */
      workHours = prefDate.getDayOfWeek().getValue();
      LocalDate newDate = prefDate.plusDays(1);    
      if (workHours < 6 ) {
        System.out.println("(wH: " + workHours + ")");
      }
//      System.out.println("(dtf: " + newDate + ")"); 
//      System.out.println("(dtf day: " + newDate.getDayOfWeek().getValue() + ")");

      System.out.println("You wish to make a call on " + prefDate + "");
    }
    
    
    private ArrayList<Integer> crunchSql(LocalDate prefDate, int vol) {
     ArrayList<Report> repList = new ArrayList<>();
  
     String SQL = "SELECT * FROM report WHERE datum = '" + prefDate + "'"
         + "AND kaj_id = '" + vol + "';";
     ResultSet rs = db.executeQuery(SQL);
     Report rep = null;
     try {
       while (rs.next()){
        rep = new Report(rs.getInt("pass"),
                        rs.getInt("kaj_id"));
        repList.add(rep);
       }
       db.closeIt(rs);
     } catch (Exception e) {
       System.err.println("- Retrieving 'Reports': " + e.getMessage());
       db.closeIt(rs);
     }
     ArrayList<Integer> occupied = new ArrayList<>();    
     for (int i = 0; i < repList.size(); i ++) {
/*       System.out.println("occupied: ");
       System.out.print("pass: " + repList.get(i).pass());
       System.out.println("\tkaj: " + repList.get(i).kaj_id());*/
       occupied.add(repList.get(i).pass());
     }
     
     return occupied;
    }
  

}
