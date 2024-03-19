package com.example.abbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.abbs.entity.Address;
import com.example.abbs.service.AddressService;

@Controller
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping
    public String listAddresses(Model model) {
        model.addAttribute("addresses", addressService.findAll()); // 모든 주소 정보를 조회하여 모델에 추가
        return "address/list"; // 뷰 이름 반환
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("address", new Address());
        return "address/add";
    }

    @PostMapping("/add")
    public String addAddress(Address address, RedirectAttributes redirectAttributes) {
        addressService.insert(address);
        redirectAttributes.addFlashAttribute("message", "주소가 성공적으로 추가되었습니다.");
        return "redirect:/address";
    }

    @GetMapping("/map/{bid}")
    public String showAddressMap(@PathVariable("bid") Long bid, Model model) {
        Address address = addressService.findById(bid);
        if (address != null) {
            model.addAttribute("roadAddress", address.getAddress());
            return "address/map"; // 지도를 표시하는 뷰로 변경
        } else {
            return "redirect:/address";
        }
    }
}