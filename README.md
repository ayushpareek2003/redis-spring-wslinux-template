# redis-spring-wslinux-template

Run these commands in your WSL terminal to setup redis on windows

```bash
curl -fsSL https://packages.redis.io/gpg | sudo gpg --dearmor -o /usr/share/keyrings/redis-archive-keyring.gpg
```
```bash
echo "deb [signed-by=/usr/share/keyrings/redis-archive-keyring.gpg] https://packages.redis.io/deb $(lsb_release -cs) main" | sudo tee /etc/apt/sources.list.d/redis.list
```

```bash
sudo apt-get update
```

```bash
sudo apt-get install redis
```

```bash
sudo service redis-server start
```
```bash
redis-cli
```


Now paste this dependency in your pom.xml

```xml
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-redis</artifactId>
		</dependency>
```

add this in your yml file
```yml
spring:
      data:
  	redis:
          
           host: localhost
           port: 6379
           // password: only if using redis cloud
```


