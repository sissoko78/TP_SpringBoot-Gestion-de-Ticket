package com.TP_SpringBoot.TP_SpringBoot.Controller;


import com.TP_SpringBoot.TP_SpringBoot.Model.Reponse;
import com.TP_SpringBoot.TP_SpringBoot.Service.ReponseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Reponse")
@AllArgsConstructor
public class ReponseController {
    private ReponseService reponseService;
    /*@PostMapping("/CreationReponse")
    private Reponse CreationReponse(@RequestBody Reponse reponse){
        return reponseService.CreerReponse(reponse);
    }*/
    @GetMapping("/AfficherReponse")
    private List<Reponse> ReadReponse(){
        return reponseService.lireReponse();
    }
    @PutMapping("/ModifierReponse/{Id}")
    private Reponse ModifierReponse(@PathVariable Long Id, @RequestBody Reponse reponse){
    return reponseService.modifyReponse(Id, reponse);
    }

    @DeleteMapping("/DeleteReponse/{Id}")
    private String DeleteReponse(@PathVariable Long Id){
        return reponseService.deleteReponse(Id);
    }
}
