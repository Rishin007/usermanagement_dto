package edu.userdemo;

import edu.userdemo.entity.User;
import edu.userdemo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class TestApplication implements CommandLineRunner {
@Autowired
private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		List<User> lu=List.of(
				User.builder().name("Babua").email("bebo@gmail.com").build(),
				User.builder().name("Gamua").email("gamo@gmail.com").build(),
				User.builder().name("Jamua").email("jamo@gmail.com").build(),
				User.builder().name("Kudua").email("kudo@gmail.com").build(),
				User.builder().name("Larua").email("laro@gmail.com").build(),
				User.builder().name("Papua").email("papo@gmail.com").build(),
				User.builder().name("Mamua").email("mamo@gmail.com").build(),
				User.builder().name("Kakua").email("kako@gmail.com").build()
		);
		lu.forEach(u->System.out.println(u.getId()+" "+u.getName()+" "+u.getEmail()));
		userRepository.saveAll(lu);

		System.out.println("All Users Saved...........");
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
