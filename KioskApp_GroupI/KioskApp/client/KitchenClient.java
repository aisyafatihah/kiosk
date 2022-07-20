//Nur Aisya Fatihah
package client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import kioskapp.ordereditem.OrderedItem;

/**
* @author NurAisyaFatihah
*/
public class KitchenClient {
	

		@SuppressWarnings("unchecked")
		public static void main(String arg[]) throws UnknownHostException, IOException, ClassNotFoundException {
			//int portNo=4222;
			KitchenFrame frame = new KitchenFrame();
			frame.setVisible(true);
			
			while(true) {
				Socket socketKitchen = new Socket(InetAddress.getLocalHost(),4222);
	            socketKitchen.setKeepAlive(true);
	            ObjectInputStream inputStream = new ObjectInputStream(socketKitchen.getInputStream());
	            DataInputStream dataIn=new DataInputStream(socketKitchen.getInputStream());
	            
	            ArrayList<OrderedItem> orderedItems = new ArrayList<OrderedItem>();
		           orderedItems = (ArrayList<OrderedItem>) inputStream.readObject();
		           
				for(OrderedItem abc: orderedItems) {
					System.out.print(abc.getItemProduct().getName() + "\t");
					System.out.println(abc.getQuantity()+ "x\n");
					//System.out.println(abc.getSubTotalAmount());
				//}
				
				frame.updateMenu( abc.getItemProduct().getName() + "\t" + abc.getQuantity()+ "x\n" );
				//
			}
				socketKitchen.close();
			}
		}
}
