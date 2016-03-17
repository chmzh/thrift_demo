package com.cmz.app;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import com.cmz.domain.MyData;
import com.cmz.services.TransferService;


public class Client {
	   public static void main(String[] args) {  
	    	
	        try {  
	        	TTransport transport = new TSocket("127.0.0.1", 19090);  
	            transport.open();  
	            TProtocol protocol = new TBinaryProtocol(transport);  
	            TransferService.Client client = new TransferService.Client(protocol);  
	            
	            MyData data = new MyData();
	            data.msg = "hi,你好";

	            System.out.println(client.sendData(data));
	            

	        } catch (TTransportException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        } catch (TException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
	        
	    }  
}
