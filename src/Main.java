import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;



import java.util.Date;

import business.CustomerBO;
import business.VehicleBO;
import domain.Customer;

public class Main {
       
       public static void main(String args[]) throws IOException{
              
              BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
              String name,password,add,city,state,cntry,email,gen;
            int pin,pin1,no;
           String dob = null;
             
              System.out.println("Login(L) or Registration(R)");
             CustomerBO ubo=new CustomerBO();
             VehicleBO vbo=new VehicleBO();
              char c=br.readLine().charAt(0);
              if(c=='L'){
                  /*   System.out.println("Enter name");
                     name=br.readLine();
                   */  
            	  System.out.println("Enter pin");
                  pin1=Integer.parseInt(br.readLine());
                  
            	    System.out.println("Enter password");
                     password=br.readLine();
                     
                    System.out.println("Enter address");
                     add=br.readLine();
                     
                     System.out.println("Enter city"); 
                     city=br.readLine();
                     
                     System.out.println("Enter state");
                     state=br.readLine();
                     
                   /*  System.out.println("Enter cntry");
                     cntry=br.readLine();
                    */ 
                     System.out.println("Enter pin");
                     pin=Integer.parseInt(br.readLine());
                     
                     System.out.println("Enter email");
                     
                     email=br.readLine();
                    /*
                     System.out.println("Enter grnder");
                    gen=br.readLine();
                   */ 
                    System.out.println("Enter no");
                  no=Integer.parseInt(br.readLine());
                  
                 // SimpleDateFormat df = new SimpleDateFormat("mm/dd/yyyy");
                  System.out.println("Enter dob");
              
           dob = br.readLine();
              /*      boolean b=false;
					try {
						b = ubo.register( name,password,add,city,state,cntry,pin,email,gen,no,dob);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
              */    /*   if(b==true){
                    	 System.out.println("Successful done");
                     }
                    	 else 	  
                    	 System.out.println("Successful3");
              */
                     boolean b=false;
                     try {
					//	b = ubo.validateLogin(pin,password);
						b=vbo.register(pin1, password, add, city, state, pin, email, no, dob);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						if(b==true){
	                    	 System.out.println("Successful done");
						}
						 else 	  
	                    	 System.out.println("Successful3");
                     
              }
       }
}