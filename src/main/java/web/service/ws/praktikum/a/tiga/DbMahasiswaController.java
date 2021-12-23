/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.service.ws.praktikum.a.tiga;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Asus
 */
@Controller
public class DbMahasiswaController {
    @CrossOrigin
    @RequestMapping(value="/datamahasiswa/xml", produces={
        MediaType.APPLICATION_XML_VALUE
    })
    @ResponseBody
    public List<Datamahasiswa> getXML(){
        List<Datamahasiswa> data = new ArrayList<>();
        DatamahasiswaJpaController cont = new DatamahasiswaJpaController();
        try{
            data = cont.findDatamahasiswaEntities();
        }catch(Exception ex){
            
        }
        return data;
    }
    
    @CrossOrigin
    @RequestMapping(value="/datamahasiswa/json", produces={
        MediaType.APPLICATION_JSON_VALUE
    })
    @ResponseBody
    public List<Datamahasiswa> getJSON(){
        List<Datamahasiswa> data = new ArrayList<>();
        DatamahasiswaJpaController cont = new DatamahasiswaJpaController();
        try{
            data = cont.findDatamahasiswaEntities();
        }catch(Exception ex){
            
        }
        return data;
    }
}
