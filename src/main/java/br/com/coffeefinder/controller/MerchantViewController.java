
package br.com.coffeefinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import br.com.coffeefinder.service.MerchantServiceImpl;

@Controller
public class MerchantViewController {

    private final MerchantServiceImpl merchantService;

    @Autowired
    public MerchantViewController(MerchantServiceImpl merchantService) {
        this.merchantService = merchantService;
    }

    @GetMapping("/merchants")
    public String showMerchantsPage(Model model) {
        model.addAttribute("merchants", merchantService.getAllMerchants());
        return "merchants";
    }
}
