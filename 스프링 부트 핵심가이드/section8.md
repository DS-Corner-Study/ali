# 8. Spring Data JPA 활용

### (1) JPQL

리포지토리는 JpaRepository를 상속받는 것만으로도 다양한 메서드가 제공되는데 기본 메서드들은 식별자 기반을 생성되기 때문에 결국 별도의 메서드를 정의해서 사용하는 경우가 많아 쿼리문을 작성해야 한다.

1) 쿼리 메서드 생성
   
   //(리턴 타입) + {주제 + 서술어(속성)} 구조의 메서드
   List<Person> findByLastnameAndEmail(String lastName, String email);

   서술어에 들어가는 엔티티의 속성 식은 엔터티에서 관리하고 있는 속성만 참조할 수 있다.
   
