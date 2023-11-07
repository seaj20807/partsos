package seaj.partsos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import seaj.partsos.domain.Plating;
import seaj.partsos.domain.PlatingRepository;
import seaj.partsos.domain.Supplier;
import seaj.partsos.domain.SupplierRepository;
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
	public CommandLineRunner partDemo(PartRepository partRepository, PlatingRepository platingRepository,
			SupplierRepository supplierRepository,
			UserRepository userRepository) {
		return (args) -> {
			log.info("Create and save example platings");
			Plating plating1 = new Plating("Au", "Gold");
			Plating plating2 = new Plating("Ag", "Silver");
			Plating plating3 = new Plating("Ni", "Nickel");
			platingRepository.save(plating1);
			platingRepository.save(plating2);
			platingRepository.save(plating3);

			log.info("Create and save example suppliers");
			Supplier supplier1 = new Supplier("Computergeeks", "Silicon Valley 1 A", "+1 234 5678",
					"contact@computergeeks.com");
			Supplier supplier2 = new Supplier("Space Rangers", "Moon Drive 2 B", "+48 235 6798",
					"contracts@srangers.com");
			Supplier supplier3 = new Supplier("KultaSepot", "Sahaajantie 6 C", "+358 20 120 320",
					"seppo.kinnunen@kultasepot.fi");
			supplierRepository.save(supplier1);
			supplierRepository.save(supplier2);
			supplierRepository.save(supplier3);

			log.info("Create and save example parts");
			Part part1 = new Part("B0001", "Cover", 0.55, "Copper", supplier2);
			Part part2 = new Part("A0001", "Processor", 2.52, "Copper", supplier1);
			Part part3 = new Part("A0002", "Cooler", 1.13, "Copper", supplier1);
			Part part4 = new Part("C0001", "Bolt", 0.04, "Brass", supplier3);
			partRepository.save(part1);
			partRepository.save(part2);
			partRepository.save(part3);
			partRepository.save(part4);

			log.info("Save users");
			User user1 = new User("user", "$2a$10$F.BY5Fk2rdPFS2p6vCdh9ON3NCU1yhBLsKBU4ExHgeigBVWkmpb5a", "USER");
			User user2 = new User("admin", "$2a$10$yV0noBYccpkKxxz0hgn7qelEflCSlCPnqWuN1eY8hpkctf3.f3cBS", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);

		};

	}

}
