package com.example.viikkotehtava4.viewmodel

import androidx.lifecycle.ViewModel
import com.example.viikkotehtava4.model.Task
import com.example.viikkotehtava4.model.mockTask
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class TaskViewModel : ViewModel() {

    private val _tasks = MutableStateFlow<List<Task>>(mockTask)
    val tasks: StateFlow<List<Task>> = _tasks.asStateFlow()

    private val _isDarkMode = MutableStateFlow(false)
    val isDarkMode: StateFlow<Boolean> = _isDarkMode.asStateFlow()

    fun setDarkMode(enabled: Boolean) {
        _isDarkMode.value = enabled
    }

    fun addTask(task: Task) {
        _tasks.value = _tasks.value + task
    }

    fun removeTask(id: Int) {
        _tasks.value = _tasks.value.filter { it.id != id }
    }

    fun toggleDone(id: Int) {
        _tasks.value = _tasks.value.map {
            if (it.id == id) it.copy(done = !it.done) else it
        }
    }

    fun updateTask(updated: Task) {
        _tasks.value = _tasks.value.map {
            if (it.id == updated.id) updated else it
        }
    }
}