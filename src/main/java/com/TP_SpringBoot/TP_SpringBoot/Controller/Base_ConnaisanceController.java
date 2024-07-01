package com.TP_SpringBoot.TP_SpringBoot.Controller;


import com.TP_SpringBoot.TP_SpringBoot.Model.Base_Connaissance;
import com.TP_SpringBoot.TP_SpringBoot.Service.Base_ConnaissanceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Base_Connaissance")
@AllArgsConstructor
public class Base_ConnaisanceController {
    private Base_ConnaissanceService base_connaissanceService;


   /* @PostMapping("/CreateBase")
    private Base_Connaissance CreationBase_Connaissance(@RequestBody Base_Connaissance base_connaissance){
        return base_connaissanceService.CreerBase_Connaissance(base_connaissance);
    }
    @DeleteMapping("/SupprimerBase")
    private String DeleteBase_Connaissance(@PathVariable Long Id){
        return base_connaissanceService.deleteBase_Connaissance(Id);
    }*/

}
