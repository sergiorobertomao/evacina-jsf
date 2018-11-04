package br.ifam.bean;

import br.ifam.dao.GenericoDAO;
import br.ifam.modelo.Vacina;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 * VacinaBean
 * author: hDolz
 */
@ManagedBean
public class VacinaBean {

    private long id;
    private String nome;
    private String descricao;
    private String lote;

    private List<Vacina> vacinas;


    //lista as vacinas ao carregar a página
    public VacinaBean () {
        GenericoDAO<Vacina> dao = new GenericoDAO<>();
        vacinas = dao.findAll(Vacina.class);
    }

    public List<Vacina> getVacinas() {
        return vacinas;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public void setVacinas(List<Vacina> vacinas) {
        this.vacinas = vacinas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    //métodos dó CRUD
    public String salva(){
        GenericoDAO<Vacina> dao = new GenericoDAO<>();
        Vacina vacina = new Vacina(nome,descricao,lote);
        dao.save(vacina);
        return "index.xhtml?faces-redirect=true";
    }
    
    public String excluir(Vacina vacina){
       GenericoDAO dao = new GenericoDAO();
       dao.remove(Vacina.class, vacina.getId());
       return "index.xhtml?faces-redirect=true";
    }
    
    public String visualiza(Vacina vacina){
        System.out.println("vacina passada - id: "+vacina.getId());
        this.id = vacina.getId();
        System.out.println("id local: "+this.id);
        this.nome = vacina.getNome();
        this.descricao = vacina.getDescricao();
        this.lote = vacina.getLote(); 
        return "alterar.xhtml";
    }
    
    public String alterar(){
        GenericoDAO dao = new GenericoDAO();
        Vacina vacina = new Vacina(id,nome,descricao,lote);
        dao.update(vacina);
        return "index.xhtml?faces-redirect=true";
    }
    
    // public String pesquisar(){
    //     GenericoDAO dao = new GenericoDAO();
    //     vacinas.clear();
    //     vacinas = dao.findByNome(Vacina.class, pesquisa, "nome");
    //     return "index.xhtml";
    // }
    
    


}