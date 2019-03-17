package lk.ijse.vle.service;

import lk.ijse.vle.dto.EmailDTO;
import lk.ijse.vle.dto.UserDTO;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    UserDTO getLogin(UserDTO userDTO);

    EmailDTO forgotPassword(EmailDTO emailDTO);

    ResponseEntity<InputStreamResource> downloadFile(String path);

    int uploadFile(MultipartFile[] files, String pathUrl);

//    ImageDTO getImage(ImageDTO imageDTO);
}
