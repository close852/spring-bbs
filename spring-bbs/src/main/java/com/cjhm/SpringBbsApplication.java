package com.cjhm;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cjhm.bbs.domain.Board;
import com.cjhm.bbs.domain.User;
import com.cjhm.bbs.domain.enums.BoardType;
import com.cjhm.bbs.repository.BBSRepository;
import com.cjhm.bbs.repository.UserRepository;

@SpringBootApplication
public class SpringBbsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBbsApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(UserRepository userRepository, BBSRepository boardRepository) throws Exception {
		System.out.println("노실행? ");
		return (args) -> {
			User u = new User();
			u.setName("jiwoo"); 
			u.setPassword("test");
			u.setEmail("close852@naver.com");
			u.setCreateDate(LocalDateTime.now());
			u.setIdx(0L);
			User user = userRepository.save(u);
			IntStream.rangeClosed(1, 200).forEach(index ->{
				Board b = new Board();
				b.setTitle("게시글"+index);
				b.setSubTitle("순서"+index);
				b.setContent("컨텐츠");
				b.setBoardType(BoardType.free);
				b.setCreateDate(LocalDateTime.now());
				b.setUpdateDate(LocalDateTime.now());
				b.setUser(user);
				
				boardRepository.save(b);
			}
			);
		};
	}
}
