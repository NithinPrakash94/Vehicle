package business;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.Cookie;

import dataaccess.ClaimDAO;
import domain.Claim;

public class ClaimBO {
	
	public Claim enter(String type,String cid,String pid)
	{
		
		Calendar cal = Calendar.getInstance();
		String a=new SimpleDateFormat("yyyy-MMM-dd").format(cal.getTime());
		String b=a.substring(5,8);
		b=b.concat(a.substring(2,4));
	    int randomPIN = (int)(Math.random()*9000)+1000;
	    String val = ""+randomPIN;
        b=b.concat(val);
	    ClaimDAO cdao=new ClaimDAO();
	    Claim cd= cdao.enter(type,pid,b,cid);
	    return cd;
	
	}
	
	public Claim entertheft(String cid,String pid,String date,String date2,String fir,String police)
	{
		Calendar cal = Calendar.getInstance();
		String a=new SimpleDateFormat("yyyy-MMM-dd").format(cal.getTime());
		String b=a.substring(5,8);
		b=b.concat(a.substring(2,4));
	    int randomPIN = (int)(Math.random()*9000)+1000;
	    String val = ""+randomPIN;
        b=b.concat(val);
	    ClaimDAO cdao=new ClaimDAO();
	    Claim cd= cdao.entertheft(b,cid,pid,date,date2,fir,police);
	    return cd;
		
	}

}
