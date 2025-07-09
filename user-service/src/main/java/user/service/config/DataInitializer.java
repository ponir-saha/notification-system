

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
    public void initClient() {

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
        // roles same as before...

        Client client = clientRepository.findAll().stream().findFirst().orElse(null);
        if (client == null) {
            client = new Client();
            client.setName("Default Client");
            client.setContactEmail("client@example.com");
            client = clientRepository.save(client);
        }

        Client finalClient = client;
        userRepository.findByEmail("super@admin.com").ifPresentOrElse(user -> {
            System.out.println("Super Admin already exists with password hash: " + user.getPassword());
            // optionally, check if password is encoded and update if necessary
        }, () -> {
            User superAdmin = new User();
            superAdmin.setEmail("super@admin.com");
            superAdmin.setPassword(passwordEncoder.encode("super123"));
            superAdmin.setAddress("HQ");
            superAdmin.setClient(finalClient);
            superAdmin.setRole(roleRepository.findById("super_admin").orElseThrow());
            userRepository.save(superAdmin);
        });
    }
}


