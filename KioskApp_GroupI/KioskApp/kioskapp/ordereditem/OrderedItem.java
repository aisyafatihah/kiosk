package kioskapp.ordereditem;

import java.io.Serializable;

import kioskapp.itemproduct.ItemProduct;
import kioskapp.order.*;
import kioskapp.ordertransaction.*;

/**
 * 
 * This class represent an item product ordered by a customer.
 * 
 * @author emalianakasmuri
 *
 */
public class OrderedItem implements Serializable{
	
	// Declaration of attributes
	private int orderedItem;	
	
	// Implementation of 1:1
	private ItemProduct itemProduct;
	private Order order;
	private OrderTransaction ordert;
	
	private int quantity;
	private double subTotalAmount;
	
	/**
	 * @return the orderedItem
	 */
	public int getOrderedItem() {
		return orderedItem;
	}
	
	/**
	 * @param orderedItem the orderedItem to set
	 */
	public void setOrderedItem(int orderedItem) {
		this.orderedItem = orderedItem;
	}
	
	/**
	 * @return the itemProduct
	 */
	public ItemProduct getItemProduct() {
		return itemProduct;
	}
	
	/**
	 * @param itemProduct the itemProduct to set
	 */
	public void setItemProduct(ItemProduct itemProduct) {
		this.itemProduct = itemProduct;
	}
	
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * @return the subTotalAmount
	 */
	public double getSubTotalAmount() {
		return subTotalAmount;
	}
	
	/**
	 * @param subTotalAmount the subTotalAmount to set
	 */
	public void setSubTotalAmount(double subTotalAmount) {
		this.subTotalAmount = subTotalAmount;
	}

	public float getTotalAmount() {
		// TODO Auto-generated method stub
		return order.getTotalAmount();
	}
	
	public int orderId() {
		return order.getOrderId();
	}

	public int getOrderReferenceNumber() {
		// TODO Auto-generated method stub
		return order.getOrderReferenceNumber();
	}

	public void setOrderId(int int1) {
		// TODO Auto-generated method stub
		
	}
	
	public String getOrderMode() {
		return ordert.getOrderMode();
	}
	
	
	

}
