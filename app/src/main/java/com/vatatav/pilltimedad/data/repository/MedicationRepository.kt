package com.vatatav.pilltimedad.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.vatatav.pilltimedad.data.model.Medication
import com.vatatav.pilltimedad.data.model.MedicationHistory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await

class MedicationRepository {
    private val firestore = FirebaseFirestore.getInstance()
    private val medicationsCollection = firestore.collection("medications")
    private val historyCollection = firestore.collection("medication_history")

    suspend fun getMedications(): Flow<List<Medication>> = flow {
        val snapshot = medicationsCollection.get().await()
        val medications = snapshot.toObjects(Medication::class.java)
        emit(medications)
    }

    suspend fun addMedication(medication: Medication) {
        medicationsCollection.document(medication.id).set(medication).await()
    }

    suspend fun updateMedication(medication: Medication) {
        medicationsCollection.document(medication.id).set(medication).await()
    }

    suspend fun deleteMedication(medicationId: String) {
        medicationsCollection.document(medicationId).delete().await()
    }

    suspend fun addMedicationHistory(history: MedicationHistory) {
        historyCollection.document(history.id).set(history).await()
    }

    suspend fun getMedicationHistory(medicationId: String): Flow<List<MedicationHistory>> = flow {
        val snapshot = historyCollection
            .whereEqualTo("medicationId", medicationId)
            .get()
            .await()
        val history = snapshot.toObjects(MedicationHistory::class.java)
        emit(history)
    }
} 