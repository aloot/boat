package se.iths.app;

import java.util.*;
import java.sql.ResultSet;

import se.iths.app.Truck;
import se.iths.app.TruckTyp;

public class TruckSql {

  DBUtils db = DBUtils.getInstance();

    public void selectTruckByKK(int kkType){
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
 //     System.out.println(tmpTList.size());
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
      }
      
      
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
      System.out.println("Trucks matching search criteria: " + counter);

      System.out.println("- - - ");
      
/*      for (int i = 0; i < tmpStatList.size(); i ++) {
        if (tmpStatList.get(i).indexOf('%') > 0) {
          keepList.add(i);
        }
      }
      System.out.println("keepL: " + keepList);
      
      
      if (keepList.size() < tmpEmpList.size()) {
        for (int i = 0; i < keepList.size(); i ++) {
          empList.add(tmpEmpList.get(keepList.get(i)));
          kkList.add(tmpKKList.get(keepList.get(i)));
          statList.add(tmpStatList.get(keepList.get(i)));
          counter ++;
        }*/
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
    }

    public void deleteReview(int id_review){
//      int id_review = r.id_review();
      String SQL="DELETE FROM review"+
        " WHERE id_review=" + id_review;
      System.out.println(db.executeUpdate(SQL) +
                         " rows deleted");
    }
    /**
     * Inserts m into the database and sets the id of m to the
     * MunicipalityID it gets.
     */
/*    public void addReview(Review r){
      //int id=r.id();
      int id_movie = r.id_movie();
      int score = r.score();
      String author = r.author();
      String review = r.review();
      String SQL = "INSERT INTO review " +
        "(id_movie, score, author, review)" +
        " VALUES('" + id_movie + "', " +
        "'" + score + "', " +
        "'" + author + "', " +
        "'" + review + "')";

//        System.out.println("sql-et: " + SQL);
      System.out.println(db.executeUpdate(SQL)+
                         " rows inserted");

  // osäker på vad denna gör uppdaterat från title till review/id_review/AK
      ResultSet rs = db.executeQuery("SELECT id_review"+
                                     " FROM review"+
                                     " WHERE review ='" + review + "'");
      try{
        rs.next();
        r.setID(rs.getInt("id_review"));
      } catch (Exception e){
        System.err.println("Getting ID: " + e.getMessage());
      } finally {
        db.closeIt(rs);
      }
    }

    public List<Review> getByMovieID(int id_movie){
      ArrayList<Review> reviewList = new ArrayList<Review>();
      //System.out.println("Get by id_movie: " + id_movie);
      String SQL = "SELECT * FROM review WHERE id_movie ='" + id_movie + "'";
      //System.out.println("--DEBUG: SQL: " + SQL);
      ResultSet rs = db.executeQuery(SQL);
      Review r = null;
      try {
        while (rs.next()){
          r = new Review(rs.getInt("id_review"),
                       rs.getInt("id_movie"),
                       rs.getInt("score"),
                       rs.getString("author"),
                       rs.getString("review"));
          r.setID(rs.getInt("id_review"));
          reviewList.add(r);

        }
        //System.out.println("En ny review: " + r.id_review() + " " + r.review());
        //System.out.println("ReviewList: " + reviewList);
        return reviewList;
      } catch (Exception e){
        System.err.println("getByMovieID: " + e.getMessage());
      } finally {
        db.closeIt(rs);
      }
      return null;
    }

    public Review getByReviewID(int id_review){
      //System.out.println("Get id_review: " + id_review);
      String SQL = "SELECT * FROM review WHERE id_review =" + id_review;
      //System.out.println("--DEBUG: SQL: " + SQL);
      ResultSet rs = db.executeQuery(SQL);
      System.out.println(rs);
      Review r = null;
      try {
        if (rs.next()){
          r = new Review(rs.getInt("id_review"),
                       rs.getInt("id_movie"),
                       rs.getInt("score"),
                       rs.getString("author"),
                       rs.getString("review"));
          r.setID(rs.getInt("id_review"));
        }
        return r;
      } catch (Exception e){
        System.err.println("getByID: " + e.getMessage());
      } finally {
        db.closeIt(rs);
      }
      return null;
    } */
}

