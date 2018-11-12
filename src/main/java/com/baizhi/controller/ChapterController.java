package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import com.baizhi.util.DurationUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> add(MultipartFile file, HttpServletRequest request, Chapter chapter) throws IOException {
        Map<String,Object> results = new HashMap<String,Object>();
        try {
            String realPath = request.getSession().getServletContext().getRealPath("/back/album/video");//获取文件绝对路径
            file.transferTo(new File(realPath,file.getOriginalFilename()));//上传音频
            Double dou = file.getSize()/1024.0/1024.0;//转换为M级别
            dou = (double)Math.round(dou*100)/100;//获取小数点后两位
            File filee = new File(realPath+"/"+file.getOriginalFilename());//获取音频
            String time = DurationUtil.getVideoTime(filee);//调用工具类获取时长
            //创建chapter对象
            chapter.setHref("back/album/video/"+file.getOriginalFilename());
            chapter.setDuration(time);
            chapter.setSize(dou);
            chapterService.add(chapter);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }

    @RequestMapping("/download")
    public void download(String fileName, String openStyle, HttpServletRequest request, HttpServletResponse response) throws Exception {

        //1.根据接收的文件名去服务中指定目录读取文件
        String realPath = request.getSession().getServletContext().getRealPath("/back/album/video");
        String filenames[] = fileName.toString().split("/");
        String filename = filenames[filenames.length-1];
        //2.以文件输入流读取文件
        FileInputStream is = new FileInputStream(new File(realPath, filename));
        //2.1 设置响应头
        response.setHeader("content-disposition", openStyle+";fileName=" + URLEncoder.encode(fileName, "UTF-8"));
        //3.获取响应输出流
        ServletOutputStream os = response.getOutputStream();
        //4.使用IOUtils工具类
        IOUtils.copy(is, os);
        //5.关流
        IOUtils.closeQuietly(is);//安静关流
        IOUtils.closeQuietly(os);
    }


}
