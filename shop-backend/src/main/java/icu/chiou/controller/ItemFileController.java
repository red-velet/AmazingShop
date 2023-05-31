package icu.chiou.controller;

import icu.chiou.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * Author: chiou
 * Date: 2023/5/31
 * Time: 16:21
 * Description: No Description
 */
@Api(tags = "文件上传接口")
@Slf4j
@RestController
public class ItemFileController {
    @Value("${amazing-shop.local.basePath}")
    private String basePath;

    @Value("${amazing-shop.cloud.qiniu.url}")
    private String URL;

//    @Autowired
//    RedisTemplate redisTemplate;

    //    @PostMapping("upload")
    @PostMapping("file")
    @ApiOperation("商品图片上传")
    public R<String> upload(@RequestParam("fileImage") MultipartFile imgFile) {
        log.info(imgFile.getOriginalFilename());
        log.info(imgFile.getContentType());
        log.info(imgFile.getSize() + "");
        //TODO 将上传的图片转存到本地 / 七牛云服务器
        //1.给图片起个不重复的名字
        //获取图片原始名称
        String originalFilename = imgFile.getOriginalFilename();
        //获取图片后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //设置新的无重复文件名
        String fileName = UUID.randomUUID().toString() + suffix;
        //todo 方法1：图片转存到本地
        File file = new File(basePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            imgFile.transferTo(new File(basePath + "//" + fileName));
            log.info("文件转存成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //todo 方法2：图片转存到七牛云
//        try {
//            QiNiuCloudUtil.upload2QiNiu(imgFile.getBytes(), fileName);
//            //将图片名存储到redis中
//            redisTemplate.opsForSet().add(RedisConstant.PREFIX_IMG_TMP, fileName);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return R.success(fileName);
    }
}
