package se.iths.app;

//import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Report {
  
  private int report_id;
  private LocalDate datum;
  private int pass;
  private int kaj_id;
  private int voltyp_id;
  private int ship_id;
  private int total_price;
  
  private String kaj_namn;
  private String ship_name;
  private String company;
  private String strDatum;
  private String voltyp_namn;
  
  
/*  public Report (int report_id, LocalDate datum, int pass, 
      String kaj_namn, String ship_namn, String company, int total_price) {
    this.report_id = report_id;
    this.datum = datum; 
    this.pass = pass;
    this.kaj_namn = kaj_namn;
    this.ship_namn = ship_namn;
    this.company = company;
    this.total_price = total_price;
  }*/
  public Report (int report_id, String datum, int pass, 
      String kaj_namn, String voltyp_namn, String ship_name, String company, int total_price) {
    this.report_id = report_id;
    this.strDatum = datum; 
    this.pass = pass;
    this.kaj_namn = kaj_namn;
    this.voltyp_namn = voltyp_namn;
    this.ship_name = ship_name;
    this.company = company;
    this.total_price = total_price;
  }
  public String voltyp_namn() {
    return this.voltyp_namn;
  }
  public String strDatum() {
    return this.strDatum;
  }
  public String kaj_namn() {
   return this.kaj_namn; 
  }
  public String ship_namn() {
   return this.ship_name; 
  }
  public String company() {
   return this.company; 
  }
  public int report_id() {
    return this.report_id;
  }

  public Report(LocalDate datum, int pass, int kaj_id) {
    this.datum = datum;
    this.pass = pass;
    this.kaj_id = kaj_id;
  }
  public Report (int report_id, 
                  int pass, 
                  int kaj_id, 
                  int ship_id,
                  int total_price) {
    this.report_id = report_id;
    this.datum = datum;
    this.pass = pass;
    this.kaj_id = kaj_id;
    this.ship_id = ship_id;
    this.total_price = total_price;
  }
  public Report (int report_id, 
                LocalDate datum, 
                int pass, 
                int kaj_id, 
                int ship_id,
                int total_price) {
    this.report_id = report_id;
    this.datum = datum;
    this.pass = pass;
    this.kaj_id = kaj_id;
    this.ship_id = ship_id;
    this.total_price = total_price;
  }
  
  public Report(int pass, int kaj_id) {
    this.pass = pass;
    this.kaj_id = kaj_id;
  }
  
  /*
  public Report (ArrayList<Object> props)  {
    this.report_id = 0;
    
    this.datum = (date) props.get(0);
    this.pass = pass;
    this.kaj_id = kaj_id;
    this.emp_id = emp_id;
    this.tr_typ_id = tr_typ_id;
    this.ship_id = ship_id;
    this.total_price = total_price;
  }*/

  public Report() {
    
  }  
  public LocalDate datum() {
    return this.datum;
  }
  public int pass() {
    return this.pass;
  }
  public int kaj_id() {
    return this.kaj_id;
  }
  public int ship_id() {
    return this.ship_id;
  }
  public int total_price() {
    return this.total_price;
  }
  public void setId(int id) {
    this.report_id = id;
  }

}
