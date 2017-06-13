package se.iths.app;

public class Ship {

  private int ship_id;
  private String ship_name;
  private String comp;
  private int volym_id;
  
  
  public Ship(int ship_id, String ship_name, String comp, int volym_id) {
    this.ship_id = ship_id;
    this.ship_name = ship_name;
    this.comp = comp;
    this.volym_id = volym_id;
  }
  
  
  public int ship_id() {
    return this.ship_id;
  }
  public String ship_name() {
    return this.ship_name;
  }
  public String comp() {
   return this.comp; 
  }
  public int volym_id() {
   return this.volym_id; 
  }
  
}
