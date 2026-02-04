package interfaces;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class Entidade {
    public Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
      public void setId(String id) {
        this.id = (id==null||id.isEmpty()||!id.matches("[0-9.]+"))?0
                :Integer.valueOf(id);
    }
      public abstract String getInsert();

    public  abstract void setParameter(PreparedStatement prepareStatement)throws SQLException; 

    public abstract String getupdate();
}
