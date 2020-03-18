package com.fortebank.forteidea.service.idea;

import com.fortebank.forteidea.dto.experience.client.ProcessOwnerDTO;
import com.fortebank.forteidea.dto.experience.client.ProcessWithOwnersDTO;
import com.fortebank.forteidea.entity.idea.Process;
import com.fortebank.forteidea.entity.idea.ProcessOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.fortebank.forteidea.util.AppConstant;

@Service
@Scope(value="prototype", proxyMode= ScopedProxyMode.TARGET_CLASS)
public class ProcessWithOwnerService {
    @Autowired
    private ProcessOwnerService processOwnerService;

    @Autowired
    private ProcessService processService;

    public List<ProcessWithOwnersDTO> getProcessesWithOwners(){
        List<ProcessWithOwnersDTO> processWithOwnersDTOList = new ArrayList<>();
        List<Process> processes = processService.getAllActiveProcesses();
        for (Process process : processes) {
            List<ProcessOwner> processOwnerList = processOwnerService.findAllByProcessId(process.getId());
            System.out.println(processOwnerList);
            List<ProcessOwnerDTO> responsibleTemp = new ArrayList<>();
            List<ProcessOwnerDTO> leanManagersTemp = new ArrayList<>();
            for (ProcessOwner processOwner : processOwnerList) {
                switch (processOwner.getRole()){
                    case AppConstant.PROCESS_OWNER_ROLE_LEAN_MANAGER:
                        leanManagersTemp.add(new ProcessOwnerDTO(processOwner.getId(), processOwner.getUser().getFullname()));
                        break;
                    case AppConstant.PROCESS_OWNER_ROLE_RESPONSIBLE:
                        responsibleTemp.add(new ProcessOwnerDTO(processOwner.getId(), processOwner.getUser().getFullname()));
                        break;
                }
            }
            ProcessWithOwnersDTO processWithOwnersDTO = new ProcessWithOwnersDTO(process.getId(),process.getName(), responsibleTemp, leanManagersTemp);
            processWithOwnersDTOList.add(processWithOwnersDTO);
        }
        return  processWithOwnersDTOList;
    }
}
