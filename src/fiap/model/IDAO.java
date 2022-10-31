package fiap.model;
import java.util.*;
import javax.swing.table.*;

public interface IDAO {
	public String inserir(Object obj);
	public String alterar(Object obj);
	public String excluir(Object obj);
	public ArrayList<String> listarUm(String id);
	public DefaultTableModel listarTudo();
}
