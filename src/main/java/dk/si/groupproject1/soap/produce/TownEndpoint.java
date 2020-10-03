package dk.si.groupproject1.soap.produce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import localhost._8080.GetTownResponse;
import localhost._8080.GetTownRequest;

/**
 * The @Endpoint annotation registers the class with
 * Spring WS as a potential candidate for processing incoming SOAP messages.
 */
@Endpoint
public class TownEndpoint {
    private static final String NAMESPACE_URL = "http://localhost:8080";

    private TownRepository townRepository;

    @Autowired
    public TownEndpoint(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    /**
     * The @PayloadRoot annotation is then used by Spring WS to pick
     * the handler method, based on the message’s namespace and localPart.
     *
     * The @ResponsePayload annotation makes Spring WS map the
     * returned value to the response payload.
     *
     * The @RequestPayload annotation indicates that the incoming
     * message will be mapped to the method’s request parameter.
     *
     * @param request
     * @return
     */
    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "getTownRequest")
    @ResponsePayload
    public GetTownResponse getTown(@RequestPayload GetTownRequest request) {
        GetTownResponse response = new GetTownResponse();
        response.setTown(townRepository.findTown(request.getZipCode()));
        return response;
    }

}
