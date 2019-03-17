package lk.ijse.vle.service.impl;

import lk.ijse.vle.dto.EmailDTO;
import lk.ijse.vle.dto.UserDTO;
import lk.ijse.vle.repository.AdminRepository;
import lk.ijse.vle.repository.StudentRepository;
import lk.ijse.vle.service.UserService;
import lk.ijse.vle.utilities.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

    private String folderPath;

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private AdminRepository adminRepository;

    public UserServiceImpl() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("settings.properties").getFile());
        Properties properties = new Properties();
        FileReader inputStream = null;
        try {
            inputStream = new FileReader(file);
            properties.load(inputStream);
            folderPath = properties.getProperty("path");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserDTO getLogin(UserDTO userDTO) {
        UserDTO user = new UserDTO();
        if (userDTO.getAccountType().equals("admin")) {
            List<Object[]> adminLogin = adminRepository.getLogin(userDTO.getUserID(), userDTO.getUserPassword());
            user = setUser(adminLogin, "admin");
        } else if (userDTO.getAccountType().equals("student")) {
            List<Object[]> studentLogin = studentRepository.getLogin(userDTO.getUserID(), userDTO.getUserPassword());
            user = setUser(studentLogin, "student");
        }

        return user;
    }

    private UserDTO setUser(List<Object[]> logins, String type) {
        UserDTO user = new UserDTO();
        if (logins != null) {
            for (Object[] login : logins) {
                if (!login[0].toString().equals("")) {
                    user.setAuthenticate(true);
                    user.setUserID(login[0].toString());
                    user.setUserName(login[1].toString());
                    user.setAccountType(type);
                    user.setProfileImage("images/" + login[2].toString() + "");
                } else {
                    user.setAuthenticate(false);
                }
            }
        } else {
            user.setAuthenticate(false);
        }
        return user;
    }

    @Override
    public EmailDTO forgotPassword(EmailDTO emailDTO) {
        return EmailService.getEmailService().emailForgotPassword(emailDTO);
    }

    @Override
    public ResponseEntity<InputStreamResource> downloadFile(String path) {
        File file = new File("" + folderPath + "" + path + "");
        InputStreamResource resource = null;
        try {
            resource = new InputStreamResource(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName()).contentType(MediaType.APPLICATION_OCTET_STREAM).contentLength(file.length()).body(resource);
    }

    @Override
    public int uploadFile(MultipartFile[] files, String pathUrl) {
        int reply = 0;
        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                reply = 1;
            }
            try {
                // Get the file and save it somewhere
                byte[] bytes = file.getBytes();
                Path path = Paths.get("" + folderPath + "" + pathUrl + "/" + file.getOriginalFilename());
                Files.write(path, bytes);

                reply = 2;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return reply;
    }


//    @Override
//    public ImageDTO getImage(ImageDTO image) {
//        File file = new File("E:/class/Angular Web/StudentManagementWithVLE/Backend/src/main/resources/data-files/" + image.getImagePath());
//        ImageDTO imageDTO = new ImageDTO();
//        try (FileInputStream imageInFile = new FileInputStream(file.getAbsolutePath())) {
//            byte imageData[] = new byte[(int) file.length()];
//            imageInFile.read(imageData);
//            String base64Image = Base64.getEncoder().encodeToString(imageData);
//            imageDTO.setImagePath(base64Image);
//        } catch (FileNotFoundException e) {
//            System.out.println("Image not found" + e);
//        } catch (IOException ioe) {
//            System.out.println("Exception while reading the Image " + ioe);
//        }
//        return imageDTO;
//    }
}
