package dk.si.groupproject1.soap.consume;

import localhost._8080.GetTownRequest;
import localhost._8080.GetTownResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class TownClient extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(TownClient.class);

    public GetTownResponse getTown(Integer zipCode) {

        GetTownRequest request = new GetTownRequest();
        request.setZipCode(zipCode);

        log.info("Requesting location for " + zipCode);

        GetTownResponse response = (GetTownResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/towns", request,
                        new SoapActionCallback(
                                "http://localhost:8080/GetTownRequest"));

        return response;
    }

}
