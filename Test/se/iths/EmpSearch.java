package se.iths;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.AfterClass;

import org.junit.experimental.categories.Category;
import se.iths.app.EmployeeSql;


		// TODO Auto-generated method stub
		public class EmpSearch {
			private ArrayList<String> employeeObj = new ArrayList<String>();
			private ArrayList<String> addEmployeeList = new ArrayList<String>();
		    private EmployeeSql empdb = new EmployeeSql();  
			EmployeeSql empSql;
				
			@BeforeClass
			public static void before(){
				System.out.println("Välkommen! Nu kör vi igång.");
			}
			
			@Before
			public void start (){
				empSql = new EmployeeSql();
			}
			
			@AfterClass
			public static void after(){
				System.out.println("Tack för idag!");
				}

			@Test
			@Category(EmployeeTest.class)
			public void testSearch() {
				int searchNr = 74;
				employeeObj = empdb.searchOnNr(searchNr);
				assertEquals("Porter", employeeObj.get(1));
				}

			@Test
			@Category(EmployeeTest.class)
			public void testUpdateStatus() {
				//75|Lydia|Zamora|7|4|4
				//1|100%
				//2|50%
				//3|Sick
				//4|Child care
				//5|Studies
				//6|Vacation
				//7|Terminated
				int searchNr = 75;
				empdb.updateEmployee("empstatus_id",  "5" , searchNr);
				employeeObj = empdb.searchOnNr(searchNr);
				assertEquals("Studies", employeeObj.get(4));
				}
				
}

