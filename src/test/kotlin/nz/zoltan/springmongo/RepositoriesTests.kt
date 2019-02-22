package nz.zoltan.springmongo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.mongodb.core.MongoTemplate
import reactor.core.publisher.Flux
import reactor.test.StepVerifier

@DataMongoTest
public class RepositoriesTests @Autowired constructor(
    val mongoTemplate: MongoTemplate,
    val productRepository: ProductRepository,
    val transactionRepository: TransactionRepository
) {

    @Test
    fun `Save and read a product`() {
        val book = Product(name = "A Book", price = 6.5f)
        productRepository.save(book).block()
        val productsFlux = productRepository.findAll().blockFirst()

        assertThat(productsFlux?.id).isEqualTo(book.id)
    }

    @Test
    fun `Save and read a transaction`() {
        val book = Product(name = "Second Book", price = 7.8f)
        val savedBook = productRepository.save(book).block()!!
        val transaction = Transaction(product = savedBook, quantity = 3)
        transactionRepository.save(transaction).block()
        val transactions = transactionRepository.findAll().blockFirst()

        assertThat(transactions?.id).isEqualTo(transaction.id)
    }
}
