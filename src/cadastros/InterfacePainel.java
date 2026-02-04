package cadastros;

import dto.InterfaceDTO;
import javax.swing.JPanel;

public abstract class InterfacePainel extends JPanel{
    public abstract InterfaceDTO getDados();
    public abstract void setDados(InterfaceDTO dto);
}
