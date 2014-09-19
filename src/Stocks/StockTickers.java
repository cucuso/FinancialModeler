package Stocks;

import org.apache.commons.net.ftp.FTPClient;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.InputStream;

public class StockTickers {

	public void getStocks() {

		FTPClient client = new FTPClient();
		FileOutputStream fos = null;
		try {
			client.connect("ftp.nasdaqtrader.com");
			client.login("anonymous", null);

			String filename = "nasdaqlisted.txt";
			fos = new FileOutputStream(filename);

			client.retrieveFile("/SymbolDirectory/" + filename, fos);

			System.out.println(fos.toString());
			fos.close();
			client.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
