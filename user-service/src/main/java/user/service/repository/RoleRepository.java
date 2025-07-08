package user.service.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import user.service.entity.Role;

public interface RoleRepository extends JpaRepository<Role, String> {}
