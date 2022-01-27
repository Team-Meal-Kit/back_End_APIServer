package com.teammealkit.mealkit.cart.repository;

import com.teammealkit.mealkit.cart.domain.CartProduct;
import com.teammealkit.mealkit.cart.dto.CartListDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartProductRepository extends JpaRepository<CartProduct, Long> {

    CartProduct findByCartIdAndProductId(Long cartId, Long productsId);

    /* 커리문 뭔지 몰라서 해석 불가
    @Query("select new com.shop.dto.CartListDto(ci.id, i.itemName, i.price, ci.count, im.imgUrl) " +
            "from CartItem ci, ItemImg im " + // 테이블 불러오기
            "join ci.item i " + // 외래키 연결
            "where ci.cart.id = :cartId " + // 조건
            "and im.item.id = ci.item.id " +
            "and im.repimgYn = 'Y' " + // 조건에 맞으면 파라메터 불러오기
            "order by ci.regTime desc") // 정렬 -> regTime을 기준으로 내림차순
     */

    List<CartListDto> findCartListDto(Long cartId);

}
