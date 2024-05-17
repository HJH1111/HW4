package org.hw4.domain.Todo.service


import org.hw4.domain.Todo.dto.CreateTodoRequest
import org.hw4.domain.Todo.dto.TodoResponse
import org.hw4.domain.Todo.dto.UpdateTodoRequest
import jakarta.transaction.Transactional
import org.hw4.domain.Todo.exception.ModelNotFoundException
import org.hw4.domain.Todo.model.Todo
import org.hw4.domain.Todo.model.toResponse
import org.hw4.domain.Todo.repository.TodoRepository
import org.springframework.data.repository.findByIdOrNull

import org.springframework.stereotype.Service


@Service
class TodoServiceImpl (
    private val todoRepository: TodoRepository
): TodoService {
    override fun getAllTodoList(): List<TodoResponse> {
        return todoRepository.findAll().map {it.toResponse()}
    }

    override fun getTodoByID(todoId: Long): TodoResponse {
        val todo = todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("Todo", todoId)
        return todo!!.toResponse()

    }

    @Transactional
    override fun createTodo(request: CreateTodoRequest): TodoResponse {
        return todoRepository.save(
            Todo(
                title = request.title,
                body = request.body,
                date = request.date,
                writerName = request.writerName,
            )
        ).toResponse()
    }

    @Transactional
    override fun updateTodo(todoId: Long, request: UpdateTodoRequest): TodoResponse {
        val todo = todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("Todo", todoId)
        if (todo == null) throw Exception("Todo not found")

        todo.title = request.title
        todo.body = request.body
        todo.writerName = request.writerName
        return todoRepository.save(todo).toResponse()
    }

    @Transactional
    override fun deleteTodo(todoId: Long) {
        val todo = todoRepository.findByIdOrNull(todoId)

        todoRepository.delete(todo!!)
    }

}