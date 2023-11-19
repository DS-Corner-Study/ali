package com.springboot.advanced_jpa.data.repository;

import com.springboot.advanced_jpa.data.entity.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //find...By
    Optional<Product> findByNumber(Long number);
    List<Product> findAllByName(String name);
    Product queryNumber(Long number);

    //exist...By
    boolean existsByNumber(Long number);

    //count...By
    long countByName(String name);

    //delete...By
    void deleteByNumber(Long number);
    long removeByName(String name);

    //...First<number>..., ...Top<number>...
    List<Product> findFirst5ByName(String name);
    List<Product> findTop10ByName(String name);


    //findByNumber 메서드와 동일하게 동작
    Product findByNumberIs(Long number);
    Product findByNumberEquals(Long number);

    //not 키워드
    Product findByNumberIsNot(Long number);
    Product findByNumberNot(Long Number);

    //(Is)Null, (Is)NotNull
    List<Product> findByUpdatedAtNull();
    List<Product> findByUpdatedAtIsNull();
    List<Product> findByUpdatedAtNotNull();
    List<Product> findByUpdatedAtIsNotNull();

    //True, False를 사용한 쿼리 메서드
    Product findByisActiveTrue();
    Product findByisActiveIsTrue();
    Product findByisActiveFalse();
    Product findByisActiveIsFalse();

    //And, Or키워드를 이용한 쿼리 메서드
    Product findByNumberAndName(Long number, String name);
    Product findByNumberOrName(Long number, String name);

    //Greater than, Less then, Between
    List<Product> findByPriceIsGreaterThan(Long price);
    List<Product> findByPriceGreaterThan(Long price);
    List<Product> findByPriceGreaterThanEqual(Long price);
    List<Product> findByPriceIsLessThan(Long price);
    List<Product> findByPriceLessThan(Long price);
    List<Product> findByPriceLessThanEqual(Long price);
    List<Product> findByPriceIsBetween(Long lowPrice, Long highPrice);
    List<Product> findByPriceIBetween(Long lowPrice, Long highPrice);

    //부분 일치 키워드를 사용한 쿼리 메서드
    List<Product> findByNameLike(String name);
    List<Product> findByNameIsLike(String name);

    List<Product> findByNameContains(String name);
    List<Product> findByNameContaining(String name);
    List<Product> findByNameIsContaining(String name);

    List<Product> findByNameStartsWith(String name);
    List<Product> findByNameStartingWith(String name);
    List<Product> findByNameIsStartingWith(String name);

    List<Product> findByNameEndsWith(String name);
    List<Product> findByNameEndingWith(String name);
    List<Product> findByNameIsEndingWith(String name);

    //쿼리 메서드 정렬 처리
    List<Product> findByNameOrderByNumberAsc(String name);
    List<Product> findByNameOrderByNumberDesc(String name);

    //쿼리 메서드에서 여러 정렬 기준 사용
    List<Product> findByNameOrderByPriceAscStockDesc(String name);

    //매개변수를 활용한 쿼리 정렬
    List<Product> findByName(String name, Sort sort);

}
