package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import client.kiosk;
/**
 * @author HidayatiRahmah
 */
public class CreditCardAuthorizationServer {

	public static void main(String[] args) throws IOException{
	// Launch the server frame
		
		CardFrame serverFrame = new CardFrame();
		serverFrame.setVisible(true);
		
		kiosk kioskframe = new kiosk();
		int portNo = 4230;
		
		//Bind Serversocket to a port
		ServerSocket serverSocket = new ServerSocket(portNo);
	
		GenerateDate dateGenerator = new GenerateDate();
		//Accept client request for connection
		Socket socket = serverSocket.accept();
		
	
		//counter to keep track the number of requested connection
		int totalRequest=0;
		///////////////////////////////////////////
		//Nur Aisya Fatihah
		while(true) {
			
			//Get current date
			String currentDate = dateGenerator.getCurrentDate();
			
			//Create stream to write data on the network
			DataInputStream inputStream = new DataInputStream(socket.getInputStream());
			DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
			String creditCard= inputStream.readUTF();
			
			System.out.print("From order server: "+ creditCard);
			boolean status=false;
			
			ValidateCard validate=new ValidateCard();
			//validate.setCard();
			String kadNum=validate.getValidateCard(creditCard);
			
			serverFrame.updateRequestStatus("Data sent to the client: " + currentDate);
			serverFrame.updateRequestStatus(
					"Accepted connection from the client. Total request = " +  ++totalRequest);
			serverFrame.updateRequestStatus(
					"Credit Card No sent = " +  creditCard);
			
			try {
			Long creditCardNum=Long.parseLong(creditCard);
			
			if (kadNum.contentEquals("invalid")) {
				//frame.popUp();
				status=false;
				System.out.print(kadNum);
				serverFrame.updateRequestStatus(
						"\nCredit Card = " +  status);
			}
			else {
				status=true;
				serverFrame.updateRequestStatus(
						"\nCredit Card = " +  status);
				outputStream.writeBoolean(status);
			}
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			
			/*//String CardNo=inputStream.readUTF();
			//System.out.print("Card No: " + CardNo);
			
			ValidateCard val=new ValidateCard(kadNum);
			
			//stream to write data to network
			DataOutputStream out=new DataOutputStream(clientSocket.getOutputStream());
			
			//send data
			out.writeUTF(val.getValidateCard(kadNum));
			out.flush();
			
			//Send current date back to the client
			out.writeBytes(currentDate);
			//Get current date
			
			//CLose socket
			clientSocket.close();
			
			
			//update the request status
			serverFrame.updateRequestStatus("Data sent to the client: " + currentDate);
			serverFrame.updateRequestStatus(
					"Accepted connection from the client. Total request = " +  ++totalRequest);
			
		}*/ 
			
		}
	
		
	
}
}

