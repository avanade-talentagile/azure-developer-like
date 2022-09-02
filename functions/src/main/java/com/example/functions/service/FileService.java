package com.example.functions.service;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.specialized.BlockBlobClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.ByteArrayInputStream;

@Service
public class FileService {
    private final BlobServiceClient blobServiceClient;

    @Autowired
    public FileService(BlobServiceClient blobServiceClient) {
        this.blobServiceClient = blobServiceClient;
    }

    public String uploadFile(byte[] file, String containerName, String fileName) {
        String url = "";
        BlobContainerClient blobContainerClient = getBlobContainerClient(containerName);
        BlockBlobClient blockBlobClient = blobContainerClient.getBlobClient(fileName).getBlockBlobClient();
        // delete file if already exists in that container
        if (blockBlobClient.exists()) {
            blockBlobClient.delete();
        }

        // upload file to azure blob storage
        blockBlobClient.upload(new ByteArrayInputStream(file), file.length, true);
        url = blockBlobClient.getBlobUrl();
        return url;
    }

    public void deleteFile(String containerName, String fileName) {
        BlobContainerClient blobContainerClient = getBlobContainerClient(containerName);
        BlockBlobClient blockBlobClient = blobContainerClient.getBlobClient(fileName).getBlockBlobClient();
        if (blockBlobClient.exists()) {
            blockBlobClient.delete();
        }
    }

    private BlobContainerClient getBlobContainerClient(String containerName) {
        // create container if not exists
        BlobContainerClient blobContainerClient = blobServiceClient.getBlobContainerClient(containerName);
        if (!blobContainerClient.exists()) {
            blobContainerClient.create();
        }
        return blobContainerClient;
    }
}

