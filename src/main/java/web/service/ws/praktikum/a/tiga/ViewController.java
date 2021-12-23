/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.service.ws.praktikum.a.tiga;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Asus
 */
@Controller
public class ViewController {
    
    @RequestMapping("/cari")
    public String getTabel(Model model, HttpServletRequest cari){
        
        String nama_barang_dicari = cari.getParameter("barangCari");
        String nama_ketemu = "";
        List<String> buffer = new ArrayList<>();
       
        ArrayList<List<String>> tabel_harga = new ArrayList<>();
        ArrayList<List<String>> tabel_baru = new ArrayList<>();
        
        tabel_harga.add(Arrays.asList("Telur", "1000"));
        tabel_harga.add(Arrays.asList("Mie x", "2500"));
        tabel_harga.add(Arrays.asList("Pensil", "4500"));
        tabel_harga.add(Arrays.asList("Tipex", "6500"));
        
        for (int brs=0;brs<tabel_harga.size();brs++){
            buffer = tabel_harga.get(brs);
            if (buffer.toString().contains(nama_barang_dicari)){
                 tabel_baru.add(tabel_harga.get(brs));
            } else {nama_ketemu="Tidak Ditemukan";}
        }
        

            
        model.addAttribute("tabel_baru", tabel_baru);
        model.addAttribute("barangdicari",nama_ketemu);
        return "viewTabel";
    }
    
    @RequestMapping("/hapus")
    public String deleteData (Model model, HttpServletRequest cari){
        String nama_barang_dihapus = cari.getParameter("barangApus");
        String nama_hapus = "";
        List<String> buffer = new ArrayList<>();
        ArrayList<List<String>> tabel_harga = new ArrayList<>();
        ArrayList<List<String>> tabel_baru = new ArrayList<>();
        
        tabel_harga.add(Arrays.asList("Telur", "1000"));
        tabel_harga.add(Arrays.asList("Mie x", "2500"));
        tabel_harga.add(Arrays.asList("Pensil", "4500"));
        tabel_harga.add(Arrays.asList("Tipex", "6500"));
        tabel_baru.clear();
        tabel_baru.addAll(tabel_harga);
        
        for (int brs=0;brs<tabel_harga.size();brs++){
            buffer = tabel_harga.get(brs);
            if (buffer.toString().contains(nama_barang_dihapus)){
                 tabel_baru.remove(tabel_harga.get(brs));
            } else {nama_hapus="Tidak Ditemukan";}
        }
            
        model.addAttribute("tabel_cari", tabel_harga);
        model.addAttribute("tabel_apus",tabel_baru);
        return "viewTabel";
    }
    @RequestMapping("/data/minuman")
    @ResponseBody
    
    public HashMap<String, String> getMinuman(){
        
        HashMap<String, String> map = new HashMap<>();
        map.put("k", "value");
        map.put("foo", "bar");
        map.put("aa", "bb");
        
        return map;
    }
    @RequestMapping("/data/cuaca")
    @ResponseBody
    
    public HashMap <String,Integer> getRamalan(){
        
        HashMap<String,Integer> map = new HashMap<>();
        
        map.put("suhu", 26);
        map.put("Kelembaban", 30);
        map.put("Tekanan", 3);
        
        return map;
    }
//    @GetMapping(value="data/xml", produces = {
//           MediaType.APPLICATION_XML_VALUE
//        }
//    )
    
//    @ResponseBody
//    public ArrayList<String> getData(){
//        
//        ArrayList<String> data = new ArrayList<>();
//        data.add("Adelia Pingkan Azzahra");
//        data.add("20190140001");
//        data.add("UMY");
//        
//        return data;
//    
    
    @CrossOrigin
    @GetMapping(value="data/pribadi", produces = {
           MediaType.APPLICATION_JSON_VALUE
        }
    )
    
    @ResponseBody
    public HashMap<String, String> getXML(){
        
        HashMap<String, String> map = new HashMap<>();
        map.put("Nama", "Adelia Pingkan Azzahra");
        map.put("Alamat", "20190140001");
        map.put("Collage", "UMY");
        
        return map;
    }
    
}