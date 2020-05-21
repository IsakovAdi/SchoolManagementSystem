package OOP.SchoolManagementSystem2;

import java.util.ArrayList;

public class GenID {
    private static ArrayList<Integer> ids = new ArrayList<>();

    /**
     * происходит генерация нового уникального id
     * @return возвращает новую id
     */
    public static int genUniqueId(){
        int id = 0;
        while (true) {
            id = (int)(Math.random()*899)+100;
            if (checkForDuplicates(id)) {
                ids.add(id);
                break;
            }
        }
        return id;
    }

    /**
     * происходит проверка нового id на отсутствие дубликата
     * @param id новое сгенерированное id которую мы проверяем на уникальность
     * @return false если дубликат найден
     * @return true если дубликата нет
     */
    public static boolean checkForDuplicates(int id){
        for (int i:ids) {
            if (i == id){
                return false;
            }
        }
        return true;
    }
}
