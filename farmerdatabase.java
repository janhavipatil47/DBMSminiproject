package javadb;
import java.sql.Connection;
import java.lang.Math;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class farmerd {

	public static void main(String[] args) throws ClassNotFoundException,SQLException {
	
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/farmerh","root","janhavi$5");
System.out.println("Connection established");
Scanner sc=new Scanner(System.in);
int pid=3001;
int regid;
System.out.println("Welcome,User!");
System.out.println("Enter your reg_id if already an existing user (else enter 0)");
regid=sc.nextInt();
if(regid==0)
{
	int min=1025;
	int max=1999;
	regid=(int)(Math.random()*(max-min+1)+min);

}
System.out.println("Enter your first name");
String Fname=sc.next();
System.out.println("Enter your middle name");
String Mname=sc.next();
System.out.println("Enter your last name");
String Lname=sc.next();
System.out.println("Welcome ,"+Fname);
System.out.println("Enter your phone number");
System.out.print("+91 ");
String contact=sc.next();
System.out.println("Enter your address: ");
String addr=sc.next();
System.out.println("Enter your birth date in the format(yyyy-mm-dd)");
String bdate=sc.next();
System.out.println("Enter your gender 'M' for Male, 'F' for female");
String gender=sc.next();

String query1="insert into farmer values(?,?,?,?,?,?,?,?)";
PreparedStatement p1=con.prepareStatement(query1);
p1.setInt(1, regid);
p1.setString(2, Lname);
p1.setString(3,Mname);
p1.setString(4,Fname);
p1.setString(5, addr);
p1.setString(6, bdate);
p1.setString(7, contact);
p1.setString(8, gender);
p1.execute();

int option;
do
{

System.out.println("Enter 1 to add your field");
System.out.println("Enter 2 to view the policies");
System.out.println("Enter 3 to view the loans");
System.out.println("Enter 4 to add the crops");
System.out.println("Enter 5 to add the fertilizers");
System.out.println("Enter 6 to view the number of farmers according to gender");
System.out.println("Enter 7 to view loans availed by farmers ");
System.out.println("Enter 8 to view all the farmers whose loan amount is greater than 20000");
System.out.println("Enter 9 to view the farmers who have applied for Agricultural Loan");
option=sc.nextInt();
switch(option)
{
case 1:{
System.out.println("Where do you have the field? Enter the location of field ");
String Field=sc.next();

System.out.println("Enter the area of field");
int area=sc.nextInt();
int i=1;
int fieldid=2011+i;
System.out.println("The field ID is: " +fieldid);
i++;
int fie=1;


String query2="insert into field values (?,?,?,?)";
PreparedStatement p2=con.prepareStatement(query2);
p2.setInt(1, fieldid);
p2.setInt(2, area);
p2.setString(3, Field);
p2.setInt(4, regid);
p2.execute();
System.out.println("Field record added successfully");
while(fie==1)
{
System.out.println("Do you want to enlist more fields? If yes, type 1");
fie=sc.nextInt();
if(fie==1)
{System.out.println("Where do you have the field? Enter the location of field ");
 Field=sc.next();

System.out.println("Enter the area of field");
 area=sc.nextInt();
fieldid=2011+i;
System.out.println("The field ID is: " +fieldid);
String query3="insert into field values (?,?,?,?)";
PreparedStatement p3=con.prepareStatement(query3);
p3.setInt(1, fieldid);
p3.setInt(2, area);
p3.setString(3, Field);
p3.setInt(4, regid);
p3.execute();
System.out.println("Field record added successfully");
i++;
    
}



}
break;
}
case 2:
{

System.out.println("The policies which you can avail are as follows");
System.out.println("Crop Insurance - ID " +pid);
pid++;
System.out.println("Fertilizer Subsidy -ID "  +pid);
pid++;
System.out.println("Loan Interest Waiver- ID " +pid);
pid++;
System.out.println("Organic Farming Support -ID " +pid);
pid++;
System.out.println("Seed Quality Assurance -ID " +pid);
pid++;
System.out.println("Equipment Rental Program -ID " +pid);
pid++;
System.out.println("Water Conservation Grant -ID " +pid);
pid++;
System.out.println("Training and Workshops - ID " +pid);
System.out.println("Enter the ID mentioned in front of every scheme to get its details or enter 0 to exit");
int schde=sc.nextInt();
switch(schde)
{
    case 3001:{
        int dpid=3001;
        String pname="Crop Insurance";
        String sdate="01-01-2023";
        String edate="01-01-2024";
        System.out.println("Policy name: "+ pname);
        System.out.println("Start Date: "+ sdate );
        System.out.println("End date: "+ edate);
        System.out.println("Organisation:Government of India");
         System.out.println("Do you want to apply for this policy,type 1");
        int poap=sc.nextInt();
        if(poap==1)
        {
        	String query4="insert into policies_availed values(?,?,?,?)";
        	PreparedStatement p4=con.prepareStatement(query4);
        	p4.setInt(1, regid);
        	p4.setString(2, Fname);
        	p4.setInt(3, dpid);
        	p4.setString(4, pname);
        	p4.execute();
        	String pola="Applied";
            System.out.println(pola);
        }
        break;
    }
    case 3002:
        {int dpid=3002;
        String pname="Fertilizer Subsidy";
            String sdate="01-02-2023";
        String edate="01-02-2024";
        System.out.println("Policy name: "+ pname);
        System.out.println("Start Date: "+ sdate );
        System.out.println("End date: "+ edate);
        System.out.println("Organisation:Government of India");
        System.out.println("Do you want to apply for this policy,type 1");
        int poap=sc.nextInt();
        if(poap==1)
        {
        	String query4="insert into policies_availed values(?,?,?,?)";
        	PreparedStatement p4=con.prepareStatement(query4);
        	p4.setInt(1, regid);
        	p4.setString(2, Fname);
        	p4.setInt(3, dpid);
        	p4.setString(4, pname);
        	p4.execute();
            String pola="Applied";
            System.out.println(pola);
        }
        break;
        
    }
     case 3003:
        {int dpid=3003;
        String pname="Loan Interest Waiver";
            String sdate="01-03-2023";
        String edate="01-03-2024";
        System.out.println("Policy name: "+ pname);
        System.out.println("Start Date: "+ sdate );
        System.out.println("End date: "+ edate);
        System.out.println("Organisation:Government of India");
         System.out.println("Do you want to apply for this policy,type 1");
        int poap=sc.nextInt();
        if(poap==1)
        {
        	String query4="insert into policies_availed values(?,?,?,?)";
        	PreparedStatement p4=con.prepareStatement(query4);
        	p4.setInt(1, regid);
        	p4.setString(2, Fname);
        	p4.setInt(3, dpid);
        	p4.setString(4, pname);
        	p4.execute();
            String pola="Applied";
            System.out.println(pola);
        }
        break;
    }
     case 3004:
        {int dpid=3004;
        String pname="Organic Farming Support";
            String sdate="01-04-2023";
        String edate="01-04-2024";
        System.out.println("Policy name: "+ pname);
        System.out.println("Start Date: "+ sdate );
        System.out.println("End date: "+ edate);
        System.out.println("Organisation:Government of India");
         System.out.println("Do you want to apply for this policy,type 1");
        int poap=sc.nextInt();
        if(poap==1)
        {
        	String query4="insert into policies_availed values(?,?,?,?)";
        	PreparedStatement p4=con.prepareStatement(query4);
        	p4.setInt(1, regid);
        	p4.setString(2, Fname);
        	p4.setInt(3, dpid);
        	p4.setString(4, pname);
        	p4.execute();
            String pola="Applied";
            System.out.println(pola);
        }
        break;
    }
     case 3005:
        {int dpid=3005;
        String pname="Seed Quality Assurance";
            String sdate="01-05-2023";
        String edate="01-05-2024";
        System.out.println("Policy name: "+ pname);
        System.out.println("Start Date: "+ sdate );
        System.out.println("End date: "+ edate);
        System.out.println("Organisation:Government of India");
         System.out.println("Do you want to apply for this policy,type 1");
        int poap=sc.nextInt();
        if(poap==1)
        {
        	String query4="insert into policies_availed values(?,?,?,?)";
        	PreparedStatement p4=con.prepareStatement(query4);
        	p4.setInt(1, regid);
        	p4.setString(2, Fname);
        	p4.setInt(3, dpid);
        	p4.setString(4, pname);
        	p4.execute();
            String pola="Applied";
            System.out.println(pola);
        }
        break;
    }
     case 3006:
        {int dpid=3006;
        String pname="Equipment Rental Program ";
            String sdate="01-06-2023";
        String edate="01-06-2024";
      System.out.println("Policy name: "+ pname);
        System.out.println("Start Date: "+ sdate );
        System.out.println("End date: "+ edate);
        System.out.println("Organisation:Government of India");
         System.out.println("Do you want to apply for this policy,type 1");
        int poap=sc.nextInt();
        if(poap==1)
        {
        	String query4="insert into policies_availed values(?,?,?,?)";
        	PreparedStatement p4=con.prepareStatement(query4);
        	p4.setInt(1, regid);
        	p4.setString(2, Fname);
        	p4.setInt(3, dpid);
        	p4.setString(4, pname);
        	p4.execute();
            String pola="Applied";
            System.out.println(pola);
        }
        break;
    }
     case 3007:
        {int dpid=3007;
        String pname="Water Conservation Grant";
            String sdate="01-07-2023";
        String edate="01-07-2024";
       System.out.println("Policy name: "+ pname);
        System.out.println("Start Date: "+ sdate );
        System.out.println("End date: "+ edate);
        System.out.println("Organisation:Government of India");
         System.out.println("Do you want to apply for this policy,type 1");
        int poap=sc.nextInt();
        if(poap==1)
        {
        	String query4="insert into policies_availed values(?,?,?,?)";
        	PreparedStatement p4=con.prepareStatement(query4);
        	p4.setInt(1, regid);
        	p4.setString(2, Fname);
        	p4.setInt(3, dpid);
        	p4.setString(4, pname);
        	p4.execute();
            String pola="Applied";
            System.out.println(pola);
        }
        break;
    }
     case 3008:
        {int dpid=3008;
        String pname="Training and Workshops";
            String sdate="01-08-2023";
        String edate="01-08-2024";
       System.out.println("Policy name: "+ pname);
        System.out.println("Start Date: "+ sdate );
        System.out.println("End date: "+ edate);
        System.out.println("Organisation:Government of India");
         System.out.println("Do you want to apply for this policy,type 1");
        int poap=sc.nextInt();
        if(poap==1)
        {
        	String query4="insert into policies_availed values(?,?,?,?)";
        	PreparedStatement p4=con.prepareStatement(query4);
        	p4.setInt(1, regid);
        	p4.setString(2, Fname);
        	p4.setInt(3, dpid);
        	p4.setString(4, pname);
        	p4.execute();
            String pola="Applied";
            System.out.println(pola);
        }
        break;
    }
    case 0:
        {
            System.exit(0);
            break;
        }
        default:System.out.println("Invalid");

}



break;
}
case 3:
    {
        int loanid=4001;
System.out.println("The loans which you can avail are as follows");
System.out.println("Personal Loan -ID " +loanid);
loanid++;
System.out.println("Agricultural Loan -ID " +loanid);
loanid++;
System.out.println("Business Loan -ID " +loanid);
loanid++;
System.out.println("Home Loan  -ID " +loanid);
loanid++;
System.out.println("Vehicle Loan -ID " +loanid);
loanid++;
System.out.println("Education Loan -ID " +loanid);
loanid++;
System.out.println("Crop Loan -ID " +loanid);
loanid++;
System.out.println("Farm Mechanization Loan -ID "  +loanid);
loanid++;
System.out.println("Land Purchase Loan- ID " +loanid);
loanid++;
System.out.println("Live Stock Loan -ID " +loanid);
loanid++;
System.out.println("Warehouse Receipt Loan -ID " +loanid);
loanid++;
System.out.println("Solar Pump Set Loan -ID " +loanid);
loanid++;
int[] loap=new int[6];
int[] lom=new int[6];
int i=0;
System.out.println("Enter the loan ID of the loan ,if you wish to apply (If not enter 0) :");
loap[i]=sc.nextInt();


if(loap[i]==0)
{
    System.exit(0);
}
System.out.println("Enter the loan amount (not greater than 5 lakhs)");
lom[i]=sc.nextInt();
if(lom[i]<=10000 && lom[i]>500000)
{
    System.out.println("Invalid amount");
    System.exit(0);
}
while(loap[i]>=4001 && loap[i]<=4012)
{
    switch(loap[i])
    {
        case 4001:{String query5="insert into loan_availed values(?,?,?,?,?)";PreparedStatement p5=con.prepareStatement(query5);
                   p5.setInt(1, regid);
                   p5.setString(2,Fname );
                   p5.setInt(3, loap[i]);
                   p5.setString(4, "Personal");
                   p5.setInt(5, lom[i]);
        		System.out.println("Successfully applied for Personal Loan");break;}
         case 4002:{String query5="insert into loan_availed values(?,?,?,?,?)";PreparedStatement p5=con.prepareStatement(query5);
         p5.setInt(1, regid);
         p5.setString(2,Fname );
         p5.setInt(3, loap[i]);
         p5.setString(4, "Agricultural");
         p5.setInt(5, lom[i]);p5.execute();
        	 System.out.println("Successfully applied for Agricultural Loan");break;}
          case 4003:{String query5="insert into loan_availed values(?,?,?,?,?)";PreparedStatement p5=con.prepareStatement(query5);
          p5.setInt(1, regid);
          p5.setString(2,Fname );
          p5.setInt(3, loap[i]);
          p5.setString(4, "Business");
          p5.setInt(5, lom[i]);p5.execute();System.out.println("Successfully applied for Business Loan");break;}
           case 4004:{String query5="insert into loan_availed values(?,?,?,?,?)";PreparedStatement p5=con.prepareStatement(query5);
           p5.setInt(1, regid);
           p5.setString(2,Fname );
           p5.setInt(3, loap[i]);
           p5.setString(4, "Home");
           p5.setInt(5, lom[i]);p5.execute();System.out.println("Successfully applied for Home Loan");break;}
            case 4005:{String query5="insert into loan_availed values(?,?,?,?,?)";PreparedStatement p5=con.prepareStatement(query5);
            p5.setInt(1, regid);
            p5.setString(2,Fname );
            p5.setInt(3, loap[i]);
            p5.setString(4, "Vehicle");
            p5.setInt(5, lom[i]);p5.execute();System.out.println("Successfully applied for Vehicle Loan");break;}
             case 4006:{String query5="insert into loan_availed values(?,?,?,?,?)";PreparedStatement p5=con.prepareStatement(query5);
             p5.setInt(1, regid);
             p5.setString(2,Fname );
             p5.setInt(3, loap[i]);
             p5.setString(4, "Education");
             p5.setInt(5, lom[i]);p5.execute();System.out.println("Successfully applied for Education Loan");break;}
        case 4007:{String query5="insert into loan_availed values(?,?,?,?,?)";PreparedStatement p5=con.prepareStatement(query5);
        p5.setInt(1, regid);
        p5.setString(2,Fname );
        p5.setInt(3, loap[i]);
        p5.setString(4, "Crop");
        p5.setInt(5, lom[i]);p5.execute();System.out.println("Successfully applied for Crop Loan");break;}
        case 4008:{String query5="insert into loan_availed values(?,?,?,?,?)";PreparedStatement p5=con.prepareStatement(query5);
        p5.setInt(1, regid);
        p5.setString(2,Fname );
        p5.setInt(3, loap[i]);
        p5.setString(4, "Farm Mechanisation");
        p5.setInt(5, lom[i]);p5.execute();System.out.println("Successfully applied for Farm Mechanisation Loan");break;}
        case 4009:{String query5="insert into loan_availed values(?,?,?,?,?)";PreparedStatement p5=con.prepareStatement(query5);
        p5.setInt(1, regid);
        p5.setString(2,Fname );
        p5.setInt(3, loap[i]);
        p5.setString(4, "Land Purchase");
        p5.setInt(5, lom[i]);p5.execute();System.out.println("Successfully applied for Land Purchase Loan");
        break;}
        case 4010:{String query5="insert into loan_availed values(?,?,?,?,?)";PreparedStatement p5=con.prepareStatement(query5);
        p5.setInt(1, regid);
        p5.setString(2,Fname );
        p5.setInt(3, loap[i]);
        p5.setString(4, "Live");
        p5.setInt(5, lom[i]);p5.execute();System.out.println("Successfully applied for Live Loan");break;}
        case 4011:{String query5="insert into loan_availed values(?,?,?,?,?)";PreparedStatement p5=con.prepareStatement(query5);
        p5.setInt(1, regid);
        p5.setString(2,Fname );
        p5.setInt(3, loap[i]);
        p5.setString(4, "Warehouse Receipt");
        p5.setInt(5, lom[i]);System.out.println("Successfully applied for Warehouse Receipt Loan");break;}
        case 4012:{String query5="insert into loan_availed values(?,?,?,?,?)";PreparedStatement p5=con.prepareStatement(query5);
        p5.setInt(1, regid);
        p5.setString(2,Fname );
        p5.setInt(3, loap[i]);
        p5.setString(4, "Solar Pump Set");
        p5.setInt(5, lom[i]);p5.execute();System.out.println("Successfully applied for Solar Pump Set Loan");break;}
        default:System.out.println("Invalid");
    }
    i++;
    System.out.println("Do you wish to apply for more loans,If yes, enter the loan ID(Enter 0 to exit)");
    loap[i]=sc.nextInt();
    if(loap[i]==0)
{
    System.exit(0);
}
    System.out.println("Enter the loan amount (not greater than 10 lakhs)");
lom[i]=sc.nextInt();
if(lom[i]<=10000 && lom[i]>500000)
{
    System.out.println("Invalid amount");
    System.exit(0);
}
String query5="insert into loan_availed values(?,?,?,?,?)";PreparedStatement p5=con.prepareStatement(query5);
p5.setInt(1, regid);
p5.setString(2,Fname );
p5.setInt(3, loap[i]);
p5.setString(4, "Personal");
p5.setInt(5, lom[i]);
}
break;

    }
case 4:
        {
            System.out.println("Enter the field ID wherein the crops are harvested: ");
            int fieldc=sc.nextInt();
            
            String query8="insert into crop values(?,?,?)";
            System.out.println("Enter the crop name: ");
            String cropname=sc.next();
            System.out.println("Enter the yield obtained");
            int yield=sc.nextInt();


            PreparedStatement p8=con.prepareStatement(query8);
            p8.setString(1, cropname);
            p8.setInt(2, fieldc);
            p8.setInt(3, yield);
            p8.execute();
            System.out.println("Crop Name:" +cropname +"added successfully");
            System.out.println("Do you want to add more crops? If yes,type 1");
            int cinca=sc.nextInt();
            while(cinca==1)
        {
                System.out.println("Enter the crop name: ");
                cropname=sc.next();
            
        
            System.out.println("Crop Name:" +cropname);
            
            System.out.println("Do you want to add more crops? If yes,type 1");
             cinca=sc.nextInt();
             PreparedStatement p9=con.prepareStatement(query8);
             p9.setString(1, cropname);
             p9.setInt(2, fieldc);
             p9.setInt(3, yield);
             p9.execute();
             System.out.println("Crop Name:" +cropname +"added successfully");
             System.out.println("Do you want to add more crops? If yes,type 1");
             cinca=sc.nextInt();
            }
        break;

        }
        case 5:
            {
                {
            System.out.println("Enter the field ID wherein the fertilizers are used: ");
            int fieldfer=sc.nextInt();
            
            int j=0;
            System.out.println("Enter the fertilizer name: ");
            String fername=sc.next();
            System.out.println("Enter the cost of fertilizer:");
            int feram=sc.nextInt();
            System.out.println("Enter the type of fertilizer:");
            String ferty=sc.next();
            int[] fertidf=new int[40];
            fertidf[j]=5009;
            System.out.println("Fertilizer Name:" +fername);
            String query6="insert into fertilizers values(?,?,?,?,?)";
            PreparedStatement p6=con.prepareStatement(query6);
            p6.setInt(1,fertidf[j]);
            p6.setString(2,fername);
            p6.setInt(3,feram);
            p6.setString(4,ferty);
            p6.setInt(5,fieldfer);
            p6.execute();
            System.out.println("Do you want to add more fertilizers? If yes,type 1");
            int finca=sc.nextInt();
            while(finca==1 && j<=10)
            {
                j++;
                System.out.println("Enter the fertilizer name: ");
                fername=sc.next();
                System.out.println("Enter the cost of fertilizer:");
                feram=sc.nextInt();
                System.out.println("Enter the type of fertilizer:");
                ferty=sc.next();
            fertidf[j]=5009+j;
            System.out.println("Fertilizer Name:" +fername);
        
            PreparedStatement p7=con.prepareStatement(query6);
            p7.setInt(1,fertidf[j]);
            p7.setString(2,fername);
            p7.setInt(3,feram);
            p7.setString(4,ferty);
            p7.setInt(5,fieldfer);
            p7.execute();
            System.out.println("Do you want to add more fertilizers? If yes,type 1");
             finca=sc.nextInt();
            }
        break;

        }
            }
        case 6:
        {
        
        	
        	String query10="select count(reg_id) from farmer where gender='M' ";
        	Statement s1=con.createStatement();
        	ResultSet rs=s1.executeQuery(query10);
        	while(rs.next())
        	{
        		System.out.println("Count of male farmers: " +rs.getInt(1));
        	}
        	String query11="select count(reg_id) from farmer where gender='F' ";
        	Statement s2=con.createStatement();
        	ResultSet rs1=s2.executeQuery(query11);
        	while(rs1.next())
        	{
        		System.out.println("Count of female farmers: " +rs1.getInt(1));
        	}
        	break;
        	
        }
        case 7:
        {
        	String query12="select * from loan_availed";
        	Statement s3=con.createStatement();
        	ResultSet rs2=s3.executeQuery(query12);
        	while(rs2.next())
        	{
        		System.out.println("===========================");
        		System.out.println("Registartion id: " +rs2.getInt(1));
        		System.out.println("Name: " +rs2.getString(2));
        		System.out.println("Loan ID: " +rs2.getInt(3));
        		System.out.println("Loan Type: "+rs2.getString(4));
        		System.out.println("Loan Amount: "+rs2.getInt(5));
        		System.out.println("===========================");
        	}
        	break;
        }
        case 8:{
        	String query13="select Fname,Mname,Lname,farmer_loc as Location from farmer where reg_id in (select reg_id from loan where Amount>20000)";
            Statement s4=con.createStatement();
            ResultSet rs3=s4.executeQuery(query13);
            while(rs3.next())
            {
            	System.out.println("=================");
            	System.out.println("Fname: "+rs3.getString(1));
            	System.out.println("Mname: " +rs3.getString(2));
            	System.out.println("Lname: " +rs3.getString(3));
            	System.out.println("Location: " +rs3.getString(4));
            }
            break;
        }
        case 9:
        {
        	String query14="select Fname,Mname,Lname,farmer_loc as Location from farmer where reg_id in (select reg_id from loan_availed where Loan_id=4002)";
            Statement s5=con.createStatement();
            ResultSet rs4=s5.executeQuery(query14);
            while(rs4.next())
            {
            	System.out.println("=================");
            	System.out.println("Fname: "+rs4.getString(1));
            	System.out.println("Mname: " +rs4.getString(2));
            	System.out.println("Lname: " +rs4.getString(3));
            	System.out.println("Location: " +rs4.getString(4));
            }
            break;
        }
        
        	
default:System.out.println("Invalid");

}
}
while(option>=1 && option<=9);

}

	}
