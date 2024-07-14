-- 더미데이터입니다 복붙하시고 파일 삭제하셔도 됩니다.
-- 더미데이터입니다 복붙하시고 파일 삭제하셔도 됩니다.
-- 더미데이터입니다 복붙하시고 파일 삭제하셔도 됩니다.

-- Student 테이블 생성
CREATE TABLE IF NOT EXISTS Student (
                                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       name VARCHAR(255) NOT NULL,
    dong VARCHAR(255) NOT NULL,
    school VARCHAR(255) NOT NULL,
    major VARCHAR(255) NOT NULL
    );

-- StudentName 테이블 생성
CREATE TABLE IF NOT EXISTS StudentName (
                                           id BIGINT PRIMARY KEY,
                                           name VARCHAR(255) NOT NULL
    );