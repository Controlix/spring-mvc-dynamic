package be.ict.mb.springmvcdynamic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminController {

    private final EndpointService endpointService;

    @GetMapping("/enable")
    public void enableTimeEndpoint() throws Exception {
        log.debug("Try to turn on endpoint /time");
        endpointService.enableTime();
    }

    @GetMapping("/disable")
    public void disableTimeEndpoint() {
        log.debug("Try to turn off endpoint /time");
        endpointService.disableTime();
    }

}
