package controller;

import dto.InterfaceDTO;
import java.sql.SQLException;

public abstract class InterfaceController {
    public abstract void salvar(InterfaceDTO dto) throws SQLException;
            
}
