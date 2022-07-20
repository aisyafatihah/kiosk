package server;

import java.net.*;
import java.util.ArrayList;
import java.util.List;

import kioskapp.ordereditem.OrderedItem;
import kioskapp.ordertransaction.OrderTransaction;

import java.io.*;
/**
 * @author HidayatiRahmah
 */
public class OrderServer 
{

	//initialize socket and input stream
	//private static Socket clientSocket = null;
	//private static ServerSocket server = null;
	//private static DataInputStream in = null;
	
	
	public static void main(String args[]) throws ClassNotFoundException, IOException
	{
		
		OrderFrame orderFrame = new OrderFrame();
		orderFrame.setVisible(true);
	//constructor with port
	//public OrderServer(int port)
	//{
		//starts server and waits for a connection
		
			//Port to receive and responnd to request
			int portNo = 4222;
			int referenceNumber = 0;
			ServerSocket server = new ServerSocket(portNo);
			System.out.println("Server is starting");
			System.out.println("Waiting for a client...");
			Socket clientSocket = server.accept();
			Socket kitchenSocket = server.accept();
			//int request = in.readInt();
			
			while(true) {
				
				GenerateDate dateGenerator = new GenerateDate();
				//Get current date
				String currentDate = dateGenerator.getCurrentDate();
				
				//counter to keep track the number of requested connection
				int totalRequest=0;
				
				//accept client request for connection
				
				System.out.println("\nClient accepted");
				
				//create input stream to read data
				ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());
				ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
				DataInputStream dataInput=new DataInputStream(clientSocket.getInputStream());
				
				
				//process request

				//System.out.println("Request from client: " + request );
				//String line = " ";
				
				//read card from client kiosk
				String creditCardNo = dataInput.readUTF();
				System.out.print("From client: "+ creditCardNo);
				
				
				////////////////////////////////////////////////////////////////////////////////////////////////////////
				//Nur Aisya Fatihah				


				int portNumber= 4230;
				String address="localhost";
				
				Socket socket = new Socket(address,portNumber);
				
				DataOutputStream outputStrm= new DataOutputStream(socket.getOutputStream());
				//send cardNo to cardserver
				outputStrm.writeUTF(creditCardNo);
				
				DataInputStream inputStrm= new DataInputStream(socket.getInputStream());
				//read status from cardserver
				boolean receiveStatus=inputStrm.readBoolean();
	
				
				
				System.out.print("__: " + receiveStatus);
				socket.close();
				
				//read from kiosk client
	
				ArrayList<OrderedItem> orderedItems = new ArrayList<OrderedItem>();
				orderedItems = (ArrayList<OrderedItem>) inputStream.readObject();
				
				ObjectOutputStream oos=new ObjectOutputStream(kitchenSocket.getOutputStream());
				oos.writeObject(orderedItems);
				
				orderFrame.updateRequestStatus("Data sent to the client: " + currentDate);
				orderFrame.updateRequestStatus(
						"Accepted connection from the client. Total request = " +  ++totalRequest);
				orderFrame.updateRequestStatus(
						"Credit Card sent = " +  creditCardNo);
				
				//DataOutputStream outStrm= new DataOutputStream(socket.getOutputStream());
				//send cardNo to cardserver
				//outputStream.writeBoolean(receiveStatus);
				
				
				OrderTransaction orderTransaction= new OrderTransaction();
				/*orderTransaction=(OrderTransaction) inputStream.readObject();
				orderTransaction.getOrderMode();
				System.out.print(orderTransaction.getOrderMode());*/
				
				//Order order = new Order();
				//order.setOrderedItems(orderedItems);
				//order.setTotalAmount(orderTransaction);
				//read from server
				/*DataInputStream inStream= new DataInputStream(socket.getInputStream());
				String kad=inStream.readUTF();
			
				
				// Close the stream
				inStream.close(); 
				socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  */
				
				//get orderTransaction from client
				//OrderedItem orderTransaction = (OrderTransaction)inputStream.readObject();
				
				
				//send request
				/*Socket transactionSocket = new Socket(InetAddress.getLocalHost(),4230);
				
				//create output stream to send result of data processing
				ObjectOutputStream transactionOutputStream = new ObjectOutputStream(transactionSocket.getOutputStream());
				//transactionOutputStream.writeObject(orderTransaction);
				transactionOutputStream.writeUTF(creditCardNo);
				transactionOutputStream.flush();
				
				//create input stream to read orderTransaction
				ObjectInputStream transactionInputStream = new ObjectInputStream(transactionSocket.getInputStream());*/
					
				//read transaction id that generate by transaction server
				//orderTransaction = (OrderTransaction)transactionInputStream.readObject();
				
				//insert order detail into database
				//if(orderTransaction.isTransactionStatus()){
						
					//orderTransaction.getOrder().setOrderReferenceNumber(++referenceNumber);;

					//OrderManager orderController = new OrderManager();
					//orderTransaction.setOrder(orderController.insertOrder(orderTransaction.getOrder()));

					//write transaction detail into database
					//OrderTransactionManager transactionController = new OrderTransactionManager();
					//transactionController.insertTransaction(orderTransaction);
					
					//insert ordered item into database
					//OrderedItemManager orderedItemController = new OrderedItemManager();
					//orderedItemController.insertOrderedItem(orderTransaction.getOrder());

					//ItemProductManager itemProductController = new ItemProductManager();
					//List<OrderedItem> products = orderTransaction.getOrder().getOrderedItems();
					/*for(OrderedItem product:products){
						product.setItemProduct(itemProductController.getProduct(product.getItemProduct().getItemProduct()));
					}}*/
				
					//create output stream to send result of data processing
				/*	ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
					
					//bind with card server
					int portNum = 4227;
					//send transaction detail to client
					outputStream.writeObject(orderTransaction);
					outputStream.flush();
					
					if(orderTransaction.isTransactionStatus()) {
						//accept connection from kitchen application
						ServerSocket kitchenServer = null;
						Socket kitchenSocket = kitchenServer.accept();	
						
						//send orderTransaction to kitchen server
						ObjectOutputStream kitchenOutputStream = new ObjectOutputStream(kitchenSocket.getOutputStream());
						kitchenOutputStream.writeObject(orderTransaction);
						
						kitchenOutputStream.close();
						kitchenSocket.close();
					}
				
					System.out.println("Closing connection...");
					
					//close connection
					clientSocket.close();
					transactionSocket.close();
					inputStream.close();
					outputStream.close();
					transactionOutputStream.close();
					transactionInputStream.close();
			}
			
			}}*/
			}
	
				
			}
}
			
	
	

	
	

