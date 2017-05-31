package se.iths.app;

import se.iths.app.Employee;

import java.util.*;
import java.sql.ResultSet;
 // klar - select med namn istället för id (join mot andra tabeller)
// insert
// update av namn, schema, körkort och empstatus - innan bör kontroll ske att id finns i tabeller
// delete - bör inte kunna ske istället sker en update av emp_status till "Slutat"

public class EmployeeSql {

  DBUtils db = DBUtils.getInstance();

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
    }
    
    public void getEmployeeListNames(){
    	ArrayList<Object> empListAll = new ArrayList<Object>();
        ArrayList<Employee> empList = new ArrayList<Employee>();
        ArrayList<KKtyp> kkList = new ArrayList<KKtyp>();
        ArrayList<String> statList = new ArrayList<String>();
        ArrayList<String> schemaList = new ArrayList<String>();
        int counter = 0;
    
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
        
        for (int i = 0; i < empListAll.size(); i = i + 4) {
          empList.add((Employee) empListAll.get(i));
          kkList.add((KKtyp) empListAll.get(i + 1));
          statList.add((String) empListAll.get(i + 2));
          schemaList.add((String) empListAll.get(i + 3));
        }
        System.out.println("empL: " + empList.size());
        
        for (int i = 0; i < empList.size(); i ++) {
          if (empList.get(i).emp_id() < 1000) {
            System.out.print("  " + empList.get(i).emp_id() + " ");        
          } else if (empList.get(i).emp_id() < 1001) {
            System.out.print(" " + empList.get(i).emp_id() + " ");   
          } else {
            System.out.print(empList.get(i).emp_id() + " ");
          }
          System.out.print(empList.get(i).f_name() + " ");
          System.out.print(empList.get(i).s_name() + " ");
          System.out.print(kkList.get(i).kk_namn() + " ");
          System.out.print(statList.get(i) + " ");
          System.out.println(schemaList.get(i));
        }
      
        System.out.println("Employee count matching criteria: " + counter);
        System.out.println("- - - ");
      }
 /*  

    public void deleteReview(int id_review){
//      int id_review = r.id_review();
      String SQL="DELETE FROM review"+
        " WHERE id_review=" + id_review;
      System.out.println(db.executeUpdate(SQL) +
                         " rows deleted");
    }
    /**
     * Inserts m into the database and sets the id of m to the
     * MunicipalityID it gets.
     */
 // Insert Employee
 // insert into employee(f_name, s_name, kk_id, empstatus_id, schema_id) 
 // values ('Alex', 'Morelatus', 1, 1, 1);

    public void addEmployee(Employee emp){
     // int id = e.id();
     // int id_employee = e.id_employee();
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

     // db.executeUpdate(SQL);
//        System.out.println("sql-et: " + SQL);
      System.out.println(db.executeUpdate(SQL)+
                         " rows inserted");

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

  /*  public List<Review> getByMovieID(int id_movie){
      ArrayList<Review> reviewList = new ArrayList<Review>();
      //System.out.println("Get by id_movie: " + id_movie);
      String SQL = "SELECT * FROM review WHERE id_movie ='" + id_movie + "'";
      //System.out.println("--DEBUG: SQL: " + SQL);
      ResultSet rs = db.executeQuery(SQL);
      Review r = null;
      try {
        while (rs.next()){
          r = new Review(rs.getInt("id_review"),
                       rs.getInt("id_movie"),
                       rs.getInt("score"),
                       rs.getString("author"),
                       rs.getString("review"));
          r.setID(rs.getInt("id_review"));
          reviewList.add(r);

        }
        //System.out.println("En ny review: " + r.id_review() + " " + r.review());
        //System.out.println("ReviewList: " + reviewList);
        return reviewList;
      } catch (Exception e){
        System.err.println("getByMovieID: " + e.getMessage());
      } finally {
        db.closeIt(rs);
      }
      return null;
    }

    public Review getByReviewID(int id_review){
      //System.out.println("Get id_review: " + id_review);
      String SQL = "SELECT * FROM review WHERE id_review =" + id_review;
      //System.out.println("--DEBUG: SQL: " + SQL);
      ResultSet rs = db.executeQuery(SQL);
      System.out.println(rs);
      Review r = null;
      try {
        if (rs.next()){
          r = new Review(rs.getInt("id_review"),
                       rs.getInt("id_movie"),
                       rs.getInt("score"),
                       rs.getString("author"),
                       rs.getString("review"));
          r.setID(rs.getInt("id_review"));
        }
        return r;
      } catch (Exception e){
        System.err.println("getByID: " + e.getMessage());
      } finally {
        db.closeIt(rs);
      }
      return null;
    } */
}

