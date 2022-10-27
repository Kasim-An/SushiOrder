package com.example.sushiorder.service;


import com.example.sushiorder.entity.Status;
import com.example.sushiorder.entity.Sushi;
import com.example.sushiorder.entity.Sushi_order;
import com.example.sushiorder.repository.StatusRepository;
import com.example.sushiorder.repository.SushiOrderRepository;
import com.example.sushiorder.repository.SushiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ScheduledFuture;
import java.util.stream.Collectors;

@Component
@Service
public class SushiOrderService {

    @Autowired
    private SushiOrderRepository sushiOrderRepository;
    @Autowired
    private SushiRepository sushiRepository;
    @Autowired
    private StatusRepository statusRepository;

    //public Map<Integer, ScheduledFuture> map;
    public List<Sushi_order> taskList=new ArrayList<>();
    public Sushi_order addSushi(String sushi) {
        if(sushi!=null&&sushi.length()>0){
            Sushi s=sushiRepository.findByName(sushi);
            if(s!=null){//order found then add in order
                Sushi_order sushi_order=new Sushi_order();
                sushi_order.setSushi_id(s.getId());
                Status st=statusRepository.findByName("created");
                sushi_order.setStatus_id(st.getId());
                Date time=new Date();
                sushi_order.setCreatedtime(time);
                sushiOrderRepository.save(sushi_order);
                return sushi_order;
            }
        }
        return null;
    }

    public boolean delete(long orderid) {
        Sushi_order so=sushiOrderRepository.findById(orderid);
        if(so!=null){
            Status st=statusRepository.findByName("cancelled");
            //thread
            so.setStatus_id(st.getId());
            return true;
        }
        return false;
    }
    public Map<String, List<Sushi_order>> getAllStatus(){//AAABBBCCC  ABC ABC ABC
        Map orders=new HashMap<>();
        //List<Sushi_order> list;
        //orders=list.stream().collect(Collectors.groupingBy(sushiOrder::getStatus));
        return orders;
    }
    public boolean pause(long orderid) {
        Sushi_order so=sushiOrderRepository.findById(orderid);
        if(so!=null){
            Status st=statusRepository.findByName("pause");
            //thread
            so.setStatus_id(st.getId());
            return true;
        }
        return false;
    }
    public boolean resume(long orderid) {
        Sushi_order so=sushiOrderRepository.findById(orderid);
        if(so!=null){
            Status st=statusRepository.findByName("in-progress");
            //thread
            so.setStatus_id(st.getId());
            return true;
        }
        return false;
    }
}