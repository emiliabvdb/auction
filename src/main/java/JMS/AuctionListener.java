package JMS;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.io.IOException;

@MessageDriven(mappedName = "jms/dat250/Topic", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "AuctionStatus = 'Complete'")
})
public class AuctionListener implements MessageListener {

    @Override
    public void onMessage(Message message) {

        try {
            AuctionMessage auctionMessage = message.getBody(AuctionMessage.class);
            JsonObject json = new JsonObject();
            ObjectMapper objectMapper = new ObjectMapper();


            try{
                json.addProperty("Winner", objectMapper.writeValueAsString(auctionMessage.getWinner()));
                json.addProperty("Seller", objectMapper.writeValueAsString(auctionMessage.getSeller()));
                json.addProperty("Auction", objectMapper.writeValueAsString(auctionMessage.getAuction()));
            } catch (JsonProcessingException e){
                e.printStackTrace();
            }

            try {
                AuctionConnection ac = new AuctionConnection();
                ac.publish(json);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (JMSException e1) {
            e1.printStackTrace();
        }

    }
}
