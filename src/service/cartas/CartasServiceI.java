package service.cartas;

import controller.CartasController;
import model.Cartas;

public interface CartasServiceI {

    public Cartas criar(Cartas novo);

    public CartasController atualizar(Integer id);

    public CartasController buscar(Integer id);

    public void deletar(Integer id);
}
