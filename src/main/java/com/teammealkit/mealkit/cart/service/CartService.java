package com.teammealkit.mealkit.cart.service;

import com.teammealkit.mealkit.cart.domain.Cart;
import com.teammealkit.mealkit.cart.domain.CartProduct;
import com.teammealkit.mealkit.cart.dto.CartListDto;
import com.teammealkit.mealkit.cart.dto.CartProductDto;
import com.teammealkit.mealkit.cart.repository.CartProductRepository;
import com.teammealkit.mealkit.cart.repository.CartRepository;
import com.teammealkit.mealkit.client.domain.Client;
import com.teammealkit.mealkit.client.repository.ClientRepository;
import com.teammealkit.mealkit.product.domain.Product;
import com.teammealkit.mealkit.product.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Lazy
public class CartService {

        private final CartRepository cartRepository;
        private final CartProductRepository cartProductsRepository;
        private final ClientRepository clientRepository;
        private final ProductRepository productRepository;

        //장바구니 담기

        public Long addCart(CartProductDto cartProductDto, Long clientId){
                Optional<Client> client = clientRepository.findById(clientId); // not-null 이라서 optional 필요
                Cart cart = cartRepository.findByClient_Idx(client.get().getIdx());

                //장바구니에 존재하지 않는다면 생성
                if(cart == null){
                        cart = Cart.createCart(client.get());
                        cartRepository.save(cart);
                }

                Product product = productRepository.findById(cartProductDto.getProductId()).orElseThrow(EntityNotFoundException::new);
                CartProduct cartProduct = cartProductsRepository.findByCartIdAndProductId(cart.getId(), product.getId());

                //해당 상품이 장바구니에 존재하지 않는다면 생성 후 추가
                if(cartProduct == null){
                        cartProduct = CartProduct.createCartItem(cart, product, cartProductDto.getCount());
                        cartProductsRepository.save(cartProduct);
                } else {
                        cartProduct.addCount(cartProductDto.getCount());
                }
                return cartProduct.getId();

        }

        // 장바구니 조회
        @Transactional(readOnly = true)
        public List<CartListDto> getCartList(Long clientId){

                List<CartListDto> cartListDtos = new ArrayList<>();

                Optional<Client> client = clientRepository.findById(clientId);
                Cart cart = cartRepository.findByClient_Idx(client.get().getIdx());

                if(cart==null){
                        return cartListDtos;
                }

                cartListDtos = cartProductsRepository.findCartListDto(cart.getId());

                return cartListDtos;
        }

        //현재 로그인한 사용자가 장바구니의 주인인지 확인
        @Transactional(readOnly = true)
        public  boolean validateCartProduct(Long cartProductId, Long clientId){

                Optional<Client> currentClient = clientRepository.findById(clientId);

                CartProduct cartProduct = cartProductsRepository.findById(cartProductId).orElseThrow(EntityNotFoundException::new);
                Client savedClient = cartProduct.getCart().getClient();

                if(Objects.equals(currentClient.get().getIdx(), savedClient.getIdx())){
                        return true;
                }
                return false;
        }

        //장바구니 상품 수량 변경
        public void updateCartProductCount(Long cartProductId, int count){
                CartProduct cartProduct = cartProductsRepository.findById(cartProductId).orElseThrow(EntityNotFoundException::new);
                cartProduct.updateCount(count);
        }

        //장바구니 상품 삭제
        public void deleteCartProduct(Long cartProductId){
                CartProduct cartProduct = cartProductsRepository.findById(cartProductId).orElseThrow(EntityNotFoundException::new);
                cartProductsRepository.delete(cartProduct);
        }


}