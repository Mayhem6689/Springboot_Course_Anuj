package com.codingshuttle.youtube.LearningRESTAPIs.DTO;

import lombok.Data;

@Data
public class StudentDTO {
    /*  Generally DTO Contains properties and methods of objects which are to be shared
    from presentation layer (controller) to service layer (entity and repository) (can also be done in the entity layer or folder
    getters and setters, hashcode etc are generally set here to edit the properties of the Data Transfer Object(DTO) which is currently in use
    LOMBOK can be used to automate this using the @Data annotation (which automatically creates getters and setters for the code)
     */
    private long id; //we need to use getters and setters because we are creating private variables
    private String name;
    private String email;


}