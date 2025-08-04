package Controller.AdminManagementController;

import Dao.Admin_Management.AdminDAO;
import Model.Admin_Management.Admin;
import java.util.List;


    public class AdminServiceImpl implements AdminService {
        private final AdminDAO dao;
        private final EventBus bus = EventBus.getInstance();
    //service non crea DAO, ma si affida ad una istanza esterna
        public AdminServiceImpl(AdminDAO dao) {
            this.dao = dao;
        }

        //@Override
        public List<Admin> findAll() {
            return dao.selectAllAdmin();
        }

        @Override
        public Admin findById(int id) {
            return dao.selectAdminById(id);
        }

        @Override
        public Admin create(Admin admin) {
            // eventualmente potrei aggiungere controlli qui
            boolean ok = dao.createAdmin(admin);
            if (!ok) throw new RuntimeException("Creazione Admin fallita");
            AdminEvent evt = new AdminEvent(SuperAdminEventType.CREATED, admin);
            bus.publish(evt);
            return admin;
        }

        @Override
        public Admin update(Admin admin) {
            boolean ok = dao.updateAdmin(admin);
            if (!ok) throw new RuntimeException("Update Admin fallito");
            bus.publish(new AdminEvent(SuperAdminEventType.UPDATED, admin));
            return admin;
        }

        @Override
        public void delete(int id) {
            Admin toDelete = dao.selectAdminById(id);
            boolean ok = dao.deleteAdmin(toDelete);
            if (!ok) throw new RuntimeException("Delete Admin fallito");
            bus.publish(new AdminEvent(SuperAdminEventType.DELETED, toDelete));
        }
    }


