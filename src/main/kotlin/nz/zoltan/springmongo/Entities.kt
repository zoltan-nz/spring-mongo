package nz.zoltan.springmongo

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import java.sql.Timestamp
import java.util.*

@Document
class Product(
    @Id var id: ObjectId = ObjectId(),
    var name: String,
    var price: Float
)

@Document
class Transaction(
    @Id var id: ObjectId = ObjectId(),
    @DBRef var product: Product,
    var time: Date = Date(),
    var quantity: Int
)
