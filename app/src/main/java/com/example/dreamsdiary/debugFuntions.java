package com.example.dreamsdiary;

import com.example.dreamsdiary.entities.Notes;

import java.util.List;

public class debugFuntions {

    public void fillNotes(DiaryDatabase db) {
        List<Notes> notes;
        int start = db.notesDao().getAll().size();
        for (int i = start; i < start + 10; i++) {
            Notes note = new Notes();
            note.title = "Жуки #" + i;
            note.body = "Множество жуков, тысячи! Они появляются неизвестно откуда, преследуют, цепляются за кожу, кусают. Идут за мной куда бы я ни пошел. Я решил найти их источник. Он начинался в моём доме. В итоге они выползали из маленького ящичка, когда я его открыл то увидел там руну (как в дизонорд, но с другими свойствами у другой формы, \"костяной амулет\" лучше бы подошло, но почему-то \"руна\"). Я вспомнил о её негативных эффектах, но всё же взял её (намереваясь выкинуть). Тут произошла НЕХ. Как-будто установилась связь между нами. Она давала вроде прям ощутимый прирост к удаче и подобному, но если бы что-то пошло не так в моей жизни начался пиздец. Решил положить её обратно, жуки вроде перестали появляться и я ушёл.";
            db.notesDao().insert(note);
        }
    }

    public void deleteAllNotes(DiaryDatabase db) {
        List<Notes> notes;
        notes = db.notesDao().getAll();
        for (Notes note : notes) {
            db.notesDao().delete(note);
        }
    }
}
