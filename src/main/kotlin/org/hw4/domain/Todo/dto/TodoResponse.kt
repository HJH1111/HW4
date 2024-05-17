package org.hw4.domain.Todo.dto

import java.time.LocalDateTime

data class TodoResponse(
    val id: Long,
    val title: String,
    val body: String,
    val date: LocalDateTime,
    val writerName: String,
)

