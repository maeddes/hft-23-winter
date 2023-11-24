# 2023-10-06 Cloud and Semester Introduction

### Intro questions:

* Which technologies or what do you have in mind in general if you think about "middleware" and "modern software architecture"?
* the "WHY" - Why would people use and implement a distributed systems architecture?

## Sketches

### Braindump

![Brainstorm topics](pics/Intro_Overview.png)

### Vertical Middleware

![Brainstorm topics](https://github.com/maeddes/hft-2021-winter/raw/main/images/middleware_sketch.png)

### Horizontal Middleware

![Brainstorm topics](https://github.com/maeddes/hft-2022-winter/blob/main/pics/middleware.png)

### Content

* Why distributed systems, why middleware, why modern software?
* What is Cloud Computing? Encounters in everyday life and history
* Characteristic, advantages & challenges
* Terminology - public, private, hybrid, dedicated
* Abstraction layers - IaaS, PaaS, FaaS, SaaS
* Overview - Hypervisors, virtual machines, containers and orchestration

### Objectives and exercises
_The student is able to describe the reasons for distributed systems and
cloud computing in own words and list examples for offerings, topologies and technologies. Includes ability to differentiate between different abstraction layers and knowledge how those layers and according technologies interact with each other. No exercises in this module_

### Student Questions

- Would an nginx serve as a vertical or horizontal middleware component?
- Is horizontal and vertical middleware same as horizontal and vertical scaling?

### Links

- https://github.com/features/codespaces
- https://www.gitpod.io/

# 2023-10-13 Container Intro

![Intro Container](pics/Container_Intro.png)

# 2023-10-20 Container Labs

### Questions

- Is a docker Container capable of installing things through apt-get?
- What happens with the data if you start and stop the Postgres container?

### Links

- https://github.com/wagoodman/dive
- https://docs.docker.com/engine/reference/builder/#cmd
- https://docs.docker.com/engine/reference/builder/#entrypoint
- https://github.com/docker/awesome-compose/

# 2023-10-27 Introduction to Spring Boot

![Spring Boot typical flow](https://raw.githubusercontent.com/maeddes/hft-2022-winter/main/pics/spring_boot_initializr_flow_2022_10_17.png)

* Background: Spring Framework - History & components
* Spring ← → Spring Boot
* Spring Initializr (start.spring.io) & starter dependencies
* Basic project structure (folders, configuration ..)
* "Hello, World!" example explained
* Using Actuator

### Objectives

The student is able to build and configure an own Spring Boot application from scratch with the IDE of choice. The exercise is to build an own "Hello, World!" application that exposes various - endpoints and is able to execute CRUD operations on the state of the application. Optional: Add logging and testing, configure Actuator.

### Exercises

Basic setup:

- Set up an own gitlab or github repository
- Either set up an own local Java IDE or use gitpod.io

Helpful Links:

- https://github.com/
- https://gitlab.com/
- https://gitpod.io/
- https://www.gitpod.io/docs/introduction/languages/java

Application:

- Build your own first Spring Boot Hello, World application at 
- https://start.spring.io
- Change name, Java version, build tool, dependencies. Observe changes
- Use the following deps: Web, Actuator, DevTools
- Annotate a class with @RestController and expose "some" Rest Mappings
- Experiment with other Mappings, e.g. @GetMapping, @PostMapping
- Pass a parameter via @PathVariable
- Put your application into a Docker container

Helpful Links:

- https://start.spring.io
- https://www.baeldung.com/spring-requestmapping
- https://www.baeldung.com/spring-boot-actuator-enable-endpoints

# 2023-11-03 Deeper Dive into REST

![REST, Controllers, Representations](pics/REST_stuff.png)

# 2023-11-10 Cloud-native Software development - Theory part

Theory lecture - Cloud-Native Software 

* CAP Theorem
* Conway's Law
* Fallacies of distributed computing
* Domain-Driven Design basics
* 12-factor application
* Evolution of applications and deployments: Monolithic -> Service-Oriented Architecture -> Microservices
* Introduction to serverless and FaaS terminology

### Objectives and exercises
_The student knows about the evolution of distributed systems (and middleware) and the drivers towards state-of-the-art implementation and deployment. She/he can explain the underlying concepts and theories and put it into practical context. No dedicated exercises for this module. Recap of basics: Spring Boot, Docker, configuration, persistence and messaging._

### Review questions

* "WHY" Cloud-Native Software? What IS Cloud-Native Software?
* Why "evolution" from a monolithic approach to a distributed approach?
* How does the CAP Theorem/Conway's Law relate to this?
* (NO Domain-Driven Design questions)
* How do the 12-factor application "methodology" relate to the technologies that we covered in this semester? (important)
* "WHY" is external configuration important in cloud-native software?
* Where did you see aspects of external configuration in the technologies we used? Provide examples
* What is the advantage of polyglot applications? Why in particular for cloud-native software? What kind of disadvantages do you see?



# 2023-11-17 Cloud-native recap / Intro to persistence

![CAP Theorem, State](pics/CAP_Theorem_State.png)

- State(full/less)ness