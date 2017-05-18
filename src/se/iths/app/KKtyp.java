package se.iths.app;


public class KKtyp {
  private int kk_id;
  private String kk_namn;
  private String kk_pris;
  
  public KKtyp() {
    
  }
  
  public KKtyp(String namn) {
    this.kk_namn = namn;
  }
  public KKtyp(String namn, String pris) {
    this.kk_namn = namn;
    this.kk_pris = pris;
  }

  public String kk_namn(){
    return this.kk_namn;
  }
  
 
}
