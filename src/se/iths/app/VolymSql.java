package se.iths.app;

import java.sql.ResultSet;
import se.iths.app.Volym;

public class VolymSql {

  DBUtils db = DBUtils.getInstance();

  public void vesselCallType(int volTyp) {
    
    Volym vol = null;
    String SQL = "SELECT v.voltyp_id, v.voltyp_namn, v.voltyp_ant_emp, "
        + "kk.kk_id, kt.kaj_id, tt.tr_typ_id "
        + "FROM volymtyp v, kktyp kk, kajtyp kt, trucktyp tt "
        + "WHERE v.voltyp_id = " + volTyp 
        + " AND v.kk_id = kk.kk_id AND v.kaj_id = kt.kaj_id AND v.tr_typ_id = tt.tr_typ_id";
    ResultSet rs = db.executeQuery(SQL);
    try{
      while(rs.next()){
        vol = new Volym(rs.getInt("voltyp_id"),
                        rs.getString("voltyp_namn"),
                        rs.getInt("voltyp_ant_emp"),
                        rs.getInt("kk_id"),
                        rs.getInt("kaj_id"),
                        rs.getInt("tr_typ_id"));
      }
      db.closeIt(rs);
    } catch (Exception e){
      System.err.println("Retrieving 'vesselCallType': " + e.getMessage());
      db.closeIt(rs);
    }
    KKtypSql kktyp = new KKtypSql();
    kktyp.selectEmpsByKK(vol.kk_id());
    
    TruckSql trucks = new TruckSql();
    trucks.selectTruckByKK(vol.kk_id());
    
    System.out.println("Cargo type: " + vol.voltyp_id());
    System.out.println("Cargo name: " + vol.voltyp_namn());
    System.out.println("Number of units needed: " + vol.voltyp_ant_emp());
    System.out.println("License : " + vol.kk_id());
    System.out.println("Truck type: " + vol.tr_typ_id());
    System.out.println("Berth: " + vol.kaj_id());
    
  }
}
