package com.cxy.common.utils;

import org.csource.common.MyException;
import org.csource.fastdfs.*;

import java.io.IOException;

public class FastDFSUtils {

    private TrackerClient trackerClient;
    private TrackerServer trackerServer;
    private StorageClient1 storageClient;

    public FastDFSUtils(String config) throws IOException, MyException {

        if (config.startsWith("classpath")){
            config = config.replace("classpath:", FastDFSUtils.class.getResource("/").getPath());
        }

        ClientGlobal.init(config);

        trackerClient = new TrackerClient();
        trackerServer = trackerClient.getConnection();
        storageClient = new StorageClient1(trackerServer,null);
    }

    public String uploadFile(String fileName, String extend) throws IOException, MyException {
        String path = storageClient.upload_file1(fileName, extend, null);
        return  path;
    }



}
