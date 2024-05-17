package org.hw4.domain.Todo.dto

data class TodoResponse(
    val id: Long,
    val title: String,
    val body: String,
    val date: String,
    val writerName: String,
)

