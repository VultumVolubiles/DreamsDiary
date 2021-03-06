package com.example.dreamsdiary;

import com.example.dreamsdiary.entities.Notes;

import java.util.List;

public class debugFuntions {

    DiaryDatabase db = App.getInstance().getDatabase();

    public void fillNotes(DiaryDatabase db) {
        List<Notes> notes;
        int start = db.notesDao().getAll().size();
        for (int i = start; i < start + 10; i++) {
            Notes note = new Notes();
            note.title = "Вычислитель №" + (i+1);
            note.body = "Круг (или колесо) подаёт прямоугольные пластины, крутясь против часовой стрелки. Каждая пластина это совокупность разных вариантов. Сам механизм ищет правильную комбинацию вариантов, которая должна будет починить/восстановить другой комплекс механизмов. Механизм будто пытается найти способ вылечить меня (о цели механизма знаю из ощущений, он как-будто пониманием сам всё рассказал. Теперь про окружение: кругом темнота, но механизм стоит на твёрдой поверхности (знаю из своих ощущений), за плоскостью или кругом есть источник зелёного цвета, такой как на фото сделанном ирл этой ночью перед сном, но тут свет как-бы выглядывает из под плоскости освещая контуры всего механизма. Назову его пока что Вычислитель. Мне его почему-то жалко. Надо бы его навестить, или даже проапгрейдить. Теперь о его действии: Если пластинка с вариантами неудачная, но из сна выкидывает. Если пластинка неплохая (т.е. значительная часть вариантов подошла), то не выкинет. Продержался максимум 2-3 пластинки. Выкидывало 3-4 раза, но я возвращался. Когда выкидывало просыпался с приступом кашля длительностью 30-60 секунд. [Ирл: выкинуло уже в который раз, перелёг на противоположную сторону на кровати, больше не выкидывало и Вычислитель не встречал.]";
//            note.title = "Жуки #" + i;
//            note.body = "Множество жуков, тысячи! Они появляются неизвестно откуда, преследуют, цепляются за кожу, кусают. Идут за мной куда бы я ни пошел. Я решил найти их источник. Он начинался в моём доме. В итоге они выползали из маленького ящичка, когда я его открыл то увидел там руну (как в дизонорд, но с другими свойствами у другой формы, \"костяной амулет\" лучше бы подошло, но почему-то \"руна\"). Я вспомнил о её негативных эффектах, но всё же взял её (намереваясь выкинуть). Тут произошла НЕХ. Как-будто установилась связь между нами. Она давала вроде прям ощутимый прирост к удаче и подобному, но если бы что-то пошло не так в моей жизни начался пиздец. Решил положить её обратно, жуки вроде перестали появляться и я ушёл.";
            db.notesDao().insert(note);
        }
    }

    public void addFavoriteNote(DiaryDatabase db) {
        Notes note;
        note = new Notes();
        note.favorite = 1;
        note.title = "Вычислитель F";
        note.body = "Круг (или колесо) подаёт прямоугольные пластины, крутясь против часовой стрелки. Каждая пластина это совокупность разных вариантов. Сам механизм ищет правильную комбинацию вариантов, которая должна будет починить/восстановить другой комплекс механизмов. Механизм будто пытается найти способ вылечить меня (о цели механизма знаю из ощущений, он как-будто пониманием сам всё рассказал. Теперь про окружение: кругом темнота, но механизм стоит на твёрдой поверхности (знаю из своих ощущений), за плоскостью или кругом есть источник зелёного цвета, такой как на фото сделанном ирл этой ночью перед сном, но тут свет как-бы выглядывает из под плоскости освещая контуры всего механизма. Назову его пока что Вычислитель. Мне его почему-то жалко. Надо бы его навестить, или даже проапгрейдить. Теперь о его действии: Если пластинка с вариантами неудачная, но из сна выкидывает. Если пластинка неплохая (т.е. значительная часть вариантов подошла), то не выкинет. Продержался максимум 2-3 пластинки. Выкидывало 3-4 раза, но я возвращался. Когда выкидывало просыпался с приступом кашля длительностью 30-60 секунд. [Ирл: выкинуло уже в который раз, перелёг на противоположную сторону на кровати, больше не выкидывало и Вычислитель не встречал.]";
//        note.title = "Жуки F";
//        note.body = "Множество жуков, тысячи! Они появляются неизвестно откуда, преследуют, цепляются за кожу, кусают. Идут за мной куда бы я ни пошел. Я решил найти их источник. Он начинался в моём доме. В итоге они выползали из маленького ящичка, когда я его открыл то увидел там руну (как в дизонорд, но с другими свойствами у другой формы, \"костяной амулет\" лучше бы подошло, но почему-то \"руна\"). Я вспомнил о её негативных эффектах, но всё же взял её (намереваясь выкинуть). Тут произошла НЕХ. Как-будто установилась связь между нами. Она давала вроде прям ощутимый прирост к удаче и подобному, но если бы что-то пошло не так в моей жизни начался пиздец. Решил положить её обратно, жуки вроде перестали появляться и я ушёл.";
        db.notesDao().insert(note);
    }

    public void addLicuidNote(DiaryDatabase db) {
        Notes note;
        note = new Notes();
        note.licuid = 1;
        note.title = "Вычислитель L";
        note.body = "Круг (или колесо) подаёт прямоугольные пластины, крутясь против часовой стрелки. Каждая пластина это совокупность разных вариантов. Сам механизм ищет правильную комбинацию вариантов, которая должна будет починить/восстановить другой комплекс механизмов. Механизм будто пытается найти способ вылечить меня (о цели механизма знаю из ощущений, он как-будто пониманием сам всё рассказал. Теперь про окружение: кругом темнота, но механизм стоит на твёрдой поверхности (знаю из своих ощущений), за плоскостью или кругом есть источник зелёного цвета, такой как на фото сделанном ирл этой ночью перед сном, но тут свет как-бы выглядывает из под плоскости освещая контуры всего механизма. Назову его пока что Вычислитель. Мне его почему-то жалко. Надо бы его навестить, или даже проапгрейдить. Теперь о его действии: Если пластинка с вариантами неудачная, но из сна выкидывает. Если пластинка неплохая (т.е. значительная часть вариантов подошла), то не выкинет. Продержался максимум 2-3 пластинки. Выкидывало 3-4 раза, но я возвращался. Когда выкидывало просыпался с приступом кашля длительностью 30-60 секунд. [Ирл: выкинуло уже в который раз, перелёг на противоположную сторону на кровати, больше не выкидывало и Вычислитель не встречал.]";
//        note.title = "Жуки L";
//        note.body = "Множество жуков, тысячи! Они появляются неизвестно откуда, преследуют, цепляются за кожу, кусают. Идут за мной куда бы я ни пошел. Я решил найти их источник. Он начинался в моём доме. В итоге они выползали из маленького ящичка, когда я его открыл то увидел там руну (как в дизонорд, но с другими свойствами у другой формы, \"костяной амулет\" лучше бы подошло, но почему-то \"руна\"). Я вспомнил о её негативных эффектах, но всё же взял её (намереваясь выкинуть). Тут произошла НЕХ. Как-будто установилась связь между нами. Она давала вроде прям ощутимый прирост к удаче и подобному, но если бы что-то пошло не так в моей жизни начался пиздец. Решил положить её обратно, жуки вроде перестали появляться и я ушёл.";
        db.notesDao().insert(note);
    }

    public void addLFNote(DiaryDatabase db) {
        Notes note;
        note = new Notes();
        note.licuid = 1;
        note.favorite = 1;
        note.title = "Вычислитель LF";
        note.body = "Круг (или колесо) подаёт прямоугольные пластины, крутясь против часовой стрелки. Каждая пластина это совокупность разных вариантов. Сам механизм ищет правильную комбинацию вариантов, которая должна будет починить/восстановить другой комплекс механизмов. Механизм будто пытается найти способ вылечить меня (о цели механизма знаю из ощущений, он как-будто пониманием сам всё рассказал. Теперь про окружение: кругом темнота, но механизм стоит на твёрдой поверхности (знаю из своих ощущений), за плоскостью или кругом есть источник зелёного цвета, такой как на фото сделанном ирл этой ночью перед сном, но тут свет как-бы выглядывает из под плоскости освещая контуры всего механизма. Назову его пока что Вычислитель. Мне его почему-то жалко. Надо бы его навестить, или даже проапгрейдить. Теперь о его действии: Если пластинка с вариантами неудачная, но из сна выкидывает. Если пластинка неплохая (т.е. значительная часть вариантов подошла), то не выкинет. Продержался максимум 2-3 пластинки. Выкидывало 3-4 раза, но я возвращался. Когда выкидывало просыпался с приступом кашля длительностью 30-60 секунд. [Ирл: выкинуло уже в который раз, перелёг на противоположную сторону на кровати, больше не выкидывало и Вычислитель не встречал.]";
//        note.title = "Жуки LF";
//        note.body = "Множество жуков, тысячи! Они появляются неизвестно откуда, преследуют, цепляются за кожу, кусают. Идут за мной куда бы я ни пошел. Я решил найти их источник. Он начинался в моём доме. В итоге они выползали из маленького ящичка, когда я его открыл то увидел там руну (как в дизонорд, но с другими свойствами у другой формы, \"костяной амулет\" лучше бы подошло, но почему-то \"руна\"). Я вспомнил о её негативных эффектах, но всё же взял её (намереваясь выкинуть). Тут произошла НЕХ. Как-будто установилась связь между нами. Она давала вроде прям ощутимый прирост к удаче и подобному, но если бы что-то пошло не так в моей жизни начался пиздец. Решил положить её обратно, жуки вроде перестали появляться и я ушёл.";
        db.notesDao().insert(note);
    }


    public void deleteAllNotes(DiaryDatabase db) {
        List<Notes> notes;
        notes = db.notesDao().getAll();
        for (Notes note : notes) {
            db.notesDao().delete(note);
        }

    }


}
