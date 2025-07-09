

package user.service.config;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import user.service.entity.Client;
import user.service.entity.User;
import user.service.repository.ClientRepository;
import user.service.repository.RoleRepository;
import user.service.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final RoleRepository roleRepository;
    private final ClientRepository clientRepository;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initData() {
        Client client = clientRepository.findAll().stream().findFirst().orElseGet(() -> {
            Client newClient = new Client();
            newClient.setName("Default Client");
            newClient.setContactEmail("client@example.com");
            return clientRepository.save(newClient);
        });

        userRepository.findByEmail("super@admin.com").ifPresentOrElse(user -> {
        }, () -> {
            User superAdmin = new User();
            superAdmin.setEmail("super@admin.com");
            superAdmin.setPassword(passwordEncoder.encode("super123"));
            superAdmin.setAddress("HQ");
            superAdmin.setClient(client);
            superAdmin.setRole(roleRepository.findById("super_admin").orElseThrow());
            userRepository.save(superAdmin);
        });
    }
}


