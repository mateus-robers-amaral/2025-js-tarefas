package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Tarefa;
import application.repository.TarefaRepository;

@Controller
@RequestMapping(value = {"/tarefas", "/"})
public class TarefaController {
    @Autowired
    private TarefaRepository tarefaRepo;

    @RequestMapping("/list")
    public String select(Model ui) {
        ui.addAttribute("tarefas", tarefaRepo.findAll());
        return "list";
    }

    @RequestMapping("/insert")
    public String insert() {
        return "formInsert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestParam("descricao") String descricao) {
        Tarefa tarefa = new Tarefa();
        tarefa.setDescricao(descricao);

        tarefaRepo.save(tarefa);

        return "redirect:/tarefas/list";
    }

    @RequestMapping("/update")
    public String update(@RequestParam("id") long id, Model ui) {
        Optional<Tarefa> resultado = tarefaRepo.findById(id);

        if (resultado.isPresent()) {
            ui.addAttribute("tarefa", resultado.get());
            return "formUpdate";
        }

        return "redirect:/tarefas/list";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@RequestParam("id") long id, @RequestParam("descricao") String descricao) {
        Optional<Tarefa> resultado = tarefaRepo.findById(id);

        if (resultado.isPresent()) {
            resultado.get().setDescricao(descricao);

            tarefaRepo.save(resultado.get());
        }

        return "redirect:/tarefas/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("id") long id, Model ui) {
        Optional<Tarefa> resultado = tarefaRepo.findById(id);

        if (resultado.isPresent()) {
            ui.addAttribute("tarefa", resultado.get());
            return "formDelete";
        }

        return "redirect:/tarefas/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") long id) {
        tarefaRepo.deleteById(id);

        return "redirect:/tarefas/list";

    }

}