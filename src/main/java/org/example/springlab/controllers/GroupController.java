package org.example.springlab.controllers;

import org.example.springlab.entities.Group;
import org.example.springlab.utils.pojos.CreateGroupPojo;
import org.example.springlab.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping
    public ResponseEntity<Long> saveGroup(@RequestBody CreateGroupPojo pojo) {
        return new ResponseEntity<>(groupService.saveGroup(pojo.getName()), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable("id") long id) {
        return new ResponseEntity<>(groupService.getGroupById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Group>> getGroups() {
        return new ResponseEntity<>(groupService.getGroups(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateGroup(@PathVariable("id") long id, @RequestBody String name) {
        groupService.updateGroup(id, name);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteGroupById(@PathVariable("id") long id) {
        groupService.deleteGroupById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity deleteGroups() {
        groupService.deleteGroups();
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
