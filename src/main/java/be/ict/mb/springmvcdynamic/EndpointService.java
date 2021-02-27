package be.ict.mb.springmvcdynamic;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Service
@RequiredArgsConstructor
public class EndpointService {

    private final RequestMappingHandlerMapping requestMappingHandlerMapping;
    private final TimeController timeController;

    public void enableTime() throws NoSuchMethodException {
        RequestMappingInfo requestMappingInfo = RequestMappingInfo.paths("/time").methods(RequestMethod.GET).produces(MediaType.APPLICATION_JSON_VALUE).build();
        requestMappingHandlerMapping.registerMapping(requestMappingInfo, timeController, TimeController.class.getDeclaredMethod("showTime"));
    }

    public void disableTime() {
        RequestMappingInfo requestMappingInfo = RequestMappingInfo.paths("/time").methods(RequestMethod.GET).produces(MediaType.APPLICATION_JSON_VALUE).build();
        requestMappingHandlerMapping.unregisterMapping(requestMappingInfo);
    }
}
