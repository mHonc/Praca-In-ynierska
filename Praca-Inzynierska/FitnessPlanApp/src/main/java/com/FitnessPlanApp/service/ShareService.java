package com.FitnessPlanApp.service;

import com.FitnessPlanApp.model.Plan;
import com.FitnessPlanApp.repository.PlanRepository;
import com.FitnessPlanApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShareService {
    @Autowired
    PlanRepository planRepository;

    @Autowired
    UserRepository userRepository;

    public List<Plan> getSharedPlanList(){
        return planRepository.findAllByShared(true);
    }

    public List<Plan> getAdminPlanList(){
        return planRepository.findAllByUser(userRepository.findById(1).get());
    }

    public void share(String planId){
        Plan plan = planRepository.findById(Integer.valueOf(planId)).get();
        plan.setShared(true);
        planRepository.save(plan);
    }

    public void unshare(String planId){
        Plan plan = planRepository.findById(Integer.valueOf(planId)).get();
        plan.setShared(false);
        planRepository.save(plan);
    }
}
