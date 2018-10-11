package SOAP;

import entity.Bid;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface BidService {

    //a method which places a bid of a given amount in an auction and informs as to it is currently the highest bid.
    @WebMethod(operationName = "IsValid")
    @WebResult(name = "IsValid")
    Boolean placeBid(Bid bid);
}
