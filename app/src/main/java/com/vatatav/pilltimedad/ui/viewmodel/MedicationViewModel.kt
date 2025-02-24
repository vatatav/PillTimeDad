package com.vatatav.pilltimedad.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vatatav.pilltimedad.data.model.Medication
import com.vatatav.pilltimedad.data.model.MedicationHistory
import com.vatatav.pilltimedad.data.repository.MedicationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MedicationViewModel(
    private val repository: MedicationRepository
) : ViewModel() {

    private val _medications = MutableStateFlow<List<Medication>>(emptyList())
    val medications: StateFlow<List<Medication>> = _medications

    private val _medicationHistory = MutableStateFlow<List<MedicationHistory>>(emptyList())
    val medicationHistory: StateFlow<List<MedicationHistory>> = _medicationHistory

    init {
        loadMedications()
    }

    private fun loadMedications() {
        viewModelScope.launch {
            repository.getMedications().collect { medications ->
                _medications.value = medications
            }
        }
    }

    fun addMedication(medication: Medication) {
        viewModelScope.launch {
            repository.addMedication(medication)
            loadMedications()
        }
    }

    fun updateMedication(medication: Medication) {
        viewModelScope.launch {
            repository.updateMedication(medication)
            loadMedications()
        }
    }

    fun deleteMedication(medicationId: String) {
        viewModelScope.launch {
            repository.deleteMedication(medicationId)
            loadMedications()
        }
    }

    fun addMedicationHistory(history: MedicationHistory) {
        viewModelScope.launch {
            repository.addMedicationHistory(history)
            loadMedicationHistory(history.medicationId)
        }
    }

    fun loadMedicationHistory(medicationId: String) {
        viewModelScope.launch {
            repository.getMedicationHistory(medicationId).collect { history ->
                _medicationHistory.value = history
            }
        }
    }
} 