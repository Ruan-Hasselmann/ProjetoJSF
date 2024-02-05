package br.com.atos.projetojsf.view.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.atos.projetojsf.core.entity.Tarefa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class TarefaBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private Tarefa tarefa = new Tarefa();
    private List<Tarefa> tarefas = new ArrayList<Tarefa>();

    public void cadastrarTarefa() {
        tarefas.add(new Tarefa(tarefa.getTitulo(), tarefa.getDescricao()));
        tarefa = new Tarefa(); // Limpar os campos após cadastrar
    }

    public void excluirTarefa(Tarefa tarefa) {
        tarefas.remove(tarefa);
        
        // Adicione esta linha para forçar a atualização do componente dataTable
        FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("form:tabelaTarefas");
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }
}
