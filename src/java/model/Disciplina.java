package model;

public class Disciplina {
    private int idDisciplina;
    private String nomeDisciplina;
    private String descricaoDisciplina;

    public Disciplina() {}

    public Disciplina(String nomeDisciplina, String descricaoDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.descricaoDisciplina = descricaoDisciplina;
    }

    public Disciplina(int idDisciplina, String nomeDisciplina, String descricaoDisciplina) {
        this.idDisciplina = idDisciplina;
        this.nomeDisciplina = nomeDisciplina;
        this.descricaoDisciplina = descricaoDisciplina;
    }

    public int getIdDisciplina() { 
        return idDisciplina; 
    }
    
    public void setIdDisciplina(int idDisciplina) { 
        this.idDisciplina = idDisciplina; 
    }

    public String getNomeDisciplina() { 
        return nomeDisciplina; 
    }
    
    public void setNomeDisciplina(String nomeDisciplina) { 
        this.nomeDisciplina = nomeDisciplina; 
    }

    public String getDescricaoDisciplina() { 
        return descricaoDisciplina; 
    }
    
    public void setDescricaoDisciplina(String descricaoDisciplina) { 
        this.descricaoDisciplina = descricaoDisciplina; 
    }
}