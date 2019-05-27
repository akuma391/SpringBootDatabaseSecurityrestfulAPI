# SpringBootDatabaseSecurityrestfulAPI
RESTful API using Spring Security, mysql database, JPA, Spring Actuator and Devtools. We are using BCrypt password encoder to encode passwords for admin and user


getTopicById     (can be accessed by both user and admin)

http://localhost:8080/user/topic/{id}

http://localhost:8080/user/topic/1


----------------------------------------------------------------------------

getAllTopics     (can be accessed by both user and admin)

http://localhost:8080/user/topics


-----------------------------------------------------------------------------

addTopic        (can be accessed only by admin)

http://localhost:8080/user/topic

{"title":"Restful web services","category":"Java"}


-----------------------------------------------------------------------------

updateTopic      (can be accessed by both user and admin)

http://localhost:8080/user/topic

{"topicId":4,"title":"Restful web services","category":"Java webService"}


-----------------------------------------------------------------------------

deleteTopic      (can be accessed by both user and admin)

http://localhost:8080/user/topic/{id}

http://localhost:8080/user/topic/1
