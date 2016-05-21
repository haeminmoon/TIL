package com.taehyung.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileOrderReader {
	
	private final int ORDER_SRL = 0;
	private final int USER_ID = 1;
	private final int PRODUCT_CODE = 2;
	private final int OPTION_CODE_START =3;

	public List<FileOrderData> readOrderLine(String filePath) throws IOException {
		List<FileOrderData> list = new ArrayList<FileOrderData>();
		BufferedReader br = new BufferedReader(new FileReader(filePath));
        while(true) {
            String line = br.readLine();
            if (line==null) break;
            FileOrderData data = parseOrderdata(line);
            if(data != null) {
            	list.add(data);
            }
        }
        br.close();
        return list;
	}
	
	private FileOrderData parseOrderdata(String line) {
		String orderData[] = line.split(",");
		List<String> optionCodeList = new ArrayList<>();
		for (int i=OPTION_CODE_START; i < orderData.length; i++){
			optionCodeList.add(orderData[i]);
		}
		return new FileOrderData(
						Long.parseLong(orderData[ORDER_SRL]), 
						orderData[USER_ID],
						orderData[PRODUCT_CODE], 
						optionCodeList
						);
	}
}
