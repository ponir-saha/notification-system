package user.service.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import user.service.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {}
