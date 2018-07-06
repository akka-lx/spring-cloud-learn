package controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 简单的接口，hello eureka!
 *
 * @author skywalker
 */
@RestController
@Slf4j
public class HelloController {

    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        List<String> services = discoveryClient.getServices();
        log.info("All known service ids: {}.", services);
        return "Hello eureka!";
    }

}
