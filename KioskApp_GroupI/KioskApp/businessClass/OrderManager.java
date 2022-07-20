package businessClass;

import kioskapp.order.Order;
import kioskapp.ordereditem.OrderedItem;

import java.sql.*;

/**
 * This class represent the front-end class in the 3-tier architecture
 * @author HamizahYusni
 */
public class OrderManager {

	private DbController dbCtrl;

	public OrderManager(){
		dbCtrl = new DbController();
	}

	/**
	 * This method insert order into database
	 */
	public void insertOrder(OrderedItem orderedItem){
		
		int qstate = 0;
    
		String query = "INSERT into order (TotalAmount, OrderReferenceNumber) values (?,?)";

        try {
        		//Establish connection
			    Connection conn = dbCtrl.getConnection();
                PreparedStatement pStmt = conn.prepareStatement(query);
                pStmt.setFloat(1, orderedItem.getTotalAmount());
                pStmt.setInt(2, orderedItem.getOrderReferenceNumber());
                
                // execute the prepared statement
                qstate = pStmt.executeUpdate();
                pStmt.close();
                if(qstate!=0)
                {
                	//execute a query
                    query ="SELECT OrderId FROM order";
                    pStmt = conn.prepareStatement(query);
                    ResultSet rs = pStmt.executeQuery();
                    rs.last();
                    
                    orderedItem.setOrderId(rs.getInt(1));
                }
                
                pStmt.close();
    	        conn.close();
            } 
            catch (ClassNotFoundException | SQLException e) {
            	e.printStackTrace();
		    }

	}
}
