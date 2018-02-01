package main.service.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import main.domain.UserInfo;
import main.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequestMapping("/logincontroll")
@Controller
public class LoginController {
    @Reference
    private UserInfoService userInfoService;

    @RequestMapping("/entrance")
    public ModelAndView entrance() {
        return new ModelAndView("login");
    }

    @RequestMapping("/login")
    public ModelAndView login(HttpSession session, HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserInfo user = userInfoService.validate(username, password);
        if (null == user) {
            return new ModelAndView("login");
        } else {
            session.setAttribute("id", user.getId());
            ModelAndView modelAndView = new ModelAndView("index");
            modelAndView.addObject("id", user.getId());
            return modelAndView;
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpSession session) {
        session.removeAttribute("id");
        return "redirect:/logincontroll/entrance";
    }
}
