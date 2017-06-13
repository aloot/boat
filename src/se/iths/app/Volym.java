package se.iths.app;

public class Volym {
  private int voltyp_id;
  private String voltyp_namn;
  private int voltyp_ant_emp;
  private int kk_id;
  private String kk_namn;
  private int kaj_id;
  private int tr_typ_id;
  
  public Volym (int voltyp_id, 
      String voltyp_namn, 
      int voltyp_ant_emp, 
      int kk_id, 
      int kaj_id, 
      int tr_typ_id) {
    this.voltyp_id = voltyp_id;
    this.voltyp_namn = voltyp_namn;
    this.voltyp_ant_emp = voltyp_ant_emp;
    this.kk_id = kk_id;
    this.kaj_id = kaj_id;
    this.tr_typ_id = tr_typ_id;
  }
  
  
  public int voltyp_id() {
    return this.voltyp_id;
  }
  public String voltyp_namn() {
    return this.voltyp_namn;
  }
  public int voltyp_ant_emp() {
    return this.voltyp_ant_emp;
  }
  public int kk_id() {
    return this.kk_id;
  }
  public String kk_namn() {
    return this.kk_namn;
}
  public int kaj_id() {
    return this.kaj_id;
  }
  public int tr_typ_id() {
    return this.tr_typ_id;
  }
  
}
