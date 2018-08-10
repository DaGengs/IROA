package cn.iruier.web.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.iruier.common.utils.FileUtils;
import cn.iruier.common.vo.ResultVo;

@Controller
public class FileUploadController {

    @RequestMapping(value = "/fileupload.do", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo fileupload(String empl_no, MultipartFile file, HttpServletRequest request) throws Exception {
        ResultVo resultVo = new ResultVo();
        //获取文件名
        String fileName = file.getOriginalFilename();
        //获取文件后缀
        String fileSuffix = fileName.substring(fileName.indexOf("."), fileName.length());
        //以工号为名字
        fileName = empl_no + fileSuffix;

        String webapps = new File(request.getServletContext().getRealPath("/")).getParentFile() + "/resources";

        File files = new File(webapps, "employeeImgs");

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

}
