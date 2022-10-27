package com.example.sushiorder.controller;


import com.example.sushiorder.JSONout;
import com.example.sushiorder.entity.Sushi_order;
import com.example.sushiorder.service.SushiOrderService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;


@RestController
public class SushiOrderController {
    @Autowired
    private SushiOrderService sushiOrderService;
    @PostMapping("/orders")
    public JSONout postSushi(@RequestBody String sushiname) throws JSONException {
        JSONObject obj;
        JSONout jout;
        try{
            obj=new JSONObject(sushiname);
            String subs= obj.getString("sushi_name");
            Sushi_order sushi_order=sushiOrderService.addSushi(subs);
            if(sushi_order!=null){
                jout=new JSONout(sushi_order,0,"Order created");
            }
            else jout=new JSONout(null,1,"Order create failed");
        }
        catch(JSONException e){
            throw new RuntimeException();
        };
        return jout;
    }
    @DeleteMapping("/delete/{order_id}")
    public JSONout deleteSushi(@RequestBody Integer order_id){
        JSONout jout;
        if(sushiOrderService.delete(order_id)){
            jout=new JSONout(0,"Order cancelled");
        }
        else jout=new JSONout(1,"Order cancel failed");
        return jout;
    }
    @GetMapping("/orders/status")
    public Map<String, List<Sushi_order>> getStatus(){//list stream filter collect( grouping by)
        return sushiOrderService.getAllStatus();

    }

    @PutMapping("/orders/{order_id}/pause")
    public JSONout pauseSushi(@RequestBody Integer order_id) throws JSONException{
        JSONout jout;
        if(sushiOrderService.pause(order_id)){
            jout=new JSONout(0,"Order cancelled");
        }
        else jout=new JSONout(1,"Order pause failed");
        return jout;
    }

    @PutMapping("/orders/{order_id}/resume")
    public JSONout resumeSushi(@RequestBody Integer order_id) throws JSONException{
        JSONout jout;
        if(sushiOrderService.resume(order_id)){
            jout=new JSONout(0,"Order cancelled");
        }
        else jout=new JSONout(1,"Order resume failed");
        return jout;
    }
}