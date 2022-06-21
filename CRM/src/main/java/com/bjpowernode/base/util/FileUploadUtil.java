package com.bjpowernode.base.util;

import com.bjpowernode.base.bean.ResultVo;
import com.bjpowernode.base.exception.CrmEnum;
import com.bjpowernode.base.exception.CrmException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * @author cty
 * @date 2021/10/26 10:13
 */
public class FileUploadUtil {
    public static ResultVo fileUpload(MultipartFile img, HttpServletRequest request) {
        ResultVo resultVo = new ResultVo();
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String fileName = img.getOriginalFilename();
        //防止用户上传相同文件名的文件
        fileName = System.currentTimeMillis() + fileName;
        try {
            //上传后缀名为png,jpg,jpeg,gif,webp的文件
            suffix(fileName);
            //上传文件大小为 <= 2M
            maxSize(img.getSize());
            img.transferTo(new File(realPath + File.separator + fileName));
            String path = request.getContextPath() + File.separator + "upload" + File.separator + fileName;
            resultVo.setOk(true);
            resultVo.setMessage("上传头像成功");
            resultVo.setT(path);
        } catch (CrmException e) {
            resultVo.setOk(false);
            resultVo.setMessage(e.getMessage());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return resultVo;
    }

    //上传文件大小 <= 2M
    private static void maxSize(long size) {
        long maxSize = 2 * 1024 * 1024;
        if (size > maxSize) {
            throw new CrmException(CrmEnum.USER_UPDATE_MAXSIZE);
        }
    }

    private static void suffix(String fileName) {
        String correctSuffix = "png,jpg,jpeg,gif,webp";
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        if (!correctSuffix.contains(suffix)) {
            throw new CrmException(CrmEnum.USER_UPDATE_SUFFIX);
        }
    }
}
