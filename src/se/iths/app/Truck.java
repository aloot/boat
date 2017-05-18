package se.iths.app;

import se.iths.app.DBUtils;
import java.util.ArrayList;

public class Truck {
  public int truck_id;
  public int tr_typ_id;
  public int tr_status_id;
  

  private DBUtils db = DBUtils.getInstance();

  
  public Truck(int truck_id, int tr_typ_id, int tr_status_id) {
    this.truck_id = truck_id;
    this.tr_typ_id = tr_typ_id;
    this.tr_status_id = tr_status_id;
  }
  
  public Truck(ArrayList<Integer> props) {
    this.truck_id = 0;
    this.tr_typ_id = props.get(0);
    this.tr_status_id = props.get(1);
  }
  
  
  public int truckID() {
   return this.truck_id; 
  }
  public int truckType() {
    return this.tr_typ_id;
  }
  public int truckStatus() {
    return this.tr_status_id;
  }
  
  
  public void setStatus(int newStatus) {
    this.tr_status_id = newStatus;
  }
  
  @Override // ta bort id_movie från utskrift
  public String toString(){
  return  truck_id + " | " + tr_typ_id + " | " + tr_status_id;
  }
}
