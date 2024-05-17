package org.hw4.domain.Todo.service

import org.hw4.domain.Todo.dto.CreateTodoRequest
import org.hw4.domain.Todo.dto.TodoResponse
import org.hw4.domain.Todo.dto.UpdateTodoRequest


interface TodoService {

    fun getAllTodoList(): List<TodoResponse>

    fun getTodoByID(todoId: Long): TodoResponse

    fun createTodo(request: CreateTodoRequest): TodoResponse

    fun updateTodo(todoId: Long, request: UpdateTodoRequest): TodoResponse

    fun deleteTodo(todoId: Long)

}

