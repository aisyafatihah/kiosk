package businessClass;

import java.sql.*;

import javax.swing.JOptionPane;

import kioskapp.order.Order;
import kioskapp.ordereditem.OrderedItem;

/**
 * This class represent the front-end class in the 3-tier architecture
 * @author HamizahYusni
 */
public class OrderedItemManager {

    private DbController dbCtrl;

    public OrderedItemManager (){
         dbCtrl = new DbController();
    }


    public void insertOrderedItem (OrderedItem order){
    	
        int qstate =0;
       
        //execute a query
        String query = "INSERT into ordereditem (ItemProduct,Quantity,SubTotalAmount,`Order`) values (?,?,?,?);";

        try {
        	//Establish connection
		    Connection conn = dbCtrl.getConnection();
            PreparedStatement pStmt = conn.prepareStatement(query);

            	pStmt.setInt(1, order.getItemProduct().getItemProduct());
            	pStmt.setInt(2, order.getQuantity());
            	pStmt.setDouble(3, order.getSubTotalAmount());
            	pStmt.setInt(4, order.orderId());
            	qstate += pStmt.executeUpdate();

            if (qstate != order.getOrderedItem())
            	//pop message
		        JOptionPane.showMessageDialog(null, "Error might occur");
            pStmt.close();
	        conn.close();
	    } catch (ClassNotFoundException | SQLException e) {
		
		    e.printStackTrace();
	    }
}
}
