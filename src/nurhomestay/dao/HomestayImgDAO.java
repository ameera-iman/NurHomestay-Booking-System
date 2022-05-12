package nurhomestay.dao;

//import java.io.File;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import nurhomestay.connection.ConnectionManager;
import nurhomestay.model.HomestayImg;


public class HomestayImgDAO {
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static int homestayId,imageId;
	static String home_image;

	
	
	
	public HomestayImg getHomestayImg(HomestayImg homestayImg) {
		home_image = homestayImg.getHome_image();
		homestayId = homestayImg.getHomestayId();

        String searchQuery = "select * from homestayImg where home_image='" + home_image + "', homestayid = '" + homestayId+"'";


        try {
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();
            
            System.out.println(searchQuery);

            // if homestay exists set the isValid variable to true
            if (more) {
                homestayImg.setValid(true);
           	}
           
            else if (!more) {            	
            	homestayImg.setValid(false);
            }
           
        }

        catch (Exception ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        }

        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                }
                stmt = null;
            }

            if (currentCon != null) {
                try {
                    currentCon.close();
                } catch (Exception e) {
                }

                currentCon = null;
            }
        }

        return homestayImg;
	}
	
	public int getImageId (String home_image, int homestayId) {
		

		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("select * from homestayImg where home_image=? and homestayid=?");

			ps.setString(1, home_image);
			ps.setInt(2,  homestayId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				 imageId = rs.getInt("imageId");
			}
		} catch (SQLException e) {
			System.out.println("failed: An Exception has occurred! " + e);
		}
		return   imageId;
	}

	
	
	public HomestayImg getHomestayImgById(int imageId) {

		HomestayImg homestayImg= new HomestayImg();

		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("select * from homestayImg where imageId=?");

			ps.setInt(1, imageId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				
		        homestayImg.setImageId(rs.getInt("imageId"));
	            homestayImg.setHome_image(rs.getString("home_image"));		          
	            homestayImg.setHomestayId(rs.getInt("homestayId"));
	            
			}
		} catch (SQLException e) {
			System.out.println("failed: An Exception has occurred! " + e);
		}
		return homestayImg;
	}
	

	public List<HomestayImg> getAllHomestayImg() {
		List<HomestayImg> homestaysImg = new ArrayList<HomestayImg>();
		  
		  try {
		  	currentCon = ConnectionManager.getConnection();
		  	stmt = currentCon.createStatement();
		  
		  	  String q = "select * from homestayImg";
		      ResultSet rs = stmt.executeQuery(q);
		      
		      while (rs.next()) {
		          HomestayImg homestayImg = new HomestayImg();		          
		          
		          homestayImg.setImageId(rs.getInt("imageId"));
		          homestayImg.setHome_image(rs.getString("home_image"));
		          homestayImg.setHomestayId(rs.getInt("homestayId"));
		          homestaysImg.add(homestayImg);
		      }
		  } catch (SQLException e) {
		      e.printStackTrace();
		  }

		  return homestaysImg;
	}
	
	public void deleteImage(int imageId)
	{
		String searchQuery = "delete from homestayImg where imageId=" + "'" + imageId + "'";
		
		System.out.println(searchQuery);
		
		try {
	
	        currentCon = ConnectionManager.getConnection();
	        stmt = currentCon.createStatement();
	        stmt.executeUpdate(searchQuery);
	        System.out.println("dah delete");
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}

	public void addImage(HomestayImg homestayImg)
	{
		imageId = homestayImg.getHomestayId();
		home_image = homestayImg.getHome_image();
		homestayId = homestayImg.getHomestayId();
		
		try {
			currentCon = ConnectionManager.getConnection();
    		ps=currentCon.prepareStatement("insert into homestayImg (home_image,homestayId)values(?,?)");
    		ps.setString(1,home_image);
    		ps.setInt(2,homestayId);
    		ps.executeUpdate();
    		System.out.println("Home image name:"+home_image);
			System.out.println("Homestay ID :"+homestayId);
		}
		catch (Exception ex) {
    		System.out.println("failed: An Exception has occurred! " + ex);
    	}

    	finally {
    		if (ps != null) {
    			try {
    				ps.close();
    			} catch (Exception e) {
    			}
    			ps = null;
    		}
    		
    		if (currentCon != null) {
    			try {
    				currentCon.close();
    			} catch (Exception e) {
    			}
    			currentCon = null;
    		}
    	}
	}
	
	public List<HomestayImg> getAllHomestayImgByHomeid(int homestayId) {
		List<HomestayImg> homestaysImg = new ArrayList<HomestayImg>();
		  
		  try {
		  	currentCon = ConnectionManager.getConnection();
		  	stmt = currentCon.createStatement();
		  
		  	  String q = "select * from homestayImg where homestayid = "+homestayId;
		      ResultSet rs = stmt.executeQuery(q);
		      
		      while (rs.next()) {
		          HomestayImg homestayImg = new HomestayImg();		          
		          
		          homestayImg.setImageId(rs.getInt("imageId"));
		          homestayImg.setHome_image(rs.getString("home_image"));
		          homestayImg.setHomestayId(rs.getInt("homestayId"));
		          homestaysImg.add(homestayImg);
		      }
		  } catch (SQLException e) {
		      e.printStackTrace();
		  }

		  return homestaysImg;
	}
	
	public List<HomestayImg> getAllHomestayImgByHomestayId(int homestayId) {
		List<HomestayImg> homestaysImg = new ArrayList<HomestayImg>();
		  
		  try {
		  	currentCon = ConnectionManager.getConnection();
		  	stmt = currentCon.createStatement();
		  	System.out.println("hjhajugbqaqsjb");
		  	  String q = "select * from homestayImg where homestayId=" + "'" + homestayId + "'";
		  	  System.out.println(q);
		      ResultSet rs = stmt.executeQuery(q);
		      
		      while (rs.next()) {
		          HomestayImg homestayImg = new HomestayImg();		          
		          
		          homestayImg.setImageId(rs.getInt("imageId"));
		          homestayImg.setHome_image(rs.getString("home_image"));
		          System.out.println(rs.getString("home_image"));
		          homestayImg.setHomestayId(rs.getInt("homestayId"));
		          homestaysImg.add(homestayImg);
		      }
		  } catch (SQLException e) {
		      e.printStackTrace();
		  }

		  return homestaysImg;
	}
	
}


