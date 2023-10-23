package seaj.partsos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import seaj.partsos.domain.Part;
import seaj.partsos.domain.PartRepository;
import seaj.partsos.domain.User;
import seaj.partsos.domain.UserRepository;

@SpringBootApplication
public class PartsosApplication {

	private static final Logger log = LoggerFactory.getLogger(PartsosApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PartsosApplication.class, args);
	}

	@Bean
	public CommandLineRunner partDemo(PartRepository partRepository, UserRepository userRepository) {
		return (args) -> {

			log.info("Create and save example parts");
			Part part1 = new Part("A0001", "Cover", 0.55, "Copper");
			partRepository.save(part1);

			log.info("Save a few users");
			User user1 = new User("user", "$2a$10$F.BY5Fk2rdPFS2p6vCdh9ON3NCU1yhBLsKBU4ExHgeigBVWkmpb5a", "USER");
			User user2 = new User("admin", "$2a$10$yV0noBYccpkKxxz0hgn7qelEflCSlCPnqWuN1eY8hpkctf3.f3cBS", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);

		};

	}

}
