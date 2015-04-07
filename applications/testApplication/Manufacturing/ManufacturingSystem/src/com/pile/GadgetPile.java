package com.pile;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import processedComponent.RawWidget;

import com.configration.dbConnection;
import com.object.Gadget;
import com.object.Widget;

public class GadgetPile implements IPile{

	private int count;
	//public static List<Gadget> 	gadgetPile = new ArrayList<Gadget>();
    Statement stmt;
	public static Connection sqlConn = 
			dbConnection.setupGooPileConnection("GadgetPile", "tedi", "tedi");
	public GadgetPile(){
	}

	@Override
	public void add(Object obj) {
		// TODO Auto-generated method stub
		Gadget gadget = (Gadget)obj;
        String SQL = "INSERT INTO GadgetPile(name, code, numberOfWidget, tag)" +
        		"VALUES("+gadget.getName()+","+ gadget.getCode()+
        		","+gadget.getNumberOfComponent()+","+ gadget.getTag()+");";  
        sqlStatement(SQL);
		//gadgetPile.add(gadget);
	}

	@Override
	public void remove(Object obj) {
		// TODO Auto-generated method stub
		Gadget gadget = (Gadget)obj;
		String SQL = "DELETE FROM GadgetPile WHERE (name="+gadget.getName()+
				"and code="+gadget.getCode()+" and numberOfWidget="+gadget.getNumberOfComponent()+
				")or ID="+gadget.getID()+";";
		sqlStatement(SQL);
		//int index= gadgetPile.indexOf(gadget);
		//gadgetPile.remove(index);
	}

	private Gadget retrieveGadget() {
		Gadget gadgetItem = new Gadget();
		String SQL = "SELECT ID,name,code, numberOfWidget, tag FROM GadgetPile";
		
		try {
			stmt = sqlConn.createStatement(); 
			ResultSet rs = stmt.executeQuery(SQL);
	        // Iterate through the data in the result set and display it.  
			 while (rs.next())  
             { 
				 gadgetItem.setID(rs.getInt("ID"));
				 gadgetItem.setName(rs.getString("name"));
				 gadgetItem.setCode(rs.getString("code"));
				 gadgetItem.setNumberOfComponent(rs.getInt("numberOfWidget"));
				 gadgetItem.setTag(rs.getString("tag"));
				return gadgetItem;
             }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			gadgetItem=null;
		} 
		return gadgetItem;
	}
	
	private List<Gadget> retrieveAllGadget() {
		List<Gadget> gadgetItems = new ArrayList<Gadget>();
		Gadget gadgetItem = new Gadget();
		String SQL = "SELECT ID,name,code, numberOfWidget, tag FROM GadgetPile";
		try {
			stmt = sqlConn.createStatement(); 
			ResultSet rs = stmt.executeQuery(SQL);
	        // Iterate through the data in the result set and display it.  
			 while (rs.next())  
             { 
				 gadgetItem.setID(rs.getInt("ID"));
				 gadgetItem.setName(rs.getString("name"));
				 gadgetItem.setCode(rs.getString("code"));
				 gadgetItem.setNumberOfComponent(rs.getInt("numberOfWidget"));
				 gadgetItem.setTag(rs.getString("tag"));
				 gadgetItems.add(gadgetItem);
             }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			gadgetItems=null;
		} 
		return gadgetItems;
	}
	
	private List<Gadget> retrieveSpecificGadgets(int numberOfWids, String label) {
		List<Gadget> gadgetItems = new ArrayList<Gadget>();
		Gadget gadgetItem = new Gadget();
		String SQL = "SELECT ID,name,code, numberOfWidget, tag " +
				"FROM GadgetPile where numberOfWidget="+numberOfWids+
				" or "+" tag="+label+";";
		try {
			stmt = sqlConn.createStatement(); 
			ResultSet rs = stmt.executeQuery(SQL);
	        // Iterate through the data in the result set and display it.  
			 while (rs.next())  
             { 
				 gadgetItem.setID(rs.getInt("ID"));
				 gadgetItem.setName(rs.getString("name"));
				 gadgetItem.setCode(rs.getString("code"));
				 gadgetItem.setNumberOfComponent(rs.getInt("NumberOfWidget"));
				 gadgetItem.setTag(rs.getString("tag"));
				 gadgetItems.add(gadgetItem);
             }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			gadgetItems=null;
		} 
		return gadgetItems;
	}
	
	@Override
	public int count() {
		// TODO Auto-generated method stub
		String SQL = "SELECT count(name) FROM  GadgetPile";
		try {
			stmt = sqlConn.createStatement(); 
			ResultSet rs = stmt.executeQuery(SQL);
	        // Iterate through the data in the result set and display it.  
			count= rs.getInt("count");
			System.out.println(" Number of Gadget in the GadgetPile="+rs.getString(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//count = gooPile.size();
		return count;
	}

	public int count(int numOfWidgets ,String label) {
		List<Gadget> list= new ArrayList<Gadget>();
		list= retrieveSpecificGadgets(numOfWidgets, label);
		return list.size();
	}

	private void sqlStatement(String SQL) {
		try {
			stmt = sqlConn.createStatement();
			// execute insert SQL statement
			stmt.executeUpdate(SQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
