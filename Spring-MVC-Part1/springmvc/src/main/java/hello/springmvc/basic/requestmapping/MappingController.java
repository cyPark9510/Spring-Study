package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MappingController {

    /**
     * HTTP 메서드 모두(GET, HEAD, POST, PUT, PATCH, DELETE) 허용
     */
    @RequestMapping("/hello-basic")
    public String helloBasic() {
        log.info("Hello Basic");
        return "ok";
    }

    /**
     * method 특정 HTTP 메서드 요청만 허용
     */
    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        log.info("mappingGetV1");
        return "ok";
    }
}
