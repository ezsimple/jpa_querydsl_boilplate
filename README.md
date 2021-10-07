## spring-data-jpa & queryDSL 학습을 위한 boilplate 
### 기술 스텍
  - springboot : 2.5.4
  - querydsl-jpa : 4.4.0
  - gradle : 6.9.1
  - H2 : 1.4.200 (2019-10-14)

```
jdbc-url : jdbc:h2:tcp://localhost:9092/../hsqldb/testdb
username : sa
password :
```
## 연관관계 테스트 
- @OneToOne
- @OneToMany (단방향)
- @OneToMany (양방향)
