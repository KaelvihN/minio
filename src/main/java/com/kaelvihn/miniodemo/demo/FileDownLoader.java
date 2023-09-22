package com.kaelvihn.miniodemo.demo;

import io.minio.BucketExistsArgs;
import io.minio.DownloadObjectArgs;
import io.minio.MinioClient;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author : KaelvihN
 * @date : 2023/9/22 6:54
 */
@Slf4j
public class FileDownLoader {
    @SneakyThrows
    public static void main(String[] args) {
        /**
         * 创建minioClient
         */
        MinioClient minioClient = MinioClient.builder()
                //ip
                .endpoint("http://47.115.228.3:9000")
                //accessKey和secretKey
                .credentials("OxQs569MpwqEmyOK", "HvnjeFPUVPXjJE0xlsVRnQYHQ6yOYYOf")
                //创建MinioClient
                .build();
        //查看要上传到的bucket是否存在
        BucketExistsArgs existsArgs = BucketExistsArgs.builder()
                .bucket("linkstart")
                .build();
        boolean isExists = minioClient.bucketExists(existsArgs);
        if (!isExists) {
            log.info("linkstart不存在，无法下载");
            return;
        } else {
            log.info("linkstart存在");
        }
        minioClient.downloadObject(DownloadObjectArgs.builder()
                //桶名
                .bucket("linkstart")
                //对象
                .object("credentials.json")
                //下载后的文件名
                .filename("download.json")
                .build());
        log.info("Success");
    }
}
