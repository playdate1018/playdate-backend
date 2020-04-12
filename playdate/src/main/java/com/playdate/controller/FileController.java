package com.playdate.controller;

import com.playdate.model.UserDetails;
import com.playdate.model.request.ImageBase64;
import com.playdate.repositories.UserRepository;
import com.playdate.service.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

@CrossOrigin
@RestController
@RequestMapping("/playdate")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    private  MongoOperations mongoOperations;

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/uploadFile/{email}")
    public boolean uploadimage(@RequestBody ImageBase64 imgObj, @PathVariable String email){
        Boolean save = false;
        try{
            UserDetails userDetails = userRepository.findByEmail(email);
            if(userDetails!=null){
                userDetails.setImageFileBinary(imgObj.getBase64Image());
                userRepository.save(userDetails);
                save=true;
            }
        }catch (Exception e){e.printStackTrace();}
        return save;
    }

//    @PostMapping("/uploadFile/{email}")
//    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file,
//                                         @PathVariable String email) {
//        FileInputStream binaryFile;
//        try{
//            UserDetails userDetails = userRepository.findByEmail(email);
//
//            byte[] imageBytes = file.getBytes();
//            String s = Base64.getEncoder().encodeToString(imageBytes);
//            userDetails.setImageFileBinary(s);
//            binaryFile = (FileInputStream) file.getInputStream();
////            mongoOperations.save(userDetails);
//            //TODO: throw an exception if the image is not saved
//            Response response = given().log().all()
//                    .contentType(ContentType.JSON)
//                    .body(userDetails, JACKSON_2)
//                    .when().post(RestEndpoints.BASE_URI + RestEndpoints.USER_DETAILS).thenReturn();
//
//        }catch(Exception e){e.printStackTrace();}
//
//        String fileName = fileStorageService.storeFile(file);
//
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/downloadFile/")
//                .path(fileName)
//                .toUriString();
//
//        return new UploadFileResponse(fileName, fileDownloadUri,
//                file.getContentType(), file.getSize());
//    }

//    @PostMapping("/uploadMultipleFiles")
//    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
//        return Arrays.asList(files)
//                .stream()
//                .map(file -> uploadFile(file))
//                .collect(Collectors.toList());
//    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }


    @GetMapping("/getImage/{email}")
    public String getImageOfUser(@PathVariable String email) throws Exception{

        //TODO: this is just a piece of code to convert base64 string to image file and save it locally. This can be removed.
        byte[] imageBArray = Base64.getDecoder().decode(userRepository.findByEmail(email).getImageFileBinary());
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/manoharadepu/DEV/fileuploads/testing.jpg");
        fileOutputStream.write(imageBArray);

        return userRepository.findByEmail(email).getImageFileBinary();
    }
}