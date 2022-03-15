CREATE TABLE `product` (
  `pno` bigint NOT NULL AUTO_INCREMENT,
  `pname` varchar(100) NOT NULL,
  `price` int NOT NULL,
  `made_by` varchar(100) NOT NULL,
  `reg_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `writer` varchar(100) DEFAULT "removed user",
  `category` varchar(100) DEFAULT NULL,
  `description` text,
  `mod_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `read_count` int DEFAULT '0',
  `image_file` text,
  PRIMARY KEY (`pno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `member` (
  `email` varchar(100) NOT NULL,
  `pwd` varchar(100) NOT NULL,
  `nick_name` varchar(100) NOT NULL,
  `reg_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `last_login` datetime DEFAULT NULL,
  `grade` tinyint DEFAULT '10',
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `comment` (
  `cno` bigint NOT NULL AUTO_INCREMENT,
  `pno` bigint DEFAULT -1,
  `writer` varchar(100) DEFAULT "removed user",
  `content` varchar(1000) NOT NULL,
  `reg_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `mod_at` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`cno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 개발전에 pk - fk 관계를 설정하면 개발할 때 수정 및 삭제에 제한이 있으므로 
-- 개발이 완료된 후 테스트를 거쳐 수정 및 삭제 기능에 이상이 없을 경우
-- 관계설정을 추가 한 후 다시 테스트를 하는게 효율적이다.

alter table product add constraint fk_product_writer
foreign key (writer) references member(email)
on update cascade
on delete no action;

-- 일반적으로 update에는 cascade, delete에는 set null 또는 no action이 자주 쓰인다.
-- 여기서 delete가 no action이면 default조건을 따라간다.
-- cascade면 해당 회원이 쓴 댓글이 모두 날아간다고 보면 된다.
-- delete에 set null을 하고 해당 컬럼의 not null조건을 풀어도 되지만 default -1로 놔두는 것도 방법이다.
-- 일반적인 게시판과 달리 회원이 탈퇴해도 기록이 지워지지 않아야 되는 경우에는 새 컬럼을 만들어서 1,0,-1 등으로 회원의 가입상황을 표시하는 방식도 있다.

alter table comment add constraint fk_commnet_writer
foreign key (writer) references member(writer)
on update cascade
on delete no action;

alter table comment add constraint fk_commnet_pno
foreign key (pno) references product(pno)
on update cascade
on delete no action;

