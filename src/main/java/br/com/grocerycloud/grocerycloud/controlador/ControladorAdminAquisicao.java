package br.com.grocerycloud.grocerycloud.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.grocerycloud.grocerycloud.controlador.dto.RequisicaoRegistrarAquisicao;
import br.com.grocerycloud.grocerycloud.negocio.fachada.FachadaGerente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/** 
 * Esta classe representa o controlador de aquisições da gerencia.
 * @author Arthur de Sá Tenório
 * @category Classe de controlador da aplicação
*/

@Controller
@RequestMapping("/admin/aquisicao")
public class ControladorAdminAquisicao {
    @Autowired
    private FachadaGerente fachadaGerente;

    @GetMapping("/")
    public ModelAndView homeAquisicao() {
        ModelAndView mv = new ModelAndView("admin/aquisicao/aquisicao");
        mv.addObject("aquisicoes", fachadaGerente.listarAquisicoes());
        return mv;
    }

    @GetMapping("/registro")
    public String registroAquisicao() {
        return "admin/aquisicao/cadastroAquisicao";
    }
    
    @PostMapping("/registro")
    public String postRegistroAquisicao(RequisicaoRegistrarAquisicao a) {
        fachadaGerente.adicionarAquisicao(a.getCnpjFornecedor(), a.getIdProduto(), 
        a.getQtdeProduto(), a.getCusto(), a.getDataAquisicao());
        return "redirect:/admin/aquisicao/";
    }
}
