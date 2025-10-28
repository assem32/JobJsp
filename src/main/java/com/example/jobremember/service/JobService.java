package com.example.jobremember.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobremember.model.JobPost;
import com.example.jobremember.repo.Repo;


@Service
public class JobService {

    @Autowired
    Repo repo; 

    public List<JobPost> getJobs(){
        return repo.getJobs();
    }
    public void addJob(JobPost jobPost){
        repo.addJob(jobPost);
        System.out.println(getJobs());
    }
    
}
