Microservice application:

2 microservices: Customer + Equipment
1 microservice with openfeign that facilitate communication with the first microservices
1 microservice spring config server to centralize configuration
1 microservice with spring gateway
Spring cloud sleuth + zipkin for tracing
1 microservice notification for sms with twilio

Customer publish messages to rabbitMQ AQMP that will be consumed by notification microservice