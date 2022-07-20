package server;
import java.util.Date;

	public class GenerateDate{

		//This method generate current date	
		public String getCurrentDate() {
			
			String currentDate = new Date().toString();
			return currentDate;
		}
	}

