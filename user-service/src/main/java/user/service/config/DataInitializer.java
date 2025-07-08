/*
package user.service.config;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import user.service.entity.Client;
import user.service.entity.Role;
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
    public void initClient() {
        // Seed roles
        for (String roleName : new String[]{"super_admin", "admin", "user"}) {
            roleRepository.findById(roleName).orElseGet(() -> roleRepository.save(new Role(roleName)));
        }

        // Seed client
        if (clientRepository.count() == 0) {
            Client defaultClient = new Client();
            defaultClient.setName("Default Client");
            defaultClient.setContactEmail("client@example.com");
            clientRepository.save(defaultClient);
        }
    }

    @PostConstruct
    public void initUser() {
        // roles
        for (String roleName : new String[]{"super_admin", "admin", "user"}) {
            roleRepository.findById(roleName).orElseGet(() -> roleRepository.save(new Role(roleName)));
        }

        // default client
        Client client = clientRepository.findAll().stream().findFirst().orElse(null);
        if (client == null) {
            client = new Client();
            client.setName("Default Client");
            client.setContactEmail("client@example.com");
            client = clientRepository.save(client);
        }

        // super admin
        if (userRepository.findByEmail("super@admin.com").isEmpty()) {
            User superAdmin = new User();
            superAdmin.setEmail("super@admin.com");
            superAdmin.setPassword(passwordEncoder.encode("super123"));
            superAdmin.setAddress("HQ");
            superAdmin.setClient(client);
            superAdmin.setRole(roleRepository.findById("super_admin").orElseThrow());
            userRepository.save(superAdmin);
        }
    }

}

*/
