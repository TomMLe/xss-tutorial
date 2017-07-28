package com.tom.storedxss.web;

/**
 * Created by thongminhle on 7/26/17.
 */

import com.tom.storedxss.service.CommentSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class CommentController {

    private CommentSite site;

    @Autowired
    public CommentController(CommentSite site){
        this.site = site;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Map<String, Object> model) {
        model.put("commentList", site.getCommentList());
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addComment(@RequestParam String comment, ModelMap model) {

        site.storeComment(comment);
        model.addAttribute("commentList", site.getCommentList());
        return "index";
    }

}
