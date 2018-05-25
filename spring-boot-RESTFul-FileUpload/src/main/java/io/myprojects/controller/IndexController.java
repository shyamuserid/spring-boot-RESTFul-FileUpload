/**
 * Created by Shyam on 5/24/18.
 */
package io.myprojects.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "upload";
    }

}