INSERT INTO article(id, title, content) VALUES (1, '가가가가', '1111');
INSERT INTO article(id, title, content) VALUES (2, '나나나나', '2222');
INSERT INTO article(id, title, content) VALUES (3, '다다다다', '3333');

-- article 더미 데이터

INSERT INTO article(id, title, content) VALUES (4, '당신의 인생 영화는?', '댓글 ㄱ');
INSERT INTO article(id, title, content) VALUES (5, '당신의 소울 푸드는?', '댓글 ㄱㄱ');
INSERT INTO article(id, title, content) VALUES (6, '당신의 취미는?', '댓글 ㄱㄱㄱ');

-- comment 더미 데이터
--- 5번 게시글 댓글들

INSERT INTO comment(id, article_id, nickname, body) VALUES (1, 4, 'Park', '굿 윌 헌팅');
INSERT INTO comment(id, article_id, nickname, body) VALUES (2, 4, 'Kim', '아이 엠 샘');
INSERT INTO comment(id, article_id, nickname, body) VALUES (3, 4, 'Choi', '쇼생크의 탈출');

--- 6번 게시글 댓글들

INSERT INTO comment(id, article_id, nickname, body) VALUES (4, 5, 'Park', '치킨');
INSERT INTO comment(id, article_id, nickname, body) VALUES (5, 5, 'Kim', '샤브샤브');
INSERT INTO comment(id, article_id, nickname, body) VALUES (6, 5, 'Choi', '쇼생크의 탈출');

--- 7번 게시글 댓글들

INSERT INTO comment(id, article_id, nickname, body) VALUES (7, 4, 'Park', '조경');
INSERT INTO comment(id, article_id, nickname, body) VALUES (8, 4, 'Kim', '유튜브');
INSERT INTO comment(id, article_id, nickname, body) VALUES (9, 4, 'Choi', '독서');