package se.iths.app;

import java.util.*;
import java.sql.ResultSet;

import se.iths.app.Truck;
import se.iths.app.TruckTyp;

public class TruckSql {

  DBUtils db = DBUtils.getInstance();

    public void selectTruckByKK(int kkType, int ant){
      ArrayList<Object> truckList = new ArrayList<Object>();
      ArrayList<Truck> tmpTList = new ArrayList<>();
      ArrayList<TruckTyp> tmpTTList = new ArrayList<>();
      ArrayList<String> tmpStatList = new ArrayList<>();
      ArrayList<Truck> tList = new ArrayList<>();
      ArrayList<TruckTyp> ttList = new ArrayList<>();
      ArrayList<String> statList = new ArrayList<>();
      ArrayList<Integer> keepList = null;
      
      int counter = 0;
//      String SQL = "SELECT * from truck limit 30";
      String SQL = "SELECT t.truck_id, t.tr_typ_id, t.tr_status_id, "
          + "tt.tr_typ_namn, tt.tr_typ_pris, ts.tr_status_namn "
          + "FROM truck t, trucktyp tt, truckstatus ts "
          + "WHERE t.tr_typ_id = tt.tr_typ_id "
          + "AND t.tr_status_id = ts.tr_status_id AND tt.tr_typ_id =" + kkType; 
      ResultSet rs = db.executeQuery(SQL);
      try{
        Truck t = null;
        TruckTyp tt = null;
        String trStat = null;
        while(rs.next()){
          t = new Truck(rs.getInt("truck_id"),
              rs.getInt("tr_typ_id"),
              rs.getInt("tr_status_id"));
          truckList.add(t);
          tt = new TruckTyp(rs.getString("tr_typ_namn"),
              rs.getInt("tr_typ_pris"));
          truckList.add(tt);
          trStat = rs.getString("tr_status_namn");
          truckList.add(trStat);
        }
        db.closeIt(rs);
      } catch (Exception e){
        System.err.println("Retrieving selectTruckByKK: " + e.getMessage());
        db.closeIt(rs);
      }
      /**
       * Get big sql-list sorted
       */
      for (int i = 0; i < truckList.size(); i = i + 3) {
        tmpTList.add((Truck) truckList.get(i));
        tmpTTList.add((TruckTyp) truckList.get(i + 1));
        tmpStatList.add((String) truckList.get(i + 2));
      }
      /**
       * Populate a keep-list
       */

      keepList = new ArrayList<>();
      for (int i = 0; i < tmpTList.size(); i ++) {
        if (tmpTList.get(i).tr_status_id() == 1 || tmpTList.get(i).tr_status_id() == 3) {
          keepList.add(i);
 //         System.out.println("keepL: " + keepList);
 //         System.out.println("truck: " + tmpTList.get(i).truck_id() + ": " + tmpTList.get(i).tr_status_id());
        }
      }
 //     System.out.println("keepL: " + keepList);
 //     System.out.println(keepList.size());

      if (keepList.size() < tmpTList.size()) {
        for (int i = 0; i < keepList.size(); i ++) {
          tList.add(tmpTList.get(keepList.get(i)));
          ttList.add(tmpTTList.get(keepList.get(i)));
          statList.add(tmpStatList.get(keepList.get(i)));
          counter ++;
        }
      } else {
        tList = new ArrayList<>(tmpTList);
        ttList = new ArrayList<>(tmpTTList);
        statList = new ArrayList<>(tmpStatList);
        counter = statList.size();
      }
      
      if (statList.size() > ant) {
        statList.subList(ant, statList.size()).clear();
      }

      System.out.println("Available machinery: "); 
      
      for (int i = 0; i < statList.size(); i ++) {
        if (tList.get(i).truck_id() < 10) {
          System.out.print("  " + tList.get(i).truck_id() + " ");
        } else if (tList.get(i).truck_id() < 100) {
          System.out.print(" " + tList.get(i).truck_id() + " ");
        } else {
          System.out.print(tList.get(i).truck_id() + " ");
        }
        System.out.print(ttList.get(i).tr_typ_namn() + " ");
        System.out.print(ttList.get(i).tr_typ_pris() + " ");
        System.out.println(statList.get(i));
      }
      System.out.println("- Trucks matching search criteria: " + counter);

      System.out.println("- - - ");
    }

 /*   public List<Truck> getAllReviewsFullData(){
      ArrayList<Truck> reviewList = new ArrayList<Truck>();
      ResultSet rs = db.executeQuery("SELECT * FROM review order by lower(author)  asc");
      try{
        Review r = null;
        while(rs.next()){
          r = new Review(rs.getInt("id_review"),
                             rs.getInt("id_movie"),
                             rs.getInt("score"),
                             rs.getString("author"),
                             rs.getString("review")
                             );
          r.setID(rs.getInt("id_review"));
          reviewList.add(r);
        }
        db.closeIt(rs);
        return reviewList;
      } catch (Exception e){
        System.err.println("Getting all reviews: " + e.getMessage());
        db.closeIt(rs);
      }
      return null;
    }*/

 
}

