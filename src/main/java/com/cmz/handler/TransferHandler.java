package com.cmz.handler;

import org.apache.thrift.TException;

import com.cmz.domain.MyData;
import com.cmz.services.TransferService.Iface;

public class TransferHandler implements Iface {

	@Override
	public String sendData(MyData data) throws TException {
		System.out.println(data.msg);
		return data.msg;
	}

}
