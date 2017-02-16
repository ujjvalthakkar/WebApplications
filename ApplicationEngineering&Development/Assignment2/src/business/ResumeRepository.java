/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;
/**
 *
 * @author Ujjval
 */
public class ResumeRepository {
    
    private ArrayList<Resume> resumeRepository;
    
    public ResumeRepository()
    {
        resumeRepository=new ArrayList<>();
    }    
    
    public ArrayList<Resume> getResumeRepository() {
        return resumeRepository;
    }

    public void setResumeRepository(ArrayList<Resume> resumeRepository) {
        this.resumeRepository = resumeRepository;
    }
    
    public Resume addResumes()
    {
        Resume rs=new Resume();
        resumeRepository.add(rs);
        return rs;
    }
    
    public void deleteResumes(Resume rs)
    {
        resumeRepository.remove(rs);
    }
}