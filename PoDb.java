package com.dsgroup.first;



import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class PoDb {
	private static List<Po> PoData = null;
	 
	 public static List<Po> GetPoData() throws IOException{
	  
	  if(PoData==null){   
	   PoData=new LinkedList<Po>();
	   Connection conn=DBUtil.getInstance().getDBConnection();
	   Statement statement;
	   String[] row=new String[6];
	try {
		statement = conn.createStatement();
		ResultSet rs=statement.executeQuery("SELECT COMPANY, PO_TYPE, PO_SERIES, PO_NO,(SELECT SUPPLIER_NAME_ENGLISH FROM SUPPLIERS WHERE COMPANY=I.COMPANY AND SUPPLIER_CODE=I.SUPPLIER_CODE) SUPPLIER_NAME, PO_AMOUNT FROM PO  I WHERE COMPANY='02' AND STATUS NOT IN ('Z')");
		while (rs.next()){
			row[0]=rs.getString("COMPANY");
			row[1]=rs.getString("PO_TYPE");
			row[2]=rs.getString("PO_SERIES");
			row[3]=rs.getString("PO_NO");
			row[4]=rs.getString("SUPPLIER_NAME");
			row[5]=rs.getString("PO_AMOUNT");
			//System.out.println(row[0]+row[1]+row[2]+row[3]+row[4]+row[5]);
			PoData.add(new Po(row[0],row[1],row[2],row[3],row[4],row[5]));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		for (Throwable t:e)
		t.printStackTrace();
	}
	  }    
	  return PoData;  
	 }  
	/*public static void main(String[] args){

			  try {
				  for (Po p:PoDb.GetPoData())
				System.out.println(p.getSupplierName());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			    }*/
	}
