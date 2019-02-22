package nz.zoltan.springmongo

import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface ProductRepository : ReactiveMongoRepository<Product, String>

interface TransactionRepository : ReactiveMongoRepository<Transaction, String>
