package com.teammealkit.mealkit.cart.repository;

import com.teammealkit.mealkit.cart.domain.CartProduct;
import com.teammealkit.mealkit.cart.dto.CartListDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartProductRepository extends JpaRepository<CartProduct, Long> {

    CartProduct findByCartIdAndProductId(Long cartId, Long productsId);


/*
    @Query("select new com.teammealkit.mealkit.cart.dto.CartListDto(ci.id, i.name, i.price, ci.count, im.imgUrl) " +
            "from CartProduct ci, ItemImg im " + // 테이블 불러오기
            "join ci.product i " + // 외래키 연결
            "where ci.cart.id = :cartId " + // 조건
            "and im.item.id = ci.product.id " +
            "and im.repimgYn = 'Y' " + // 조건에 맞으면 파라메터 불러오기
            "order by ci.regTime desc") // 정렬 -> regTime을 기준으로 내림차순
*/

    @Query("select new com.teammealkit.mealkit.cart.dto.CartListDto(cp.id, p.name, p.price, cp.count) " +
            "from CartProduct cp " + // 테이블 불러오기
            "join cp.product p " + // 외래키 연결
            "where cp.cart.id = :cartId " +// 조건에 맞으면 파라메터 불러오기
            "order by cp.createdDate desc") // 정렬 -> regTime을 기준으로 내림차순

    List<CartListDto> findCartListDto(Long cartId);

}
