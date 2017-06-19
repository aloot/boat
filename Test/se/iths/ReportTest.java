package se.iths;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import se.iths.app.Report;
import se.iths.app.ReportSql;

public class ReportTest {
ReportSql repSql;

@BeforeClass
public static void before(){
	System.out.println("Here we go.");
}

@Before
public void start (){
	repSql = new ReportSql();
}

@AfterClass
public static void after(){
	System.out.println("Peace out!");
	}

@Test
@Category(ReportTest.class)
public void testReport() {
	
	String strDate1 = "2017-01-01";
	String strDate2 = "2017-01-08";
	ArrayList<Report> list = repSql.getReads(strDate1, strDate2);
	
	equals(list.get(0).datum());
	}
}
