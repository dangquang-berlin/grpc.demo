package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.HelloClient;

/**
 * @author quangnd4
 * Date: 6/30/2026
 */

@RestController
@RequestMapping("/hello")
public class HelloController {

    private final HelloClient helloClient;

    public HelloController(HelloClient helloClient) {
        this.helloClient = helloClient;
    }

    @GetMapping("/{name}")
    public String hello(@PathVariable String name) {
        return helloClient.sayHello(name);
    }
}
