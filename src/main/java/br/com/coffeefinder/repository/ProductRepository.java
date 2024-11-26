package br.com.coffeefinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.coffeefinder.entity.Product;

/** ProductRepository */
/*TODO: create a base product class and create another class to use this one as base
 * I wanna this because i need to cover other type of products not only coffee beans
 * */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
