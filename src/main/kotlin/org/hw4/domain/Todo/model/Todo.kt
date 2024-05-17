package org.hw4.domain.Todo.model

import jakarta.persistence.*
import org.hw4.domain.Todo.dto.TodoResponse
import java.time.LocalDateTime

@Entity
@Table(name = "todo")
class Todo (
    @Column(name = "title")
    var title: String,

    @Column(name = "body")
    var body: String,

    @Column(name = "date")
    val date: LocalDateTime = LocalDateTime.now(),

    @Column(name = "writername")
    var writerName: String,
)
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}
fun Todo.toResponse(): TodoResponse = TodoResponse(
    id = id!!,
    title = title,
    body = body,
    date = date,
    writerName = writerName
)

//fun Todo.toResponse(): TodoResponse {
//    return TodoResponse(
//        id = id!!
//            ...
//    )
//}