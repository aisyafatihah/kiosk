package businessClass;

import java.sql.*;
import java.util.ArrayList;

import kioskapp.itemproduct.ItemProduct;

/**
 * This class represent the front-end class in the 3-tier architecture
 * @author HamizahYusni
 */
public class ItemProductManager {

	private DbController dbCtrl;
	
	public ItemProductManager (){
		dbCtrl = new DbController();
	}

	/**
	 * This method select item product ID
	 */
	public int getItemProductID (String itemProductName) {
		
		ItemProduct itemProd = new ItemProduct();
		
		//execute a query
		String query = "SELECT ItemProduct FROM itemproduct WHERE Name = ?";
		
		try {
			//Establish connection
			Connection conn = dbCtrl.getConnection();
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, itemProductName);
			
			// execute the prepared statement
			ResultSet rs = preparedStmt.executeQuery();
			if (rs.next())
				itemProd.setItemProduct(rs.getInt(1));
			
			preparedStmt.close();
			rs.close();
			conn.close();
			
		} catch (SQLException | ClassNotFoundException e1) {
			
			e1.printStackTrace();
		}
		
		return itemProd.getItemProduct();
	}

	/**
	 * This method select item product
	 */
	public ItemProduct getProduct (int itemProductId)
	{
		ItemProduct itemProd = new ItemProduct();
		//execute a query
		String query = "SELECT Name, Price FROM itemproduct WHERE ItemProduct = ? ";
		
		try {
			//Establish connection
			Connection conn = dbCtrl.getConnection();
			PreparedStatement preparedStmt= conn.prepareStatement(query);
			preparedStmt.setInt(1, itemProductId);
			ResultSet rs = preparedStmt.executeQuery();
			
			if(rs.next()){
				itemProd.setName(rs.getString(1));
				itemProd.setPrice(rs.getFloat(2));
			}
					
			preparedStmt.close();
			conn.close();
			rs.close();
			

		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}

		return itemProd;

	}

	/**
	 * This method select a list of item product
	 */
	public ArrayList<ItemProduct> getProductss ()
	{
		
		//an object to store a list of item product
		ArrayList<ItemProduct> prods = new ArrayList<ItemProduct>();
		//form SQL statement
		String query = "SELECT ItemProduct , Name, Price FROM itemproduct";
		
		try {
			//Establish connection
			Connection conn = dbCtrl.getConnection();
			PreparedStatement pStmt= conn.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()){
				ItemProduct prdct = new ItemProduct();
				prdct.setItemProduct(rs.getInt(1));
				prdct.setName(rs.getString(2));
				prdct.setPrice(rs.getFloat(3));
				prods.add(prdct);
			}			
			pStmt.close();
			rs.close();
			conn.close();

		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}

		return prods;

	}
}
