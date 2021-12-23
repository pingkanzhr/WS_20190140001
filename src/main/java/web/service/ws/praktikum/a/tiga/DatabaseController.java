/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.service.ws.praktikum.a.tiga;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Asus
 */
@Controller
public class DatabaseController {
    @GetMapping(value="alattulis", produces = {
           MediaType.APPLICATION_JSON_VALUE
        }
    )
    @ResponseBody
    public List<Alattulis> getAlatTulis(){
        
        List<Alattulis> alattulis = new ArrayList<>();
        
        AlattulisJpaController controller = new AlattulisJpaController();
        
        try {
            alattulis = controller.findAlattulisEntities();
        } catch (Exception e){}
        
        return alattulis;
    }
}
