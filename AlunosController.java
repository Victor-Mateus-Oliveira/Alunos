package br.com.cursomentorama.Cadastro.de.alunos;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/CadastrodeAlunos")
public class AlunosController<nome> {
    private final List<Alunos> alunos;
    public AlunosController() {
        this.alunos = new ArrayList<>();
        Alunos alunos1 = new Alunos(1,"Victor",21);
        Alunos alunos2 = new Alunos(3,"Victória",23);
        Alunos alunos3 = new Alunos(4,"Marcos",22);
        this.alunos.add(alunos1);
        this.alunos.add(alunos2);
        this.alunos.add(alunos3);
    }
    @GetMapping
    public List<Alunos> findAll(@RequestParam(required = false) String aluno) {
        return alunos.stream()
                .filter(aln -> aln.getNomedoAluno().contains(aluno))
                .collect(Collectors.toList());
    }


    @GetMapping("/id/{id}")
    public Alunos buscarporid(@PathVariable("id") Integer id ){
        return this.alunos.stream().filter(aln -> aln.getId().equals(id)).findFirst()
                .orElse(null);

    }


    @PostMapping
    public Integer add(@RequestBody final @NotNull Alunos aluno){
        if(aluno.getId() == 1){
            aluno.setId(aluno.size() + 1);
        }
        alunos.add(aluno);
        return aluno.getId();
    }
    @PutMapping
    public void update(@RequestBody final Alunos aluno){
        alunos.stream().filter(aln -> aln.getId().equals(aluno.getId()))
                .forEach(aln -> aln.setNomedoAluno(aluno.getNomedoAluno()));
    }
    @DeleteMapping("/(id)")
    public void delete(@PathVariable ("id") Integer id){
        alunos.removeIf(aln -> aln.getId().equals(id));

    }
}



