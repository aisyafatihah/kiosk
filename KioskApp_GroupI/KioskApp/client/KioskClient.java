//Nur Aisya Fatihah 
package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import kioskapp.ordereditem.OrderedItem;

/**
* @author NurAisyaFatihah
*/
public class KioskClient {

	public static void main(String [] args) throws UnknownHostException, IOException, InterruptedException, SQLException
	{
		kiosk frame = new kiosk();
		frame.setVisible(true);
		
		
			
		
		while(true){
		Socket socket = new Socket("localhost", 4222);
		socket.setKeepAlive(true);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
		
		//send to server
		DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
		
		String cardNo=frame.getCreditCardNumber();
		ArrayList<OrderedItem> orderedItems = new ArrayList<OrderedItem>();
		
		orderedItems = frame.getOrderedItems();
		for(OrderedItem abc: orderedItems) {
		System.out.print(abc.getItemProduct().getName());
		}
		
		dos.writeUTF(cardNo);
		dos.flush();
		
		objectOutputStream.writeObject(orderedItems);
		objectOutputStream.flush();
			
		DataInputStream inputStrm= new DataInputStream(socket.getInputStream());
		//read status from orderserver
		boolean receiveStatus=inputStrm.readBoolean();
		System.out.print(receiveStatus);
		
		/*if (receiveStatus=true) {
			frame.popUpTrue();
		}
			frame.popUp();*/
		
		/*OrderTransaction orderTransaction = new OrderTransaction();
		        orderTransaction=frame.getOrderTransaction();
		        System.out.print(orderTransaction);
		        objectOutputStream.writeObject(orderTransaction);
		        
		        objectOutputStream.flush(); 
			}*/
			

		//System.out.println("\nClientSide: End of application.\n");

}
}
}
	
	