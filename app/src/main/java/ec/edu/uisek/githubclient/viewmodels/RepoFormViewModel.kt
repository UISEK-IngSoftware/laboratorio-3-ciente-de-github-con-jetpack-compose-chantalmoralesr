package ec.edu.uisek.githubclient.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ec.edu.uisek.githubclient.models.RepositoryPayload
import ec.edu.uisek.githubclient.services.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RepoFormViewModel : ViewModel() {
    private val apiService = RetrofitClient.apiService

    private val _isLoading = MutableStateFlow(value = false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _errorMsg = MutableStateFlow<String?>(value = null)
    val errorMsg: StateFlow<String?> = _errorMsg.asStateFlow()

    private val _isSuccess = MutableStateFlow(false)
    val isSuccess: StateFlow<Boolean> = _isSuccess.asStateFlow()

    fun createRepo(name: String, description: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMsg.value = null
            try {
                val repository = RepositoryPayload(name, description)
                apiService.createRepository(repository)
                _isSuccess.value = true
            } catch (e: Exception) {
                _errorMsg.value = "Error al crear el repositorio: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun resetSuccess() {
        _isSuccess.value = false
    }

    // Actualizar un repositorio
    fun updateRepo(owner: String, repoName: String, newName: String, description: String?) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMsg.value = null
            try {
                val payload = RepositoryPayload(newName, description)
                apiService.updateRepository(owner, repoName, payload)
                _isSuccess.value = true
            } catch (e: Exception) {
                _errorMsg.value = "Error al actualizar el repositorio: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

}