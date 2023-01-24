package su.um.feri.zimskasola.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("info")
    public String getInfo(){
        return "Hello";
    }
}
