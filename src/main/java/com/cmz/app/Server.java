package com.cmz.app;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

import com.cmz.handler.TransferHandler;
import com.cmz.services.TransferService;


public class Server {
	static Logger logger = Logger.getLogger(Server.class);
	public static void main(String[] args) {
		DOMConfigurator.configure(System.getProperty("user.dir") + "/conf/log4j.xml");
		
		try {
			TServerSocket serverTransport = new TServerSocket(19090);
			Factory proFactory = new TBinaryProtocol.Factory();

			TProcessor processor = new TransferService.Processor<TransferHandler>(new TransferHandler());
			TThreadPoolServer.Args tArgs = new TThreadPoolServer.Args(serverTransport);
			tArgs.processor(processor);
			tArgs.protocolFactory(proFactory);

			TServer server = new TThreadPoolServer(tArgs);
			System.out.println("Start server on port 19090....");
			server.serve();
		} catch (TTransportException e) {
			e.printStackTrace();
		}
	}
}
