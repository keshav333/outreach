package org.iiitb.controller;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.iiitb.bean.Student;
import org.iiitb.service.StudentService;
import org.iiitb.service.impl.StudentServiceImpl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;

@Path("/student")
public class StudentController {
    private StudentService studentService = new StudentServiceImpl();
    
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public String addStudent(@FormDataParam("firstName") String firstName,
                             @FormDataParam("middleName") String middleName,
                             @FormDataParam("lastName") String lastName,
                             @FormDataParam("emailId") String emailId,
                             @FormDataParam("domainId") Integer domainId,
                             @FormDataParam("photograph") InputStream photograph,
                             @FormDataParam("photograph") FormDataContentDisposition fileDetail) {
        
        Student student = new Student();
        student.setFirstName(firstName);
        student.setMiddleName(middleName);
        student.setLastName(lastName);
        student.setEmailId(emailId);
        
        studentService.save(student, photograph, fileDetail, domainId);
        return "Done";
    }
    
    
}
