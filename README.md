# API Server

# Mysql Docker Setting
```
// 이미지 pull
docker pull mysql

// 이미지 확인
docker images

// 컨테이너 실행
docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=1234 -d -p 3306:3306 mysql:latest

// 컨테이너 목록 조회
docker ps -a


// 컨테이너 접속
docker exec -it mysql-container bash

// mysql 
mysql -u root -p

// create database
CREATE DATABASE dockerMySql;

// Sample Table 생성 & Test
USE dockerMySql;

CREATE TABLE TEST_USER (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name varchar(55) NOT NULL
);

INSERT INTO TEST_USER (name) VALUES ('Nine');
```


# Api-server
```

```
