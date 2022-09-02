package com.example.functions;

import com.example.functions.model.File;
import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.BindingName;
import com.microsoft.azure.functions.annotation.BlobTrigger;
import com.microsoft.azure.functions.annotation.FunctionName;
import org.springframework.cloud.function.adapter.azure.FunctionInvoker;

public class FileHandler extends FunctionInvoker<File, Boolean> {
    @FunctionName("fileprocessor")
    public void run(
            @BlobTrigger(name = "file", dataType = "binary", path = "raw-images/{name}", connection = "AzureWebJobsStorage") byte[] content,
            @BindingName("name") String filename,
            final ExecutionContext context) {

        if (handleRequest(new File(filename, content), context)) {
            context.getLogger().info("Successfully watermarked file: " + filename);
        } else {
            context.getLogger().info("Failed to watermark file: " + filename);
        }
    }
}
