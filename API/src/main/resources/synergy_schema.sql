CREATE TABLE IF NOT EXISTS `users` (
  `id` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `name` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL,
  `age` int NOT NULL,
  `img` varchar(40) DEFAULT NULL,
  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO users (id, password, name, email, age) values ("ssafy", "1234", "김싸피", "ssafy.kim@ssafy.com", 20);


CREATE TABLE IF NOT EXISTS `reviews` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `userid` varchar(40) NOT NULL,
  `videoid` varchar(40) NOT NULL,
  `title` varchar(40) NOT NULL,
  `content` TEXT NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO reviews (id, userid, videoid, title, content) values ("1", "ssafy", "1", "좋은 영상 감사합니다. (제목)", "좋은 영상 감사합니다. (내용)");


CREATE TABLE IF NOT EXISTS `videos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` varchar(40) NOT NULL,
  `content` TEXT NOT NULL,
  `fitpartname` varchar(40) NOT NULL,
  `youtubeurl` TEXT NOT NULL,
  `channelname` varchar(40) DEFAULT NULL,
  `viewcnt` INT NOT NULL DEFAULT 0,
  `like` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO videos (id, title, content, fitpartname, youtubeurl, channelname, viewcnt) values ('1', '하루 15분! 전신 칼로리 불태우는 다이어트 운동 (제목)', '하루 15분! 전신 칼로리 불태우는 다이어트 운동 (본문)', '전신', 'https://www.youtube.com/embed/swRNeYw1JkY', 'ThankyouBUBU', 0,0);