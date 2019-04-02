package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CourseScoreController {
    @RequestMapping("/getCourseScore")
    public void getFeatureList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
    }
}
