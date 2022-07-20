package kioskapp.ordertransaction;

import java.io.Serializable;
import java.sql.Date;

import kioskapp.order.Order;

/**
 * 
 * This class represent the payment made on the placed order by the customer
 * 
 * 
 * @author emalianakasmuri
 *
 */
public class OrderTransaction implements Serializable {
	
	// Declaration of attributes
	
	private int orderTransactionId;
	private Date transactionDate;
	private double amountCharged;
	private boolean transactionStatus;
	private int last4Digits;
	private String orderMode;
	
	/* Implementation of 1:1 */
	private Order order;

	/**
	 * @return the orderTransactionId
	 */
	public int getOrderTransactionId() {
		return orderTransactionId;
	}

	/**
	 * @param orderTransactionId the orderTransactionId to set
	 */
	public void setOrderTransactionId(int orderTransactionId) {
		this.orderTransactionId = orderTransactionId;
	}

	/**
	 * @return the transactioDate
	 */
	public Date getTransactionDate() {
		return transactionDate;
	}

	/**
	 * @param transactioDate the transactioDate to set
	 */
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	/**
	 * @return the amountCharged
	 */
	public double getAmountCharged() {
		return amountCharged;
	}

	/**
	 * @param amountCharged the amountCharged to set
	 */
	public void setAmountCharged(double amountCharged) {
		this.amountCharged = amountCharged;
	}

	/**
	 * @return the transactionStatus
	 */
	public boolean isTransactionStatus() {
		return transactionStatus;
	}

	/**
	 * @param transactionStatus the transactionStatus to set
	 */
	public void setTransactionStatus(boolean transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	/**
	 * @return the last4Digits
	 */
	public int getLast4Digits() {
		return last4Digits;
	}

	/**
	 * @param last4Digits the last4Digits to set
	 */
	public void setLast4Digits(int last4Digits) {
		this.last4Digits = last4Digits;
	}

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * @return the orderMode
	 */
	public String getOrderMode() {
		return orderMode;
	}

	/**
	 * @param orderMode the orderMode to set
	 */
	public void setOrderMode(String orderMode) {
		this.orderMode = orderMode;
	}
	
	

}
