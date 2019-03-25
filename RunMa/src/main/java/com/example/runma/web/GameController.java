package com.example.runma.web;

import com.example.runma.GameMethod;
import com.example.runma.Ma;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class GameController {
    static Map<Integer, Ma> maMap = new ConcurrentHashMap<>();
    static int sum = 0;

    @PostConstruct
    public void postConstruct() {
        for (int i=1; i<5; i++) {
            maMap.put(i, new Ma(i));
        }
    }

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String index() {
        // 加入一个属性，用来在模板中读取
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }

    @RequestMapping(value="/game", method= RequestMethod.GET)
    public String index(ModelMap map, @RequestParam Integer id) {
        sum++;
        Ma ma = new Ma(id);
        maMap.put(id, ma);
        ma.setName(""+id);
        ma.setLocation(1);
        ma.setName(GameMethod.getString(1));
        map.addAttribute("maMap", maMap);
        map.addAttribute("sum",sum);
        return "game";
    }


}
