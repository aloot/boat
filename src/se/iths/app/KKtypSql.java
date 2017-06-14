package se.iths.app;


import java.sql.ResultSet;
import java.util.ArrayList;


import se.iths.app.Employee;
import se.iths.app.KKtyp;

public class KKtypSql {

  DBUtils db = DBUtils.getInstance();
  
  public void selectEmpsByKK(int kkType, int ant){
    ArrayList<Object> empListKK = new ArrayList<Object>();
    ArrayList<Employee> tmpEmpList = new ArrayList<Employee>();
    ArrayList<Employee> empList = new ArrayList<Employee>();
    ArrayList<KKtyp> tmpKKList = new ArrayList<KKtyp>();
    ArrayList<KKtyp> kkList = new ArrayList<KKtyp>();
    ArrayList<String> tmpStatList = new ArrayList<String>();
    ArrayList<String> statList = new ArrayList<String>();
    ArrayList<Integer> keepList = new ArrayList<Integer>();
    int counter = 0;
    
    String SQL = "SELECT e.emp_id, e.f_name, e.s_name, kk.kk_namn, es.empstatus_namn "
        + "FROM employee e, kktyp kk,  empstatus es "
        + "WHERE e.kk_id = kk.kk_id AND e.empstatus_id = es.empstatus_id AND e.kk_id = " + kkType;
    ResultSet rs = db.executeQuery(SQL);
    Employee emp = null;
    KKtyp kk = null;
    String stat = null;
    try{
      while(rs.next()){
        emp = new Employee(rs.getInt("emp_id"),
                        rs.getString("f_name"),
                        rs.getString("s_name"));
       empListKK.add(emp);
       kk  = new KKtyp (rs.getString("kk_namn"));
       empListKK.add(kk);
       stat = (rs.getString("empstatus_namn"));
       empListKK.add(stat);
      }
      db.closeIt(rs);
    } catch (Exception e){
      System.err.println("- Retrieving 'selectEmpsByKK': " + e.getMessage());
      db.closeIt(rs);
    }
    
    //System.out.println("(empListKK.size: " + empListKK.size() + ")");
    for (int i = 0; i < empListKK.size(); i = i + 3) {
      tmpEmpList.add((Employee) empListKK.get(i));
      tmpKKList.add((KKtyp) empListKK.get(i + 1));
      tmpStatList.add((String) empListKK.get(i + 2));
    }

    for (int i = 0; i < tmpStatList.size(); i ++) {
      if (tmpStatList.get(i).indexOf('%') > 0) {
        keepList.add(i);
      }
    }
    //System.out.println("(keepL: " + keepList.size() + ")");
    
    
    if (keepList.size() < tmpEmpList.size()) {
      for (int i = 0; i < keepList.size(); i ++) {
        empList.add(tmpEmpList.get(keepList.get(i)));
        kkList.add(tmpKKList.get(keepList.get(i)));
        statList.add(tmpStatList.get(keepList.get(i)));
        counter ++;
      }
    } else {
      empList = new ArrayList<>(tmpEmpList);
      kkList = new ArrayList<>(tmpKKList);
      statList = new ArrayList<>(tmpStatList);
      counter = statList.size();
    }
//    System.out.println("(empL: " + empList.size() + ")");
    
    /**
     * ant = ant + ant;
     */
    ant = ant + ant;
//    System.out.println("a: " + ant);
    int chkSum = 0;
    int placeInList = 0;
    while (chkSum <= ant) {
        if (statList.get(placeInList).equals("50%")) {
          chkSum = chkSum + 1;
        } else if (statList.get(placeInList).equals("100%")) {
          chkSum = chkSum + 2;
        }
        placeInList ++;
//        System.out.print("cS: " + chkSum);
//        System.out.println(", pIL: " + placeInList);
    }
    if (empList.size() > placeInList) { // first cut
      empList.subList(placeInList, empList.size()).clear();
      statList.subList(placeInList, statList.size()).clear();
      kkList.subList(placeInList, kkList.size()).clear();
    }
    if (chkSum > ant) {
//      System.out.println("cS diff: " + (chkSum - ant));
/*      for (String s : statList) {
        System.out.println("s: " + s);
      }*/
      int pos;
      if (ant == (chkSum - 1)) {
 //       System.out.println("tar bort 50");
        pos = statList.indexOf("50%"); 

      } else if (ant == (chkSum - 2)) {
//        System.out.println("tar bort 100");
        pos = statList.indexOf("100%");
      } else {
        System.out.print("cS strul : " + chkSum );
        pos = 100;
      }
      empList.remove(pos);
      kkList.remove(pos);
      statList.remove(pos);

    }
    /**
     * Weed out inappropriate working hours, days, %
     */

    System.out.println("Available employees: "); 
    
    for (int i = 0; i < empList.size(); i ++) {
      if (empList.get(i).emp_id() < 10) {
        System.out.print("  " + empList.get(i).emp_id() + " ");        
      } else if (empList.get(i).emp_id() < 100) {
        System.out.print(" " + empList.get(i).emp_id() + " ");   
      } else {
        System.out.print(empList.get(i).emp_id() + " ");
      }
      System.out.print(empList.get(i).f_name() + " ");
      System.out.print(empList.get(i).s_name() + " ");
      System.out.print(kkList.get(i).kk_namn() + " ");
      System.out.println(statList.get(i));
    }

    System.out.println("- Employee count matching criteria: " + counter);
    System.out.println("- - - ");
  }

  private void komigen() {
    // TODO Auto-generated method stub
    
  }
  
  
}
