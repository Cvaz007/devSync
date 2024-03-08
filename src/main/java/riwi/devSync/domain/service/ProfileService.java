package riwi.devSync.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import riwi.devSync.persistence.crud.ProfileCrudRepository;
import riwi.devSync.persistence.entity.Profile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileCrudRepository profileRepository;
    public List<Profile> getAllProfiles(){
        return profileRepository.findAll();
    }

    public Profile getProfileById(Integer id){
        return profileRepository.findById(id).get();
    }

    public void saveProfile(Profile profile){
        profileRepository.save(profile);
    }

    public void deleteProfile(Integer id){
        profileRepository.deleteById(id);
    }
}
