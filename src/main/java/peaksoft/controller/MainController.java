package peaksoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Mukhammed Asantegin
 */
@Controller
@RequestMapping
public class MainController {

    @GetMapping
    public String mainPage(){
        return "main-page";
    }


}
