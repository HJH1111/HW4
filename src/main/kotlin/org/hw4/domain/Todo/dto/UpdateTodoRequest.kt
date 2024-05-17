package org.hw4.domain.Todo.dto

data class UpdateTodoRequest(
    val title: String,
    val body: String,
    val writerName: String
)