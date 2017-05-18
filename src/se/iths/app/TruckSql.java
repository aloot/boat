package se.iths.app;

import java.util.*;
import java.sql.ResultSet;
 

public class TruckSql {

  DBUtils db = DBUtils.getInstance();

    public ArrayList<Truck> getFullTruckList(){
      ArrayList<Truck> truckList = new ArrayList<Truck>();
//      String SQL = "SELECT * from t.*, tt.*, ts.* FROM truck t, trucktyp tt, trstatus ts WHERE t.tr_typ_id = tt.tr_typ_id and t.tr_status_id = ts.tr_status_id LIMIT 20";
      String SQL = "SELECT * from truck limit 230";  
      ResultSet rs = db.executeQuery(SQL);
      //ResultSet rs = db.executeQuery("SELECT * FROM movie ORDER BY id_movie");
      //"SELECT ma.character, a.*, m.* FROM movie_actor ma, actor a, movie m 
      //WHERE ma.id_movie ='" + id_movie + "' and ma.id_actor = a.id_actor and ma.id_movie = m.id_movie";
      try{
        Truck t = null;
        while(rs.next()){
          t = new Truck(rs.getInt("truck_id"),
                          rs.getInt("tr_typ_id"),
                          rs.getInt("tr_status_id"));
          truckList.add(t);
        }
        db.closeIt(rs);
        return truckList;
      } catch (Exception e){
        System.err.println("Retrieving list of trucks: " + e.getMessage());
        db.closeIt(rs);
      }
      return null;
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

