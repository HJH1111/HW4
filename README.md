# TODO앱 백엔드 서버 만들기
할 일 카드를 작성, 수정, 삭제, 조회하는 api를 만들어주세요.

## 필수 구현 기능
- [x]  할일카드 작성 기능
    - `할 일 제목`, `할일 내용`, `작성일`, `작성자 이름` 을 저장할 수 있습니다.
    - 저장된 할 일의 정보를 반환 받아 확인할 수 있습니다.
```kotlin
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
```
- [x]  선택한 할 일 조회 기능
    - 선택한 할 일의 정보를 조회할 수 있습니다.
    - 반환 받은 할 일 정보에는 `할 일 제목`,`할일 내용`, `작성일`, `작성자 이름`정보가 들어있습니다.
```kotlin
    override fun getTodoByID(todoId: Long): TodoResponse {
        val todo = todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("Todo", todoId)
        return todo!!.toResponse()
    } 
```
- [x]  할 일카드 목록 조회 기능
    - 등록된 할 일 전체를 조회할 수 있습니다.
    - 조회된 할 일 목록은 작성일 기준 내림차순으로 정렬 되어있습니다.
```kotlin
override fun getAllTodoList(): List<TodoResponse> {
        return todoRepository.findAll().map {it.toResponse()}
    }
```
- [x]  선택한 할 일 수정 기능
    - 선택한 할 일의 `할 일 제목`, `작성자명`, `작성 내용`을 수정할 수 있습니다.
    - 수정된 할 일의 정보를 반환 받아 확인할 수 있습니다.
```kotlin
@Transactional
override fun updateTodo(todoId: Long, request: UpdateTodoRequest): TodoResponse {
   val todo = todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("Todo", todoId)
   if (todo == null) throw Exception("Todo not found")

   todo.title = request.title
   todo.body = request.body
   todo.writerName = request.writerName
   return todoRepository.save(todo).toResponse()
} 
```
- [x]  선택한 할 일 삭제 기능
    - 선택한 게시글을 삭제할 수 있습니다.
```kotlin
@Transactional
override fun deleteTodo(todoId: Long) {
   val todo = todoRepository.findByIdOrNull(todoId)

   todoRepository.delete(todo!!)
} 
```

### ERD usecase 추가예정
### step 1 까지 완성

## 환경설정
#### Language : Kotlin
#### IDE : IntelliJ
#### JDK : 1.9.23
