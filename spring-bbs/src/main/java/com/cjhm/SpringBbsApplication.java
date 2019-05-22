package com.cjhm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class SpringBbsApplication {

	@GetMapping({"","/"})
	public String index() {
		return "index";
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBbsApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner runner(UserRepository userRepository, BBSRepository bbsRepository,CategoryRepository categoryRepository,BoardRepository boardRepository,ArticleRepository articleRepository) throws Exception {
//		System.out.println("노실행? ");
//		return (args) -> {
//			User u = new User();
//			u.setName("jiwoo"); 
//			u.setPassword("test");
//			u.setEmail("close852@naver.com");
//			u.setCreateDate(LocalDateTime.now());
//			u.setIdx(0L);
//			User user = userRepository.save(u);
//			IntStream.rangeClosed(1, 200).forEach(index ->{
//				BBS b = new BBS();
//				b.setTitle("게시글"+index);
//				b.setSubTitle("순서"+index);
//				b.setContent("컨텐츠");
//				b.setBoardType(BoardType.free);
//				b.setCreateDate(LocalDateTime.now());
//				b.setUpdateDate(LocalDateTime.now());
//				b.setUser(user);
//				
//				bbsRepository.save(b);
//			}
//			);
//			
//			Category category = categoryRepository.save(
//									Category.builder()
//									.createId(user.getIdx())
//									.createDate(LocalDateTime.now())
//									.name("게시함")
//									.useYn("Y")
//									.build());
//			System.out.println("category :: "+category);
//			Board board = boardRepository.save(
//								Board.builder()
//									.categoryId(category.getCategoryId())
//									.createId(user.getIdx())
//									.createDate(LocalDateTime.now())
//									.depth(1)
//									.sortno(1)
//									.useYn("Y")
//									.upboardId("*")
//									.name("자유게시판")
//									.build());
//			System.out.println("자유게시판 : "+board);
//			for(int idx =1;idx<=35;idx++) {
//				Article article = articleRepository.save(
//						Article.builder()
//						.content("내용"+idx)
//						.title("제목"+idx)
//						.userId(user.getIdx())
//						.boardId(board.getBoardId())
//						.board(board)
//						.createId(user.getIdx())
//						.createDate(LocalDateTime.now())
//						.updateId(user.getIdx())
//						.updateDate(LocalDateTime.now())
//						.build());
//				System.out.println(article);
//			}
//			
//			board = boardRepository.save(
//					Board.builder()
//						.categoryId(category.getCategoryId())
//						.createId(user.getIdx())
//						.createDate(LocalDateTime.now())
//						.depth(1)
//						.sortno(1)
//						.useYn("Y")
//						.upboardId("*")
//						.name("상담게시판")
//						.build());
//			System.out.println("상담게시판 : "+board);		
//			
//			for(int idx =1;idx<=35;idx++) {
//				Article article = articleRepository.save(
//						Article.builder()
//						.content("내용"+idx)
//						.title("제목"+idx)
//						.userId(user.getIdx())
//						.boardId(board.getBoardId())
//						.board(board)
//						.createId(user.getIdx())
//						.createDate(LocalDateTime.now())
//						.updateId(user.getIdx())
//						.updateDate(LocalDateTime.now())
//						.build());
//				System.out.println(article);
//			}
//		};
//	}
}
