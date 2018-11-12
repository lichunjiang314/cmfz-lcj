package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
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
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping("/findAll")
 /*   public @ResponseBody List<Album> findAll(){
        List<Album> all = albumService.findAll();
        return all;
    }*/
    public @ResponseBody
    Map<String,Object> findAll(Integer page, Integer rows){
        Map<String,Object> results = new HashMap<String,Object>();
        //当前页数据rows:
        List<Album> all = albumService.findByPage(page, rows);
        //总记录数
        Long totals = albumService.findTotals();
        results.put("total",totals);
        results.put("rows",all);
        return results;
    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> add(MultipartFile bannerFileName,HttpServletRequest request,Album album) throws IOException {
        Map<String,Object> results = new HashMap<String,Object>();
        try {
            String fileName=bannerFileName.getOriginalFilename();
            String realPath=request.getSession().getServletContext().getRealPath("/back/album/image");
            bannerFileName.transferTo(new File(realPath,bannerFileName.getOriginalFilename()));
            fileName="back/album/image/"+fileName;
            //创建Banner对象
            album.setImg(fileName);
            albumService.add(album);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }
}
