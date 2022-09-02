package com.example.functions.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.example.functions.model.File;
import com.example.functions.model.UserFeedback;
import com.example.functions.repository.UserFeedbackRepository;
import com.example.functions.service.FileService;

import java.util.Optional;
import java.util.function.Function;

@Component
public class FileProcessor implements Function<File, Boolean> {

    @Autowired
    UserFeedbackRepository repository;
    @Autowired
    FileService fileService;

    @Value("${images.raw.container}")
	private String rawImages;

    @Value("${images.watermarked.container}")
	private String watermarkedImages;

    public Boolean apply(File file) {
        try{
            applyWatermark(file);

            String newFileUrl = fileService.uploadFile(file.getContent(), watermarkedImages, file.getFileName());

            Optional<UserFeedback> userFeedback = repository.findById(getIdFromImageName(file));
            if(userFeedback.isEmpty()){
                return false;
            }

            UserFeedback feedback = userFeedback.get();
            feedback.setUrl(newFileUrl);
            repository.save(feedback);
            fileService.deleteFile(rawImages, file.getFileName());

            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    private void applyWatermark(File file){
        // TODO : Balkis put your watermark code here
    }

    private String getIdFromImageName(File file){
        int index = file.getFileName().indexOf(".");
        return file.getFileName().substring(0 , index);
    }
}
