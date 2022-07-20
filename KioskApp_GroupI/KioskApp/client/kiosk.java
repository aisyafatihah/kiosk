//Nur Aisya Fatihah
package client;

//import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.List;

import javax.swing.border.TitledBorder;

import businessClass.*;
import kioskapp.itemproduct.ItemProduct;
import kioskapp.order.Order;
import kioskapp.ordereditem.OrderedItem;
import kioskapp.ordertransaction.OrderTransaction;

import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
//import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
* @author NurAisyaFatihah
*/
public class kiosk extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	public ItemProduct itemProduct=new ItemProduct();
	public ItemProductManager productManager = new ItemProductManager();
	OrderTransaction orderTransaction= new OrderTransaction();
	ArrayList<OrderedItem> cart = new ArrayList<OrderedItem>();
	ArrayList<Integer> quant = new ArrayList<Integer>();
	ArrayList<Double> amount = new ArrayList<Double>();
	private boolean itemName[]= {false,false,false,false,false,false,false,false,false,false,false,false,false};
	private double totalprice=0;
	private int quantity[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
	private double subtotal[] = {8.10, 11.90, 30.20, 11.90, 9.40, 9.45, 10.40, 8.45, 13.20, 13.20, 13.00 , 4.15, 4.15};
	private double total[] = {8.10, 11.90, 30.20, 11.90, 9.40, 9.45, 10.40, 8.45, 13.20, 13.20, 13.00 , 4.15, 4.15};
	private JTextField textField;
	//double sum=0,price, bigtotal=0;
	double totalAmount=0;
	int qty;
	String name,card,mode;
	double subTotalAmount;
	boolean decide;
	private String orderMode,printMessage, receipt;
	JTextArea textArea = new JTextArea();
	//OrderTransaction orderTransaction=new OrderTransaction();
	Order order=new Order();
	public OrderedItem orderedItem=new OrderedItem();
	 private static DecimalFormat df = new DecimalFormat("#.##");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
					
					kiosk frame = new kiosk();
					frame.setVisible(true);
					//frame.setTitle("Kiosk");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public kiosk() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Kiosk");
		setBounds(100, 100, 1016, 774);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 1002, 110);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome To Our Kiosk");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(353, 31, 266, 47);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBounds(531, 111, 471, 399);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Cart");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(216, 10, 68, 21);
		panel_1.add(lblNewLabel_2);
		
		textArea.setBackground(new Color(255, 255, 204));
		textArea.setBounds(10, 41, 451, 280);
		panel_1.add(textArea);
		
		JLabel lblNewLabel_4 = new JLabel("Total Price :");
		lblNewLabel_4.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 15));
		lblNewLabel_4.setBounds(171, 344, 103, 31);
		panel_1.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(354, 345, 96, 31);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(0, 111, 527, 616);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		//ArrayList<String> cart = new ArrayList<String>();
		String [] meal = {"McChicken Meal (Medium) - RM 13.20", "Chicken McNuggets 6pcs Meal (Medium) - RM13.20"
				,"Filet-O-Fish Meal (Medium) - RM 13.00", "Ayam Goreng McD Spicy (2pcs) - RM 11.90", "Ayam Goreng McD Spicy (5pcs) - RM 30.20"
				,"Chicken McNuggets (6pcs) - RM 9.40", "Strawberry Sundae - RM 4.15"
				,"Chocolate Sundae - RM 4.15", "McChicken - RM 8.10", "Spicy Chicken McDeluxe - RM 11.90"
				,"Double Cheeseburger - RM 9.45", "Big Mac - RM 10.40","Filet-O-Fish - RM 8.45"};
		JComboBox comboBox = new JComboBox(meal);
		comboBox.setBounds(118, 204, 305, 33);
		panel_2.add(comboBox);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.ORANGE);
		panel_4.setBounds(0, 0, 527, 54);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnEatin = new JButton("Eat-In");
		btnEatin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode = "Eat-In";
				orderTransaction.setOrderMode(mode);
				orderTransaction.getOrderMode();
				
			}
		});
		btnEatin.setBounds(132, 10, 85, 21);
		panel_4.add(btnEatin);
		
		JButton btnNewButton_3 = new JButton("Take-Away");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode = "Take-Away";
				orderTransaction.setOrderMode(mode);
				orderTransaction.getOrderMode();
			}
		});
		btnNewButton_3.setBounds(267, 10, 123, 21);
		panel_4.add(btnNewButton_3);
		
		JLabel lblNewLabel_3 = new JLabel("Menu List");
		lblNewLabel_3.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 15));
		lblNewLabel_3.setBounds(219, 115, 189, 30);
		panel_2.add(lblNewLabel_3);
		
		JSpinner txtQty = new JSpinner();
		txtQty.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
		txtQty.setBounds(148, 524, 63, 48);
		panel_2.add(txtQty);
		
		JLabel lblNewLabel_7 = new JLabel("Quantity  :");
		lblNewLabel_7.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 15));
		lblNewLabel_7.setBounds(54, 531, 84, 31);
		panel_2.add(lblNewLabel_7);
		
		JButton btnNewButton_1 = new JButton("Add To Cart");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String usertype = comboBox.getSelectedItem().toString();
				
				
				if (usertype.equals("McChicken Meal (Medium) - RM 13.20")) {
					ItemProduct itemProduct= productManager.getProduct(9);
					orderedItem.setItemProduct(itemProduct);
					String nma= itemProduct.getName();
					orderedItem.getItemProduct();
					orderedItem.getSubTotalAmount();
					orderedItem.setQuantity((Integer)txtQty.getValue());
				//UpdateTotal();
					//quantity[8]=(Integer)txtQty.getValue();
					orderedItem.setSubTotalAmount(itemProduct.getPrice()*orderedItem.getQuantity());
					cart.add(orderedItem);
					//System.out.print(orderedItem.getItemProduct().getName());
				}
				else if(usertype.equals("Chicken McNuggets 6pcs Meal (Medium) - RM13.20")) {
					ItemProduct itemProduct= productManager.getProduct(10);
					orderedItem.setItemProduct(itemProduct);
					itemProduct.getName();
					orderedItem.getItemProduct();
					orderedItem.getSubTotalAmount();
					orderedItem.setQuantity((Integer)txtQty.getValue());
					orderedItem.setQuantity(quantity[9]);
					//UpdateTotal();
					quantity[9]=(Integer)txtQty.getValue();
					//UpdateTotal();
					orderedItem.setSubTotalAmount(itemProduct.getPrice()*orderedItem.getQuantity());
					cart.add(orderedItem);
				}
				else if(usertype.equals("Filet-O-Fish Meal (Medium) - RM 13.00")) {
					ItemProduct itemProduct= productManager.getProduct(11);
					orderedItem.setItemProduct(itemProduct);
					String name= itemProduct.getName();
					orderedItem.getItemProduct();
					orderedItem.getSubTotalAmount();
					orderedItem.setQuantity((Integer)txtQty.getValue());
					//UpdateTotal();
					//quantity[10]=(Integer)txtQty.getValue();
					orderedItem.setSubTotalAmount(itemProduct.getPrice()*orderedItem.getQuantity());
					cart.add(orderedItem);
			
				}
				else if(usertype.equals("Ayam Goreng McD Spicy (2pcs) - RM 11.90")) {
					ItemProduct itemProduct= productManager.getProduct(2);
					orderedItem.setItemProduct(itemProduct);
					itemProduct.getName();
					orderedItem.getItemProduct();
					orderedItem.getSubTotalAmount();
					subtotal[1]=total[1]*(Integer)txtQty.getValue();
					orderedItem.setQuantity((Integer)txtQty.getValue());
					orderedItem.setSubTotalAmount(itemProduct.getPrice()*orderedItem.getQuantity());
					cart.add(orderedItem);
					
				}
				else if(usertype.equals("Ayam Goreng McD Spicy (5pcs) - RM 30.20")) {
					ItemProduct itemProduct= productManager.getProduct(3);
					orderedItem.setItemProduct(itemProduct);
					itemProduct.getName();
					orderedItem.getItemProduct();
					orderedItem.getSubTotalAmount();
					orderedItem.setQuantity((Integer)txtQty.getValue());
					orderedItem.setSubTotalAmount(itemProduct.getPrice()*orderedItem.getQuantity());
					cart.add(orderedItem);
				}
				else if(usertype.equals("Chicken McNuggets (6pcs) - RM 9.40")) {
					ItemProduct itemProduct= productManager.getProduct(5);
					orderedItem.setItemProduct(itemProduct);
					itemProduct.getName();
					orderedItem.getItemProduct();
					orderedItem.getSubTotalAmount();
					orderedItem.setQuantity((Integer)txtQty.getValue());
					orderedItem.setSubTotalAmount(itemProduct.getPrice()*orderedItem.getQuantity());
					cart.add(orderedItem);
				}
				else if(usertype.equals("Strawberry Sundae - RM 4.15")) {
					ItemProduct itemProduct= productManager.getProduct(12);
					orderedItem.setItemProduct(itemProduct);
					//orderedItem.setSubTotalAmount(itemProduct.getPrice());
					itemProduct.getName();
					orderedItem.getItemProduct();
					orderedItem.getSubTotalAmount();
					orderedItem.setQuantity((Integer)txtQty.getValue());
					orderedItem.setSubTotalAmount(itemProduct.getPrice()*orderedItem.getQuantity());
					cart.add(orderedItem);
				//System.out.print(orderedItem.getItemProduct().getName());
				}
				else if(usertype.equals("Chocolate Sundae - RM 4.15")) {
					ItemProduct itemProduct= productManager.getProduct(13);
					orderedItem.setItemProduct(itemProduct);
					itemProduct.getName();
					orderedItem.getItemProduct();
					orderedItem.getSubTotalAmount();
					orderedItem.setQuantity((Integer)txtQty.getValue());
					orderedItem.setSubTotalAmount(itemProduct.getPrice()*orderedItem.getQuantity());
				//printOrderedItem();
					cart.add(orderedItem);
				}
				else if(usertype.equals("McChicken - RM 8.10")) {
					ItemProduct itemProduct= productManager.getProduct(1);
					orderedItem.setItemProduct(itemProduct);
					itemProduct.getName();
					orderedItem.getItemProduct();
					orderedItem.getSubTotalAmount();
					orderedItem.setQuantity((Integer)txtQty.getValue());
					orderedItem.setSubTotalAmount(itemProduct.getPrice()*orderedItem.getQuantity());
					
					cart.add(orderedItem);
					System.out.print(itemProduct.getName());
					System.out.print(orderedItem.getSubTotalAmount() + "\t");
					System.out.print(quantity[0]);
				}
				else if(usertype.equals("Spicy Chicken McDeluxe - RM 11.90")) {
					ItemProduct itemProduct= productManager.getProduct(4);
					orderedItem.setItemProduct(itemProduct);
					String te= itemProduct.getName();
					orderedItem.getItemProduct();
					orderedItem.getSubTotalAmount();
					orderedItem.setQuantity((Integer)txtQty.getValue());
					orderedItem.setSubTotalAmount(itemProduct.getPrice()*orderedItem.getQuantity());
					cart.add(orderedItem);
				
				}
				else if(usertype.equals("Double Cheeseburger - RM 9.45")) {
					ItemProduct itemProduct= productManager.getProduct(6);
					orderedItem.setItemProduct(itemProduct);
					itemProduct.getName();
					orderedItem.getItemProduct();
					orderedItem.getSubTotalAmount();
					orderedItem.setQuantity((Integer)txtQty.getValue());
					orderedItem.setSubTotalAmount(itemProduct.getPrice()*orderedItem.getQuantity());
	
					cart.add(orderedItem);
				}
				else if(usertype.equals("Big Mac - RM 10.40")) {
					ItemProduct itemProduct= productManager.getProduct(7);
					orderedItem.setItemProduct(itemProduct);
					itemProduct.getName();
					orderedItem.getItemProduct();
					orderedItem.getSubTotalAmount();
					orderedItem.setQuantity((Integer)txtQty.getValue());
					orderedItem.setSubTotalAmount(itemProduct.getPrice()*quantity[6]);
					cart.add(orderedItem);
	
				}
				else {
					ItemProduct itemProduct= productManager.getProduct(8);
					orderedItem.setItemProduct(itemProduct);
					itemProduct.getName();
					orderedItem.getItemProduct();
					orderedItem.getSubTotalAmount();
					orderedItem.setQuantity((Integer)txtQty.getValue());
					orderedItem.setSubTotalAmount(itemProduct.getPrice()*orderedItem.getQuantity());
					cart.add(orderedItem);
				}
				amount.add(orderedItem.getSubTotalAmount());
				printOrderedItem(orderedItem);
				UpdateTotal(orderedItem.getSubTotalAmount());
				
				printOrderedItem(orderedItem);

				OrderedItemManager OIMgr = new OrderedItemManager();
				OIMgr.insertOrderedItem(orderedItem);
				OrderManager orderMgr = new OrderManager();
				orderMgr.insertOrder(orderedItem);
				//display total price for a transaction
			//	textField.setText("RM "+ df.format(sum));
				
				//getOrderedMenu();
				
			}	
			
		});
		
		btnNewButton_1.setBackground(new Color(102, 204, 51));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(260, 526, 163, 38);
		panel_2.add(btnNewButton_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(531, 513, 471, 214);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBackground(SystemColor.inactiveCaptionBorder);
		textField_1.setBounds(20, 103, 364, 26);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Credit Card Number:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(20, 80, 180, 13);
		panel_3.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Process Payment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_1.getText().isEmpty())
				{
					test();
					JOptionPane.showMessageDialog(null,"Please Enter Credit Card Number");
				} 
				else //every thing is fine, you can continue
				{
					
				card=textField_1.getText();
				if(card.length() != 16) {
					popUp();
					
			}
				else {
					popUpTrue();
				
				}
				try {
					release();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				double a=getTotalOrderPrice();
				System.out.printf("%.2f",a);
				OrderTransactionManager OTMgr = new OrderTransactionManager();
				OTMgr.insertTransaction(orderTransaction);
			}}
		});
		btnNewButton.setBounds(115, 172, 198, 21);
		panel_3.add(btnNewButton);
		
		
	}

public ArrayList<OrderedItem> getMenu() {
	return cart;
}
public void setCreditCardNumber() throws InterruptedException {
	textField_1.getText();
}

//Calculate total of suvtotal in the arraylist
public double getTotalOrderPrice() {
	for (int i=0; i<amount.size();i++) {
		totalAmount=totalAmount+amount.get(i);
		
	}
	return totalAmount;
}
public String getCreditCardNumber() throws InterruptedException{
	
	waitForInput();
	return card;
}
public void printOrderedItem(OrderedItem orderedItem) {
	String text = "";
  //for(int i = 0;i<itemName.length ; i++) {
      // ItemProduct itemProduct = new ItemProduct();
    //  itemProduct = productManager.getProduct(i+1);

     //if(itemName[i]) {
	
	text +=orderedItem.getItemProduct().getName() +" x " + orderedItem.getQuantity() + " : RM" +df.format(orderedItem.getSubTotalAmount())  + "\n";
         //  orderedItem.setItemProduct(productManager.getProduct(i));
       // }
       
   // }
    
   textArea.setText(text);
  // textArea.setVisible(true);
    //return text;
   
}


public void UpdateTotal(double subtotal) 
{
    
   // for(int i = 0; i<itemName.length ; i++) 
    //{
      //  if (itemName[i]) 
       // {
            totalprice += subtotal;
       // }
    //}
    textField.setText("RM " + df.format(totalprice));
    
}
/*public OrderedItem orderedItem() {
	for(OrderedItem item : orderTransaction.getOrder().getOrderedItem()) {
		receipt += "\r\n";
		
		receipt += String.format("%-5d%-40sRM %7.2f",item.getQuantity(),
				item.getItemProduct().getName(),item.getSubTotalAmount());
	}
	return null;
	
}*/
public void waitForInput() throws InterruptedException {
	synchronized(this) {
		wait();
	}
}
public void release() throws InterruptedException {
	synchronized(this) {
		notifyAll();
	}
}

public void popUp() {
	JOptionPane.showMessageDialog(null,"Invalid Card Number");	
}


public void test() {
	for (OrderedItem item: cart){
		System.out.print(item.getItemProduct().getName());
	}
}

public ArrayList<OrderedItem> getOrderedItems() throws SQLException, InterruptedException {
	return cart;
}
public OrderTransaction getOrderTransaction() {
	return orderTransaction;
}
public void popUpTrue() {
	JOptionPane.showMessageDialog(null,"Order will be sent to Kitchen");	
}
}
