package com.github.sparkzxl.file.interfaces.controller;

import com.github.sparkzxl.file.api.FileApi;
import com.github.sparkzxl.file.dto.FileDTO;
import com.github.sparkzxl.log.annotation.WebLog;
import com.github.sparkzxl.web.annotation.ResponseResult;
import com.github.sparkzxl.file.application.service.IFileService;
import com.github.sparkzxl.file.interfaces.dto.FileMaterialDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * description: 文件上传 前端控制器
 *
 * @author zhouxinlei
 * @date 2020-05-24 12:40:10
 */
@RestController
@WebLog
@Api(tags = "文件管理")
public class FileController implements FileApi {

    private final IFileService fileService;

    public FileController(IFileService fileService) {
        this.fileService = fileService;
    }

    @ApiOperation("文件上传")
    @ResponseResult
    @PostMapping("/file/upload")
    public FileMaterialDTO upload(@RequestParam("file") MultipartFile multipartFile) throws Exception {
        return fileService.upload(multipartFile);
    }

    @ApiOperation("删除文件")
    @ResponseResult
    @DeleteMapping("/file/delete/{fileName}")
    public boolean delete(@PathVariable("fileName") String fileName) {
        return fileService.deleteFile(fileName);
    }

    @Override
    @ApiOperation("转换html文件")
    public FileDTO getHtml(@RequestBody FileDTO fileDTO) throws Exception {
        return fileService.getHtml(fileDTO);
    }

    @Override
    public FileDTO getPdf(FileDTO fileDTO) {
        return null;
    }

    @ResponseResult
    @Override
    public String getSayHello() {
        return "sayHello";
    }
}
