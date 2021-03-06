package com.aude.mvc.mvc.upload;

import com.aude.mvc.constant.ConstanErrorMsg;
import com.aude.mvc.constant.Constant;

import java.util.regex.Matcher;

/**
 * Created by IntelliJ IDEA.
 * User: audestick@gmail.com
 * Date: 2016/5/30 0030
 * To change this template use File | Settings | File Templates.
 */
public class FileUploadAdapter {

    public static void checkFile(String fileName, int size) {
        Matcher matcher = Constant.ATTACH_PATTERN.matcher(fileName);
        if (!matcher.matches()) {
            throw new RuntimeException(ConstanErrorMsg.FILE_UPLOAD_SUFFIX.replace("{SUFFIX}", fileName.split("\\.")[1]));
        } else if (size > (Constant.ATTACH_MAX_FILE_SIEZ * 1024 * 1024)) {
            throw new RuntimeException(ConstanErrorMsg.FILE_UPLOAD_MAX_SZIE.replace("{MAXSIZE}", String.valueOf(Constant.ATTACH_MAX_FILE_SIEZ)));
        }
    }
}
