package org.hw4.domain.Todo.repository


import org.hw4.domain.Todo.model.Todo
import org.springframework.data.jpa.repository.JpaRepository



interface TodoRepository: JpaRepository<Todo, Long> {
}