package se.iths.app;

import se.iths.app.Employee;

import java.util.*;
import java.sql.ResultSet;

public class EmployeeSql {

  DBUtils db = DBUtils.getInstance();

    public void searchOnName(String wanted) {
      ArrayList<Object> empListAll = new ArrayList<Object>();
      String SQL = "SELECT emp.emp_id, emp.f_name, emp.s_name, kk.kk_namn,es.empstatus_namn, sch.schema_namn"
      + " FROM employee emp, kktyp kk, empstatus es, empschema sch"
      + " WHERE emp.kk_id = kk.kk_id AND emp.empstatus_id = es.empstatus_id"
      + " AND emp.schema_id = sch.schema_id"
      + " AND ((emp.s_name = '"+ wanted +"' ) OR (emp.f_name = '"+ wanted +"'));";
      
      ResultSet rs = db.executeQuery(SQL);
      
      Employee emp = null;
      KKtyp kk = null;
      String stat = null;
      String schema = null;
      try{
        while(rs.next()){
          emp = new Employee(rs.getInt("emp_id"),
                          rs.getString("f_name"),
                          rs.getString("s_name"));
          empListAll.add(emp);
         kk  = new KKtyp (rs.getString("kk_namn"));
         empListAll.add(kk);
         stat = (rs.getString("empstatus_namn"));
         empListAll.add(stat);
         schema = (rs.getString("schema_namn"));
         empListAll.add(schema);
        }
        db.closeIt(rs);
      } catch (Exception e){
        System.err.println("Retrieving 'selectEmpName': " + e.getMessage());
        db.closeIt(rs);
      }
      sortEmployeeList(empListAll);
    }

// ---------------
    
    public void sortEmployeeList(ArrayList<Object> empListAll) {
    	System.out.println("EmployeeId" + " " + "\tFirstname" + " " + "\tSurname" + " " + "\tTrucklicense" + " " + "\tStatus" + " " + "\tSchematype");
      ArrayList<Employee> empList = new ArrayList<Employee>();
      ArrayList<KKtyp> kkList = new ArrayList<KKtyp>();
      ArrayList<String> statList = new ArrayList<String>();
      ArrayList<String> schemaList = new ArrayList<String>();
      int counter = 0;
      
      /**
       * Sortera upp den feta 'empListAll' i fyra mindre
       */
      for (int i = 0; i < empListAll.size(); i = i + 4) {
        empList.add((Employee) empListAll.get(i));
        kkList.add((KKtyp) empListAll.get(i + 1));
        statList.add((String) empListAll.get(i + 2));
        schemaList.add((String) empListAll.get(i + 3));
        counter ++;
      }

      for (int i = 0; i < empList.size(); i ++) {
        if (empList.get(i).emp_id() < 10) {
          System.out.print("   " + empList.get(i).emp_id() + " \t" + " \t");        
        } else if (empList.get(i).emp_id() < 100) {
          System.out.print("  " + empList.get(i).emp_id() + " \t" + " \t");   
        } else if (empList.get(i).emp_id() < 1000){
          System.out.print(" " + empList.get(i).emp_id() + " \t" + " \t");
        } else {
          System.out.print(" " + empList.get(i).emp_id() + " \t" + " \t");
        }
        System.out.print(empList.get(i).f_name() + " \t" + " \t");
        System.out.print(empList.get(i).s_name() + " \t"+ "\t");
        System.out.print(kkList.get(i).kk_namn() + " \t"+ " \t");
        System.out.print(statList.get(i) + " \t");
        System.out.println(schemaList.get(i));
      }
    
      System.out.println("Employee count matching criteria: " + counter);
    
    }

// Sök på emp_id //
     public ArrayList<String> searchOnNr(int wantedNr) {
    	ArrayList<String> employeeObj = new ArrayList<String>();
        String SQL = "SELECT emp.emp_id, emp.f_name, emp.s_name, kk.kk_namn, es.empstatus_namn, sch.schema_namn "
          + "FROM employee emp, kktyp kk, empstatus es, empschema sch "
          + "WHERE emp.kk_id = kk.kk_id AND emp.empstatus_id = es.empstatus_id "
          + "AND emp.schema_id = sch.schema_id AND emp.emp_id = " + wantedNr + ";";
        ResultSet rs = db.executeQuery(SQL);
      
        try {
        while(rs.next()) {
          String emp_id = Integer.toString(rs.getInt("emp_id"));
          employeeObj.add(emp_id);
          String f_name = rs.getString("f_name");
          employeeObj.add(f_name);
          String s_name = rs.getString("s_name");
          employeeObj.add(s_name);
          String kk_namn = rs.getString("kk_namn");
          employeeObj.add(kk_namn);
          String empstatus_namn = rs.getString("empstatus_namn");
          employeeObj.add(empstatus_namn);
          String schema_namn = rs.getString("schema_namn");
          employeeObj.add(schema_namn);
        } 

        db.closeIt(rs);
      }  catch (Exception e){
        System.err.println("Retrieving 'searchOnNr': " + e.getMessage());
        db.closeIt(rs);
      }
        return employeeObj;   
  }
    
//--------------
    public void getEmployeeListNames(String empMsg){
    	ArrayList<Object> empListAll = new ArrayList<Object>();
    
      String SQL = "select emp.emp_id, emp.f_name, emp.s_name, kk.kk_namn,es.empstatus_namn, sch.schema_namn"
		  + " from employee emp, kktyp kk, empstatus es, empschema sch"
		  + " where emp.kk_id = kk.kk_id and emp.empstatus_id = es.empstatus_id"
		  + " and emp.schema_id = sch.schema_id;";  
        ResultSet rs = db.executeQuery(SQL);
  
        Employee emp = null;
        KKtyp kk = null;
        String stat = null;
        String schema = null;
        try{
          while(rs.next()){
            emp = new Employee(rs.getInt("emp_id"),
                            rs.getString("f_name"),
                            rs.getString("s_name"));
            empListAll.add(emp);
           kk  = new KKtyp (rs.getString("kk_namn"));
           empListAll.add(kk);
           stat = (rs.getString("empstatus_namn"));
           empListAll.add(stat);
           schema = (rs.getString("schema_namn"));
           empListAll.add(schema);
          }
          db.closeIt(rs);
        } catch (Exception e){
          System.err.println("Retrieving 'selectEmpName': " + e.getMessage());
          db.closeIt(rs);
        }
        sortEmployeeList(empListAll);
      }

    
 /*
    public ArrayList<Employee> getFullEmployeeList(){
      ArrayList<Employee> employeeList = new ArrayList<Employee>();
      String SQL = "SELECT * from employee";  
      ResultSet rs = db.executeQuery(SQL);
      try{
        Employee emp = null;
        while(rs.next()){
          emp = new Employee(rs.getInt("emp_id"),
                          rs.getString("f_name"),
                          rs.getString("s_name"),
                          rs.getInt("kk_id"),
                          rs.getInt("empstatus_id"),
                          rs.getInt("schema_id")
                          );
  
          employeeList.add(emp);
        }
        db.closeIt(rs);
        return employeeList;
      } catch (Exception e){
        System.err.println("Retrieving list of employee: " + e.getMessage());
        db.closeIt(rs);
      }
      return null;
    }*/
    
// Insert ny employee //
    public void addEmployee(Employee emp){
      String f_name = emp.f_name();
      String s_name = emp.s_name();
      int kk_id = emp.kk_id();
      int empstatus_id = emp.empstatus_id();
      int schema_id = emp.schema_id();
      
      String SQL = "INSERT INTO employee " +
        "(f_name, s_name, kk_id, empstatus_id, schema_id)" +
        " VALUES('" + f_name + "', " +
        "'" + s_name + "', " +
        "'" + kk_id + "', " +
        "'" + empstatus_id + "', " +
        "'" + schema_id + "')";

      System.out.println(db.executeUpdate(SQL)+
                         " new employee is created successfully");

  // osäker på vad denna gör uppdaterat från title till review/id_review/AK
      ResultSet rs = db.executeQuery("SELECT emp_id"+
                                     " FROM employee"+
                                     " WHERE f_name ='" + f_name + "'");
      try{
        rs.next();
       // r.setID(rs.getInt("emp_id"));
      } catch (Exception e){
        System.err.println("Getting ID: " + e.getMessage());
      } finally {
        db.closeIt(rs);
      }
    }
    
// Ändra employee	//   
    public void updateEmployee(String editObj, String editContent, int editId){
    	//System.out.println("inne i update: " + editObj + " " + editContent  + " " + editId);
        String SQL="UPDATE employee SET " + editObj + "=" +  '"' + editContent  + '"'
          + " WHERE emp_id =" + editId;
       // System.out.println(SQL);
        System.out.println(db.executeUpdate(SQL)
                           + " rows updated");
      }
}
 

