package com.kaelvihn.miniodemo.demo;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.UploadObjectArgs;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author : KaelvihN
 * @date : 2023/9/19 23:50
 */
@Slf4j
public class FileUpLoader {

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
            log.info("linkstart不存在，现在创建");
            //不存在则创建
            MakeBucketArgs makeBucketArgs = MakeBucketArgs
                    .builder()
                    .bucket("linkstart")
                    .build();
            minioClient.makeBucket(makeBucketArgs);
        } else {
            log.info("linkstart存在");
        }
        minioClient.uploadObject(UploadObjectArgs.builder()
                //桶名
                .bucket("linkstart")
                //文件对象
                .object("credentials.json")
                //文件名(绝对路径)
                .filename("C:\\Users\\Aprox\\Desktop\\credentials.json")
                .build());
        log.info("Success");
    }
}
