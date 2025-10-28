package com.example.jobremember;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.jobremember.model.JobPost;
import com.example.jobremember.service.JobService;

import org.springframework.ui.Model;




@Controller
public class JobController{

    @Autowired
    JobService service;
    
    @RequestMapping({"/","home"})
    public String home(){
        return "home";
    }
    @RequestMapping("addjob")
    public String addJob() {
        return "addjob";
    }

    @PostMapping("handleForm")
    public String handleForm(JobPost jobPost) {
        service.addJob(jobPost);
        return "success";
    }

    @GetMapping("viewalljobs")
    public String viewAllJobs(Model m) {
        List<JobPost> jobs = service.getJobs();
        m.addAttribute("jobPosts", jobs);
        return "viewalljobs";
    }
    
    
    
}