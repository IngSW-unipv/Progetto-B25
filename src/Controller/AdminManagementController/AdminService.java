package Controller.AdminManagementController;

import Model.Admin_Management.Admin;

public interface AdminService {
    //seppur si chiama non è un admin vero e proprio, bensì è un layer tra il dao e il controller
    // il service infatti invoca il dao e gestisce gli adminEvent
    // nasce per essere implementato e dare comandi specifici al Dao
    // successivamente l'admin manager gestirà tramite throws le vere e proprie chiamate a service con http o altro
    Admin findById(int id);
    Admin create(Admin admin);
    Admin update(Admin admin);
    void delete(int id);
}
