package com.baizhi.controller;

import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/guru")
public class GuruController {
    @Autowired
    private GuruService guruService;

    @RequestMapping("/findAll")
    public @ResponseBody Map<String,Object> findAll(Integer page, Integer rows){
        Map<String,Object> results = new HashMap<String,Object>();
        //当前页数据rows:
        List<Guru> gurus = guruService.findByPage(page,rows);
        //总记录数
        Long totals = guruService.findTotals();
        results.put("total",totals);
        results.put("rows",gurus);
        return results;
    }

    @RequestMapping("/remove")
    public @ResponseBody Map<String,Object> remove(int id){
        Map<String,Object> results = new HashMap<String,Object>();
        try {
            guruService.remove(id);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }

    @RequestMapping("/findOne")
    public @ResponseBody Guru findOne(int id){
        return guruService.findById(id);
    }

    @RequestMapping("/motify")
    public @ResponseBody Map<String,Object> motify(Guru guru){
        Map<String,Object> results = new HashMap<String,Object>();
        try {
            guruService.motify(guru);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }

    @RequestMapping(value = "upload",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> upLoadBannerFile(MultipartFile bannerFileName, String name, String sex, HttpServletRequest request) throws IOException {
        Map<String,Object> results = new HashMap<String,Object>();
        try {
            String fileName=bannerFileName.getOriginalFilename();
            String realPath=request.getSession().getServletContext().getRealPath("/back/guru/image");
            bannerFileName.transferTo(new File(realPath,bannerFileName.getOriginalFilename()));
            fileName="back/guru/image/"+fileName;
            //创建Banner对象
            Guru guru = new Guru();
            guru.setName(name);
            guru.setSex(sex);
            guru.setHeadpic(fileName);
            //入库
            guruService.add(guru);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }
}
