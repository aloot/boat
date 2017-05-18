package se.iths.app;

public class TruckTyp {

  private int tr_typ_id;
  private String tr_typ_namn;
  private int tr_typ_pris;
  
  public TruckTyp(int tr_typ_id, String tr_typ_namn, int tr_typ_pris) {
    this.tr_typ_id = tr_typ_id;
    this.tr_typ_namn = tr_typ_namn;
    this.tr_typ_pris = tr_typ_pris;
  }
  public TruckTyp(String tr_typ_namn, int tr_typ_pris) {
    this.tr_typ_namn = tr_typ_namn;
    this.tr_typ_pris = tr_typ_pris;
  }
  
  public String tr_typ_namn() {
    return this.tr_typ_namn;
  }
  public int tr_typ_pris() {
    return this.tr_typ_pris;
  }
    
}
