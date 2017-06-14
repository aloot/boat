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
			public void testAdd() {
				int searchNr = 74;
				employeeObj = empdb.searchOnNr(searchNr);
				assertEquals("Porter", employeeObj.get(1));
				}

	}

//}
