include "domain.thrift"

namespace java com.cmz.services
namespace cpp com.cmz.services

service TransferService{
	string sendData(1:domain.MyData data)
}