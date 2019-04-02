package com.cjhm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBbsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBbsApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner runner(UserRepository userRepository, BoardRepository boardRepository) throws Exception {
//		System.out.println("노실행?");
//		return (args) -> {
//			User u = new User();
//			u.setName("havi");
//			u.setPassword("test");
//			u.setEmail("havi@gmail.com");
//			u.setCreateDate(LocalDateTime.now());
//			
//			User user = userRepository.save(u);
//			IntStream.rangeClosed(1, 200).forEach(index ->{
//				Board b = new Board();
//				b.setTitle("게시글"+index);
//				b.setSubTitle("순서"+index);
//				b.setContent("컨텐츠");
//				b.setBoardType(BoardType.free);
//				b.setCreateDate(LocalDateTime.now());
//				b.setUpdateDate(LocalDateTime.now());
//				b.setUser(user);
//				
//				boardRepository.save(b);
//			}
//			);
//		};
//	}
}
