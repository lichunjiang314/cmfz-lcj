package com.baizhi.controller;

import com.baizhi.entity.SowingMap;
import com.baizhi.service.SowingMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sowingMap")
public class SowingMapController {
    @Autowired
    private SowingMapService sowingMapService;

    @RequestMapping("/findAll")
    public @ResponseBody Map<String,Object> findAll(Integer page, Integer rows){
        Map<String,Object> results = new HashMap<String,Object>();
        //当前页数据rows:
        List<SowingMap> maps = sowingMapService.findByPage(page,rows);
        //总记录数
        Long totals = sowingMapService.findTotals();
        results.put("total",totals);
        results.put("rows",maps);
        return results;
    }

    @RequestMapping("/remove")
    public @ResponseBody Map<String,Object> remove(int id){
        Map<String,Object> results = new HashMap<String,Object>();
        try {
            sowingMapService.remove(id);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }

    @RequestMapping("/findOne")
    public @ResponseBody SowingMap findOne(int id){
        return sowingMapService.findById(id);
    }

    @RequestMapping("/motify")
    public @ResponseBody Map<String,Object> motify(SowingMap sowingMap){
        Map<String,Object> results = new HashMap<String,Object>();
        try {
            sowingMapService.motify(sowingMap);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }

    @RequestMapping(value = "upload",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> upLoadBannerFile(MultipartFile bannerFileName, String title,String description,HttpServletRequest request) throws IOException {
        Map<String,Object> results = new HashMap<String,Object>();
        try {
            String fileName=bannerFileName.getOriginalFilename();
            String realPath=request.getSession().getServletContext().getRealPath("/back/sowingMap/image");
            bannerFileName.transferTo(new File(realPath,bannerFileName.getOriginalFilename()));
            fileName="back/sowingMap/image/"+fileName;
            //创建Banner对象
            SowingMap sowingMap = new SowingMap();
            sowingMap.setDate(new Date().toString());
            sowingMap.setTitle(title);
            sowingMap.setStatus(true);
            sowingMap.setImgPath(fileName);
            sowingMap.setDescription(description);
            //入库
            sowingMapService.add(sowingMap);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }
}
