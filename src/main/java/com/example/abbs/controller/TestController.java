package com.example.abbs.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.abbs.util.AsideUtil;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board1")
public class TestController {
    @Autowired private AsideUtil asideUtil;
    
    @GetMapping("/index")
    public String index(HttpSession session, Model model) {
        
        // 세션에서 location 값을 가져옴
        String location = (String) session.getAttribute("location");
        
        // location 값이 null인 경우 기본값 설정
        if (location == null) {
            location = "서울특별시 청와대"; // 예시로 "서울특별시 청와대"를 기본 위치로 설정
        }
        
        // location 값을 바로 지오코딩에 사용하여 위도와 경도를 얻음
        Map<String, String> map = asideUtil.getGeocode(location);
        if (map != null && map.containsKey("lon") && map.containsKey("lat")) {
            // 지오코딩 결과를 모델에 추가
            model.addAttribute("xy", map.get("lat") + ", " + map.get("lon"));
        } else {
            // 지오코딩 결과가 없는 경우, 예시로 사용된 기본 xy 값을 모델에 추가
            String xy = "37.575929, 126.976849"; // 청와대의 위치를 예시로 사용
            model.addAttribute("xy", xy);
        }
        
        return "map";
    }
}