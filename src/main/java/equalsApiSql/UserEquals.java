package equalsApiSql;

import user.User;

import java.util.List;

public class UserEquals {
    //Метод сравнения для сравнения API & SQL
    public static boolean equalsUsers(List<User> sql, List<User> api){
        boolean result = true;
        for (User sqlobj : sql){
            if (result == true){
            for (User apiobj : sql ){
                if (sqlobj.getId()!=apiobj.getId()){
                    result = false;
                } else if (sqlobj.getId()==apiobj.getId()) {
                    if (sqlobj.getSex()==apiobj.getSex() && sqlobj.getFirstName()==apiobj.getFirstName() &&
                            sqlobj.getSecondName()==apiobj.getSecondName() && sqlobj.getAge()==apiobj.getAge() &&
                            sqlobj.getMoney() == apiobj.getMoney())
                    {
                    result = true;
                    break;
                }
            }
        }


    }

    }
        return result;
}
}
