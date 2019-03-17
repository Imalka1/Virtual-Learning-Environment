package lk.ijse.vle.controller;

import lk.ijse.vle.dto.*;
import lk.ijse.vle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/authenticate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO getLogin(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO.getUserID());
        System.out.println(userDTO.getUserName());
        return userService.getLogin(userDTO);
    }

    @PostMapping(value = "/forgotPassword", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public EmailDTO forgotPassword(@RequestBody EmailDTO emailDTO) {
        return userService.forgotPassword(emailDTO);
    }

    @GetMapping(value = "/file", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<InputStreamResource> downloadFile(@RequestParam(value = "path", required = false) String path) {
        return userService.downloadFile(path);
    }

    //    @Consumes("multipart/form-data")
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public int uploadFile(@RequestParam("file") MultipartFile[] files, @RequestParam("pathUrl") String pathUrl) {
        return userService.uploadFile(files, pathUrl);
    }
}
