package se.iths.app;

import se.iths.app.DBUtils;
import java.util.ArrayList;

public class Employee {
  public int emp_id;
  public String f_name;
  public String s_name;
  public int kk_id;
  public int empstatus_id;
  public int schema_id;
 
  private DBUtils db = DBUtils.getInstance();
  
   
  public Employee(int emp_id
		  ,String f_name
		  ,String s_name
		  ,int kk_id
		  ,int empstatus_id
		  ,int schema_id) {
    this.emp_id = emp_id;
    this.f_name = f_name;
    this.s_name = s_name;
    this.kk_id = kk_id;
    this.empstatus_id = empstatus_id;
    this.schema_id = schema_id;
    }
  
  public Employee(ArrayList<String> props) {
	  	this.emp_id = 0;
	    this.f_name =  props.get(0);
	    this.s_name =  props.get(1);
	    this.kk_id =  Integer.parseInt(props.get(2));
	    this.empstatus_id = Integer.parseInt(props.get(3));
	    this.schema_id = Integer.parseInt(props.get(4));
  }
  
  
  public int emp_id() {
   return this.emp_id; 
  }
  public String f_name() {
    return this.f_name;
  }
  public String s_name() {
	    return this.s_name;
	  }
  public int kk_id() {
	    return this.kk_id;
	  }
  public int empstatus_id() {
	    return this.empstatus_id;
	  }
  public int schema_id() {
    return this.schema_id;
  }
  
   @Override // ta bort id_movie från utskrift
  public String toString(){
  return  emp_id + " | " + f_name + " | " + " | " + s_name + " | " +" | " + kk_id + " | " + schema_id + " | " + empstatus_id;
  }
}
