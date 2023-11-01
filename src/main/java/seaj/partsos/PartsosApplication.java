package seaj.partsos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import seaj.partsos.domain.Coating;
import seaj.partsos.domain.CoatingRepository;
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
	public CommandLineRunner partDemo(PartRepository partRepository, CoatingRepository coatingRepository,
			UserRepository userRepository) {
		return (args) -> {
			log.info("Create and save exaple coatings");
			Coating coating1 = new Coating("Gold", 2.5);
			Coating coating2 = new Coating("Silver", 2.5);
			Coating coating3 = new Coating("Nickel", 5.0);
			coatingRepository.save(coating1);
			coatingRepository.save(coating2);
			coatingRepository.save(coating3);

			log.info("Create and save example parts");
			Part part1 = new Part("A0001", "Cover", 0.55, "Copper", coating1);
			Part part2 = new Part("A0002", "Processor", 2.52, "Copper", coating1);
			Part part3 = new Part("A0003", "Cooler", 1.13, "Copper", coating2);
			Part part4 = new Part("A0004", "Bolt", 0.04, "Brass", coating3);
			partRepository.save(part1);
			partRepository.save(part2);
			partRepository.save(part3);
			partRepository.save(part4);

			log.info("Save a few users");
			User user1 = new User("user", "$2a$10$F.BY5Fk2rdPFS2p6vCdh9ON3NCU1yhBLsKBU4ExHgeigBVWkmpb5a", "USER");
			User user2 = new User("admin", "$2a$10$yV0noBYccpkKxxz0hgn7qelEflCSlCPnqWuN1eY8hpkctf3.f3cBS", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);

		};

	}

}
