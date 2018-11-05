package br.ifam.bean;

import br.ifam.dao.GenericoDAO;
import javax.faces.bean.ManagedBean;
import br.ifam.modelo.Local;
import br.ifam.util.IBean;
import java.util.List;

/**
 *
 * @author fernando
 */
@ManagedBean
public class LocalBean implements IBean<Local>{
    
    private long id;
    private String local;
    private String cidade;
    private String uf;
    private List<Local> locais;

    public LocalBean() {
        GenericoDAO<Local> dao = new GenericoDAO<>();
        locais = dao.findAll(Local.class);
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public List<Local> getLocais() {
        return locais;
    }

    public void setLocais(List<Local> locais) {
        this.locais = locais;
    }

    @Override
    public String salva() {
        GenericoDAO<Local> dao = new GenericoDAO<>();
        Local l = new Local(local, cidade, uf);
        dao.save(l);
        return "index.xhtml?faces-redirect=true";
    }

    @Override
    public String excluir(Local ob) {
        GenericoDAO<Local> dao = new GenericoDAO<>();
        dao.remove(Local.class, ob.getId());
        return "index.xhtml?faces-redirect=true";
    }

    @Override
    public String visualiza(Local ob) {
        System.out.println("vacina passada - id: "+ob.getId());
        this.id = ob.getId();
        System.out.println("id local: "+this.id);
        this.local = ob.getNome();
        this.cidade = ob.getCidade();
        this.uf = ob.getUf();
        return "alterar.xhtml";
    }

    @Override
    public String alterar() {
        GenericoDAO<Local> dao = new GenericoDAO<>();
        Local l = new Local(id,local, cidade, uf);
        dao.update(l);
        return "index.xhtml?faces-redirect=true";
    }
    
    
}
