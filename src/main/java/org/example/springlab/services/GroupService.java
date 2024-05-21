package org.example.springlab.services;

import org.example.springlab.entities.Group;
import org.example.springlab.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public long saveGroup(String name) {
        return groupRepository.saveGroup(name);
    }

    public Group getGroupById(long id) {
        return groupRepository.getGroupById(id);
    }

    public List<Group> getGroups() {
        return groupRepository.getGroups();
    }

    public void updateGroup(long id, String name) {
        groupRepository.updateGroup(id, name);
    }

    public void deleteGroupById(long id) {
        groupRepository.deleteGroupById(id);
    }

    public void deleteGroups() {
        groupRepository.deleteGroups();
    }
}
