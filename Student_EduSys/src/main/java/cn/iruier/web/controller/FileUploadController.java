package cn.iruier.web.controller;


import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.iruier.common.vo.ResultVo;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

    @RequestMapping(value = "/upCard_pre.do", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo upCard_pre(String stu_no, @RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request) throws Exception {
        System.out.println("file" + file);
        ResultVo resultVo = new ResultVo();
        //获取文件名
        String fileName = file.getOriginalFilename();
        //获取文件后缀
        String fileSuffix = fileName.substring(fileName.indexOf("."), fileName.length());
        //以学号为名字
        fileName = stu_no + "_card_pre_" + fileSuffix;

        String webapps = new File(request.getServletContext().getRealPath("/")).getParentFile() + "/resources";

        File files = new File(webapps, "studentImgs");

        if (!files.exists()) {
            files.mkdirs();
        }

        File destFile = new File(files, fileName);

        //保存文件
        file.transferTo(destFile);
        //获取文件名
        if (destFile.exists()) {
            resultVo.setCode(0);
            resultVo.setMsg(fileName);
        } else {
            resultVo.setCode(1);
            resultVo.setMsg("上传失败");
        }
        return resultVo;
    }

    @RequestMapping(value = "/upCard_suf.do", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo upCard_suf(String stu_no, MultipartFile file, HttpServletRequest request) throws Exception {
        ResultVo resultVo = new ResultVo();
        //获取文件名
        String fileName = file.getOriginalFilename();
        //获取文件后缀
        String fileSuffix = fileName.substring(fileName.indexOf("."), fileName.length());
        //以学号为名字
        fileName = stu_no + "_card_suf_" + fileSuffix;

        String webapps = new File(request.getServletContext().getRealPath("/")).getParentFile() + "/resources";

        File files = new File(webapps, "studentImgs");

        if (!files.exists()) {
            files.mkdirs();
        }

        File destFile = new File(files, fileName);

        //保存文件
        file.transferTo(destFile);
        //获取文件名
        if (destFile.exists()) {
            resultVo.setCode(0);
            resultVo.setMsg(fileName);
        } else {
            resultVo.setCode(1);
            resultVo.setMsg("上传失败");
        }
        return resultVo;
    }

    @RequestMapping(value = "/upPhoto.do", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo upPhoto(String stu_no, MultipartFile file, HttpServletRequest request) throws Exception {
        ResultVo resultVo = new ResultVo();
        //获取文件名
        String fileName = file.getOriginalFilename();
        //获取文件后缀
        String fileSuffix = fileName.substring(fileName.indexOf("."), fileName.length());
        //以学号为名字
        fileName = stu_no + "_photo_" + fileSuffix;

        String webapps = new File(request.getServletContext().getRealPath("/")).getParentFile() + "/resources";

        File files = new File(webapps, "studentImgs");

        if (!files.exists()) {
            files.mkdirs();
        }

        File destFile = new File(files, fileName);

        //保存文件
        file.transferTo(destFile);
        //获取文件名
		/*if (destFile.exists()) {
			resultVo.setCode(0);
			resultVo.setMsg(fileName);
		} else {
			resultVo.setCode(1);
			resultVo.setMsg("上传失败");
		}*/
        return resultVo;
    }
}
