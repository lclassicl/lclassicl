package net.mds.forum.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import net.coobird.thumbnailator.Thumbnails;

@Controller
@RequestMapping(value = "file")
public class FileController {
    
    private static final Logger logger = LoggerFactory.getLogger(FileController.class); 
    
    // root-contenxt에서 설정한 설정파일에서 값을 읽어와서 넣어준다
    @Value("${imageupload.url}")
    private String imageuploadUrl;
    
    @RequestMapping(value = "upload", method=RequestMethod.GET)
    public void upload() {
    	logger.info(imageuploadUrl + ": ");
    }
    
    @RequestMapping(value = "upload", method=RequestMethod.POST,
            produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseBody
    public Map<String, String> upload(FileVO fileVO) throws IllegalStateException, IOException {
        Map<String, String> map = new HashMap<String, String>();
        CommonsMultipartFile cmf = fileVO.getFile();
        
        if(cmf == null) {
            logger.info("파일이 전달되지 못했습니다");
            map.put("data", "failure");
            return map;
        }
           
//        long fileSize = cmf.getSize();
        String originalName = cmf.getOriginalFilename();
        File file = new File(imageuploadUrl, originalName);
//        int pos = originalName.lastIndexOf(".");
//        String filename = originalName.substring(0, pos);
        try {
            cmf.transferTo(file);
            logger.info(fileVO.toString());
        } catch (FileNotFoundException e) {
            createUploadDir();
            cmf.transferTo(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        boolean isImage = cmf.getContentType()
                             .substring(0, 6)
                             .toLowerCase()
                             .equals("image/");
        
        
        String extention = originalName.substring(originalName.lastIndexOf(".") + 1);
        File thum = new File(imageuploadUrl + "/thumb_" + originalName);
        if(isImage) {
            Thumbnails.of(file).size(100, 100).outputFormat(extention).toFile(thum);
        }
        
        map.put("location", originalName);
        
        return map;
        
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("file/uploadAction");
//        mav.addObject("fileSize", fileSize);
//        mav.addObject("originalName", originalName);
//        return mav;
        
    }

    private void createUploadDir() {
        File dir = new File(imageuploadUrl);
        if (!dir.exists()) {
            dir.mkdirs();
            logger.info(imageuploadUrl + " 디렉토리를 생성하였습니다");
        }
    }
    
    // 사용하고 싶은 자료가 있으면 그걸 써두면 알아서 받아줌
    @RequestMapping(value = "download/{filename:.+}")
    public void download(@PathVariable String filename, HttpServletResponse response) throws IOException {
        //HttpSession session,
//        session.getAttribute("user_id"); 파일에 대한 권한이 있는 지 없는 지 검사
//        logger.info(filename);
        File file = new File(imageuploadUrl, filename);
        response.setContentLength((int)file.length());
        response.setContentType("application/octet-stream"); // 파일 그대로 내보낼 때
        response.setHeader("Content-Disposition", "attachment;filename=" + URLDecoder.decode(filename, "UTF-8"));
        InputStream is = new FileInputStream(imageuploadUrl + "/" + filename);
        OutputStream os = response.getOutputStream(); // 응답객체로 내보냄
        FileCopyUtils.copy(is, os);
        
        os.flush();
        
        if(os != null) try{ os.close(); } catch(Exception e) {}
        if(is != null) try{ is.close(); } catch(Exception e) {}
    }
}
