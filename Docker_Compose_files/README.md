
 docker compose down   
 docker system prune                 


docker compose up -d --build




applications/properties
spring.application.name=demo
#spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
#spring.jpa.hibernate.ddl-auto=update
#server.port=8083
spring.mail.host=smtp.gmail.com
#spring.mail.port=587
#spring.datasource.url=${SPRING_DATASOURCE_URL}
#spring.datasource.username=${SPRING_DATASOURCE_USERNAME}
#spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}
spring.mail.username=gyasu1110@gmail.com
spring.mail.password=mdwr czwu xgee ghah
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
# application.properties or application.yml
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB



server.port=8083

# ============================
# Database (Local MySQL) 
# ============================
spring.datasource.url=jdbc:mysql://localhost:3306/prop
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
