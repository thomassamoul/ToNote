package com.thomas.tonote.feature_note.domain.use_case

import com.thomas.tonote.feature_note.domain.model.InvalidNoteException
import com.thomas.tonote.feature_note.domain.model.Note
import com.thomas.tonote.feature_note.domain.repository.NoteRepository

class AddNote(private val repository: NoteRepository) {


    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("The Title Of the note cant be empty")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("The Content Of the note cant be empty")
        }
        repository.insetNote(note)
    }
}