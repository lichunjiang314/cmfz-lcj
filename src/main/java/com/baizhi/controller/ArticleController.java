package com.baizhi.controller;

import com.baizhi.entity.Article;
import com.baizhi.service.ArticleService;
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
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/findAll")
    public @ResponseBody Map<String,Object> findAll(Integer page, Integer rows){
        Map<String,Object> results = new HashMap<String,Object>();
        //当前页数据rows:
        List<Article> maps =articleService.findByPage(page,rows);
        //总记录数
        Long totals = articleService.findTotals();
        results.put("total",totals);
        results.put("rows",maps);
        return results;
    }

    @RequestMapping("/remove")
    public @ResponseBody Map<String,Object> remove(int id){
        Map<String,Object> results = new HashMap<String,Object>();
        try {
            articleService.remove(id);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }

    @RequestMapping("/motify")
    public @ResponseBody Map<String,Object> motify(Article article){
        Map<String,Object> results = new HashMap<String,Object>();
        try {
            articleService.motify(article);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> add(MultipartFile bannerFileName, HttpServletRequest request,Article article) throws IOException {
        Map<String,Object> results = new HashMap<String,Object>();
        try {
            String fileName=bannerFileName.getOriginalFilename();
            String realPath=request.getSession().getServletContext().getRealPath("/back/article/image");
            bannerFileName.transferTo(new File(realPath,bannerFileName.getOriginalFilename()));
            fileName="back/article/image/"+fileName;
            //创建Banner对象
            article.setImg(fileName);
            articleService.add(article);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }
}
