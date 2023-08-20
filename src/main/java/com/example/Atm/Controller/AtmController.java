package com.example.Atm.Controller;

import com.example.Atm.Dto.AtmDto;
import com.example.Atm.Service.AtmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AtmController {

    @Autowired
    private AtmService atmService;

    public static String a = "Success";
    @PostMapping("/withdraw")
    public AtmDto withdraw(@RequestBody AtmDto atmDto)
    {
        return atmService.doWithdraw(atmDto.getAmount());
    }

    @GetMapping("/money")
    public AtmDto bill()
    {
        return atmService.getMoney();
    }


}
