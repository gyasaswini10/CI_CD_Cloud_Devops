package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.model.Property;
import com.example.demo.model.PropertyManager;
import com.example.demo.repository.PropertiesRepository;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/jobs")
public class PropertyController {
    @Autowired
    PropertyManager JM;
    @Autowired
    private PropertiesRepository JR;

    // Change the endpoint to handle image uploads
    @PostMapping("/upload")
    public String uploadProperty(
            @RequestParam("nameOfOwner") String nameOfOwner,
            @RequestParam("contact") String contact,
            @RequestParam("state") String state,
            @RequestParam("location") String location,
            @RequestParam("propertyToBe") String propertyToBe,
            @RequestParam("cost") Double cost,
            @RequestParam("description") String description) {
//    	@RequestParam("image") MultipartFile image) {
        try {
//            long maxSize = 10 * 1024 * 1024;  // 10 MB
//            if (image.getSize() > maxSize) {
//                return "400::File size exceeds the maximum limit of 10 MB";
//            }
//            System.out.println("Image file size: " + image.getSize());
            Property property = new Property();
            property.setNameOfOwner(nameOfOwner);
            property.setContact(contact);
            property.setState(state);
            property.setLocation(location);
            property.setPropertyToBe(propertyToBe);
            property.setCost(cost);
            property.setDescription(description);
            return JM.createJob(property);
        } catch (Exception e) {
            return "500::" + e.getMessage();
        }
    }

    @PostMapping("/create")
    public String create(@RequestBody Property property) {
        return JM.createJob(property);
    }

    @GetMapping("/read")
    public String read() {
        return JM.readJobs();
    }
//    @GetMapping("/image/{id}")
//    public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) {
//        try {
//            Property property = JM.getPropertyById(id); // Fetch the property by ID
//            if (property != null ) {
//                HttpHeaders headers = new HttpHeaders();
//                headers.setContentType(MediaType.IMAGE_JPEG);  // Or use MediaType.IMAGE_PNG depending on the image format
//                return new ResponseEntity<>(headers, HttpStatus.OK);
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//            }
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }

    @GetMapping("/getdata/{id}")
    public String getData(@PathVariable("id") Long ID) {
        return JM.getData(ID);
    }
    

    @PutMapping("/update")
    public String update(@RequestBody Property property) {
        return JM.updateJob(property);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long ID) {
        return JM.deleteJob(ID);
    }
}
