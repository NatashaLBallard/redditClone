package com.redditclone.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    LinkRepository linkRepository;

    @RequestMapping("/")
    public String listLinks(Model model){
        model.addAttribute("links", linkRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String linkForm(Model model){
        model.addAttribute("link", new Link());
        return "linkform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Link link, BindingResult result){
        if (result.hasErrors()){
            return "linkform";
        }
        linkRepository.save(link);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showLink(@PathVariable("id") long id, Model model){
        model.addAttribute("link", linkRepository.findOne(id));
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updateLink(@PathVariable("id") long id, Model model){
        model.addAttribute("link", linkRepository.findOne(id));
        return "linkform";
    }

    @RequestMapping("/delete/{id}")
    public String deleteLink(@PathVariable("id") long id){
        linkRepository.delete(id);
        return "redirect:/";
    }
}
