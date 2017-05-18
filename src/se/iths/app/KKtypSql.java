package se.iths.app;

import java.util.*;
import java.sql.ResultSet;
import java.util.ArrayList;


import se.iths.app.Employee;
import se.iths.app.KKtyp;

public class KKtypSql {

  DBUtils db = DBUtils.getInstance();
  
  public void selectEmpsByKK(int kkType){
    ArrayList<Object> empListKK = new ArrayList<Object>();
    ArrayList<Employee> tmpEmpList = new ArrayList<Employee>();
    ArrayList<Employee> empList = new ArrayList<Employee>();
    ArrayList<KKtyp> tmpKKList = new ArrayList<KKtyp>();
    ArrayList<KKtyp> kkList = new ArrayList<KKtyp>();
    ArrayList<String> tmpStatList = new ArrayList<String>();
    ArrayList<String> statList = new ArrayList<String>();
    ArrayList<Integer> keepList = new ArrayList<Integer>();
    int counter = 0;
//    String SQL = "SELECT * from t.*, tt.*, ts.* FROM truck t, trucktyp tt, trstatus ts 
//    WHERE t.tr_typ_id = tt.tr_typ_id and t.tr_status_id = ts.tr_status_id LIMIT 20";
//  select e.emp_id, e.f_name, kk.kk_namn from employee e, kktyp kk where e.kk_id = 1 and kk.kk_id = 1;
//    "SELECT ma.character, a.*, m.* FROM movie_actor ma, actor a, movie m 
    //WHERE ma.id_movie ='" + id_movie + "' and ma.id_actor = a.id_actor and ma.id_movie = m.id_movie";
    
    String SQL = "SELECT e.emp_id, e.f_name, e.s_name, kk.kk_namn, es.empstatus_namn "
        + "FROM employee e, kktyp kk,  empstatus es "
        + "WHERE e.kk_id = " + kkType + " AND kk.kk_id = " + kkType ;
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
      System.err.println("Retrieving 'selectEmpsByKK': " + e.getMessage());
      db.closeIt(rs);
    }
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
    System.out.println("keepL: " + keepList);
    
    
    if (keepList.size() < tmpEmpList.size()) {
      for (int i = 0; i < keepList.size(); i ++) {
        empList.add(tmpEmpList.get(keepList.get(i)));
        kkList.add(tmpKKList.get(keepList.get(i)));
        statList.add(tmpStatList.get(keepList.get(i)));
        counter ++;
      }
    }
    System.out.println("empL: " + empList.size());
    /**
     * Weed out inappropriate working hours, days, %
     */
    
    for (int i = 0; i < empList.size(); i ++) {
      System.out.print(empList.get(i).emp_id() + " ");
      System.out.print(empList.get(i).f_name() + " ");
      System.out.print(empList.get(i).s_name() + " ");
      System.out.print(kkList.get(i).kk_namn() + " ");
      System.out.println(statList.get(i));
    }

    System.out.print("Employee count matching criteria: " + counter);
  }

  private void komigen() {
    // TODO Auto-generated method stub
    
  }
  
  
}
