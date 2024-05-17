package org.hw4.domain.Todo.dto

import java.time.LocalDateTime

data class CreateTodoRequest(
    val title: String,
    val body: String,
    val writerName: String,
)
