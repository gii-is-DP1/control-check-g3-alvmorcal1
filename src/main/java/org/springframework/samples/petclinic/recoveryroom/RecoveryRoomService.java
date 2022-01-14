package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecoveryRoomService {
	
	@Autowired
	RecoveryRoomRepository recoveryRepo;
	
    public List<RecoveryRoom> getAll(){
        return recoveryRepo.findAll();
    }

    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return recoveryRepo.findAllRecoveryRoomTypes();
    }

    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        return recoveryRepo.getRecoveryRoomType(typeName);
    }

    public List<RecoveryRoom> getRecoveryRoomsBiggerThan(double size) {
        return recoveryRepo.findBySizeMoreThan(size);
    }

    public RecoveryRoom save(RecoveryRoom p) {
        return recoveryRepo.save(p);       
    }

    
}
