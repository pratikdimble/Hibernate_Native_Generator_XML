package com.pratik.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pratik.domain.lucky_draw;
import com.pratik.utility.HibernateUtil;

public class ClientApp {

	public static void main(String[] args) 
	{
		Session ses = null;
		lucky_draw coupen = null;
		Transaction tx = null;

		ses = HibernateUtil.getSession();
				
		coupen=new lucky_draw();
	//	coupen.setCoupenNumber("Bajaj002");
		coupen.setCustomerName("Rohit");
		coupen.setBillAmount(80000);


		try {
			tx = ses.beginTransaction();
			ses.save(coupen);
			tx.commit();
			System.out.println("object is saved");
			//System.out.println("\n\t***Generated ID Value::: "+id);
		} catch (Exception e) {
			tx.rollback();

		}
		ses.close();
				//================Displaying the Table============
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		try
		{
			
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");
			String sql="select * from coupendraw1";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			System.out.println("\n\n\t CoupenID \t CustomerName \t BillAmount");
			System.out.println("\t================================================================== ");
			int count=0;
			while(rs.next())
			{
				count++;
				System.out.print("\n\t"+rs.getString(1)+"\t\t\t"+rs.getString(2)+"\t    "+rs.getFloat(3));
			}
			System.out.println("\n\t================================================================ ");
			System.out.println("\n\t***Records Displayed: "+count);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				//	CLOSE THE RESOURCES
				con.close();
				st.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		System.out.print("\n\t\t ==PROGRAMME BY PRATIK DIMBLE==\n\n\n");

		

	}

}
