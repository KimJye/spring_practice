package Controller;

import Model.product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class controller {

    @RequestMapping(value = "/")
    public String test(){
        return "index";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void testGET() {
        System.out.println("testGET() 호출");
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String test2(@ModelAttribute("num") int num){
        System.out.println("num: " + num);

        return "test-result";
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public void product() {
        System.out.println("product 호출");
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String product_result(@ModelAttribute("prod") product p) {
        System.out.println("name: " + p.getName());
        System.out.println("id: " + p.getId());

        return "product_result";
    }


}