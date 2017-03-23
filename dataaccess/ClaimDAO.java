package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbconnection.DBConnection;
import domain.Claim;
import domain.Customer;

public class ClaimDAO {
public Claim enter(String type,String pid,String cid,String uid)
{    String sql1;
     int a=0;
	 float dat=0;  
     int dat1=0; 
     float dat2=0;
	    Connection con = DBConnection.getConnection();
     PreparedStatement s = null;
     Customer user = null;
     try {   System.out.println(pid);
			String sql = "SELECT Policy_amount from vehicle_registration where Policy_id = ?";
			s = con.prepareStatement(sql);
			s.setString(1,pid);
     } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
     String t=type.substring(0,2);
    
         ResultSet rSet = null;
		try {
			rSet = s.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         try {
			if (rSet.next()) 
			dat2= Float.parseFloat(rSet.getString("Policy_amount"));
			System.out.println(dat2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
        if(t.equals("TW"))
        {
        	 sql1 = "SELECT Two_wheeler from accident where Accident_type = ?";
        	
        }
        		
        else
        {
        	 sql1 = "SELECT Four_wheeler from accident where Accident_type = ?";
        }
    	try {
			s = con.prepareStatement(sql1);
		
		s.setString(1,type);
        
		 ResultSet rSet1 = s.executeQuery();
         if (rSet1.next()) 
        dat1= Integer.parseInt(rSet1.getString(1));
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 dat= (dat2*dat1)/100;
    	 System.out.println(dat);
    	 if(con!=null)
 		{
 			
 		
 			String sql="INSERT INTO claim (	Claim_id, Policy_id, Claim_type, User_name, Total_amount, Accident_type, Weightage,Claimed_amount) VALUES(?,?,?,?,?,?,?,?)";
 			
 			PreparedStatement stmt;
 			try {
 				stmt = con.prepareStatement(sql);
 		
 			
 		
 			stmt.setString(1,cid);
 			stmt.setString(2, pid);
 			stmt.setString(3,"Accident");
 			stmt.setString(4, uid);
 			stmt.setFloat(5,dat2 );
 			stmt.setString(6,type );
 			stmt.setFloat(7, dat1);
 			stmt.setFloat(8, dat);
 		
 			
 			 a= stmt.executeUpdate();
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		}
    	 Claim cb=new Claim(cid,pid,dat1,type,dat);
    	return cb;
    	}

public Claim entertheft(String b,String cid,String pid,String date,String date2,String fir,String police)
{    String sql1;
      int a=0;
      float dat=0;
      float dat2=0;
	    Connection con = DBConnection.getConnection();
     PreparedStatement s = null;
     Customer user = null;
     try {   System.out.println(pid);
			String sql = "SELECT Policy_amount from vehicle_registration where Policy_id = ?";
			s = con.prepareStatement(sql);
			s.setString(1,pid);
            ResultSet rSet = null;	
			rSet = s.executeQuery();
			if (rSet.next()) 
			dat2= Float.parseFloat(rSet.getString("Policy_amount"));
			System.out.println(dat2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     dat=(float) (dat2*0.70);
     
     if(con!=null)
		{
			
		
			String sql="INSERT INTO claim (	Claim_id, Policy_id, Claim_type, User_name, Total_amount, Weightage,Date_of_theft,Date_of_complaint,Fir_no,Police_station_branch,Claimed_amount) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement stmt;
			try {
				stmt = con.prepareStatement(sql);
		
			
		
			stmt.setString(1,b);
			stmt.setString(2, pid);
			stmt.setString(3,"Theft");
			stmt.setString(4, cid);
			stmt.setFloat(5,dat2 );
			stmt.setString(6,"70" );
			stmt.setString(7, date);
			stmt.setString(8, date2);
			stmt.setString(9, fir);
			stmt.setString(10, police);
			stmt.setFloat(11, dat);
			 a= stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
 	 Claim cb=new Claim(cid,pid,date,date2,fir,police,dat);
 	return cb;
 	}

}

