# 1. 스프링 부트란?
#### 1. 제어 역전

  - 자바: 사용하려는 객체의 의존성을 생성한 후 객체에서 제공하는 기능을 사용

  - 스프링: 객체를 직접 생성하지 않고 객체의 관리를 컨테이너에 맡김(제어권을 줌: 제어 역전)
  
  따라서 의존성 주입, 관점 지향 프로그래밍 가능
  
#### 2. 의존성 주입
  - 이용할 객체를 직접 생성하지 않고 외부 컨테이너가 생성한 객체를 주입받아 사용하는 방식
  
    <의존성을 주입받는 방법>
    
    - 생성자를 통한 의존성 주입
      ````
      @RestController
      public class DIOController{
      
          MyService myService;
          @Autowired
          public DIOController(MyService myService){
              this.myService.gethello();
        }
      }
      ````
    
    - 필드 객체 선언을 통한 의존성 주입

      ````
      @RestController
      public class FieldInjectionController{
        
          @Autowired
          private MyService myService;
      }
      ````
    
    - setter 매서드를 통한 의존성 주입
       ````
      @RestController
      public class SetterInjectionController{
        
          @Autowired
          public void setMyService(MyService myService){
              this.myService = myService;
      }
      ````

    @Autowired라는 어노테이션을 통해 의존성 주입 가능(위 세 곳에 각각 붙이기 가능)

#### 3. 관점지향 프로그래밍(AOP)
  - 관점을 기준으로 묶어 개발하는 방식(핵심기능, 부가기능)

    <AOP 구현 방법>
    - 컴파일 과정에서 삽입하는 방식
      
    - 바이트코드를 메모리에 로드하는 과정에서 삽입하는 방식
      
    - 프라시 패턴을 이용한 방식

    <목적>
    - 모듈화를 통한 재사용 가능한 구성을 만드는 것
   
    - 모듈화된 객체를 편하게 적용
      
***
# 2. 스프링 부트 특징
  1. 의존성 관리

    'spring-boot-starter'라는 의존성을 제공(라이브러리 호환성 문제까지 해결)
    
  2. 자동설정

    애플리케이션에 추가된 라이브러리 실행하는 데 필요한 환경 설정을 알아서 찾아줌

    > 애플리케이션을 개발하는 데 필요한 의존성을 추가하면 프레임워트가 이를 자동으로 관리해줌

        @SpringBootApplication(@SpringBootConfiguration, @EnableAutoConfiguration, @ComponentScan을 합쳐놓은 구성)

        -> 스프링 부트 애플리케이션이 실행되면 
        
          1. @ComponentScan이 @Component이 붙은 클래스를 발견해 빈에 등록
          
          2. @EnableAutoConfiguration이 spring-boot-autoconfigure 패키지 안에 spring.factories 파일을 추가해 다양한 자동 설정이 적용됨

          <@Component 시리즈 어노테이션의 대표적인 예>

          - @Controller

          - @RestController

          - @Service

          - @Repository

          - @Configuration

  3. 내장 AWS 존재

  4. 모니터링

     서비스 운영 시기에 해당 시스템이 사용하는 스레드, 메모리, 세션 등의 주요 요소들을 모니터링 해야함(스프링 부트 액추에이터 이용)
