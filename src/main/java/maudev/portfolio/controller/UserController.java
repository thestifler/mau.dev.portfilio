package maudev.portfolio.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import maudev.portfolio.entity.Contact;
import maudev.portfolio.entity.Project;
import maudev.portfolio.entity.ProjectPhoto;
import maudev.portfolio.entity.Skill;
import maudev.portfolio.entity.SkillDetail;
import maudev.portfolio.entity.User;
import maudev.portfolio.entity.WorkExperience;
import maudev.portfolio.service.ContactService;
import maudev.portfolio.service.ProjectPhotoService;
import maudev.portfolio.service.ProjectService;
import maudev.portfolio.service.SkillDetailService;
import maudev.portfolio.service.SkillService;
import maudev.portfolio.service.UserService;
import maudev.portfolio.service.WorkExperinceService;
import maudev.portfolio.util.ErrorMessage;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    @Autowired
    private ContactService contactService;
    @Autowired
    private WorkExperinceService workExperinceService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProjectPhotoService projectPhotoService;
    @Autowired
    private SkillService skillService;
    @Autowired
    private SkillDetailService skillDetailService;

    @GetMapping
    public ResponseEntity<List<User>> userList(){
      List<User> users = userService.findAll();
      if(users.isEmpty()){
          return ResponseEntity.noContent().build();
      }
      return ResponseEntity.ok(users);
      
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user ){
        User createUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUser);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(name = "id") Long id ,@RequestBody User user){
        user.setId(id);

        User userDB = userService.updateUser(user);

        if(null ==userDB){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userDB);


    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(name = "id") Long id){
        User userDB = userService.deleteUser(id);

        if (null == userDB) {
            return ResponseEntity.notFound().build();
        }


        return ResponseEntity.ok(userDB);
    }




    @RequestMapping(value = "/contacts" )
    public ResponseEntity<List<Contact>> contactList(){
        List<Contact> contacts = contactService.findAll();
        
        if (contacts.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contacts);
    }

    @PostMapping(value = "/contacts")
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact){

        Contact createContact = contactService.saveContact(contact);

        return ResponseEntity.status(HttpStatus.CREATED).body(createContact);
    }

    @PutMapping(value = "/contacts/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable(name = "id") Long id ,@RequestBody Contact contact){
        contact.setId(id);

        Contact contactUpdate =  contactService.updateContact(contact);

        if (contactUpdate == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(contactUpdate);

    }

    @GetMapping(value = "/work-experience")
    public ResponseEntity<List<WorkExperience>> workExperienceList(){
        List<WorkExperience> workExperiencesList = workExperinceService.findAll();
        if (workExperiencesList == null) {
            return null;
        }
        return ResponseEntity.ok(workExperiencesList);
    }

    @PostMapping(value = "/work-experience")
    public ResponseEntity<WorkExperience> createWorkExperience(@RequestBody WorkExperience workExperience){
        WorkExperience workExperienceDB = workExperinceService.saveWorkExperience(workExperience);
        return ResponseEntity.status(HttpStatus.CREATED).body(workExperienceDB);
    }

    @PutMapping(value = "/work-experience/{id}")
    public ResponseEntity<WorkExperience> updateWorkExperience(@PathVariable(name = "id") Long id , @RequestBody WorkExperience workExperience){
        workExperience.setId(id);

        WorkExperience workExperienceDB = workExperinceService.updateWorkExperience(workExperience);

        if (workExperienceDB ==  null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(workExperienceDB);
    }

    @DeleteMapping(value = "/work-experience/{id}")
    public ResponseEntity<WorkExperience> deleteWorkExperience(@PathVariable(name = "id") Long id){
        WorkExperience workExperienceDb = workExperinceService.deleteWorkExperience(id);

        if (workExperienceDb == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(workExperienceDb);
    }

    @PostMapping(value = "/project")
    public ResponseEntity<Project> createProject(@RequestBody Project project){
        Project projectDB = projectService.saveProject(project);

        return ResponseEntity.status(HttpStatus.CREATED).body(projectDB);
    }

    @GetMapping(value =  "/project")
    public ResponseEntity<List<Project>> projectList(){
        List<Project> projects = projectService.findAll();

        if (projects == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(projects);
    }

    @PutMapping(value = "/project/{id}")
    public ResponseEntity<Project>  updateProject(@PathVariable(value = "id") Long id , @RequestBody Project project){
        project.setId(id);

        Project projectDB = projectService.updateProject(project);

        if(projectDB == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(projectDB);
    } 

    @DeleteMapping(value = "/project/{id}")
    public ResponseEntity<Project> deleteProjct(@PathVariable(value = "id") Long id){

        Project project = projectService.deleteProject(id);

        if (project == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(project);
    }

    @PostMapping(value = "/project/photo")
    public ResponseEntity<ProjectPhoto> createProjectPhoto(@RequestBody ProjectPhoto projectPhoto){
        ProjectPhoto projectPhotoDB = projectPhotoService.saveProjectPhoto(projectPhoto);

        if (projectPhotoDB == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(projectPhotoDB);
    }

    @GetMapping(value = "/project/photo")
    public ResponseEntity<List<ProjectPhoto>> projectPhothoList(){
        List<ProjectPhoto> projectPhotos = projectPhotoService.findAll();

        if (projectPhotos == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(projectPhotos);
    }

    @DeleteMapping(value = "/project/photo/{id}")
    public ResponseEntity<ProjectPhoto> deleteProjectPhoto(@PathVariable(name = "id")Long id){

        ProjectPhoto project = projectPhotoService.deleteProjectPhoto(id);
        if (project == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(project);
    }

    @PutMapping(value = "/project/photo/{id}")
    public ResponseEntity<ProjectPhoto> updateProjectPhoto(@PathVariable(value = "id") Long id ,@RequestBody ProjectPhoto projectPhoto){
        projectPhoto.setId(id);

        ProjectPhoto projectPhotoDB = projectPhotoService.updaProjectPhoto(projectPhoto);

        if(projectPhotoDB == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(projectPhotoDB);
    }

    @PostMapping(value = "/skill")
    public ResponseEntity<Skill> createSkill(@RequestBody Skill skill){
        Skill skillDB = skillService.saveSkill(skill);

        if (skillDB == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(skillDB);
    }

    @GetMapping(value = "/skill")
    public ResponseEntity<List<Skill>> skillList(){
        List<Skill> skills = skillService.findAll();

        if (skills == null ){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(skills);
    }

    @PutMapping(value = "/skill/{id}")
    public ResponseEntity<Skill> updateSkill(@PathVariable(name = "id") Long id , @RequestBody Skill skill){

        skill.setId(id);
        Skill skillDB = skillService.updateSkill(skill);

        if (skillDB == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(skillDB);
    }

    @DeleteMapping(value = "/skill/{id}")
    public ResponseEntity<Skill> deleteSkill(@PathVariable(value = "id") Long id){
        Skill skill = skillService.deleteSkill(id);

        if (skill == null) {
            return ResponseEntity.notFound().build();
        }

       return  ResponseEntity.ok(skill);   
    }

    @PostMapping(value = "/skill/detail")
    public ResponseEntity<SkillDetail> createSkillDetail(@Valid @RequestBody SkillDetail skillDetail , BindingResult result ){

        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
    
        SkillDetail skillDetailDB = skillDetailService.saveSkillDetail(skillDetail);

        if (skillDetailDB == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(skillDetailDB);
    }


    private  String formatMessage(BindingResult bindingResult){
        List<Map<String,String>> errors =bindingResult.getFieldErrors().stream()
        .map(err ->{
            Map<String,String> error = new HashMap<>();
            error.put(err.getField(), err.getDefaultMessage());    
            return error;
        }).collect(Collectors.toList());

        ErrorMessage errorMessage = ErrorMessage.builder()
        .codeError("01")
        .messages(errors).build();

        ObjectMapper objectMapper = new ObjectMapper();
        String jsoString ="";

        try {
            jsoString = objectMapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return jsoString;


    }
}
