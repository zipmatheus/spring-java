package senai.springjava;

import java.util.Optional;

import org.senai.prjjava.entity.Produto;
import org.senai.prjjava.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// http://localhost:8080/api/produto/add?nome=janildo&email=janildo@gmail.com 
//Nesse exemplo são usadas variáveis de parâmetro
@Controller
@RequestMapping(path = "/api/produto")
@CrossOrigin("*")

public class ProdutoController {

    @Autowired
    ProdutoRepository pRepository;

    @PostMapping("/")
    public @ResponseBody Integer addProduto(@RequestBody Produto objP) {
        pRepository.save(objP);
        return objP.getId();
    }

    @GetMapping("/")
    public @ResponseBody Iterable<Produto> buscarProdutos() {
        return pRepository.findAll();
    }

    // http://localhost:8080/api/produto - nesse exemplo é sado uma variável de
    // path(caminho)
    @GetMapping("/{id}")
    public @ResponseBody Optional<Produto> buscarProduto(@PathVariable Integer id) {
        return pRepository.findById(id);

    }

    @PutMapping("/")
    public @ResponseBody Produto atualizar(@RequestBody Produto objP) {
        pRepository.save(objP);
        return objP;
    }

    @DeleteMapping("/{id}")
    public @ResponseBody String apagar(@PathVariable Integer id) {
        pRepository.deleteById(id);
        return "Ok ao apagar!";
    }

}
