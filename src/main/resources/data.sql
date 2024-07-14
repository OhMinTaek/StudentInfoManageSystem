-- 더미데이터입니다 복붙하시고 파일 삭제하셔도 됩니다.
-- 더미데이터입니다 복붙하시고 파일 삭제하셔도 됩니다.
-- 더미데이터입니다 복붙하시고 파일 삭제하셔도 됩니다.

-- Student 테이블에 데이터 삽입
INSERT INTO Student (name, dong, school, major) VALUES ('김철수', '강남구', '서울대학교', '컴퓨터공학');
INSERT INTO Student (name, dong, school, major) VALUES ('박영희', '서초구', '고려대학교', '경영학');
INSERT INTO Student (name, dong, school, major) VALUES ('이민수', '송파구', '연세대학교', '의학');
INSERT INTO Student (name, dong, school, major) VALUES ('최은영', '강동구', '한양대학교', '화학공학');
INSERT INTO Student (name, dong, school, major) VALUES ('홍길동', '마포구', '성균관대학교', '물리학');

-- StudentName 테이블에 데이터 삽입
-- Student 테이블에 삽입된 데이터를 기반으로 ID를 설정합니다.
INSERT INTO StudentName (id, name) VALUES (1, '김철수');
INSERT INTO StudentName (id, name) VALUES (2, '박영희');
INSERT INTO StudentName (id, name) VALUES (3, '이민수');
INSERT INTO StudentName (id, name) VALUES (4, '최은영');
INSERT INTO StudentName (id, name) VALUES (5, '홍길동');
