# spring-cloud-stream3-bug
spring-cloud-stream3-bug

 Two options to make a Spring Cloud Stream 2 project work in Spring Cloud Stream 3 <br/>
1) add @SpringBootApplication(exclude = FunctionConfiguration.class) <br/>
2) add a Bean called output()