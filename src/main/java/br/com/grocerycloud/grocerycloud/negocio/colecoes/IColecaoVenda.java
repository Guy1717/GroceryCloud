package br.com.grocerycloud.grocerycloud.negocio.colecoes;

import java.util.List;

import br.com.grocerycloud.grocerycloud.negocio.entidade.Cliente;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Funcionario;
import br.com.grocerycloud.grocerycloud.negocio.entidade.Venda;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.UsuarioSemVendasException;
import br.com.grocerycloud.grocerycloud.negocio.excecoes.VendaNaoEncontradaException;

/** 
 * Esta classe implementa o contrato de uma venda, estabelecendo 
 * os métodos que devem ser executados pela classe de negocio de venda
 * @author Arthur de Sá Tenório
 * @category Interface de negócio
*/

public interface IColecaoVenda {
    void adicionar(Venda venda);
    List<Venda> listarTodos();
    Venda listarPorId(long id) throws VendaNaoEncontradaException;
    List<Venda> listarPorCliente(Cliente cliente) throws UsuarioSemVendasException;
    List<Venda> listarPorFuncionario(Funcionario funcionario) throws UsuarioSemVendasException;
    //+ metodos de adicionar produtos na venda
}
