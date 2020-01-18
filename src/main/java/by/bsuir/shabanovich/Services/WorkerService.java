package by.bsuir.shabanovich.Services;

import by.bsuir.shabanovich.Entities.Role;
import by.bsuir.shabanovich.Entities.Worker;
import by.bsuir.shabanovich.Repositories.WaybillRepository;
import by.bsuir.shabanovich.Repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {

    @Autowired
    WorkerRepository workerRepository;

    private Worker findByLogin(String login) {
        return workerRepository.findByLogin(login);
    }

    public List<Worker> findAll() { return workerRepository.findAll(); }

    public Worker getCurrentUser(){
        try {
            org.springframework.security.core.userdetails.User authUser =
                    (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext()
                            .getAuthentication().getPrincipal();

            return findByLogin(authUser.getUsername());
        }catch (Exception e){ return null; }
    }

    public boolean isAdmin() {
        if(getCurrentUser() != null) {
            return getCurrentUser().getRoles().contains(Role.ADMIN);
        }
        return false;
    }

    public boolean isLogin() {
        return getCurrentUser() != null;
    }

    public void userRemove() {
        workerRepository.delete(getCurrentUser());
    }

    /*public void edit(String name, String surname) {
        Worker worker = getCurrentUser();
        worker.setName(name);
        worker.setSurname(surname);
        userRepository.save(user);
    }*/
}
