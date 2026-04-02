package com.example.taskmanager.ui.home

 object MockDataProvider {

    fun getTasks(): List<Task> {
        val tasks = mutableListOf<Task>()
        tasks.add(Task("Do the dishes", 1, false))
        tasks.add(Task("Do the laundry", 2, false))
        tasks.add(Task("Pay the rent", 3, true))

        return tasks
    }
}
